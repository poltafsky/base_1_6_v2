package com.gb.base_1_6_v2;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable  {
    private int Index;
    private String name;
    private String description;
    private int DateOfCreation;

    public Note(String name, int Index) {
        this.name = name;
        this.Index = Index;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    protected Note(Parcel in) {
        name = in.readString();
        description = in.readString();
        DateOfCreation = in.readInt();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDateOfCreation() {
        return DateOfCreation;
    }

    public void setDateOfCreation(int dateOfCreation) {
        DateOfCreation = dateOfCreation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeInt(DateOfCreation);
    }
}
