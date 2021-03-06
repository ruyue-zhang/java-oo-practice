package com.twu.entities;

import com.twu.exceptions.VoteFailException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TopSearchManager {
    private List<TopSearch> topSearchList = new ArrayList<>();

    public TopSearchManager() {
    }

    public List<TopSearch> getTopSearchList() {
        List<TopSearch> list = this.topSearchList.stream().sorted((h1, h2) -> h2.getVoteCount() - h1.getVoteCount()).collect(Collectors.toList());
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

    public void displayTopSearch() {
        List<TopSearch> topSearchList = getTopSearchList();
        topSearchList.forEach(i -> System.out.println(topSearchList.indexOf(i) + 1 + " " + i));
    }

    public void addTopSearch(TopSearch topSearch) {
        this.topSearchList.add(topSearch);
    }

    public void addSuperTopSearch(TopSearch topSearch) {
        this.topSearchList.add(topSearch);
    }

    public void voteTopSearch(User user, String content, int vote) {
        if (vote > user.getVoteNumber()) {
            throw new VoteFailException("投票失败：剩余票数不足");
        } else {
            boolean isTopSearchExist = false;
            for (TopSearch topSearch : topSearchList) {
                if(topSearch.getContent().equals(content)) {
                    int voteCount = vote;
                    if (topSearch.isSuperTopSearch()) {
                        voteCount = vote * 2;
                    }
                    user.setVoteNumber(user.getVoteNumber() - vote);
                    topSearch.setVoteCount(voteCount + topSearch.getVoteCount());
                    isTopSearchExist = true;
                    System.out.println("投票成功！");
                    break;
                }
            }
            if (!isTopSearchExist) {
                throw new VoteFailException("投票失败：热搜不存在");
            }
        }
    }

    public void buyTopSearch(String content, int ranking, int price) {
        boolean canBuyIt = false;
        List<TopSearch> hotSearchList = getTopSearchList();
        for (TopSearch topSearch : topSearchList) {
            if (topSearch.getContent().equals(content) && price > hotSearchList.get(ranking - 1).getPrice()) {
                canBuyIt = true;
                topSearch.setBuyTopSearch(true);
                topSearch.setRank(ranking);
                topSearch.setPrice(price);
                if (topSearchList.get(ranking - 1).isBuyTopSearch()) {
                    topSearchList.remove(ranking - 1);
                }
            }
        }
        System.out.println(canBuyIt ? "购买成功" : "购买失败");
    }
}
