import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

/**
 * testFileGen
 */
public class testFileGen {

    private static HashSet<Integer> hs;
    private static Iterator<Integer> it;
    private static String filePath = "C:\\Users\\Oti\\Desktop\\Projects\\Java\\sortingpractice\\test1.txt";

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Create a list of 100 random integers in java between 0 and 1000 without
        // allowiing duplicates
        hs = new HashSet<Integer>();
        int num = 0;
        while (hs.size() < 100000) {
            num = (int) (Math.random() * 1000000);
            hs.add(num);
        }
        // An iterator used to iterate over the hashlist --uses a count variable just to
        // help keep track of how many integers were generated.
        it = hs.iterator();

        // Create a new file to write to, returns false if file already exists.
        try {
            File test = new File(filePath);
            if (test.createNewFile()) {
                System.out.println("File was successfully created: " + test.getName());
            } else {
                System.out.println("File already created");
            }
        } catch (IOException e) {
            // handle exception
            System.out.println("An error occured");
            e.printStackTrace();
        }

        // Write this Hashset to file for testing purposes.
        toFile(filePath);
    }

    // Print to file if it is a hashset using an iterator
    public static void toFile(String path) {
        if (path == filePath) {
            try {
                FileWriter outPut = new FileWriter(path);
                while (it.hasNext()) {
                    outPut.write(String.valueOf(it.next()) + " ");
                }
                outPut.close();
            } catch (IOException e) {
                // handle exception
                System.out.println("An error occured!");
                e.printStackTrace();
            }
        } else {
            try {
                FileWriter outPut = new FileWriter(path);
                while (it.hasNext()) {
                    outPut.write(String.valueOf(it.next()) + " ");
                }
                outPut.close();
            } catch (IOException e) {
                // handle exception
                System.out.println("An error occured!");
                e.printStackTrace();
            }
        }
    }

    // Print to file if it is an int Array
    public static void toFileArray(String path, int[] a_list) {
        try {
            FileWriter outPut = new FileWriter(path);
            for (int i = 0; i < a_list.length; i++) {
                outPut.write(String.valueOf(a_list[i]) + " ");
            }
            outPut.close();
        } catch (IOException e) {
            // handle exception
            System.out.println("An error occured!");
            e.printStackTrace();
        }
    }

}