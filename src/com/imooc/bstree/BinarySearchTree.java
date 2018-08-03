package com.imooc.bstree;

/**
 * 二分搜索树
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>>{

    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e=e;
            left=null;
            right =null;
        }
    }

    private Node root;
    private Integer size;

    public BinarySearchTree(){
        root=null;
        size=0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;

    }
    //改写add方法
    public void insert(E e){
        root=insert(root,e);
    }

    //以node为根节点，递归调用插入元素e
    //返回插入新节点之后二分搜索树的根
    private Node insert(Node node,E e){
        if (node==null){
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e)<0){
            node.left = insert(node.left,e);
        }else if (e.compareTo(node.e)>0){
            node.right =insert(node.right,e);
        }
        return node;
    }
    // 查询二分搜索树中是否含有元素 e
    public boolean contains(E e){
        return contains(root,e);
    }
    //递归查询，当前的节点是否含有元素e
    private boolean contains(Node node,E e){
        if (node ==null){
            return false;
        }
        if (e.compareTo(node.e)==0){
            return true;
        }else if (e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else { //e.compareTo(node.e)>0
            return contains(node.right,e);
        }
    }
    // 二分搜索树前序遍历
    public void preOrder(){
        preOrder(root);
    }
    //前序遍历以node为跟节点的二分搜索树。递归算法
    private void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树中序遍历
    public void inOrder(){
        inOrder(root);
    }
    //中序遍历，以node为节点的二分搜索树。递归算法
    private void inOrder(Node node){
        if (node ==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树，搜索以root为跟节点最小的的元素
    public E minE(){
        if (size==0){
            throw new IllegalArgumentException(" Tree is Empty");
        }
        return minE(root).e;
    }
    //返回以node为节点的 二分搜索树，最小的元素节点。递归算法
    private Node minE(Node node){
        if (node ==null){
            return node;
        }
       return minE(node.left);
    }
    //从二分搜索树中删除最小的元素节点，返回最小节点e 。删除最大的元素模式对称
    public E removeMin(){
        E minE =minE();
        root=removeMin(root);
        return minE;
    }

    private Node removeMin(Node node){
        if (node.left ==null ){
            Node rightNode = node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }
    //从二分搜索树中删除一个元素e
    public void remove(E e){
       root=remove(root,e);
    }
    private Node remove(Node node,E e){
        if (node == null)
            return null;
        if (e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
            return  node;
        }else if (e.compareTo(node.e)>0){
            node.right =remove(node.right,e);
            return node;
        }else { //e ==node.e
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null){
                Node leftNode =node.left;
                node.left =null;
                size--;
                return leftNode;
            }
            //带删除节点左右子树均不为空的情况
            //找到比带删除节点最大的的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minE(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;

            return successor;
        }
    }


    //从二分搜索树中删除最小的元素，递归调用

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }
}
