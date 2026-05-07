import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
    public static int tryInt(Scanner scan)
    {
        Boolean correctInput = false;
        int inputInt = 0;
        while (!correctInput)
        {
            try {
                inputInt = scan.nextInt();
                correctInput = true;
            }
            catch (InputMismatchException a) {
                System.out.println("Please input a proper integer!");
                scan.next();
            }
        }
        return inputInt;
    }
}
