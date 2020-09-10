package com.twu.services;

import com.twu.entities.Administrator;
import com.twu.entities.User;
import com.twu.exceptions.WrongInputException;

import java.util.Scanner;

public class TopSearchService {
    private UserService userService = new UserService();
    private AdministratorService administratorService = new AdministratorService();

    public void welcomePage() {
        while(true) {
            try {
                System.out.println("欢迎来到热搜排行榜，你是?\n1.用户\n2.管理员\n3.退出");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.next();
                switch (input) {
                    case "1":
                        System.out.println("请输入你的昵称:");
                        User user = new User(scanner.next());
                        userService.mainPage(user);
                        break;
                    case "2":
                        System.out.println("请输入你的昵称:");
                        String name = scanner.next();
                        System.out.println("请输入你的密码:");
                        String passWord = scanner.next();
                        Administrator administrator = new Administrator();
                        if (name.equals(administrator.getName()) && passWord.equals(administrator.getPassWord())) {
                            administratorService.mainPage(administrator);
                        } else {
                            System.out.println("密码输入错误");
                            welcomePage();
                        }
                        break;
                    case "3":
                        System.out.println("系统已退出");
                        welcomePage();
                        break;
                    default:
                        throw new WrongInputException("选项输入错误");
                }
            } catch (WrongInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
