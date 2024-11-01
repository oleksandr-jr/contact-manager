package ua.com.javarush.gnew.m2.service;

import ua.com.javarush.gnew.m2.dto.ContactDto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SimplePhoneBook implements PhoneBookInterface {
    @Override
    public ContactDto add(ContactDto contactDto) {
        return contactDto;
    }

    @Override
    public List<ContactDto> search(String str) {
        return Collections.emptyList();
    }

    @Override
    public void edit(ContactDto contact) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<ContactDto> list() {
        return Collections.emptyList();
    }

    @Override
    public Optional<ContactDto> getById(long id) {
        return Optional.empty();
    }
}
