/*
*   Assignement 8, Question 1: This is the Utility class
*   Author: Chinthana Sembakutti
*   Date: March 26, 2022
*/
package assignment8;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author chint
 */
public class Utility {
    
    //max method. Works by setting a tmp variable to the first element of the array
    //then testing that against the other elements of the array. If an element is
    //is greater than tmp, then that element will be set to tmp. At the end, tmp will
    //contain the greatest element of the array, and will then be returned
    public Object max(Object object) {
        Comparable[] comparable = (Comparable[])(object); //casting Type Comparable 
        int length = comparable.length;
        if(length == 0) {
            return null;
        }
        Object tmp = comparable[0];
        for(int i=0; i < length; i++) {
            if(comparable[i].compareTo(tmp) > 0) {
                tmp = comparable[i];
            }
        }
        return tmp;
    }
    
    //min method. Works by setting a tmp variable to the first element of the array,
    //then testing that against the other elements of the array. If an element is 
    //smaller than tmp, then that element will be set to tmp. At the end, tmp will
    //contain the smallest element of the array, and will then be returned.
    public Object min(Object object) {
        Comparable[] comparable = (Comparable[])(object);
     int length = comparable.length;
        if(length == 0) {
            return null;
        }
        Object tmp = comparable[0];
        for(int i=0; i < length; i++) {
            if(comparable[i].compareTo(tmp) < 0) {
                tmp = comparable[i];
            }
        }
        return tmp;
    }
    
    //contain method. Takes an input of integer arraylist, Array of type comparable and a index variable.
    //Works by checking every element in the comparable array against one element in the comparable array
    //given by the index variable, and returns true or false if the element is contained or not.
    private boolean contains(ArrayList<Integer> list, Comparable[] comparable, int index) {
        for (int i = 0; i < list.size(); i++) {
            if (comparable[list.get(i)].compareTo(comparable[index]) == 0) {
                return true;
            }
        }
        return false;
    }
    public Comparable[] removeRepetition(Comparable[] comparable) {
        int length = comparable.length;
        if(length == 0) {
            return null;
        } 
        //this array list holds the integer values of the locations in an array.
        //for example, in the case of arr[i], the arraylist will contain the i values of
        //arr (positions in the array).
        ArrayList<Integer> compareOut =  new ArrayList<>(); 
        
       
        // Add the value 0 to the integer arraylist, since the first element of the array
        //is guaranteed to not already exist.
        compareOut.add(0);
        for(int i=1; i < length; i++) {
            //calling contains method. If the element doesnt exist, its position integer will
            //be added to the integer arraylist
            if (!contains(compareOut, comparable, i)) { 
                compareOut.add(i); 
            }
        }
        //creating an array of type Comparable (outArr), with the size of the integer arraylist length.
        Comparable[] outArr = new Comparable[compareOut.size()];
        for(int i=0; i < compareOut.size(); i++) {
            //adding the element of comparable to outArr using the position integers that
            //coincide with non repeated elements. outArr will then contain the same elements
            //of comparable, but without the repeeated elements.
            outArr[i] = comparable[compareOut.get(i)];
        }
        return outArr;
    }
}
        

/*
* Where in this program is polymorphic behavior seen?
*       Polymorphism is seen in the Circle and Student classes where implements Comparable<>   
*       is written (line 14 in both classes), and where the compareTo method is called (Line 22 in Circle class
*       and Line 30 in Student class). This is since the compareTo method is an abstract method and is being 
*       overriden by the Circle and Student Classes.
*
* Given the compareTo method parameter of type Object, what happens if we have an object
* of a class that does not implement the Comparable interface and pass this object to the compareTo
* method of a circle?
*       This will result in an error, since the compareTo method for the object doesn't implement the 
*       compareTo method (it needs its own override in its own class for it to work properly)
*
* Wouldn't it be better if the compareTo method parameter in the Comparable interface was of type
* Comparable and not Object?
*       No, since relevant information from the object is needed to use the compareTo method effectively.
*/