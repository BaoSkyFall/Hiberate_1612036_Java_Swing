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
import java.text.DecimalFormat;
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
import com.sun.jdi.connect.Connector.SelectedArgument;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class detailStudentPanelContent extends JPanel {

	/**
	 * Create the panel.
	 */

		private JTable tableList;
		private JScrollPane scroll;

		/**
		 * Create the panel.
		 */
		public String sqlClasses = "";
		public String sqlSubjects = "";
		public String sqlStudents = "";
		public String classChoosen= "";
		public String codeSubjectChoosen="";
		public String mssvChoosen="";
		public float midTermGrade =0;
		public float finalGrade =0;
		public float otherGrade =0;
		public float totalGrade =0;
		public int indexChoosen=-1;
		private JTextField textFieldMidTerm;
		private JTextField textFieldFinal;
		private JTextField textFieldOther;
		public detailStudentPanelContent() {
		
			setSize(900,600);
			setLayout(null);
			JLabel lblNewLabel = new JLabel("GRADE CONTENT");
			lblNewLabel.setBounds(199, 14, 230, 34);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("UTM Androgyne", Font.PLAIN, 17));
			add(lblNewLabel);
			
			JPanel panel = new JPanel();
			panel.setBounds(20, 59, 870, 530);
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			add(panel);
			panel.setLayout(null);
			JComboBox comboBoxSubject = new JComboBox();
			JLabel lblStudentDisplay = new JLabel("Student :");
			lblStudentDisplay.setHorizontalAlignment(SwingConstants.LEFT);
			lblStudentDisplay.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
			lblStudentDisplay.setBounds(27, 296, 242, 23);
			panel.add(lblStudentDisplay);
			comboBoxSubject.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 JComboBox comboBox = (JComboBox) e.getSource();
			          Object o = comboBox.getSelectedItem();
						System.out.println(o);
						codeSubjectChoosen= o.toString();
						
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=UTF-8","root","root");
							Statement stmt=con.createStatement();
							if(o=="All")
							{
//								showDataTable(classChoosen, stmt);
								
							}
							else
							{
								showDataTable(classChoosen,codeSubjectChoosen, stmt);
							}

									
									
								
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						

							
							
				}	
			});
			comboBoxSubject.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
			comboBoxSubject.setBackground(Color.WHITE);
			comboBoxSubject.setBounds(142, 50, 198, 22);
			panel.add(comboBoxSubject);
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
							classChoosen= o.toString();
