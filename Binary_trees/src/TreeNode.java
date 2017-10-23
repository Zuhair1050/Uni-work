


	public class TreeNode <T  extends Comparable<T>> {
		// TODO Auto-generated constructor stub
		T value;
		BinaryTree<T> left, right;
		public TreeNode(T value) {
		this.value = value;
		System.out.println(value);
		left = new BinaryTree<T>();
		right = new BinaryTree<T>();
		}
		//...// methods follow
		
		public T value() {
		return value;
		}
		public BinaryTree<T> left() {
		return left;
		}
		public BinaryTree<T> right() {
		return right;
		}
		
	}


