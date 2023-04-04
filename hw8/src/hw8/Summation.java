package hw8;
import java.util.Random;

public class Summation extends Thread{

	//Private variables
	private int[] array1;
	private int low, high, partial;
	
	//Construction
	public Summation(int array1[], int low, int high) {
		
		this.array1 = array1;
		this.high = Math.min(high, array1.length);
	}
	
	public int getPartialSum() {
		return partial;
	}
	
	public void run() {
		partial = sum(array1, low, high);
	}

	public static int sum(int[] array1) {
		return sum(array1, 0, array1.length);
	}
	
	public static int sum(int[] array1, int low, int high) {
		int total = 0;
		for (int i = low; i<high; i++) {
			total += array1[i];
		}	
		return total;
	}
	
	public static int parallelSum(int[] array1) {
		return parallelSum(array1, Runtime.getRuntime().availableProcessors());
	}
	
	public static int parallelSum(int[]array1, int threads) {
		int size = (int) Math.ceil(array1.length*1.0 / threads);
	Summation[] sums = new Summation[threads];
	
	for(int i=0; i<threads; i++) {
		
		sums[i] = new Summation(array1, i*size, (i+1)* size);
		
		sums[i].start();
	}
		
	
	try {
		for (Summation sum : sums) {
			sum.join();
		}
	}catch (InterruptedException e) {}
	
	int total = 0;
	
	for (Summation sum : sums) {
		
		total += sum.getPartialSum();
	}
	
	return total;
	
}
		
	
}//end of Summation Class
