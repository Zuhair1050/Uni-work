package demo.sphinx.helloworld;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.awt.Font;


public class AI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AI frame = new AI();
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
	public AI() {
		setTitle("A.I assistant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListen = new JButton("Listen");
		btnListen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread speech = new Thread(new Runnable() {
				

					@Override
                    public void run() {
                    	
                    	HelloWorld f = new HelloWorld();
        				String[] args = new String[]{};
        				HelloWorld.main(args);

                    }
                });         
                speech.start();
               
                
                
            }
				
		});
		btnListen.setBounds(10, 228, 89, 23);
		contentPane.add(btnListen);
		
		textField = new JTextField();
		textField.setBounds(109, 120, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Command:");
		lblNewLabel.setFont(new Font("Simplified Arabic", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 120, 106, 18);
		contentPane.add(lblNewLabel);
		
		JButton btnEnter = new JButton("Submit");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String str = textField.getText();
				//textField.setText(str); 
				if(str.equalsIgnoreCase("word")) {
					
					
					try {
						Runtime.getRuntime().exec("cmd.exe /C start winword");
						textField.setText("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(str.equalsIgnoreCase("onenote") || (str.equalsIgnoreCase("note"))) {
					
					try {
						Runtime.getRuntime().exec("cmd.exe /C start onenote");
						textField.setText("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(str.equalsIgnoreCase("outlook") || (str.equalsIgnoreCase("out"))) {
					
					try {
						Runtime.getRuntime().exec("cmd.exe /C start outlook");
						textField.setText("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnEnter.setBounds(205, 119, 89, 23);
		contentPane.add(btnEnter);
		
		JButton btnHelp = new JButton("About");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String msg = "<html>A.I Assistant Java application<br>By: Zuhair Annab - U1166830<br>Version: 1.0";

			    JOptionPane optionPane = new JOptionPane();
			    optionPane.setMessage(msg);
			    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
			    JDialog dialog = optionPane.createDialog(null, "About");
			    dialog.setVisible(true);
			}
		});
		btnHelp.setBounds(335, 228, 89, 23);
		contentPane.add(btnHelp);
		
		JButton btnHelp_1 = new JButton("Help");
		btnHelp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String msg = "<html>To activate voice recognizer, press the listen button.<br>Then say open and application name to open application<br>And close and application name to close the application.<br>";

			    JOptionPane optionPane = new JOptionPane();
			    optionPane.setMessage(msg);
			    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
			    JDialog dialog = optionPane.createDialog(null, "Help");
			    dialog.setVisible(true);
			}
		});
		btnHelp_1.setBounds(236, 228, 89, 23);
		contentPane.add(btnHelp_1);
		
		JButton btnNewButton = new JButton("Voice Commands");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "<html>Available Voice Commands:-<br>1. Open/Close Word<br>2. Open/Close notepad<br>3. Open/Close excel<br>4. Open/Close access<br>5. Open/Close Outlook<br>6. Open/Close word pad<br>7. Open/Close browser";

			    JOptionPane optionPane = new JOptionPane();
			    optionPane.setMessage(msg);
			    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
			    JDialog dialog = optionPane.createDialog(null, "About");
			    dialog.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 194, 188, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblAiAssistant = new JLabel("A.I Assistant");
		lblAiAssistant.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAiAssistant.setBounds(125, 11, 188, 67);
		contentPane.add(lblAiAssistant);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 
		        }
					

					
				
				
			
		});
		btnStop.setBounds(109, 228, 89, 23);
		contentPane.add(btnStop);
		
		JButton btnTextCommands = new JButton("Text Commands");
		btnTextCommands.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String msg = "<html>Available Voice Commands:-<br>1. Open/Close Word<br>2. Open/Close OneNote<br>3. Open/Close Outlook";

			    JOptionPane optionPane = new JOptionPane();
			    optionPane.setMessage(msg);
			    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
			    JDialog dialog = optionPane.createDialog(null, "About");
			    dialog.setVisible(true);
				
			}
		});
		btnTextCommands.setBounds(236, 194, 188, 23);
		contentPane.add(btnTextCommands);
		
		JButton btnTime = new JButton("Time");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane optionPane = new JOptionPane();
				String sText;
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
		        Date date =new Date();
		        sText="The Time is : "+(DateFormat.getTimeInstance(DateFormat.SHORT).format(date));
		        optionPane.setMessage(timeStamp);
		        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		        JDialog dialog = optionPane.createDialog(null, "Time");
			    dialog.setVisible(true);
			}
		});
		btnTime.setBounds(335, 119, 89, 23);
		contentPane.add(btnTime);
	}
}
