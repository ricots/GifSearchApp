
package com.roberterrera.gifsearch.model.giphyapi.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.roberterrera.gifsearch.model.giphyapi.Datum;
import com.roberterrera.gifsearch.model.giphyapi.Meta;
import com.roberterrera.gifsearch.model.giphyapi.Pagination;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SearchResponse {

    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<>();
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    /**
     * 
     * @return
     *     The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }

    /**
     * 
     * @return
     *     The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * 
     * @param meta
     *     The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     * 
     * @return
     *     The pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * 
     * @param pagination
     *     The pagination
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
