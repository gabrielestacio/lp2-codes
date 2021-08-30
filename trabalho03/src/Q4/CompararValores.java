/*
	TRABALHO 03 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 04
 */

package trabalho03.src.Q4;

import java.util.Comparator;

import trabalho03.Element;

public class CompararValores implements Comparator<Element> {

	@Override
    public int compare(Element o1, Element o2) {
        return  o1.compareTo(o2);
    }

}