import java.awt.Font;
import java.util.List;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;

public class classesPanelContent extends JPanel {
	private JTable tableList;

	/**
	 * Create the panel.
	 */
	public classesPanelContent() {
		setSize(521,437);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("CLASSES CONTENT");
		lblNewLabel.setBounds(142, 14, 230, 34);
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
		comboBoxChooseClass.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		comboBoxChooseClass.setBounds(142, 16, 198, 22);
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
		tableList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MSSV", "NAME", "GENDER", "CMND"
			}
		));
		tableList.setBounds(27, 113, 441, 242);
		panel.add(tableList);
//		 JScrollPane js=new JScrollPane(tableList);
//	     js.setVisible(true);
//	    add(js);


		JButton btnNewButton = new JButton("Add Student to Class");
		btnNewButton.setBounds(309, 79, 159, 23);
		panel.add(btnNewButton);
		String sqlClasses = "";
		String sqlStudents = "";
		DefaultTableModel model = new DefaultTableModel();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiberate?characterEncoding=latin1","root","root");
			Statement stmt=con.createStatement();
			sqlClasses = "select * from classes;";
			System.out.println(sqlClasses);
			ResultSet rs = stmt.executeQuery(sqlClasses);

			if(rs.next())
			{
				
				List<String> list = new ArrayList<>();
				while(rs.next()){
					comboBoxChooseClass.addItem(rs.getString("name_class"));
					list.add(rs.getString("name_class"));
					}
				sqlStudents= "select u.*,c.name_class from users as u,classes as c where u.id_class = c.id_class and c.name_class='"+ list.get(0) +"'";
				ResultSet resultStudent = stmt.executeQuery(sqlStudents);
				System.out.println(sqlStudents);
				model.addColumn("MSSV");
				model.addColumn("Name");
				model.addColumn("Gender");
				model.addColumn("CMND");
				if(resultStudent.next())
				{
			
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
				


					
				}
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Get Data Fail");

			}
			
	}catch(Exception e1) {
		System.out.println(e1);
	}
	}
}
