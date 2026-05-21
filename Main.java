public class Main {
    public static void main(String[] args) {
        Mascota miMascota = new Mascota();
        
        // Arrancamos el hilo del tiempo
        TemporizadorMascota temporalizador = new TemporizadorMascota(miMascota);
        Thread hiloTiempo = new Thread(temporalizador);
        hiloTiempo.start();

        System.out.println("Mascota iniciada en etapa: " + miMascota.getEtapaEvolutiva());
    }
}
