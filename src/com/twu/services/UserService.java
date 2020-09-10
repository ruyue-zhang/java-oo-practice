package com.twu.services;

import com.twu.entities.TopSearch;
import com.twu.entities.User;
import com.twu.exceptions.VoteFailException;
import com.twu.exceptions.WrongInputException;
import com.twu.repositories.TopSearchRepository;

import java.util.Scanner;

public class UserService {
    public void mainPage(User user) {
        System.out.printf("你好,%s,你可以:%n", user.getUserName());
        System.out.println("1.查看热搜排行榜\n2.给热搜事件投票\n3.购买热搜\n4.添加热搜\n5.退出");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        switch (input) {
            case "1":
                TopSearchRepository.topSearchManager.displayTopSearch();
                mainPage(user);
                break;
            case "2":
                try {
                    System.out.println("请输入你要投票的热搜名称:");
                    String contentToVote = scanner.next();
                    System.out.printf("请输入你要投票的热搜票数：(你目前还有：%s票)%n", user.getVoteNumber());
                    int voteCount = scanner.nextInt();
                    TopSearchRepository.topSearchManager.voteTopSearch(user, contentToVote, voteCount);
                } catch (VoteFailException e) {
                    System.out.println(e.getMessage());
                }
                mainPage(user);
                break;
//            case "3":
//                System.out.println("请输入你要购买的热搜名称:");
//                String contentToBuy = scanner.next();
//                System.out.println("请输入你要购买的热搜名次:");
//                int ranking = scanner.nextInt();
//                System.out.println("请输入你要购买的热搜金额");
//                int price = scanner.nextInt();
//                TopSearchRepository.topSearchManager.buyTopSearch(contentToBuy, ranking, price);
//                mainPage(user);
//                break;
            case "4":
                System.out.println("请输入你要添加的热搜内容：");
                String contentToAdd = scanner.next();
                TopSearchRepository.topSearchManager.addTopSearch(new TopSearch(contentToAdd));
                mainPage(user);
                break;
            case "5":
                System.out.println("你已退出！");
                break;
            default:
                throw new WrongInputException("选项输入错误");
        }
    }
}
