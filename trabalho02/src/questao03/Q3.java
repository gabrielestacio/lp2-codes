/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 03
 */
 
package trabalho02.src.questao03;

import trabalho02.BinarySearchTree;

public class Q3{
    public static void main(String[] args){
		BinarySearchTree teste = new BinarySearchTree();
		
		teste.insert(5);
		teste.insert(8);
		teste.insert(20);
		teste.insert(1);
		teste.insert(6);
		
		System.out.println(teste);
		System.out.println("E completa? " +  teste.check());
	}
}
