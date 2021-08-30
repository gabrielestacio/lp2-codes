package trabalho03;

public interface Element extends Comparable<Element> {

	default public int cost() {
		return 1;
	}
	
	default public boolean isObjective() {
		return false;
	}
}
