package lab9;



public class IntegerList {

	int[] list;
	int size;
	
	public IntegerList(int size) {
		list = new int[size];
		this.size += size;
	}
	
	public void randomize() {
		for (int i = 0; i < list.length; i++) {
			list[i] = (int) (Math.random() * 100) + 1; 
		}
	}
	
	public void print() {
		for (int i = 0; i < list.length; i++) {
			System.out.println(i + ":\t" + list[i]);
		}
	}
	
	public void increaseSize() {
		int[] temp = new int[list.length * 2];
		
		for (int i = 0; i < list.length; i++) {
			temp[i] = list[i];
		}
		
		list = temp;
	}
	
	public void addElement(int newVal) {
		if (size == list.length) {
			increaseSize();
		}
		
		list[size] = newVal;
		size++;
		
	}
	
	public void removeFirst(int newVal) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == newVal) {
				list[i] = 0;
				size--;
				break;
			}
		}
	}
	
	public void removeAll(int newVal) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == newVal) {
				list[i] = 0;
				size--;
			}
		}
	}
	
	
	
	
}
