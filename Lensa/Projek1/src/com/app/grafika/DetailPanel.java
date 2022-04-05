package com.app.grafika;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class DetailPanel extends JPanel implements ChangeListener{

    /*
    * objectSize = Ukuran Benda
    * objectDistance = Jarak Benda
    * lensFocusPoint = Titik Fokus Cermin
    * imageSize = Ukuran Bayangan
    * imageDistance = Jarak Bayangan
    * F = FieldText
    * L = Label
    */

    JLabel objectSizeL, objectDistanceL, lensFocusPointL, imageSizeL, imageDistanceL;
    static JTextField imageSizeF, imageDistanceF;
    static JSpinner objectSizeS, objectDistanceS, lensFocusPointS;
    LensPanel lensPanel = new LensPanel();

    public DetailPanel(){
        setLayout(new GridLayout(5, 2, 1, 5));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setPreferredSize(new Dimension(300, 130));
        //setBackground(Color.RED);

        initComponent();
        addComponent();
    }

    public void initComponent(){
        objectSizeL = new JLabel("Ukuran Benda");
        objectDistanceL = new JLabel("Jarak Benda");
        lensFocusPointL = new JLabel("Titik Fokus Cermin");
        imageSizeL = new JLabel("Jarak Bayangan");
        imageDistanceL = new JLabel("Ukuran Bayangan");

        objectSizeS = new JSpinner(new SpinnerNumberModel(100, -250, 250, 1));
        objectSizeS.addChangeListener(this);

        objectDistanceS = new JSpinner(new SpinnerNumberModel(300, -600, 600, 1));
        objectDistanceS.addChangeListener(this);

        lensFocusPointS = new JSpinner(new SpinnerNumberModel(200, 0, 700, 1));
        lensFocusPointS.addChangeListener(this);

        imageSizeF = new JTextField();
        imageSizeF.setEditable(false);
        imageSizeF.setText(String.valueOf(lensPanel.imageDistance()));
        imageDistanceF = new JTextField();
        imageDistanceF.setEditable(false);
        imageDistanceF.setText(String.valueOf(lensPanel.imageSize()));

    }

    public void addComponent(){
        add(objectSizeL);
        add(objectSizeS);
        add(objectDistanceL);
        add(objectDistanceS);
        add(lensFocusPointL);
        add(lensFocusPointS);
        add(imageSizeL);
        add(imageSizeF);
        add(imageDistanceL);
        add(imageDistanceF);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == objectSizeS){
            LeftPanel.objectSizeSlider.setValue((Integer) objectSizeS.getValue());
        } if (e.getSource() == objectDistanceS){
            SlidePanelBottom.objectDistance.setValue((Integer) objectDistanceS.getValue());
        } if (e.getSource() == lensFocusPointS){
            SlidePanelBottom.focusPoint.setValue((Integer) lensFocusPointS.getValue());
        }
    }
}
