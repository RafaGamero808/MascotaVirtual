public class TemporizadorMascota implements Runnable {
    private Mascota mascota;
    private boolean ejecutando = true;
    private final int INTERVALO = 50000; // 50 segundos

    public TemporizadorMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public void run(){
        while (ejecutando){
            try {
                Thread.sleep(INTERVALO);
                mascota.reducirAtributos(5, 5, 10, 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}