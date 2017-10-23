import net.jini.core.entry.*;

public class ZUQueueStatus implements Entry{
    // Variables
    public Integer nextJob;
    
    // No arg contructor
    public ZUQueueStatus (){
    }

    public ZUQueueStatus (int n){
	// set count to n
	nextJob = new Integer(n);
    }

    public void addMsg(){
	nextJob = new Integer(nextJob.intValue() + 1);
    }
}
