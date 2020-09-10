package com.twu.services;

import com.twu.entities.Administrator;
import com.twu.entities.TopSearch;
import com.twu.exceptions.WrongInputException;
import com.twu.repositories.TopSearchRepository;

import java.util.Scanner;

public class AdministratorService {
    public void mainPage(Administrator administrator) {
        System.out.printf("你好,%s,你可以:%n", administrator.getName());
        System.out.println("1.查看热搜排行榜\n2.添加热搜\n3.添加超级热搜\n4.退出");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        switch (input) {
            case "1":
                TopSearchRepository.topSearchManager.displayTopSearch();
                mainPage(administrator);
                break;
            case "2":
                System.out.println("请输入你要添加的热搜内容：");
                String contentToAdd = scanner.next();
                TopSearchRepository.topSearchManager.addTopSearch(new TopSearch(contentToAdd));
                mainPage(administrator);
                break;
            case "3":
                System.out.println("请输入你要添加的超级热搜内容：");
                String contentToAddSuper = scanner.next();
                TopSearchRepository.topSearchManager.addSuperTopSearch(new TopSearch(contentToAddSuper, true));
                mainPage(administrator);
                break;
            case "4":
                break;
            default:
                throw new WrongInputException("选项输入错误");
        }
    }
}
