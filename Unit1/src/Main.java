//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import javax.swing.*;

/**
 * This is just a placeholder since intellij needs a main to run programs, will be utilized later
 */
public class Main {
    public static void main(String[] args) {
        Frame f = new Frame();
        MouseUse mouse = new MouseUse();
        JComponent drawings = new DrawingPane();
        f.add(drawings);
        drawings.addMouseListener(mouse);
        f.createComponents();

    }
}