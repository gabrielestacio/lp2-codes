/*
	TRABALHO 01 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTÁCIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		CLASSE QUE DEFINE O TIPO NODEN, UTILIZADO NA CLASSE TREEN, LIGADA À QUESTÃO 9.
 */
 
package trabalho01;

import java.util.Stack;

public class NodeN {

	public int value;

	public Stack<NodeN> childs = new Stack<NodeN>();;


	public NodeN(int value) {
		this.value = value;

	}

	public String toString() {
		return Integer.toString(value);
	}
	
}

