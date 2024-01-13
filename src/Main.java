import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame windows = new JFrame();
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.setTitle("fill");

        Painel painel = new Painel();
        windows.add(painel);

        windows.pack();
        windows.setLocationRelativeTo(null);
        windows.setVisible(true);

        painel.startGameThread();







    }
}