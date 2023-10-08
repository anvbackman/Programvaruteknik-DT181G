package com.dt181g.laboration_3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImageLoader {

    public List<BufferedImage> loadImage(String path, int numberOfPairs) {
        List<BufferedImage> imagePairs = new ArrayList<>();
        File folder = new File(path);
        File[] files = folder.listFiles();

        if (files != null && files.length >= numberOfPairs) {
            List<File> fileList = Arrays.asList(files);
            Collections.shuffle(fileList);

            for (int i = 0; i < numberOfPairs; i++) {
                try {
                    BufferedImage image = ImageIO.read(fileList.get(i));
                    imagePairs.add(image);
                    imagePairs.add(image);
                    System.out.println("Loaded Image: " + fileList.get(i).getName());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
//            JOptionPane.showMessageDialog(this, "Not enough images");
            System.out.println("Not enough images");
        }

        return imagePairs;
    }
}
