package com.example.aishwarya.miwok;

/**
 * Created by Aishwarya on 12/9/2016.
 */

public class Word {

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    /** Images */
    private int mResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;


    /** Audio */
    private int mediaResource;


    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     *
     */

    public Word(String defaultTranslation, String miwokTranslation, int media) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mediaResource = media;
    }

    /**
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     *
     * @param miwokTranslation is the word in the Miwok language
     *
     * @param resourceId stores the resource_id for the images in the drawable folder
     *
     */

    public Word(String defaultTranslation, String miwokTranslation, int resourceId, int media){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mResourceId = resourceId;
        mediaResource = media;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }


    /**
     * Get Images.
     */
    public int getResourceId(){return  mResourceId;}

    public int getMediaFile(){return  mediaResource; }

    public boolean hasImage(){
        return mResourceId != NO_IMAGE_PROVIDED;
    }

}