package pl.pawel.kul.view;

import pl.pawel.kul.controller.ControllerDecoding;
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

public class ControllerListenerDecoding implements ActionListener {

    private ControllerDecoding controllerDecoding;
    private final JTextArea textArea;
    private final JEditorPane editorPane;

    private final JRadioButton functionOne;
    private final JRadioButton functionTwo;

    private final JButton button;

    public ControllerListenerDecoding(MainButton mainButton, RadioButton radioButton, MainPanel mainPanel) {
        this.textArea = mainPanel.getTextArea();
        this.editorPane = mainPanel.getEditorPane();

        this.functionOne = radioButton.getFunctionOne();
        this.functionTwo = radioButton.getFunctionTwo();

        this.button = mainButton.getButtonDecoding();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = textArea.getText();

        editorPane.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        Pattern pattern = Pattern.compile("[0-1]*");
        controllerDecoding=new ControllerDecoding(message);
        if (textArea.getText().isEmpty()){
            editorPane.setText("Empty message");
        }
        else if(!pattern.matcher(message).matches()){
            editorPane.setText( "Wrong data. There can only be binary numbers!!!");
        }
        else if (textArea.getText().length()!=7) {
            editorPane.setText("Message must have 7 digits!!!!");
        }
        else if (functionOne.isSelected()) {
            controllerDecoding.setGeneratingFunction(new FunctionOne(),message);
            editorPane.setText(controllerDecoding.decoding());
        }
        else if (functionTwo.isSelected()) {
            controllerDecoding.setGeneratingFunction(new FunctionTwo(),message);
            editorPane.setText(controllerDecoding.decoding());
        }
    }


}
