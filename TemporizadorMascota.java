// Archivo: TemporizadorMascota.java
public class TemporizadorMascota implements Runnable {
    private Mascota mascota;
    private boolean ejecutando = true;
    
    // Un tick base rápido (ej. cada 10 segundos) sirve para manejar diferentes ritmos
    private final int TICK_BASE = 10000; 
    private int contadorTicks = 0;

    public TemporizadorMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public void run() {
        while (ejecutando) {
            try {
                Thread.sleep(TICK_BASE);
                contadorTicks++;

                // --- RITMOS ASÍNCRONOS DE DESCENSO ---

                // 1. El Hambre (Panza): Baja un poco en cada ciclo (cada 10s) porque siempre gasta energía básica.
                mascota.reducirPanza(2);

                // 2. El Cansancio: Baja de forma constante pero más lento (Cada 20 segundos)
                if (contadorTicks % 2 == 0) {
                    mascota.reducirCansancio(4);
                }

                // 3. El Aburrimiento (Diversión): Cae en picado si no se le hace caso (Cada 30 segundos)
                if (contadorTicks % 3 == 0) {
                    mascota.reducirDiversion(8);
                }

                // 4. El Baño (Caca): Solo decae de forma crítica dependiendo de la digestión.
                // Simulamos digestión pasiva a largo plazo (Cada 50 segundos)
                if (contadorTicks % 5 == 0) {
                    mascota.reducirCaca(5); 
                }

                // Reiniciamos el contador para evitar desbordamiento del int a largo plazo
                if (contadorTicks >= 30) {
                    contadorTicks = 0;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void detener() {
        this.ejecutando = false;
    }
}
