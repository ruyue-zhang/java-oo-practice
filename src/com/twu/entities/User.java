package com.twu.entities;

public class User {
    private String userName;
    private int voteNumber;

    public User(String userName) {
        this.userName = userName;
        this.voteNumber = 10;
    }

    public String getUserName() {
        return userName;
    }

    public int getVoteNumber() {
        return voteNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setVoteNumber(int voteNumber) {
        this.voteNumber = voteNumber;
    }
}
