package exerciseTracker2;
//Occupies west side of screen
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExerciseDetailPanel extends JPanel {
	private JTextField txtName;
	private JTextField txtDate;
	private JTextField txtDuration;
	private JTextField txtDistance;
	private JTextArea tarComment;
	
	/**
	 * Graphical user interface for the exercise details
	 */
	public void setupGUI() {
		
		// Setting up the panel for the details of an exercise
		setLayout(new BorderLayout());
		JPanel panNorth = new JPanel();
		panNorth.setLayout(new GridLayout(5,2));
		
		// Creating labels and text fields for the different parts of an exercise
		JLabel labelName = new JLabel("Name:");
		txtName = new JTextField(10);
		JLabel labelDate = new JLabel("Date:");
		txtDate = new JTextField(10);
		JLabel labelDuration = new JLabel("Duration:");
		txtDuration = new JTextField(10);
		JLabel labelDistance = new JLabel("Distance:");
		txtDistance = new JTextField(10);
		
		// Add the labels and text fields to the layout
		panNorth.add(labelName);
		panNorth.add(txtName);
		panNorth.add(labelDate);
		panNorth.add(txtDate);
		panNorth.add(labelDuration);
		panNorth.add(txtDuration);
		panNorth.add(labelDistance);
		panNorth.add(txtDistance);
		add(panNorth,BorderLayout.NORTH);
		
		// Setting up comment section of the GUI
		JPanel panComment = new JPanel();
		panComment.setLayout(new BorderLayout());
		JLabel labelComment = new JLabel("Add comment:");
		panComment.add(labelComment,BorderLayout.NORTH);
		tarComment = new JTextArea(5,10);
		panComment.add(tarComment,BorderLayout.CENTER);
		add(panComment,BorderLayout.CENTER);
		
		
	}
	public ExerciseDetailPanel() {
		setupGUI();
	}
	public String getName() {
		return txtName.getText();
	}
	public String getDate() {
		return txtDate.getText();
	}
	public int getDuration() {
		return Integer.parseInt(txtDuration.getText());
	}
	public int getDistance() {
		return Integer.parseInt(txtDistance.getText());
	}
	public String getComment() {
		return tarComment.getText();
	}
	public void clearEntries() {
		txtName.setText("");
		txtDate.setText("");
		txtDuration.setText("");
		txtDistance.setText("");
		tarComment.setText("");
	}
	public void enableEntries(boolean enableYN) {
		txtName.setEnabled(enableYN);
		txtDate.setEnabled(enableYN);
		txtDuration.setEnabled(enableYN);
		txtDistance.setEnabled(enableYN);
		tarComment.setEnabled(enableYN);
	}
}
