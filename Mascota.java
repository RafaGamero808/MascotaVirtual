public class Mascota {
    // Atributos base
    private int felicidad = 50;
    private int panza = 50;
    private int diversion = 50;
    private int caca = 90; // Nota: 100% es limpio, va bajando al comer (necesidad de ir al baño)
    private int exp = 0;
    private int nivel = 1;
    private int cansancio = 100; // 100% es energía a tope, baja al jugar

    // SISTEMA DE EVOLUCIÓN
    private String etapaEvolutiva = "Bebé Ico"; // Etapas: Bebé Ico -> Neo Joven -> Alpha Adulto

    // Getters
    public int getFelicidad() {
        calcularFelicidad();
        return felicidad;
    }

    public int getPanza() { return panza; }
    public int getDiversion() { return diversion; }
    public int getCaca() { return caca; }
    public int getExp() { return exp; }
    public int getNivel() { return nivel; }
    public int getCansancio() { return cansancio; }
    public String getEtapaEvolutiva() { return etapaEvolutiva; }

    // METODO PARA CALCULAR FELICIDAD AUTOMÁTICAMENTE
    private void calcularFelicidad() {
        int atributosBuenos = 0;
        int totalDesviacion = 0;

        if (panza >= 75) atributosBuenos++;
        else totalDesviacion += (75 - panza);

        if (diversion >= 75) atributosBuenos++;
        else totalDesviacion += (75 - diversion);

        if (caca >= 75) atributosBuenos++;
        else totalDesviacion += (75 - caca);

        if (cansancio >= 75) atributosBuenos++;
        else totalDesviacion += (75 - cansancio);

        double felicidadBase = atributosBuenos * 25;
        double penalizacion = totalDesviacion * 0.4;

        felicidad = (int) Math.max(0, Math.min(100, felicidadBase - penalizacion));
    }

    // CONTROL DE NIVEL Y EVOLUCIÓN INTERNA
    private void nivelChequeo(){
        int expNecesaria = (int)((nivel + 0.5) * 100);
        if (exp >= expNecesaria){
            nivel++;
            exp = 0;
            System.out.println("¡Subida de nivel! Tu mascota ahora es nivel " + nivel + "!");
            
            // Lógica de Evolución Basada en Niveles
            actualizarEvolucion();
        }
    }

    private void actualizarEvolucion() {
        String etapaAnterior = etapaEvolutiva;
        
        if (nivel >= 10) {
            etapaEvolutiva = "Alpha Adulto";
        } else if (nivel >= 4) {
            etapaEvolutiva = "Neo Joven";
        } else {
            etapaEvolutiva = "Bebé Ico";
        }

        if (!etapaEvolutiva.equals(etapaAnterior)) {
            System.out.println("============== ¡INCREÍBLE! ==============");
            System.out.println("¡Tu mascota ha evolucionado a: " + etapaEvolutiva + "!");
            System.out.println("=========================================");
        }
    }

    // METODOS DE MANTENIMIENTO
    public void comerPoco() {
        panza = Math.min(panza + 25, 100);
        System.out.println("Le diste un snack. Panza al " + panza + "%.");
        caca = Math.max(caca - 15, 0); // Ensuicia un poco el estómago
        exp += 5;
        nivelChequeo();
    }

    public void comerMucho() {
        panza = Math.min(panza + 50, 100);
        System.out.println("Le diste un buen plato de comida. Panza al " + panza + "%.");
        caca = Math.max(caca - 30, 0); // Al comer mucho, le darán ganas de ir al baño más rápido
        exp += 12;
        nivelChequeo();
    }

    public void comerLleno() {
        panza = 100;
        System.out.println("¡Tu mascota está completamente llena!");
        caca = Math.max(caca - 45, 0);
        exp += 25;
        nivelChequeo();
    }

    public void jugarPoco() {
        diversion = Math.min(diversion + 25, 100);
        cansancio = Math.max(cansancio - 15, 0);
        System.out.println("Jugaste un ratito. Diversión: " + diversion + "%. Enérgia: " + cansancio + "%.");
        exp += 8;
        nivelChequeo();
    }

    public void jugarNormal() {
        diversion = Math.min(diversion + 50, 100);
        cansancio = Math.max(cansancio - 25, 0);
        System.out.println("¡Buen rato de juego! Diversión: " + diversion + "%. Energía: " + cansancio + "%.");
        exp += 18;
        nivelChequeo();
    }

    public void jugarMucho() {
        diversion = 100;
        cansancio = Math.max(cansancio - 40, 0);
        System.out.println("¡Sesión intensa de juego! Diversión al máximo. Energía: " + cansancio + "%.");
        exp += 30;
        nivelChequeo();
    }

    public void hacerCaca() {
        caca = 100; // Limpio de nuevo
        System.out.println("¡Tu mascota fue al baño y se ha quedado como nueva!");
        exp += 5;
        nivelChequeo();
    }

    public void descansar() {
        cansancio = 100;
        System.out.println("La mascota durmió plácidamente. ¡Energía recuperada!");
        exp += 5;
        nivelChequeo();
    }

    // Reducción asíncrona controlada por ciclos individuales
    public void reducirPanza(int cantidad) { panza = Math.max(panza - cantidad, 0); }
    public void reducirDiversion(int cantidad) { diversion = Math.max(diversion - cantidad, 0); }
    public void reducirCaca(int cantidad) { caca = Math.max(caca - cantidad, 0); }
    public void reducirCansancio(int cantidad) { cansancio = Math.max(cansancio - cantidad, 0); }
}
