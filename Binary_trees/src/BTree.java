
public interface BTree <T extends Comparable<T>> {
	
	
	
	
	public void insert(T value);
	// @return the value held at the root of this tree
	public T value();
	// @return the left (right) subtree of this tree
	public BTree<T> left();
	public BTree<T> right();

}
