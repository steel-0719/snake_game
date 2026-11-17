package com.daemon.main;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

import com.daemon.var.__Int;

public class TileObject extends JPanel {
    public int width, height, xLocation, yLocation;
    public Color color;

    public TileObject(int __xLocation, int __yLocation, int __width, int __height, Color __color) {
        xLocation = __xLocation;
        yLocation = __yLocation;
        width = __width;
        height = __height;
        color = __color;

        setBounds(xLocation, yLocation, width, height);
        setOpaque(false);

        System.out.println("Constructor called...");
    }

    @Override
    protected void paintComponent(Graphics drawToolkit) {
        super.paintComponent(drawToolkit);
        drawToolkit.setColor(color);
        drawToolkit.fillRect(__Int.LOCAL_X_LOCATION, __Int.LOCAL_Y_LOCATION, width, height);
    }
    
}
