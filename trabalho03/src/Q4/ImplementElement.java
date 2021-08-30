/*
	TRABALHO 03 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 04
 */

package trabalho03.src.Q4;

import trabalho03.Element;

public class ImplementElement implements Element{

	protected int value;

	ImplementElement(int value){
		this.value = value;
	}

	@Override
	public int compareTo(Element o) {
		
		return this.value - ((ImplementElement)o).value;
	}

	
	@Override
	public String toString() {
		
		return Integer.toString(this.value);
	}

}