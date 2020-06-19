import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.sql.Array;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.mysql.jdbc.PreparedStatement;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

public class classesPanelContent extends JPanel {
	private JTable tableList;
	private JScrollPane scroll;

	/**
	 * Create the panel.
	 */
	public String sqlClasses = "";
	public String sqlStudents = "";
	public String classChoosen= "";
	public classesPanelContent() {
	
		setSize(521,437);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("CLASSES CONTENT");
		lblNewLabel.setBounds(125, 14, 230, 34);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("UTM Androgyne", Font.PLAIN, 17));
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 59, 491, 366);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);
		panel.setLayout(null);
		
		JComboBox comboBoxChooseClass = new JComboBox();
		comboBoxChooseClass.setBackground(new Color(255, 255, 255));
		comboBoxChooseClass.setFont(new Font("Arial Black", Font.PLAIN, 16));
		comboBoxChooseClass.setBounds(142, 16, 198, 22);
		comboBoxChooseClass.addActionListener(new ActionListener() {

	      

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 JComboBox comboBox = (JComboBox) e.getSource();
		          Object o = comboBox.getSelectedItem();
					System.out.println(o);
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=UTF-8","root","root");
						Statement stmt=con.createStatement();
						
						showDataTable(o.toString(), stmt);

								
								
							
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
						
						
			}	
		          
				
		});
		panel.add(comboBoxChooseClass);
		
		JLabel lblNewLabel_1 = new JLabel("Choose class :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(13, 15, 110, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("List of Students");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(27, 79, 143, 23);
		panel.add(lblNewLabel_1_1);

		tableList = new JTable();
		tableList.setUpdateSelectionOnSort(false);
		tableList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableList.setBounds(27, 135, 441, 220);
		scroll = new JScrollPane(tableList);
		scroll.setFont(new Font("UTM Androgyne", Font.PLAIN, 18));
		scroll.setBounds(27, 135, 441, 220);
		panel.add(scroll);

		

		JButton btnNewButton = new JButton("Add Student to Class");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mssv = JOptionPane.showInputDialog(null,"MSSV");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=latin1","root","root");
					Statement stmt=con.createStatement();
					String sqlInsert ="update users set id_class =(select id_class from classes where name_class=?) where indentity_student=?;";
					PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sqlInsert);
					pstmt.setString(1, classChoosen);
					pstmt.setString(2, mssv);
					int rs = pstmt.executeUpdate();
					System.out.println(rs);
					showDataTable(classChoosen, stmt);
					if(rs!=0)
					{
						JOptionPane.showMessageDialog(null,"Add student into class " + classChoosen + " sucessfull");

					}

					
					
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
					JOptionPane.showMessageDialog(null,e2.getMessage());

					// TODO: handle exception
				}
			}
		});
		btnNewButton.setBounds(309, 79, 159, 23);
		panel.add(btnNewButton);
		
		JComboBox comboBoxChooseClass_1 = new JComboBox();
		comboBoxChooseClass_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		comboBoxChooseClass_1.setBackground(Color.WHITE);
		comboBoxChooseClass_1.setBounds(142, 50, 198, 22);
		panel.add(comboBoxChooseClass_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Choose subject :");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(0, 49, 123, 23);
		panel.add(lblNewLabel_1_2);
		
		JButton btnImportDataFrom = new JButton("Import data from file");
		btnImportDataFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImportDataFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
//				FileNameExtensionFilter filterFileChooser = new FileNameExtensionFilter(".csv","xls");
//				fileChooser.setFileFilter(filterFileChooser);
				fileChooser.setMultiSelectionEnabled(false);
				int  x= fileChooser.showDialog(panel, "Chon File");
				if(x==JFileChooser.APPROVE_OPTION)
				{
					File fi = fileChooser.getSelectedFile();
					try {
				        List < User > list = new ArrayList < > ();
						BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(fi.getPath()), "UTF-8"));
						String className = br.readLine().trim().replace(",", "").toString(); ;
						
						String columns = br.readLine().trim();
						System.out.println(columns);
						Object [] lines = br.lines().toArray();
						for(int i=0;i<lines.length;i++)
						{
							String line = lines[i].toString().trim();
							String[] dataRow = line.split(",");
							list.add(new User(dataRow[1],dataRow[1],dataRow[2],dataRow[4],dataRow[3].toLowerCase() =="nam"?true:false,dataRow[1],className));
							
						}
						 String INSERT_USERS_SQL = "INSERT INTO users (username,password,name,indentity_number,gender,indentity_student,id_class)\r\n" + 
						 		"SELECT * FROM (SELECT ? as username ,? as password,?,?,?,? as indentity_number,(SELECT(id_class) as id_class from classes where name_class=?)) as tmp\r\n" + 
						 		"WHERE NOT EXISTS (\r\n" + 
						 		"    SELECT username FROM users WHERE username = ?\r\n" + 
						 		") LIMIT 1;";
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=UTF-8","root","root");
							Statement stmt=con.createStatement();
							String sqlInsert ="INSERT INTO classes (name_class) SELECT * FROM (SELECT ?) AS tmp WHERE NOT EXISTS (SELECT name_class FROM classes WHERE name_class = ?) LIMIT 1;";
							PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sqlInsert);
							pstmt.setString(1, className);
							pstmt.setString(2, className);
							int rs = pstmt.executeUpdate();
							System.out.println(rs);
							if(rs!=0)
							{
								JOptionPane.showMessageDialog(null,"Add new Class: " + className + " sucessfull");
								 try (Connection connection = DriverManager
								            .getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=UTF-8", "root", "root");
								            // Step 2:Create a statement using connection object
								            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(INSERT_USERS_SQL)) {
								            connection.setAutoCommit(false);
								            for (Iterator < User > iterator = list.iterator(); iterator.hasNext();) {
								                User user = (User) iterator.next();
								                preparedStatement.setString(1, user.getUsername());
								                preparedStatement.setString(2, user.getUsername());
								                preparedStatement.setString(3, user.getName());
								                preparedStatement.setString(4, user.getIndentity_number());
								                preparedStatement.setBoolean(5, user.getGender());
								                preparedStatement.setString(6, user.getUsername());
								                preparedStatement.setString(7, user.getname_class());
								                preparedStatement.setString(8, user.getUsername());
								                preparedStatement.addBatch();
								            }
											System.out.println(preparedStatement);							       
								            int[] updateCounts = preparedStatement.executeBatch();
								            System.out.println(Arrays.toString(updateCounts));
								            connection.commit();
								            connection.setAutoCommit(true);
								        } catch (BatchUpdateException batchUpdateException) {
								        } catch (SQLException e1) {
								        }
									comboBoxChooseClass.addItem(className);

							}
								
							
							else
							{
								JOptionPane.showMessageDialog(null,"Can't add new Class: " + className + ". Because it existed");
							}

							
							
						} catch (Exception e2) {
							System.out.println(e2.getMessage());
							JOptionPane.showMessageDialog(null,e2.getMessage());

							// TODO: handle exception
						}
						
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

					}
				

		
		
		});
		btnImportDataFrom.setBounds(337, 25, 159, 23);
		add(btnImportDataFrom);
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=UTF-8","root","root");
			Statement stmt=con.createStatement();
			sqlClasses = "select * from classes;";
			System.out.println(sqlClasses);
			ResultSet rs = stmt.executeQuery(sqlClasses);

			if(rs.next())
			{
				
				List<String> list = new ArrayList<>();
				
				String item = new String(rs.getString("name_class"));
				comboBoxChooseClass.addItem(item);
				list.add(rs.getString("name_class"));
				while(rs.next()){
				
					comboBoxChooseClass.addItem(rs.getString("name_class"));
					list.add(rs.getString("name_class"));
					}
				showDataTable(list.get(0), stmt);
			
	}
		}catch(Exception e1) {
		System.out.println(e1);
	}
	}
	
	public void showDataTable(String className,Statement stmt) throws SQLException
	{
		sqlStudents= "select u.*,c.name_class from users as u,classes as c where u.id_class = c.id_class and c.name_class='"+ className +"'";
		ResultSet resultStudent = stmt.executeQuery(sqlStudents);
		System.out.println(sqlStudents);
		classChoosen= className;
		if(resultStudent.next())
		{
			 DefaultTableModel model = new DefaultTableModel();
			model.addColumn("MSSV");
			model.addColumn("Name");
			model.addColumn("Gender");
			model.addColumn("CMND");
			model.addRow(new Object[] {
					resultStudent.getString("indentity_student"),
					resultStudent.getString("name"),
					resultStudent.getBoolean("gender")? "Male": "Female",
					resultStudent.getString("indentity_number"),
					
				});
			while(resultStudent.next())
			{
				model.addRow(new Object[] {
					resultStudent.getString("indentity_student"),
					resultStudent.getString("name"),
					resultStudent.getBoolean("gender")? "Male": "Female",
					resultStudent.getString("indentity_number"),
					
				});
			}
			System.out.println(model.getColumnCount());
			tableList.setModel(model);
			tableList.getColumnModel().getColumn(1).setPreferredWidth(180);


			
		}
		
		
	
	else
	{
		JOptionPane.showMessageDialog(null,"Get Data Fail");

	}
		
	}
}
