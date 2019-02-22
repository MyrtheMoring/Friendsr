package com.example.friendsr;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* This class stores the details of the Friend objects, which include: name, bio, id and rating.
Implements both Serializable and Parcelable to pass between intents and store in Bundle. */
public class Friend implements Serializable, Parcelable {
    private String name, bio;
    private int drawableId;
    private float rating;

    /* Constructor to create new Friend object. */
    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    /* The get and set functions for the details. */
    public String getName() {
        return name;
    }
    public String getBio() {
        return bio;
    }
    public int getDrawableId() {
        return drawableId;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }

    /* Function that creates a Parcel. */
    public static final Parcelable.Creator<Friend> CREATOR = new Parcelable.Creator<Friend>() {
        @Override
        public Friend createFromParcel(Parcel in) {
            return new Friend(in);
        }

        @Override
        public Friend[] newArray(int size) {
            return new Friend[size];
        }
    };

    /* Function in order to restore the Friend instance from the Parcel. */
    protected Friend(Parcel in) {
        name = in.readString();
        bio = in.readString();
        drawableId = in.readInt();
        rating = in.readFloat();
    }

    /* Function required for the Parcel. */
    @Override
    public int describeContents() {
        return 0;
    }

    /* Function in order to write the Friend details to the Parcel. */
    @Override
    public void writeToParcel(Parcel p, int flags) {
        p.writeString(name);
        p.writeString(bio);
        p.writeInt(drawableId);
        p.writeFloat(rating);
    }
}

