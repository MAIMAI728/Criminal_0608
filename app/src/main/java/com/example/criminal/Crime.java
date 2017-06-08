package com.example.criminal;

import java.util.Date;
import java.util.UUID;

/**
 * Created by mai on 2017/06/02.
 */

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private boolean mRequiredPolice;
/* = false;*/

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

//    public void setId(UUID id) {
//        mId = id;
//    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public boolean ismRequiredPolice() {
        return mRequiredPolice;
    }

    public void setmRequiredPolice(boolean requiredPolice) {
        this.mRequiredPolice = requiredPolice;
    }
}

