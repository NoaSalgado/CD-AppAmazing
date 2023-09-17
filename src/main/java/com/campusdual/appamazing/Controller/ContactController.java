package com.campusdual.appamazing.Controller;

import com.campusdual.appamazing.api.IContactsService;
import com.campusdual.appamazing.model.dto.ContactDTO;
import com.campusdual.appamazing.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private IContactsService contactsService;

    @PostMapping
    public String testController(@RequestBody String name){
        return name + "Contacts controller is working!";
    }

    @PostMapping("/get")
    public ContactDTO queryContact(@RequestBody ContactDTO contactDTO){
        return this.contactsService.queryContact(contactDTO);
    }

    @GetMapping("get/{id}")
    public ContactDTO queryContact(@PathVariable int id){
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(id);
        return this.contactsService.queryContact(contactDTO);
    }

    @GetMapping("/getAll")
    public List<ContactDTO> queryAllContacts(){
        return this.contactsService.queryAllContacts();
    }

    @PostMapping("/add")
    public int addProduct(@RequestBody ContactDTO contactDTO){
        return this.contactsService.insertContact(contactDTO);
    }

    @PutMapping("/update")
    public int updateProduct(@RequestBody ContactDTO contactDTO){
        return this.contactsService.updateContact(contactDTO);
    }

    @DeleteMapping("/delete")
    public int deleteContact(@RequestBody ContactDTO contactDTO){
        return this.contactsService.deleteContact(contactDTO);
    }
}
