package ua.com.javarush.gnew.m2.entity;

import lombok.Data;

import java.util.Arrays;

@Data
public class Contact {
    private String id;
    private String fullName;
    private String[] phones = new String[3];
    private String[] emails = new String[3];

    public Contact(String fullName, String[] phones, String[] emails) {
        this.fullName = fullName;
        this.phones = phones;
        this.emails = emails;
    }
    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phones=" + Arrays.toString(phones) +
                ", emails=" + Arrays.toString(emails) +
                '}';
    }
}
