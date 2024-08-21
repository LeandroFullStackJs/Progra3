package Clase2.act1;

import Clase2.TreeNode;

public class AlturaBST {

    public static int alturaBST(TreeNode root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(
                            alturaBST(root.left),
                            alturaBST(root.right));
        }
    }
}
