package model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import model.abstractclasses.CanCollectInput;
import view.ProjectDialog;

public class CollectInput {

    private static ArrayList<String> inputStrings;

    public static ArrayList<String> getInputs(JTextField... args) {
        inputStrings = new ArrayList<String>();
        for (JTextField field : args) {
            inputStrings.add(field.getText());
        }
        return inputStrings;
    }
        
    }
