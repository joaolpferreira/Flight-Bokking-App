package dkeep.gui;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import dkeep.logic.*;

import javax.swing.DefaultComboBoxModel;
import java.awt.CardLayout;

public class BookTicketPanel extends JPanel {
	private JTextField textSource;
	private JTextField textDestination;
	private JTextField textTickNum1;
	private JTextField textTickFlight1;
	private JTextField textTickCompany1;
	private JTextField textTickSource1;
	private JTextField textTickDestination1;
	private JTextField textTickDate1;
	private JTextField textTickDepartureT1;
	private JTextField textTickArrivalT1;
	private JTextField textTickPrice1;
	private JTextField textTotalPrice;
	private JTextField textTickPrice1_1;
	JComboBox comboClass = new JComboBox();
	JComboBox comboOneWayReturn = new JComboBox();
	JSpinner spinTickNumber1 = new JSpinner();
	JSpinner spinTickNumber1_1 = new JSpinner();
	JButton buttonSearch = new JButton("Search");
	JButton btnBookTickets= new JButton("Book Tickets");
	JButton btnAddFlight= new JButton("Add Flight");
	JButton btnAddReturn= new JButton("Add Return");
	JLabel labelTickSeats1 = new JLabel("Seats:");
	JLabel labelTickSeats1_1 = new JLabel("Seats:");
	JLabel labelTickForm1_1 = new JLabel("Ticket Form");
	JPanel TicketForm1_1 = new JPanel();
	
	UtilDateModel model = new UtilDateModel();
	Properties p = new Properties();
	JDatePanelImpl datePanelImpl = new JDatePanelImpl((DateModel) model, (Properties) p);
	JDatePickerImpl departureDate = new JDatePickerImpl((JDatePanelImpl) datePanelImpl, new DateComponentFormatter());
	
	UtilDateModel model1 = new UtilDateModel();
	Properties p1 = new Properties();
	JDatePanelImpl datePanelImpl1 = new JDatePanelImpl((DateModel) model1, (Properties) p1);
	JDatePickerImpl returnDate = new JDatePickerImpl((JDatePanelImpl) datePanelImpl1, new DateComponentFormatter());
	DefaultTableModel model2;
	JTable table = new JTable();
	private JTextField textTickArrivalT1_1;
	private JTextField textTickDepartureT1_1;
	private JTextField textTickDate1_1;
	private JTextField textTickDestination1_1;
	private JTextField textTickSource1_1;
	private JTextField textTickCompany1_1;
	private JTextField textTickFlight1_1;
	private JTextField textTickNum1_1;
	
	int empty_row=0;
	
	final Object[] row = new Object[8];
	
