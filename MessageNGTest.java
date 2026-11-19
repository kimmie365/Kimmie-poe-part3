package com.mycompany.Registrationlogin.java;

import com.mycompany.registrationlogin.Message;
import javax.swing.JOptionPane;
import org.junit.jupiter.api.Test;
import static org.testng.Assert.*;



/**
     * Test of SentMessage method, of class Message.
     */


/**
 *
 * @author Student
 */
public class MessageNGTest {
    
  
        @Test
    public void testSentMessage() {
        System.out.println("SentMessage");
        Message instance = new Message("+2711111111", "hjs xsjhvbsh hjsvxjvws");
        String expResult = "message successfully sent";
        String result = instance.SentMessage();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of storeMessage method, of class Message.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        Message instance = new Message("+27111111111", "hhugtffyuhiutfgygu");
        instance.storeMessage();
        
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("CheckMessageID");
        Message instance = new Message("+27111111111", "hhugtffyuhiutfgygu");
        boolean expResult = true;
        boolean result = instance.checkMessageID();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkRecipientCell method, of class Message.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        Message instance = null;
        boolean expResult = false;
        boolean result = instance.checkRecipientCell();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkMessageLength method, of class Message.
     */
    @Test
    public void testCheckMessageLength() {
        System.out.println("checkMessageLength");
        Message instance = new Message("+27111111111", "hhugtffyuhiutfgygu");
        boolean expResult = false;
        boolean result = instance.checkMessageLength();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of generateMessageID method, of class Message.
     */
    @Test
    public void testGenerateMessageID() {
        System.out.println("generateMessageID");
        Message instance = new Message("+27111111111", "hhugtffyuhiutfgygu");
        String expResult = "1245";
        String result = instance.generateMessageID();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of createMessageHash method, of class Message.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        Message instance = new Message("+27111111111", "hhugtffyuhiutfgygu");
        String expResult = "EXPECTED_HASH_HERE";
        String result = instance.createMessageHash();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }
 public class StoredMessagesMenu {

    public static void main(String[] args) {
        
        MessageManager manager;
        manager = new MessageManager();
        
        
        

      boolean running = true;
        while (running) {
            String choice = JOptionPane.showInputDialog(
                null,
                "Message Messenger Menu:\n" +
                "a. Display sender and recipient of all stored messages\n" +
                "b. Display the longest stored message\n" +
                "c. Search for a message ID\n" +
                "d. Search all messages for a particular recipient\n" +
                "e. Delete a message using message hash\n" +
                "f. Display full report\n" +
                "g. Add a new message (JOptionPane)\n" +
                "x. Exit",
                "Message Messenger",
                JOptionPane.QUESTION_MESSAGE
            );

            if (choice == null || choice.trim().equalsIgnoreCase("x")) {
                JOptionPane.showMessageDialog(null, "Exiting Message Messenger.");
                running = false;
                break;
            }

            switch (choice.trim().toLowerCase()) {
                case "a":
                    JOptionPane.showMessageDialog(null, manager.displayStoredSendersAndRecipients());
                    break;
                case "b":
                    JOptionPane.showMessageDialog(null, "Longest Message:\n" + manager.getLongestMessage());
                    break;
                case "c":
                    String id = JOptionPane.showInputDialog(null, "Enter Message ID:");
                    if (id != null) {
                        JOptionPane.showMessageDialog(null, manager.searchByMessageID(id));
                    }
                    break;
                case "d":
                    String recipient = JOptionPane.showInputDialog(null, "Enter Recipient Number:");
                    if (recipient != null) {
                        JOptionPane.showMessageDialog(null, manager.searchByRecipient(recipient));
                    }
                    break;
                case "e":
                    String hash = JOptionPane.showInputDialog(null, "Enter Message Hash to delete:");
                    if (hash != null) {
                        JOptionPane.showMessageDialog(null, manager.deleteByMessageHash(hash));
                    }
                    break;
                case "f":
                    JOptionPane.showMessageDialog(null, manager.displayFullReport());
                    break;
                case "g":
                    String sender = JOptionPane.showInputDialog(null, "Enter Sender:");
                    if (sender == null) break;
                    String rec = JOptionPane.showInputDialog(null, "Enter Recipient:");
                    if (rec == null) break;
                    String msg = JOptionPane.showInputDialog(null, "Enter Message:");
                    if (msg == null) break;
                    String msgId = JOptionPane.showInputDialog(null, "Enter Message ID:");
                    if (msgId == null) break;
                    String msgHash = JOptionPane.showInputDialog(null, "Enter Message Hash:");
                    if (msgHash == null) break;
                    String flag = JOptionPane.showInputDialog(null, "Enter Flag (Stored / Sent / Disregarded):");
                    if (flag == null) break;

                    manager.addMessage(sender, rec, msg, msgId, msgHash, flag);
                    JOptionPane.showMessageDialog(null, "Message added!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Choose a–g or x.");
                    break;
            }
        }
    }
}
}
    
        
    


