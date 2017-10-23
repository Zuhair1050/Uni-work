
import java.util.Random;


class Philosopher implements Runnable
{
	private static final int NB_PHILOSPHERS = 5;
	private static final Fork[] forks = new Fork[NB_PHILOSPHERS];
	private static Random rand = new Random();

	private int id;

	public Philosopher(int id) {
		this.id = id;
		forks[id] = new Fork("[Fork " + id + "]");
	}

	private void think() {
		try {
			Thread.sleep(rand.nextInt(10) * 1000);
		} catch (InterruptedException e) {
			System.err.println("One philosopher thread died :(");
			System.exit(1);
		};
	}

	private void eat() {
		Fork leftFork = forks[id];
		Fork rightFork = forks[(id + 1) % NB_PHILOSPHERS];

		System.out.println(this + " is hungry.");

		// Left fork
		while (!leftFork.take()) {
			System.out.println(this + leftFork.toString() +
					": Left fork already taken");		
			think();
		}
		System.out.println(this + leftFork.toString() + " Holding left fork");
		
		// Right fork
		while (!rightFork.take()) {
			System.out.println(this + rightFork.toString() +
					": Right fork already taken");	
			think();
		}
		System.out.println(this + rightFork.toString() + " Holding right fork");	


		System.out.println(this + " is eating.");
		think();
		leftFork.putDown();
		rightFork.putDown();

		System.out.println(this + " is satiated.");
	}

	public String toString() {
		return "[Philosopher " + id + "]";
	}

	public void run() {
		System.out.println(this + " sit at the table.");			
		for (int i = 0; i < 10 ; i++) {
			think();
			eat();
		}
	}

	public static void main(String [] args) {
		Thread philosophers[] = new Thread[NB_PHILOSPHERS];
		System.out.println("Start");

		for (int i = 0 ; i < NB_PHILOSPHERS ; i++) {
			philosophers[i] = new Thread(new Philosopher(i)); 
			philosophers[i].start();
		}

		try {
			for (int i = 0 ; i < NB_PHILOSPHERS ; i++)
				philosophers[i].join();
		} 
		catch (InterruptedException e) {
			System.err.println("One philosopher thread died :(");
			System.exit(1);
		} 
		System.out.println("End");
	}
}	