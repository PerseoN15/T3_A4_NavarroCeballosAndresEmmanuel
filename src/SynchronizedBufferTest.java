import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedBufferTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Buffer sharedLocation = new SynchronizedBuffer();
        
        System.out.println("Acción\t\tValor\tSuma de Producidos\tSuma de Consumidos");
        System.out.printf("------\t\t-----\t-----------------\t-----------------%n%n");
        
        executorService.execute(new Producer(sharedLocation));
        executorService.execute(new Consumer(sharedLocation));
        
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}