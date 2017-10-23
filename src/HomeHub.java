import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Instant;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import ClientAndServer.HomeHubPOA;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;


class HomeHubServant extends HomeHubPOA {

	private ORB orb;
	private ClientAndServer.Status server;
	private HomeHub parent;
	boolean online = false;
	boolean press = false;
	boolean alarm = false;
	Date sensorTime;
	Date cameraTime;

	public HomeHubServant(HomeHub parentGUI, ORB orb_val) {
		// store reference to parent GUI
		parent = parentGUI;

		// store reference to ORB
		orb = orb_val;

		// look up the server
		try {
			// read in the 'stringified IOR'
			BufferedReader in = new BufferedReader(new FileReader("server.ref"));
			String stringified_ior = in.readLine();

			// get object reference from stringified IOR
			org.omg.CORBA.Object server_ref = orb.string_to_object(stringified_ior);
			server = ClientAndServer.StatusHelper.narrow(server_ref);
		} catch (Exception e) {
			System.out.println("ERROR : " + e);
			e.printStackTrace(System.out);
		}
	}

	public String fetch_status() {

		String messageFromCamera = server.sensorHit();

		parent.addMessage("Alarm triggered on Camera at " + Instant.now() + "\n");
		

		cameraPanic();
		String message = "msg";
		return message;
	}

	@Override
	public String sendAlarm() {

		String messageFromCamera = server.message();

		return messageFromCamera;
	}

	@Override
	public void sensorPanic() {
		long t1 = 5000;
		this.press = true;
		

	}

	@Override
	public void cameraPanic() {
		long t2 = 5000;
		this.online = true;
	}

	@Override
	public String currentImage() {
		// TODO Auto-generated method stub
		return fetch_status();
	}

	@Override
	public String sensorHit() {

		parent.addMessage("Alarm triggered on Sensor at " + Instant.now() + "\n");
		sensorPanic();

		return "";
	}

	@Override
	public void sensorCancel() {
		this.press = false;

	}

	@Override
	public void cameraCancel() {
		// TODO Auto-generated method stub
		this.online = false;
	}
	
	
	
	
}

public class HomeHub extends JFrame {
	private JPanel panel;
	private JScrollPane scrollpane;
	private JTextArea textarea;
	private JButton panic;

	// Class acts as a log 
	public HomeHub(String[] args) {
		try {

			// create and initialize the ORB
			ORB orb = ORB.init(args, null);

			// get reference to rootpoa & activate the POAManager
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();

			// create servant and register it with the ORB
			HomeHubServant relayRef = new HomeHubServant(this, orb);

			// Get the 'stringified IOR'
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(relayRef);
			String stringified_ior = orb.object_to_string(ref);

			// Save IOR to file
			BufferedWriter out = new BufferedWriter(new FileWriter("relay.ref"));
			out.write(stringified_ior);
			out.close();
			scrollpane = new JScrollPane();
			scrollpane.setBounds(44, 26, 310, 366);
			panel = new JPanel();
			panel.setLayout(null);
			
			
			
			
			

			panic = new JButton("Notify Office");
			panic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//long seconds = (relayRef.sensorTime.getTime()- relayRef.cameraTime.getTime())/1000;

					if (relayRef.online == true && relayRef.press == true) {
						relayRef.sendAlarm();
						relayRef.sensorCancel();
						relayRef.cameraCancel();
						textarea.append("Regional Office notified");
						
						
					} else {

						System.out.println("Alarm not sent to reg office");
					}
				}
			});
			panic.setBounds(121, 403, 136, 23);
			panel.add(panic);

			panel.add(scrollpane);

			// set up the GUI
			textarea = new JTextArea(20, 40);
			scrollpane.setRowHeaderView(textarea);

			// wait for invocations from clients
			textarea.append("HomeHub online.\n");
			getContentPane().add(panel, "Center");

			setSize(400, 500);
			setTitle("HomeHub");

			addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent evt) {
					System.exit(0);
					;
				}
			});

			

		} catch (Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}
	}

	public void addMessage(String message) {

		textarea.append(message);
	}

	public static void main(String args[]) {
		final String[] arguments = args;
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new HomeHub(arguments).setVisible(true);
				
				
			}
		});
	}

}
