package pl.pawel.kul.view.component;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private final JTextArea textArea;
    private final JEditorPane editorPane;

    public MainPanel() {
        super();
        this.textArea = new JTextArea();
        this.editorPane = new JEditorPane();
        createMainPanel();
    }

    private void createMainPanel(){
        editorPane.setEditable(false);
        this.setLayout(new BorderLayout());
        textArea.setBackground(Color.lightGray);
        Font font = new Font(Font.SERIF,  Font.ITALIC, 25);
        textArea.setFont(font);
        editorPane.setText("");
        this.add(textArea,BorderLayout.NORTH);
        this.add(editorPane,BorderLayout.CENTER);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JEditorPane getEditorPane() {
        return editorPane;
    }
}
