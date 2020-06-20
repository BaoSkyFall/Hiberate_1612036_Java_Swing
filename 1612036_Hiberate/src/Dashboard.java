import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private JLabel lblPortal;
	private JPanel panelHome;
	private JPanel panelViewClasses;
	private JPanel panelSchedules;
	private JPanel panelDetailStudent;
	private JPanel panelReExamination;
	private JPanel panelLogout;
	private JLabel lbl_home;
	private JPanel panelContent;
	private homePanelContent homePanelContent;
	private detailStudentPanelContent detailStudentContent;
	private classesPanelContent classesPanelContent;
	private reExaminationsPanelContent reExaminationsPanelContent;
	private schedulesPanelContent schedulesPanelContent;
	private Image img_logo = new ImageIcon("img/hcmus.png").getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image img_home = new ImageIcon("img/home-run.png").getImage().getScaledInstance(45,45,Image.SCALE_SMOOTH);
	private Image img_classes = new ImageIcon("img/school.png").getImage().getScaledInstance(45,45,Image.SCALE_SMOOTH);
	private Image img_schedules = new ImageIcon("img/calendar.png").getImage().getScaledInstance(45,45,Image.SCALE_SMOOTH);
	private Image img_students = new ImageIcon("img/Meeting-02.png").getImage().getScaledInstance(45,45,Image.SCALE_SMOOTH);
	private Image img_reExam = new ImageIcon("img/SEO-16.png").getImage().getScaledInstance(45,45,Image.SCALE_SMOOTH);
	private Image img_logout = new ImageIcon("img/Logout.png").getImage().getScaledInstance(45,45,Image.SCALE_SMOOTH);
	private JLabel lblIconClasses;
	private JLabel lblIconSchedules;
	private JLabel lblIconStudents;
	private JLabel lblIconReExaminations;
	private JLabel lblIconLogout;
	private detailStudentPanelContent detailStudentPanelContent;
	private JLabel lblPortal_2;
	private JLabel lblUser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 230, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblPortal = new JLabel("");
		lblPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortal.setBounds(10, 11, 90, 90);
		lblPortal.setFont(new Font("UTM Androgyne", Font.PLAIN, 24));
		lblPortal.setLayout(null);
		lblPortal.setIcon(new ImageIcon(img_logo));
		panel.add(lblPortal);
		
		panelHome = new JPanel();
		panelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(homePanelContent,panelHome);
			}
		});
		panelHome.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelHome.setBackground(new Color(255, 0, 0));
		panelHome.setBounds(-1, 104, 230, 51);
		panel.add(panelHome);
		panelHome.setLayout(null);
		
		lbl_home = new JLabel("Home");
		lbl_home.setForeground(Color.WHITE);
		lbl_home.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_home.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lbl_home.setBounds(74, 11, 118, 20);
		panelHome.add(lbl_home);
		
		JLabel lblIconHome = new JLabel("");
		lblIconHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(homePanelContent,panelHome);
			}
		});
		lblIconHome.setBounds(19, 0, 45, 45);
		lblIconHome.setIcon(new ImageIcon(img_home));
		panelHome.add(lblIconHome);
		
		panelViewClasses = new JPanel();
		panelViewClasses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(classesPanelContent,panelViewClasses);

			}
		});
		panelViewClasses.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelViewClasses.setBackground(new Color(112, 128, 144));
		panelViewClasses.setBounds(-1, 152, 230, 51);
		panel.add(panelViewClasses);
		panelViewClasses.setLayout(null);
		
		JLabel lbl_viewClass = new JLabel("View Classes");
		lbl_viewClass.setForeground(Color.WHITE);
		lbl_viewClass.setBounds(80, 11, 113, 24);
		lbl_viewClass.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_viewClass.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		panelViewClasses.add(lbl_viewClass);
		
		lblIconClasses = new JLabel("");
		lblIconClasses.setBounds(10, 0, 45, 45);
		lblIconClasses.setIcon(new ImageIcon(img_classes));

		panelViewClasses.add(lblIconClasses);
		
		panelSchedules = new JPanel();
		panelSchedules.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(schedulesPanelContent,panelSchedules);
			}
		});
		panelSchedules.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelSchedules.setBackground(new Color(112, 128, 144));
		panelSchedules.setBounds(-1, 203, 230, 51);
		panel.add(panelSchedules);
		panelSchedules.setLayout(null);
		
		JLabel lbl_home_1_1 = new JLabel("View Schedules");
		lbl_home_1_1.setForeground(Color.WHITE);
		lbl_home_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_home_1_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lbl_home_1_1.setBounds(69, 11, 125, 24);
		panelSchedules.add(lbl_home_1_1);
		
		lblIconSchedules = new JLabel("");
		lblIconSchedules.setBounds(10, 0, 45, 45);
		lblIconSchedules.setIcon(new ImageIcon(img_schedules));
		panelSchedules.add(lblIconSchedules);
		
		panelDetailStudent = new JPanel();
		panelDetailStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(detailStudentPanelContent,panelDetailStudent);
			}
		});
		panelDetailStudent.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelDetailStudent.setBackground(new Color(112, 128, 144));
		panelDetailStudent.setBounds(-1, 253, 230, 51);
		panel.add(panelDetailStudent);
		panelDetailStudent.setLayout(null);
		
		JLabel lbl_home_1_1_1 = new JLabel("View Grades");
		lbl_home_1_1_1.setForeground(Color.WHITE);
		lbl_home_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_home_1_1_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lbl_home_1_1_1.setBounds(79, 11, 117, 24);
		panelDetailStudent.add(lbl_home_1_1_1);
		
		lblIconStudents = new JLabel("");
		lblIconStudents.setBounds(10, 0, 45, 45);
		lblIconStudents.setIcon(new ImageIcon(img_students));
		panelDetailStudent.add(lblIconStudents);
		
		panelReExamination = new JPanel();
		panelReExamination.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(reExaminationsPanelContent,panelReExamination);
			}
		});
		panelReExamination.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelReExamination.setBackground(new Color(112, 128, 144));
		panelReExamination.setBounds(-1, 305, 230, 51);
		panel.add(panelReExamination);
		panelReExamination.setLayout(null);
		
		JLabel panelReExaminations = new JLabel("Re-Examinations");
		panelReExaminations.setForeground(Color.WHITE);
		panelReExaminations.setHorizontalAlignment(SwingConstants.RIGHT);
		panelReExaminations.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		panelReExaminations.setBounds(63, 11, 133, 24);
		panelReExamination.add(panelReExaminations);
		
		lblIconReExaminations = new JLabel("");
	
		lblIconReExaminations.setBounds(10, 0, 45, 45);
		lblIconReExaminations.setIcon(new ImageIcon(img_reExam));

		panelReExamination.add(lblIconReExaminations);
		
		panelLogout = new JPanel();
		panelLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?")== 0)
				{
					Login Login = new Login();
					Login.setVisible(true);
					Dashboard.this.dispose();
				}
			
			}
		});
		panelLogout.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelLogout.setBackground(new Color(112, 128, 144));
		panelLogout.setBounds(-1, 356, 230, 51);
		panel.add(panelLogout);
		panelLogout.setLayout(null);
		
		JLabel lbl_home_1_1_3 = new JLabel("Logout");
		lbl_home_1_1_3.setForeground(Color.WHITE);
		lbl_home_1_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_home_1_1_3.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lbl_home_1_1_3.setBounds(82, 11, 116, 24);
		panelLogout.add(lbl_home_1_1_3);
		
		lblIconLogout = new JLabel("");
		lblIconLogout.setBounds(10, 0, 51, 45);
		lblIconLogout.setIcon(new ImageIcon(img_logout));
		panelLogout.add(lblIconLogout);
		
		lblPortal_2 = new JLabel("Portal");
		lblPortal_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortal_2.setFont(new Font("UTM Androgyne", Font.PLAIN, 24));
		lblPortal_2.setBounds(130, 52, 90, 43);
		panel.add(lblPortal_2);
		
		lblUser = new JLabel("Hi");
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setFont(new Font("UTM Androgyne", Font.PLAIN, 12));
		lblUser.setBounds(130, 11, 90, 43);
		panel.add(lblUser);
		
		panelContent = new JPanel();
		panelContent.setBackground(new Color(47, 79, 79));
		panelContent.setBounds(230, 0, 745, 600);
		contentPane.add(panelContent);
		panelContent.setLayout(null);
		homePanelContent = new homePanelContent();
		homePanelContent.setBounds(0,0,740,600);
	
		detailStudentPanelContent = new detailStudentPanelContent();
		detailStudentPanelContent.setSize(900, 600);
		detailStudentPanelContent.setVisible(false);
		classesPanelContent = new classesPanelContent();
		classesPanelContent.setSize(900, 600);
		classesPanelContent.setVisible(false);
		reExaminationsPanelContent = new reExaminationsPanelContent();
		reExaminationsPanelContent.setSize(900, 600);
		reExaminationsPanelContent.setVisible(false);
		schedulesPanelContent = new schedulesPanelContent();
		schedulesPanelContent.setSize(900, 600);
		schedulesPanelContent.setVisible(false);

		
		
		panelContent.add(homePanelContent);
		panelContent.add(detailStudentPanelContent);
		panelContent.add(classesPanelContent);
		panelContent.add(reExaminationsPanelContent);
		panelContent.add(schedulesPanelContent);
		
		
		
	}
	public void menuClicked(JPanel panel,JPanel panel2) {
		homePanelContent.setVisible(false);
		detailStudentPanelContent.setVisible(false);
		classesPanelContent.setVisible(false);
		reExaminationsPanelContent.setVisible(false);
		schedulesPanelContent.setVisible(false);
		panelHome.setBackground(new Color(112,128,144));
		panelLogout.setBackground(new Color(112,128,144));
		panelDetailStudent.setBackground(new Color(112,128,144));
		panelSchedules.setBackground(new Color(112,128,144));
		panelViewClasses.setBackground(new Color(112,128,144));
		panelReExamination.setBackground(new Color(112,128,144));
		
		panel.setVisible(true);
		panel2.setBackground(Color.RED);

		
	}
	public void setNameUser(String name) {
		lblUser.setText(name);
	}
}
