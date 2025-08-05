package Controller;

import Model.Contact;
import View.ContactView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactController {
    private List<Contact> contacts = new ArrayList<>();
    private ContactView view;

    public ContactController(ContactView view) {
        this.view = view;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        view.showMessage("Contact added!");
    }

    public void deleteContact(String name) {
        contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
        view.showMessage("Contact deleted if existed.");
    }

    public void editContact(String name, Contact updatedContact) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                c.setName(updatedContact.getName());
                c.setPhone(updatedContact.getPhone());
                c.setEmail(updatedContact.getEmail());
                c.setAddress(updatedContact.getAddress());
                view.showMessage("Contact updated!");
                return;
            }
        }
        view.showMessage("Contact not found.");
    }

    public void searchContact(String keyword) {
        for (Contact c : contacts) {
            if (c.getName().contains(keyword) || 
                c.getPhone().contains(keyword) || 
                c.getEmail().contains(keyword)) {
                view.showContact(c);
            }
        }
    }

    public void sortContactsByName() {
        contacts.sort(Comparator.comparing(Contact::getName));
        view.showAllContacts(contacts);
    }

    public void displayAll() {
        view.showAllContacts(contacts);
    }
}

