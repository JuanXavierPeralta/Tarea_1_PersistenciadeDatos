
package com.latamairlines;

import com.latamairlines.views.views;

public class Main {

    public static void main(String[] args) {

        // INICIAR INTERFAZ GRAFICA
        java.awt.EventQueue.invokeLater(() -> {
            new views().setVisible(true);
        });

    }
}
