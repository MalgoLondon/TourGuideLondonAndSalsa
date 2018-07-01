package com.example.android.tourguidelondonandsalsa;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by malgo on 18/07/2018.
 */


public class Items implements Parcelable{

    //**we need 2 fields for the state of the word object:*/
    private String mName;
    private String mAddress;
    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED;

    static {
        NO_IMAGE_PROVIDED = -1;
    }

    /**
     * Image resource ID for the word
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    //**then we need to create a constructor (create an object) which takes in 2 parameters: mName, mAddress
    // The name of the constructor needs to match exactly the name of the class
    // it needs to be public (access variable) so outside classes can access it
    // this is a setter method*/
    public Items(String name, String address) {
        mName=name;
        mAddress =address;

    }

    //**then we need to create a constructor (create an object) which takes in 3 parameters: mName, mAddress, mImageResourceId
    // The name of the constructor needs to match exactly the name of the class
    // it needs to be public (access variable) so outside classes can access it
    // this is a setter method*/
    public Items(String name, String address, int imageResourceId) {
        mName=name;
        mAddress =address;
        mImageResourceId=imageResourceId;

    }

    protected Items(Parcel in) {
        mName = in.readString();
        mAddress = in.readString();
        mImageResourceId = in.readInt();
    }

    public static final Creator<Items> CREATOR = new Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel in) {
            return new Items(in);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };

    //**adding 2 methods with purpose to return the translations
    // this is a getter method*/
    public String getName() {
        return mName;
    }

    public String getAddress() {
        return mAddress;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mAddress);
        dest.writeInt(mImageResourceId);
    }
}
