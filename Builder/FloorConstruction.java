
package Builder;

//import java.util.Arrays;bug test
import java.util.Scanner;

public class FloorConstruction {

    //database used arrays
    //1.creating floor stock array
    //2.floor stock array contains info about floor came from factory at index +1 day
    //3.int builder = N which ensures the construction order from stock array.
    //4.builder -- for each floor construction
    //repeating(/construction) till builder == 0
    public static boolean Search(int[] arr, int key) 
    {
        boolean test = false; 
        for (int element : arr) 
        {
            if (element == key) 
            {
                test = true;
                break;
            }
        }
        return test;

    }




    //driver code
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the total no of floors in the building");
        //n = total number of floor to be made
        int n = sc.nextInt();
        int[] floorStock = new int[n];
        //maybe helpful in future so making temp copy of this array to work on that array 
        int[] tempfloorStock = new int[n]; 
        int builder = n;//builder is the floor to be built at bottom
        int i = 0;//index of floorStock
        String[] result = new String[n];//declare to get desired output
        while (i<n) 
        {
            int day = i+1;
            System.out.println("enter the floor size given on day :"+" "+day);
            int a = sc.nextInt();
            floorStock[i] = a;//floor manufactured at ith day
            tempfloorStock[i] = a;//temp array to use for binary search
            //Arrays.sort(tempfloorStock);-->bug test
            String str="";//initialising str for storing result
            /* ---construction logic---
            WHILE(Search(builder in floorStock))//builder finds desired floor in stock to be built 
                String result = result + current builder value
                builder--   //builder is now the next floor to be built and repeat 
                once result is ready we store that in result array with ith day index for output 
            */
            while(Search(tempfloorStock, builder))
            {   
                //System.out.println("/-"+Arrays.binarySearch(tempfloorStock, builder));-->bug test
                str = str+" "+Integer.toString(builder);//storing construction idea as string
                builder--;
            }
            result[i] = str;//on ith day the construction idea is stored in result array as string
            i++;    
        }
        System.out.println("The order of construction is as follows");
        //this for loop gives desired output
        for (int j = 0; j < result.length; j++) 
        {  
            int Day = j+1;
            System.out.println("Day:"+Day);
            if(result[j]==null)
            {
                System.out.println();
            }    
            else
            {
                System.out.println(result[j]);
            }
        }
    }
}

    