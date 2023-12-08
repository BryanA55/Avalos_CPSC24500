package exerciseTracker2;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.util.ArrayList;

public class SummaryPanel extends JPanel {
	private ArrayList<RunWalk> runwalks;
	private JTextArea tarSummary;
	private JLabel labelSummary;
	
	/**
	 * Graphical user interface for the summary of the exercises
	 */
	public void setupGUI() {
		setLayout(new BorderLayout());
		JPanel panNorth = new JPanel();
		panNorth.setLayout(new FlowLayout());
		labelSummary = new JLabel("Exercise Summary");
		panNorth.add(labelSummary);
		add(panNorth,BorderLayout.NORTH);
		tarSummary = new JTextArea(10,30);
		tarSummary.setEditable(false);
		add(tarSummary,BorderLayout.CENTER);	
	}
	public void setSummaryLabel(String text) {
		labelSummary.setText(text);
	}
	public SummaryPanel(ArrayList<RunWalk> runwalks) {
		this.runwalks = runwalks;
		setupGUI();
	}
	/**
	 * Updates the list for the exercise summary tab
	 */
	public void updateList() {
		tarSummary.setText("");
		String text = "";
		for(RunWalk runwalk : runwalks) {
			text = text + runwalk + "\n";
		}
		tarSummary.setText(text);
	}
}
