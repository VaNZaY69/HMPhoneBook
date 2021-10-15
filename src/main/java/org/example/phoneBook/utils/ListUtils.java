package org.example.phoneBook.utils;

import org.example.phoneBook.contactService.Contact;
import org.example.phoneBook.contactService.ContactList;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListUtils {

    public static void forEach(ContactList contactList, Consumer<Contact> elemProcessor) {
        for (int i = 0; i < contactList.size(); i++) {
            elemProcessor.accept(contactList.get(i));
        }
    }

    public static ContactList filter(ContactList contactList, Predicate<Contact> predicate) {
        ContactList filteredList = new ContactList();
        for (int i = 0; i < contactList.size(); i++) {
            if (predicate.test(contactList.get(i))) {
                filteredList.add(contactList.get(i));
            }
        }
        return filteredList;
    }

    public static <R> R reduce(ContactList contactList, R initValue, BiFunction<R, Contact, R> biFunction) {

        for (int i = 0; i < contactList.size(); i++) {
            initValue = biFunction.apply(initValue, contactList.get(i));
        }
        return initValue;
    }

    public static ContactList map(ContactList contactList, Function<Contact, Contact> function) {
        ContactList result = new ContactList();
        for (int i = 0; i < contactList.size(); i++) {
            result.add(function.apply(contactList.get(i)));
        }
        return result;
    }

    public static boolean anyMatch(ContactList contactList, Predicate<Contact> predicate) {
        for (int i = 0; i < contactList.size(); i++) {
            if (predicate.test(contactList.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean allMatch(ContactList contactList, Predicate<Contact> predicate) {
        for (int i = 0; i < contactList.size(); i++) {
            if (!predicate.test(contactList.get(i))) {
                return false;
            }
        }
        return true;
    }
}