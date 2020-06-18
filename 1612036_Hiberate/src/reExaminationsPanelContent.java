import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class reExaminationsPanelContent extends JPanel {

	/**
	 * Create the panel.
	 */
	public reExaminationsPanelContent() {
		setLayout(null);
		setSize(521,437);
		JLabel lblNewLabel = new JLabel("RE-EXAMINATIONS CONTENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("UTM Androgyne", Font.PLAIN, 17));
		lblNewLabel.setBounds(112, 62, 230, 121);
		add(lblNewLabel);
	}

}
