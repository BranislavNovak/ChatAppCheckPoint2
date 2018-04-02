package com.example.branislavnovak.chatapplication;

/**
 * Created by Branislav Novak on 01-Apr-18.
 */

public class ModelMessage {

    public String mInboxMessage;
    public String mRorS = "R";                                                                      // is message received or sent

    public ModelMessage(String mInboxMessage, String mRors) {
        this.mInboxMessage = mInboxMessage;
        this.mRorS = mRors;
    }

    public String getmInboxMessage() {
        return mInboxMessage;
    }

    public String getmRorS() {
        return mRorS;
    }
}
