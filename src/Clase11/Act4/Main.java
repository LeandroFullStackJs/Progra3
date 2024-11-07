package Clase11.Act4;

public class Main {
    public static void main(String[] args) {
        RedSocial redSocial = new RedSocial();

        Usuario usuario0 = new Usuario(0, "Usuario 0");
        Usuario usuario1 = new Usuario(1, "Usuario 1");
        Usuario usuario2 = new Usuario(2, "Usuario 2");
        Usuario usuario3 = new Usuario(3, "Usuario 3");
        Usuario usuario4 = new Usuario(4, "Usuario 4");
        Usuario usuario5 = new Usuario(5, "Usuario 5");

        redSocial.agregarUsuario(usuario0);
        redSocial.agregarUsuario(usuario1);
        redSocial.agregarUsuario(usuario2);
        redSocial.agregarUsuario(usuario3);
        redSocial.agregarUsuario(usuario4);
        redSocial.agregarUsuario(usuario5);

        redSocial.conectarUsuarios(0, 1);
        redSocial.conectarUsuarios(0, 2);
        redSocial.conectarUsuarios(0, 4);
        redSocial.conectarUsuarios(1, 3);
        redSocial.conectarUsuarios(1, 5);
        redSocial.conectarUsuarios(2, 3);
        redSocial.conectarUsuarios(3, 4);

        System.out.println("Recorrido DFS empezando desde el usuario 0:");
        redSocial.DFS(0);

        System.out.println("\nRecorrido BFS empezando desde el usuario 0:");
        redSocial.BFS(0);
    }
}