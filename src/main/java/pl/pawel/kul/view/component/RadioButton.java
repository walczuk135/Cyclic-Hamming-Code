package pl.pawel.kul.view.component;

import javax.swing.*;
import java.awt.*;

public class RadioButton extends JPanel {
    private final JRadioButton functionOne;
    private final JRadioButton functionTwo;

    public RadioButton() {
        super();
        this.functionOne = new JRadioButton("x^3+x+1");
        this.functionTwo = new JRadioButton("x^3+x^2+1");

        createRadioButtonsAlphabet();
    }

    private void createRadioButtonsAlphabet() {
        ButtonGroup groupCase = new ButtonGroup();
        groupCase.add(functionOne);
        groupCase.add(functionTwo);

        this.setLayout(new GridLayout(1, 1));
        this.add(functionOne);
        this.add(functionTwo);

    }

    public JRadioButton getFunctionOne() {
        return functionOne;
    }

    public JRadioButton getFunctionTwo() {
        return functionTwo;
    }


}
