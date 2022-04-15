package dkeep.gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;

import dkeep.logic.Ticket;
import dkeep.logic.User;
import dkeep.logic.Wallet;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import java.text.ParseException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardPanel extends JPanel {
	JFormattedTextField dateText = new JFormattedTextField();
	JFormattedTextField cardNumberText = new JFormattedTextField();
	JFormattedTextField cvvText = new JFormattedTextField();
	public JTextField nameText;
	FramePayment framePayment;
	
	String price;
	String ticket;
	String flight;
	String flight_r;
	String ticket_r;
	User user;
	BookTicketPanel bookTicket;
	/**
	 * Create the panel.
	 */
	public CardPanel() {
		setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(255, 127, 80)));
		setBounds(0,0,334,346);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblCardNumber = new JLabel("CARD NUMBER");
		lblCardNumber.setForeground(new Color(0, 139, 139));
		lblCardNumber.setFont(new Font("Arial", Font.BOLD, 12));
		lblCardNumber.setBounds(25, 22, 91, 14);
		add(lblCardNumber);
		
		


		
		MaskFormatter mask_number;
		try {
			mask_number=new MaskFormatter("#### #### #### ####");
			cardNumberText = new JFormattedTextField(mask_number);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cardNumberText.setBounds(25, 47, 278, 33);
		add(cardNumberText);
		
		JLabel lblExp = new JLabel("EXPIRATION DATE");
		lblExp.setForeground(new Color(0, 139, 139));
		lblExp.setFont(new Font("Arial", Font.BOLD, 12));
		lblExp.setBounds(25, 104, 116, 14);
		add(lblExp);
		
		
		MaskFormatter mask_date;
		try {
			mask_date=new MaskFormatter("##/####");
			dateText = new JFormattedTextField(mask_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dateText.setBounds(24, 129, 127, 33);
		this.add(dateText);
			
		MaskFormatter mask_CVV;
		try {
			mask_CVV=new MaskFormatter("###");
			cvvText = new JFormattedTextField(mask_CVV);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cvvText.setBounds(212, 129, 91, 33);
		add(cvvText);
		
		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setForeground(new Color(0, 139, 139));
		lblCvv.setFont(new Font("Arial", Font.BOLD, 12));
		lblCvv.setBounds(212, 104, 48, 14);
		add(lblCvv);
		
		JLabel lblCardHoldersName = new JLabel("CARD HOLDERS NAME");
		lblCardHoldersName.setForeground(new Color(0, 139, 139));
		lblCardHoldersName.setFont(new Font("Arial", Font.BOLD, 12));
		lblCardHoldersName.setBounds(25, 185, 152, 14);
		add(lblCardHoldersName);
		
		nameText = new JTextField();
		nameText.setBounds(25, 210, 278, 33);
		add(nameText);
		nameText.setColumns(10);
		
		JButton btnNewButton = new JButton("CONFIRM PAYMENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	String date= dateText.getText();
	        	boolean validateDate=validDate(date);
	        	//validate card number
	        	String cardNumber=cardNumberText.getText();
	        	boolean validateNumber=validNumber(cardNumber);
	        	if(!validateNumber) {
	        		JOptionPane.showMessageDialog(null, "Card Number is not valid");
	        	}
	        	//validate date
	        	else if(!validateDate) {
	        		JOptionPane.showMessageDialog(null, "Expiry Date is not valid");
	        		
	        	}
	        	else {
					JOptionPane.showMessageDialog(null, "Flight Bought Successfully");
					framePayment.dispose();
					//System.out.println("card "+user.get_username());
					Ticket.Insert_Ticket(Integer.parseInt(ticket),Integer.parseInt(flight), user.get_username());
					Wallet.Add_points(user.get_username(), Integer.parseInt(price));
					//System.out.println("ticket_r123 "+ticket_r);
					if(ticket_r!=null) {
						//System.out.println("ticket_r "+ticket_r);
						Ticket.Insert_Ticket(Integer.parseInt(ticket_r),Integer.parseInt(flight_r), user.get_username());

	        		}
					framePayment.resetBookInfos();
	        	}
			}
	        	
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setBounds(0, 278, 334, 68);
		add(btnNewButton);
		
		
		
	}
	
	public void setFramePayment(FramePayment frame) {
		this.framePayment=frame;
	}
	
	public void setUser(User user) {
		this.user=user;
	}
	
	public void setFlightTicket(String flight, String ticket, String price) {
		this.flight=flight;
		this.ticket=ticket;
		this.price=price;
	}
	
	public void setFlightTicket1(String flight, String ticket, String price, String flight_r, String ticket_r) {
		this.flight=flight;
		this.ticket=ticket;
		this.price=price;
		this.flight_r=flight_r;
		this.ticket_r=ticket_r;
	}
	
    private static boolean validDate(String date) {
    	DateTimeFormatter f = DateTimeFormatter.ofPattern( "M/uuuu" ) ;
    	YearMonth ym = YearMonth.parse( date , f ) ;
    	YearMonth current= YearMonth.now();
    	boolean result= ym.isBefore(current);
    	if(result) {
    		return false;
    	}
    	return true;
    }
    
    private static boolean validNumber(String cardNumber)  {
        String purportedCard = cardNumber.replaceAll(" ", "");
        int sum = 0;

        for (int i = 0; i < purportedCard.length(); i++) {
            int cardNum = Integer.parseInt(
                    Character.toString(purportedCard.charAt(i)));

            if ((purportedCard.length() - i) % 2 == 0) {
                cardNum = cardNum * 2;

                if (cardNum > 9) {
                    cardNum = cardNum - 9;
                }
            }

            sum += cardNum;
        }
        return sum % 10 == 0;
    }
	
		
}
