//package LP2;

import java.util.LinkedList;

public class Tree{
	public Node root;
	public String output;
	public int count, sum;
		
	public Tree(){
		//20190038990
		
		count = 0;
		sum = 0;
		
		Node node1 = new Node(2);
		Node node2 = new Node(0);
		Node node3 = new Node(1);
		Node node4 = new Node(9);
		Node node5 = new Node(0);
		Node node6 = new Node(0);
		Node node7 = new Node(3);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(9);
		Node node11 = new Node(0);
		
		root = node6;
		node6.setChilds(node4, node10);
		node4.setChilds(node2, node5);
		node10.setChilds(node8, node11);
		node2.setChilds(node1, node3);
		node8.setChilds(node7, node9);
	}
	
	public void inOrder(Node atual){
		if(atual != null){
			inOrder(atual.left);
			System.out.print(atual.value);
			inOrder(atual.right);
		}
	}
	
	public void preOrder(Node atual){
		if(atual != null){
			System.out.print(atual.value);
			inOrder(atual.left);
			inOrder(atual.right);
		}
	}
	
	public void posOrder(Node atual){
		if(atual != null){
			inOrder(atual.left);
			inOrder(atual.right);
			System.out.print(atual.value);
		}
	}
	
	public void add(int valor){
		Node no = new Node(valor);
		if(root == null){
			this.root = no;
		}
		else{
			Node atual = this.root;
			while(true){
				if(no.value < atual.value){
					if(atual.left != null){
						atual = atual.left;
					}
					else{
						atual.left = no;
						break;
					}
				}
				else{
					if(atual.right != null){
						atual = atual.right;
					}
					else{
						atual.right = no;
						break;
					}
				}
			}
		}
	}
	
	//Questão 7
	public void nodeCount(Node atual){
		if(atual != null){
			nodeCount(atual.left);
			count += 1;
			nodeCount(atual.right);
		}
	}
	
	public void treeSum(Node atual){
		if(atual != null){
			treeSum(atual.left);
			sum += atual.value;
			treeSum(atual.right);
		}
	}
	
	@Override
	public boolean equals(Object obj){
		
		if(this == obj){
			return true;
		}
		
		if(obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		
		Tree tree = (Tree)obj;
		
		this.nodeCount(root);
		tree.nodeCount(tree.root);
		this.treeSum(root);
		tree.treeSum(tree.root);
		
		return ((this.sum == tree.sum) && (this.count == tree.count) && (this.root.value == tree.root.value));
	}
	
	public String toString(Node atual){
		return Integer.toString(atual.value);
	}
}