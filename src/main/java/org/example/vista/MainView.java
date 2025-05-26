package org.example.vista;

import javax.swing.*;

public class MainView {
    private JPanel panel1;
    private JButton ataquesButton;
    private JButton pokemonsButton;
    private JButton entrenadoresButton;
    private JButton combatesButton;
    private JButton pokemonLogo;

    private JFrame frame;

    public MainView() {
        frame = new JFrame("Pokemon Management");
        frame.setContentPane(panel1);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }

    // Getters para los botones
    public JButton getAtaquesButton() {
        return ataquesButton;
    }

    public JButton getPokemonsButton() {
        return pokemonsButton;
    }

    public JButton getEntrenadoresButton() {
        return entrenadoresButton;
    }

    public JButton getCombatesButton() {
        return combatesButton;
    }

    public JButton getPokemonLogo() {
        return pokemonLogo;
    }
}
