package com.dt181g.laboration_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Producer extends JPanel {

    private int count = 6;
    private JLabel label;

    public Producer() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, 400));
        label = new JLabel("Producers: " + count);
        label.setFont(new Font("Monaco", Font.BOLD, 24));

        JButton button = new JButton("Add Producer");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count++;
                update(count);
            }
        });

        add(label);
        add(button);
    }

    public int getProducerCount() {
        return count;
    }

    public void updateProducer(int count) {
        label.setText("Producers: " + count);
    }
}
