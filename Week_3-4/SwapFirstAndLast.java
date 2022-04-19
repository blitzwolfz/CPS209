public class SwapFirstAndLast
{
	
  public static void main(String[] args)
  {
     int[] randoms = new int[10];
     // Create a test array containing random numbers.
     for (int i = 0; i < 10; i++)
     {
       randoms[i] = (int) (Math.random() * 100) + 1;
       // Print the values as they are assigned.
       System.out.print(randoms[i] + " ");
     }
     System.out.println();

     // Perform the swap.
     swapFirstLast(randoms);

     // Print again to see new order.
     for (int i = 0; i < 10; i++)
     {
        System.out.print(randoms[i] + " ");
     }
     System.out.println();
  }

  public static void swapFirstLast(int[] arr)
  {
     int last = arr.length - 1;
     int temp = arr[0];
     arr[0] = arr[last];
     arr[last] = temp;
  }
}