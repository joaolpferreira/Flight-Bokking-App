package dkeep.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dkeep.logic.*;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;

public class FrameHome extends JFrame {
	//
	private JPanel contentPane;
	private Image img_home= new ImageIcon(FrameHome.class.getResource("res/4JFLY_Logo.png")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
	private Image img_myaccount= new ImageIcon(FrameHome.class.getResource("res/user.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_bookticket= new ImageIcon(FrameHome.class.getResource("res/new_ticket.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_cancelticket= new ImageIcon(FrameHome.class.getResource("res/delete_ticket.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_support= new ImageIcon(FrameHome.class.getResource("res/help.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_logout= new ImageIcon(FrameHome.class.getResource("res/logout.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_management= new ImageIcon(FrameHome.class.getResource("res/manage.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);

	private BookTicketPanel bookTicketPanel;
	private UserAccountPanel userAccountPanel;

	private SupportPanel supportPanel;
	private ManageFlightsPanel manageFlightsPanel;
	
	JPanel SupportPanel = new JPanel();
	JPanel UpdateFlightPanel = new JPanel();
	JPanel MyAccountPanel = new JPanel();
	JPanel BookTicketPanel = new JPanel();
	
	User user;
	
	
	JPanel WelcomePanel = new JPanel();
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHome frame = new FrameHome(String us);
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
	
	public FrameHome(String usernameText) {
		setBackground(new Color(255, 127, 80));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1536, 864);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bookTicketPanel= new BookTicketPanel();
		userAccountPanel= new UserAccountPanel();
		
		supportPanel= new SupportPanel();
		manageFlightsPanel= new ManageFlightsPanel();

		
		JPanel MenuPanel = new JPanel();
		MenuPanel.setBackground(new Color(255, 127, 80));
		MenuPanel.setBounds(0, 45, 275, 819);
		contentPane.add(MenuPanel);
		MenuPanel.setLayout(null);
		
		JLabel IconHomeLabel = new JLabel("");
		IconHomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconHomeLabel.setBounds(10, 11, 255, 157);
		IconHomeLabel.setIcon(new ImageIcon(img_home));
		MenuPanel.add(IconHomeLabel);
		
		JLabel SloganLabel1 = new JLabel("No matter where in the world \r\n");
		SloganLabel1.setForeground(new Color(0, 0, 102));
		SloganLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		SloganLabel1.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		SloganLabel1.setBounds(30, 175, 216, 31);
		MenuPanel.add(SloganLabel1);
		
		JLabel SloganLabel2 = new JLabel("you want to go, we can help\r\n");
		SloganLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		SloganLabel2.setForeground(new Color(0, 0, 102));
		SloganLabel2.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		SloganLabel2.setBounds(31, 203, 216, 31);
		MenuPanel.add(SloganLabel2);
		
		JLabel SloganLabel3 = new JLabel("   get you there.");
		SloganLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		SloganLabel3.setForeground(new Color(0, 0, 102));
		SloganLabel3.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		SloganLabel3.setBounds(20, 232, 216, 31);
		MenuPanel.add(SloganLabel3);
		
		
		UpdateFlightPanel.addMouseListener(new PanelButtonMouseAdapter(UpdateFlightPanel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(manageFlightsPanel);
			}
		});
		UpdateFlightPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		UpdateFlightPanel.setBackground(new Color(255, 127, 80));
		UpdateFlightPanel.setBounds(0, 617, 275, 49);
		MenuPanel.add(UpdateFlightPanel);
		UpdateFlightPanel.setLayout(null);
		
		JLabel UpdateFlightsLabel = new JLabel("Manage Flights");
		UpdateFlightsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		UpdateFlightsLabel.setForeground(Color.WHITE);
		UpdateFlightsLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		UpdateFlightsLabel.setBounds(61, 11, 99, 27);
		UpdateFlightPanel.add(UpdateFlightsLabel);
		
		JLabel IconManageFlights = new JLabel("");
		IconManageFlights.setHorizontalAlignment(SwingConstants.CENTER);
		IconManageFlights.setBounds(0, 0, 49, 49);
		IconManageFlights.setIcon(new ImageIcon(img_management));
		UpdateFlightPanel.add(IconManageFlights);
		
		JPanel LogoutPanel = new JPanel();
		LogoutPanel.addMouseListener(new PanelButtonMouseAdapter(LogoutPanel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to log out?")==0) {
					FrameLogin frameLogin=new FrameLogin();
					frameLogin.setVisible(true);
					FrameHome.this.dispose();
				}

			}

		});
		LogoutPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		LogoutPanel.setBackground(new Color(255, 127, 80));
		LogoutPanel.setBounds(0, 557, 275, 49);
		MenuPanel.add(LogoutPanel);
		LogoutPanel.setLayout(null);
		
		JLabel LogoutLabel = new JLabel("Logout");
		LogoutLabel.setHorizontalAlignment(SwingConstants.LEFT);
		LogoutLabel.setForeground(Color.WHITE);
		LogoutLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		LogoutLabel.setBounds(59, 11, 99, 27);
		LogoutPanel.add(LogoutLabel);
		
		JLabel IconLogout = new JLabel("");
		IconLogout.setHorizontalAlignment(SwingConstants.CENTER);
		IconLogout.setBounds(0, 0, 49, 49);
		IconLogout.setIcon(new ImageIcon(img_logout));
		LogoutPanel.add(IconLogout);
		
		
		SupportPanel.addMouseListener(new PanelButtonMouseAdapter(SupportPanel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(supportPanel);
			}
		});
		SupportPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		SupportPanel.setBackground(new Color(255, 127, 80));
		SupportPanel.setBounds(0, 437, 275, 49);
		MenuPanel.add(SupportPanel);
		SupportPanel.setLayout(null);
		
		JLabel SupportTicketLabel = new JLabel("Support");
		SupportTicketLabel.setHorizontalAlignment(SwingConstants.LEFT);
		SupportTicketLabel.setForeground(Color.WHITE);
		SupportTicketLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		SupportTicketLabel.setBounds(56, 11, 99, 27);
		SupportPanel.add(SupportTicketLabel);
		
		JLabel IconSupport = new JLabel("");
		IconSupport.setHorizontalAlignment(SwingConstants.CENTER);
		IconSupport.setBounds(0, 0, 49, 49);
		IconSupport.setIcon(new ImageIcon(img_support));
		SupportPanel.add(IconSupport);
		
		
		BookTicketPanel.addMouseListener(new PanelButtonMouseAdapter(BookTicketPanel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(bookTicketPanel);
			}
		});
		BookTicketPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		BookTicketPanel.setBackground(new Color(255, 127, 80));
		BookTicketPanel.setBounds(0, 377, 275, 49);
		MenuPanel.add(BookTicketPanel);
		BookTicketPanel.setLayout(null);
		
		JLabel BookTicketLabel = new JLabel("Book Ticket");
		BookTicketLabel.setHorizontalAlignment(SwingConstants.LEFT);
		BookTicketLabel.setForeground(Color.WHITE);
		BookTicketLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		BookTicketLabel.setBounds(56, 11, 99, 27);
		BookTicketPanel.add(BookTicketLabel);
		
		JLabel IconBookTicket = new JLabel("");
		IconBookTicket.setHorizontalAlignment(SwingConstants.CENTER);
		IconBookTicket.setBounds(0, 0, 49, 49);
		IconBookTicket.setIcon(new ImageIcon(img_bookticket));
		BookTicketPanel.add(IconBookTicket);
		
		
		MyAccountPanel.addMouseListener(new PanelButtonMouseAdapter(MyAccountPanel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(userAccountPanel);
			}
		});
		MyAccountPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		MyAccountPanel.setBackground(new Color(255, 127, 80));
		MyAccountPanel.setBounds(0, 317, 275, 49);
		MenuPanel.add(MyAccountPanel);
		MyAccountPanel.setLayout(null);
		
