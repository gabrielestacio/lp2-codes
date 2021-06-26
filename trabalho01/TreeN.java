/*
	TRABALHO 01 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTÁCIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE LIGADA À QUESTÃO 9
 */
 
package trabalho01;

import java.util.Stack;

public class TreeN {

	public NodeN root;
	public int n;

	public TreeN(int n){
		this.n = n;
	}

	public void levelOrder() {
		Stack<NodeN> P = new Stack<NodeN>();
		P.add(root);
		while (!P.isEmpty()) {
			NodeN current = P.pop();
			if (current != null) {
				System.out.println(current);
				for (int i = current.childs.size() - 1 ; i >= 0 ; i-- )
				{
					P.add(current.childs.elementAt(i));
				}
			}
		}
	}
}