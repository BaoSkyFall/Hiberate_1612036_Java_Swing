import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.sql.*;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("HIBERATE PORTAL APPLICATION");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("UTM Androgyne", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 11, 537, 36);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(63, 129, 448, 248);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblLogin_1 = new JLabel("Username :");
		lblLogin_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin_1.setForeground(Color.BLACK);
		lblLogin_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 20));
		lblLogin_1.setBounds(10, 23, 123, 36);
		panel.add(lblLogin_1);
		
		JLabel lblLogin_1_1 = new JLabel("Password :");
		lblLogin_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin_1_1.setForeground(Color.BLACK);
		lblLogin_1_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 20));
		lblLogin_1_1.setBounds(10, 75, 123, 36);
		panel.add(lblLogin_1_1);
		
		txt_username = new JTextField();
		txt_username.setFont(new Font("UTM Androgyne", Font.PLAIN, 20));
		txt_username.setBounds(163, 23, 257, 34);
		panel.add(txt_username);
		txt_username.setColumns(10);
		
		txt_password = new JPasswordField();
		txt_password.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txt_password.setBounds(163, 75, 257, 34);
		panel.add(txt_password);
		
		JButton btnNewButton = new JButton("Signin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=latin1","root","root");
					Statement stmt=con.createStatement();
					String sql = "select * from users where username= '"+ txt_username.getText()+ "' and password='"+txt_password.getText().toString()+ "'";
					System.out.println(sql);
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next())
					{
						Boolean isStudent  = rs.getBoolean("isStudent");
						if(!isStudent)
						{
							Dashboard Dashboard = new Dashboard();
							Dashboard.setVisible(true);
							Login.this.dispose();
						}
						else
						{
							
							JOptionPane.showMessageDialog(null,"Login Fail");

						}
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Login Fail");

					}
					
			}catch(Exception e1) {
				System.out.println(e1);
			}
			}
		});
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(SystemColor.textHighlightText);
		btnNewButton.setFont(new Font("UTM Androgyne", Font.PLAIN, 20));
	
		btnNewButton.setBounds(133, 140, 175, 51);
		panel.add(btnNewButton);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("UTM Androgyne", Font.PLAIN, 26));
		lblLogin.setBounds(10, 82, 537, 36);
		contentPane.add(lblLogin);
	}
}
