package dkeep.gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Choice;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dkeep.logic.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserAccountPanel extends JPanel {
	private JTextField usernameText;
	private JTextField emailText;
	private JTextField contactText;
	private JTextField passportText;
	private Image img_username= new ImageIcon(FrameLogin.class.getResource("res/user.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_email= new ImageIcon(FrameLogin.class.getResource("res/email.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_contact= new ImageIcon(FrameLogin.class.getResource("res/contact.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_passport= new ImageIcon(FrameLogin.class.getResource("res/passport.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private JTextField walletText;
	private JTable table;
	DefaultTableModel model;

	User user;
	/**
	 * Create the panel.
	 */
	public UserAccountPanel() {
		setBorder(new MatteBorder(0, 2, 2, 0, (Color) new Color(255, 127, 80)));
		setBackground(new Color(255, 250, 250));
		setBounds(0,0,1260,819);
		setLayout(null);
		
		JLabel lblHelloUser = new JLabel("My Account");
		lblHelloUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblHelloUser.setForeground(new Color(255, 250, 250));
		lblHelloUser.setFont(new Font("Sitka Text", Font.PLAIN, 24));
		lblHelloUser.setBounds(10, 11, 169, 31);
		add(lblHelloUser);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 127, 80));
		separator.setBounds(0, 40, 192, 4);
		add(separator);
		
		usernameText = new JTextField();
		usernameText.setBounds(10, 128, 169, 20);
		add(usernameText);
		usernameText.setColumns(10);
		
		
		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(10, 209, 169, 20);
		add(emailText);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setForeground(new Color(255, 250, 250));
		usernameLabel.setFont(new Font("Arial", Font.BOLD, 12));
		usernameLabel.setBounds(10, 103, 82, 14);
		add(usernameLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setForeground(new Color(255, 250, 250));
		emailLabel.setFont(new Font("Arial", Font.BOLD, 12));
		emailLabel.setBounds(10, 184, 82, 14);
		add(emailLabel);
		
		JLabel contactLabel = new JLabel("Contact n\u00BA");
		contactLabel.setForeground(new Color(255, 250, 250));
		contactLabel.setFont(new Font("Arial", Font.BOLD, 12));
		contactLabel.setBounds(10, 259, 82, 14);
		add(contactLabel);
		
		contactText = new JTextField();
		contactText.setColumns(10);
		contactText.setBounds(10, 284, 169, 20);
		add(contactText);
		
		JLabel passportLabel = new JLabel("Passport ID");
		passportLabel.setForeground(new Color(255, 250, 250));
		passportLabel.setFont(new Font("Arial", Font.BOLD, 12));
		passportLabel.setBounds(10, 340, 82, 14);
		add(passportLabel);
		
		passportText = new JTextField();
		passportText.setColumns(10);
		passportText.setBounds(10, 365, 169, 20);
		add(passportText);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 127, 80), 2));
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 192, 819);
		add(panel);
		panel.setLayout(null);
		
		JLabel IconPassportLabel = new JLabel("");
		IconPassportLabel.setBounds(139, 323, 31, 31);
		panel.add(IconPassportLabel);
		IconPassportLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconPassportLabel.setIcon(new ImageIcon(img_passport));
		
		JLabel IconContactLabel = new JLabel("");
		IconContactLabel.setBounds(139, 242, 31, 31);
		panel.add(IconContactLabel);
		IconContactLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconContactLabel.setIcon(new ImageIcon(img_contact));
		
		JLabel IconEmailLabel = new JLabel("");
		IconEmailLabel.setBounds(139, 167, 31, 31);
		panel.add(IconEmailLabel);
		IconEmailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconEmailLabel.setIcon(new ImageIcon(img_email));
		
		JLabel IconUserLabel = new JLabel("");
		IconUserLabel.setBounds(139, 86, 31, 31);
		panel.add(IconUserLabel);
		IconUserLabel.setBackground(new Color(0, 0, 0));
		IconUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconUserLabel.setIcon(new ImageIcon(img_username));
		
		JLabel lblNewLabel = new JLabel("Wallet Points");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(224, 75, 82, 14);
		add(lblNewLabel);
		
		walletText = new JTextField();
		walletText.setBounds(310, 72, 92, 20);
		add(walletText);
		walletText.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 139, 139)));
		scrollPane.setForeground(new Color(0, 128, 128));
		scrollPane.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setBackground(new Color(255, 250, 250));
		scrollPane.setBounds(235, 211, 991, 266);
		scrollPane.getViewport().setBackground(new Color(255, 250, 250));
		add(scrollPane);
		
		table = new JTable();
		table.setGridColor(new Color(255, 160, 122));
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Arial", Font.PLAIN, 11));
		table.setBackground(new Color(255, 250, 250));
		model=new DefaultTableModel();
		Object[] column= {"Ticket ID","Flight ID","Source","Destination","Date","Departure Time","Arrival Time","Price","Company"};
		Object[] row= new Object[9];
		model.setColumnIdentifiers(column);
		
		table.setModel(model);
		table.setGridColor(new Color(255, 160, 122));
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		JButton cancelTickButton = new JButton("CANCEL TICKET");
		cancelTickButton.setBackground(new Color(0, 139, 139));
		cancelTickButton.setForeground(new Color(255, 250, 250));
		cancelTickButton.setFont(new Font("Arial", Font.BOLD, 13));
		cancelTickButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int o=table.getSelectedRow();
				int tick_id=(int) table.getValueAt(o, 0);
				Ticket.Delete_single_ticket(tick_id);
				if(o>=0) {
					model.removeRow(o);
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select a row first");
				}			
			}
		});
		cancelTickButton.setBounds(611, 548, 221, 63);
		add(cancelTickButton);
		
		
		
	}

	public void setUser(User user) {
		this.user=user;
//set user  info
		usernameText.setText(user.get_username());
		emailText.setText(user.get_email());
		contactText.setText(user.get_contact());
		passportText.setText(user.get_passport());
//set wallet info
		Integer points=Wallet.Query_wallet_points(user.get_username());
		walletText.setText(points.toString());
//if normal user set table
		if(!(user.get_username().equals("admin"))) {
			set_table();
		}
	}
	
	public void set_table() {
		Object[] row1= new Object[9];
		while(model.getRowCount()!=0) {
    		model.removeRow(0);
    		//System.out.println("Removed");
    	}
		
		int [][] ids=Ticket.Query_flights(user.get_username());
		if(ids!=null) {
			int i=0;
			//System.out.println("Flights"+ ids[1]+ ids[2]+ ids[4]);
			String[][] list_flights=new String[10][10];
			while(ids[i][0]!=0) {
				list_flights=Flight.Query_flight_id(ids[i][1]);
				int j=0;
				while(list_flights[j][0]!=null) {
					row1[0]=ids[i][0];
					row1[1]=list_flights[j][0];
	        		row1[2]=list_flights[j][1];
	        		row1[3]=list_flights[j][2];
	        		row1[4]=list_flights[j][3];
	        		row1[5]=list_flights[j][4];
	        		row1[6]=list_flights[j][5];
	        		row1[7]=list_flights[j][6];
	        		row1[8]=list_flights[j][7];
	        		model.addRow(row1);
	        		j++;
				}		
				i++;
			}
		}
	}
}
