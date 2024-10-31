package ua.com.javarush.gnew.m2.service;

import ua.com.javarush.gnew.m2.dto.ContactDto;
import ua.com.javarush.gnew.m2.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface PhoneBookInterface {

    ContactDto add(ContactDto contactDto);
    List<ContactDto> search(String str);
    void edit(ContactDto contact);
    void delete(long id);
    List<ContactDto> list ();
    Optional<ContactDto> getById(long id);
}
