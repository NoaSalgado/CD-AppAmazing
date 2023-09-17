package com.campusdual.appamazing.service;

import com.campusdual.appamazing.api.IContactsService;
import com.campusdual.appamazing.model.Contact;
import com.campusdual.appamazing.model.dao.ContactDAO;
import com.campusdual.appamazing.model.dto.ContactDTO;
import com.campusdual.appamazing.model.dto.dtomapper.ContactMapper;
import com.campusdual.appamazing.model.dto.dtomapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ContactService")
@Lazy
public class ContactService implements IContactsService {
    @Autowired
    ContactDAO contactDAO;
    @Override
    public ContactDTO queryContact(ContactDTO contactDTO) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        return ContactMapper.INSTANCE.toDTO(contactDAO.getReferenceById(contact.getId()));
    }

    @Override
    public List<ContactDTO> queryAllContacts() {
        return ContactMapper.INSTANCE.toDTOList(contactDAO.findAll());
    }

    @Override
    public int insertContact(ContactDTO contactDTO) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        contactDAO.saveAndFlush(contact);
        return contact.getId();
    }

    @Override
    public int updateContact(ContactDTO contactDTO) {
        return this.insertContact(contactDTO);
    }

    @Override
    public int deleteContact(ContactDTO contactDTO) {
        int id = contactDTO.getId();
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        contactDAO.delete(contact);
        return id;
    }
}
