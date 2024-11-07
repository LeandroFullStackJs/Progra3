package Clase11.Act3;
import java.util.ArrayList;

import java.util.ArrayList;

public class Almacen {
    private Integer id;
    private String nombre;
    private ArrayList<Integer> destinos;

    public Almacen(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.destinos = new ArrayList<>();
    }

    public void agregarDestino(Integer id) {
        destinos.add(id);
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Integer> getDestinos() {
        return destinos;
    }

    @Override
    public String toString() {
        return "Almacen [id=" + id + ", nombre=" + nombre + ", destinos=" + destinos + "]";
    }
}
