import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import net.jini.core.lease.Lease;
import net.jini.space.JavaSpace;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Messenger extends JFrame {

	//variables
	protected static int FIVE_SEC = 1000 * 5;
	private JPanel contentPane;
	private JTextField msgField;
	JTextArea message_list = new JTextArea();
	private JavaSpace space;
	private static int ONE_MIN = 1000 * 60;
	private JTextField toField;
	private JTextField sender;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messenger frame = new Messenger();
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
	public Messenger() {
		
		space = SpaceUtils.getSpace();
		if (space == null){
			System.err.println("Failed to find the javaspace");
			System.exit(1);
		}
		
		
		setTitle("Messenger");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt1) {
				sndMsg();
			}
			
			
			//code for sending a message
			private void sndMsg() {
				
				try {
					
				    ZUQueueStatus zuqsTemp = new ZUQueueStatus();
				    ZUQueueStatus qStatus = (ZUQueueStatus)space.take(zuqsTemp,null,Long.MAX_VALUE);
				    String message = msgField.getText();
				    String username = sender.getText();
				    String toUn = toField.getText();
				    String frUn = sender.getText();
				    ZUQueueItem newMsg = new ZUQueueItem(message, username, toUn, frUn);
				    space.write( newMsg, null, Lease.FOREVER);
				    qStatus.addMsg();
				    space.write( qStatus, null, Lease.FOREVER);
				    message_list.append(frUn + " " + "says" + " " + message + " " + toUn + System.lineSeparator());
				    
				}  catch ( Exception e) {
				    e.printStackTrace();
				}
			    
			}
		});
		btnSend.setBounds(22, 110, 89, 23);
		contentPane.add(btnSend);
		
		msgField = new JTextField();
		msgField.setBounds(102, 79, 86, 20);
		contentPane.add(msgField);
		msgField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(223, 14, 201, 213);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(message_list);
		message_list.setColumns(10);
		message_list.setEditable(false);
		
		JLabel lblEnterMessage = new JLabel("Enter message:");
		lblEnterMessage.setBounds(10, 82, 101, 14);
		contentPane.add(lblEnterMessage);
		
		//Receive button code
		JButton btnReceive = new JButton("Receive");
		btnReceive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt2) {
				getMsg (evt2);
			}

			//retrieves the message object from the space
			private void getMsg(ActionEvent evt2) {
				// TODO Auto-generated method stub
					ZUQueueItem template = new ZUQueueItem();
					try {
						ZUQueueItem got = (ZUQueueItem)space.take(template, null, FIVE_SEC);
						if (got == null)
							
							message_list.append("No object found!!!" + System.lineSeparator());
						else 
							message_list.append(got.from + " " + "says" + " " + got.message + " " + "to" + " " + got.to + System.lineSeparator());
					    
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				
			}
		});
		btnReceive.setBounds(124, 110, 89, 23);
		contentPane.add(btnReceive);
		
		
		//delete button code
		//deletes the message object from  the space
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZUQueueItem template = new ZUQueueItem();
				try {
					ZUQueueItem del = (ZUQueueItem)space.take(template, null, 1000);
					if (del != null)
					message_list.append("Object deleted" + System.lineSeparator());
					else
						message_list.append("No object to delete!!!" + System.lineSeparator());
							
								
								
				
				} catch (Exception u) {
					u.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(22, 144, 89, 23);
		contentPane.add(btnDelete);
		
		
		//save button code
		//saves a message object to the space
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					ZUQueueItem sav = new ZUQueueItem(sender.getText(), msgField.getText(), toField.getText());
						if(sender.getText().equals("") && msgField.getText().equals("") && toField.getText().equals("")){
							message_list.append("No object to save!!!" + System.lineSeparator());
						}
						
						else{
							space.write( sav, null, ONE_MIN);
							message_list.append("Message Saved!"+ System.lineSeparator());
						}
				} catch (Exception s) {
					s.printStackTrace();
				}
						
						
			}
		});
		btnSave.setBounds(124, 144, 89, 23);
		contentPane.add(btnSave);
		
		
		//notification toggle on/off code
		//informs the user of incoming messages
		JButton btnNotificationsOnoff = new JButton("Notifications On/Off");
		btnNotificationsOnoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ZUQueueItem template = new ZUQueueItem();
				
				try {
				    ZUQueueItem msg = (ZUQueueItem)space.take(template, null, 5000);
				    if(msg != null){
				    	message_list.append("You have a message!!!" + " " + "from" + " " + msg.username + System.lineSeparator());
				    }
				    else
				    	message_list.append("No Message" + System.lineSeparator());
				    	
				
				    
				} catch (Exception e) {
				    e.printStackTrace();
				}
				
			}
		});
		btnNotificationsOnoff.setBounds(22, 178, 191, 23);
		contentPane.add(btnNotificationsOnoff);
		
		toField = new JTextField();
		toField.setBounds(102, 48, 86, 20);
		contentPane.add(toField);
		toField.setColumns(10);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(77, 51, 46, 14);
		contentPane.add(lblTo);
		
		sender = new JTextField();
		sender.setBounds(102, 20, 86, 20);
		contentPane.add(sender);
		sender.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("From:");
		lblNewLabel.setBounds(65, 23, 46, 14);
		contentPane.add(lblNewLabel);
		
	}

}

