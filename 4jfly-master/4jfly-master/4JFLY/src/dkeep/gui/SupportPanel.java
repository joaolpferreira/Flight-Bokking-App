package dkeep.gui;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class SupportPanel extends JPanel {
	private JTextField question3Text;
	private JTextField question6Text;
	private JTextField question5Text;
	private JTextField question4Text;
	private JTextField question1Text3;
	private JTextField question2Text;
	private JTextField question1Text2;
	private JTextField question1Text1;
	private JTextField phoneText;
	private JTextField adminMailText;

	/**
	 * Create the panel.
	 */
	public SupportPanel() {
		setBackground(new Color(255, 250, 250));
		setBounds(0,0,1260,819);
		setLayout(null);
		
		
		JLabel supportLabel = new JLabel("Support");
		supportLabel.setHorizontalAlignment(SwingConstants.LEFT);
		supportLabel.setForeground(new Color(0, 139, 139));
		supportLabel.setFont(new Font("Sitka Text", Font.PLAIN, 24));
		supportLabel.setBounds(10, 11, 169, 31);
		add(supportLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 127, 80));
		separator.setBounds(0, 40, 192, 4);
		add(separator);
		
		JLabel question3Label = new JLabel("How do I know if my reservations have actually been made?");
		question3Label.setForeground(new Color(0, 139, 139));
		question3Label.setFont(new Font("Arial", Font.BOLD, 17));
		question3Label.setBounds(165, 395, 492, 27);
		add(question3Label);
		
		question3Text = new JTextField();
		question3Text.setText("Once you book a flight ticket it will appear in the flight history in your account.");
		question3Text.setFont(new Font("Arial", Font.BOLD, 13));
		question3Text.setEditable(false);
		question3Text.setColumns(10);
		question3Text.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 160, 122)));
		question3Text.setBackground(new Color(255, 250, 250));
		question3Text.setBounds(165, 433, 739, 52);
		add(question3Text);
		
		question6Text = new JTextField();
		question6Text.setText("Yes, you can pay, with enough points, with your digital wallet that was created when you registered in this app.");
		question6Text.setFont(new Font("Arial", Font.BOLD, 13));
		question6Text.setColumns(10);
		question6Text.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 160, 122)));
		question6Text.setBackground(new Color(255, 250, 250));
		question6Text.setBounds(165, 733, 739, 52);
		add(question6Text);
		
		JLabel question6Label = new JLabel("Can I make a reservation without a credit card?");
		question6Label.setForeground(new Color(0, 139, 139));
		question6Label.setFont(new Font("Arial", Font.BOLD, 17));
		question6Label.setBounds(165, 695, 492, 27);
		add(question6Label);
		
		question5Text = new JTextField();
		question5Text.setText("All reservations have free cancellation.");
		question5Text.setFont(new Font("Arial", Font.BOLD, 13));
		question5Text.setEditable(false);
		question5Text.setColumns(10);
		question5Text.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 160, 122)));
		question5Text.setBackground(new Color(255, 250, 250));
		question5Text.setBounds(165, 632, 739, 52);
		add(question5Text);
		
		JLabel question5Label = new JLabel("If I need to cancel my reservation, will I pay any fees?");
		question5Label.setForeground(new Color(0, 139, 139));
		question5Label.setFont(new Font("Arial", Font.BOLD, 17));
		question5Label.setBounds(165, 594, 492, 27);
		add(question5Label);
		
		question4Text = new JTextField();
		question4Text.setText("Yes, in your account you can select the reservation you want to cancel.");
		question4Text.setFont(new Font("Arial", Font.BOLD, 13));
		question4Text.setEditable(false);
		question4Text.setColumns(10);
		question4Text.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 160, 122)));
		question4Text.setBackground(new Color(255, 250, 250));
		question4Text.setBounds(165, 531, 739, 52);
		add(question4Text);
		
		JLabel question4Label = new JLabel("May I cancel my reservation?");
		question4Label.setForeground(new Color(0, 139, 139));
		question4Label.setFont(new Font("Arial", Font.BOLD, 17));
		question4Label.setBounds(165, 496, 492, 27);
		add(question4Label);
		
		JLabel reservationsLabel = new JLabel("Reservations");
		reservationsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		reservationsLabel.setForeground(new Color(255, 69, 0));
		reservationsLabel.setFont(new Font("Sitka Text", Font.PLAIN, 24));
		reservationsLabel.setBounds(63, 353, 169, 31);
		add(reservationsLabel);
		
		JLabel digitalLabel = new JLabel("Digital Wallet");
		digitalLabel.setHorizontalAlignment(SwingConstants.LEFT);
		digitalLabel.setForeground(new Color(255, 69, 0));
		digitalLabel.setFont(new Font("Sitka Text", Font.PLAIN, 24));
		digitalLabel.setBounds(63, 69, 169, 31);
		add(digitalLabel);
		
		JLabel question1Label = new JLabel("How can I get points for the digital wallet?");
		question1Label.setForeground(new Color(0, 139, 139));
		question1Label.setFont(new Font("Arial", Font.BOLD, 17));
		question1Label.setBounds(165, 111, 492, 27);
		add(question1Label);
		
		question1Text3 = new JTextField();
		question1Text3.setText("another flight ticket.");
		question1Text3.setToolTipText("");
		question1Text3.setHorizontalAlignment(SwingConstants.LEFT);
		question1Text3.setFont(new Font("Arial", Font.BOLD, 13));
		question1Text3.setEditable(false);
		question1Text3.setColumns(10);
		question1Text3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 160, 122)));
		question1Text3.setBackground(new Color(255, 250, 250));
		question1Text3.setBounds(165, 202, 739, 31);
		add(question1Text3);
		
		JLabel question2label = new JLabel("How can I see how many points do I have in my digital wallet?");
		question2label.setForeground(new Color(0, 139, 139));
		question2label.setFont(new Font("Arial", Font.BOLD, 17));
		question2label.setBounds(165, 244, 492, 27);
		add(question2label);
		
		question2Text = new JTextField();
		question2Text.setText("You can see how many points you have in your account page.");
		question2Text.setFont(new Font("Arial", Font.BOLD, 13));
		question2Text.setEditable(false);
		question2Text.setColumns(10);
		question2Text.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 160, 122)));
		question2Text.setBackground(new Color(255, 250, 250));
		question2Text.setBounds(165, 279, 739, 52);
		add(question2Text);
		
		question1Text2 = new JTextField();
		question1Text2.setText("That is, whatever you spend on a ticket, you will have the value converted into points to later use to buy ");
		question1Text2.setToolTipText("");
		question1Text2.setHorizontalAlignment(SwingConstants.LEFT);
		question1Text2.setFont(new Font("Arial", Font.BOLD, 13));
		question1Text2.setEditable(false);
		question1Text2.setColumns(10);
		question1Text2.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 160, 122)));
		question1Text2.setBackground(new Color(255, 250, 250));
		question1Text2.setBounds(165, 174, 739, 31);
		add(question1Text2);
		
		question1Text1 = new JTextField();
		question1Text1.setText("You can earn points by purchasing tickets, with the ratio between price to points being one to one. ");
		question1Text1.setToolTipText("");
		question1Text1.setHorizontalAlignment(SwingConstants.LEFT);
		question1Text1.setFont(new Font("Arial", Font.BOLD, 13));
		question1Text1.setEditable(false);
		question1Text1.setColumns(10);
		question1Text1.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 160, 122)));
		question1Text1.setBackground(new Color(255, 250, 250));
		question1Text1.setBounds(165, 149, 739, 31);
		add(question1Text1);
		
		JLabel ContactsLabel = new JLabel("Contacts:");
		ContactsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		ContactsLabel.setForeground(new Color(255, 69, 0));
		ContactsLabel.setFont(new Font("Sitka Text", Font.PLAIN, 24));
		ContactsLabel.setBounds(1081, 670, 169, 31);
		add(ContactsLabel);
		
		phoneText = new JTextField();
		phoneText.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(255, 160, 122)));
		phoneText.setBackground(new Color(255, 250, 250));
		phoneText.setFont(new Font("Arial", Font.BOLD, 12));
		phoneText.setText("16402\r\n");
		phoneText.setBounds(1081, 712, 151, 31);
		add(phoneText);
		phoneText.setColumns(10);
		
		adminMailText = new JTextField();
		adminMailText.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(255, 160, 122)));
		adminMailText.setBackground(new Color(255, 250, 250));
		adminMailText.setFont(new Font("Arial", Font.BOLD, 12));
		adminMailText.setText("admin4JLFY@gmail.com\r\n");
		adminMailText.setColumns(10);
		adminMailText.setBounds(1081, 754, 151, 31);
		add(adminMailText);
	}

}
