package com.app.grafika;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BottomPanel extends JPanel {

    SlidePanelBottom slidePanelBottom = new SlidePanelBottom();
    DetailPanel detailPanel = new DetailPanel();

    public BottomPanel(){
        //setBorder(new LineBorder(Color.GRAY.brighter(), 1));
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Jarak Object dan Titik Fokus"));
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setPreferredSize(new Dimension(10,158));
        //setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        //setBackground(Color.GREEN);

        add(slidePanelBottom);
        add(detailPanel);
    }
}
