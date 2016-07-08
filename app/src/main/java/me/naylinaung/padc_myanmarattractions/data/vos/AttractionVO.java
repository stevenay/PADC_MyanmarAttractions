package me.naylinaung.padc_myanmarattractions.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NayLinAung on 7/7/2016.
 */
public class AttractionVO {

    @SerializedName("title")
    private String mTitle;

    @SerializedName("desc")
    private String mDescription;

    @SerializedName("images")
    private String[] mImages;

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String[] getImages() {
        return mImages;
    }

    public String getFirstImage() {
        if (this.mImages != null && this.mImages.length > 0) {
            return mImages[0];
        } else {
            return null;
        }
    }

    public AttractionVO(String title, String description, String[] imageName) {
        mTitle = title;
        mDescription = description;
        mImages = imageName;
    }

    public static String getImagePath() {
        return "http://www.aungpyaephyo.xyz/myanmar_attractions/";
    }
}
