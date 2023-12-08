package exerciseTracker2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JDialog {
	private boolean loggedIn;
	private String password;
	private String username;
	
	/**
	 * Graphical user interface for the log in form
	 */
	public void setupGUI() {
		setBounds(250,150,300,200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panCenter = new JPanel();
		panCenter.setLayout(new GridLayout(4, 1));
		
		// Creating user name label and field for login
		JLabel user = new JLabel("Username");
		user.setHorizontalAlignment(JLabel.CENTER);
		user.setVerticalAlignment(JLabel.CENTER);
		panCenter.add(user);
		JPasswordField txtUsername = new JPasswordField(10);
		panCenter.add(txtUsername);
		
		// Creating password field and label for login
		JLabel pswrd = new JLabel("Password");
		pswrd.setHorizontalAlignment(JLabel.CENTER);
		pswrd.setVerticalAlignment(JLabel.CENTER);
		panCenter.add(pswrd);
		JPasswordField txtPassword = new JPasswordField(10);
		panCenter.add(txtPassword);
		
		// Creating empty border layouts to center the user name and password fields
		JPanel panWest = new JPanel();
		panWest.setLayout(new BorderLayout());
		panWest.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
		JPanel panEast = new JPanel();
		panEast.setLayout(new BorderLayout());
        panEast.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));

		// Adding border layouts to to the container
		c.add(panCenter,BorderLayout.CENTER);
		c.add(panWest,BorderLayout.WEST);
		c.add(panEast,BorderLayout.EAST);
		
		// Creating log in and cancel buttons
		JPanel panSouth = new JPanel();
		JButton btnLogin = new JButton("Log In");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredPassword = new String(txtPassword.getPassword());
				String enteredUsername = new String(txtUsername.getPassword());
				if (enteredPassword.equals(password) && enteredUsername.equals(username)) {
					loggedIn = true;
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null,"The username/password you entered was incorrect.");	
				}
			}
		});
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loggedIn = false;
				setVisible(false);
			}	
		});
		// Adding the log in and cancel buttons to the container
		panSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
		panSouth.add(btnLogin);
		panSouth.add(btnCancel);
		c.add(panSouth,BorderLayout.SOUTH);
	}
	/**
	 * Sets up the user name and password requirements for logging in
	 * @param owner
	 * @param title
	 * @param modal
	 */
	public LoginForm(JFrame owner, String title, boolean modal) {
		super(owner,title,modal);
		setupGUI();
		loggedIn = false;
		password = "donut";
		username = "healthy";
	}
	/**
	 * Determines if the user is logged in
	 * @return logged in, to determine if the user is logged into the application
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}
}
