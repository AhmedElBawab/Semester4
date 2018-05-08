package eg.edu.alexu.csd.filestructure.avl.cs23;



import eg.edu.alexu.csd.filestructure.avl.IAVLTree;
import eg.edu.alexu.csd.filestructure.avl.INode;

public class AVLTree<T extends Comparable<T>> implements IAVLTree<T> {


	public Node<T> root = null;
	int size = 0;


	@Override
	public void insert(T key) {
		// TODO Auto-generated method stub
		 Node<T> node = new Node<T>(key);
	        insert(this.root, node);
	}

	public void insert(Node<T> root, Node<T> node){
		if(root == null){
			this.root = node;

			size++;
			//this.balanceTree(this.root);

			return;
		}
		if(root.getValue().compareTo(node.getValue()) < 0){
			if(root.hasRightChild())
				insert((Node<T>)root.getRightChild(), node);
			else{
				root.setRightChild(node);
				node.setParent(root);
				size++;
			this.balanceTree(node.getParent());
				return;
			}
		}
		else if(root.getValue().compareTo(node.getValue()) > 0){
			if(root.hasLeftChild()){
				insert((Node<T>)root.getLeftChild(), node);
			}
			else{
				root.setLeftChild(node);
				node.setParent(root);
				size++;
				this.balanceTree(node.getParent());
				return;
			}
		}
		else return;

	}

	@Override
	public boolean delete(T key) {
		// TODO Auto-generated method stub

		  Node<T> currentNode = (Node<T>) this.getFromSearch(this.root,key);
          if(currentNode == null){
              return false;
          }
          Node<T> parentNode = currentNode.getParent();
          if(currentNode.isLeaf()){
             if(parentNode.getLeftChild() == currentNode){
                 parentNode.setLeftChild(null);
             }else{
                 parentNode.setRightChild(null);
             }
             currentNode = null;
			 this.balanceTree(parentNode);
          }else{
			  Node maxNode = (Node) this.getMaxLeft();
			  currentNode.setValue((T) maxNode.getValue());
			  this.delete((T) maxNode.getValue());
		  }
          this.size--;
          this.balanceTree(parentNode);
		  return true;
	}

	 private INode<T> getMaxLeft(){
         Node<T> maxNode = (Node<T>) this.root.getLeftChild();
         while(maxNode.hasRightChild()){
             maxNode = (Node<T>) maxNode.getRightChild();
         }
         return maxNode;
     }

	@Override
	public boolean search(T key) {
		// TODO Auto-generated method stub

		if(getFromSearch((Node<T>) root, key) == null){
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return root.getHeight();
	}

	@Override
	public INode<T> getTree() {
		// TODO Auto-generated method stub
		return root;
	}

	private Node<T> getFromSearch(Node<T> node,T key){

		Node<T> temp = null;

		if(node != null){

			if(key.compareTo(node.getValue()) > 0){
				getFromSearch((Node<T>) node.getRightChild(), key);
			}
			else if(key.compareTo(node.getValue()) < 0){
				getFromSearch((Node<T>) node.getLeftChild(), key);
			}
			else {
				temp = node;
			}
		}

		return temp;
	}

	void printPreorder(Node<T> node)
    {
        if (node == null)
            return;
 
        /* first print data of node */
        System.out.print(node.getValue() + " ");
 
        /* then recur on left sutree */
        printPreorder((Node<T>)node.getLeftChild());
 
        /* now recur on right subtree */
        printPreorder((Node<T>)node.getRightChild());


    }

    private void balanceTree(Node<T> node){

			Node<T> rightChild =node.hasRightChild()? (Node<T>) node.getRightChild():null;
			Node<T> leftChild = node.hasLeftChild()? (Node<T>) node.getLeftChild():null;

			int rightChildHeight = -1 ;
			int leftChildHeight = -1;

			if(rightChild != null){
				rightChildHeight = rightChild.getHeight();
			}
			if(leftChild != null){
				leftChildHeight = leftChild.getHeight();
			}

			if(rightChildHeight - leftChildHeight >1){

				Node<T> rightRightChild = rightChild.hasRightChild()? (Node<T>) rightChild.getRightChild() :null;
				Node<T> rightLeftChild  = rightChild.hasLeftChild()? (Node<T>) rightChild.getLeftChild() : null;

				int rightRightChildHeight = -1;
				int rightLeftChildHeight = -1;

				if(rightRightChild != null){
					rightRightChildHeight = rightRightChild.getHeight();
				}
				if(rightLeftChild != null){
					rightLeftChildHeight = rightLeftChild.getHeight();
				}

				if(rightRightChildHeight >= rightLeftChildHeight){
					rotationLeft(node);
				}else{
					doubleRotationRightFirst(node);
				}
			}else if(leftChildHeight - rightChildHeight >1) {


				Node<T> leftRightChild = leftChild.hasRightChild() ? (Node<T>) leftChild.getRightChild() : null;
				Node<T> leftleftChild = leftChild.hasLeftChild() ? (Node<T>) leftChild.getLeftChild() : null;

				int leftRightChildHeight = -1;
				int leftLeftChildHeight = -1;

				if (leftRightChild != null) {
					leftRightChildHeight = leftRightChild.getHeight();
				}
				if (leftleftChild != null) {
					leftLeftChildHeight = leftleftChild.getHeight();
				}

				if (leftLeftChildHeight >= leftRightChildHeight) {
					rotationRight(node);
				} else {
					doubleRotationLeftFirst(node);
				}

			}else{
				if(node.hasParent()) {
					this.balanceTree(node.getParent());
				}
			}
		}

	public void rotationRight(Node<T> node){

		Node<T> temp = (Node<T>) node.getLeftChild();

		node.setLeftChild((Node<T>) temp.getRightChild());

		if(temp.getRightChild() != null){
			((Node<T>)temp.getRightChild()).setParent(node);
		}

		temp.setRightChild(node);

		if(node.getParent() != null){
			temp.setParent(node.getParent());
		}
		else temp.nullifyParent();


		node.setParent(temp);
		if(temp.getParent() != null)
		temp.getParent().setRightChild(temp);

		if(node == root && temp.getParent() == null){
			root = temp;
		}


	}
	public void rotationLeft(Node<T> node){



		Node<T> temp = (Node<T>) node.getRightChild();

		node.setRightChild((Node<T>) temp.getLeftChild());

		if(temp.getLeftChild() != null){
			((Node<T>)temp.getLeftChild()).setParent(node);
		}

		temp.setLeftChild(node);

		if(node.getParent() != null){
			temp.setParent(node.getParent());
		}
		else temp.nullifyParent();


		node.setParent(temp);
		if(temp.getParent() != null)
			temp.getParent().setLeftChild(temp);

		if(node == root && temp.getParent() == null){
			root = temp;
		}

	}

	public void doubleRotationLeftFirst(Node<T> node){



		rotationLeft((Node<T>) node.getLeftChild());

		rotationRight(node);


	}

	public void doubleRotationRightFirst(Node<T> node){

		rotationRight((Node<T>) node.getRightChild());

		rotationLeft(node);


	}
	
}
