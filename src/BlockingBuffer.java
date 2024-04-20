import java.util.concurrent.ArrayBlockingQueue;
public class BlockingBuffer implements Buffer{
	 private final ArrayBlockingQueue<Integer> buffer; // buffer compartido
	    
	    public BlockingBuffer() {
	        buffer = new ArrayBlockingQueue<Integer>(1);
	    }
	    
	    // colocar valor en el buffer
	    public void blockingPut(int value) throws InterruptedException {
	        buffer.put(value); // colocar valor en el buffer
	        System.out.printf("%s%2d\t%s%d%n", "Productor escribe ", value,
	                "Celdas ocupadas en el buffer: ", buffer.size());
	    }
	    
	    // obtener valor del buffer
	    public int blockingGet() throws InterruptedException {
	        int readValue = buffer.take(); // remover valor del buffer
	        System.out.printf("%s %2d\t%s%d%n", "Consumidor lee ",
	                readValue, "Celdas ocupadas en el buffer: ", buffer.size());
	        return readValue;
	    }
}
