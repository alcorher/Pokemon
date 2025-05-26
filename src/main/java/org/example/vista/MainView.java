package org.example.vista;

import javax.swing.*;

public class MainView {
    private JPanel panel1;
    private JButton ataquesButton;
    private JButton pokemonsButton;
    private JButton entrenadoresButton;
    private JButton combatesButton;
    private JButton pokemonLogo;

    public void setVisible(boolean b) {
        JFrame frame = new JFrame("Pokemon Management");
        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(b);
    }
}
