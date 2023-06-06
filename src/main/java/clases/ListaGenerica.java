package clases;

import java.util.ArrayList;

public class ListaGenerica<T> {
    private ArrayList<T> elementos = new ArrayList<>();

    public void add(T elemento) {
        elementos.add(elemento);
    }

    public void remove(int index) {
        try {
            if (index >= 0 && index < elementos.size()) {
                elementos.remove(index);
            }
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Ivalid index <!>" + index);
        }
    }

    public Object get(int index) {
        Object elemento = null;
        try {
            if (index >= 0 && index < elementos.size()) {
                elemento = elementos.get(index);
            }
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Invalid index <!>" + index);
        }
        return elemento;
    }

    public ArrayList<T> getAll(){
        return elementos;
    }

    public String listarElementos(){
        String lista = "No hay elementos";
        if(!elementos.isEmpty()){
            lista = "";
            for(Object elemento:elementos){
                lista+=elemento.toString()+"\n";
            }
        }
        return lista;
    }
}