	WalletPaymentPanel walletpaymentPanel;
	User user;
	/**
	 * Create the panel.
	 */
	public BookTicketPanel() {
		setBackground(new Color(255, 250, 250));
		setBounds(0,0,1260,819);
		setLayout(null);
		comboOneWayReturn.setForeground(new Color(0, 0, 0));
		comboOneWayReturn.setFont(new Font("Arial", Font.BOLD, 11));
		
		comboOneWayReturn.setModel(new DefaultComboBoxModel(new String[] {"One Way", "Return"}));
		comboOneWayReturn.setSelectedIndex(0);
		comboOneWayReturn.setBackground(new Color(255, 250, 250));
		comboOneWayReturn.setBounds(10, 36, 98, 22);
		add(comboOneWayReturn);
		comboClass.setFont(new Font("Arial", Font.BOLD, 11));
		
		
		comboClass.setModel(new DefaultComboBoxModel(new String[] {"Class", "Economy", "Business", "First"}));
		comboClass.setSelectedIndex(0);
		comboClass.setBackground(new Color(255, 250, 250));
		comboClass.setBounds(135, 36, 98, 22);
		add(comboClass);
		
		textSource = new JTextField();
		textSource.setFont(new Font("Arial", Font.PLAIN, 11));
		textSource.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 102)));
		textSource.setBackground(new Color(255, 250, 250));
		textSource.setBounds(10, 90, 115, 20);
		add(textSource);
		textSource.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Source");
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 77, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Destination");
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(135, 77, 74, 14);
		add(lblNewLabel_1);
		
		textDestination = new JTextField();
		textDestination.setFont(new Font("Arial", Font.PLAIN, 11));
		textDestination.setColumns(10);
		textDestination.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 102)));
		textDestination.setBackground(new Color(255, 250, 250));
		textDestination.setBounds(135, 90, 115, 20);
		add(textDestination);
		
		//UtilDateModel model = new UtilDateModel();
		model.setDate(2022, 1, 1);
		//Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		//JDatePanelImpl datePanelImpl = new JDatePanelImpl((DateModel) model, (Properties) p);
		datePanelImpl.setForeground(new Color(51, 204, 255));
		datePanelImpl.setShowYearButtons(true);
		departureDate.getJFormattedTextField().setBackground(new Color(255, 250, 250));
		departureDate.getJFormattedTextField().setFont(new Font("Arial", Font.PLAIN, 11));
		departureDate.setForeground(new Color(0, 139, 139));
		departureDate.setBackground(new Color(255, 250, 250));
		//datePanelImpl.setBounds(2, 64, 90, 21);
		//JDatePickerImpl departureDate = new JDatePickerImpl((JDatePanelImpl) datePanelImpl, new DateComponentFormatter());
		departureDate.setBounds(272, 90, 110, 20);
		this.add(departureDate);
		System.out.println(model);
		
		//UtilDateModel model1 = new UtilDateModel();
		LocalDate date_now=LocalDate.now();
		int day=date_now.getDayOfMonth();
		int  month=date_now.getMonthValue();
		int year=date_now.getYear();
		model1.setDate(year, month, day);
		//Properties p1 = new Properties();
		p1.put("text.today", "Today");
		p1.put("text.month", "Month");
		p1.put("text.year", "Year");
		//JDatePanelImpl datePanelImpl1 = new JDatePanelImpl((DateModel) model1, (Properties) p1);
		datePanelImpl1.setForeground(new Color(51, 204, 255));
		datePanelImpl1.setShowYearButtons(true);
		returnDate.getJFormattedTextField().setBackground(new Color(255, 250, 250));
		returnDate.setForeground(new Color(0, 128, 128));
		returnDate.setBackground(new Color(255, 250, 250));
		//JDatePickerImpl returnDate = new JDatePickerImpl((JDatePanelImpl) datePanelImpl1, new DateComponentFormatter());
		returnDate.setBounds(404, 90, 110, 20);
		this.add(returnDate);
		
		JLabel lblNewLabel_1_1 = new JLabel("Departure Date");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(272, 77, 110, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Return Date");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(404, 77, 74, 14);
		add(lblNewLabel_1_1_1);
		System.out.println(model1);
		
		JLabel labelTickForm1 = new JLabel("Ticket Form");
		labelTickForm1.setForeground(new Color(0, 0, 102));
		labelTickForm1.setBounds(930, 11, 92, 17);
		labelTickForm1.setFont(new Font("Arial", Font.BOLD, 14));
		add(labelTickForm1);
		
		JLabel labelTickNum1 = new JLabel("Ticket number:");
		labelTickNum1.setForeground(new Color(0, 0, 102));
		labelTickNum1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickNum1.setBounds(812, 46, 139, 22);
		add(labelTickNum1);
		
		JLabel labelTickFlight1 = new JLabel("Flight ID");
		labelTickFlight1.setForeground(new Color(0, 0, 102));
		labelTickFlight1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickFlight1.setBounds(812, 76, 139, 22);
		add(labelTickFlight1);
		
		JLabel labelTickCompany1 = new JLabel("Company");
		labelTickCompany1.setForeground(new Color(0, 0, 102));
		labelTickCompany1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickCompany1.setBounds(812, 106, 139, 22);
		add(labelTickCompany1);
		
		JLabel labelTickSource1 = new JLabel("Source");
		labelTickSource1.setForeground(new Color(0, 0, 102));
		labelTickSource1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickSource1.setBounds(812, 136, 139, 22);
		add(labelTickSource1);
		
		JLabel labelTickDestination1 = new JLabel("Destination");
		labelTickDestination1.setForeground(new Color(0, 0, 102));
		labelTickDestination1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickDestination1.setBounds(812, 166, 139, 22);
		add(labelTickDestination1);
		
		JLabel labelTickDate1 = new JLabel("Date");
		labelTickDate1.setForeground(new Color(0, 0, 102));
		labelTickDate1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickDate1.setBounds(812, 196, 139, 22);
		add(labelTickDate1);
		
		JLabel labelTickArrivalT1 = new JLabel("Arrival Time:");
		labelTickArrivalT1.setForeground(new Color(0, 0, 102));
		labelTickArrivalT1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickArrivalT1.setBounds(812, 256, 139, 22);
		add(labelTickArrivalT1);
		
		JLabel labelTickDepartureT1 = new JLabel("Departure Time:");
		labelTickDepartureT1.setForeground(new Color(0, 0, 102));
		labelTickDepartureT1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickDepartureT1.setBounds(812, 226, 139, 22);
		add(labelTickDepartureT1);
		
		JLabel labelTickPrice1 = new JLabel("Price:");
		labelTickPrice1.setForeground(new Color(0, 0, 102));
		labelTickPrice1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickPrice1.setBounds(812, 298, 47, 14);
		add(labelTickPrice1);
		spinTickNumber1.setFont(new Font("Arial", Font.PLAIN, 11));
		
		
		spinTickNumber1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		spinTickNumber1.setBounds(150, 604, 30, 20);
		this.add(spinTickNumber1);
		spinTickNumber1_1.setFont(new Font("Arial", Font.PLAIN, 11));
		
		spinTickNumber1_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		spinTickNumber1_1.setBounds(150, 635, 30, 20);
		this.add(spinTickNumber1_1);
		labelTickSeats1.setForeground(new Color(0, 0, 102));
		
		
		labelTickSeats1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickSeats1.setBounds(106, 606, 54, 14);;
		this.add(labelTickSeats1);
		
		textTickNum1 = new JTextField();
		textTickNum1.setBounds(960, 46, 86, 22);
		add(textTickNum1);
		textTickNum1.setColumns(10);
		
		textTickFlight1 = new JTextField();
		textTickFlight1.setBounds(960, 76, 86, 22);
		add(textTickFlight1);
		textTickFlight1.setColumns(10);
		
		textTickCompany1 = new JTextField();
		textTickCompany1.setBounds(960, 106, 86, 22);
		add(textTickCompany1);
		textTickCompany1.setColumns(10);
		
		textTickSource1 = new JTextField();
		textTickSource1.setBounds(960, 136, 86, 22);
		add(textTickSource1);
		textTickSource1.setColumns(10);
		
		textTickDestination1 = new JTextField();
		textTickDestination1.setBounds(960, 166, 86, 22);
		add(textTickDestination1);
		textTickDestination1.setColumns(10);
		
		textTickDate1 = new JTextField();
		textTickDate1.setBounds(960, 196, 86, 22);
		add(textTickDate1);
		textTickDate1.setColumns(10);
		
		textTickDepartureT1 = new JTextField();
		textTickDepartureT1.setBounds(960, 226, 86, 22);
		add(textTickDepartureT1);
		textTickDepartureT1.setColumns(10);
		
		textTickArrivalT1 = new JTextField();
		textTickArrivalT1.setBounds(960, 256, 86, 22);
		add(textTickArrivalT1);
		textTickArrivalT1.setColumns(10);
		
		textTickPrice1 = new JTextField();
		textTickPrice1.setBounds(853, 296, 86, 20);
		add(textTickPrice1);
		textTickPrice1.setColumns(10);
		TicketForm1_1.setBackground(new Color(255, 250, 250));
		
		TicketForm1_1.setLayout(null);
		TicketForm1_1.setBounds(812, 344, 338, 400);
		this.add(TicketForm1_1);
		TicketForm1_1.hide();
		
		JLabel lblTicketFormReturn = new JLabel("Ticket Form Return");
		lblTicketFormReturn.setForeground(new Color(0, 0, 102));
		lblTicketFormReturn.setFont(new Font("Arial", Font.BOLD, 14));
		lblTicketFormReturn.setBounds(98, 5, 140, 17);
		TicketForm1_1.add(lblTicketFormReturn);
		
		JLabel labelTickNum1_1 = new JLabel("Ticket number:");
		labelTickNum1_1.setForeground(new Color(0, 0, 102));
		labelTickNum1_1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickNum1_1.setBounds(10, 40, 139, 22);
		TicketForm1_1.add(labelTickNum1_1);
		
		JLabel labelTickFlight1_1 = new JLabel("Flight ID");
		labelTickFlight1_1.setForeground(new Color(0, 0, 102));
		labelTickFlight1_1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickFlight1_1.setBounds(10, 70, 139, 22);
		TicketForm1_1.add(labelTickFlight1_1);
		
		JLabel labelTickCompany1_1 = new JLabel("Company");
		labelTickCompany1_1.setForeground(new Color(0, 0, 102));
		labelTickCompany1_1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickCompany1_1.setBounds(10, 100, 139, 22);
		TicketForm1_1.add(labelTickCompany1_1);
		
		JLabel labelTickSource1_1 = new JLabel("Source");
		labelTickSource1_1.setForeground(new Color(0, 0, 102));
		labelTickSource1_1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickSource1_1.setBounds(10, 130, 139, 22);
		TicketForm1_1.add(labelTickSource1_1);
		
		JLabel labelTickDestination1_1 = new JLabel("Destination");
		labelTickDestination1_1.setForeground(new Color(0, 0, 102));
		labelTickDestination1_1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickDestination1_1.setBounds(10, 160, 139, 22);
		TicketForm1_1.add(labelTickDestination1_1);
		
		JLabel labelTickDate1_1 = new JLabel("Date");
		labelTickDate1_1.setForeground(new Color(0, 0, 102));
		labelTickDate1_1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickDate1_1.setBounds(10, 190, 139, 22);
		TicketForm1_1.add(labelTickDate1_1);
		
		JLabel labelTickArrivalT1_1 = new JLabel("Arrival Time:");
		labelTickArrivalT1_1.setForeground(new Color(0, 0, 102));
		labelTickArrivalT1_1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickArrivalT1_1.setBounds(10, 250, 139, 22);
		TicketForm1_1.add(labelTickArrivalT1_1);
		
		JLabel labelTickDepartureT1_1 = new JLabel("Departure Time:");
		labelTickDepartureT1_1.setForeground(new Color(0, 0, 102));
		labelTickDepartureT1_1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickDepartureT1_1.setBounds(10, 220, 139, 22);
		TicketForm1_1.add(labelTickDepartureT1_1);
		
		JLabel labelTickPrice1_1 = new JLabel("Price:");
		labelTickPrice1_1.setForeground(new Color(0, 0, 102));
		labelTickPrice1_1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickPrice1_1.setBounds(10, 292, 47, 14);
		TicketForm1_1.add(labelTickPrice1_1);
		
		textTickNum1_1 = new JTextField();
		textTickNum1_1.setColumns(10);
		textTickNum1_1.setBounds(158, 40, 86, 22);
		TicketForm1_1.add(textTickNum1_1);
		
		textTickFlight1_1 = new JTextField();
		textTickFlight1_1.setColumns(10);
		textTickFlight1_1.setBounds(158, 70, 86, 22);
		TicketForm1_1.add(textTickFlight1_1);
		
		textTickCompany1_1 = new JTextField();
		textTickCompany1_1.setColumns(10);
		textTickCompany1_1.setBounds(158, 100, 86, 22);
		TicketForm1_1.add(textTickCompany1_1);
		
		textTickSource1_1 = new JTextField();
		textTickSource1_1.setColumns(10);
		textTickSource1_1.setBounds(158, 130, 86, 22);
		TicketForm1_1.add(textTickSource1_1);
		
		textTickDestination1_1 = new JTextField();
		textTickDestination1_1.setColumns(10);
		textTickDestination1_1.setBounds(158, 160, 86, 22);
		TicketForm1_1.add(textTickDestination1_1);
		
		textTickDate1_1 = new JTextField();
		textTickDate1_1.setColumns(10);
		textTickDate1_1.setBounds(158, 190, 86, 22);
		TicketForm1_1.add(textTickDate1_1);
		
		textTickDepartureT1_1 = new JTextField();
		textTickDepartureT1_1.setColumns(10);
		textTickDepartureT1_1.setBounds(158, 220, 86, 22);
		TicketForm1_1.add(textTickDepartureT1_1);
		
		textTickArrivalT1_1 = new JTextField();
		textTickArrivalT1_1.setColumns(10);
		textTickArrivalT1_1.setBounds(158, 250, 86, 22);
		TicketForm1_1.add(textTickArrivalT1_1);
		
		textTickPrice1_1 = new JTextField();
		textTickPrice1_1.setColumns(10);
		textTickPrice1_1.setBounds(51, 290, 86, 20);
		TicketForm1_1.add(textTickPrice1_1);
		labelTickSeats1_1.setForeground(new Color(0, 0, 102));
		
		
		labelTickSeats1_1.setFont(new Font("Arial", Font.BOLD, 12));
		labelTickSeats1_1.setBounds(106, 635, 54, 14);
		add(labelTickSeats1_1);
		
		JLabel lblTotalPrice = new JLabel("Total Price:");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalPrice.setBounds(825, 772, 75, 14);
		add(lblTotalPrice);
		
		textTotalPrice = new JTextField();
		textTotalPrice.setColumns(10);
		textTotalPrice.setBounds(908, 770, 86, 20);
		add(textTotalPrice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 139, 139)));
		scrollPane.setBounds(10, 229, 734, 215);
		add(scrollPane);
		
		model2=new DefaultTableModel();
		Object[] column = {"Flight ID", "Source", "Destination", "Date", "Departure Time", "Arrival Time", "Price", "Company"};
		//final Object[] row = new Object[8];
		model2.setColumnIdentifiers(column);
		table.setModel(model2);
		scrollPane.setViewportView(table);
		buttonSearch.setForeground(new Color(255, 255, 255));
		buttonSearch.setFont(new Font("Arial", Font.BOLD, 13));
		buttonSearch.setBackground(new Color(0, 139, 139));
		
		buttonSearch.setBounds(575, 68, 115, 42);
		this.add(buttonSearch);
		btnBookTickets.setForeground(new Color(255, 255, 255));
		btnBookTickets.setBackground(new Color(0, 139, 139));
		
		btnBookTickets.setFont(new Font("Arial", Font.BOLD, 13));
		btnBookTickets.setBounds(647, 768, 130, 40);
		this.add(btnBookTickets);
		btnAddFlight.setForeground(new Color(255, 255, 255));
		btnAddFlight.setBackground(new Color(0, 139, 139));
		
		btnAddFlight.setFont(new Font("Arial", Font.BOLD, 13));
		btnAddFlight.setBounds(292, 572, 130, 40);
		this.add(btnAddFlight);
		btnAddReturn.setBackground(new Color(0, 139, 139));
		btnAddReturn.setForeground(new Color(255, 255, 255));
		
		
		btnAddReturn.setFont(new Font("Arial", Font.BOLD, 13));
		btnAddReturn.setBounds(292, 636, 130, 40);
		this.add(btnAddReturn);
		btnAddReturn.hide();
		
		setActionListeners();
	}
	
