/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 02
 */
 
package trabalho02.src.questao02;

import trabalho02.BinarySearchTree;

public class Q2{
    public static void main(String[] args){
		BinarySearchTree teste = new BinarySearchTree();
		
		teste.insert(5);
		teste.insert(8);
		teste.insert(20);
		teste.insert(1);
		teste.insert(6);
		teste.insert(1);
		teste.insert(18);
		teste.insert(25);
		teste.insert(20);
		teste.insert(23);
		teste.insert(19);
		
		System.out.println(teste);
		
		System.out.println("Tamanho da árvore: " +  teste.size());
		
		teste.remove(20);

		System.out.println(teste);
		
		System.out.println("Tamanho da árvore: " +  teste.size());
	}
}
