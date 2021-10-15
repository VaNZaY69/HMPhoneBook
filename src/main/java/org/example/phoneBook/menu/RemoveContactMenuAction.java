package org.example.phoneBook.menu;

import org.example.phoneBook.contactService.ContactsService;

import java.util.Scanner;

public class RemoveContactMenuAction implements MenuAction {

    private ContactsService contactsService;

    public RemoveContactMenuAction(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @Override
    public void doAction(Scanner scan) {
        System.out.print("Please enter index of contact which you want to delete: ");
        int index = scan.nextInt() - 1;
        scan.nextLine();
        contactsService.remove(index);
    }

    @Override
    public String getName() {
        return "Remove existing contact";
    }
}