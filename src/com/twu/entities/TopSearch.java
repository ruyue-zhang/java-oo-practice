package com.twu.entities;

public class TopSearch {
    private String content;
    private int voteCount;
    private int price;
    private int rank;
    private boolean buyTopSearch;
    private boolean isSuperTopSearch;

    public TopSearch(String content) {
        this.content = content;
        this.voteCount = 0;
        this.price = 0;
        this.buyTopSearch = false;
        this.isSuperTopSearch = false;
    }

    public TopSearch(String content, boolean isSuperTopSearch) {
        this.content = content;
        this.isSuperTopSearch = isSuperTopSearch;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean isBuyTopSearch() {
        return buyTopSearch;
    }

    public void setBuyTopSearch(boolean buyTopSearch) {
        this.buyTopSearch = buyTopSearch;
    }

    public boolean isSuperTopSearch() {
        return isSuperTopSearch;
    }

    public void setSuperTopSearch(boolean superTopSearch) {
        isSuperTopSearch = superTopSearch;
    }

    @Override
    public String toString() {
        return content + " " + voteCount;
    }
}
