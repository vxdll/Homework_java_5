// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

import java.io.IOException;
import java.util.*;


public class PhoneBook {
    public static Map<String, List<String>> phoneBook = new HashMap<String, List<String>>();
    public static void main(String[] args){
        Scanner scanPB = new Scanner ((System.in));
        System.out.println("Выберите действие: \n" +
                "addPhoneBook - добавить запись\n" +
                "deletePb - удалить запись по имени\n" +
                "printPhoneBook - вывести БД\n" +
                "exit - выйти");

        while (true) {
            System.out.print("Ввод: ");
            String act = scanPB.nextLine();
            if (act.equals("addPB")) {
                System.out.println("Введите имя: ");
                String name = scanPB.nextLine();
                System.out.println("Введите телефон: ");
                String phoneNumber = scanPB.nextLine();
                addPhoneBook(name, phoneNumber);
            } else if (act.equals("delPB")) {
                System.out.println("Введите имя: ");
                String name = scanPB.nextLine();
                deletePB(name);
            } else if (act.equals("printPB")) {
                printPhonebook();
            } else if (act.equals("exit")) {
                break;
            }
        }
    }


    // Добавить номер и имя абонента
    private static void addPhoneBook(String name, String phoneNumber) {
        List<String> values = new ArrayList<String>();
        if (phoneBook.containsKey(name)){
            values.add(phoneNumber);
            phoneBook.put(name,values);
        } else {
            phoneBook.put(name, Collections.singletonList(phoneNumber));
        }
    }

    // Удалить запись по номеру
    private static void deletePB(String phoneNumber) {
        phoneBook.remove(phoneNumber);
    }

    // Вывод БД
    public static void printPhonebook() {
        System.out.println("Телефонный справочник: ");
            for (Map.Entry<String, List<String>> k : phoneBook.entrySet()) {
                String key = k.getKey();
                String value = k.getValue().toString();
                System.out.println(key + " : " + value);
        }
    }
}

