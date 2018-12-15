package dataStructures;

public class Arrays {
	private static int SIZE = 10;
	public Object[] fillArray(Object[] arr) {
		for(int i = 0; i < SIZE; i++)
			arr[i]=i;
		return arr;
	}
	public void baseArray() {
		Object[] arr = new Integer[SIZE];
		arr = fillArray(arr);
	}
}
