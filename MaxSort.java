import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
 * MaxSort
 * 
 * ~Pseudocode~~
 * if n = 0|1, the list is sorted
 * 
 * starting at the end of the array
 *  find the position of the maximum(biggest) element in the array(curr_max), from index 0 to index end;
 */

public class MaxSort {

    static String fileName = "C:\\Users\\Oti\\Desktop\\Projects\\Java\\sortingpractice\\test1.txt";
    static String fileOut = "C:\\Users\\Oti\\Desktop\\Projects\\Java\\sortingpractice\\test1out.txt";
    private static int[] a_list;
    static int max_pos = 0;
    static int end;

    public static void main(String[] args) throws FileNotFoundException {

        long start = System.nanoTime();
        setUp();
        // Variables
        end = a_list.length - 1;

        // Implement MaxSort
        for (; end > 0; end--) {
            max_pos = findMax(a_list, end); // Find Max_position in the array up to the end
            swap(a_list, max_pos, end); // Swap the position of the next value from the end with value in the Max_pos
        }
        long end = System.nanoTime();
        long runTime = end - start;

        print();
        isSorted();

        runTime = TimeUnit.NANOSECONDS.toMillis(runTime);
        System.out.println("Time: " + runTime + " ms");
        testFileGen.toFileArray(fileOut, a_list);
    }

    private static void isSorted() {
        boolean sorted = true;
        for (int i = 0; i < a_list.length - 1; i++) {
            if (a_list[i] > a_list[i + 1])
                sorted = false;
        }
        if (sorted == true) {
            System.out.println("The list is sorted!");
        } else {
            System.out.println("The list is not sorted completely!");
        }
    }

    private static void print() {
        System.out.println(Arrays.toString(a_list));
    }

    public static int[] swap(int[] a_list, int newMax, int switchTo) {
        int temp = 0;
        temp = a_list[switchTo];
        a_list[switchTo] = a_list[newMax];
        a_list[newMax] = temp;

        return a_list;
    }

    // Find the max in the array
    public static int findMax(int[] a_list, int upTo) {
        int maxPos = 0;
        for (int i = 0; i <= upTo; i++) {
            if (a_list[i] > a_list[maxPos])
                maxPos = i;
        }
        return maxPos;
    }

    public static void setUp() throws FileNotFoundException {
        // Accept input from file with list of integers for testing purposes
        File file = new File(fileName);
        Scanner inPut = new Scanner(file);
        List<Integer> list = new ArrayList<>();
        while (inPut.hasNext()) {
            list.add(Integer.valueOf(inPut.next()));
        }
        inPut.close();
        // ArrayList to an array
        a_list = list.stream().mapToInt(i -> i).toArray();
    }

}
