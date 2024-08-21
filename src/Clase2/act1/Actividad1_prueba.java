package Clase2.act1;

import Clase2.TreeNode;


public class Actividad1_prueba {
    public static void main(String []args){

        // Crear un árbol de ejemplo
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);
        root.right.right.right = new TreeNode(30);
        root.right.right.right.right = new TreeNode(35);

        System.out.println("Altura del arbol: " + AlturaBST.alturaBST(root));

    }
}
