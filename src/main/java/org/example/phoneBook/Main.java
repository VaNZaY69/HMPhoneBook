package org.example.phoneBook;

import org.example.phoneBook.contactService.ContactsService;
import org.example.phoneBook.menu.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<MenuAction> actions = new ArrayList<>();
        Menu menu = new Menu(actions);
        ContactsService memory = menu.chooseType();
        actions.add(new ReadAllMenuAction(memory));
        actions.add(new AddContactMenuAction(memory));
        actions.add(new RemoveContactMenuAction(memory));
        actions.add(new FindContactMenuAction(memory));
        menu.run();
    }
}
