public interface Buffer {
    // colocar un valor entero en el Buffer
    void blockingPut(int value) throws InterruptedException;

    // obtener un valor entero del Buffer
    int blockingGet() throws InterruptedException;
}
