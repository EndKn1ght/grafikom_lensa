package com.app.grafika;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LensPanel extends JPanel implements ActionListener, MouseMotionListener {

    final int widthPanel = 1260;
    final int heightPanel = 558;
    static int objectDistance = 300;
    static int objectSize = 100;
    static int focusPointF = 100;


    public LensPanel() {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Lensa Cekung"));
        setPreferredSize(new Dimension(widthPanel, heightPanel));
        addMouseMotionListener(this);
        Timer timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D line = (Graphics2D) g;
        line.drawLine(2, heightPanel / 2, widthPanel - 4, heightPanel / 2);
        line.drawLine(widthPanel / 2, 7, widthPanel / 2, heightPanel - 5);
        line.drawString("F", widthPanel / 2 - focusPointF, heightPanel / 2);
        line.drawString("f", widthPanel / 2 - focusPointF * 2, heightPanel / 2);

        // Object Main Body
        line.setStroke(new BasicStroke(2));
        line.setColor(Color.RED);
        line.drawLine(sourceLight(), heightPanel / 2 - objectSize, widthPanel / 2, heightPanel / 2 - objectSize);
        line.drawLine(widthPanel / 2, heightPanel / 2 + (int) imageSize(),
                ddaX(widthPanel / 2, heightPanel / 2 + (int) imageSize(), widthPanel / 2 - objectDistance, heightPanel / 2 - objectSize, true),
                ddaY(widthPanel / 2, heightPanel / 2 + (int) imageSize(), widthPanel / 2 - objectDistance, heightPanel / 2 - objectSize, true));

        line.setColor(Color.BLUE);
        line.drawLine(sourceLightImage(), heightPanel / 2 + (int) imageSize(), widthPanel / 2, heightPanel / 2 + (int) imageSize());
        line.drawLine(widthPanel / 2, heightPanel / 2 - objectSize,
                ddaX(widthPanel / 2 - (int) imageDistance(), heightPanel / 2 + (int) imageSize(), widthPanel / 2, heightPanel / 2 - objectSize, false),
                ddaY(widthPanel / 2 - (int) imageDistance(), heightPanel / 2 + (int) imageSize(), widthPanel / 2, heightPanel / 2 - objectSize, false));

        line.setColor(Color.CYAN);
        line.drawLine(widthPanel / 2 - objectDistance, heightPanel / 2 - objectSize, widthPanel / 2 - objectDistance, heightPanel / 2);
        // Object Pencil Frame
        // Pencil Frame
        line.drawLine(widthPanel / 2 - objectDistance - objectSize / 4, heightPanel / 2 - objectSize / 4,
                widthPanel / 2 - objectDistance - objectSize / 4, heightPanel / 2 + objectSize / 24 - objectSize);
        line.drawLine(widthPanel / 2 - objectDistance + objectSize / 4, heightPanel / 2 - objectSize / 4,
                widthPanel / 2 - objectDistance + objectSize / 4, heightPanel / 2 + objectSize / 24 - objectSize);
        line.drawLine(widthPanel / 2 - objectDistance - objectSize / 12, heightPanel / 2 - objectSize / 3,
                widthPanel / 2 - objectDistance - objectSize / 12, heightPanel / 2 - objectSize);
        line.drawLine(widthPanel / 2 - objectDistance + objectSize / 12, heightPanel / 2 - objectSize / 3,
                widthPanel / 2 - objectDistance + objectSize / 12, heightPanel / 2 - objectSize);
        // Pencil Frame Connector
        line.drawLine(widthPanel / 2 - objectDistance, heightPanel / 2,
                widthPanel / 2 - objectDistance - objectSize / 4, heightPanel / 2 - objectSize / 4);
        line.drawLine(widthPanel / 2 - objectDistance, heightPanel / 2,
                widthPanel / 2 - objectDistance + objectSize / 4, heightPanel / 2 - objectSize / 4);
        line.drawLine(widthPanel / 2 - objectDistance - objectSize / 12, heightPanel / 2 - objectSize / 3,
                widthPanel / 2 - objectDistance - objectSize / 4, heightPanel / 2 - objectSize / 4);
        line.drawLine(widthPanel / 2 - objectDistance + objectSize / 12, heightPanel / 2 - objectSize / 3,
                widthPanel / 2 - objectDistance + objectSize / 4, heightPanel / 2 - objectSize / 4);
        line.drawLine(widthPanel / 2 - objectDistance - objectSize / 12, heightPanel / 2 - objectSize,
                widthPanel / 2 - objectDistance - objectSize / 4, heightPanel / 2 + objectSize / 24 - objectSize);
        line.drawLine(widthPanel / 2 - objectDistance + objectSize / 12, heightPanel / 2 - objectSize,
                widthPanel / 2 - objectDistance + objectSize / 4, heightPanel / 2 + objectSize / 24 - objectSize);
        line.drawLine(widthPanel / 2 - objectDistance - objectSize / 12, heightPanel / 2 - objectSize / 3,
                widthPanel / 2 - objectDistance + objectSize / 12, heightPanel / 2 - objectSize / 3);
        line.drawLine(widthPanel / 2 - objectDistance - objectSize / 12, heightPanel / 2 - objectSize,
                widthPanel / 2 - objectDistance + objectSize / 12, heightPanel / 2 - objectSize);

        // Image
        line.setColor(Color.GREEN);
        line.drawLine(widthPanel / 2 - (int) imageDistance(), heightPanel / 2 + (int) imageSize(), widthPanel / 2 - (int) imageDistance(), heightPanel / 2);
        // Image Pencil Frame
        // Pencil Frame
        line.drawLine(widthPanel / 2 - (int) imageDistance() - (int) imageSize() / 4, heightPanel / 2 + (int) imageSize() / 4,
                widthPanel / 2 - (int) imageDistance() - (int) imageSize() / 4, heightPanel / 2 - (int) imageSize() / 24 + (int) imageSize());
        line.drawLine(widthPanel / 2 - (int) imageDistance() + (int) imageSize() / 4, heightPanel / 2 + (int) imageSize() / 4,
                widthPanel / 2 - (int) imageDistance() + (int) imageSize() / 4, heightPanel / 2 - (int) imageSize() / 24 + (int) imageSize());
        line.drawLine(widthPanel / 2 - (int) imageDistance() - (int) imageSize() / 12, heightPanel / 2 + (int) imageSize() / 3,
                widthPanel / 2 - (int) imageDistance() - (int) imageSize() / 12, heightPanel / 2 + (int) imageSize());
        line.drawLine(widthPanel / 2 - (int) imageDistance() + (int) imageSize() / 12, heightPanel / 2 + (int) imageSize() / 3,
                widthPanel / 2 - (int) imageDistance() + (int) imageSize() / 12, heightPanel / 2 + (int) imageSize());
        // Pencil Frame Connector
        line.drawLine(widthPanel / 2 - (int) imageDistance(), heightPanel / 2,
                widthPanel / 2 - (int) imageDistance() - (int) imageSize() / 4, heightPanel / 2 + (int) imageSize() / 4);
        line.drawLine(widthPanel / 2 - (int) imageDistance(), heightPanel / 2,
                widthPanel / 2 - (int) imageDistance() + (int) imageSize() / 4, heightPanel / 2 + (int) imageSize() / 4);
        line.drawLine(widthPanel / 2 - (int) imageDistance() - (int) imageSize() / 12, heightPanel / 2 + (int) imageSize() / 3,
                widthPanel / 2 - (int) imageDistance() - (int) imageSize() / 4, heightPanel / 2 + (int) imageSize() / 4);
        line.drawLine(widthPanel / 2 - (int) imageDistance() + (int) imageSize() / 12, heightPanel / 2 + (int) imageSize() / 3,
                widthPanel / 2 - (int) imageDistance() + (int) imageSize() / 4, heightPanel / 2 + (int) imageSize() / 4);
        line.drawLine(widthPanel / 2 - (int) imageDistance() - (int) imageSize() / 12, heightPanel / 2 + (int) imageSize(),
                widthPanel / 2 - (int) imageDistance() - (int) imageSize() / 4, heightPanel / 2 - (int) imageSize() / 24 + (int) imageSize());
        line.drawLine(widthPanel / 2 - (int) imageDistance() + (int) imageSize() / 12, heightPanel / 2 + (int) imageSize(),
                widthPanel / 2 - (int) imageDistance() + (int) imageSize() / 4, heightPanel / 2 - (int) imageSize() / 24 + (int) imageSize());
        line.drawLine(widthPanel / 2 - (int) imageDistance() - (int) imageSize() / 12, heightPanel / 2 + (int) imageSize() / 3,
                widthPanel / 2 - (int) imageDistance() + (int) imageSize() / 12, heightPanel / 2 + (int) imageSize() / 3);
        line.drawLine(widthPanel / 2 - (int) imageDistance() - (int) imageSize() / 12, heightPanel / 2 + (int) imageSize(),
                widthPanel / 2 - (int) imageDistance() + (int) imageSize() / 12, heightPanel / 2 + (int) imageSize());

    }

    public float imageDistance() {
        // Jarak
        float s = ((float) objectDistance * focusPointF) / ((float) objectDistance - focusPointF);
        DetailPanel.imageSizeF.setText(String.valueOf((int) s));
        return s;
    }

    public float imageSize() {
        // Tinggi
        float i = (imageDistance() * objectSize / objectDistance);
        DetailPanel.imageDistanceF.setText(String.valueOf((int) i));
        return i;
    }

    public int sourceLight() {
        if (objectDistance > -1) {
            return 0;
        } else {
            return widthPanel;
        }
    }

    public int sourceLightImage() {
        if (imageDistance() > -1) {
            return 0;
        } else {
            return widthPanel;
        }
    }

    public int ddaX(float x1, float y1, float x2, float y2, boolean symbol) {
        float x;
        float steps;
        float dx = x2 - x1;
        float dy = y2 - y1;
        steps = Math.max(Math.abs(dx), Math.abs(dy));
        float Xinc = dx / steps;
        x = x1;
        for (int i = 0; i < 1600; i++) {
            if (symbol) {
                x += Xinc;
            }
            if (!symbol){
                x -= Xinc;
            }
        }
        return (int) x;
    }

    public int ddaY(float x1, float y1, float x2, float y2, boolean symbol) {
        float y;
        float steps;
        float dx = x2 - x1;
        float dy = y2 - y1;
        steps = Math.max(Math.abs(dx), Math.abs(dy));
        float Yinc = dy / steps;
        y = y1;
        for (int i = 0; i < 1600; i++) {
            if (symbol) {
                y += Yinc;
            }
            if (!symbol){
                y -= Yinc;
            }
        }
        return (int) y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = widthPanel / 2 - e.getX();
        int y = heightPanel / 2 - e.getY();
        if (e.isShiftDown()) {
            focusPointF = x;
            DetailPanel.lensFocusPointS.setValue(x);
            repaint();
        } else {
            objectDistance = x;
            objectSize = y;
            LeftPanel.objectSizeSlider.setValue(y);
            DetailPanel.objectSizeS.setValue(y);
            DetailPanel.objectDistanceS.setValue(x);
            SlidePanelBottom.objectDistance.setValue(x);
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}