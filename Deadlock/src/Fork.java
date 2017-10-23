import java.util.concurrent.Semaphore;

class Fork
{
	private Semaphore forkTaken;
	private String name;
	
	Fork(String name) {
		this.name = name;
		this.forkTaken = false;
	}
	
	public String toString() {
		return name;
	}
	
	public static void take() {
		Semaphore s1 = new Semaphore(1);
		Semaphore s2 = new Semaphore(0);
		if (this.forkTaken)
			

		forkTaken = s1;
		
	}
	
	public void putDown() {
		this.forkTaken = false;
	}
}
