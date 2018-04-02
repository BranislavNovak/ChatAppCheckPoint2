package com.example.branislavnovak.chatapplication;

import android.graphics.drawable.Drawable;


/**
 * Created by Branislav Novak on 28-Mar-18.
 */

public class Model {
    public String mFirstLetter;
    public String mNameOfContact;
    public Drawable mImage;


    public Model(String firstLetter, String nameOfContact, Drawable image) {
        this.mFirstLetter = firstLetter;
        this.mNameOfContact = nameOfContact;
        this.mImage = image;
    }

    public String getmFirstLetter() {
        return mFirstLetter;
    }

    public String getmNameOfContact() {
        return mNameOfContact;
    }

    public Drawable getmImage() {
        return mImage;
    }

    public void setmFirstLetter(String mFirstLetter) {
        this.mFirstLetter = mFirstLetter;
    }

    public void setmNameOfContact(String mNameOfContact) {
        this.mNameOfContact = mNameOfContact;
    }

    public void setmImage(Drawable mImage) {
        this.mImage = mImage;
    }
}
