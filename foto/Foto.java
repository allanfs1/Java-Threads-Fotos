/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foto;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
//para testar a classe procure uma imagem de no mínimo 30MB
// construa uma aplicação com threads para processar partes independentes da imagem
public class Foto implements Runnable{
    
    private int ix;
    private int iy;
    private int my;
    private int mx;
    private  BufferedImage image;
    
    Foto(int ix,int iy,int mx,int my){
        
     this.ix = ix;
     this.iy = iy;
     this.mx = mx;
     this.my = my;
        
    }
    
    
    @Override
    public void run() {
        
      this.red();
    }
    
    
    public void red(){
        
        System.out.println("start");
        BufferedImage image = null;
        
       
        
        try {
            File imagefile = new File("C:\\Users\\Allan\\Pictures\\Foto\\foto.jpg");
            image = ImageIO.read(imagefile);
 

            //ImageIO Image write Example in Java
             for (int x = 0; x < this.mx; x++) {
                for (int y = 0; y < this.my; y++) {
                    Color c = new Color(image.getRGB(x, y));

                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();
                    int media = (r + g + b) / 3;
                    Color nc = new Color(media, media, media);
                    image.setRGB(x, y, nc.getRGB());
                }
            }
            
            ImageIO.write(image, "jpg", new File("C:\\Users\\Allan\\Pictures\\Foto\\foto02.jpg"));
            //ImageIO.write(image, "bmp", new File("C:\\temp\\1.bmp"));
            //ImageIO.write(image, "png", new File("C:\\temp\\1.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
       
        System.out.println("Success");

    }
        
    
    
    
   
    public static void main(String[] args) {

       //Foto ft = new Foto(0,0,4400,2924); 
       //Thread t1 = new Thread(ft);
       //t1.start();
       
       //Foto ft2 = new Foto(4400,2924,8800,5848); 
       //Thread t2 = new Thread(ft2);
       //t2.start();
       
       Foto ft1 = new Foto(0,0,8800,5848); 
       Thread t1 = new Thread(ft1);
       t1.start();
}
       

  }