package org.example.phoneBook.menu;

import org.example.phoneBook.contactService.ContactsService;

import java.util.Scanner;

public class ReadAllMenuAction implements MenuAction {

    private ContactsService contactsService;

    public ReadAllMenuAction(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @Override
    public void doAction(Scanner scan) {
        System.out.println(contactsService.getAll());
    }

    @Override
    public String getName() {
        return "Read phonebook";
    }
}