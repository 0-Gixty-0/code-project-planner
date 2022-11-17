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

    public static void setConstraints(GridBagConstraints constraints, int gridX, int gridY, int constant, double weightX, double weightY, int gridWidth, int gridHeight) {
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        constraints.anchor = constant;
        constraints.weightx = weightX;
        constraints.weighty = weightY;
        constraints.gridwidth = gridWidth;
        constraints.gridheight = gridHeight;
    }

    public static void positionComponent(JPanel panel, Component component, int gridX, int gridY, int constant, double weightX, double weightY, int gridWidth, int gridHeight) {
        GridBagConstraints constraints = new GridBagConstraints();
        GridPositioning.setConstraints(constraints, gridX, gridY, constant, weightX, weightY, gridWidth, gridHeight);
        panel.add(component, constraints);
    }

    public static void positionWithPadding(JPanel panel,  Component component, int gridX, int gridY, int constant, double weightX, double weightY, int gridWidth, int gridHeight, int ipadx, int ipady) {
        GridBagConstraints constraints = new GridBagConstraints();
        GridPositioning.setConstraints(constraints, gridX, gridY, constant, weightX, weightY, gridWidth, gridHeight);
        panel.add(component, constraints);
    }
}
