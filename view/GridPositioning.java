package view;

import java.awt.*;

import javax.swing.*;

public class GridPositioning {
    public static void main(String[] args) {
        
    }

    public static void set_grid_x(GridBagConstraints constraints, int x) {
        constraints.gridx = x;
    }

    public static void set_grid_y(GridBagConstraints constraints, int y) {
        constraints.gridy = y;
    }

    public static void set_anchor(GridBagConstraints constraints, int constant) {
        constraints.anchor = constant;
    }

    public static void set_weight_x(GridBagConstraints constraints, double x) {
        constraints.weightx = x;
    }

    public static void set_weight_y(GridBagConstraints constraints, double y) {
        constraints.weighty = y;
    }
}
