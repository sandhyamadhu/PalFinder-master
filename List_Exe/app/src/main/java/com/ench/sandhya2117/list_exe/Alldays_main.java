package com.ench.sandhya2117.list_exe;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by enchanter19 on 13/6/17.
 */

public class Alldays_main implements Parcelable {
//
    String ids;
    String daysofwhat;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getDaysofwhat() {
        return daysofwhat;
    }

    public void setDaysofwhat(String daysofwhat) {
        this.daysofwhat = daysofwhat;
    }

    public static Creator<Alldays_main> getCREATOR() {
        return CREATOR;
    }

    protected Alldays_main(Parcel in) {
        ids = in.readString();
        daysofwhat = in.readString();
    }

    public static final Creator<Alldays_main> CREATOR = new Creator<Alldays_main>() {
        @Override
        public Alldays_main createFromParcel(Parcel in) {
            return new Alldays_main(in);
        }

        @Override
        public Alldays_main[] newArray(int size) {
            return new Alldays_main[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ids);
        dest.writeString(daysofwhat);
    }
}
