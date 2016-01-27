package eldertrack.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AnnouncementPanel extends JPanel{
	private static final long serialVersionUID = -8742307067990031379L;
	private JLabel AnnouncementManager;
	private String s = "This is a test text";
	
	AnnouncementPanel() {
		setBounds(0, 0, 995, 670);
		setLayout(null);
		
		JButton btnMainMenu = new JButton("Back to Main Menu");
		btnMainMenu.setBounds(820, 15, 139, 40);
		add(btnMainMenu);
		
		JButton eManagement = new JButton("Back to people management\r\n");
		eManagement.setBounds(26, 555, 307, 25);
		add(eManagement);
		
		AnnouncementManager = new JLabel("ElderTrack Announcement Settings");
		AnnouncementManager.setBounds(26, 5, 594, 61);
		AnnouncementManager.setForeground(SystemColor.textHighlight);
		AnnouncementManager.setFont(new Font("Segoe UI", Font.ITALIC, 40));
		add(AnnouncementManager);
		
		JLabel announcementTextHeader = new JLabel("Edit announcement text :");
		announcementTextHeader.setFont(new Font("Tahoma", Font.PLAIN, 18));
		announcementTextHeader.setBounds(26, 361, 206, 22);
		add(announcementTextHeader);
		
		JTextField editAnnouncementText = new JTextField();
		editAnnouncementText.setToolTipText("");
		editAnnouncementText.setFont(new Font("Monospaced", Font.PLAIN, 13));
		editAnnouncementText.setBounds(26, 385, 933, 30);
		add(editAnnouncementText);
		
		JButton btnNewButton = new JButton("Save Announcement Text");
		btnNewButton.setBounds(26, 428, 206, 25);
		add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(26, 120, 933, 225);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel announcementPreview = new JLabel("Announcement preview");
		announcementPreview.setFont(new Font("Tahoma", Font.PLAIN, 18));
		announcementPreview.setBounds(26, 99, 189, 22);
		add(announcementPreview);
		
		/*MarqueePanel previewMarquee = new MarqueePanel();
		previewMarquee.setBounds(0, 89, 933, 29);
		previewMarquee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(previewMarquee);
		previewMarquee.setBackground(new Color(0, 153, 255));
		previewMarquee.start();
		*/
		
		//// Event Handlers ////
		
		// Return to management panel
		eManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout parentCards = (CardLayout)MgmtSection.CardDeck.getLayout();
				parentCards.show(MgmtSection.CardDeck, MgmtSection.MGMTPANEL);
			}
		});
		
		// Return to main menu
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout parentCards = (CardLayout) MainFrame.CardsPanel.getLayout();
				parentCards.show(MainFrame.CardsPanel, MainFrame.MENUPANEL);
			}
		});
		
		editAnnouncementText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String s = editAnnouncementText.getText();
			}
		});
		
	}
}
