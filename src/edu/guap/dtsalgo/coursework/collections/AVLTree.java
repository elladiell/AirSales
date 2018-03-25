package edu.guap.dtsalgo.coursework.collections;



public class AVLTree<T extends Comparable<T>> {

    private AvlTreeNode root = null;

    class AvlTreeNode {

        AvlTreeNode(T element) {
            this(element, null, null);
        }

        AvlTreeNode(T element, AvlTreeNode ll, AvlTreeNode rl) {
            data = element;
            left = ll;
            right = rl;
            height = 0;
        }

        AvlTreeNode left;
        AvlTreeNode right;
        T data;
        int height;

    }

    public AVLTree() {
    }

    private  int height(AvlTreeNode t) {
        if (t == null) {
            return -1;
        } else return t.height;

    }

    // Малое правое вращение
    private  AvlTreeNode rotateSmallRight(AvlTreeNode node) {
        if (node == null) return node;
        AvlTreeNode lc = node.left;
        if (lc == null) return node;
        node.left = lc.right;

        lc.right = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        lc.height = Math.max(height(lc.left), node.height) + 1;
        return lc;
    }

    // Малое левое вращение
    private  AvlTreeNode rotateSmallLeft(AvlTreeNode node) {
        if (node == null) return node;
        AvlTreeNode rc = node.right;
        if (rc == null) return node;
        node.right = rc.left;
        rc.left = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        rc.height = Math.max(height(rc.right), node.height) + 1;
        return rc;
    }


    // Большое правое вращение
    private  AvlTreeNode rotateBigRight(AvlTreeNode node) {
        node.left = rotateSmallLeft(node.left);
        return rotateSmallRight(node);
    }

    // Большое левое вращение
    private  AvlTreeNode rotateBigLeft(AvlTreeNode node) {
        node.right = rotateSmallRight(node.right);
        return rotateSmallLeft(node);
    }

    /**
     * puts an element into the Tree, maintaining order and height conditions
     *
     * @param element
     */
    public void put(T element) {
        root = put(element, root);
    }


    private AvlTreeNode put(T element, AvlTreeNode subroot) {
        if (subroot == null) {
            // Добавляем в корень, если его ещё нет
            subroot = new AvlTreeNode(element, null, null);
        } else
            //Добавляем в левое поддерево, если element < subroot.data
            if (element.compareTo(subroot.data) < 0) {
                subroot.left = put(element, subroot.left);
                if (height(subroot.left) - height(subroot.right) == 2) {
                    if (height(subroot.left.right) <= height(subroot.left.left))
                        subroot = rotateSmallRight(subroot);
                    else
                        subroot = rotateBigRight(subroot);
                }
            } else if (element.compareTo(subroot.data) > 0) {
                //Добавляем в правое поддерево, если element > subroot.data
                subroot.right = put(element, subroot.right);
                if (height(subroot.right) - height(subroot.left) == 2) {
                    if (height(subroot.right.left) <= height(subroot.right.right))
                        subroot = rotateSmallLeft(subroot);
                    else
                        subroot = rotateBigLeft(subroot);
                }
            }

        subroot.height = Math.max(height(subroot.left), height(subroot.right)) + 1;
        return subroot;
    }


    private void output(AvlTreeNode avlTreeNode) {
        if (avlTreeNode != null) {
            output(avlTreeNode.left);
            System.out.println(avlTreeNode.data);
            output(avlTreeNode.right);
        }
    }

    public void output() {
        output(root);
    }

    private void makeVector(AvlTreeNode T, Vector V) {
        if (T != null) {
            makeVector(T.left, V);
            V.addElement(T.data);
            makeVector(T.right, V);
        }
    }

    private void makeVector(Vector V) {
        makeVector(root, V);
    }

    /**
     * returns a Vector containing
     * elements of this Tree in their search order
     */
    public Vector toVector() {
        Vector V = new Vector();
        makeVector(V);
        return V;
    }


}


