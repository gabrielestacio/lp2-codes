/*
	TRABALHO 03 - LINGUAGEM DE PROGRAMAÇÃO 2 - 2021.1
	GABRIEL ESTACIO E THAUANNY RAMOS
	_________________________________________________
	
	OBSERVAÇÕES DO ARQUIVO:
		IMPLEMENTAÇÃO DO TIPO HEAP (QUESTÃO 2 INCLUSA)
 */

package trabalho03;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap <Type> {
	
	protected ArrayList<Type> elements;
	protected int size;

	protected Comparator<Type> comparator;

	public Heap(Comparator<Type> comparator){
		this.comparator = comparator;
		size = 0;
		elements = new ArrayList<Type>();
	}

	private void up(int index) {
		int child = index;
		int p = (index - 1) / 2;
		if (child > 0) {
			if (comparator.compare(elements.get(child), elements.get(p) ) > 0 ) {
				swap(child, p);
				up(p);
			}
		}
	}
 
    
	private void down(int index) {
		int p = index;
		int child = ((index + 1) * 2) - 1;
		if (child  < size) {
			if (child + 1 < size && comparator.compare(elements.get(child+1), elements.get(p) ) > 0) {
				child += 1;
				
			}
		
			if (comparator.compare(elements.get(child), elements.get(p) ) > 0) {
				swap(p, child);
				down(child + 1);
			}
		}
	}

	private void swap(int i, int j) {
		Type aux = elements.get(i);
		elements.set(i, elements.get(j));
		elements.set(j, aux);

	}

	public void update(Type current, Type newValue) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (elements.get(i) == current) {
				index = i;
			}
		}
		if (index != -1) {
			if (comparator.compare(newValue, current) > 0) {
				current = newValue;
				up(index);
			} else if (comparator.compare(newValue, current) < 0) {
				current = newValue;
				down(index);
			}
		}
	}

	public boolean insert(Type e) {
		if (size <= elements.size()) {
			elements.add(e);
			size += 1;
			up(size - 1);
			return true;
		}else{
			throw new StackOverflowError("Overflow: Não é possivel inserir, capacidade atingida!");
		}
	}

	public Type remove() {
		if(elements.size() > 0){
			Type value = elements.get(0);
			elements.set(0, elements.get(size-1));
			size--;
			elements.remove(size);
			down(0);
			return value;
		}else{
			throw new RuntimeException("Underflow: Array não possui elementos");
		}
	
	}

	public Type get() {
		if(elements.size() > 0){
			return elements.get(0);
		}else{	
			throw new RuntimeException("Underflow: Array não possui elementos");
		}

	}

	public int size() {
		return size;
	}


}
