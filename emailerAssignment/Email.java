	package emailerAssignment;
	
	import java.util.ArrayList;
	import java.io.File;
	import java.util.Scanner;
	
	public class Email {
		private String subject;
		private String body;
		private ArrayList<String> recipients;
		private static boolean send;
	
		public static void send() {
			send = true;
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
		public String getRecipientsAsString() {
			String result = "";
			for (String recip: recipients) {
				result = result + recip;
			}
			return result;
		}
		public String toString() {
			String sendStatus;
			if (send) {
				sendStatus = "sent";
			} else {
				sendStatus = "not sent";
			}
			return String.format("To: %s\t\nSubject: %s\t\nStatus: %s\t\nBody:\n%s\n",getRecipientsAsString(),subject,sendStatus,body);
		}
		public String fileFriendlyEmail() {
			return String.format("%s\t%s\t%s",getRecipientsAsString(),subject,body);
		}
	//public String fileFriendlyString() {
		//return tab-delimited version of the email
	//}
	
	// before its sent, return = false;
		// after it is sent, return = true;
	
	//constructors
	//get and set
	// toString()
	
	
}
