/** 
 * Write a method trimmedMean() that computes the average of a list of numbers,
 * excluding the largest and smallest elements.
 * For example trimmedMean([50, 5, 20, 2, 7, 33, 9, 41]).
 * returns (5+20+7+33+9+41)/6.0 = 
 * 
 * Note: you can accomplish this in a single loop
 */
import java.util.Random;

public class QA6 {

	static Random r;

	public static void main(String[] args) {
		r = new Random(3);
		int numbers[];
		int nums[] = {50};

		System.out.print("List: [ ");
		for(int i = 0; i < nums.length;i++){
			System.out.print(nums[i] + " ");
		}
		System.out.print("]\n");
		System.out.printf("Trimmed Mean: %2.2f",trimmedMean(nums));
		System.out.println("\nExpected:\nTrimmed Mean: 50.00");

		double[] expectedMeans = {36.41,37.05,48.80};
		
		for(int j = 0; j < 3; j++){
			numbers = fillInt();
			System.out.print("List: [ ");
			for(int i = 0; i < numbers.length;i++){
				numbers[i] = r.nextInt(75);
				System.out.print(numbers[i] + " ");
			}
			System.out.print("]\n");
			System.out.printf("Trimmed Mean: %2.2f",trimmedMean(numbers));
			System.out.printf("\nExpected:\nTrimmed Mean: %2.2f\n",expectedMeans[j]);
		}
	}


	/** Method that takes an integer array and calculates the average (mean) of all elements
	 * in the array without the smallest value and largest value
	 * 
	 * @param numbers, integer array containing the values to calculate the sum
	 * @return average of numbers without smallest and largest
	 */
	public static double trimmedMean(int numbers[]){
		int total, smallest, largest;
		//-----------Start below here. To do: approximate lines of code = 15
		//  set total to the sum of the list, and smallest to the smallest number in the list
		// Hint: if there is only one number in the array, return that number as the average.
		// Make sure you never divide by 0 
		
		if (numbers.length == 1) return numbers[0];
		
		if (numbers.length == 2) {
			return (double) (numbers[0]+numbers[1])/2;
		}

		total = largest = smallest = numbers[0];
		
		for(int i = 1; i < numbers.length; i++) {
			total  += numbers[i];

			if(numbers[i] > largest) largest = numbers[i];
			
			else if(numbers[i] < smallest) smallest = numbers[i];
		}

		return ((double) (total-largest-smallest) / (numbers.length - 2));
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	public static int[] fillInt(){
		int numbers[] = new int[r.nextInt(15)+10];
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = r.nextInt(50);
		}

		return numbers;

	}

}
