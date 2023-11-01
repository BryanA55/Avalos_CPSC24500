package emailerAssignment;
	
import java.util.ArrayList;
	
public class Email {
	// Declare necessary variables
		
	private String subject;
	private String body;
	private ArrayList<String> recipients;
	private static boolean send;
	private String sendStatus;
	
	public static void send() {
		send = true; // Send function
	}
	public Email() {
		this(new String[0],"Subject","Body");
	}
	public Email(String [] recipientArray, String sub, String bod) {
		setSubject(sub);
		setBody(bod);
		recipients = new ArrayList<String>();
		for (String recipient : recipientArray) {
			addRecipients(recipient);
		}
		send = false;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void addRecipients(String recip) {
		recipients.add(recip);
	}
	/**
	 * Converts the recipients of the emails into a string
	 * @return result, the recipients as a string
	 */
	public String getRecipientsAsString() {
		String [] recipientArray = recipients.toArray(new String [0]);	
		String result = String.join(", ", recipientArray);
		return result;
	}
	/**
	 *  Formats the email for the menu option to list emails
	 *  @return String.format, the formatted email for listing
	 */
	public String toString() {
		// Format of email when listing emails
		
		if (send) {
			sendStatus = "sent";
		} else {
			sendStatus = "not sent";
		}
		return String.format("To:\t\t%s\nSubject:\t%s\nStatus:\t\t%s\nBody:\n%s\n",getRecipientsAsString(),subject,sendStatus,body);
	}
	/**
	 * Provides a clean format for saving the user emails to a file
	 * @return String.format the formatting of the email
	 */
	public String fileFriendlyEmail() {
		// Format of email when saving to file
			
		if (send) {
			sendStatus = "sent";
		} else {
			sendStatus = "not sent";
		}
		return String.format("%s\t%s\t%s\t%s",getRecipientsAsString(),subject,body,sendStatus);
	}	
}
