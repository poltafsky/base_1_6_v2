package com.gb.base_1_6_v2;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable  {
    private int Index;
    private String name;

    public Note(int i) {
        Index = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public static Creator<Note> getCREATOR() {
        return CREATOR;
    }

    protected Note(Parcel in) {
        Index = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(Index);
    }
}
