
package com.mycompany.registrationlogin;

import java.util.List;
import javax.swing.JOptionPane;

public class StoredMessagesMenu {

    public static void showMenu() {

       
        
        MessageManager manager = new MessageManager();

        manager.loadStoredMessagesFromJSON("stored_messages.json");

        boolean inSubMenu = true;

        while (inSubMenu) {

            String choice = JOptionPane.showInputDialog(
                "STORED MESSAGES MENU\n\n" +
                "a. Display senders and recipients\n" +
                "b. Display the longest stored message\n" +
                "c. Search for a message ID\n" +
                "d. Search messages by recipient\n" +
                "e. Delete a message using message hash\n" +
                "f. Display full report\n" +
                "x. Return to Main Menu\n\n" +
                "Enter your choice:"
            );

            if (choice == null ||
                    choice.trim().equalsIgnoreCase("x")) {

                inSubMenu = false;

                JOptionPane.showMessageDialog(null,
                        "Returning to Main Menu.");

                continue;
            }

            switch (choice.trim().toLowerCase()) {

                case "a":

                    JOptionPane.showMessageDialog(
                            null,
                            manager.displayStoredSendersAndRecipients()
                    );

                    break;

                case "b":

                    JOptionPane.showMessageDialog(
                            null,
                            "Longest Stored Message:\n\n" +
                            manager.getLongestMessage()
                    );

                    break;

                case "c":

                    String id = JOptionPane.showInputDialog(
                            "Enter Message ID:"
                    );

                    if (id != null) {

                        JOptionPane.showMessageDialog(
                                null,
                                manager.searchByMessageID(id)
                        );
                    }

                    break;

                case "d":

                    String recipient = JOptionPane.showInputDialog(
                            "Enter Recipient Number:"
                    );

                    if (recipient != null) {

                        List<String> results =
                                manager.searchByRecipient(recipient);

                        JOptionPane.showMessageDialog(
                                null,
                                String.join("\n", results)
                        );
                    }

                    break;

                case "e":

                    String hash = JOptionPane.showInputDialog(
                            "Enter Message Hash:"
                    );

                    if (hash != null) {

                        JOptionPane.showMessageDialog(
                                null,
                                manager.deleteByMessageHash(hash)
                        );
                    }

                    break;

                case "f":

                    JOptionPane.showMessageDialog(
                            null,
                            manager.displaySentReport()
                    );

                    break;

                default:

                    JOptionPane.showMessageDialog(
                            null,
                            "Invalid option. Choose a, b, c, d, e, f or x."
                    );

                    break;
            }
        }
    }

    public static void main(String[] args) {
        showMenu();
    }
}
