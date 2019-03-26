package lab9;

public class BasicArray {

	public static void main(String[] args) {
		
		final int limit = 15;
		final int multiple = 10;
		
		int[] list = new int[limit];
		
		// initialize the array values
		for (int index = 0; index < limit; index++) {
			list[index] = index * multiple;
		}
		
		list[5] = 999;
		
		for (int value : list) {
			System.out.println(value + " ");
		}
		
		
	}
}
