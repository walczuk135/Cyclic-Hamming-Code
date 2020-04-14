package pl.pawel.kul.view;


import pl.pawel.kul.view.component.FrontPanel;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        super("Cyclic Code 7,4 Paweł Walczuk");
        JPanel HtmlAPanel = new FrontPanel();
        add(HtmlAPanel);

        setPreferredSize(new Dimension(500, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
