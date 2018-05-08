package eg.edu.alexu.csd.filestructure.sort.cs23;

import java.util.ArrayList;
import java.util.Collection;

import eg.edu.alexu.csd.filestructure.sort.IHeap;
import eg.edu.alexu.csd.filestructure.sort.INode;

public class MaxHeap<T extends Comparable<T>> implements IHeap<T> {

	Node<T> root = null;
	ArrayList<Node<T>> items;
	
	public MaxHeap(){
		items = new ArrayList<Node<T>>();
		root = new Node<>();
		root.index = 0;
	}
	@Override
	public INode<T> getRoot() {
		// TODO Auto-generated method stub
		root = items.size() > 0? items.get(0): null;
		return root;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	// Heapify UP
	public void heapify(INode<T> node) {
		// TODO Auto-generated method stub
		
		Node<T> nodeItem  = (Node<T>) node;
		
		
		if(items.size() == 1)
			return;
		else{
			
			
			int index = ((Double)Math.ceil((items.indexOf(nodeItem) - 2)/2.0)).intValue();
			Node<T> parent = index >= 0 ? items.get(index) : null;
			
			
			while(index >= 0 && nodeItem.getValue().compareTo(parent.getValue()) > 0){
				
				
				T temp =  (T) nodeItem.getValue();
				nodeItem.setValue(parent.getValue());
				parent.setValue(temp);
				nodeItem = parent;
				index  = ((Double)Math.ceil((items.indexOf(nodeItem) - 2)/2.0)).intValue();
				if(index < 0) break;
				else {
					parent = items.get(index);
				}
			}
			
			// assigning left and right children
			int pos= 2 * items.indexOf(nodeItem) + 1;
			if( pos < items.size()){
				nodeItem.SetLeftChild(items.get(pos));
			}
			
		    if(pos + 1 < items.size()){
		    	nodeItem.SetRightChild(items.get(pos + 1));
		    }
		    
		    pos = ((Double)Math.ceil((items.indexOf(nodeItem) - 2)/2.0)).intValue();
		    if(pos >= 0){
		    	nodeItem.SetParent(items.get(pos));
		    }
		    
		}
		
	}

	@Override
	public T extract() {
		if(items.size() > 0){
			T extractedValue = items.get(0).getValue();
			items.get(0).setValue(items.get(items.size() - 1).getValue());
			detachParent(items.get(items.size() - 1));
			items.remove(items.size() - 1);
			heapifyDown();
			return extractedValue;
		}
		return null;
	}

	private void detachParent(Node<T> node) {
		// TODO Auto-generated method stub
		int index = ((Double)Math.ceil((items.size() - 1 - 2)/2.0)).intValue();
		if(index >= 0){
		if((Node<T>)items.get(index).getLeftChild() == node){
			items.get(index).SetLeftChild(null);
		}
		else{
			items.get(index).SetRightChild(null);
		}
		}
		
	}
	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		Node<T> node = new Node<>();
		node.setValue(element);
		items.add(node);
		//check
		int index = ((Double)Math.ceil((items.indexOf(node) - 2)/2.0)).intValue();
		if(index >= 0){
			node.SetParent(items.get(index));
		}
		heapify(node);
		
	}

	@Override
	public void build(Collection<T> unordered) {
		// TODO Auto-generated method stub
		
		items = null;
		items = new ArrayList<>();
		for(T item : unordered){
			insert(item);
		}
	}
	
	
	private void heapifyDown(){
		
		if(items.size() <= 1) return;
		
		Node<T> node = items.get(0);
		
		while(true){
			if(node.hasLeftChild() && node.hasRightChild()){
				Node<T> temp = maxOfChildren((Node<T>)node.getLeftChild(), (Node<T>)node.getRightChild());
				
				
				if(node.getValue().compareTo(temp.getValue()) < 0){
					
					swapNodeValues(node, temp);
					node = temp;
				}
				else break;
			}
			else if(node.hasLeftChild()){
				if(node.getValue().compareTo(node.getLeftChild().getValue()) < 0){
					Node<T> temp = (Node<T>)node.getLeftChild();
					
					swapNodeValues(node, temp);
					node = temp;
				}
				else break;
			}
			else{
				break;
			}
		}
		
		
		
	}
	
	private Node<T> maxOfChildren(Node<T> left, Node<T> right){
		if(left.getValue().compareTo(right.getValue()) > 0)
			return left;
		else return right;
	}
	
	private void swapNodeValues(Node<T> first, Node<T> second){
		T temp = first.getValue();
		first.setValue(second.getValue());
		second.setValue(temp);
	}

}
