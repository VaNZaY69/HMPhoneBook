package org.example.phoneBook.contactService;

import org.example.phoneBook.utils.ListUtils;

public class InMemoryContactsService implements ContactsService {

    private ContactList contactList = new ContactList();

    @Override
    public ContactList getAll() {
        return contactList;
    }

    @Override
    public void remove(int index) {

        if (contactList.size() == 0) {
            System.out.println("Phonebook is empty");
        } else if (index < 0 || index >= contactList.size()) {
            System.out.println("Incorrect input");
        } else {
            contactList.remove(index);
        }
    }

    @Override
    public void add(Contact contact) {
        contactList.add(contact);
    }

    @Override
    public void save() {

    }

    @Override
    public ContactList load() {
        return null;
    }

    @Override
    public ContactList findByName(String name) {
        return ListUtils.filter(contactList, contact -> contact.getName().contains(name));
    }
}