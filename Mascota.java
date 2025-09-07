import org.w3c.dom.ls.LSOutput;

public class Mascota{

    private int felicidad = 50;
    private int panza = 50;
    private int diversion = 50;
    private int caca = 90;
    private int exp = 0;
    private int nivel = 1;
    private int cansancio = 100;

    //Getters
    public int getFelicidad() {
        return felicidad;
    }

    public int getPanza() {
        return panza;
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

    public void jugarPoco () {
        diversion = diversion + 25;
        if (diversion > 100){
            diversion = 100;

            System.out.println("Ya vale, que no queremos estimular de más al gato");
        }

        else if (diversion < 100){
            System.out.println("Parece que a tu gato no le importaría jugar un rato más...");
        }

        exp += 5;
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
