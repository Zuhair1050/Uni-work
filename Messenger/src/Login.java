import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.jini.core.lease.Lease;
import net.jini.space.JavaSpace;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;



public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String username;
	private JavaSpace space;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		space = SpaceUtils.getSpace();
		if (space == null){
			System.err.println("Failed to find the javaspace");
			System.exit(1);
		}
		
		//login code
		JButton btnSend = new JButton("Login");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ZUQueueItem u1 = new ZUQueueItem();
				String uname1 = textField.getText();
				
				//checks if user is valid
				if((uname1 != null) && (uname1.length() > 0)) {
					 
						  setusername(username);
						  username = u1.from;

			        //creates new instance of messenger class
					Messenger usr1 = new Messenger();
					usr1.setVisible(true);
					dispose();
				} else {

					//Display error message
					JOptionPane.showMessageDialog(null,"Enter a valid username!");
					textField.setText("");
					
					textField.requestFocus();
				}

			}
		});
		btnSend.setBounds(163, 122, 89, 23);
		contentPane.add(btnSend);
		
		textField = new JTextField();
		textField.setBounds(163, 80, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(95, 83, 62, 14);
		contentPane.add(lblUsername);
		
		JLabel lblLoginScreen = new JLabel("Login Screen");
		lblLoginScreen.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblLoginScreen.setBounds(163, 31, 89, 14);
		contentPane.add(lblLoginScreen);
	}
	

	protected void setusername(String name) {
		setusername(name);
	}

		
	public String getUsername() {
		return username;
	}

}
