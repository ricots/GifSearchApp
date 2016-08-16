
package com.roberterrera.gifsearch.model.trending;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class User {

    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    @SerializedName("banner_url")
    @Expose
    private String bannerUrl;
    @SerializedName("profile_url")
    @Expose
    private String profileUrl;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("twitter")
    @Expose
    private String twitter;

    /**
     * 
     * @return
     *     The avatarUrl
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 
     * @param avatarUrl
     *     The avatar_url
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * 
     * @return
     *     The bannerUrl
     */
    public String getBannerUrl() {
        return bannerUrl;
    }

    /**
     * 
     * @param bannerUrl
     *     The banner_url
     */
    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    /**
     * 
     * @return
     *     The profileUrl
     */
    public String getProfileUrl() {
        return profileUrl;
    }

    /**
     * 
     * @param profileUrl
     *     The profile_url
     */
    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    /**
     * 
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     * @param displayName
     *     The display_name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 
     * @return
     *     The twitter
     */
    public String getTwitter() {
        return twitter;
    }

    /**
     * 
     * @param twitter
     *     The twitter
     */
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

}
