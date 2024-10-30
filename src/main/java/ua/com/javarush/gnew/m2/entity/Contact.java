package ua.com.javarush.gnew.m2.entity;

import lombok.Data;

import java.util.List;

@Data
public class Contact {
    private long id;

    private String fullName;

    private List<PhoneNumber> phones;

    private List<Email> emails;
}

