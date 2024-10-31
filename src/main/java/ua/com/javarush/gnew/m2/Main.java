package ua.com.javarush.gnew.m2;


import picocli.CommandLine;
import ua.com.javarush.gnew.m2.cli.PhoneBookCLI;
import ua.com.javarush.gnew.m2.service.PhoneBookInterface;
import ua.com.javarush.gnew.m2.service.SimplePhoneBook;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello 16-fr-implement-basic-cli-support!");
        PhoneBookInterface phoneBook = new SimplePhoneBook();

                int exitCode = new CommandLine(new PhoneBookCLI())
                .addSubcommand("add", new PhoneBookCLI.AddContact(phoneBook))
                .addSubcommand("search", new PhoneBookCLI.SearchContact(phoneBook))
                .addSubcommand("edit", new PhoneBookCLI.EditContact(phoneBook))
                .addSubcommand("delete", new PhoneBookCLI.DeleteContact(phoneBook))
                .addSubcommand("list", new PhoneBookCLI.ListContacts(phoneBook))
//                .addSubcommand("user", new PhoneBookCLI.SetUser(phoneBookContext))
                .execute(args);
    }
}
