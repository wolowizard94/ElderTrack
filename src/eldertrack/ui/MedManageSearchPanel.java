package eldertrack.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import eldertrack.db.SQLObject;
import eldertrack.medical.ElderData;

public class MedManageSearchPanel extends JPanel {

	private static final long serialVersionUID = 4090792694881415463L;
	private ElderData room101=new ElderData();
	private ElderData room102=new ElderData();
	private ElderData room103=new ElderData();
	private ElderData room104=new ElderData();
	private ElderData room105=new ElderData();
	private ElderData room201=new ElderData();
	private ElderData room202=new ElderData();
	private ElderData room203=new ElderData();

	public MedManageSearchPanel() {
		setBounds(5, 5, 975, 510);
		setLayout(null);
		ResultSet rs;
		try {
			SQLObject so = new SQLObject();
			PreparedStatement statement = so.getPreparedStatementWithKey("SELECT * FROM et_elderly ");
			rs = statement.executeQuery();
			while(rs.next()){
				String roomNum=rs.getString("room");
				String roomGender=rs.getString("gender");

				if(roomNum.equalsIgnoreCase("101")){
					room101.setElderNum(1);
					if(roomGender.equalsIgnoreCase("m")){
						room101.setElderNumMale(1);
					}
					else{
						room101.setElderNumFemale(1);
					}


				}
				else if(roomNum.equalsIgnoreCase("102")){
					room102.setElderNum(1);
					if(roomGender.equalsIgnoreCase("m")){
						room102.setElderNumMale(1);
					}
					else{
						room102.setElderNumFemale(1);
					}

				}
				else if(roomNum.equalsIgnoreCase("103")){
					room103.setElderNum(1);
					if(roomGender.equalsIgnoreCase("m")){
						room103.setElderNumMale(1);
					}
					else{
						room103.setElderNumFemale(1);
					}

				}
				else if(roomNum.equalsIgnoreCase("104")){
					room104.setElderNum(1);
					if(roomGender.equalsIgnoreCase("m")){
						room104.setElderNumMale(1);
					}
					else{
						room104.setElderNumFemale(1);
					}

				}
				else if(roomNum.equalsIgnoreCase("105")){
					room105.setElderNum(1);
					if(roomGender.equalsIgnoreCase("m")){
						room105.setElderNumMale(1);
					}
					else{
						room105.setElderNumFemale(1);
					}

				}
				else if(roomNum.equalsIgnoreCase("201")){
					room201.setElderNum(1);
					if(roomGender.equalsIgnoreCase("m")){
						room201.setElderNumMale(1);
					}
					else{
						room201.setElderNumFemale(1);
					}

				}
				else if(roomNum.equalsIgnoreCase("202")){
					room202.setElderNum(1);
					if(roomGender.equalsIgnoreCase("m")){
						room202.setElderNumMale(1);
					}
					else{
						room202.setElderNumFemale(1);
					}

				}
				else if(roomNum.equalsIgnoreCase("203")){
					room203.setElderNum(1);
					if(roomGender.equalsIgnoreCase("m")){
						room203.setElderNumMale(1);
					}
					else{
						room203.setElderNumFemale(1);
					}

				}
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		JLabel lblManage = new JLabel("Dosage Management");
		lblManage.setForeground(UIManager.getColor("TextField.selectionBackground"));
		lblManage.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblManage.setBounds(25, 25, 300, 41);
		add(lblManage);

		JLabel lblOverview = new JLabel("Overview:");
		lblOverview.setForeground(new Color(0, 128, 128));
		lblOverview.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblOverview.setBounds(85, 107, 151, 41);
		add(lblOverview);

		JTextPane txtpnRoomNumber = new JTextPane();
		txtpnRoomNumber.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtpnRoomNumber.setText(
				"============================================================================="		
						+"\r\nRoom Number: 101 \r\nTotal number of elderly:"+room101.getElderNum() 
						+"\r\nTotal Male elderly: " +room101.getElderNumMale() +"\r\nTotal Female elderly:" +room101.getElderNumFemale()
						+"\r\n============================================================================="	
						+"\r\nRoom Number: 102 \r\nTotal number of elderly: "+room102.getElderNum() 
						+"\r\nTotal Male elderly: " +room102.getElderNumMale() +"\r\nTotal Female elderly:" +room102.getElderNumFemale()
						+"\r\n============================================================================="	
						+"\r\nRoom Number: 103 \r\nTotal number of elderly: "+room103.getElderNum() 
						+"\r\nTotal Male elderly: " +room103.getElderNumMale() +"\r\nTotal Female elderly:" +room103.getElderNumFemale()
						+"\r\n============================================================================="	
						+"\r\nRoom Number: 104 \r\nTotal number of elderly: "+room104.getElderNum() 
						+"\r\nTotal Male elderly: " +room104.getElderNumMale() +"\r\nTotal Female elderly:" +room104.getElderNumFemale()		
						+"\r\n============================================================================="	
						+"\r\nRoom Number: 105 \r\nTotal number of elderly: "+room105.getElderNum() 
						+"\r\nTotal Male elderly: " +room105.getElderNumMale() +"\r\nTotal Female elderly:" +room105.getElderNumFemale()	
						+"\r\n============================================================================="	
						+"\r\nRoom Number: 201 \r\nTotal number of elderly: "+room201.getElderNum() 
						+"\r\nTotal Male elderly: " +room201.getElderNumMale() +"\r\nTotal Female elderly:" +room201.getElderNumFemale()	
						+"\r\n============================================================================="	
						+"\r\nRoom Number: 202 \r\nTotal number of elderly: "+room202.getElderNum() 
						+"\r\nTotal Male elderly: " +room202.getElderNumMale() +"\r\nTotal Female elderly:" +room202.getElderNumFemale()
						+"\r\n============================================================================="	
						+"\r\nRoom Number: 203 \r\nTotal number of elderly: "+room203.getElderNum() 
						+"\r\nTotal Male elderly: " +room203.getElderNumMale() +"\r\nTotal Female elderly:" +room203.getElderNumFemale()
						+"\r\n============================================================================="	
				);

		JScrollPane txtpnScroll=new JScrollPane(txtpnRoomNumber);
		txtpnScroll.setBounds(85, 145, 796, 226);
		add(txtpnScroll);



		JButton btnGetManagement = new JButton("Start Managing");
		btnGetManagement.setBounds(85, 395, 278, 31);
		btnGetManagement.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		add(btnGetManagement);
		btnGetManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPanel gottenManage=new MedManagePanel();
				MedPanel.MedCardPanel.add(gottenManage,MedPanel.MMANAGEPANEL);

				CardLayout mainCards = (CardLayout) MedPanel.MedCardPanel.getLayout();
				mainCards.show(MedPanel.MedCardPanel, MedPanel.MMANAGEPANEL);
			}
		});


	}

}
