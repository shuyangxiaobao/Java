package com.xiaobao.domain;

public class MyAccount {
    private int id;
    private String myname;
    private float mymoney;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMyname() {
        return myname;
    }

    public void setMyname(String myname) {
        this.myname = myname;
    }

    public float getMymoney() {
        return mymoney;
    }

    public void setMymoney(float mymoney) {
        this.mymoney = mymoney;
    }

    @Override
    public String toString() {
        return "MyAccount{" +
                "id=" + id +
                ", myname='" + myname + '\'' +
                ", mymoney=" + mymoney +
                '}';
    }
}
