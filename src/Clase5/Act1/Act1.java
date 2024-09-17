package Clase5.Act1;

import java.util.*;

public class Act1 {
	private Map<Usuario, List<Usuario>> adjList;

	public Act1() {
		this.adjList = new HashMap<>();
	}

	public void agregarUsuario(Usuario usuario) {
		adjList.putIfAbsent(usuario, new ArrayList<>());
	}

	public void seguir(Usuario seguidor, Usuario seguido) {
		adjList.putIfAbsent(seguidor, new ArrayList<>());
		adjList.putIfAbsent(seguido, new ArrayList<>());
		List<Usuario> seguidores = adjList.get(seguidor);
		if (!seguidores.contains(seguido)) {
			seguidores.add(seguido);
		}
	}

	public void dejarDeSeguir(Usuario seguidor, Usuario seguido) {
		List<Usuario> seguidores = adjList.get(seguidor);
		if (seguidores != null) {
			seguidores.remove(seguido);
		}
	}

	public List<Usuario> listarSeguidores(Usuario usuario) {
		return adjList.getOrDefault(usuario, Collections.emptyList());
	}

	public static void main(String[] args) {
		Act1 redSocial = new Act1();

		Usuario alice = new Usuario("Alice");
		Usuario bob = new Usuario("Bob");
		Usuario charlie = new Usuario("Charlie");

		redSocial.agregarUsuario(alice);
		redSocial.agregarUsuario(bob);
		redSocial.agregarUsuario(charlie);

		redSocial.seguir(alice, bob);
		redSocial.seguir(alice, charlie);
		redSocial.seguir(bob, charlie);

		System.out.println("Alice sigue a: " + redSocial.listarSeguidores(alice));
		System.out.println("Bob sigue a: " + redSocial.listarSeguidores(bob));
		System.out.println("Charlie sigue a: " + redSocial.listarSeguidores(charlie));

		redSocial.dejarDeSeguir(alice, bob);
		System.out.println("Alice sigue a (después de dejar de seguir a Bob): " + redSocial.listarSeguidores(alice));
	}
}
