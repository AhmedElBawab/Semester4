package eg.edu.alexu.csd.filestructure.sort.cs23;

import java.util.Set;

import eg.edu.alexu.csd.filestructure.sort.INode;

public class Node<T extends Comparable<T>> implements INode<T> {
	
	
	public int index;
	private T value;
	
	Node<T> nodeLeft = null;
	Node<T> nodeRight = null;
	Node<T> nodeParent = null;
	
	public void SetLeftChild(INode<T> left){
		nodeLeft = (Node<T>) left;
	}
	
	public void SetRightChild(INode<T> right){
		nodeRight = (Node<T>) right;
	}
	
	public void SetParent(INode<T> parent){
		nodeParent = (Node<T>) parent;
	}

	@Override
	public INode<T> getLeftChild() {
		return nodeLeft;
	}

	@Override
	public INode<T> getRightChild() {
		// TODO Auto-generated method stub
		
		return nodeRight;
	}

	@Override
	public INode<T> getParent() {
	
		return nodeParent;
	}

	@Override
	public T getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public void setValue(T value) {
		// TODO Auto-generated method stub
		this.value = value;
	}
	
	public boolean hasRightChild(){
		return nodeRight == null? false : true;
	}
	public boolean hasLeftChild(){
		return nodeLeft == null? false : true;
	}
	public boolean hasParent(){
		return nodeParent == null? false : true;
	}

}
