package org.example.phoneBook.menu;

import java.util.Scanner;

public interface MenuAction {

    void doAction(Scanner sc);

    String getName();

}