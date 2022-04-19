import processing.core.PApplet;
import processing.core.PImage;

/**
 * This program animates a cloud, a circle, and a bee over an image background
 * @author T. Guo
 *
 */

public class Sketch extends PApplet {
	
  // Initialising and declaring global variables
  PImage imgBackground;
  PImage imgCloud;
  PImage imgBee;

  float fltCloudX = 200;
  float fltCloudXSpd = 2;

  float fltCircleX = 400;
  float fltCircleY = 400;
  float fltCircleXSpd = 3;
  float fltCircleYSpd = -2;

  float fltBeeX = 80;
  float fltBeeXSpd = 3;
  float fltBeeY;
  int beeFlip = -1; // Changes the orientation of the bee. Kinda acts like a Boolean
	

  public void settings() {  
    size(800, 800);
  }


  public void setup() {
    imgBackground = loadImage("BlissWindows.png");
    imgBackground.resize(800, 800);
    
    imgCloud = loadImage("cloud.png");
    imgCloud.resize(imgCloud.width / 8, imgCloud.height / 8);

    imgBee = loadImage("bee.png");
    imgBee.resize(imgBee.width / 4, imgBee.height / 4);
  }


  public void draw() {

    // Cloud animation
	  image(imgBackground,0, 0);
    image(imgCloud, fltCloudX, 100);

    fltCloudX += fltCloudXSpd;

    if (fltCloudX > width - imgCloud.width || fltCloudX < 0){
      fltCloudXSpd *= -1;
    }



    // Circle animation
    fill(255, 255, 0);
    ellipse(fltCircleX, fltCircleY, 10, 10);

    fltCircleX += fltCircleXSpd;
    fltCircleY += fltCircleYSpd;

    if (fltCircleX < 0 + 10 || fltCircleX > width - 10) {
      fltCircleXSpd *= -1;
    }
  
    if (fltCircleY < 0 + 10  || fltCircleY > height - 10) {
      fltCircleYSpd *= -1;
    }

    

    // Bee animation
    scale(beeFlip, 1);
    image(imgBee, fltBeeX * beeFlip - imgBee.width, fltBeeY);
    
    fltBeeX += fltBeeXSpd;
    fltBeeY = 300 + sin(fltBeeX / 30) * 100;

    if (fltBeeX > width - imgBee.width|| fltBeeX < 0 + imgBee.width){
      beeFlip *= -1;
      fltBeeXSpd *= -1;
    }

  }
  
}