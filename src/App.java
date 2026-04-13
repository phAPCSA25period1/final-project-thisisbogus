import javax.swing.JButton;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        //creating instance of JFrame
        JFrame f= new JFrame();

        JButton b1 = new JButton("Hello, World!");
        b1.setBounds(90, 100, 180, 40);
        f.add(b1);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}
