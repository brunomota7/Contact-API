package br.com.crud.controller;

import br.com.crud.model.Contact;
import br.com.crud.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crud")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/add")
    public Contact addNewContact(@RequestBody Contact newContact) {
        return contactService.toSaveContact(newContact);
    }

    @GetMapping("/listar")
    public List<Contact> getAllContact() {
        return contactService.getAllContact();
    }

    @PutMapping("/atualizar/{id}")
    public Contact updateContact(@PathVariable Long id,@RequestBody Contact updateContact) {
        return contactService.toUpdateContact(id, updateContact);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.status(200).body("Contato deletado com sucesso.");
    }
}
