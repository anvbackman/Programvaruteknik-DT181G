package com.dt181g.laboration_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Consumer extends JPanel {
    private int count = 5;
    private JLabel label;

    public Consumer() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, 400));
        label = new JLabel("Consumers: " + count);
        label.setFont(new Font("Monaco", Font.BOLD, 24));

        JButton button = new JButton("Remove Consumer");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count++;
                label.setText("Consumers: " + count);
            }
        });

        add(label);
        add(button);
    }

    public int getConsumerCount() {
        return count;
    }
}
