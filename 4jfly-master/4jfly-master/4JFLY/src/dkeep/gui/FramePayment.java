package dkeep.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import dkeep.logic.User;

public class FramePayment extends JFrame {

	private JPanel contentPane;
	private CardPanel cardPanel;
	private WalletPaymentPanel walletpaymentPanel;
	private Image img_visa= new ImageIcon(FrameHome.class.getResource("res/visa.png")).getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
	private Image img_wallet= new ImageIcon(FrameHome.class.getResource("res/wallet.png")).getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
	private Image img_master= new ImageIcon(FrameHome.class.getResource("res/mastercad.png")).getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
	
	JPanel CardPanel = new JPanel();
	JPanel WalletPaymentPanel = new JPanel();
	
	JPanel WalletPanel = new JPanel();
	
	BookTicketPanel bookticket;
	User user;
	
	URL url=this.getClass().getResource("res/4JFLY_Logo.png");
	Image img_titulo=Toolkit.getDefaultToolkit().getImage(url);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePayment frame = new FramePayment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePayment() {
		this.setIconImage(img_titulo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 456);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(255, 127, 80), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cardPanel = new CardPanel();
		walletpaymentPanel= new WalletPaymentPanel();
		
		JPanel PaymentPanel = new JPanel();
		PaymentPanel.setBackground(new Color(0, 139, 139));
		PaymentPanel.setBounds(0, 0, 334, 48);
		contentPane.add(PaymentPanel);
		PaymentPanel.setLayout(null);
		
		JLabel PaymentLabel = new JLabel("Payment Methods");
		PaymentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PaymentLabel.setForeground(new Color(255, 250, 250));
		PaymentLabel.setFont(new Font("Sitka Text", Font.PLAIN, 24));
		PaymentLabel.setBounds(59, 11, 222, 31);
		PaymentPanel.add(PaymentLabel);
		
		JLabel XLabel = new JLabel("X");
		XLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FramePayment.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				XLabel.setForeground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				XLabel.setForeground(Color.WHITE);
			}
		});
		XLabel.setForeground(Color.WHITE);
		XLabel.setHorizontalAlignment(SwingConstants.CENTER);
		XLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		XLabel.setBounds(312, 0, 22, 21);
		PaymentPanel.add(XLabel);
		
		JPanel VisaPanel = new JPanel();
		VisaPanel.addMouseListener(new PanelButtonMouseAdapter(VisaPanel){
			@Override
			public void mouseClicked(MouseEvent e) {
				cardPanel.nameText.setText("");
				cardPanel.cardNumberText.setText("");
				cardPanel.cvvText.setText("");
				cardPanel.dateText.setText("");
				methodsClicked(cardPanel);
			}
		});
		VisaPanel.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(255, 127, 80)));
		VisaPanel.setBackground(new Color(255, 250, 250));
		VisaPanel.setBounds(0, 48, 112, 61);
		contentPane.add(VisaPanel);
		VisaPanel.setLayout(null);
		
		JLabel IconVisaLabel = new JLabel("");
		IconVisaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconVisaLabel.setBounds(10, 0, 92, 50);
		IconVisaLabel.setIcon(new ImageIcon(img_visa));
		VisaPanel.add(IconVisaLabel);
		
		JLabel lblNewLabel = new JLabel("VISA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel.setBounds(34, 49, 46, 14);
		VisaPanel.add(lblNewLabel);
		
		JPanel MasterPanel = new JPanel();
		MasterPanel.addMouseListener(new PanelButtonMouseAdapter(MasterPanel){
			@Override
			public void mouseClicked(MouseEvent e) {
				cardPanel.nameText.setText("");
				cardPanel.cardNumberText.setText("");
				cardPanel.cvvText.setText("");
				cardPanel.dateText.setText("");
				methodsClicked(cardPanel);
			}
		});
		MasterPanel.setBackground(new Color(255, 250, 250));
		MasterPanel.setBounds(112, 48, 112, 61);
		contentPane.add(MasterPanel);
		MasterPanel.setLayout(null);
		
		JLabel IconMasterLabel = new JLabel("");
		IconMasterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconMasterLabel.setBounds(10, 0, 92, 50);
		IconMasterLabel.setIcon(new ImageIcon(img_master));
		MasterPanel.add(IconMasterLabel);
		
		JLabel lblMastercard = new JLabel("MASTERCARD");
		lblMastercard.setHorizontalAlignment(SwingConstants.CENTER);
		lblMastercard.setForeground(new Color(255, 250, 250));
		lblMastercard.setFont(new Font("Arial", Font.BOLD, 11));
		lblMastercard.setBounds(10, 47, 92, 14);
		MasterPanel.add(lblMastercard);
		
		
		WalletPanel.addMouseListener(new PanelButtonMouseAdapter(WalletPanel){
			@Override
			public void mouseClicked(MouseEvent e) {
				methodsClicked(walletpaymentPanel);
				WalletPanel.setBackground(new Color(255,102,51));
			}
		});
		WalletPanel.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(255, 127, 80)));
		WalletPanel.setBackground(new Color(255, 250, 250));
		WalletPanel.setBounds(222, 48, 112, 61);
		contentPane.add(WalletPanel);
		WalletPanel.setLayout(null);
		
		JLabel IconWalletLabel = new JLabel("");
		IconWalletLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconWalletLabel.setBounds(10, 0, 92, 50);
		IconWalletLabel.setIcon(new ImageIcon(img_wallet));
		WalletPanel.add(IconWalletLabel);
		
		JLabel lblWalletPoints = new JLabel("WALLET ");
		lblWalletPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblWalletPoints.setForeground(new Color(255, 250, 250));
		lblWalletPoints.setFont(new Font("Arial", Font.BOLD, 11));
		lblWalletPoints.setBounds(10, 47, 92, 14);
		WalletPanel.add(lblWalletPoints);
		
		JPanel panelMainMethod = new JPanel();
		panelMainMethod.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(255, 127, 80)));
		panelMainMethod.setBackground(new Color(255, 255, 255));
		panelMainMethod.setBounds(0, 110, 334, 346);
		contentPane.add(panelMainMethod);
		panelMainMethod.setLayout(null);
		
		panelMainMethod.add(cardPanel);
		panelMainMethod.add(walletpaymentPanel);
		
		
		methodsClicked(cardPanel);
		

	}
	public void methodsClicked(JPanel panel) {
		cardPanel.setVisible(false);
		walletpaymentPanel.setVisible(false);
		if(panel.equals(walletpaymentPanel)) {
			walletpaymentPanel.setFramePayment(this);
			walletpaymentPanel.setUser(user);
		}
		else if(panel.equals(cardPanel)) {
			
			cardPanel.setFramePayment(this);
			cardPanel.setUser(user);
		}
		
		
		panel.setVisible(true);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(255,102,51));
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(250, 250, 250));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(255, 127, 80));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(255,102,51));
		}
		
	}
	
	public void set_Price(String Price, User user) {
		walletpaymentPanel.walletPrice(Price, user);
		
	}
	
	public void setUser(User user) {
		this.user=user;
		walletpaymentPanel.setUser(user);
		cardPanel.setUser(user);
	}
	
	public void setFlightTicket(String flight, String ticket, String price) {
		this.user=user;
		walletpaymentPanel.setFlightTicket(flight, ticket, price);
		cardPanel.setFlightTicket(flight, ticket, price);
	}
	
	public void setFlightTicket1(String flight, String ticket, String price, String flight_r, String ticket_r) {
		this.user=user;
		walletpaymentPanel.setFlightTicket1(flight, ticket, price, flight_r, ticket_r);
		cardPanel.setFlightTicket1(flight, ticket, price, flight_r, ticket_r);
	}
	
	public void resetBookInfos() {
		System.out.println("resetBook framepayment");
		System.out.println(bookticket.user.get_username()+"userpaymentpanel");
		bookticket.resetBookInfos();
	}
	
	public void setBookPanel(BookTicketPanel panel) {
		System.out.println("setbookticket");
		this.bookticket=panel;
	}
	
	
	
}
