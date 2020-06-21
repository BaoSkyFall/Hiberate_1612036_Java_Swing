import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public String username = "";
	public String name = "";
	public String codeSubjectChoosen;
	public JLabel lblHi;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student("");
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
	public void setName(String username1)
	{
		this.name = username1;
		lblHi.setText("Hi, " + username1);
	}
	public Student(String username) {
		this.username = username;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 375, 284);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Choose subject :");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(0, 49, 123, 23);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblMidTerm = new JLabel("Mid Term : ");
		lblMidTerm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMidTerm.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
		lblMidTerm.setBounds(42, 125, 81, 23);
		panel.add(lblMidTerm);
		
		JLabel lblFinal = new JLabel("Final :  ");
		lblFinal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFinal.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
		lblFinal.setBounds(73, 156, 50, 23);
		panel.add(lblFinal);
		
		JLabel lblOther = new JLabel("Other :");
		lblOther.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOther.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
		lblOther.setBounds(67, 186, 56, 23);
		panel.add(lblOther);
		
		JLabel lblNameDisplay = new JLabel("");
		lblNameDisplay.setHorizontalAlignment(SwingConstants.LEFT);
		lblNameDisplay.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
		lblNameDisplay.setBounds(111, 330, 158, 23);
		panel.add(lblNameDisplay);
		
		JComboBox comboBoxSubject = new JComboBox();

		comboBoxSubject.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		comboBoxSubject.setBackground(Color.WHITE);
		comboBoxSubject.setBounds(132, 49, 198, 22);
		panel.add(comboBoxSubject);
		
		JLabel lblTotal = new JLabel("Total : ");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
		lblTotal.setBounds(67, 220, 56, 23);
		panel.add(lblTotal);
		
		JLabel lblMidTermDisplay = new JLabel("0");
		lblMidTermDisplay.setHorizontalAlignment(SwingConstants.LEFT);
		lblMidTermDisplay.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
		lblMidTermDisplay.setBounds(133, 125, 123, 23);
		panel.add(lblMidTermDisplay);
		
		JLabel lblFinalDisplay = new JLabel("0");
		lblFinalDisplay.setHorizontalAlignment(SwingConstants.LEFT);
		lblFinalDisplay.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
		lblFinalDisplay.setBounds(133, 156, 123, 23);
		panel.add(lblFinalDisplay);
		
		JLabel lblOtherDisplay = new JLabel("0");
		lblOtherDisplay.setHorizontalAlignment(SwingConstants.LEFT);
		lblOtherDisplay.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
		lblOtherDisplay.setBounds(133, 186, 123, 23);
		panel.add(lblOtherDisplay);
		
		JLabel lblTotalDisplay = new JLabel("0");
		lblTotalDisplay.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalDisplay.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
		lblTotalDisplay.setBounds(133, 220, 123, 23);
		panel.add(lblTotalDisplay);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login Login = new Login();
				Login.setVisible(true);

				Student.this.dispose();
			}
			
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("UTM Androgyne", Font.PLAIN, 14));
		btnLogout.setBackground(SystemColor.textHighlight);
		btnLogout.setBounds(266, 235, 81, 27);
		panel.add(btnLogout);
		
		 lblHi = new JLabel("Hi ");
		lblHi.setHorizontalAlignment(SwingConstants.LEFT);
		lblHi.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
		lblHi.setBounds(10, 11, 320, 23);
		panel.add(lblHi);
		
		comboBoxSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JComboBox comboBox = (JComboBox) e.getSource();
		          Object o = comboBox.getSelectedItem();
					System.out.println(o);
					codeSubjectChoosen= o.toString();
					try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=latin1","root","root");
					Statement stmt=con.createStatement();
					String sql= "select g.* from users as u, grades as g \r\n" + 
							"where u.id_user = g.id_user and g.code_subject = '"+ codeSubjectChoosen+ "' and u.username='"+ username + "'";
					ResultSet rs2 = stmt.executeQuery(sql);
					if(rs2.next())
					{
						lblMidTermDisplay.setText(rs2.getString("midterm_grade"));
						lblFinalDisplay.setText(rs2.getString("final_grade"));
						lblOtherDisplay.setText(rs2.getString("other_grade"));
						lblTotalDisplay.setText(rs2.getString("average_grade"));
					}
					else
					{
						JOptionPane.showMessageDialog(null,"You don't have any Score in this subject: "+ codeSubjectChoosen);
					}
					}
					catch(Exception e1) {
						System.out.println(e1);
					}
					
			}
		});
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=latin1","root","root");
			Statement stmt=con.createStatement();
			String sql = "select distinct s.* from subjects as s, grades as g, users as u\r\n" + 
					"where s.code_subject = g.code_subject and u.id_user= g.id_user and u.username = '"+ username +"';";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			List<String> list2 = new ArrayList<>();

			if(rs.next())
			{
			
				
				String item = new String(rs.getString("code_subject"));
				codeSubjectChoosen = item;
				comboBoxSubject.addItem(item);
				list2.add(rs.getString("code_subject"));
				while(rs.next()){
				
					comboBoxSubject.addItem(rs.getString("code_subject"));
					list2.add(rs.getString("code_subject"));
					}
				sql= "select g.* from users as u, grades as g \r\n" + 
						"where u.id_user = g.id_user and g.code_subject = '"+ codeSubjectChoosen+ "' and u.username='"+ username + "'";
				ResultSet rs2 = stmt.executeQuery(sql);
				if(rs2.next())
				{
					lblMidTermDisplay.setText(rs2.getString("midterm_grade"));
					lblFinalDisplay.setText(rs2.getString("final_grade"));
					lblOtherDisplay.setText(rs2.getString("other_grade"));
					lblTotalDisplay.setText(rs2.getString("average_grade"));
				}
				else
				{
					JOptionPane.showMessageDialog(null,"You don't have any Score in this subject: "+ codeSubjectChoosen);
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"You don't have any subject have Score!");

			}
			
	}catch(Exception e1) {
		System.out.println(e1);
	}
		
		
		
		
		
	}
}
