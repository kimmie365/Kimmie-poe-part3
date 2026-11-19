package com.mycompany.registrationlogin;

import java.util.ArrayList;
import java.util.List;

public class MessageManager {

    private final List<String> senders = new ArrayList<>();
    private final List<String> recipients = new ArrayList<>();
    private final List<String> messages = new ArrayList<>();
    private final List<String> messageIDs = new ArrayList<>();
    private final List<String> messageHashes = new ArrayList<>();
    private final List<String> flags = new ArrayList<>();

    public MessageManager() {
        loadDefaultMessages();
    }

    public final void loadDefaultMessages() {
        senders.clear();
        recipients.clear();
        messages.clear();
        messageIDs.clear();
        messageHashes.clear();
        flags.clear();

        addMessage("+27821112222", "+27834557896", "Did you get the cake?", "0838845672", "08:1:DIDCAKE?", "Stored");
        addMessage("+27821112222", "+27838884567", "Where are you? You are late! I have asked you to be on time.", "0838845673", "08:2:WHERETIME.", "Stored");
        addMessage("+27821112222", "+27834557896", "Meeting starts at 10:00 AM.", "0838845674", "08:3:MEETINGAM.", "Sent");
    }

    public void addMessage(String sender, String recipient, String message, String messageID, String messageHash, String flag) {
        senders.add(sender == null ? "" : sender.trim());
        recipients.add(recipient == null ? "" : recipient.trim());
        messages.add(message == null ? "" : message.trim());
        messageIDs.add(messageID == null ? "" : messageID.trim());
        messageHashes.add(messageHash == null ? "" : messageHash.trim());
        flags.add(flag == null ? "Stored" : flag.trim());
    }

    public String displayStoredSendersAndRecipients() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < messages.size(); i++) {
            if ("Stored".equalsIgnoreCase(flags.get(i))) {
                sb.append("Sender: ").append(senders.get(i))
                  .append(" | Recipient: ").append(recipients.get(i))
                  .append("\n");
            }
        }
        return sb.length() == 0 ? "No stored messages found." : sb.toString().trim();
    }

    public String getLongestMessage() {
        if (messages.isEmpty()) {
            return "No messages available.";
        }
        String longest = "";
        for (int i = 0; i < messages.size(); i++) {
            if ("Stored".equalsIgnoreCase(flags.get(i)) && messages.get(i).length() > longest.length()) {
                longest = messages.get(i);
            }
        }
        if (longest.isEmpty()) {
            for (String msg : messages) {
                if (msg.length() > longest.length()) {
                    longest = msg;
                }
            }
        }
        return longest;
    }

    public String searchByMessageID(String id) {
        if (id == null || id.isBlank()) {
            return "Please enter a valid Message ID.";
        }
        for (int i = 0; i < messageIDs.size(); i++) {
            if (messageIDs.get(i).equalsIgnoreCase(id.trim())) {
                return "ID: " + messageIDs.get(i)
                        + "\nSender: " + senders.get(i)
                        + "\nRecipient: " + recipients.get(i)
                        + "\nMessage: " + messages.get(i)
                        + "\nHash: " + messageHashes.get(i)
                        + "\nFlag: " + flags.get(i);
            }
        }
        return "Message ID not found: " + id.trim();
    }

    public String searchByRecipient(String recipient) {
        if (recipient == null || recipient.isBlank()) {
            return "Please enter a recipient number.";
        }
        String target = recipient.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).equalsIgnoreCase(target)) {
                sb.append("[").append(messageIDs.get(i)).append("] ")
                  .append(messages.get(i))
                  .append(" (").append(flags.get(i)).append(")\n");
            }
        }
        return sb.length() == 0 ? "No messages found for recipient: " + target : sb.toString().trim();
    }

    public String deleteByMessageHash(String hash) {
        if (hash == null || hash.isBlank()) {
            return "Please enter a valid Message Hash.";
        }
        String target = hash.trim();
        for (int i = 0; i < messageHashes.size(); i++) {
            if (messageHashes.get(i).equalsIgnoreCase(target)) {
                String removed = messages.get(i);
                senders.remove(i);
                recipients.remove(i);
                messages.remove(i);
                messageIDs.remove(i);
                messageHashes.remove(i);
                flags.remove(i);
                return "Deleted message: " + removed;
            }
        }
        return "No message found with hash: " + target;
    }

    public String displayFullReport() {
        if (messages.isEmpty()) {
            return "No messages to display.";
        }
        StringBuilder sb = new StringBuilder("=== MESSAGES REPORT ===\n");
        for (int i = 0; i < messages.size(); i++) {
            sb.append("#").append(i + 1)
              .append(" | ID: ").append(messageIDs.get(i))
              .append(" | Hash: ").append(messageHashes.get(i))
              .append(" | Sender: ").append(senders.get(i))
              .append(" | Recipient: ").append(recipients.get(i))
              .append(" | Flag: ").append(flags.get(i))
              .append(" | Message: ").append(messages.get(i))
              .append("\n");
        }
        return sb.toString().trim();
    }

    void loadStoredMessagesFromJSON(String stored_messagesjson) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}