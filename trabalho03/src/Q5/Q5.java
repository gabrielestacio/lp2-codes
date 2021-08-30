/*
	TRABALHO 03 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 05
 */

package trabalho03.src.Q5;

import trabalho03.Node;
import trabalho03.QuadTree;

public class Q5{
	public static void main(String[] args){
		QuadTree tree = new QuadTree();
		
		tree = qA(tree, args);
		tree = qB(tree);
		qC(tree);
		qD(tree);
		tree.inOrder();
		qE(tree);
	}
	
	public static QuadTree qA(QuadTree tree, String[] args){
		for(int i = 0; i < args.length; i++){
			tree.insert(Integer.parseInt(args[i]));
		}
		
		return tree;
	}
	
	public static QuadTree qB(QuadTree tree){
		tree.randomize();
		
		return tree;
	}
	
	public static void qC(QuadTree tree){
		Node answer = tree.way();
		
		System.out.println("Menor custo: " + answer.getCost() + "\n");
	}
	
	public static void qD(QuadTree tree){
		tree.levelRun();
	}

	public static void qE(QuadTree tree){
		tree.levelRunByLessCost();
	}
}