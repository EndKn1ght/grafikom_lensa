package com.app.grafika;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    LensPanel lensPanel = new LensPanel();
    BottomPanel bottomPanel = new BottomPanel();
    LeftPanel leftPanel = new LeftPanel();

    public MainFrame(){
        setTitle("Grafikom");
        setLayout(new BorderLayout(5, 5));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

        //GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);
        setSize(1360, 768);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(lensPanel);
        add(bottomPanel, BorderLayout.SOUTH);
        add(leftPanel, BorderLayout.WEST);
        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        new MainFrame();
    }
}
