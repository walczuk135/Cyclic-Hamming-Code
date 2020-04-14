package pl.pawel.kul.view.component;


import pl.pawel.kul.view.ControllerListenerCoding;
import pl.pawel.kul.view.ControllerListenerDecoding;

import javax.swing.*;
import java.awt.*;

public class FrontPanel extends JPanel {

    private final MainPanel mainPanel;
    private final RadioButton radioButton;
    private final MainButton mainButton;

    public FrontPanel() {
        super();
        mainPanel=new MainPanel();
        radioButton=new RadioButton();
        mainButton=new MainButton();
        mainButton.getButtonCoding().addActionListener(new ControllerListenerCoding(mainButton,radioButton,mainPanel));
        mainButton.getButtonDecoding().addActionListener(new ControllerListenerDecoding(mainButton,radioButton,mainPanel));
        createPanels();
    }

    private void createPanels() {
        setLayout(new BorderLayout());
        this.add(radioButton,BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(mainButton, BorderLayout.SOUTH);
    }

}

