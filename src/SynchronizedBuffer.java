public class SynchronizedBuffer implements Buffer {
    private int buffer = -1; // compartido por los hilos productor y consumidor
    
    // colocar valor en el buffer
    public synchronized void blockingPut(int value) throws InterruptedException {
        System.out.printf("Productor escribe:\t%2d", value);
        buffer = value;
    }
    
    // obtener valor del buffer
    public synchronized int blockingGet() throws InterruptedException {
        System.out.printf("Consumidor lee:\t%2d", buffer);
        return buffer;
    }
}
