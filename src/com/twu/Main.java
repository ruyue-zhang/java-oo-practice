package com.twu;

import com.twu.services.TopSearchService;

public class Main {
    private static TopSearchService topSearchService = new TopSearchService();

    public static void main(String[] args) {
        topSearchService.welcomePage();
    }
}
