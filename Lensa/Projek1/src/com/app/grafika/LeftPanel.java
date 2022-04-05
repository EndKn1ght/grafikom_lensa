package com.app.grafika;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class LeftPanel extends JPanel implements ChangeListener {

    static JSlider objectSizeSlider;

    public LeftPanel(){
        //setBackground(Color.ORANGE);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tinggi"));
        setPreferredSize(new Dimension(70, 514));

        objectSizeSlider = new JSlider(-250, 250, 100);

        objectSizeSlider.setOrientation(SwingConstants.VERTICAL);
        objectSizeSlider.setPreferredSize(new Dimension(60, 505));
        objectSizeSlider.setPaintTrack(true);
        objectSizeSlider.setPaintTicks(true);
        objectSizeSlider.setPaintLabels(true);
        objectSizeSlider.setMajorTickSpacing(50);
        objectSizeSlider.setMinorTickSpacing(10);
        objectSizeSlider.setToolTipText("Tinggi Benda");
        objectSizeSlider.addChangeListener(this);
        add(objectSizeSlider);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        DetailPanel.objectSizeS.setValue(objectSizeSlider.getValue());
        LensPanel.objectSize = objectSizeSlider.getValue();
    }

    public Integer getValueSlider(){
        return objectSizeSlider.getValue();
    }

    public void setValSlider(Integer value){
        objectSizeSlider.setValue(value);
    }
}
