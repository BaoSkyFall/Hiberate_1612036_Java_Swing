import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class homePanelContent extends JPanel {

	/**
	 * Create the panel.
	 */
	public homePanelContent() {
		setLayout(null);
		setSize(521,600);
		setBounds(230,0,521,600);
		JLabel lblNewLabel = new JLabel("HOME CONTENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("UTM Androgyne", Font.PLAIN, 17));
		lblNewLabel.setBounds(112, 62, 230, 121);
		add(lblNewLabel);

	}

}
