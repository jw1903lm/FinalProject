/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.user;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

public class ImageAdjust {
    public void initResize(String inputLink, String outputLink, int imageWidth, int imageHeight, HttpServletRequest request) throws IOException {
        //link file gui vao
        String folderPath = getFolderPath(request);
        String inImage = folderPath + inputLink;
        String outImage = folderPath + outputLink;
        File input = new File(folderPath + inputLink);
        BufferedImage image = ImageIO.read(input);
        
        //file gui vao, width can resize , heigth can resize
        BufferedImage resized = resize(image, 80, 102);
        
        //link file gui ra sau resize
        File output = new File(folderPath + outputLink);
        ImageIO.write(resized, "png", output);
    }

    private BufferedImage resize(BufferedImage img, int width, int height) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    
    public String getNewImageName(){
        String name = "img";
        //lay 1 String ngau nhien gom 20 chu so
        for (int i = 0; i < 20; i++) {
            double randomNumber = Math.random() * 10;
            int intNumber  = (int)randomNumber;
            String addString = Integer.toString(intNumber);
            name = name + addString;
        }
        return name;
    }
    
    public static String getFolderPath(HttpServletRequest request){
        String path = request.getServletContext().getRealPath("");
        String[] rawFolderPath = path.split("\\\\");
        int count = rawFolderPath.length - 2;
        String folderPath = "";
        for (int i = 0; i < count; i++ ) {
            folderPath = folderPath + rawFolderPath[i] + "/";
        }
        return folderPath;
    }
}
