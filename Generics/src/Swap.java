import java.util.Arrays;

public class Swap <A> {
	
	public static void main(String[] args) {
		
		String[] a={"1","2","3"};
        System.out.println("before: "+Arrays.toString(a));
        swap(a,0,2);
        System.out.println("after: "+Arrays.toString(a));
		
	       Swap<?> swap = new Swap();
	
	
	
	}
	
	
	
	public void swap (int[] array, int index1, int index2) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<array.length; i++){
		    array[i] = i;
		}

		swap(array, 14, 3);

		for(int i = 0; i<array.length; i++){
		    System.out.print(i + array[i] + " ");
		}
		
		
		index1 = array[1];
	    array[1] = array[2];
	    array[2] = index1;
		
	    System.out.println(index1 + index2);
	
	}


	public boolean swap(Swap<A> index1, Swap<A> index2) {
	return index1.getValue().equals(index2.getValue());
	}
	private Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	public <B> boolean swap2(Swap<B> index1, Swap<B> index2) {
	return index1.getValue().equals(index2.getValue());
	}
	
	 public static void swap(Object[] a, int i, int j){
	        Object temp=a[i];
	        a[i]=a[j];
	        a[j]=temp;    
	    }
}

	  



