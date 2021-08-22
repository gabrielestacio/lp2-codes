package trabalho03.src.Q4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import trabalho03.Element;
import trabalho03.Heap;


public class HeapComparator<Type extends Element> {

	private int k;
	private Comparator<Type> cmp;
	private Heap<Type> heap;


	HeapComparator(int k, Comparator<Type> cmp){
		heap =  new Heap<Type>(cmp);
		this.cmp = cmp;
		this.k = k;
	
	}

	public void insert(Type value){
		if(heap.size() < this.k){
			heap.insert(value);
		}else{
			if(cmp.compare(value, heap.get()) < 0){
				heap.remove();
				heap.insert(value);
			}
		}
	}

	public List<Type> showValues(){
		List<Type> list = new ArrayList<>();

		while (heap.size() > 0) {
		
			list.add(0, heap.remove());
			
		}
		return list;
	}
	
	public static void main(String[] args) {

		Comparator<Element> cmp = new CompararValores();
		HeapComparator<Element> teste = new HeapComparator<>(3, cmp);
		
		teste.insert(new ImplementElement(60));
		teste.insert(new ImplementElement(40));
		teste.insert(new ImplementElement(30));
		teste.insert(new ImplementElement(20));
		teste.insert(new ImplementElement(10));
		teste.insert(new ImplementElement(50));

		System.out.println(teste.showValues());
	}
}

