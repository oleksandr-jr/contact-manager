package ua.com.javarush.gnew.m2.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ContactDto {
    private long id;

    private String fullName;

    private List<String> phones;

    private List<String> emails;

}
