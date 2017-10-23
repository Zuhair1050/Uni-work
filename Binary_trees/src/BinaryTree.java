
public class BinaryTree<T extends Comparable <T>> implements BTree<T> {
	
	
	TreeNode<T> root;
	
		
		public static void main (String []args){
			BinaryTree<Integer> btree = new BinaryTree<Integer>();
			btree.insert(21);
			btree.insert(65);
			btree.insert(12);
			btree.insert(34);
			btree.insert(43);
			btree.insert(0);
		}

	
	
	
	
	public void insert(T value) {
		if (root == null) {
		root = new TreeNode(value);
		} 
		else if (value.compareTo(value()) < 0) {
		root.left().insert(value);
		System.out.println("Left node");
		} 
		else {
		root.right().insert(value);
		System.out.println("Right node");
		
		}
	}

	@Override
	public T value() {
		// TODO Auto-generated method stub
		System.out.println("Root: " + root.value());
		return root.value();
	}

	@Override
	public BTree<T> left() {
		// TODO Auto-generated method stub
		return root.left();
	}

	@Override
	public BTree<T> right() {
		// TODO Auto-generated method stub
		return root.right();
	}
	
//	public boolean contains(T value) {
//		return false;
//		
//	}

	

}
