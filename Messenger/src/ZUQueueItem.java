import net.jini.core.entry.*;

public class ZUQueueItem implements Entry{
    // Variables
	public String username;
    public String message;
    public String to;
	public String from;
    
    // No arg contructor
    public ZUQueueItem (){
    }
    
    //arg constructor
    public ZUQueueItem (String f, String fn, String t){
    	message = fn;
    	to = t;
    	from = f;
        }
    
    //full arg constructor
    public ZUQueueItem (String f, String fn, String t, String un){
	from = f;
	message = fn;
	to = t;
	username = un;
    }
}
