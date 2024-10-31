package ua.com.javarush.gnew.m2.cli;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import ua.com.javarush.gnew.m2.dto.ContactDto;
import ua.com.javarush.gnew.m2.entity.Contact;
import ua.com.javarush.gnew.m2.service.PhoneBookInterface;
import ua.com.javarush.gnew.m2.utils.Utils;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.Callable;

@Command(name = "phonebook", mixinStandardHelpOptions = true, version = "PhoneBook CLI 1.0",
        description = "CLI для управління контактами в телефонній книзі")
public class PhoneBookCLI implements Callable<Integer> {

    @Override
    public Integer call() {
        System.out.println("Використовуйте одну з команд: user, add, search, edit, delete, list");
        return 0;
    }

    @Command(name = "add", aliases = {"-a","--add"}, description = "Додає новий контакт до телефонної книги", mixinStandardHelpOptions = true)
    public static class AddContact implements Callable<Integer> {

        private final PhoneBookInterface phoneBookInterface;

        @Option(names = {"-n", "--name"}, description = "Ім'я контакту", required = true)
        private String name;

        @Option(names = {"-p", "--phone"}, description = "Номер телефону", required = true, arity = "0..3")
        private List<String> phones;
        @Option(names = {"-e", "--email"}, description = "Електронна пошта", required = true, arity = "0..3")
        private List<String> emails;

        public AddContact(PhoneBookInterface phoneBookInterface) {
            this.phoneBookInterface = phoneBookInterface;
        }

        @Override
        public Integer call() {
            try {
                ContactDto newContactDto = ContactDto.builder()
                        .fullName(name)
                        .phones(phones)
                        .emails(emails)
                        .build();
                ContactDto savedContactDto = phoneBookInterface.add(newContactDto);
                System.out.println("Контакт додано: ");
                Utils.printContactList(List.of(savedContactDto));

            } catch (Exception e) {
                System.out.println("Помилка, невірний формат: " + name);
            }
            return 0;
        }
    }
    @Command(name = "user", aliases = {"-u","--user"}, mixinStandardHelpOptions = true, description = "Обрати активного корисувача")
    public static class SetUser implements Callable<Integer> {


        @Parameters(index = "0", description = "Ім'я користувача", arity = "0..1")
        private String user;


        @Override
        public Integer call() {
            //TODO Реалізувати логіку команди user

            System.out.println("Ви обрали користувача: "+user);

            return 0;
        }
    }


    @Command(name = "search", aliases = {"-s","--search"}, mixinStandardHelpOptions = true, description = "Шукає контакт за ім'ям")
    public static class SearchContact implements Callable<Integer> {

        private final PhoneBookInterface phoneBookInterface;

        @Parameters(index = "0", description = "Фраза для пошуку", arity = "0..1")
        private String name;

        public SearchContact(PhoneBookInterface phoneBookInterface) {
            this.phoneBookInterface = phoneBookInterface;
        }

        @Override
        public Integer call() {
            Utils.printContactList(phoneBookInterface.search(name));
            return 0;
        }
    }

    @Command(name = "--edit", aliases = {"-e","--edit"}, description = "Редагує існуючий контакт за ім'ям")
    public static class EditContact implements Callable<Integer> {
        private final PhoneBookInterface phoneBookInterface;
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        @Parameters(index = "0", description = "ID контакта", arity = "1")
        private long id;

        public EditContact(PhoneBookInterface phoneBookInterface) {
            this.phoneBookInterface = phoneBookInterface;
        }

        @Override
        public Integer call() {

            Optional<ContactDto> optionalContact = phoneBookInterface.getById(id);

                if (optionalContact.isPresent()) {
                    ContactDto contactDto = optionalContact.get();
                    Utils.printContactList(List.of(contactDto));

                while (true) {
                    System.out.println("\nТелефонна книга - виберiть команду:");
                    System.out.println("1. Редагувати iм'я");
                    System.out.println("2. Редагувати телефони");
                    System.out.println("3. Редагувати email");
                    System.out.println("4. Вийти");
                    System.out.print("Ваш вибiр: ");
                    choice = scanner.nextLine();
                    if(choice.equals("4")) return 0;
                    new CommandLine(new EditContactMenu(phoneBookInterface, contactDto)).execute(choice);
                }
            }else  System.out.println("Помилка. Такого контакту не існує. Спробуйте ще раз.");


            return 0;
        }
    }

    @Command(name = "--delete", aliases = {"-d", "--delete"}, description = "Видаляє контакт за ID", mixinStandardHelpOptions = true)
    public static class DeleteContact implements Callable<Integer> {

        private final PhoneBookInterface phoneBookInterface;

        @Parameters(index = "0", description = "ID контакта", arity = "1..*")
        private List<Long> listId;

        public DeleteContact(PhoneBookInterface phoneBookInterface) {
            this.phoneBookInterface = phoneBookInterface;
        }

        @Override
        public Integer call() {
            listId.forEach(phoneBookInterface::delete);
            System.out.println("Контакт видалено: ");
            Utils.printContactList(phoneBookInterface.list());
            return 0;
        }
    }

    @Command(name = "list", aliases = {"-ls", "--list"}, description = "Виводить усі контакти", mixinStandardHelpOptions = true)
    public static class ListContacts implements Callable<Integer> {
        private final PhoneBookInterface phoneBookInterface;

        public ListContacts(PhoneBookInterface phoneBookInterface) {
            this.phoneBookInterface = phoneBookInterface;
        }

        @Override
        public Integer call() {
            Utils.printContactList(phoneBookInterface.list());
            return 0;
        }
    }


}

