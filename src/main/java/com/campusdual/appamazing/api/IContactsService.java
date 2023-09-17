package com.campusdual.appamazing.api;

import com.campusdual.appamazing.model.dto.ContactDTO;

import java.util.List;

public interface IContactsService {
    ContactDTO queryContact(ContactDTO contactDTO);
    List<ContactDTO> queryAllContacts();
    int insertContact(ContactDTO contactDTO);
    int updateContact(ContactDTO contactDTO);
    int deleteContact(ContactDTO contactDTO);
}
