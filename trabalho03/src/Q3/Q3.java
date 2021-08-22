package trabalho03.src.Q3;

import java.util.Comparator;

import trabalho03.Heap;


class HeapComparator<Type extends Comparable<Type>> implements Comparator<Type>{


	@Override
    public int compare(Type o1, Type o2) {
        return  o1.compareTo(o2);
    }
}

public class Q3 {
    

	public static void main(String[] args) {
		Comparator<String>  cmp = new HeapComparator<String>();
		Heap<String> heap = new Heap<String>(cmp);
		heap.insert("teste");
		heap.insert("aaaaa");
		heap.insert("bbbbb");
		heap.insert("cccc");
		heap.insert("ddd");
		heap.insert("ee");


		while(heap.size() > 0) {
			System.out.println("GET " + heap.get());
			System.out.println("REMOVE " + heap.remove());
		}
	}
}