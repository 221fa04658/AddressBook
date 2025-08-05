package Main;

import Controller.ContactController;
import Model.Contact;
import View.ContactView;

public class Main {
    public static void main(String[] args) {
        ContactView view = new ContactView();
        ContactController controller = new ContactController(view);

        controller.addContact(new Contact("Alice", "9876543210", "alice@mail.com", "Bangalore"));
        controller.addContact(new Contact("Bob", "9123456780", "bob@mail.com", "Hyderabad"));

        System.out.println("\n--- All Contacts ---");
        controller.displayAll();

        System.out.println("\n--- Search for 'Alice' ---");
        controller.searchContact("Alice");

        System.out.println("\n--- Sort by Name ---");
        controller.sortContactsByName();

        System.out.println("\n--- Update Alice ---");
        controller.editContact("Alice", new Contact("Alice Smith", "9000000000", "alice.smith@mail.com", "Delhi"));
        controller.displayAll();

        System.out.println("\n--- Delete Bob ---");
        controller.deleteContact("Bob");
        controller.displayAll();
    }
}
