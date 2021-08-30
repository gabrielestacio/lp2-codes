/*
	TRABALHO 03 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DA QUESTÃO 01
 */

package trabalho03.src.Q1;

import java.util.Comparator;

public class Q1 <Type extends Comparable<Type>>{
    
    private Type value;

    private int compareComparable(Type obj){
        return obj.compareTo(this.value);
	}

    private int compareComparator(Type [] values, Comparator<Type> cmp){
        Type a = values[0];
        Type b = values[1];

        if(cmp.compare(a, b) > 0){
          return 1;
        }else if(cmp.compare(a, b) < 0){
            return -1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {

        Comparator<Integer> cmp = new CompareTest();
        Q1<Integer> exemplo = new Q1<>();
        Integer [] valores = {0, 1};
        exemplo.value = 2;
        Integer obj1 = 1;
        System.out.println(exemplo.compareComparable(obj1));
        System.out.println(exemplo.compareComparator(valores, cmp));
    
    }
}

class CompareTest implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
        
    }
}

