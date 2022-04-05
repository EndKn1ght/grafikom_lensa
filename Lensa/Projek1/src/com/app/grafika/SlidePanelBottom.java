package com.app.grafika;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SlidePanelBottom extends JPanel{

    static JSlider focusPoint, objectDistance;

    public SlidePanelBottom(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setPreferredSize(new Dimension(1000, 130));
        //setBackground(Color.pink);

        focusPoint = new JSlider(0, 600, 100);
        focusPoint.setPaintTrack(true);
        focusPoint.setPaintTicks(true);
        focusPoint.setPaintLabels(true);
        focusPoint.setMajorTickSpacing(100);
        focusPoint.setMinorTickSpacing(10);
        focusPoint.setToolTipText("Titik Fokus Cermin");
        focusPoint.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                DetailPanel.lensFocusPointS.setValue(focusPoint.getValue());
                LensPanel.focusPointF = focusPoint.getValue();
            }
        });

        objectDistance = new JSlider(-600, 600, 300);
        objectDistance.setPaintTrack(true);
        objectDistance.setPaintTicks(true);
        objectDistance.setPaintLabels(true);
        objectDistance.setMajorTickSpacing(100);
        objectDistance.setMinorTickSpacing(10);
        objectDistance.setToolTipText("Jarak Benda");
        objectDistance.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                DetailPanel.objectDistanceS.setValue(objectDistance.getValue());
                LensPanel.objectDistance = objectDistance.getValue();
            }
        });

        add(Box.createVerticalStrut(20));
        //add(Box.createVerticalGlue());
        add(objectDistance);
        //add(Box.createVerticalGlue());
        add(focusPoint);
        //add(Box.createVerticalGlue());
    }

}
