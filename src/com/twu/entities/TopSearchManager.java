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
        List<TopSearch> list = this.topSearchList.stream().sorted(Comparator.comparingInt(TopSearch::getVoteCount)).collect(Collectors.toList());
        List<TopSearch> newSortTopSearch = new ArrayList<>();
        for (TopSearch topSearch : list) {
            if(topSearch.isBuyTopSearch()) {
                newSortTopSearch.add(topSearch);
            }
        }
        for (TopSearch sortTopSearch : newSortTopSearch) {
            list = sortByRank(list, sortTopSearch);
        }
        this.topSearchList = list;
        return list;
    }

    public List<TopSearch> sortByRank(List<TopSearch> list, TopSearch sortTopSearch) {
        List<TopSearch> newList;
        newList = new ArrayList<>(list.subList(0, sortTopSearch.getRank() - 1));
        newList.add(sortTopSearch);
        newList.addAll(list.subList(sortTopSearch.getRank() - 1, list.size()));
        newList.remove(newList.lastIndexOf(sortTopSearch));
        return newList;
    }

    public void setTopSearchList(List<TopSearch> topSearchList) {
        this.topSearchList = topSearchList;
    }
}
