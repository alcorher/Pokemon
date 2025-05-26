package org.example.controlador;

import java.awt.event.ActionListener;
import MainView;
public class MainController {
    public void addAtaquesButtonListener(ActionListener listener) {
        ataquesButton.addActionListener(listener);
    }

    public void addPokemonsButtonListener(ActionListener listener) {
        pokemonsButton.addActionListener(listener);
    }

    public void addEntrenadoresButtonListener(ActionListener listener) {
        entrenadoresButton.addActionListener(listener);
    }

    public void addCombatesButtonListener(ActionListener listener) {
        combatesButton.addActionListener(listener);
    }

    public void addPokemonLogoListener(ActionListener listener) {
        pokemonLogo.addActionListener(listener);
    }
}
