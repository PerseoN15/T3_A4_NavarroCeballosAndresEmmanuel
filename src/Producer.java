import java.security.SecureRandom;

import java.util.Random;

public class Producer {
    private String numeroDeControl;
    private boolean becasAsignadas;

    public Producer(String numeroDeControl, boolean becasAsignadas) {
        this.numeroDeControl = numeroDeControl;
        this.becasAsignadas = becasAsignadas;
    }

    // Getters y setters
    public String getNumeroDeControl() {
        return numeroDeControl;
    }

    public void setNumeroDeControl(String numeroDeControl) {
        this.numeroDeControl = numeroDeControl;
    }

    public boolean isBecasAsignadas() {
        return becasAsignadas;
    }

    public void setBecasAsignadas(boolean becasAsignadas) {
        this.becasAsignadas = becasAsignadas;
    }

    // Método para generar un número de control aleatorio
    public static String generarNumeroDeControl() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
