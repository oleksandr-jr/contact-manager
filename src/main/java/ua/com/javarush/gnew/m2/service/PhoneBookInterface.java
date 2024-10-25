package ua.com.javarush.gnew.m2.service;

import ua.com.javarush.gnew.m2.entity.Contact;

import java.util.List;

public interface PhoneBookInterface {

    void add(Contact contact);
    void search(String str);
    void edit(Contact contact);
    void delete(String name);
    List<Contact> list ();

}
