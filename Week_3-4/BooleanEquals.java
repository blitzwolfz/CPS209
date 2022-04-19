public class BooleanEquals
{
   public static boolean equals(int[] a, int[] b)
   {
      if (a.length != b.length) 
      {
         return false;
      }
   
      for (int i = 0; i < a.length; i++)
      {
         if (a[i] != b[i]) 
         { 
            return false; 
         }
      }
      return true;
   }

   public static void main(String[] args)
   {
      int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
      int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8};
      int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
      int[] arr4 = {1, 2, 3, 4, 5, 4, 7, 8};
   
      System.out.print("Arrays 1 and 2 are ");
      if (!equals(arr1, arr2))
      {
         System.out.print("not ");
      }
      System.out.println("equal." );
   
      System.out.print("Arrays 1 and 3 are ");
      if (!equals(arr1, arr3))
      {
         System.out.print("not ");
      }
      System.out.println("equal." );
   
      System.out.print("Arrays 1 and 4 are ");
      if (!equals(arr1, arr4))
      {
         System.out.print("not ");
      }
      System.out.println("equal." );
   }
}
