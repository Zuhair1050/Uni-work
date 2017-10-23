import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.omg.CORBA.ORB;

public class Sensor extends JFrame {
	public Sensor(String [] args) {
		setSize(206, 157);
        setTitle("Sensor");
		try {
		    // create and initialize the ORB
		    ORB orb = ORB.init(args, null);
		    
		    // read in the 'stringified IOR' of the Relay
	      	    BufferedReader in = new BufferedReader(new FileReader("relay.ref"));
	      	    String stringified_ior = in.readLine();
		    
		    // get object reference from stringified IOR
	      	    org.omg.CORBA.Object server_ref = 		
			orb.string_to_object(stringified_ior);
		    
		    final ClientAndServer.HomeHub hub = 
			ClientAndServer.HomeHubHelper.narrow(server_ref);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		//alarm button
		JButton alarmButton = new JButton("Alarm");
		alarmButton.setBounds(33, 48, 118, 23);
		alarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String result = hub.sensorHit();
				hub.sensorPanic();
		
			}
		});
		panel.setLayout(null);
		panel.add(alarmButton);
	} catch (Exception e) {
	    System.out.println("ERROR : " + e) ;
	    e.printStackTrace(System.out);
		}
		
	}
	
	//main method
	public static void main(String args[]) {
		final String[] arguments = args;
        java.awt.EventQueue.invokeLater(new Runnable() {
		public void run() {
			
		    new  Sensor(arguments).setVisible(true);
		}
	    });
	
	}	
}
