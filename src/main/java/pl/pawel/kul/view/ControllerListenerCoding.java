package pl.pawel.kul.view;


import pl.pawel.kul.controller.ControllerCoding;
import pl.pawel.kul.model.FunctionOne;
import pl.pawel.kul.model.FunctionTwo;
import pl.pawel.kul.view.component.MainButton;
import pl.pawel.kul.view.component.MainPanel;
import pl.pawel.kul.view.component.RadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class ControllerListenerCoding implements ActionListener {

    private ControllerCoding controllerCoding;
    private final JTextArea textArea;
    private final JEditorPane editorPane;

    private final JRadioButton functionOne;
    private final JRadioButton functionTwo;

    private final JButton button;

    public ControllerListenerCoding(MainButton mainButton, RadioButton radioButton, MainPanel mainPanel) {
        this.textArea = mainPanel.getTextArea();
        this.editorPane = mainPanel.getEditorPane();
        this.functionOne = radioButton.getFunctionOne();
        this.functionTwo = radioButton.getFunctionTwo();
        this.button = mainButton.getButtonCoding();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = textArea.getText();
        editorPane.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        Pattern pattern = Pattern.compile("[0-1]*");
        if (textArea.getText().isEmpty()){
            editorPane.setText("Empty message");
        }
        else if (textArea.getText().length()!=4) {
            editorPane.setText("Message must have 4 digits!!!!");
        }
        else if(!pattern.matcher(message).matches()){
            editorPane.setText( "Wrong data. There can only be binary numbers!!!");
        }
        else if (functionOne.isSelected()) {
            controllerCoding=new ControllerCoding(message);
            controllerCoding.setGeneratingFunction(new FunctionOne(),message);
            editorPane.setText(controllerCoding.coding());
        }
        else if (functionTwo.isSelected()) {
            controllerCoding=new ControllerCoding(message);
            controllerCoding.setGeneratingFunction(new FunctionTwo(),message);
            editorPane.setText(controllerCoding.coding());
        }
    }

}

