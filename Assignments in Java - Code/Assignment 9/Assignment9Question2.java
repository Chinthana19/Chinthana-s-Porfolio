/*
*   Assignement 9, Question 2: This program finds the time difference of creating a binary file of 10,000,000 integers
                                using bufferedwriter, compared to a nonbuffered writer.
*   Author: Chinthana Sembakutti
*   Date: April 8, 2022
*/
package assignement9;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/**
 *
 * @author chint
 */
public class Assignment9Question2 {
    public static void main(String[] args) throws IOException {
        Assignment9Question2 program = new Assignment9Question2();
        
        int[] array = program.createIntegers(10000000);
        
        
        long startTimeBuffer = System.currentTimeMillis();
        program.withBuffering(array, "withBuffer.bin");
        long endTimeBuffer = System.currentTimeMillis();
        System.out.println("Time taken with Buffer: "+(endTimeBuffer - startTimeBuffer)+"ms");
        
        long startTimeNoBuffer = System.currentTimeMillis();
        program.withoutBuffering(array, "withoutBuffer.bin");
        long endTimeNoBuffer = System.currentTimeMillis();
        System.out.println("Time taken without Buffer: "+(endTimeNoBuffer - startTimeNoBuffer)+"ms");
    }
    
    public int[] createIntegers(int n) {
        Random rand = new Random();
        int[] intArray = new int[n];
        for(int i = 0; i < n; i++) {
            intArray[i] = rand.nextInt();
        }
        return intArray;
    }
    
    public void withBuffering(int[] arr, String filename) throws IOException {
        int length = arr.length;
        FileWriter filewrite = new FileWriter(filename);
        BufferedWriter writer = new BufferedWriter(filewrite);
        
        for(int i=0; i < length; i++) {
            writer.write(arr[i]);
        }
        writer.close();   
    }
    
    public void withoutBuffering(int[] arr, String filename) throws IOException {
        int length = arr.length;
        FileWriter filewrite = new FileWriter(filename);
        
        for(int i=0; i < length; i++) {
            filewrite.write(arr[i]);
        }
        filewrite.close();
    }
}
