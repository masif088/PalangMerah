package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//    Pegawai pegawai=new Pegawai();
        File imgFile = new File("/home/masif088/Downloads/kontol.png");
        BufferedImage img = null;
        try {
            img = ImageIO.read(imgFile);
        } catch (IOException ex) {
            System.out.println("cek");
            System.exit(0);
        }

        // GET MATRIX

        int[][] cover = new int[img.getHeight()][img.getWidth()];
        for (int y = 0; y < cover.length; y++) {
            for (int x = 0; x < cover[y].length; x++) {
                cover[y][x] = img.getRGB(x, y);
            }
        }

        // MESSAGE TO BINARY

        String msg = "1910984";
        char[] msgChar = msg.toCharArray();
        String secret = "";
        for (int i = 0; i < msgChar.length; i++) {
            int tmp01 = (int) msgChar[i];
            String tmp02 = Integer.toBinaryString(tmp01);
            secret += String.format("%1$7s", tmp02).replace(' ', '0');
        }

        // HISTOGRAM
        int[] histogram = new int[256];
        for (int y = 0; y < cover.length; y++) {
            for (int x = 0; x < cover.length; x++) {
                int tmp = (cover[y][x] >> 16) & 0xFF;
                histogram[tmp]++;
            }
        }
        System.out.print("Histogram: ");
        for (int i = 0; i < histogram.length; i++) {
            System.out.print(histogram[i] + " ");
//            if (i==115) System.out.println("cek"+histogram[i]);;
        }
        System.out.println();
        System.out.println(histogram.length);
        System.out.println();

        // PEAK & ZERO

        int peak = 0, peakvalue = histogram[0];
        int zero = 0, zerovalue = histogram[0];
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] > peakvalue) {
                peak = i;
                peakvalue = histogram[i];
            }
            if (histogram[i] < zerovalue) {
                zero = i;
                zerovalue = histogram[i];
            }
        }
        System.out.println("Peak = " + peak);
        System.out.println("Zero = " + zero);

        //peak sebelah kiri zero

        if (peak < zero) {
            for (int y = 0; y < cover.length; y++) {
                for (int x = 0; x < cover[y].length; x++) {
                    int tmp = (cover[y][x] >> 16) & 0xFF;
                    //playload
                    if (tmp == zero) {
                        secret += "0";
                    } else if (tmp == (zero - 1)) {
                        secret += "1";
                    }
                    //shifting
                    if (tmp > peak && tmp < zero) {
                        Color pixel = new Color(tmp + 1, (cover[y][x] >> 8) & 0xFF, cover[y][x] & 0xFF, (cover[y][x] >> 24) & 0xFF);
                        cover[y][x] = pixel.getRGB();
                    }
                }
            }
            int index = 0;
            for (int y = 0; y < cover.length; y++) {
                for (int x = 0; x < cover[y].length; x++) {
                    int tmp = (cover[y][x] >> 16) & 0xFF;
                    if (tmp == peak) {
                        tmp += Integer.parseInt(secret.substring(index, index + 1), index);
                        index++;
                        Color pixel = new Color(tmp, (cover[y][x] >> 8) & 0xFF, cover[y][x] & 0xFF, (cover[y][x] >> 24) & 0xFF);
                        cover[y][x] = pixel.getRGB();
                    }
                }
            }

            //peak sebelah kanan zero

        } else if (peak > zero) {
            for (int y = 0; y < cover.length; y++) {
                for (int x = 0; x < cover[y].length; x++) {
                    int tmp = (cover[y][x] >> 16) & 0xFF;
                    //playload
                    if (tmp == zero) {
                        secret += "0";
                    } else if (tmp == (zero + 1)) {
                        secret += "1";
                    }
                    //shifting
                    if (tmp < peak && tmp > zero) {
                        Color pixel = new Color(tmp - 1, (cover[y][x] >> 8) & 0xFF, cover[y][x] & 0xFF, (cover[y][x] >> 24) & 0xFF);
                        cover[y][x] = pixel.getRGB();
                    }
                }
            }
            // embed secret message
            int index = 0;
            for (int y = 0; y < cover.length; y++) {
                for (int x = 0; x < cover[y].length; x++) {
                    int tmp = (cover[y][x] >> 16) & 0xFF;
                    if ((tmp == peak) && (index < secret.length())) {
                        tmp -= Integer.parseInt(secret.substring(index, index + 1), 2);
                        index++;
                        Color pixel = new Color(tmp, (cover[y][x] >> 8) & 0xFF, cover[y][x] & 0xFF, (cover[y][x] >> 24) & 0xFF);
                        cover[y][x] = pixel.getRGB();
                    }
                }
            }

        } else {
            System.err.println("Image doesnt work");
            System.exit(0);
        }

        // tulis lagi
        histogram = new int[256];
        for (int y = 0; y < cover.length; y++) {
            for (int x = 0; x < cover.length; x++) {
                int tmp = (cover[y][x] >> 16) & 0xFF;
                histogram[tmp]++;
            }
        }
        System.out.print("Histogram: ");
        for (int i = 0; i < histogram.length; i++) {
            System.out.print(histogram[i] + " ");
        }
        System.out.println();
        img= new BufferedImage(cover[0].length,cover.length,BufferedImage.TYPE_4BYTE_ABGR);
        for (int i = 0; i <cover.length; i++) {
            for (int j = 0; j <cover[i].length ; j++) {
                img.setRGB(j,i,cover[i][j]);
            }
        }
        try {
            ImageIO.write(img,"png", new File("/home/masif088/Downloads/covera.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
