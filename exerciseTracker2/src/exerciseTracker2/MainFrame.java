package exerciseTracker2;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Date;

public class MainFrame extends JFrame implements ActionListener {
	private ArrayList<RunWalk> runwalks;
	private ExerciseDetailPanel edp;
	private JButton btnAddExercise;
	private JMenuItem miLogin;
	private JMenuItem miLogout;
	
	/**
	 * Graphical user interface for the main window of the application
	 */
	public void setupGUI() {
		// Creating container and adding the different panels to the main window
		setTitle("Ecercise Tracker V2.0");
		setBounds(100,100,800,500);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		edp = new ExerciseDetailPanel();
		SummaryPanel sumPan = new SummaryPanel(runwalks);
		c.add(edp,BorderLayout.WEST);
		c.add(sumPan,BorderLayout.EAST);
		JPanel panSouth = new JPanel();
		
		btnAddExercise = new JButton("Add Exercise");
		btnAddExercise.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				int dur = 0, dist = 0;
				ArrayList<String> errors = new ArrayList<String>();
				String name = edp.getName();
				Date date = null;
				try { // Ensures the user enters the date correctly
					date = new SimpleDateFormat("MM/dd/yyy").parse(edp.getDate());
				} catch (ParseException ex) {
					errors.add("The date must be entered in mm/dd/yyyy format.");
				}		
				try { // Ensures the user enters the duration correctly
					dur = edp.getDuration();
					if (dur < 0) {
						errors.add("The duration must be a non-zero number.");
					}
				} catch (Exception ex) {
					errors.add("The duration must be a number.");
				}
				try { // Ensures the user enters the distance correctly
					dist = edp.getDistance();
					if (dist < 0) {
						errors.add("The distance must be a non-zero number.");
					}
				} catch (Exception ex) {
					errors.add("The distance must be a number.");
				}
				
				String com = edp.getComment();
				String errorMessage = "";
				
				if(errors.size() > 0) {  // When errors exist, display message to user
					for(String error : errors) {
						errorMessage = errorMessage + error + " ";
					}
					JOptionPane.showMessageDialog(null,"These errors occured:" + errorMessage);
				} else { // When user inputs all data correctly, add to runwalk list, update the summary panel, and clear entries
				RunWalk runwalk = new RunWalk(name, date, dur, dist, com);
				runwalks.add(runwalk);
				sumPan.updateList();
				edp.clearEntries();
				sumPan.setSummaryLabel(String.format("Exercise Summary (%.2f)",RunWalk.getTotalBurned(runwalks)));
				repaint();
				}
			}
		});
		panSouth.setLayout(new FlowLayout());
		panSouth.add(btnAddExercise);
		c.add(panSouth,BorderLayout.SOUTH);
		enableControls(false);
	}
	/**
	 * Sets up the menu bar for the application
	 */
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		setJMenuBar(mbar);
		
		JMenu mnuFile = new JMenu("File");
		mbar.add(mnuFile);

		miLogin = new JMenuItem("Log in");
		miLogin.addActionListener(this);
		mnuFile.add(miLogin);
		miLogout = new JMenuItem("Log out");
		miLogout.addActionListener(this);
		mnuFile.add(miLogout);
		JMenuItem miSave = new JMenuItem("Save");
		mnuFile.add(miSave);
		
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				File f;
				// Open file chooser when user clicks on the save option
				if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					f = chooser.getSelectedFile();
					if (ExerciseWriter.writeToFile(f, runwalks)) {
						JOptionPane.showMessageDialog(null, "Exercises were saved.");
					} else {
						JOptionPane.showMessageDialog(null, "Exercises were not saved.");
					}
				}
			}
		});
		// Exits the application when user clicks exit option
		JMenuItem miExit = new JMenuItem("Exit");
		mnuFile.add(miExit);
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// displays information about the application when user clicks about option
		JMenu mnuHelp = new JMenu("Help");
		mbar.add(mnuHelp);
		JMenuItem miAbout = new JMenuItem("About");
		mnuHelp.add(miAbout);
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"ExerciseTrackerV2.0 - CPSC 24500 Fall 2023");
			}
		});	
	}
	/**
	 * Constructor to initialize objects
	 * @param runwalks 
	 */
	public MainFrame(ArrayList<RunWalk> runwalks) {
		this.runwalks = runwalks;
		setupGUI();
		setupMenu();
	}
	/**
	 * Enable and disable controls
	 * @param enableYN
	 */
	public void enableControls(boolean enableYN) {
		edp.enableEntries(enableYN);
		btnAddExercise.setEnabled(enableYN);
	}
	/**
	 * Enable and disable controls based on if user is logged in or not 
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == miLogin ) {
			LoginForm dlgLogin = new LoginForm(this,"Log in",true);
			dlgLogin.setVisible(true);
			if (dlgLogin.isLoggedIn()) {
				enableControls(true);
			} else {
				enableControls(false);
			}
		} else if (e.getSource() ==  miLogout){
			enableControls(false);
			edp.clearEntries();
		}
	}
} 