package org.example.phoneBook.contactService;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

import java.io.*;

@AllArgsConstructor
public class JSonXmlSerializationContactService extends SerializationHelperAbstractClass {

    ObjectMapper objectMapper;
    String fileName;

    @Override
    public void save() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), cache);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ContactList load() {
        checkForFileExisting(fileName);
        if (cache == null) {
            try {
                cache = objectMapper.readValue(new File(fileName), ContactList.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cache;
    }
}