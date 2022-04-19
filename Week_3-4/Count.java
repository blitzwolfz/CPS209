public class Count
{
   public static int count(int e, int[] b)
   {
      int count = 0;
      for (int i = 0; i < b.length; i++)
      {
         if (e == b[i])
         {
            count++;
         }
      }
      return count;
   }
   
   // This method assumes that the two array arguments
   // are the same size.
   public static boolean sameElements(int[] a, int[] b)
   {
      for (int i = 0; i < a.length; i++)
      {
         if (count(a[i], a) != count(a[i], b))
         {
            return false;
         }
      }
      return true;
   }   
   
   public static void main(String[] args)
   {
      int[] a = {1, 4, 9, 16, 9, 7, 4, 9, 11};
      int[] b = {11, 1, 4, 9, 16, 9, 7, 4, 9};
   
      System.out.print("The arrays a and b ");
   
      if (!sameElements(a, b))
      {
         System.out.print("do not ");
      }
   
      System.out.println("have the same elements." );
   }
}
