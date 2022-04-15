package dkeep.gui;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.DateModel;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.Properties;
import java.awt.Color;
import javax.swing.JTextField;

import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import dkeep.logic.Flight;
import dkeep.logic.Ticket;
import dkeep.logic.User;
import dkeep.logic.Wallet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;


public class ManageFlightsPanel extends JPanel {
	private JTable table;
	DefaultTableModel model;
	private JTextField textFlight;
	
	private Image img_username= new ImageIcon(FrameLogin.class.getResource("res/user.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_email= new ImageIcon(FrameLogin.class.getResource("res/email.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_contact= new ImageIcon(FrameLogin.class.getResource("res/contact.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	
	UtilDateModel model1 = new UtilDateModel();
	Properties p = new Properties();
	JDatePanelImpl datePanelImpl = new JDatePanelImpl((DateModel) model1, (Properties) p);
	JDatePickerImpl flightDate = new JDatePickerImpl((JDatePanelImpl) datePanelImpl, new DateComponentFormatter());
	private JTextField textSource;
	private JTextField textDestination;
	private JTextField textArrival_time;
	private JTextField textPrice;
	private JTextField textCompany;
	private JTextField textDeparture_time;
	private JTextField usernameText;
	private JTextField emailText;
	private JTextField contactText;
	
	User user;
	final Object[] row = new Object[8];
	
	JButton btnAddButton = new JButton("ADD");
	JButton btnSearch = new JButton("SEARCH");
	JButton btnDelete = new JButton("DELETE");
	JButton btnUpdate = new JButton("UPDATE");
	/**
	 * Create the panel.
	 */
	public ManageFlightsPanel() {
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 127, 80), 2));
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 192, 819);
		add(panel);
		panel.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setForeground(new Color(255, 250, 250));
		usernameLabel.setFont(new Font("Arial", Font.BOLD, 12));
		usernameLabel.setBounds(10, 104, 82, 14);
		panel.add(usernameLabel);
		
		usernameText = new JTextField();
		usernameText.setEditable(false);
		usernameText.setColumns(10);
		usernameText.setBounds(10, 129, 169, 20);
		panel.add(usernameText);
		
		JLabel IconUserLabel = new JLabel("");
		IconUserLabel.setBounds(148, 87, 31, 31);
		panel.add(IconUserLabel);
		IconUserLabel.setBackground(new Color(0, 0, 0));
		IconUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconUserLabel.setIcon(new ImageIcon(img_username));
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setForeground(new Color(255, 250, 250));
		emailLabel.setFont(new Font("Arial", Font.BOLD, 12));
		emailLabel.setBounds(10, 177, 82, 14);
		panel.add(emailLabel);
		
		emailText = new JTextField();
		emailText.setEditable(false);
		emailText.setColumns(10);
		emailText.setBounds(10, 202, 169, 20);
		panel.add(emailText);
		
		JLabel IconEmailLabel = new JLabel("");
		IconEmailLabel.setBounds(139, 167, 31, 31);
		panel.add(IconEmailLabel);
		IconEmailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconEmailLabel.setIcon(new ImageIcon(img_email));
		
		JLabel contactLabel = new JLabel("Contact n\u00BA");
		contactLabel.setForeground(new Color(255, 250, 250));
		contactLabel.setFont(new Font("Arial", Font.BOLD, 12));
		contactLabel.setBounds(10, 250, 82, 14);
		panel.add(contactLabel);
		
		contactText = new JTextField();
		contactText.setEditable(false);
		contactText.setColumns(10);
		contactText.setBounds(10, 275, 169, 20);
		panel.add(contactText);
		
		JLabel IconContactLabel = new JLabel("");
		IconContactLabel.setBounds(139, 242, 31, 31);
		panel.add(IconContactLabel);
		IconContactLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconContactLabel.setIcon(new ImageIcon(img_contact));
		
		
		JLabel manageLabel = new JLabel("Management Of Flights");
		manageLabel.setHorizontalAlignment(SwingConstants.LEFT);
		manageLabel.setForeground(new Color(0, 139, 139));
		manageLabel.setFont(new Font("Sitka Text", Font.PLAIN, 24));
		manageLabel.setBounds(215, 11, 272, 31);
		add(manageLabel);
		
		JSeparator separator2 = new JSeparator();
		separator2.setForeground(new Color(255, 127, 80));
		separator2.setBounds(215, 40, 304, 2);
		add(separator2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 139, 139)));
		scrollPane.setForeground(new Color(0, 128, 128));
		scrollPane.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setBackground(new Color(255, 250, 250));
		scrollPane.setBounds(235, 445, 991, 321);
		scrollPane.getViewport().setBackground(new Color(255, 250, 250));
		add(scrollPane);
		
		table = new JTable();
		table.setGridColor(new Color(255, 160, 122));
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Arial", Font.PLAIN, 11));
		table.setBackground(new Color(255, 250, 250));
		model=new DefaultTableModel();
		Object[] column = {"Flight ID", "Source", "Destination", "Date", "Departure Time", "Arrival Time", "Price", "Company"};
		//Object[] row= new Object[8];
		model.setColumnIdentifiers(column);
		
		table.setModel(model);
		table.setGridColor(new Color(255, 160, 122));
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		JLabel flightLabel = new JLabel("Flight Details");
		flightLabel.setHorizontalAlignment(SwingConstants.LEFT);
		flightLabel.setForeground(new Color(255, 69, 0));
		flightLabel.setFont(new Font("Sitka Text", Font.PLAIN, 24));
		flightLabel.setBounds(235, 53, 169, 31);
		add(flightLabel);
		
		JLabel FlightIDLabel = new JLabel("Flight ID");
		FlightIDLabel.setForeground(new Color(0, 0, 102));
		FlightIDLabel.setFont(new Font("Arial", Font.BOLD, 12));
		FlightIDLabel.setBounds(416, 104, 46, 14);
		add(FlightIDLabel);
		
		textFlight = new JTextField();
		textFlight.setFont(new Font("Arial", Font.PLAIN, 11));
		textFlight.setColumns(10);
		textFlight.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 102)));
		textFlight.setBackground(new Color(255, 250, 250));
		textFlight.setBounds(416, 129, 132, 20);
		add(textFlight);
		
		//UtilDateModel model = new UtilDateModel();
		model1.setDate(2022, 1, 1);
		//Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		//JDatePanelImpl datePanelImpl = new JDatePanelImpl((DateModel) model, (Properties) p);
		datePanelImpl.setForeground(new Color(51, 204, 255));
		datePanelImpl.setShowYearButtons(true);
		flightDate.getJFormattedTextField().setBackground(new Color(255, 250, 250));
		flightDate.getJFormattedTextField().setFont(new Font("Arial", Font.PLAIN, 11));
		flightDate.setForeground(new Color(0, 139, 139));
		flightDate.setBackground(new Color(255, 250, 250));
		//datePanelImpl.setBounds(2, 64, 90, 21);
		//JDatePickerImpl departureDate = new JDatePickerImpl((JDatePanelImpl) datePanelImpl, new DateComponentFormatter());
		flightDate.setBounds(416, 332, 132, 20);
		this.add(flightDate);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setForeground(new Color(0, 0, 102));
		lblSource.setFont(new Font("Arial", Font.BOLD, 12));
		lblSource.setBounds(416, 177, 46, 14);
		add(lblSource);
		
		textSource = new JTextField();
		textSource.setFont(new Font("Arial", Font.PLAIN, 11));
		textSource.setColumns(10);
		textSource.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 102)));
		textSource.setBackground(new Color(255, 250, 250));
		textSource.setBounds(416, 202, 132, 20);
		add(textSource);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setForeground(new Color(0, 0, 102));
		lblDestination.setFont(new Font("Arial", Font.BOLD, 12));
		lblDestination.setBounds(416, 240, 71, 14);
		add(lblDestination);
		
		textDestination = new JTextField();
		textDestination.setFont(new Font("Arial", Font.PLAIN, 11));
		textDestination.setColumns(10);
		textDestination.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 102)));
		textDestination.setBackground(new Color(255, 250, 250));
		textDestination.setBounds(416, 259, 132, 20);
		add(textDestination);
		
		JLabel FlightIDLabel_1_1 = new JLabel("Date");
		FlightIDLabel_1_1.setForeground(new Color(0, 0, 102));
		FlightIDLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		FlightIDLabel_1_1.setBounds(416, 307, 46, 14);
		add(FlightIDLabel_1_1);
		
		JLabel lblArrivalTime = new JLabel("Arrival Time");
		lblArrivalTime.setForeground(new Color(0, 0, 102));
		lblArrivalTime.setFont(new Font("Arial", Font.BOLD, 12));
		lblArrivalTime.setBounds(690, 177, 79, 14);
		add(lblArrivalTime);
		
		textArrival_time = new JTextField();
		textArrival_time.setFont(new Font("Arial", Font.PLAIN, 11));
		textArrival_time.setColumns(10);
		textArrival_time.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 102)));
		textArrival_time.setBackground(new Color(255, 250, 250));
		textArrival_time.setBounds(690, 202, 132, 20);
		add(textArrival_time);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(0, 0, 102));
		lblPrice.setFont(new Font("Arial", Font.BOLD, 12));
		lblPrice.setBounds(690, 240, 71, 14);
		add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setFont(new Font("Arial", Font.PLAIN, 11));
		textPrice.setColumns(10);
		textPrice.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 102)));
		textPrice.setBackground(new Color(255, 250, 250));
		textPrice.setBounds(690, 259, 132, 20);
		add(textPrice);
		
		textCompany = new JTextField();
		textCompany.setFont(new Font("Arial", Font.PLAIN, 11));
		textCompany.setColumns(10);
		textCompany.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 102)));
		textCompany.setBackground(new Color(255, 250, 250));
		textCompany.setBounds(690, 332, 132, 20);
		add(textCompany);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setForeground(new Color(0, 0, 102));
		lblCompany.setFont(new Font("Arial", Font.BOLD, 12));
		lblCompany.setBounds(690, 307, 71, 14);
		add(lblCompany);
		
		
		
		btnAddButton.setForeground(new Color(255, 250, 250));
		btnAddButton.setBackground(new Color(0, 139, 139));
		btnAddButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnAddButton.setBounds(891, 186, 141, 46);
		add(btnAddButton);
		
		
		btnDelete.setBackground(new Color(0, 139, 139));
		btnDelete.setForeground(new Color(255, 250, 250));
		btnDelete.setFont(new Font("Arial", Font.BOLD, 13));
		btnDelete.setBounds(891, 265, 141, 46);
		add(btnDelete);
		
		
		btnUpdate.setBackground(new Color(0, 139, 139));
		btnUpdate.setForeground(new Color(255, 250, 250));
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 13));
		btnUpdate.setBounds(891, 348, 141, 46);
		add(btnUpdate);
		
		JLabel lblDepartureTime = new JLabel("Departure Time");
		lblDepartureTime.setForeground(new Color(0, 0, 102));
		lblDepartureTime.setFont(new Font("Arial", Font.BOLD, 12));
		lblDepartureTime.setBounds(690, 104, 110, 14);
		add(lblDepartureTime);
		
		textDeparture_time = new JTextField();
		textDeparture_time.setFont(new Font("Arial", Font.PLAIN, 11));
		textDeparture_time.setColumns(10);
		textDeparture_time.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 102)));
		textDeparture_time.setBackground(new Color(255, 250, 250));
		textDeparture_time.setBounds(690, 129, 132, 20);
		add(textDeparture_time);
		
		
		btnSearch.setForeground(new Color(255, 250, 250));
		btnSearch.setFont(new Font("Arial", Font.BOLD, 13));
		btnSearch.setBackground(new Color(0, 139, 139));
		btnSearch.setBounds(891, 107, 141, 46);
		add(btnSearch);
		//System.out.println(model);
		
		Actions();
	}
	
	
	public void Actions() {
		
		
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(model.getRowCount()!=0) {
	        		model.removeRow(0);
	        		//System.out.println("Removed");
	        	}
				
				
				String [][] flights=Flight.Query_flight_admin(textSource.getText(), textDestination.getText(), String.valueOf(LocalDate.of(model1.getYear(), model1.getMonth()+1, model1.getDay())));
				if(flights==null) {
            		JOptionPane.showMessageDialog(null, "No Flights available on the selected dates");
            	}
            	int i=0;
            	while(flights[i][0]!=null) {
            		System.out.println(flights[i][0]);
            		row[0]=flights[i][0];
            		row[1]=flights[i][1];
            		row[2]=flights[i][2];
            		row[3]=flights[i][3];
            		row[4]=flights[i][4];
            		row[5]=flights[i][5];
            		row[6]=flights[i][6];
            		row[7]=flights[i][7];
            		model.addRow(row);
                	i++;
            	}
			}
		});
		
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x=table.getSelectedRow();
				textFlight.setText(model.getValueAt(x, 0).toString());
				textDeparture_time.setText(model.getValueAt(x, 4).toString());
				textArrival_time.setText(model.getValueAt(x, 5).toString());	
				textPrice.setText(model.getValueAt(x, 6).toString());
				textCompany.setText(model.getValueAt(x, 7).toString());
				
			}	
		});
		
		
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFlight.getText().equals("") || textDeparture_time.getText().equals("") || textArrival_time.getText().equals("") || textPrice.getText().equals("") || textCompany.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Fill all text fields");
				}
				
				else {
					Flight.Insert_Flight_single(Integer.parseInt(textFlight.getText()), textSource.getText(), textDestination.getText(), LocalTime.parse(textDeparture_time.getText()), LocalTime.parse(textArrival_time.getText()), Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth()+1,model1.getDay())), Integer.parseInt(textPrice.getText()), textCompany.getText());
					
					while(model.getRowCount()!=0) {
		        		model.removeRow(0);
		        		//System.out.println("Removed");
		        	}
					
					
					String [][] flights=Flight.Query_flight_admin(textSource.getText(), textDestination.getText(), String.valueOf(LocalDate.of(model1.getYear(), model1.getMonth()+1, model1.getDay())));
					if(flights==null) {
	            		//JOptionPane.showMessageDialog(null, "No Flights available on the selected dates");
	            	}
	            	int i=0;
	            	while(flights[i][0]!=null) {
	            		System.out.println(flights[i][0]);
	            		row[0]=flights[i][0];
	            		row[1]=flights[i][1];
	            		row[2]=flights[i][2];
	            		row[3]=flights[i][3];
	            		row[4]=flights[i][4];
	            		row[5]=flights[i][5];
	            		row[6]=flights[i][6];
	            		row[7]=flights[i][7];
	            		model.addRow(row);
	                	i++;
	            	}
	            	
	            	textFlight.setText("");
					textDeparture_time.setText("");
					textArrival_time.setText("");	
					textPrice.setText("");
					textCompany.setText("");
				}
				
			
			}
		});
	
		
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFlight.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Select Flight from the table");
				}
				
				else {
					Flight.Delete_single_flight(Integer.parseInt(textFlight.getText()));
					
					while(model.getRowCount()!=0) {
		        		model.removeRow(0);
		        		//System.out.println("Removed");
		        	}
					
					
					String [][] flights=Flight.Query_flight_admin(textSource.getText(), textDestination.getText(), String.valueOf(LocalDate.of(model1.getYear(), model1.getMonth()+1, model1.getDay())));
					if(flights==null) {
	            		//JOptionPane.showMessageDialog(null, "No Flights available on the selected dates");
	            	}
	            	int i=0;
	            	while(flights[i][0]!=null) {
	            		System.out.println(flights[i][0]);
	            		row[0]=flights[i][0];
	            		row[1]=flights[i][1];
	            		row[2]=flights[i][2];
	            		row[3]=flights[i][3];
	            		row[4]=flights[i][4];
	            		row[5]=flights[i][5];
	            		row[6]=flights[i][6];
	            		row[7]=flights[i][7];
	            		model.addRow(row);
	                	i++;
	            	}
	            	
	            	textFlight.setText("");
					textDeparture_time.setText("");
					textArrival_time.setText("");	
					textPrice.setText("");
					textCompany.setText("");
				}
				
			}
		});
		
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFlight.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Select Flight from the table");
				}
				
				else {
					Flight.Update_Flight(Integer.parseInt(textFlight.getText()), textSource.getText(), textDestination.getText(), LocalTime.parse(textDeparture_time.getText()), LocalTime.parse(textArrival_time.getText()), Date.valueOf(LocalDate.of(model1.getYear(), model1.getMonth()+1, model1.getDay())), Integer.parseInt(textPrice.getText()), textCompany.getText());
					
					while(model.getRowCount()!=0) {
		        		model.removeRow(0);
		        		//System.out.println("Removed");
		        	}
					
					String [][] flights=Flight.Query_flight_admin(textSource.getText(), textDestination.getText(), String.valueOf(LocalDate.of(model1.getYear(), model1.getMonth()+1, model1.getDay())));
					if(flights==null) {
	            		//JOptionPane.showMessageDialog(null, "No Flights available on the selected dates");
	            	}
	            	int i=0;
	            	while(flights[i][0]!=null) {
	            		System.out.println(flights[i][0]);
	            		row[0]=flights[i][0];
	            		row[1]=flights[i][1];
	            		row[2]=flights[i][2];
	            		row[3]=flights[i][3];
	            		row[4]=flights[i][4];
	            		row[5]=flights[i][5];
	            		row[6]=flights[i][6];
	            		row[7]=flights[i][7];
	            		model.addRow(row);
	                	i++;
	            	}
	            	
	            	textFlight.setText("");
					textDeparture_time.setText("");
					textArrival_time.setText("");	
					textPrice.setText("");
					textCompany.setText("");
				}
				
				
			}
		});
		
		
		
	}
	
	public void setUser(User user) {
		this.user=user;
//set user  info
		System.out.println("sete" + user.get_email());
		usernameText.setText(user.get_username());
		emailText.setText(user.get_email());
		contactText.setText(user.get_contact());
			
	}
}
