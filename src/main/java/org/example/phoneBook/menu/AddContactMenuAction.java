package org.example.phoneBook.menu;

import org.example.phoneBook.contactService.Contact;
import org.example.phoneBook.contactService.ContactsService;

import java.util.Scanner;

public class AddContactMenuAction implements MenuAction {

    private ContactsService contactsService;

    public AddContactMenuAction(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @Override
    public void doAction(Scanner scan) {
        System.out.print("Enter contact name:  ");
        String name = scan.nextLine();
        System.out.print("Enter contact phone number: ");
        String phone = scan.nextLine();
        Contact newContact = new Contact(name, phone);
        contactsService.add(newContact);

    }

    @Override
    public String getName() {
        return "Add new contact";
    }
}