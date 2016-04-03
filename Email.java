/**
 * CS180 - Project 4: Email Server
 * Email : represents email objects that stay in your mailbox
 * @author Phoebe Song, song384@purdue.edu
 */
import java.util.Date;

public class Email {

    private String recipient;
    private String sender;
    private long id;
    private String message;
    private String dateCreated;
    /*
     * @param recipient: the username of the person the email is going to
     * @param sender : the username of the person who is sending the email
     * @param id: unique semi-global id, ids only have to be unique within a user's mailbox
     * @message: text content of the email
     * This constructor must also record the time when each Email is constructed--used in GET-EMAILS command.
     */
    public Email(String recipient, String sender, long id, String message) {
        this.recipient = recipient;
        this.sender = sender;
        this.id = id;
        this.message = message;
        Date date = new Date();
        //might not need this following statement (do in GET-EMAILS instead of here)
        dateCreated = date.toString();
    }

    public long getID() {
        return id;
    }

    public String getOwner() {
        return recipient;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    /*
     * toString(): retrieves String representation of an Email object in the format
     * mail id; create time; sender; "this is the mail body"
     */
    public String toString() {
        String details = id + "; " + getDateCreated() + "; "
                + "From: " + getSender() + "; \"" + getMessage() + "\"";
        return details;
    }


}
