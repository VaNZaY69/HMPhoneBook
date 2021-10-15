package org.example.phoneBook.menu;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.phoneBook.contactService.*;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public Menu(List<MenuAction> actions) {
        this.actions = actions;
    }

    private Scanner scanner = new Scanner(System.in);
    private List<MenuAction> actions;

    private void printActions() {
        for (int i = 0; i < actions.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, actions.get(i).getName());
        }
        System.out.printf("%d - exit\n", actions.size() + 1);
    }

    private int getChoice() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice - 1;
    }

    public void run() {
        while (true) {
            printActions();
            int choice = getChoice();
            if (choice < 0 || choice > actions.size()) {
                System.out.println("Incorrect choice");
                continue;
            }
            if (choice == actions.size()) {
                break;
            }
            actions.get(choice).doAction(scanner);
        }
    }

    public ContactsService chooseType() {
        System.out.print("Which method of serialization you would like to use ? ");
        System.out.println("Type number of method to choose : ");
        System.out.println("1 - Keep data in memory;\n" +
                "2 - Keep data in CSV file;\n" +
                "3 - Keep data in object file;\n" +
                "4 - Keep data in XML file;\n" +
                "5 - Keep data in JSON file;");
        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    return new InMemoryContactsService();
                case 2:
                    return new CSVSerializationContactsService();
                case 3:
                    return new ByteSerializationContactsService();
                case 4:
                    return new JSonXmlSerializationContactService(new XmlMapper(), "Contacts.xml");
                case 5:
                    return new JSonXmlSerializationContactService(new JsonMapper(), "Contacts.json");
                default:
                    break;
            }
        }
    }

    public void addAction(MenuAction action) {
        actions.add(action);
    }
}