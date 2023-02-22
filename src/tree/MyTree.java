package tree;

import string.MyStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class MyTree<T extends Comparable<T>> {
    Node<T>  root;

    public MyTree() {
        root = null;
    }

    private void addR(Node<T> current, T data) {

        if(current.data.compareTo(data) > 0 ) {
            if(current.left == null ) {
                current.left = new Node<>(data);
            } else {
                addR(current.left, data);
            }

        } else {
            if(current.right == null) {
                current.right = new Node<>(data);
            } else {
                addR(current.right , data);
            }

        }
    }


    public void add(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            addR(root, data);
        }
    }

    public void preOrderR(Node<T> current) {
            System.out.print(current.data);
            if(current.left != null) {
                System.out.print(" -> ");
                preOrderR(current.left);
            }
            if(current.right != null ) {
                System.out.print(" -> ");
                preOrderR(current.right);
            }
    }
    public void preOrder() {
        if(root != null ) {
            preOrderR(root);
        }

        System.out.println();

    }

    public void postOrderR(Node<T> current ) {
        if(current.left != null) {
            postOrderR(current.left);
            System.out.print(" -> ");
        }
        if(current.right != null ) {
            postOrderR(current.right);
            System.out.print(" -> ");
        }
        System.out.print(current.data);
    }


    public void postOrder() {
        if(root!=null) {
            postOrderR(root);
        }

        System.out.println();
    }

    public void inOrderR(Node<T> current ) {
        if(current.left != null) {
            inOrderR(current.left);
            System.out.print(" -> ");
        }
        System.out.print(current.data);

        if(current.right != null ) {
            System.out.print(" -> ");
            inOrderR(current.right);
        }
    }


    public void inOrder() {
        if(root!=null) {
            inOrderR(root);
        }

        System.out.println();
    }

    private void isExist(Node node, T target) { //binary tree
        boolean flag = false;
        if(node == null) {
            System.out.println("not found");
        } else if(node.data.compareTo(target) >0) { //go right side
            isExist(node.left, target);
        } else if(node.data.compareTo(target) < 0 ) { //go left side
            isExist(node.right, target);
        } else if(node.data.compareTo(target) == 0) {
            System.out.println(" found");
        }


    }

    private boolean isE(Node node, T target) { //binary tree
        if (node == null) {
            return false;
        } else if (node.data.compareTo(target) > 0) { //go right side
            return isE(node.left, target);
        } else if (node.data.compareTo(target) < 0) { //go left side
            return isE(node.right, target);
        } else if (node.data.compareTo(target) == 0) {
            return true;
        }
        return false;
    }


    //common ancestor




    public boolean search(T target) {
        return isE(root, target);
    }

    public void searchTree(T target) {
         isExist(root, target);
    }

    private Node<Integer> convertToTreeFromIntArray(int[] arr, int start, int end) {
        if(start > end) return null;
        int mid = (start+end)/2;
        Node<Integer> node = new Node<>(arr[mid]);
        node.left = convertToTreeFromIntArray(arr, start, mid-1);
        node.right = convertToTreeFromIntArray(arr, mid+1, end);
        return  node;
    }


    public static MyTree convertToTreeFromIntArray(int[] arr) { //sorted array
        MyTree<Integer> tree = new MyTree<>();
        tree.root = tree.convertToTreeFromIntArray(arr,0, arr.length-1) ;
        return tree;
    }


    public void preOrderByNR(Node<T> current, int num) {
        int i = 0;
        if(num == i) {
            System.out.print(current.data);
        } else {
            if(current.left != null) {
                i++;
                preOrderByNR(current.left, num);
            }
            if(current.right != null ) {
                i++;
                preOrderByNR(current.right, num);
            }
        }
    }
    public void preOrderByN(int num) {
        if(root != null ) {
            preOrderByNR(root, num);
        }
        System.out.println();

    }

    private boolean findPath(Node<T> node, T data, List<Node<T>> path) {
        if (node == null) {
            return false;
        }
        path.add(node);

        if (node.data.equals(data)) {
            return true;
        }
        if(findPath(node.left, data, path)) {
            return true;
        }
        if(findPath(node.right, data, path)) {
            return true;
        }
        //when edge is reached && not found
        path.remove(node);
        return false;

    }


    public Node<T> lowestCommonAncestor(T data1, T data2) {
        List<Node<T>> path1 = new ArrayList<>();
        List<Node<T>> path2 = new ArrayList<>();

        if (!findPath(root, data1, path1) || !findPath(root, data2, path2)) {
            return null;
        }

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if(!path1.get(i).equals(path2.get(i))) {
                break;
            }
        }
        return path1.get(i-1);
    }


    public boolean isBinary(Node<T> node) {
        if(node == null ) {
            return true;
        }

        if(node.left != null && node.left.data.compareTo(node.data) >0) {
            return false;
        }

        if(node.right != null && node.right.data.compareTo(node.data) <0) {
            return false;
        }

        if(!isBinary(node.left) || !isBinary(node.right)){
            return false;
        }
        return true;

    }



// reverse number

    public int reverse(int num) {

       int returnValue = 0;
        while (num > 0) {
            int lastNum = num % 10;
            returnValue = returnValue *10 + lastNum;
            num = num/10;
        }
        return returnValue;
    }










    public static void main(String[] args) {
        MyTree<Integer> tree =new MyTree<>();
        tree.add(2);
        tree.add(5);
        tree.add(3);
        tree.add(1);
        tree.add(7);
        tree.add(9);
        tree.add(10);
        tree.preOrder();
        tree.postOrder();;
        tree.inOrder();
        int[] numArr = new int[10];
        for(int i =0; i < numArr.length; i++){
        numArr[i] = i;}
        MyTree<Integer> myBinaryTree = MyTree.convertToTreeFromIntArray(numArr);
        myBinaryTree.inOrder();
        myBinaryTree.postOrder();
        myBinaryTree.preOrder();
        myBinaryTree.searchTree(11);
        myBinaryTree.searchTree(3);
        System.out.println(myBinaryTree.search(3));
        int[] numA = {21, 45, 66, 32 ,463, 13, 14, 43, 1, 3};
        myBinaryTree = MyTree.convertToTreeFromIntArray(numA);
        myBinaryTree.preOrderByN(1);
        myBinaryTree.preOrder();

        System.out.println("ancestor" + tree.lowestCommonAncestor(3,10));
        System.out.println(tree.isBinary(tree.root));
    }

}
