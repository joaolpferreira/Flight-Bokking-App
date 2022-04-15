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

import dkeep.logic.*;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import dkeep.logic.*;

public class FrameLogin extends JFrame {
	//
	private Image img_logo= new ImageIcon(FrameLogin.class.getResource("res/4JFLY_Logo.png")).getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
	private Image img_username= new ImageIcon(FrameLogin.class.getResource("res/user.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_password= new ImageIcon(FrameLogin.class.getResource("res/password.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_login= new ImageIcon(FrameLogin.class.getResource("res/login.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_signup= new ImageIcon(FrameLogin.class.getResource("res/add-friend.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField usernameText;
	private JPasswordField passwordText;
	
	JPanel PanelButtonLogin = new JPanel();
	
	URL url=this.getClass().getResource("res/4JFLY_Logo.png");
	Image img_titulo=Toolkit.getDefaultToolkit().getImage(url);

	
	User user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	FrameLogin(){
		initialize();
	}
	
	//validation
	public boolean validateLogin() {
		
		String name=usernameText.getText();
		String password=passwordText.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this,"please enter username");
			return false;
		}
		if(password.equals("")) {
			JOptionPane.showMessageDialog(this, "please enter password");
			return false;
		}
		return true;
	}
	
	//verification
	public void login() {
		int action=User.Query_login(usernameText.getText(), passwordText.getText());
    	//Wrong User
    	if(action == 1) {
    		System.out.println("User doesn't exist");
            JOptionPane.showMessageDialog(null, "User Not Found!");
    		
    	}
    	//Wrong password
    	else if(action == 2) {
    		System.out.println("Wrong Password");
            JOptionPane.showMessageDialog(null, "Incorrect Password");
    		
    	}
    	//Login
    	else if(action == 3) {
    		System.out.println("Login successful");		
			user = new User();
			user.set_user_username(usernameText.getText());
			//System.out.println("user "+user.get_username());
			FrameHome frameHome=new FrameHome(usernameText.getText());
			frameHome.setUser(user);
			frameHome.setVisible(true);
			FrameLogin.this.dispose();
    	}
    	//Login normal user
    	else if(action == 4) {    
    		user = new User();
			user.set_user_username(usernameText.getText());
    		FrameHome frameHome=new FrameHome(usernameText.getText());
    		frameHome.setUser(user);
    		frameHome.setVisible(true);
			FrameLogin.this.dispose();
    	}
    
        //Error
    	if(action==5) {
    		System.out.println("Unknown error");
    		JOptionPane.showMessageDialog(null, "UNKOWN ERROR1");
    	}
	}
	private void PanelButtonLoginActionPerformed(java.awt.event.MouseEvent e) {
		if(validateLogin()) {
			login();
		}
	}


	public void initialize() {
		this.setIconImage(img_titulo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 622);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(612, 179, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
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
		panel.add(usernameText);
		usernameText.setColumns(10);
		
		JLabel IconUserLabel = new JLabel("");
		IconUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconUserLabel.setBounds(204, 0, 46, 40);
		IconUserLabel.setIcon(new ImageIcon(img_username));
		panel.add(IconUserLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(612, 242, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
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
		panel_1.add(passwordText);
		
		JLabel IconPasswordLabel = new JLabel("");
		IconPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IconPasswordLabel.setBounds(204, 0, 46, 40);
		IconPasswordLabel.setIcon(new ImageIcon(img_password));
		panel_1.add(IconPasswordLabel);
		

		
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
				PanelButtonLoginActionPerformed(e);
				PanelButtonLogin.setBackground(new Color(127,255,212));
			}
		});
		PanelButtonLogin.setBackground(new Color(102, 205, 170));
		PanelButtonLogin.setBounds(612, 386, 250, 50);
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
					FrameLogin.this.dispose();
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
				
				FrameSignUp frameSignUp = new FrameSignUp();
				frameSignUp.setVisible(true);
				FrameLogin.this.dispose();
			}
		});
		PanelButtonSign.setLayout(null);
		PanelButtonSign.setBackground(new Color(255, 127, 80));
		PanelButtonSign.setBounds(612, 454, 250, 50);
		contentPane.add(PanelButtonSign);
		
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
		
		JLabel forgotpasswordLabel = new JLabel("Forgot my password...");
		forgotpasswordLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgotPasswordFrame frameforgot=new ForgotPasswordFrame();
        		frameforgot.setVisible(true);
        		frameforgot.toFront();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				forgotpasswordLabel.setForeground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				forgotpasswordLabel.setForeground(Color.WHITE);
			}
		});
		forgotpasswordLabel.setForeground(Color.WHITE);
		forgotpasswordLabel.setFont(new Font("Arial", Font.BOLD, 10));
		forgotpasswordLabel.setBounds(678, 528, 130, 14);
		contentPane.add(forgotpasswordLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		panel_2.setBounds(0, 0, 552, 622);
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
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel.setBounds(644, 55, 196, 34);
		contentPane.add(lblNewLabel);
		
		JLabel WelcomeLabel = new JLabel("Welcome!");
		WelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeLabel.setForeground(Color.WHITE);
		WelcomeLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		WelcomeLabel.setBounds(644, 85, 196, 34);
		contentPane.add(WelcomeLabel);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		

	}
}