public void setActionListeners(){
    	
    	
        buttonSearch.addActionListener((e->{    	
        	

        	int i=0;
        	String Class = new String();
        	
        	//Delete Ticket Form1
        	textTickNum1.setText("");
 			textTickFlight1.setText("");
 			textTickCompany1.setText("");
 			textTickSource1.setText("");
 			textTickDestination1.setText("");
 			textTickDate1.setText("");
 			textTickDepartureT1.setText("");
 			textTickArrivalT1.setText("");
 			textTickPrice1.setText("");
 			spinTickNumber1.setValue(1);
 			
 			//Delete Ticket Form1_1
 			textTickNum1_1.setText("");
 			textTickFlight1_1.setText("");
 			textTickCompany1_1.setText("");
 			textTickSource1_1.setText("");
 			textTickDestination1_1.setText("");
 			textTickDate1_1.setText("");
 			textTickDepartureT1_1.setText("");
 			textTickArrivalT1_1.setText("");
 			textTickPrice1_1.setText("");
        	spinTickNumber1_1.setValue(1);
        	
        	//Delete previous search
        	while(model2.getRowCount()!=0) {
        		model2.removeRow(0);
        		System.out.println("Removed");
        	}
        	
        	if(textSource.getText().equals("")) {
        		JOptionPane.showMessageDialog(null, "Source is empty");
        	}
        	else if(textDestination.getText().equals("")) {
        		JOptionPane.showMessageDialog(null, "Destination is empty");
        	}
        	
        	//Check if class is selected
        	else if(comboClass.getSelectedIndex()==0) {
        		JOptionPane.showMessageDialog(null, "Please select Class");	
        	}
        	
        	else if(comboClass.getSelectedIndex()==1) {
    			Class="Economy";
    		}
        	else if(comboClass.getSelectedIndex()==2) {
    			Class="Business";
    		}
        	else if(comboClass.getSelectedIndex()==3) {
    			Class="First";
    		}
    		
        	//checks if it's a one way flight
        	if(comboOneWayReturn.getSelectedIndex()==0) {
        		TicketForm1_1.hide();
        		btnAddReturn.hide();
        		spinTickNumber1_1.hide();
        		labelTickSeats1_1.hide();
        		Date selectedDate1 = Date.valueOf(LocalDate.of(departureDate.getModel().getYear(), departureDate.getModel().getMonth()+1, departureDate.getModel().getDay()));
            	System.out.println(selectedDate1);
            	//if(Date.valueOf(LocalDate.now()).after(selectedDate1)) {
            	//	JOptionPane.showMessageDialog(null, "Please select a date after today");
            	//}
            	//else{
            		String list [][] = Flight.Query_one_way(textSource.getText(), textDestination.getText(), selectedDate1, Class);
            		if(list==null) {
                		JOptionPane.showMessageDialog(null, "No Flights available on the selected dates");
                	}
                	i=0;
                	while(list[i][0]!=null) {
                		System.out.println(list[i][0]);
                		row[0]=list[i][0];
                		row[1]=list[i][1];
                		row[2]=list[i][2];
                		row[3]=list[i][3];
                		row[4]=list[i][4];
                		row[5]=list[i][5];
                		row[6]=list[i][7];
                		row[7]=list[i][8];
                		model2.addRow(row);
                    	i++;
                	}
            	//}
            	
        	}
        	
        	//check if it's a flight with return
        	else if(comboOneWayReturn.getSelectedIndex()==1) {
        		System.out.println(Class);
        		Date selectedDate1 = Date.valueOf(LocalDate.of(departureDate.getModel().getYear(), departureDate.getModel().getMonth()+1, departureDate.getModel().getDay()));
            	System.out.println(selectedDate1);
            	Date selectedDate2 = Date.valueOf(LocalDate.of(returnDate.getModel().getYear(), returnDate.getModel().getMonth()+1, returnDate.getModel().getDay()));
            	//if(Date.valueOf(LocalDate.now()).after(selectedDate1)) {
            	//	JOptionPane.showMessageDialog(null, "Please select a date after today");
            	//}
            	//add else !
            	if(selectedDate1.after(selectedDate2)) {
            		JOptionPane.showMessageDialog(null, "Date of Return must be after Departure Date");
            	}
            	else if(selectedDate2.after(selectedDate1)) {
            		String list1 [][] = Flight.Query_one_way(textSource.getText(), textDestination.getText(), selectedDate1, Class);
            		String list2 [][] = Flight.Query_one_way(textDestination.getText(), textSource.getText(), selectedDate2, Class);
                	
            		if(list1==null && list2==null) {
                		JOptionPane.showMessageDialog(null, "No Flights available on the selected dates");
                	}
            		else if(list1!=null && list2==null) {
                		JOptionPane.showMessageDialog(null, "No Return Flights available on the selected dates");
                	}
            		else if(list1==null && list2!=null) {
                		JOptionPane.showMessageDialog(null, "No Departure Flights available on the selected dates");
                	}
                	else {
                		TicketForm1_1.setVisible(true);
                		btnAddReturn.setVisible(true);
                		spinTickNumber1_1.setVisible(true);
                		labelTickSeats1_1.setVisible(true);
                		i=0;
                    	while(list1[i][0]!=null) {
                    		System.out.println(list1[i][0]);
                    		row[0]=list1[i][0];
                    		row[1]=list1[i][1];
                    		row[2]=list1[i][2];
                    		row[3]=list1[i][3];
                    		row[4]=list1[i][4];
                    		row[5]=list1[i][5];
                    		row[6]=list1[i][7];
                    		row[7]=list1[i][8];
                    		model2.addRow(row);
                        	i++;
                    	}
                    	//int a=i;
                    	//System.out.println("ihih"+a);
                    	empty_row=i;
                    	i=0;
                    
                    	model2.addRow(new Object[]{null,null,null,null,null,null,null,null});
                    	
                    	while(list2[i][0]!=null) {
                    		System.out.println(list2[i][0]);
                    		row[0]=list2[i][0];
                    		row[1]=list2[i][1];
                    		row[2]=list2[i][2];
                    		row[3]=list2[i][3];
                    		row[4]=list2[i][4];
                    		row[5]=list2[i][5];
                    		row[6]=list2[i][7];
                    		row[7]=list2[i][8];
                    		model2.addRow(row);
                        	i++;
                    	}
                    	
                	}
            	}
            	
            	this.updateUI();
        	} 	        
        }));
        
       
        //Falta verificar se o i é menor ou maior que empty row e deixar apenas selecionar o respetivo voo
        //ticket number, funçao que retorne o ticket number disponivel
        //falta mensagens
       
        
        table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
						
					btnAddFlight.addActionListener((a->{ 	
						int i=table.getSelectedRow();
						if(textSource.getText().equals(model2.getValueAt(i, 1).toString())) {								
							textTickNum1.setText(String.valueOf(Ticket.Query_ticket_available()));
							textTickFlight1.setText(model2.getValueAt(i, 0).toString());
							textTickCompany1.setText(model2.getValueAt(i, 7).toString());
							textTickSource1.setText(model2.getValueAt(i, 1).toString());
							textTickDestination1.setText(model2.getValueAt(i, 2).toString());
							textTickDate1.setText(model2.getValueAt(i, 3).toString());
							textTickDepartureT1.setText(model2.getValueAt(i, 4).toString());
							textTickArrivalT1.setText(model2.getValueAt(i, 5).toString());
							textTickPrice1.setText(String.valueOf((Integer.parseInt(model2.getValueAt(i, 6).toString()))*((Integer) spinTickNumber1.getValue())));
							if(textTickPrice1_1.getText().equals("")) {
								textTotalPrice.setText(textTickPrice1.getText());
							}
							else {
								textTotalPrice.setText(String.valueOf((Integer.parseInt(textTickPrice1.getText()))+(Integer.parseInt(textTickPrice1_1.getText()))));
							}
							
						}									      
					}));
				
				
					btnAddReturn.addActionListener((a->{
						int i=table.getSelectedRow();
						if(textDestination.getText().equals(model2.getValueAt(i, 1).toString())) {
							textTickNum1_1.setText(String.valueOf(Ticket.Query_ticket_available()+1));
							textTickFlight1_1.setText(model2.getValueAt(i, 0).toString());
							textTickCompany1_1.setText(model2.getValueAt(i, 7).toString());
							textTickSource1_1.setText(model2.getValueAt(i, 1).toString());
							textTickDestination1_1.setText(model2.getValueAt(i, 2).toString());
							textTickDate1_1.setText(model2.getValueAt(i, 3).toString());
							textTickDepartureT1_1.setText(model2.getValueAt(i, 4).toString());
							textTickArrivalT1_1.setText(model2.getValueAt(i, 5).toString());
							textTickPrice1_1.setText(String.valueOf((Integer.parseInt(model2.getValueAt(i, 6).toString()))*((Integer) spinTickNumber1_1.getValue())));
							if(textTickPrice1.getText().equals("")) {
								textTotalPrice.setText(textTickPrice1_1.getText());
							}
							else {
								textTotalPrice.setText(String.valueOf((Integer.parseInt(textTickPrice1.getText()))+(Integer.parseInt(textTickPrice1_1.getText()))));
							}
						}														
								
			        }));
				 
			}
			
		});
        
        btnBookTickets.addActionListener((e->{
        	
        	if(comboOneWayReturn.getSelectedIndex()==0 && (textSource.getText().equals(textTickSource1.getText()))) {
        		FramePayment framePayment=new FramePayment();
        		//frameHome.setUser(user); 
        		framePayment.setBookPanel(this);
        		framePayment.set_Price(textTotalPrice.getText(), user);
        		framePayment.setUser(user);
        		framePayment.setFlightTicket(textTickFlight1.getText(), textTickNum1.getText(), textTotalPrice.getText());
        		framePayment.setVisible(true);
        		framePayment.toFront();
        		System.out.println(user.get_username()+" payment");
        		
        		
    			//BookTicketPanel.this.dispose();            
        	}   
        	
        	//System.out.println(String.valueOf(Integer.parseInt(textTickPrice1.getText()+Integer.parseInt(textTickPrice1_1.getText()))));
        	if(comboOneWayReturn.getSelectedIndex()==1 && (textSource.getText().equals(textTickSource1.getText())) && (textSource.getText().equals(textTickDestination1_1.getText()))) {
        		FramePayment framePayment=new FramePayment(); 
        		//and bookticketpanel
        		framePayment.setBookPanel(this);
        		framePayment.setUser(user);
        		framePayment.set_Price(textTotalPrice.getText(), user);
        		framePayment.setFlightTicket1(textTickFlight1.getText(), textTickNum1.getText(), textTotalPrice.getText(), textTickFlight1_1.getText(), textTickNum1_1.getText());
        		System.out.println(user.get_username()+" payment");
        		framePayment.setVisible(true);
        		framePayment.toFront();
        		
        	} 
        }));
    }
	
	public void setPaymentUser(User user) {
		
		this.user=user;
		//and bookticketpanel
	}
	
	public void resetBookInfos() {
		this.TicketForm1_1.hide();
		this.spinTickNumber1_1.hide();
		this.labelTickSeats1_1.hide();
		this.btnAddReturn.hide();
		while(this.model2.getRowCount()!=0) {
    		this.model2.removeRow(0);
    		System.out.println("Removed");
    	}
		
		textTickNum1.setText("");
		textTickFlight1.setText("");
		textTickCompany1.setText("");
		textTickSource1.setText("");
		textTickDestination1.setText("");
		textTickDate1.setText("");
		textTickDepartureT1.setText("");
		textTickArrivalT1.setText("");
		textTickPrice1.setText("");
		spinTickNumber1.setValue(1);
		
		//Delete Ticket Form1_1
		textTickNum1_1.setText("");
		textTickFlight1_1.setText("");
		textTickCompany1_1.setText("");
		textTickSource1_1.setText("");
		textTickDestination1_1.setText("");
		textTickDate1_1.setText("");
		textTickDepartureT1_1.setText("");
		textTickArrivalT1_1.setText("");
		textTickPrice1_1.setText("");
    	spinTickNumber1_1.setValue(1);
    	
    	textTotalPrice.setText("");
    	textSource.setText("");
    	textDestination.setText("");
    	comboOneWayReturn.setSelectedIndex(0);
    	comboClass.setSelectedIndex(0);
    	
    	model1.setSelected(false);
    	model.setValue(null);
		
	}  	
}
