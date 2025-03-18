package br.com.crud.service;

import br.com.crud.model.Contact;
import br.com.crud.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    /**
     * O Spring injeta automaticamente uma
     * instância de ContactRepository na classe ContactService,
     * evitando a necessidade de instanciá-la manualmente.
     **/
    @Autowired
    private ContactRepository contactRepository;

    public Contact toSaveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    public Contact toUpdateContact(Long id, Contact contact) {
        return contactRepository.findById(id)
                .map(existingContact -> {
                    existingContact.setName(contact.getName());
                    existingContact.setEmail(contact.getEmail());
                    existingContact.setPhone(contact.getPhone());
                    return contactRepository.save(existingContact);
                }).orElseThrow(() -> new RuntimeException("Contato não encontrado"));
    }

    public void deleteContact(Long id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
        } else {
            throw new RuntimeException("Contato não encontrado");
        }
    }
}
