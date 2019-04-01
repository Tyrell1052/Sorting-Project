    
/* CSCI 112 - Fall 2013
 * reading, sorting and writing data in text files
 * this program reads data from a text file, sort the data,
 * then writes the data back to another text file.
 * last edited Oct 1, 2013 by C. Herbert
 * 
 * for this to work, the file "unsorted.txt" must be in the project folder
 * warning -- this will overwrite the file "tutorials.txt"
 * 
 * This program has methods to read lines from a text from a file into an array,
 * display a text array on screen line-by-line, sort a text array, and write 
 * a text array to a data file line by line.
 * 
 * The program is limited to a file with 100 lines. To change this, change the
 * size of the array declared in the main method.
 *
 * Tyrell Robbins:      CSCI 112     10-26-19
 *
 * Added two methods
 *
 * selectionSort() this method implements the Selection Sort algorithm able to sort data in a .txt file
 *
 *
 * insertionSort() this method implements the Insertions Sort algorithm able to sort data in a .txt file
 * 
 */
package tutorials;
import java.util.Scanner; 

public class Tutorials 
{

    // the main method call methods to perform each part of the program
public static void main(String[] args) throws Exception

    {
        String[] tutorials = new String[100];     // an array to hold a list of tutorials
        int count;		// the number of elements in the that are used
        
        // read data into tutorials[] line by line and return count
        count = readLines(tutorials); 
        
        // print the array on the screen
        System.out.println("The original array:\n");
        displayLines(tutorials, count);
        
        //to sort the array 
        //sortStringArray(tutorials, count);

        //insertion sort
        insertionSort(tutorials, count);

        // selection sort
        //selectionSort(tutorials, count);

        // print the array on the screen  line by line
        System.out.println("\nThe sorted array:\n");
        displayLines(tutorials, count);
        
        // write the array to a data file line by line
        writeLines(tutorials, count);

    } // end main()        
/**************************************************************************************************************/
    
    /* This method reads data from the file into the array. 
     * We want our array to work with up to 100 elements  
     * Each line from the file will be one element in the array.
     * 
     * The parameter refers to the array in the main method.  
     * 
     * The method returns the number of elements it uses.
     */
     public static int readLines(String[] lines) throws Exception
    {
        int count = 0; // number of array elements with data
        
        // Create a File class object linked to the name of the file to read
        java.io.File unsorted = new java.io.File("unsorted.txt");

        // Create a Scanner named infile to read the input stream from the file
        Scanner infile  = new Scanner(unsorted);
   
        /* This while loop reads lines of text into an array. it uses a Scanner class 
         * boolean function hasNextLine() to see if there another line in the file.
         */
        
        while ( infile.hasNextLine() ) 
        {
            // read a line and put it in an array element
            lines[count] = infile.nextLine();
            count ++;  // increment the number of array elements with data
            
        } // end while
        
        infile.close();
        return count;    // returns the number of items used in the array.
    
    } // end readList()
/*************************************************************************************************************/
    
    /* This method sorts an array of Strings line by line 
     * using a simple bubble sort. 
     * 
     * The first parameter refers to the array in the main method.
     * The second parameter is the number of elements in the array that
     * actually contain data
     */
    
    public static void sortStringArray(String[] a, int count)
    {
        boolean swapped;    //  keeps track of when array values are swapped 
        int i;              // a loop counter
        String temp;         // catalyst variable for String swapping
        
        // Each iteration of the outer do loop is is one pass through the loop. 
        // If anything was swapped, it makes another pass
        do     
        {
            // set swapped to false before each pass
            swapped = false;
            
            // the for loop is a pass through the array to the second to last element
            for( i=0 ; (i < count-1) ; i++ )    
            {
                // if the two items are out of order  see page 16 for String compareTo() 
                if(a[i+1].compareTo(a[i]) < 0)	 
                {
                    // swap the two items ans set swapped to true    
                    temp  = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    
                    swapped = true;    
		
		}  // end if
            } // end for
            
        // the outer loop will repeat if a swap was made  – another passs
        } while (swapped);	
        
    } // end sortStringArray
/***********************************************************************************************************/

        /*This method prints an array of Strings on the screen.  
         * The first parameter refers to the array in the main method.  The second 
         * parameter is the number of elements in the array that actually contain data
         */
        public static void displayLines(String[] lines, int count)
        {
            int i;  // loop counter
        
            // iterate the elements actually used
            for ( i=0; i < count; i++)    
                System.out.println(lines[i]);
        
        } // end displayLines()
/**********************************************************************************************************/

/* This method writes an array of Strings to a text data file.  
 * The first parameter refers to the array in the main method. The second parameter
 * is the number of elements in the array that actually contain data
 */

        public static void  writeLines(String[] lines, int count) throws Exception
        {
            // create a File class object and give the file the name tutorials.txt
            java.io.File tut  = new java.io.File("tutorials.txt");
            // Create a PrintWriter text output stream and link it to the file x
            java.io.PrintWriter outfile  = new java.io.PrintWriter(tut);
            
            int i;  // loop counter
            
            // iterate the elements actually used
            for ( i=0; i < count; i++)    
                outfile.println(lines[i]);

            outfile.close();            
            
        } // end writeTextArray()
/*************************************************************************************************************/

/*
 * This method sorts an array of Strings line by line
 * using a Insertion Sort algorithm able to sort String data
 *
 * The second parameter is the number of elements in the array that
 *
 */

        public static void insertionSort(String[] a, int count){

            int i, j; /* Creating variables to iterate through my loops*/
            String key;// this key variable will keep track of the index of the array


            for(i=1; i<count; i++){
                key = a[i];
                j = i-1;

                //here i am using the compareTo method to aid in the comparision of each string
                while (j >= 0 && a[j].compareTo(key) > 0) {
                    a[j + 1] = a[j];
                    j = j - 1;
                }
                a[j + 1] = key;

                }// end for()

            }//end insertionSort()


/*************************************************************************************************************/


/*
 * This method sorts an array of Strings line by line
 * using a Selection Sort algorithm able to sort String data
 *
 * The second parameter is the number of elements in the array that
 *
 */

        public static void selectionSort(String[] a, int count){
            String temp; // temp variable for swapping the array
            int i,j,minimumIndex; //variables needed to aid in the sorting process

            for (i=0; i<count -1; i++){
                minimumIndex = i;
                for(j=i+1; j<count; j++){
                    if(a[j].compareTo(a[minimumIndex])<0){
                        minimumIndex = j;
                    }
                }
                temp =a[minimumIndex];
                a[minimumIndex] = a[i];
                a[i] = temp;

            }// end for()


        }// end selectionSort()

}// end Tutorials