//							showDataTable(o.toString(), stmt);
							sqlSubjects = "select s.* from subjects as s, classes as c where s.id_class=c.id_class and c.name_class='" +o.toString()+"';";

							ResultSet rs2= stmt.executeQuery(sqlSubjects);
							if(rs2.next())
							{
								List<String> list2 = new ArrayList<>();
				                ComboBoxModel model = comboBoxSubject.getModel();
				                DefaultComboBoxModel<String> dfModel = new DefaultComboBoxModel<String>();
				                //Delete old comboxSubject
//				                for(int i=0;i<model.getSize();i++)
//				                {
//				                	if(i!=0)
//				                	{
//				                		comboBoxSubject.remove(i);;
//				                	}
//				                }
								String item = new String(rs2.getString("code_subject"));
								comboBoxSubject.setModel(dfModel);
								comboBoxSubject.addItem(item);
								list2.add(rs2.getString("code_subject"));
								while(rs2.next()){
								
									comboBoxSubject.addItem(rs2.getString("code_subject"));
									list2.add(rs2.getString("code_subject"));
									}
							}
									
									
								
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
			
			JLabel lblNewLabel_1_1 = new JLabel("List of Grades");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
			lblNewLabel_1_1.setBounds(27, 79, 143, 23);
			panel.add(lblNewLabel_1_1);

			tableList = new JTable();
	
			tableList.setUpdateSelectionOnSort(false);
			tableList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tableList.setBounds(27, 135, 441, 134);
			scroll = new JScrollPane(tableList);
			scroll.setFont(new Font("UTM Androgyne", Font.PLAIN, 18));
			scroll.setBounds(27, 135, 820, 134);
			panel.add(scroll);
			
		
			
			JLabel lblNewLabel_1_2 = new JLabel("Choose subject :");
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_2.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
			lblNewLabel_1_2.setBounds(0, 49, 123, 23);
			panel.add(lblNewLabel_1_2);
			
		
			
			JButton btnDeleteStudent = new JButton("Update grade");
			btnDeleteStudent.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(mssvChoosen);
					System.out.println(codeSubjectChoosen);
					System.out.println(midTermGrade);
					System.out.println(finalGrade);
					System.out.println(otherGrade);
					if(mssvChoosen.length()>0)
					{
						if(codeSubjectChoosen =="All")
						{
							JOptionPane.showMessageDialog(null,"Cant' delete Student have identiy: " + mssvChoosen + ". Because it require in class");
						}
						else
						{
//							
//							try {
//								Class.forName("com.mysql.jdbc.Driver");
//								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=UTF-8","root","root");
//								Statement stmt=con.createStatement();
//								String sqlInsert ="DELETE FROM listsubjectclass where id_user = (select u.id_user from users as u where u.indentity_student= ?) and code_subject=?;";
//								PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sqlInsert);
//								pstmt.setString(1, mssvChoosen);
//								pstmt.setString(2, codeSubjectChoosen);
//								int rs = pstmt.executeUpdate();
//								System.out.println(rs);
//								if(rs!=0)
//								{
//									try {
//									
//										if(codeSubjectChoosen=="All")
//										{
////											showDataTable(classChoosen, stmt);
//											
//										}
//										else
//										{
//											sqlSubjects = "select u.* from listsubjectclass as lsc, users as u,subjects as s where s.code_subject = lsc.code_subject \r\n" + 
//													"and u.id_user = lsc.id_user and lsc.code_subject = '"+ codeSubjectChoosen + "';";
//											ResultSet rs2= stmt.executeQuery(sqlSubjects);
//											if(rs2.next())
//											{
//												 DefaultTableModel model = new DefaultTableModel();
//													model.addColumn("MSSV");
//													model.addColumn("Name");
//													model.addColumn("Gender");
//													model.addColumn("CMND");
//													model.addRow(new Object[] {
//															rs2.getString("indentity_student"),
//															rs2.getString("name"),
//															rs2.getBoolean("gender")? "Male": "Female",
//																	rs2.getString("indentity_number"),
//															
//														});
//													while(rs2.next())
//													{
//														model.addRow(new Object[] {
//															rs2.getString("indentity_student"),
//															rs2.getString("name"),
//															rs2.getBoolean("gender")? "Male": "Female",
//															rs2.getString("indentity_number"),
//															
//														});
//													}
//													System.out.println(model.getColumnCount());
//													tableList.setModel(model);
//													tableList.getColumnModel().getColumn(1).setPreferredWidth(180);
//											}
//										}
//
//												
//												
//											
//									}  catch (SQLException e1) {
//										// TODO Auto-generated catch block
//										e1.printStackTrace();
//									}	
//									JOptionPane.showMessageDialog(null,"Delete Student have identiy: " + mssvChoosen + " sucessfull");
//
//								}
//									
//								
//								else
//								{
//									JOptionPane.showMessageDialog(null,"Can't Delete Student: " + mssvChoosen );
//								}
//
//								
//								
//							} catch (Exception e2) {
//								System.out.println(e2.getMessage());
//								JOptionPane.showMessageDialog(null,e2.getMessage());
//
//								// TODO: handle exception
//							}
							
						}
						
					}
				}
			});
			btnDeleteStudent.setBounds(110, 455, 159, 23);
			panel.add(btnDeleteStudent);
			
			JLabel lblName = new JLabel("Name :");
			lblName.setHorizontalAlignment(SwingConstants.LEFT);
			lblName.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
			lblName.setBounds(45, 330, 56, 23);
			panel.add(lblName);
			
			JLabel lblMidTerm = new JLabel("Mid Term : ");
			lblMidTerm.setHorizontalAlignment(SwingConstants.LEFT);
			lblMidTerm.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
			lblMidTerm.setBounds(20, 360, 81, 23);
			panel.add(lblMidTerm);
			
			JLabel lblFinal = new JLabel("Final :  ");
			lblFinal.setHorizontalAlignment(SwingConstants.LEFT);
			lblFinal.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
			lblFinal.setBounds(51, 390, 50, 23);
			panel.add(lblFinal);
			
			JLabel lblOther = new JLabel("Other :");
			lblOther.setHorizontalAlignment(SwingConstants.LEFT);
			lblOther.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
			lblOther.setBounds(44, 420, 56, 23);
			panel.add(lblOther);
			
			textFieldMidTerm = new JTextField();
			textFieldMidTerm.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					 JTextField textField = (JTextField) e.getSource();
					 if(textField.getText().length()>0)
					 {
					     midTermGrade = Float.parseFloat(textField.getText().toString());
//						 if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
//							 textFieldMidTerm.setEditable(true);
//				            } else {
//				            	textFieldMidTerm.setEditable(false);
//				            } 
					 }
				 
				}
			});
			textFieldMidTerm.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
			textFieldMidTerm.setColumns(10);
			textFieldMidTerm.setBounds(111, 364, 158, 20);
			panel.add(textFieldMidTerm);
			
			textFieldFinal = new JTextField();
			textFieldFinal.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					 JTextField textField1 = (JTextField) e.getSource();
					 if(textField1.getText().length()>0)
					 {
					     finalGrade = Float.parseFloat(textField1.getText().toString());
//						 if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
//							 textFieldMidTerm.setEditable(true);
//				            } else {
//				            	textFieldMidTerm.setEditable(false);
//				            } 
					 }				}
			});
			textFieldFinal.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
			textFieldFinal.setColumns(10);
			textFieldFinal.setBounds(111, 394, 158, 20);
			panel.add(textFieldFinal);
			
			textFieldOther = new JTextField();
			textFieldOther.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					 JTextField textField2 = (JTextField) e.getSource();
					 if(textField2.getText().length()>0)
					 {
					     otherGrade = Float.parseFloat(textField2.getText().toString());
//						 if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
//							 textFieldMidTerm.setEditable(true);
//				            } else {
//				            	textFieldMidTerm.setEditable(false);
//				            } 
					 }
				}
			});
			textFieldOther.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
			textFieldOther.setColumns(10);
			textFieldOther.setBounds(111, 424, 158, 20);
			panel.add(textFieldOther);
			
			JLabel lblNameDisplay = new JLabel("");
			lblNameDisplay.setHorizontalAlignment(SwingConstants.LEFT);
			lblNameDisplay.setFont(new Font("UTM Bienvenue", Font.PLAIN, 16));
			lblNameDisplay.setBounds(111, 330, 158, 23);
			panel.add(lblNameDisplay);
			
			JButton btnImportDataFrom = new JButton("Import data from file");
			btnImportDataFrom.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnImportDataFrom.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JFileChooser fileChooser = new JFileChooser();
