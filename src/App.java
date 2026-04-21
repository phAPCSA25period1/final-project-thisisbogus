import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String[] wordArray = input.nextLine().split(" ");

        System.out.println();

        String story = "";

        for (int i = 0; i < wordArray.length/2; i++)
        {
            System.out.print(wordArray[i]);
            System.out.print(" ");
        }

        input.close();
    }
}