		JLabel MyAccountLabel = new JLabel("My account");
		MyAccountLabel.setForeground(Color.WHITE);
		MyAccountLabel.setHorizontalAlignment(SwingConstants.LEFT);
		MyAccountLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		MyAccountLabel.setBounds(59, 11, 99, 27);
		MyAccountPanel.add(MyAccountLabel);
		
		JLabel IconMyAccount = new JLabel("");
		IconMyAccount.setHorizontalAlignment(SwingConstants.CENTER);
		IconMyAccount.setBounds(0, 0, 49, 49);
		IconMyAccount.setIcon(new ImageIcon(img_myaccount));
		MyAccountPanel.add(IconMyAccount);
		
		
		WelcomePanel.setBackground(new Color(0, 139, 139));
		WelcomePanel.setBounds(0, 0, 1536, 45);
		contentPane.add(WelcomePanel);
		WelcomePanel.setLayout(null);
		
		
		
		
		JLabel XLabel = new JLabel("X");
		XLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this application?","Cofirmation",JOptionPane.YES_NO_OPTION)==0) {
					FrameHome.this.dispose();
				}
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
		XLabel.setBounds(1504, 11, 32, 21);
		WelcomePanel.add(XLabel);
		
		JPanel MainContentPanel = new JPanel();
		MainContentPanel.setBackground(new Color(255, 250, 250));
		MainContentPanel.setBounds(276, 45, 1260, 819);
		contentPane.add(MainContentPanel);
		MainContentPanel.setLayout(null);
		
		MainContentPanel.add(userAccountPanel);
		MainContentPanel.add(bookTicketPanel);
		MainContentPanel.add(supportPanel);
		MainContentPanel.add(manageFlightsPanel);
		
		
		if(usernameText.equals("admin")) {
			System.out.println(usernameText +"ADMIN");
			menuClicked(manageFlightsPanel);
		}
		else{
			System.out.println(usernameText + " USER");
			menuClicked(userAccountPanel);
		}
		
		
		
		
	}
	
	public void menuClicked(JPanel panel) {
		userAccountPanel.setVisible(false);
		bookTicketPanel.setVisible(false);
		supportPanel.setVisible(false);
		manageFlightsPanel.setVisible(false);
		
		if(panel.equals(userAccountPanel) && this.user!=null) {
			userAccountPanel.setUser(this.user);
		}
		if(panel.equals(bookTicketPanel)) {
			bookTicketPanel.resetBookInfos();
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
			panel.setBackground(new Color(255, 127, 80));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(255,99,71));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(255,102,51));
		}
	}
	
	public void setUser(User user) {
		this.user=user;
		
//Set user login on Welcome Panel		
		JLabel WelcomeLabel = new JLabel("Welcome, "+user.get_username());
		WelcomeLabel.setForeground(Color.WHITE);
		WelcomeLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		WelcomeLabel.setBounds(1323, 11, 171, 23);
		WelcomePanel.add(WelcomeLabel);
		
//If it's admin jump to manageflights panel
		if(user.get_username().equals("admin")) {
			menuClicked(manageFlightsPanel);
			manageFlightsPanel.setUser(user);
			SupportPanel.setVisible(false);
			MyAccountPanel.setVisible(false);
			BookTicketPanel.setVisible(false);
			
		}
//else set useraccount panel
		else {
			userAccountPanel.setUser(user);
			bookTicketPanel.setPaymentUser(user);
			UpdateFlightPanel.setVisible(false);
		}
	}
}
