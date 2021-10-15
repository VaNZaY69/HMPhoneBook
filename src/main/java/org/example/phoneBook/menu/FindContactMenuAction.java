package org.example.phoneBook.menu;

import org.example.phoneBook.contactService.ContactList;
import org.example.phoneBook.contactService.ContactsService;

import java.util.Scanner;

public class FindContactMenuAction implements MenuAction {

    private ContactsService contactsService;

    public FindContactMenuAction(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @Override
    public void doAction(Scanner scan) {
        System.out.print("Please enter contact name or part of the name: ");
        String name = scan.nextLine();
        ContactList found = contactsService.findByName(name);
        if (found != null && !found.toString().contains("Phonebook is empty")) {
            System.out.println(found);
        } else {
            System.out.println("There is no such contact");
        }
    }

    @Override
    public String getName() {
        return "Find by name";
    }
}