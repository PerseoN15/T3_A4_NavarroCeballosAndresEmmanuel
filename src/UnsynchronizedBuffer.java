public class UnsynchronizedBuffer implements Buffer {
    private int buffer = -1; // compartido por los hilos productor y consumidor

    // colocar valor en el buffer
    public synchronized void blockingPut(int value) throws InterruptedException {
        while (buffer != -1) {
            wait(); // esperar mientras el buffer esté lleno
        }
        buffer = value;
        System.out.printf("Productor escribe:\t%2d", value);
        notifyAll(); // notificar a todos los hilos en espera
    }

    // obtener valor del buffer
    public synchronized int blockingGet() throws InterruptedException {
        while (buffer == -1) {
            wait(); // esperar mientras el buffer esté vacío
        }
        int value = buffer;
        buffer = -1;
        System.out.printf("Consumidor lee:\t%2d", value);
        notifyAll(); // notificar a todos los hilos en espera
        return value;
    }
}
