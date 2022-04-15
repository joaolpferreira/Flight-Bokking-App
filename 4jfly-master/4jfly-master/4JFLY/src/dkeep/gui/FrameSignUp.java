package dkeep.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;

import dkeep.logic.*;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.text.ParseException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import dkeep.logic.*;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class FrameSignUp extends JFrame {
	
	private Image img_logo= new ImageIcon(FrameLogin.class.getResource("res/4JFLY_Logo.png")).getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
	private Image img_username= new ImageIcon(FrameLogin.class.getResource("res/user.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_password= new ImageIcon(FrameLogin.class.getResource("res/password.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_login= new ImageIcon(FrameLogin.class.getResource("res/login.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_signup= new ImageIcon(FrameLogin.class.getResource("res/add-friend.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_secquest= new ImageIcon(FrameLogin.class.getResource("res/shield.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_answer= new ImageIcon(FrameLogin.class.getResource("res/answers.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	private Image img_email= new ImageIcon(FrameLogin.class.getResource("res/email.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_contact= new ImageIcon(FrameLogin.class.getResource("res/contact.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_passport= new ImageIcon(FrameLogin.class.getResource("res/passport.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField usernameText;
	private JPasswordField passwordText;

	
	JPanel PanelButtonLogin = new JPanel();
	
	
	URL url=this.getClass().getResource("res/4JFLY_Logo.png");
	Image img_titulo=Toolkit.getDefaultToolkit().getImage(url);
	User user;
	private JTextField answerText;
	private JTextField emailText;
	private JTextField contactText;
	private JTextField passportText;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSignUp frame = new FrameSignUp();
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
	FrameSignUp(){
		initialize();
	}
	
	public void initialize() {
		this.setIconImage(img_titulo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 205, 922, 622);
		contentPane = new JPanel();
		setUndecorated(true);
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel UsernamePanel = new JPanel();
		UsernamePanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		UsernamePanel.setBackground(new Color(0, 139, 139));
		UsernamePanel.setBounds(613, 103, 250, 40);
		contentPane.add(UsernamePanel);
		UsernamePanel.setLayout(null);
		
		
		usernameText = new JTextField();
		usernameText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(usernameText.getText().equals("Username")) {
					usernameText.setText("");
				}
				else {
					usernameText.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(usernameText.getText().equals(""))
					usernameText.setText("Username");
			}
		});
		usernameText.setBackground(new Color(0, 139, 139));
		usernameText.setForeground(Color.DARK_GRAY);
		usernameText.setCaretColor(Color.GRAY);
		usernameText.setBorder(null);
		usernameText.setFont(new Font("Arial", Font.PLAIN, 12));
		usernameText.setText("Username");
		usernameText.setBounds(10, 11, 170, 20);
		UsernamePanel.add(usernameText);
		usernameText.setColumns(10);
		
		JLabel IconUserLabel = new JLabel("");
		IconUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconUserLabel.setBounds(204, 0, 46, 40);
		IconUserLabel.setIcon(new ImageIcon(img_username));
		UsernamePanel.add(IconUserLabel);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		passwordPanel.setBackground(new Color(0, 139, 139));
		passwordPanel.setBounds(613, 154, 250, 40);
		contentPane.add(passwordPanel);
		passwordPanel.setLayout(null);
		
		passwordText = new JPasswordField();
		passwordText.setForeground(Color.DARK_GRAY);
		passwordText.setFont(new Font("Arial", Font.PLAIN, 12));
		passwordText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(passwordText.getText().equals("Password")) {
					passwordText.setEchoChar('*');
					passwordText.setText("");
				}
				else {
					passwordText.selectAll();
				}

			}
			@Override
			public void focusLost(FocusEvent e) {
				if(passwordText.getText().equals("")) {
					passwordText.setText("Password");
					passwordText.setEchoChar((char)0);
				}
					
			}
		});
		passwordText.setBackground(new Color(0, 139, 139));
		passwordText.setBorder(null);
		passwordText.setEchoChar((char)0);
		passwordText.setText("Password");
		passwordText.setBounds(10, 11, 170, 20);
		passwordPanel.add(passwordText);
		
		JLabel IconPasswordLabel = new JLabel("");
		IconPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconPasswordLabel.setBounds(204, 0, 46, 40);
		IconPasswordLabel.setIcon(new ImageIcon(img_password));
		passwordPanel.add(IconPasswordLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 250, 40);
		passwordPanel.add(panel);
		panel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		panel.setBackground(new Color(0, 139, 139));
		panel.setLayout(null);
		

		
		PanelButtonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				PanelButtonLogin.setBackground(new Color(127,255,212));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				PanelButtonLogin.setBackground(new Color(102,205,170));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				PanelButtonLogin.setBackground(new Color(32,178,170));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				PanelButtonLogin.setBackground(new Color(127,255,212));
				FrameLogin frameLogin=new FrameLogin();
				frameLogin.setVisible(true);
				FrameSignUp.this.dispose();
			}
		});
		PanelButtonLogin.setBackground(new Color(102, 205, 170));
		PanelButtonLogin.setBounds(613, 475, 250, 50);
		contentPane.add(PanelButtonLogin);
		PanelButtonLogin.setLayout(null);
		
		JLabel LoginLabel = new JLabel("LOGIN");
		LoginLabel.setBounds(105, 11, 135, 28);
		LoginLabel.setForeground(Color.WHITE);
		LoginLabel.setFont(new Font("Arial", Font.BOLD, 14));
		PanelButtonLogin.add(LoginLabel);
		
		JLabel IconLoginLabel = new JLabel("");
		IconLoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconLoginLabel.setBounds(36, 0, 46, 51);
		IconLoginLabel.setIcon(new ImageIcon(img_login));
		PanelButtonLogin.add(IconLoginLabel);
		
		JLabel XLabel = new JLabel("X");
		XLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this application?","Cofirmation",JOptionPane.YES_NO_OPTION)==0) {
					FrameSignUp.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				XLabel.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				XLabel.setForeground(Color.WHITE);
			}
		});
		XLabel.setForeground(Color.WHITE);
		XLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		XLabel.setHorizontalAlignment(SwingConstants.CENTER);
		XLabel.setBounds(902, 0, 20, 20);
		contentPane.add(XLabel);
		
		JPanel PanelButtonSign = new JPanel();
		
		JLabel SignUpLabel = new JLabel("SIGNUP");
		SignUpLabel.setForeground(Color.WHITE);
		SignUpLabel.setFont(new Font("Arial", Font.BOLD, 14));
		SignUpLabel.setBounds(105, 11, 135, 28);
		PanelButtonSign.add(SignUpLabel);
		
		JLabel IconSignUpLabel = new JLabel("");
		IconSignUpLabel.setBounds(34, 0, 46, 51);
		PanelButtonSign.add(IconSignUpLabel);
		IconSignUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconSignUpLabel.setIcon(new ImageIcon(img_signup));
		PanelButtonSign.add(IconSignUpLabel);
		
		JPanel SecQuestPanel = new JPanel();
		SecQuestPanel.setLayout(null);
		SecQuestPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		SecQuestPanel.setBackground(new Color(0, 139, 139));
		SecQuestPanel.setBounds(613, 205, 250, 40);
		contentPane.add(SecQuestPanel);
		
		JComboBox comboSecQuest = new JComboBox();
		comboSecQuest.setFont(new Font("Arial", Font.PLAIN, 12));
		String [] secquestion = {"Security Question","Which city were you born in?","What's your favourite pet?","What's your favourite food?","What was the model of your first car?"};
		comboSecQuest.setModel(new DefaultComboBoxModel(secquestion));
		comboSecQuest.setBackground(new Color(0, 139, 139));
		comboSecQuest.setBounds(0, 11, 208, 22);
		SecQuestPanel.add(comboSecQuest);
		
		JLabel IconSecQuest = new JLabel("");
		IconSecQuest.setHorizontalAlignment(SwingConstants.CENTER);
		IconSecQuest.setBounds(204, 0, 46, 40);
		IconSecQuest.setIcon(new ImageIcon(img_secquest));
		SecQuestPanel.add(IconSecQuest);
		
		
		PanelButtonSign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				PanelButtonSign.setBackground(new Color(255,102,51));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				PanelButtonSign.setBackground(new Color(255, 127, 80));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				PanelButtonSign.setBackground(new Color(255,99,71));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				PanelButtonSign.setBackground(new Color(255,102,51));
				if(usernameText.getText().equals("") || usernameText.getText().equals("Username")) {
					JOptionPane.showMessageDialog(null, "Please insert Username");
				}
				else if(passwordText.getText().equals("") || passwordText.getText().equals("Password")) {
					JOptionPane.showMessageDialog(null, "Please insert Password");
				}
				else if (comboSecQuest.getSelectedIndex()==0){
	                JOptionPane.showMessageDialog(null, "Please select a Security Question");
	            }
				else if(answerText.getText().equals("") || answerText.getText().equals("Answer")) {
					JOptionPane.showMessageDialog(null, "Please insert Answer");
				}
				else if(emailText.getText().equals("") || emailText.getText().equals("Email")) {
					JOptionPane.showMessageDialog(null, "Please insert Email");
				}
				else if(contactText.getText().equals("") || contactText.getText().equals("Contact")) {
					JOptionPane.showMessageDialog(null, "Please insert Contact");
				}
				else if(passportText.getText().equals("") || passportText.getText().equals("Passport ID")) {
					JOptionPane.showMessageDialog(null, "Please insert Passport");
				}
				else {
					if(User.Query_login(usernameText.getText(), passwordText.getText())==1) {
						User.Insert_User(usernameText.getText(), passwordText.getText(), emailText.getText(), secquestion[comboSecQuest.getSelectedIndex()], answerText.getText(), contactText.getText(), passportText.getText());					
						Wallet.Insert_wallet(usernameText.getText(),0);
						FrameLogin frameLogin=new FrameLogin();
						frameLogin.setVisible(true);
						FrameSignUp.this.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Username already exists");
					}
				}
				
			}
		});
		PanelButtonSign.setLayout(null);
		PanelButtonSign.setBackground(new Color(255, 127, 80));
		PanelButtonSign.setBounds(613, 536, 250, 50);
		contentPane.add(PanelButtonSign);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		panel_2.setBounds(0, 0, 562, 622);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel IconLogoLabel = new JLabel("");
		IconLogoLabel.setBounds(139, 229, 250, 250);
		panel_2.add(IconLogoLabel);
		IconLogoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconLogoLabel.setIcon(new ImageIcon(img_logo));
		
		JLabel lblWelcomeTo = new JLabel("Welcome To\r\n");
		lblWelcomeTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeTo.setForeground(new Color(0, 0, 102));
		lblWelcomeTo.setFont(new Font("Sitka Text", Font.PLAIN, 19));
		lblWelcomeTo.setBounds(157, 138, 232, 38);
		panel_2.add(lblWelcomeTo);
		
		JLabel SignUpPageLabel = new JLabel("SignUp Page");
		SignUpPageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SignUpPageLabel.setForeground(Color.WHITE);
		SignUpPageLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		SignUpPageLabel.setBounds(642, 24, 196, 34);
		contentPane.add(SignUpPageLabel);
		
		JLabel NewAccountLabel = new JLabel("Create New Account");
		NewAccountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NewAccountLabel.setForeground(Color.WHITE);
		NewAccountLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		NewAccountLabel.setBounds(642, 58, 196, 34);
		contentPane.add(NewAccountLabel);
		
		JPanel AnswerPanel = new JPanel();
		AnswerPanel.setLayout(null);
		AnswerPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		AnswerPanel.setBackground(new Color(0, 139, 139));
		AnswerPanel.setBounds(613, 256, 250, 40);
		contentPane.add(AnswerPanel);
		
		answerText = new JTextField();
		answerText.setText("Answer");
		answerText.setForeground(Color.DARK_GRAY);
		answerText.setFont(new Font("Arial", Font.PLAIN, 12));
		answerText.setColumns(10);
		answerText.setCaretColor(Color.GRAY);
		answerText.setBorder(null);
		answerText.setBackground(new Color(0, 139, 139));
		answerText.setBounds(10, 11, 170, 20);
		AnswerPanel.add(answerText);
		
		JLabel IconAnswer = new JLabel("");
		IconAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		IconAnswer.setIcon(new ImageIcon(img_answer));
		IconAnswer.setBounds(204, 0, 46, 40);
		AnswerPanel.add(IconAnswer);
		
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(null);
		emailPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		emailPanel.setBackground(new Color(0, 139, 139));
		emailPanel.setBounds(613, 307, 250, 40);
		contentPane.add(emailPanel);
		
		emailText = new JTextField();
		emailText.setText("Email");
		emailText.setForeground(Color.DARK_GRAY);
		emailText.setFont(new Font("Arial", Font.PLAIN, 12));
		emailText.setColumns(10);
		emailText.setCaretColor(Color.GRAY);
		emailText.setBorder(null);
		emailText.setBackground(new Color(0, 139, 139));
		emailText.setBounds(10, 11, 170, 20);
		emailPanel.add(emailText);
		
		JLabel IconEmail = new JLabel("");
		IconEmail.setHorizontalAlignment(SwingConstants.CENTER);
		IconEmail.setBounds(204, 0, 46, 40);
		IconEmail.setIcon(new ImageIcon(img_email));
		emailPanel.add(IconEmail);
		
		JPanel contactPanel = new JPanel();
		contactPanel.setLayout(null);
		contactPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		contactPanel.setBackground(new Color(0, 139, 139));
		contactPanel.setBounds(613, 358, 250, 40);
		contentPane.add(contactPanel);
		
		contactText = new JTextField();
		contactText.setText("Contact");
		contactText.setForeground(Color.DARK_GRAY);
		contactText.setFont(new Font("Arial", Font.PLAIN, 12));
		contactText.setColumns(10);
		contactText.setCaretColor(Color.GRAY);
		contactText.setBorder(null);
		contactText.setBackground(new Color(0, 139, 139));
		contactText.setBounds(10, 11, 170, 20);
		contactPanel.add(contactText);
		
		JLabel IconContact = new JLabel("");
		IconContact.setHorizontalAlignment(SwingConstants.CENTER);
		IconContact.setBounds(204, 0, 46, 40);
		IconContact.setIcon(new ImageIcon(img_contact));
		contactPanel.add(IconContact);
		
		JPanel passportPanel = new JPanel();
		passportPanel.setLayout(null);
		passportPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		passportPanel.setBackground(new Color(0, 139, 139));
		passportPanel.setBounds(613, 409, 250, 40);
		contentPane.add(passportPanel);
		
		passportText = new JTextField();
		passportText.setText("Passport ID");
		passportText.setForeground(Color.DARK_GRAY);
		passportText.setFont(new Font("Arial", Font.PLAIN, 12));
		passportText.setColumns(10);
		passportText.setCaretColor(Color.GRAY);
		passportText.setBorder(null);
		passportText.setBackground(new Color(0, 139, 139));
		passportText.setBounds(10, 11, 170, 20);
		passportPanel.add(passportText);
		
		JLabel IconPassport = new JLabel("");
		IconPassport.setHorizontalAlignment(SwingConstants.CENTER);
		IconPassport.setBounds(204, 0, 46, 40);
		IconPassport.setIcon(new ImageIcon(img_passport));
		passportPanel.add(IconPassport);
	
		
		

	}
}