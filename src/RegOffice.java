import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.Instant;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.border.SoftBevelBorder;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import ClientAndServer.StatusPOA;

import javax.swing.JTextArea;

class StatusServant extends StatusPOA {
    private RegOffice parent;

    public StatusServant(RegOffice parentGUI) {
	// store reference to parent GUI
	parent = parentGUI;
    }
    

	@Override
	public String message() {


		parent.addMessage("Alarm triggered \n\n", null);
		
		return "";
	}
	
	@Override
	public String sensorHit() {

		parent.addMessage("Alarm triggered on Sensor at " + Instant.now() + "\n", null);
		//sensorPanic();

		return "";
	}
	
	public String sms() {
		
		
		return "Warning: Alarm ON!";
		
	}
	
	
}


public class RegOffice extends JFrame {
    private JPanel panel;
    private JScrollPane scrollpane;
    private JTextArea textarea;

    public RegOffice(String[] args){
	try {
		 // create and initialize the ORB
	    ORB orb = ORB.init(args, null);
	    
	    // get reference to rootpoa & activate the POAManager
	    POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	    rootpoa.the_POAManager().activate();
	    
	    // create servant and register it with the ORB
	    StatusServant helloRef = new StatusServant(this);
	    
	    // get the 'stringified IOR'
	    org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloRef);
	    String stringified_ior = orb.object_to_string(ref);
	    
    	// Save IOR to file
        BufferedWriter out = new BufferedWriter(new FileWriter("server.ref"));
        out.write(stringified_ior);
	    out.close();
	    
	    
	    


	    // set up the GUI
	    textarea = new JTextArea(20,25);
	    scrollpane = new JScrollPane(textarea);
	    panel = new JPanel();

	    panel.add(scrollpane);
	    getContentPane().add(panel, "Center");

	    setSize(400, 500);
            setTitle("Regional Office");

            addWindowListener (new java.awt.event.WindowAdapter () {
                public void windowClosing (java.awt.event.WindowEvent evt) {
                    System.exit(0);;
                }
            } );

	    
	} catch (Exception e) {
	    System.err.println("ERROR: " + e);
	    e.printStackTrace(System.out);
	}

    }


    public void addMessage(String message, String sensorHit){
	textarea.append(message);
	textarea.append(sensorHit);
    }

    
    public static void main(String args[]) {
	final String[] arguments = args;
        java.awt.EventQueue.invokeLater(new Runnable() {
		public void run() {
		    new  RegOffice(arguments).setVisible(true);
		}
	    });
    }   
}