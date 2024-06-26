import java.security.SecureRandom;

public class Consumer implements Runnable{
	private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation; 
    
    public Consumer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }
    
    public void run() {
        int sum = 0;
        for (int count = 1; count <= 10; count++) {
            try {
                Thread.sleep(generator.nextInt(3000)); 
                sum += sharedLocation.blockingGet(); 
                System.out.printf("\t\t\t%2d%n", sum);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("Consumidor ha terminado de consumir%nTerminando el Consumidor%n");
    }
}
