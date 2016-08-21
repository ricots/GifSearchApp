package com.roberterrera.gifsearch.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.roberterrera.gifsearch.R;

import java.io.File;

public class DetailActivity extends AppCompatActivity {

    String originalImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView gifOriginal = (ImageView) findViewById(R.id.imageView_gif_fullsize);

        originalImage = getIntent().getStringExtra("original");

        Glide.with(this)
                .load(originalImage)
                .asGif()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.drawable.ic_burst_mode)
                .into(gifOriginal);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks.
        switch (item.getItemId()) {
            case R.id.action_share:
                shareChooser();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void shareChooser() {
        // specify our test image location
        Uri url = Uri.parse(originalImage);

        // set up an intent to share the image
        Intent share_intent = new Intent();
        share_intent.setAction(Intent.ACTION_SEND);
        share_intent.setType("image/gif");
        share_intent.putExtra(Intent.EXTRA_STREAM,
                Uri.fromFile(new File(url.toString())));
        share_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        share_intent.putExtra(Intent.EXTRA_SUBJECT,
                "Share this gif");

        // start the intent
        try {
            startActivity(Intent.createChooser(share_intent,
                    "Sharing gif"));
        } catch (android.content.ActivityNotFoundException ex) {
            (new AlertDialog.Builder(DetailActivity.this)
                    .setMessage("Share failed")
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int whichButton) {
                                }
                            }).create()).show();
        }
    }
}
