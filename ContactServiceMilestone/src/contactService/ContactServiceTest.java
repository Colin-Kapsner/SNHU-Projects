package contactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void addContactStoresContact() {
        ContactService service = new ContactService();

        service.addContact("12345", "John", "Doe",
                           "1234567890", "123 Main Street");

        Contact contact = service.getContact("12345");
        assertNotNull(contact);
        assertEquals("John", contact.getFirstName());
    }

    @Test
    void addContactWithDuplicateIdThrowsException() {
        ContactService service = new ContactService();

        service.addContact("12345", "John", "Doe",
                           "1234567890", "123 Main Street");

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact("12345", "Jane", "Smith",
                               "0987654321", "456 Elm Street");
        });
    }

    @Test
    void updateFirstNameChangesStoredContact() {
        ContactService service = new ContactService();

        service.addContact("12345", "John", "Doe",
                           "1234567890", "123 Main Street");

        service.updateFirstName("12345", "Jane");
        Contact contact = service.getContact("12345");

        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void deleteContactRemovesContact() {
        ContactService service = new ContactService();

        service.addContact("12345", "John", "Doe",
                           "1234567890", "123 Main Street");

        service.deleteContact("12345");

        Contact contact = service.getContact("12345");
        assertNull(contact);
    }
}