//					FileNameExtensionFilter filterFileChooser = new FileNameExtensionFilter(".csv","xls");
//					fileChooser.setFileFilter(filterFileChooser);
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
			btnImportDataFrom.setBounds(546, 25, 159, 23);
			add(btnImportDataFrom);
			tableList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					DefaultTableModel modelDefault = (DefaultTableModel)tableList.getModel();
					int selectedRowIndex = tableList.getSelectedRow();
					
					lblStudentDisplay.setText("Student: " + modelDefault.getValueAt(selectedRowIndex, 1).toString());
					lblNameDisplay.setText( modelDefault.getValueAt(selectedRowIndex, 2).toString());
					
					textFieldMidTerm.setText(modelDefault.getValueAt(selectedRowIndex, 3).toString());
					textFieldFinal.setText(modelDefault.getValueAt(selectedRowIndex, 4).toString());
					textFieldOther.setText(modelDefault.getValueAt(selectedRowIndex, 5).toString());
					midTermGrade = Float.parseFloat(modelDefault.getValueAt(selectedRowIndex, 3).toString());
					finalGrade = Float.parseFloat(modelDefault.getValueAt(selectedRowIndex, 4).toString());
					otherGrade = Float.parseFloat(modelDefault.getValueAt(selectedRowIndex, 5).toString());
					totalGrade = Float.parseFloat(modelDefault.getValueAt(selectedRowIndex, 6).toString());
					mssvChoosen = modelDefault.getValueAt(selectedRowIndex, 1).toString();
					indexChoosen= tableList.getSelectedRow();
				}
			});
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=UTF-8","root","root");
				Statement stmt=con.createStatement();
				sqlClasses = "select * from classes;";

				System.out.println(sqlClasses);
				ResultSet rs = stmt.executeQuery(sqlClasses);
				List<String> list = new ArrayList<>();
				List<String> list2 = new ArrayList<>();

				if(rs.next())
				{
					
					
					String item = new String(rs.getString("name_class"));
					comboBoxChooseClass.addItem(item);
					classChoosen= item;
					list.add(rs.getString("name_class"));
					sqlSubjects = "select s.* from subjects as s, classes as c where s.id_class=c.id_class and c.id_class=" + rs.getString("id_class");
					while(rs.next()){
					
						comboBoxChooseClass.addItem(rs.getString("name_class"));
						list.add(rs.getString("name_class"));
						}
				
				}
				ResultSet rs2= stmt.executeQuery(sqlSubjects);
				if(rs2.next())
				{
					
					String item = new String(rs2.getString("code_subject"));
					codeSubjectChoosen = item;
					comboBoxSubject.addItem(item);
					list2.add(rs2.getString("code_subject"));
					while(rs2.next()){
					
						comboBoxSubject.addItem(rs2.getString("code_subject"));
						list2.add(rs2.getString("code_subject"));
						}
				}
				showDataTable(list.get(0),list2.get(0), stmt);

				
			}catch(Exception e1) {
			System.out.println(e1);
		}
		}

		
		public void showDataTable(String className,String codeSubject,Statement stmt) throws SQLException
		{
			if(className.length()>0 && codeSubject.length()>0)
			{
				sqlStudents=
						"select u.*,g.* from users as u, subjects as s, grades as g where u.id_user = g.id_user and s.code_subject = g.code_subject \r\n" + 
						"and u.id_class = (select id_class from classes where name_class='"+ className+ "') and g.code_subject='"+ codeSubject+"';";
				ResultSet resultStudent = stmt.executeQuery(sqlStudents);
				System.out.println(sqlStudents);
				classChoosen= className;
				if(resultStudent.next())
				{
					int index =1;
					 DefaultTableModel model = new DefaultTableModel();
					model.addColumn("STT");
					model.addColumn("MSSV");
					model.addColumn("Name");
					model.addColumn("Mid Term");
					model.addColumn("Final");
					model.addColumn("Other");
					model.addColumn("Total");
					model.addColumn("Status");
					model.addRow(new Object[] {
							index++,
							resultStudent.getString("indentity_student"),
							resultStudent.getString("name"),
							resultStudent.getString("midterm_grade"),
							resultStudent.getString("final_grade"),
							resultStudent.getString("other_grade"),
							resultStudent.getString("average_grade"),
							resultStudent.getInt("average_grade")>=5? "Pass" : "Fail",
							
						});
					while(resultStudent.next())
					{
						model.addRow(new Object[] {
								index++,
								resultStudent.getString("indentity_student"),
								resultStudent.getString("name"),
								resultStudent.getString("midterm_grade"),
								resultStudent.getString("final_grade"),
								resultStudent.getString("other_grade"),
								resultStudent.getString("average_grade"),
								resultStudent.getInt("average_grade")>=5? "Pass" : "Fail",
							
						});
					}
					System.out.println(model.getColumnCount());
					tableList.setModel(model);
					tableList.getColumnModel().getColumn(2).setPreferredWidth(160);


					
				}
				
				
			
			else
			{
				JOptionPane.showMessageDialog(null,"Get Data Fail");

			}
			}
			
			
		}
		public void caculateTotalGrade()
		{
			DecimalFormat df = new DecimalFormat("#.##");
			System.out.println(midTermGrade);
			System.out.println(finalGrade);
			System.out.println(otherGrade);
			float avg = (midTermGrade + finalGrade + otherGrade)/3;
			System.out.println(avg);
			lblTotalDisplay.setText(df.format(avg));
			totalGrade = avg;
		}
}


