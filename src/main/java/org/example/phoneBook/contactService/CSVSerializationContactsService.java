package org.example.phoneBook.contactService;

import java.io.*;
import java.util.stream.Collectors;

public class CSVSerializationContactsService extends SerializationHelperAbstractClass {

    @Override
    public void save() {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("Contacts.csv"))) {
            for (int i = 0; i < cache.size(); i++) {
                fileWriter.write(cache.get(i).getName() + "," + cache.get(i).getPhone() + "\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ContactList load() {
        checkForFileExisting("Contacts.csv");
        if (cache == null) {
            try (FileReader fileReader = new FileReader("Contacts.csv")) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                cache = new ContactList(bufferedReader.lines().map(l -> l.split(",")).map(a -> new Contact(a[0], a[1])).collect(Collectors.toList()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cache;
    }
}