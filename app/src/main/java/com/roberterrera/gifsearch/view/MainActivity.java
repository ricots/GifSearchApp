package com.roberterrera.gifsearch.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.roberterrera.gifsearch.R;
import com.roberterrera.gifsearch.databinding.ActivityMainBinding;
import com.roberterrera.gifsearch.model.TrendingAdapter;
import com.roberterrera.gifsearch.model.trending.Images;
import com.roberterrera.gifsearch.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    MainViewModel mMainViewModel;
    List<Images> trendingListImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainViewModel = new MainViewModel(this);
        mBinding.setViewModel(mMainViewModel);

        setupRecyclerView(mBinding.recyclerviewTrending);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainViewModel.destroy();
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        TrendingAdapter adapter = new TrendingAdapter(trendingListImages);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
    }
}

