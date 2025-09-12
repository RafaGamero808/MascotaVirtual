public class Mascota {
    private int felicidad = 50;
    private int panza = 50;
    private int diversion = 50;
    private int caca = 90;
    private int exp = 0;
    private int nivel = 1;
    private int cansancio = 100;

    //Getters
    public int getFelicidad() {
        calcularFelicidad();
        return felicidad;
    }

    public int getPanza() {
        return panza;
    }

    public int getDiversion() {
        return diversion;
    }

    public int getCaca() {
        return caca;
    }

    public int getExp() {
        return exp;
    }

    public int getNivel() {
        return nivel;
    }

    public int getCansancio() {
        return cansancio;
    }

    // MÉTODO PARA CALCULAR FELICIDAD AUTOMÁTICAMENTE
    private void calcularFelicidad() {
        // Sistema basado en el punto crítico de 75 que mencionaste
        int atributosBuenos = 0;
        int totalDesviacion = 0;

        // Verificar cada atributo contra el punto crítico de 75
        if (panza >= 75) atributosBuenos++;
        else totalDesviacion += (75 - panza);

        if (diversion >= 75) atributosBuenos++;
        else totalDesviacion += (75 - diversion);

        if (caca >= 75) atributosBuenos++;
        else totalDesviacion += (75 - caca);

        if (cansancio >= 75) atributosBuenos++; // Cansancio alto es bueno
        else totalDesviacion += (75 - cansancio);

        // Cálculo base: 25 puntos por cada atributo en buen estado
        double felicidadBase = atributosBuenos * 25;

        // Penalización por desviación (cada punto de desviación reduce 0.4 de felicidad)
        double penalizacion = totalDesviacion * 0.4;

        felicidad = (int) Math.max(0, Math.min(100, felicidadBase - penalizacion));
    }

    //METODOS PARA EL MANTENIMIENTO DE LA MASCOTA
    //NIVEL
    private void nivelChequeo(){
        if (exp >= (int)((nivel + 0.5) * 100)){
            nivel++;
            exp = 0;
            System.out.println("¡Subida de nivel! ¡Tu gato ahora es nivel " + nivel + "!");
        }
    }

    //COMIDA
    public void comerPoco() {
        int panzaAntes = panza;
        panza = panza + 25;
        if (panza > 100){
            panza = 100;
        }

        if (panza < 100){
            System.out.println("El nivel de comida de tu gato es " + panza + "% , aún podría comer algo más...");
        }
        else if (panza == 100){
            System.out.println("¡Tu gato está completamente lleno!");
        }
        getPanza();

        caca -= 25;
        getCaca();

        exp += 5;
        nivelChequeo();
    }

    public void comerMucho() {
        int panzaAntes = panza;
        panza = panza + 50;
        if (panza > 100){
            panza = 100;
        }

        if (panza < 100){
            System.out.println("El nivel de comida de tu gato es " + panza + "% , aún podría comer algo más...");
        }
        else if (panza == 100){
            System.out.println("¡Tu gato está completamente lleno!");
        }
        getPanza();

        caca -= 35;
        getCaca();

        exp += 5;
        nivelChequeo();
    }

    public void comerLleno() {
        int panzaAntes = panza;
        panza = panza + 100;
        if (panza > 100){
            panza = 100;
        }

        if (panza == 100){
            System.out.println("¡Tu gato está completamente lleno!");
        }
        getPanza();

        caca -= 35;
        getCaca();

        exp += 45;
        nivelChequeo();
    }

    //DIVERSION
    public void jugarPoco() {
        int diversionAntes = diversion;
        diversion = diversion + 25;
        if (diversion > 100){
            diversion = 100;
        }

        if (diversion < 100){
            System.out.println("Parece que a tu gato no le importaría jugar un rato más... (Diversión: " + diversion + "%)");
        }
        else if (diversion == 100){
            System.out.println("¡Tu gato está completamente entretenido! (Diversión: 100%)");
        }

        cansancio -= 15;
        if (cansancio < 0) {
            cansancio = 0;
        }
        getCansancio();

        exp += 5;
        nivelChequeo();
    }

    public void jugarNormal() {
        int diversionAntes = diversion;
        diversion = diversion + 50;
        if (diversion > 100){
            diversion = 100;
        }

        if (diversion < 100){
            System.out.println("Parece que a tu gato no le importaría jugar un rato más... (Diversión: " + diversion + "%)");
        }
        else if (diversion == 100){
            System.out.println("¡Tu gato está completamente entretenido! (Diversión: 100%)");
        }

        cansancio -= 20;
        if (cansancio < 0) {
            cansancio = 0;
        }
        getCansancio();

        exp += 10;
        nivelChequeo();
    }

    public void jugarMucho() {
        int diversionAntes = diversion;
        diversion = diversion + 75;
        if (diversion > 100){
            diversion = 100;
        }

        if (diversion < 100){
            System.out.println("Parece que a tu gato no le importaría jugar un rato más... (Diversión: " + diversion + "%)");
        }
        else if (diversion == 100){
            System.out.println("¡Tu gato está completamente entretenido! (Diversión: 100%)");
        }

        cansancio -= 25;
        if (cansancio < 0) {
            cansancio = 0;
        }
        getCansancio();

        exp += 15;
        nivelChequeo();
    }

    //HACER CACA
    public void hacerCaca() {
        caca = caca + 100;
        if (caca > 100){
            caca = 100;

            System.out.println("¡Qué a gusto se ha quedado el gato!");
        }
        exp += 1;
        nivelChequeo();
    }

    //DESCANSAR
    public void descansar() {
        cansancio = cansancio + 100;
        if (cansancio > 100){
            cansancio = 100;

            System.out.println("Tu gato está listo para correr los sanfermines");
        }
    }

    //REDUCCIÓN DE ATRIBUTOS
    public void reducirAtributos(int reducirPanza, int reducirDiversion, int reducirCaca, int reducirCansancio){
        panza = Math.max(panza - reducirPanza, 0);
        diversion = Math.max(diversion - reducirDiversion, 0);
        caca = Math.max(caca - reducirCaca, 0);
        cansancio = Math.max(cansancio - reducirCansancio, 0);
    }
}
