/*
	TRABALHO 02 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 04
 */

package trabalho02.src.questao04;

import trabalho02.BinarySearchTree;

public class Q4{
   
   public static void main(String[] args) {
       BinarySearchTree teste = new BinarySearchTree();
    
       teste.insert(5);
       teste.insert(8);
       teste.insert(20);
       teste.insert(1);
       teste.insert(19);
       teste.insert(6);
       teste.insert(21);
       teste.insert(2);
       System.out.println(teste);
       System.out.println("Sucessor");
      teste.getSucessor(19);
      System.out.println("Antecessor");
      teste.getAntecessor(8);
      
      
  
   }
    
}
