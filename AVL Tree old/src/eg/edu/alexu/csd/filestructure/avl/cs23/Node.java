package eg.edu.alexu.csd.filestructure.avl.cs23;
import eg.edu.alexu.csd.filestructure.avl.INode;
public class Node<T extends Comparable<T>> implements INode<T> {
    public Node<T> left = null;
    public Node<T> right = null;
    public Node<T> parent = null;
    private T value;
    private int height;


    public Node(T value){
        this.value = value;
    }

    public Node(Node<T> parent, Node<T> left, Node<T> right, T value){
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    @Override
    public INode<T> getLeftChild() {
        // TODO Auto-generated method stub
        if(left == null){
            return null;
        }
        else return left;
    }
    @Override
    public INode<T> getRightChild() {
        // TODO Auto-generated method stub
        return right;

    }
    @Override
    public T getValue() {
        // TODO Auto-generated method stub
        return this.value;
    }
    @Override
    public void setValue(T value) {
        this.value = value;
    }
    public void setLeftChild(Node<T> left) {
        this.left = left;
    }
    public void setRightChild(Node<T> right) {
        this.right = right;
    }
    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getParent(){
        return this.parent;
    }

    public int getHeight() {


        if(this.isLeaf()){
            this.height = 0;
            System.out.println("Inside this.isLeaf(): " + this.height + "");
            return height;
        }
        else{
            if(this.left != null && this.right != null){
                this.height =  1 + Integer.max(((Node<T>)this.getRightChild()).getHeight(),
                        ((Node<T>)this.getLeftChild()).getHeight());
                System.out.println("Has both children(): " + this.height);
                return this.height;
            }

            else if(this.left !=  null){
                this.height =  1 + ((Node<T>)this.getLeftChild()).getHeight();
                System.out.println("Has left child:  " + this.height);
                return this.height;

            }
            else if(this.right !=  null){
                this.height =  1 + ((Node<T>)this.getRightChild()).getHeight();
                System.out.println("Has right child:  " + this.height);
                return this.height;
            }
        }

        return this.height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public boolean hasLeftChild(){
        if(left == null) return false;
        else  return true;
    }
    public boolean hasRightChild(){
        if(right == null) return false;
        else  return true;
    }
    public boolean hasParent(){
        if(parent == null) return false;
        else  return true;
    }

    public boolean isLeaf(){
        if(right == null && left == null){
            return true;
        }
        else return false;
    }
    @Override
    public String toString() {
        return this.getValue()+ "";
    }
    public void nullifyParent(){
        this.parent = null;
    }
}