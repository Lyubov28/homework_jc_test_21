public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        // Создание групп
        phoneBook.addGroup("Друзья");
        phoneBook.addGroup("Работа");
        phoneBook.addGroup("Курс");

        // Добавление контактов в группы
        phoneBook.addContactToGroup(new Contact("8-905-203-10-10", "Лена"), "Друзья");
        phoneBook.addContactToGroup(new Contact("8-917-305-89-11", "Коля"), "Друзья");

        // Поиск контакта по номеру
        System.out.println(phoneBook.findContactByNumber("8-905-203-10-10"));
        System.out.println(phoneBook.findContactByNumber("8-945-206-45-87"));
        System.out.println();
        System.out.println(phoneBook.orderGroup());

    }
}
