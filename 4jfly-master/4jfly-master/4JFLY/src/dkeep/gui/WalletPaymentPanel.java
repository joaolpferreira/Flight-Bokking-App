package dkeep.gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

import dkeep.logic.Ticket;
import dkeep.logic.User;
import dkeep.logic.Wallet;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WalletPaymentPanel extends JPanel {
	private JTextField youhaveText;
	private JTextField youneedText;
	FramePayment framePayment;
	Wallet wallet;
	User user;
	String flight;
	String ticket;
	String flight_r;
	String ticket_r;
	String price;
	BookTicketPanel bookTicket;
	/**
	 * Create the panel.
	 */
	public WalletPaymentPanel() {
		setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(255, 127, 80)));
		setBackground(new Color(255, 255, 255));
		setBounds(0,0,334,346);
		setLayout(null);
		
		JLabel youhaveLabel = new JLabel("YOU HAVE");
		youhaveLabel.setForeground(new Color(0, 139, 139));
		youhaveLabel.setFont(new Font("Arial", Font.BOLD, 12));
		youhaveLabel.setBounds(39, 79, 63, 14);
		add(youhaveLabel);
		
		youhaveText = new JTextField();
		youhaveText.setBounds(112, 76, 111, 20);
		add(youhaveText);
		youhaveText.setColumns(10);
		
		JLabel pointsLabel = new JLabel("POINTS");
		pointsLabel.setForeground(new Color(0, 139, 139));
		pointsLabel.setFont(new Font("Arial", Font.BOLD, 12));
		pointsLabel.setBounds(233, 79, 63, 14);
		add(pointsLabel);
		
		JLabel youneedLabel = new JLabel("YOU NEED");
		youneedLabel.setForeground(new Color(0, 139, 139));
		youneedLabel.setFont(new Font("Arial", Font.BOLD, 12));
		youneedLabel.setBounds(39, 189, 63, 14);
		add(youneedLabel);
		
		youneedText = new JTextField();
		youneedText.setColumns(10);
		youneedText.setBounds(112, 186, 111, 20);
		add(youneedText);
		
		JLabel pointsLabel2 = new JLabel("POINTS");
		pointsLabel2.setForeground(new Color(0, 139, 139));
		pointsLabel2.setFont(new Font("Arial", Font.BOLD, 12));
		pointsLabel2.setBounds(233, 189, 63, 14);
		add(pointsLabel2);
		
		JButton btnNewButton = new JButton("CONFIRM PAYMENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(youhaveText.getText()) >= Integer.parseInt(youneedText.getText())) {
					JOptionPane.showMessageDialog(null, "Flight Bought Successfully");
					framePayment.dispose();
					Ticket.Insert_Ticket(Integer.parseInt(ticket),Integer.parseInt(flight), user.get_username());
					Wallet.Remove_points(user.get_username(), Integer.parseInt(youneedText.getText()));
					if(ticket_r!=null) {
						System.out.println("ticket_r "+ticket_r);
						Ticket.Insert_Ticket(Integer.parseInt(ticket_r),Integer.parseInt(flight_r), user.get_username());
					}
					framePayment.resetBookInfos();
				}
				else {
					JOptionPane.showMessageDialog(null, "You don't have enough points");
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setBounds(0, 278, 334, 68);
		add(btnNewButton);

	}
	
	public void walletPrice(String Price, User user) {
		youneedText.setText(String.valueOf(Price));
		System.out.println("wallet price "+user.get_username());
		int Points=Wallet.Query_wallet_points(user.get_username());
		youhaveText.setText(String.valueOf(Points));
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
	
	
}
