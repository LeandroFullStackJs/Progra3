package Clase11.Act4;

import java.util.ArrayList;

public class Usuario {
    private Integer id;
    private String nombre;
    private ArrayList<Integer> amigos;

    public Usuario(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.amigos = new ArrayList<>();
    }

    public void agregarAmigo(Integer id) {
        amigos.add(id);
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Integer> getAmigos() {
        return amigos;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", amigos=" + amigos + "]";
    }
}