package com.twu.entities;

public class TopSearch {
    private String content;
    private int voteCount;
    private int price;
    private boolean buyHotSearch;
    private boolean isSuperHotSearch;

    public TopSearch(String content) {
        this.content = content;
        this.voteCount = 0;
        this.price = 0;
        this.buyHotSearch = false;
        this.isSuperHotSearch = false;
    }

    public TopSearch(String content, boolean isSuperHotSearch) {
        this.content = content;
        this.isSuperHotSearch = isSuperHotSearch;
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

    public boolean isBuyHotSearch() {
        return buyHotSearch;
    }

    public void setBuyHotSearch(boolean buyHotSearch) {
        this.buyHotSearch = buyHotSearch;
    }

    public boolean isSuperHotSearch() {
        return isSuperHotSearch;
    }

    public void setSuperHotSearch(boolean superHotSearch) {
        isSuperHotSearch = superHotSearch;
    }

    @Override
    public String toString() {
        return content + " " + voteCount;
    }
}
