package org.example.controlador;

import org.example.vista.MainView;
import org.example.vista.PokemonView;
import org.example.vista.AtaquesView;
import org.example.vista.EntrenadoresView;
import org.example.vista.CombatesView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;

        // Añadir listeners
        mainView.getPokemonsButton().addActionListener(e -> {
            // Cargar vista de Pokémons
            PokemonView pokemonView = new PokemonView();
            pokemonView.setVisible(true);
        });

        mainView.getAtaquesButton().addActionListener(e -> {
            AtaquesView ataquesView = new AtaquesView();
            ataquesView.setVisible(true);
        });

        mainView.getEntrenadoresButton().addActionListener(e -> {
            EntrenadoresView entrenadoresView = new EntrenadoresView();
            entrenadoresView.setVisible(true);
        });

        mainView.getCombatesButton().addActionListener(e -> {
            CombatesView combatesView = new CombatesView();
            combatesView.setVisible(true);
        });

        // Puedes añadir lógica extra si quieres cerrar la mainView o dejarla abierta
    }
}
