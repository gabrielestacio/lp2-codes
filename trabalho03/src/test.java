package trabalho03.src;


public class test {

	public static void main(String[] args) {
		test teste = new test(10);
		teste.insert(0);
		teste.insert(9);
		teste.insert(5);
		teste.insert(3);
		teste.insert(2);
		teste.insert(7);
  
		while(teste.size() > 0) {
			System.out.println("GET " + teste.get());
			System.out.println("REMOVE " + teste.remove());
		}
		System.out.println("//");
		teste.print();
	}

	protected int[] elements;
	protected int size;

	public test(int capacity) {
		size = 0;
		elements = new int[capacity];
	}

	private void up(int index) {
		int child = index;
		int p = (index - 1) / 2;
		if (child > 0) {
			if (elements[child] > elements[p]) {
				swap(child, p);
				up(p);
			}
		}
	}

	private void down(int index) {
		int p = index;
		int child = ((index + 1) * 2) - 1;
		if (child + 1 < size) {
			if (elements[child + 1] > elements[p]) {
				swap(p, child + 1);
				down(child + 1);
			}
		} else if (child < size) {
			if (elements[child] > elements[p]) {
				swap(p, child);
			}
		}
	}

	private void swap(int i, int j) {
		int aux = elements[i];
		elements[i] = elements[j];
		elements[j] = aux;
	}

	public void update(int current, int newValue) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (elements[i] == current) {
				index = i;
			}
		}
		if (index != -1) {
			if (newValue > current) {
				current = newValue;
				up(index);
			} else if (newValue < current) {
				current = newValue;
				down(index);
			}
		}
	}

	public boolean insert(int e) {
		if (size < elements.length) {
			elements[size] = e;
			size += 1;
			up(size - 1);
			return true;
		}
		return false;
	}

	public int remove() {
		int value = elements[0];
		elements[0] = elements[size - 1];
		size--;
		down(0);
		return value;
	}

	public int get() {
		return elements[0];
	}

	public int size() {
		return size;
	}

    public void print(){
		for (int type : elements) {
			System.out.println(type);
        }}
		
}
