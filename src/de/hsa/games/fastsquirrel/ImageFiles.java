package de.hsa.games.fastsquirrel;

import javafx.scene.image.Image;

import java.io.File;


public class ImageFiles {
    File file = new File("C:\\Users\\valen\\Desktop\\Programmieren\\GameBilder\\mariowall.png");
    javafx.scene.image.Image image = new javafx.scene.image.Image(file.toURI().toString());
    public Image getImage(){
        return image;
    }
    File file1 = new File("C:\\Users\\valen\\Desktop\\Programmieren\\GameBilder\\engel.png");
    Image image1 = new Image(file1.toURI().toString());
    public Image getImage1(){
        return image1;
    }

    File file2 = new File("C:\\Users\\valen\\Desktop\\Programmieren\\GameBilder\\teufel.png");
    Image image2 = new Image(file2.toURI().toString());
    public Image getImage2(){
        return image2;
    }
    File file3 = new File("C:\\Users\\valen\\Desktop\\Programmieren\\GameBilder\\eichel.png");
    Image image3 = new Image(file3.toURI().toString());
    public Image getImage3(){
        return image3;
    }
    File file4 = new File("C:\\Users\\valen\\Desktop\\Programmieren\\GameBilder\\kacke.png");
    Image image4 = new Image(file4.toURI().toString());
    public Image getImage4(){
        return image4;
    }
    File file5 = new File("C:\\Users\\valen\\Desktop\\Programmieren\\GameBilder\\chip.png");
    Image image5 = new Image(file5.toURI().toString());
    public Image getImage5(){
        return image5;
    }
    File file6 = new File("C:\\Users\\valen\\Desktop\\Programmieren\\GameBilder\\vieh.png");
    Image image6 = new Image(file6.toURI().toString());
    public Image getImage6(){
        return image6;
    }
}

