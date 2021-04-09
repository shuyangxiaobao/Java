package com.xiaobao.domain;

import java.util.Date;

public class AccountUser extends Account {
    private String myId;
    private String myUsername;
    private Date myBirthday;
    private String mySex;
    private String myAddress;

    @Override
    public String toString() {
        return super.toString () + "AccountUser{" +
                "myId='" + myId + '\'' +
                ", myUsername='" + myUsername + '\'' +
                ", myBirthday=" + myBirthday +
                ", mySex='" + mySex + '\'' +
                ", myAddress='" + myAddress + '\'' +
                '}';
    }

    public String getMyId() {
        return myId;
    }

    public void setMyId(String myId) {
        this.myId = myId;
    }

    public String getMyUsername() {
        return myUsername;
    }

    public void setMyUsername(String myUsername) {
        this.myUsername = myUsername;
    }

    public Date getMyBirthday() {
        return myBirthday;
    }

    public void setMyBirthday(Date myBirthday) {
        this.myBirthday = myBirthday;
    }

    public String getMySex() {
        return mySex;
    }

    public void setMySex(String mySex) {
        this.mySex = mySex;
    }

    public String getMyAddress() {
        return myAddress;
    }

    public void setMyAddress(String myAddress) {
        this.myAddress = myAddress;
    }
}
