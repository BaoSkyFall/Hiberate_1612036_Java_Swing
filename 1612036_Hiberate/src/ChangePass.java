import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChangePass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordFieldOld;
	private Image img_logo = new ImageIcon("img/Meeting-04.png").getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image img_hcmus = new ImageIcon("img/hcmus-cover.png").getImage().getScaledInstance(350,150,Image.SCALE_SMOOTH);
	private JPasswordField passwordFieldNew;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePass frame = new ChangePass();
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
	public ChangePass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 557, 516);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel = new JLabel("HIBERATE PORTAL APPLICATION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("UTM Androgyne", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 11, 537, 36);
		contentPane_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(18, 153, 493, 303);
		contentPane_1.add(panel);
		
		JLabel lblLogin_1 = new JLabel("Username :");
		lblLogin_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin_1.setForeground(Color.BLACK);
		lblLogin_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 20));
		lblLogin_1.setBounds(54, 23, 123, 36);
		panel.add(lblLogin_1);
		
		JLabel lblLogin_1_1 = new JLabel("Old Password :");
		lblLogin_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin_1_1.setForeground(Color.BLACK);
		lblLogin_1_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 20));
		lblLogin_1_1.setBounds(38, 72, 139, 36);
		panel.add(lblLogin_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("UTM Androgyne", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(207, 23, 257, 34);
		panel.add(textField);
		
		passwordFieldOld = new JPasswordField();
		passwordFieldOld.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordFieldOld.setBounds(207, 75, 257, 34);
		panel.add(passwordFieldOld);
		
		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=latin1","root","root");
					Statement stmt=con.createStatement();
					String sql = "select * from users where username= '"+ textField.getText()+ "' and password='"+passwordFieldOld.getText().toString()+ "'";
					System.out.println(sql);
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next())
					{
						String sqlInsert ="update users set password =?" + 
								"where username=?;";
						PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sqlInsert);
						pstmt.setString(2, textField.getText());
						pstmt.setString(1, passwordFieldNew.getText().toString());
						int rs1 = pstmt.executeUpdate();
						if(rs1!=0)
						{
							JOptionPane.showMessageDialog(null,"Change password sucessfull");
							Login Login = new Login();
							Login.setVisible(true);
							ChangePass.this.dispose();
						}
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Wrong password or User");

					}
					
			}catch(Exception e1) {
				System.out.println(e1);
			}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("UTM Androgyne", Font.PLAIN, 20));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setBounds(143, 179, 218, 51);
		panel.add(btnNewButton);
		
		JLabel lblLogin_1_1_1 = new JLabel("New Password :");
		lblLogin_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin_1_1_1.setForeground(Color.BLACK);
		lblLogin_1_1_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 20));
		lblLogin_1_1_1.setBounds(0, 120, 175, 36);
		panel.add(lblLogin_1_1_1);
		
		passwordFieldNew = new JPasswordField();
		passwordFieldNew.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordFieldNew.setBounds(207, 123, 257, 34);
		panel.add(passwordFieldNew);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login Login = new Login();
				Login.setVisible(true);
				ChangePass.this.dispose();
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("UTM Androgyne", Font.PLAIN, 20));
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setBounds(143, 241, 218, 51);
		panel.add(btnLogin);
		
		JLabel lblLogin = new JLabel("");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("UTM Androgyne", Font.PLAIN, 26));
		lblLogin.setBounds(63, 58, 448, 90);
		lblLogin.setIcon(new ImageIcon(img_logo));
		contentPane_1.add(lblLogin);
	}
}
