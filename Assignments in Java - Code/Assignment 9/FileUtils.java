/*
*   Assignement 9, Question 1: This is the fileUtils class
*   Author: Chinthana Sembakutti
*   Date: April 8, 2022
*/
package assignement9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author chint
 */
public class FileUtils {
    //length method, which recieves a path as an input 
    public int length(String path) {
        int size = 0;
        File directory = new File(path);
        //in case the entered path isn't a folder
        if (directory.isFile()) {
            System.out.println("Error, file path was entered. Enter path to a directory.");
            System.exit(0);
        }
        //getting list of files in folder, setting it to file array
        File[] fileArr = directory.listFiles();
        for (int i = 0; i < fileArr.length; i++) {
            if (fileArr[i].isFile()) {
                //adding the size of every file in the file array to size variable
                size += fileArr[i].length();
            } else if (fileArr[i].isDirectory()) {
                //if the file in the file array is another folder
                String subFolder = fileArr[i].getPath();
                //using length method again to find size of the additional folder, adding to size variable
                int sum = length(subFolder);
                size += sum;
            }
        }
        return size;
    }
    
    //creating random string of 15 characters
    private String randomString() {
        Random rand = new Random();
        String str = new String();
        int x = rand.nextInt();
        for (int i = 0; i < 15; i++) {
            while (true) {
                //setting range, so that the outputted string will only be a-z, A-Z
                x = rand.nextInt(65, 123);
                if (x < 91 || x > 96) {
                    break;
                }
            }
            str += Character.toString((char) x);
        }
        return str;
    }

    //createRandomFile method
    public String createRandomFile() throws IOException {
        //creating file with random name
        File file = new File(randomString() + ".txt");
        if (file.createNewFile()) {
            System.out.println("File Successfully created.");
        } else {
            System.out.println("Error Creating File.");
        }
        return file.getAbsolutePath();
    }

    //fileMaker method, which creates and writes inputted string into a file
    private void fileMaker(String str, String filename, int count) throws IOException {
        filename = filename.replace(".txt", "");
        filename += count + ".txt";
        FileWriter filewrite = new FileWriter(filename);
        BufferedWriter writer = new BufferedWriter(filewrite);
        writer.write(str);
        writer.close();
    }

    //split method, which splits a text file into several text files containing n lines of the original
    public void split(String filename, int n) throws FileNotFoundException, IOException {
        int count = 0;
        int countLine = 0;
        File file = new File(filename);
        BufferedReader read = new BufferedReader(new FileReader(file));
        String str = new String();
        while (true) {
            String line = read.readLine();
            //in case end of file is reached
            if (line == null) {
                //if end of file is reached at exactly n lines
                if(countLine == 0) {
                    break;
                }
                //creating last file with < n lines
                count++;
                fileMaker(str, filename, count);
                break;
            }
            //adding a line to str until n number of lines is stored in str
            str += line;
            str += "\n";
            countLine++;
            //creating new file containing str
            if (countLine == n) {
                count++;
                fileMaker(str, filename, count);
                str = new String();
                countLine = 0;
            }
        }
    }
    
    //createDirectories method
    public void createDirectories() {
        Date date = new Date();
        //getting current year, month and day
        int year = date.getYear() +1900;
        int month = date.getMonth()+1;
        int day = date.getDate();
        //creating folder with name of current year
        File fileYear = new File(""+year);
        fileYear.mkdir();
        //creating folder with name of current month inside current year folder
        File fileMonth = new File(fileYear.getAbsolutePath()+"\\"+month);
        fileMonth.mkdir();
        //creating folder with name of current day inside current month folder
        File fileDay = new File(fileMonth.getAbsolutePath()+"\\"+day);
        fileDay.mkdir();
    }
}
