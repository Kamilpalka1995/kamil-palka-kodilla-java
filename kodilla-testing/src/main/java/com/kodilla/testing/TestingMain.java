package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;


public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();
        if (calculator.add(5, 4) == 9) {
            System.out.println("Test add is ok");
        } else {
            System.out.println("Test is not ok");
        }
        if (calculator.substract(5, 4) == 1) {
            System.out.println("Test substract is ok");
        } else {
            System.out.println("Test substract is not ok");
        }
    }
}