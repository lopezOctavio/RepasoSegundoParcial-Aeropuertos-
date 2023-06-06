package excepciones;

public class Excep_capacidadLimitada extends Exception{
    private int cant;


    public Excep_capacidadLimitada(String mensaje, int cant) {
        super(mensaje);
        this.cant = cant;
    }

    public int getCant() {
        return cant;
    }
}
