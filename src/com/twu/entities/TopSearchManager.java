package com.twu.entities;

import java.util.ArrayList;
import java.util.List;

public class TopSearchManager {
    private List<TopSearch> topSearchList = new ArrayList<>();

    public TopSearchManager() {
    }

    public List<TopSearch> getTopSearchList() {

        return topSearchList;
    }

    public void setTopSearchList(List<TopSearch> topSearchList) {
        this.topSearchList = topSearchList;
    }
}
