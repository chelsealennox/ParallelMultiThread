//**********************************************************
//Name: Chelsea Lennox                                     *
// Date: April 3, 2023                                     *
// Purpose: Compute the sum in parallel using multi-threads*
//**********************************************************

package hw8;
import java.util.Random;
public class Main {
 

	public static void main(String[] args) {
	
		Random r = new Random();
		
		//Array for 200million 
		int[] array1 = new int[200000000];
		
		for(int i = 0; i < array1.length; i++) {
			
			array1[i] = r.nextInt(10) + 1;	
		}
		
		long start = System.currentTimeMillis();
		
		//Print Summation
		System.out.println(Summation.parallelSum(array1));
		System.out.println("Single: " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		
		//Print Parallel
		System.out.println(Summation.parallelSum(array1));
		System.out.println("Parallel: " + (System.currentTimeMillis() - start));
		
	}//End of main


}//End of Main class
