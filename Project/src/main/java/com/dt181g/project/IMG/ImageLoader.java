package com.dt181g.project.IMG;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImageLoader {

    public static BufferedImage loadIMG(String path) {
        try {
            return ImageIO.read(new File(path));
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
