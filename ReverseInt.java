import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
* This program reverses integers.
*
* @author  Jedidiah Alfred
* @version 1.0
* @since   2023-05-04
*/

public final class ReverseInt {
    /**
    * This is a private constructor used to satisfy the
    * style checker.
    *
    * @exception IllegalStateException Utility Class
    */
    private ReverseInt() {
        throw new IllegalStateException("Utility Class");
    }
    /**
    * This is the main method.
    *
    * @param args Unused
    * @throws Exception if something goes wrong
    */

    public static void main(String[] args) {

        // Initializing variables
        int list;
        try {

            // new file object
            final File input = new File("input.txt");
            final Scanner scanner = new Scanner(input);

            // Create the writer
            final FileWriter output = new FileWriter("output.txt");

            // create an arrayList to hold the lines
            final ArrayList<Integer> lists = new ArrayList<Integer>();

            // Getting the input
            while (scanner.hasNextLine()) {
                // Add next line to variable.
                final String line = scanner.nextLine();
                try {
                    // getting next line and putting it in the list
                    list = Integer.parseInt(line);
                    lists.add(list);
                } catch (NumberFormatException err) {
                    System.out.println("Line cannot be"
                        + "converted to int: " + line);
                }
            }

            // set a counter
            final int counter = 0;

            // create a new array for the lines
            final int[] listArr = new int[lists.size()];
            for (int location = 0; location < listArr.length; location++) {
                listArr[location] = lists.get(location);
            }

            // This is the Loop to send the lines to function.
            for (int intList : listArr) {

                // Call function.
                final String reverse = reverse(intList);
                System.out.println(reverse);
                output.write(reverse + "\n");
            }

            // Close the writer.
            output.close();

        } catch (IOException err) {

            // If no input file is found.
            System.err.println("Err: " + err.getMessage());
        }
    }
    /**
    * This is the reverse the string method.
    *
    * @param list This is the string
    * @return the score of the 2dArray
    */

    public static String reverse(int list) {
        // Base case, list cannot be divided.
        if (list < 10) {
            return Integer.toString(list);
        } else {
            return Integer.toString(list % 10) + reverse(list / 10);
        }
    }
}
