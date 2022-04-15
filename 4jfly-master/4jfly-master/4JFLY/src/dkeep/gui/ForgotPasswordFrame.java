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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import dkeep.logic.*;

public class ForgotPasswordFrame extends JFrame {
	
	private Image img_secquest= new ImageIcon(FrameLogin.class.getResource("res/shield.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_answer= new ImageIcon(FrameLogin.class.getResource("res/answers.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JTextField usernameText;
	private JTextField secquestionText;
	private JTextField answerText;
	private JTextField yourpasswordText;
	
	JButton searchButton = new JButton("Search");
	JButton retrieveButton = new JButton("Retrieve Password");
	URL url=this.getClass().getResource("res/4JFLY_Logo.png");
	Image img_titulo=Toolkit.getDefaultToolkit().getImage(url);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPasswordFrame frame = new ForgotPasswordFrame();
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
	public ForgotPasswordFrame() {
		this.setIconImage(img_titulo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 334, 456);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(255, 127, 80), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel ForgotPanel = new JPanel();
		ForgotPanel.setBackground(new Color(0, 139, 139));
		ForgotPanel.setBounds(0, 0, 334, 48);
		contentPane.add(ForgotPanel);
		ForgotPanel.setLayout(null);
		
		JLabel forgotLabel = new JLabel("Forgot Password");
		forgotLabel.setHorizontalAlignment(SwingConstants.CENTER);
		forgotLabel.setForeground(new Color(255, 250, 250));
		forgotLabel.setFont(new Font("Sitka Text", Font.PLAIN, 24));
		forgotLabel.setBounds(59, 11, 222, 31);
		ForgotPanel.add(forgotLabel);
		JLabel XLabel = new JLabel("X");
		XLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					ForgotPasswordFrame.this.dispose();
				
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
		ForgotPanel.add(XLabel);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setForeground(new Color(0, 139, 139));
		usernameLabel.setFont(new Font("Arial", Font.BOLD, 12));
		usernameLabel.setBounds(21, 88, 74, 14);
		contentPane.add(usernameLabel);
		
		usernameText = new JTextField();
		usernameText.setFont(new Font("Arial", Font.PLAIN, 12));
		usernameText.setBounds(21, 113, 158, 20);
		contentPane.add(usernameText);
		usernameText.setColumns(10);
		

		searchButton.setFont(new Font("Arial", Font.BOLD, 12));
		searchButton.setBackground(new Color(0, 139, 139));
		searchButton.setForeground(new Color(255, 255, 255));
		searchButton.setBounds(211, 112, 96, 22);
		contentPane.add(searchButton);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 127, 80));
		separator.setBounds(0, 144, 334, 2);
		contentPane.add(separator);
		
		JLabel secquestLabel = new JLabel("SECURITY QUESTION");
		secquestLabel.setForeground(new Color(0, 139, 139));
		secquestLabel.setFont(new Font("Arial", Font.BOLD, 12));
		secquestLabel.setBounds(21, 178, 158, 14);
		contentPane.add(secquestLabel);
		
		secquestionText = new JTextField();
		secquestionText.setEditable(false);
		secquestionText.setFont(new Font("Arial", Font.PLAIN, 12));
		secquestionText.setColumns(10);
		secquestionText.setBounds(21, 216, 286, 20);
		contentPane.add(secquestionText);
		
		JLabel answerLabel = new JLabel("ANSWER");
		answerLabel.setForeground(new Color(0, 139, 139));
		answerLabel.setFont(new Font("Arial", Font.BOLD, 12));
		answerLabel.setBounds(21, 261, 74, 14);
		contentPane.add(answerLabel);
		
		answerText = new JTextField();
		answerText.setBounds(21, 301, 286, 20);
		contentPane.add(answerText);
		answerText.setColumns(10);
		

		retrieveButton.setForeground(Color.WHITE);
		retrieveButton.setFont(new Font("Arial", Font.BOLD, 12));
		retrieveButton.setBackground(new Color(0, 139, 139));
		retrieveButton.setBounds(57, 345, 218, 22);
		contentPane.add(retrieveButton);
		
		JLabel yourpasswordLabel = new JLabel("YOUR PASSWORD");
		yourpasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		yourpasswordLabel.setForeground(new Color(0, 139, 139));
		yourpasswordLabel.setFont(new Font("Arial", Font.BOLD, 12));
		yourpasswordLabel.setBounds(96, 400, 129, 14);
		contentPane.add(yourpasswordLabel);
		
		yourpasswordText = new JTextField();
		yourpasswordText.setEditable(false);
		yourpasswordText.setFont(new Font("Arial", Font.PLAIN, 12));
		yourpasswordText.setColumns(10);
		yourpasswordText.setBounds(21, 425, 286, 20);
		contentPane.add(yourpasswordText);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 127, 80));
		separator_1.setBounds(0, 387, 334, 2);
		contentPane.add(separator_1);
		
		setActionListeners();
		
	}
	
    public void setActionListeners(){
        searchButton.addActionListener((e->{
        	
        	String list [] = User.Query_forgot_password_1(usernameText.getText());
        	//wrong username
        	if(list==null) {
        		JOptionPane.showMessageDialog(null, "Username not found");
        	}
        	//username found
        	else {
        		secquestionText.setText(list[1]);
        	}

        }));
        
        retrieveButton.addActionListener((e->{
        	//System.out.println(usernameText.getText() + nameText.getText() + secquestionText.getText()+ answerText.getText());
        	String list = User.Query_forgot_password_2(usernameText.getText(), secquestionText.getText(), answerText.getText());
        	
        	//wrong answer to the Sec. Question
        	if(list==null) {
        		JOptionPane.showMessageDialog(null, "Wrong answer");
        	}
        	//answer is correct
        	else {
        		yourpasswordText.setText(list);
        	}


        }));  

    }
}
