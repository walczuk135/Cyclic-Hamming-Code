package pl.pawel.kul.view.component;

import javax.swing.*;
import java.awt.*;

public class MainButton extends JPanel {
    private final JButton buttonCoding;
    private final JButton buttonDecoding;

    public MainButton() {
        super();
        buttonDecoding=new JButton("Decoding");

        buttonCoding =new JButton("Coding");

        createMainButton();
    }

    private void createMainButton() {
        setLayout(new GridLayout(1,2));
        this.add(buttonCoding);
        this.add(buttonDecoding);
    }

    public JButton getButtonCoding() {
        return buttonCoding;
    }

    public JButton getButtonDecoding() {
        return buttonDecoding;
    }
}
