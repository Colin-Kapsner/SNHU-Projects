package contactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void contactIsCreatedWithValidData() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");

        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void contactIdLongerThanTenCharactersThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    void phoneThatIsNotTenDigitsThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "123456789", "123 Main Street"); // 9 digits
        });
    }

    @Test
    void setFirstNameUpdatesNameWhenValid() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");

        contact.setFirstName("Jane");

        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void setPhoneRejectsInvalidValue() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345abcde"); // not all digits
        });
    }
}