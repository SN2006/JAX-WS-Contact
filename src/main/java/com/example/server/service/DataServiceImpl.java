package com.example.server.service;

import com.example.server.entity.Contact;
import com.example.server.exceptions.ContactDataException;
import com.example.server.repository.impl.ContactRepository;
import com.example.server.utils.Constants;
import com.example.server.utils.ContactValidator;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@WebService(endpointInterface = "com.example.server.service.DataService")
public class DataServiceImpl implements DataService {

    ContactRepository contactRepository = new ContactRepository();
    ContactValidator validator = new ContactValidator();

    @Override
    public String create(String[] data) {
        Map<String, String> errors = validator.validateNamePhone(data);
        if (!errors.isEmpty()) {
            try {
                throw new ContactDataException("Check inputs");
            }catch (ContactDataException e) {
                return e.getErrors(errors);
            }
        }
        Contact contact = new Contact();
        contact.setName(data[0]);
        contact.setPhone(data[1]);

        return contactRepository.create(contact);
    }

    @Override
    public String read() {
        Optional<List<Contact>> optionalContacts = contactRepository.read();
        if (optionalContacts.isPresent()) {
            List<Contact> contacts = optionalContacts.get();
            if (!contacts.isEmpty()){
                AtomicInteger counter = new AtomicInteger();
                StringBuilder builder = new StringBuilder();
                contacts.forEach(contact -> builder.append(counter.incrementAndGet())
                        .append(") ").append(contact.toString())
                        .append("\n"));
                return builder.toString();
            }
            return Constants.NO_DATA_MSG;
        }
        return Constants.NO_DATA_MSG;
    }

    @Override
    public String update(String[] data) {
        Map<String, String> errors = validator.validateIdNamePhone(data);
        if (!errors.isEmpty()) {
            try {
                throw new ContactDataException("Check inputs!");
            }catch (ContactDataException e) {
                return e.getErrors(errors);
            }
        }
        Contact contact = new Contact();
        contact.setId(Long.parseLong(data[0]));
        contact.setName(data[1]);
        contact.setPhone(data[2]);

        return contactRepository.update(contact);
    }

    @Override
    public String delete(String[] data) {
        Map<String, String> errors = validator.validateId(data);
        if (!errors.isEmpty()) {
            try {
                throw new ContactDataException("Check inputs");
            } catch (ContactDataException e) {
                return e.getErrors(errors);
            }
        }
        return contactRepository.delete(Long.parseLong(data[0]));
    }

    @Override
    public String readById(String[] data) {
        Map<String, String> errors = validator.validateId(data);
        if (!errors.isEmpty()) {
            try {
                throw new ContactDataException("Check inputs");
            } catch (ContactDataException e) {
                return e.getErrors(errors);
            }
        }
        Optional<Contact> optionalContact =
                contactRepository.readById(Long.parseLong(data[0]));

        if (optionalContact.isPresent()) {
            return optionalContact.get().toString();
        }
        return Constants.NO_DATA_MSG;
    }
}
