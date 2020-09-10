package com.twu.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
