//Camera code
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.SwingConstants;

import org.omg.CORBA.ORB;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//	Maintains an alarm status
//	Can be switched on
//	Can be switched off
//	Maintains a current image (could just be unique string) that can be provided upon request

public class Camera extends JFrame {

	//private int cameraStatus = 0;
	JTextField imgText;

	public Camera(String[] args) {

		setTitle("Camera");
		setSize(478, 252);
		try {
			// create and initialize the ORB
			ORB orb = ORB.init(args, null);

			// read in the 'stringified IOR' of the Relay
			BufferedReader in = new BufferedReader(new FileReader("relay.ref"));
			String stringified_ior = in.readLine();

			// get object reference from stringified IOR
			org.omg.CORBA.Object server_ref = orb.string_to_object(stringified_ior);

			final ClientAndServer.HomeHub hub = ClientAndServer.HomeHubHelper.narrow(server_ref);

			JTextField status = new JTextField();
			status.setText("Camera off");
			status.setBackground(Color.WHITE);
			status.setBounds(239, 52, 208, 20);
			status.setEditable(false);
			status.setToolTipText("Camera Status");
			status.setColumns(30);
			
			JTextField imgText = new JTextField();
			imgText.setBackground(Color.WHITE);
			imgText.setEditable(false);
			//imgText.setVisible(isVisible());
			imgText.setBounds(239, 131, 208, 20);
			getContentPane().add(imgText);
			imgText.setColumns(10);

			JButton alarm = new JButton("ALARM");
			alarm.setForeground(Color.BLACK);
			alarm.setBounds(23, 96, 125, 23);
			alarm.setEnabled(false);
			
			JButton btnCan = new JButton("Cancel");
			btnCan.setBounds(23, 164, 128, 23);
			btnCan.setEnabled(false);
			getContentPane().add(btnCan);

			alarm.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent evt) {
		
					status.setText("Alarm sent to home hub.");
					String result = hub.fetch_status();

					hub.cameraPanic();

					alarm.setEnabled(true);
					btnCan.setEnabled(true);
				}
			});
			
			
			// can button removes camera alarm request from homehub
			btnCan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					hub.cameraCancel();
					status.setText("Alarm state reset.");
					alarm.setEnabled(true);
					btnCan.setEnabled(false);
				}
			});

			JLabel lblCurrentStatus = new JLabel("Camera Status : ");
			lblCurrentStatus.setBounds(265, 21, 147, 26);
			lblCurrentStatus.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().setLayout(null);
			getContentPane().setLayout(null);
			getContentPane().add(lblCurrentStatus);
			getContentPane().add(status);
			getContentPane().add(alarm);


			
			//Camera Image code
			JButton btnImg = new JButton("Get Image");
			btnImg.setEnabled(false);
			btnImg.setBounds(23, 130, 128, 23);
			getContentPane().add(btnImg);
			
			
			btnImg.addActionListener(new ActionListener() {

				private JFrame frame;

				@Override
				public void actionPerformed(ActionEvent e) {

					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					Date date = new Date();
					imgText.setText("Current Image : " + dateFormat.format(date));

				}

			});

			JButton btnOnCamera = new JButton("Camera ON");
			btnOnCamera.setBounds(23, 23, 125, 23);
			getContentPane().add(btnOnCamera);

			//camera off button code
			JButton btnOff = new JButton("Camera OFF");
			btnOff.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					btnOnCamera.setEnabled(true);
					btnOff.setEnabled(false);
					btnImg.setEnabled(false);
					alarm.setEnabled(false);
					
					status.setText("Camera off");
					
				}
			});
			btnOff.setBounds(23, 63, 125, 23);
			btnOff.setEnabled(false);
			getContentPane().add(btnOff);

			

			JLabel lblCurrentImage = new JLabel("Current Image :");
			lblCurrentImage.setBounds(299, 100, 97, 20);
			getContentPane().add(lblCurrentImage);

			//camera on button code
			btnOnCamera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					btnOff.setEnabled(true);
					alarm.setEnabled(true);
					btnImg.setEnabled(true);
					btnOnCamera.setEnabled(false);

					status.setText("Camera on");
				}
			});

		}

		catch (Exception e) {
			System.out.println("ERROR : " + e);
			e.printStackTrace(System.out);
		}

	}

	public JTextField getImgText() {
		return imgText;
	}

	public void setImgText(JTextField imgText) {
		this.imgText = imgText;
	}

	//main method
	public static void main(String args[]) {
		final String[] arguments = args;
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				new Camera(arguments).setVisible(true);
			}
		});
	}
}

//
