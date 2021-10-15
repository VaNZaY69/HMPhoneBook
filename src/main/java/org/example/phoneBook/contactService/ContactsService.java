package org.example.phoneBook.contactService;

public interface ContactsService {

    ContactList getAll();

    void remove(int index);

    void add(Contact contact);

    void save();

    public ContactList findByName(String name);

    ContactList load();
}