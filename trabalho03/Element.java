/*
	TRABALHO 03 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		INTERFACE FORNECIDA PELO PROFESSOR
 */

package trabalho03;

public interface Element extends Comparable<Element> {

	default public int cost() {
		return 1;
	}
	
	default public boolean isObjective() {
		return false;
	}
}
