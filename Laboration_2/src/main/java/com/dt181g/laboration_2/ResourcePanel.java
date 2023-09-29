package com.dt181g.laboration_2;

import javax.swing.*;
import java.awt.*;

public class ResourcePanel extends JLabel {

    private ResourcePool resourcePool;

    public ResourcePanel(ResourcePool resourcePool) {
        this.resourcePool = resourcePool;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = resourcePool.getResourceAmount();
        int height = resourcePool.getResourceAmount();
        int x = (getWidth() / 2) - (width / 2);
        int y = (getHeight() / 2) - (height / 2);

        if (width < 50) {
            g.setColor(Color.RED);
        }
        else if (width < 100) {
            g.setColor(Color.YELLOW);
        }
        else if (width < 150) {
            g.setColor(Color.GREEN);
        }
        else {
            g.setColor(Color.BLUE);
        }

        g.fillOval(x, y, width, height);
    }
}
