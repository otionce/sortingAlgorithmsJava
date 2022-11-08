import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MergeSort {

    // Fields
    private static int[] a_list;
    private static String fileName = "C:\\Users\\Oti\\Desktop\\Projects\\Java\\sortingpractice\\test1.txt";
    private static String fileOut = "C:\\Users\\Oti\\Desktop\\Projects\\Java\\sortingpractice\\test2out.txt";

    // private

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.nanoTime();
        setup();
        // Divide the problem into two or more subproblems
        // Solve the subproblems
        divide(a_list, a_list.length);
        long end = System.nanoTime();
        long runtime = end - start;
        isSorted();
        testFileGen.toFileArray(fileOut, a_list);
        runtime = TimeUnit.NANOSECONDS.toMillis(runtime);
        System.out.println("Time: " + runtime + "ms");
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

    private static void setup() throws FileNotFoundException {
        File file = new File(fileName);
        Scanner inPut = new Scanner(file);
        List<Integer> list = new ArrayList<>();
        while (inPut.hasNext()) {
            list.add(Integer.valueOf(inPut.next()));
        }
        inPut.close();
        a_list = list.stream().mapToInt(i -> i).toArray();
    }

    static void divide(int[] a_list, int size) {
        if (size == 0 || size == 1) {
            // Sorted
            return;
        } else {
            // split list into 2 lists, of roughly equal sizes

            int leftSize = size / 2;
            int rightSize = size - leftSize;
            int[] left_list = new int[leftSize];
            int[] right_list = new int[rightSize];

            left_list = copyLeft(a_list, left_list, leftSize);
            right_list = copyRight(a_list, right_list, leftSize);

            divide(right_list, right_list.length);
            divide(left_list, left_list.length);

            // Merge
            merge(left_list, right_list, a_list, leftSize, rightSize);
            // System.out.println(Arrays.toString(a_list) + "\n");
        }
    }

    private static void merge(int[] left_list, int[] right_list, int[] a_list, int leftSize, int rightSize) {
        // 3 variables we will use to merge the left and right lists
        int i = 0, j = 0, k = 0;
        // Compare all values in right_list and left_list
        while (i < leftSize && j < rightSize) {
            if (left_list[i] < right_list[j]) {
                a_list[k++] = left_list[i++];
            } else {
                a_list[k++] = right_list[j++];
            }
        }
        // Copy the remaining values into the original a_list array
        while (i < leftSize) {
            a_list[k++] = left_list[i++];
        }
        while (j < rightSize) {
            a_list[k++] = right_list[j++];
        }
    }

    private static int[] copyLeft(int[] a_list, int[] left_list, int end) {
        // Copy values from a_list into left_list
        for (int i = 0; i < end; i++) {
            left_list[i] = a_list[i];
        }
        return left_list;
    }

    private static int[] copyRight(int[] a_list, int[] right_list, int start) {
        // Copy values from a_list into right_list
        for (int i = 0; i < right_list.length; i++) {
            right_list[i] = a_list[i + start];
        }
        return right_list;
    }

}
