import net.jini.space.*;
import net.jini.core.lease.*;

public class StartMessageQueue{
    public static void main(String args[]){
	JavaSpace space = SpaceUtils.getSpace();
	if (space == null){
	    System.err.println("Failed to find the javaspace");
	    System.exit(1);
	}

	try {
	    ZUQueueStatus qs = new ZUQueueStatus(0);
	    space.write( qs, null, Lease.FOREVER);
	} catch ( Exception e) {
	    e.printStackTrace();
	}
    }
}
