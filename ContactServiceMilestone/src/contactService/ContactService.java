package contactService;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private List<Contact> contacts = new ArrayList<>();

    // helper method to find a contact by ID
    private Contact findContact(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }
    
    // helper method for tests / external code to see a contact
    public Contact getContact(String contactId) {
        return findContact(contactId);
    }

    // add a new contact with a unique ID
    public void addContact(String contactId, String firstName, String lastName,
                           String phone, String address) {

        if (findContact(contactId) != null) {
            throw new IllegalArgumentException("Contact ID already exists");
        }

        Contact contact = new Contact(contactId, firstName, lastName, phone, address);
        contacts.add(contact);
    }

    // delete a contact by ID
    public void deleteContact(String contactId) {
        Contact contact = findContact(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contacts.remove(contact);
    }

    // update first name for a contact by ID
    public void updateFirstName(String contactId, String newFirstName) {
        Contact contact = findContact(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setFirstName(newFirstName);
    }

    // update last name for a contact by ID
    public void updateLastName(String contactId, String newLastName) {
        Contact contact = findContact(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setLastName(newLastName);
    }

    // update phone for a contact by ID
    public void updatePhone(String contactId, String newPhone) {
        Contact contact = findContact(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setPhone(newPhone);
    }

    // update address for a contact by ID
    public void updateAddress(String contactId, String newAddress) {
        Contact contact = findContact(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setAddress(newAddress);
    }
}