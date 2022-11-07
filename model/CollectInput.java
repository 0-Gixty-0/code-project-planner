package model;
import java.util.ArrayList;

import javax.swing.*;

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
