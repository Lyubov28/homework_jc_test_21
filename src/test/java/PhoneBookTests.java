import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PhoneBookTests {
    PhoneBook sut;

    @BeforeEach
    public void init() {
        sut = new PhoneBook();
    }

    @Test // Тест №1
    public void testAddGroup() {
        String group = "focusGroup";
        PhoneBook expected = new PhoneBook();
        expected.phoneBook.put(group, new ArrayList<>());

        sut.addGroup(group);

        Assertions.assertEquals(expected.phoneBook, sut.phoneBook);
    }

    @Test // Тест №2
    public void testAddContactToGroup_ContactExists() {
        String group = "focusGroup";
        Contact contact = new Contact("8-888-888-88-88", "Лена");
        List<Contact> list = new ArrayList<>();
        list.add(contact);
        PhoneBook expected = new PhoneBook();
        expected.phoneBook.put(group, new ArrayList<>(list));

        sut.addGroup(group);
        sut.addContactToGroup(contact, group);
        sut.addContactToGroup(contact, group);//Попытка добавления уже существующего контакта

        Assertions.assertEquals(expected.phoneBook, sut.phoneBook);
    }



    @Test //Тест №3
    public void testFindContactByNumber_isNot() {
        String group = "focusGroup";
        String phoneNumber = "8-888-888-88-88";
        String name = "Лена";
        String phoneNumberTest = "8-444-444-44-44";
        Contact contact = new Contact(phoneNumber, name);
        sut.addGroup(group);
        sut.addContactToGroup(contact, group);
        String expected = "Контакт по номеру " + phoneNumberTest + " не найден";

        String result = sut.findContactByNumber(phoneNumberTest);

        Assertions.assertEquals(expected, result);
    }
}