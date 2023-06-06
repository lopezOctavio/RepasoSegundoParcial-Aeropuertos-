package org.example;



import clases.Aeropuerto;
import clases.Avion;
import clases.Etiqueta;
import clases.ListaGenerica;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import excepciones.Excep_capacidadLimitada;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            File file = new File("G6UyHYt7.json");
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Aeropuerto> aeropuertos = mapper.readValue(file, new TypeReference<>(){});
            System.out.println(aeropuertos.toString());

            System.out.println("LISTAS FILTRADAS");
            List<Aeropuerto> aeropuertosFiltrados = aeropuertosFiltradosPorCapacidad(aeropuertos, 30);
            System.out.println(aeropuertosFiltrados);

            System.out.println("LISTA GENERICA");
            ListaGenerica listaGenerica = new ListaGenerica();
            for(Aeropuerto aeropuerto:aeropuertos){
                for(Etiqueta etiqueta:aeropuerto.getEtiquetas()){
                    listaGenerica.add(etiqueta);
                }
                for(Avion avion:aeropuerto.getAviones()){
                    listaGenerica.add(avion.getPiloto());
                }
            }
            System.out.println(listaGenerica.get(1));
            System.out.println((listaGenerica.listarElementos()));

            System.out.println("HASH SET DE ETIQUETAS");
            HashSet<Etiqueta> setEtiquetas = new HashSet<>();
            for (Object o : listaGenerica.getAll()) {

                System.out.println(o.toString());
                if (o instanceof Etiqueta) {
                    setEtiquetas.add((Etiqueta) o);

                    }
                }

            System.out.println(setEtiquetas);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Aeropuerto> aeropuertosFiltradosPorCapacidad(ArrayList<Aeropuerto> aeropuertos, int filtro)throws Excep_capacidadLimitada{
        ArrayList<Aeropuerto> tmp = new ArrayList<>();
        for(Aeropuerto aeropuerto:aeropuertos){
            try{
                if(aeropuerto.getCapacidad()>filtro){
                    tmp.add(aeropuerto);
                }
            }catch (Exception e){
               throw new Excep_capacidadLimitada("La capacidad es menor que la indicada <!>" , aeropuerto.getCapacidad());

            }
        }
        return tmp;
    }
}