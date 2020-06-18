import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panelHome;
	private JPanel panelViewClasses;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel lbl_home;
	private JPanel panelContent;
	private homePanelContent homePanelContent;
	private detailStudentPanelContent detailStudentContent;
	private classesPanelContent classesPanelContent;
	private reExaminationsPanelContent reExaminationsPanelContent;
	private schedulesPanelContent schedulesPanelContent;
	
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
		setBounds(100, 100, 767, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 230, 447);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("PORTAL");
		lblNewLabel.setBounds(65, 5, 85, 36);
		lblNewLabel.setFont(new Font("UTM Androgyne", Font.PLAIN, 24));
		lblNewLabel.setLayout(null);
		panel.add(lblNewLabel);
		
		panelHome = new JPanel();
		panelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homePanelContent.setVisible(true);
			}
		});
		panelHome.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelHome.setBackground(new Color(112, 128, 144));
		panelHome.setBounds(0, 65, 230, 36);
		panel.add(panelHome);
		panelHome.setLayout(null);
		
		lbl_home = new JLabel("Home");
		lbl_home.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_home.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lbl_home.setBounds(38, 11, 154, 20);
		panelHome.add(lbl_home);
		
		panelViewClasses = new JPanel();
		panelViewClasses.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelViewClasses.setBackground(new Color(112, 128, 144));
		panelViewClasses.setBounds(0, 101, 230, 36);
		panel.add(panelViewClasses);
		panelViewClasses.setLayout(null);
		
		JLabel lbl_viewClass = new JLabel("View Classes");
		lbl_viewClass.setBounds(41, 11, 152, 24);
		lbl_viewClass.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_viewClass.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		panelViewClasses.add(lbl_viewClass);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_3.setBackground(new Color(112, 128, 144));
		panel_3.setBounds(0, 136, 230, 36);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lbl_home_1_1 = new JLabel("View Schedules");
		lbl_home_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_home_1_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lbl_home_1_1.setBounds(42, 11, 152, 24);
		panel_3.add(lbl_home_1_1);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_4.setBackground(new Color(112, 128, 144));
		panel_4.setBounds(0, 172, 230, 36);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lbl_home_1_1_1 = new JLabel("Detail Students");
		lbl_home_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_home_1_1_1.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lbl_home_1_1_1.setBounds(44, 11, 152, 24);
		panel_4.add(lbl_home_1_1_1);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_5.setBackground(new Color(112, 128, 144));
		panel_5.setBounds(0, 208, 230, 36);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lbl_home_1_1_2 = new JLabel("Re-Examinations");
		lbl_home_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_home_1_1_2.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lbl_home_1_1_2.setBounds(44, 11, 152, 24);
		panel_5.add(lbl_home_1_1_2);
		
		panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
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
		panel_6.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_6.setBackground(new Color(112, 128, 144));
		panel_6.setBounds(0, 244, 230, 36);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lbl_home_1_1_3 = new JLabel("Logout");
		lbl_home_1_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_home_1_1_3.setFont(new Font("UTM Androgyne", Font.PLAIN, 16));
		lbl_home_1_1_3.setBounds(46, 11, 152, 24);
		panel_6.add(lbl_home_1_1_3);
		
		panelContent = new JPanel();
		panelContent.setBackground(new Color(47, 79, 79));
		panelContent.setBounds(230, 0, 521, 437);
		contentPane.add(panelContent);
		panelContent.setLayout(null);
		homePanelContent = new homePanelContent();
		homePanelContent.setBounds(0,0,521,437);
	
//		homePanelContent = new homePanelContent();
//		homePanelContent = new homePanelContent();
//		homePanelContent = new homePanelContent();
//		homePanelContent = new homePanelContent();
		
		
		panelContent.add(homePanelContent);
		
		
		
	}
}
