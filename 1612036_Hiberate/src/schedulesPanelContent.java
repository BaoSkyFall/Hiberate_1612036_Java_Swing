import java.awt.Font;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class schedulesPanelContent extends JPanel {

	/**
	 * Create the panel.
	 */
	public String sqlSubjects = "";
//	public String sqlStudents = "";
	public String subjectChoosen= "";
	private JTable tableList;
	private JTable tableSubject;
	private JScrollPane scroll;

	public schedulesPanelContent() {
		setLayout(null);
		setSize(521,600);
		JLabel lblNewLabel = new JLabel("SCHEDULES CONTENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("UTM Androgyne", Font.PLAIN, 17));
		lblNewLabel.setBounds(125, 14, 230, 34);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(20, 59, 491, 530);
		add(panel);
		
		JComboBox comboBoxChooseClass = new JComboBox();
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
		comboBoxChooseClass.setFont(new Font("Arial Black", Font.PLAIN, 16));
		comboBoxChooseClass.setBackground(Color.WHITE);
		comboBoxChooseClass.setBounds(142, 16, 198, 22);
		panel.add(comboBoxChooseClass);
		
		JLabel lblNewLabel_1 = new JLabel("Choose class :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(13, 15, 110, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("List of Subjects");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(27, 79, 143, 23);
		panel.add(lblNewLabel_1_1);
		
		tableSubject = new JTable();
		tableSubject.setBounds(27, 135, 441, 134);
		scroll = new JScrollPane(tableSubject);
		scroll.setFont(new Font("UTM Androgyne", Font.PLAIN, 18));
		scroll.setBounds(27, 135, 441, 134);
		panel.add(scroll);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Student: ");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(27, 309, 143, 23);
		panel.add(lblNewLabel_1_1_1);

		
		
		
	
	
		

		
	
		
		JButton btnImportDataFrom = new JButton("Import data from file");
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
				        List < Subject > list = new ArrayList < > ();
						BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(fi.getPath()), "UTF-8"));
						String className = br.readLine().trim().replace(",", "").toString(); ;
						
						String columns = br.readLine().trim();
						System.out.println(columns);
						Object [] lines = br.lines().toArray();
						for(int i=0;i<lines.length;i++)
						{
							String line = lines[i].toString().trim();
							String[] dataRow = line.split(",");
							list.add(new Subject(dataRow[1],dataRow[2],dataRow[3],className));
							
						}
						 String INSERT_SCHEDULE_SQL = "INSERT INTO subjects (code_subject,name_subject,room,id_class)\r\n" + 
						 		"SELECT * FROM (SELECT ? ,?,?,(SELECT(id_class) as id_class from classes where name_class=?)) as tmp\r\n" + 
						 		"WHERE NOT EXISTS (\r\n" + 
						 		"    SELECT code_subject FROM subjects WHERE code_subject = ?\r\n" + 
						 		") LIMIT 1;";
						 String INSERT_LIST_SUBJECT_SQL="INSERT INTO listsubjectclass (id_user,code_subject)" +
						 	"SELECT * FROM( SELECT u.id_user,s.code_subject from users as u, subjects as s,classes as c WHERE s.code_subject=? and s.id_class=c.id_class and u.id_class= c.id_class) as tmp;";
							System.out.println(INSERT_SCHEDULE_SQL);

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
								comboBoxChooseClass.addItem(className);

							}
								
							
							else
							{
								JOptionPane.showMessageDialog(null,"Can't add new Class: " + className + ". Because it existed");
							}
							try (Connection connection = DriverManager
						            .getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=UTF-8", "root", "root");
						            // Step 2:Create a statement using connection object
						            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(INSERT_SCHEDULE_SQL);
						            PreparedStatement preparedStatement2 = (PreparedStatement) connection.prepareStatement(INSERT_LIST_SUBJECT_SQL);
									) {

						            connection.setAutoCommit(false);
						            for (Iterator<Subject> iterator = list.iterator(); iterator.hasNext();) {
						                Subject subject = (Subject) iterator.next();
						                preparedStatement.setString(1, subject.getCode_subject());
						                preparedStatement.setString(2, subject.getName());
						                preparedStatement.setString(3, subject.getRoom());
						                preparedStatement.setString(4, subject.getname_class());
						                preparedStatement.setString(5, subject.getCode_subject());
						           
						                preparedStatement2.setString(1,subject.getCode_subject());
						                preparedStatement.addBatch();
						                preparedStatement2.addBatch();
						            }
									System.out.println(preparedStatement);							       
						            int[] updateCounts = preparedStatement.executeBatch();
						            int[] updateCounts2 = preparedStatement2.executeBatch();

						            System.out.println(Arrays.toString(updateCounts));
						            System.out.println(Arrays.toString(updateCounts2));
						            connection.commit();
						            connection.setAutoCommit(true);
						            sqlSubjects = "select * from classes;";
									System.out.println(sqlSubjects);
									ResultSet rs2 = stmt.executeQuery(sqlSubjects);
					               
									if(rs2.next())
									{
										
										List<String> list2 = new ArrayList<>();
										 DefaultComboBoxModel<String> dfModel = new DefaultComboBoxModel<String>();
							                comboBoxChooseClass.setModel(dfModel);
										String item = new String(rs2.getString("name_class"));
										comboBoxChooseClass.addItem(item);
										list2.add(rs2.getString("name_class"));
										while(rs2.next()){
										
											comboBoxChooseClass.addItem(rs2.getString("name_class"));
											list2.add(rs2.getString("name_class"));
											}
										showDataTable(list2.get(0), stmt);		
									}
									} catch (BatchUpdateException batchUpdateException) {
						        } catch (SQLException e1) {
						        }
							JOptionPane.showMessageDialog(null,"Add new Schedule in class: " + className + " sucessfull");
							
							
							
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
		btnImportDataFrom.setBounds(352, 25, 159, 23);
		add(btnImportDataFrom);
		
		
		
		
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=UTF-8","root","root");
			Statement stmt=con.createStatement();
			sqlSubjects = "select * from classes;";
			System.out.println(sqlSubjects);
			ResultSet rs = stmt.executeQuery(sqlSubjects);

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
		sqlSubjects= "select s.*,c.name_class from subjects as s,classes as c where s.id_class = c.id_class and c.name_class='"+ className +"'";
		ResultSet resultStudent = stmt.executeQuery(sqlSubjects);
		System.out.println(sqlSubjects);
		subjectChoosen= className;
		if(resultStudent.next())
		{
			 DefaultTableModel model = new DefaultTableModel();
			 int index =1;
			model.addColumn("STT");
			model.addColumn("Code Subject");
			model.addColumn("Name");
			model.addColumn("Room");
			model.addRow(new Object[] {
					index,
					resultStudent.getString("code_subject"),
					resultStudent.getString("name_subject"),
					resultStudent.getString("room"),
					
				});
			while(resultStudent.next())
			{
				index++;
				model.addRow(new Object[] {
					index,
					resultStudent.getString("code_subject"),
					resultStudent.getString("name_subject"),
					resultStudent.getString("room"),
					
				});
			}
			System.out.println(model.getColumnCount());
			tableSubject.setModel(model);
			tableSubject.getColumnModel().getColumn(0).setPreferredWidth(50);
			tableSubject.getColumnModel().getColumn(2).setPreferredWidth(180);


			
		}
		
		
	
	else
	{
		JOptionPane.showMessageDialog(null,"Get Data Fail");

	}
		
	}
}
