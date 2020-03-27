/*
* @Author: adrrrrrrrian
* @Date:   2016-03-08 22:28:05
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-22 10:19:03
*/
/* PixImage.java */

/**
 *  The PixImage class represents an image, which is a rectangular grid of
 *  color pixels.  Each pixel has red, green, and blue intensities in the range
 *  0...255.  Descriptions of the methods you must implement appear below.
 *  They include a constructor of the form
 *
 *      public PixImage(int width, int height);
 *
 *  that creates a black (zero intensity) image of the specified width and
 *  height.  Pixels are numbered in the range (0...width - 1, 0...height - 1).
 *
 *  All methods in this class must be implemented to complete Part I.
 *  See the README file accompanying this project for additional details.
 */

public class PixImage {

  /**
   *  Define any variables associated with a PixImage object here.  These
   *  variables MUST be private.
   */
  private int width = 0;
  private int height = 0;

  private short[][] r;
  private short[][] b;
  private short[][] g;


  /**
   * PixImage() constructs an empty PixImage with a specified width and height.
   * Every pixel has red, green, and blue intensities of zero (solid black).
   *
   * @param width the width of the image.
   * @param height the height of the image.
   */
  public PixImage(int width, int height) {
    this.width = width;
    this.height = height;
    r = new short[width][height];
    g = new short[width][height];
    b = new short[width][height];
  }
    
  

  /**
   * getWidth() returns the width of the image.
   *
   * @return the width of the image.
   */
  public int getWidth() {
    return width;
  }

  /**
   * getHeight() returns the height of the image.
   *
   * @return the height of the image.
   */
  public int getHeight() {
    return height;
  }

  /**
   * getRed() returns the red intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the red intensity of the pixel at coordinate (x, y).
   */
  public short getRed(int x, int y) {
    return r[x][y];
  }

  /**
   * getGreen() returns the green intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the green intensity of the pixel at coordinate (x, y).
   */
  public short getGreen(int x, int y) {
    return g[x][y];
  }

  /**
   * getBlue() returns the blue intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the blue intensity of the pixel at coordinate (x, y).
   */
  public short getBlue(int x, int y) {
    return b[x][y];
  }

  /**
   * setPixel() sets the pixel at coordinate (x, y) to specified red, green,
   * and blue intensities.
   *
   * If any of the three color intensities is NOT in the range 0...255, then
   * this method does NOT change any of the pixel intensities.
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @param red the new red intensity for the pixel at coordinate (x, y).
   * @param green the new green intensity for the pixel at coordinate (x, y).
   * @param blue the new blue intensity for the pixel at coordinate (x, y).
   */
  public void setPixel(int x, int y, short red, short green, short blue) {
      if(red >= 0 && red <=255 && blue >= 0 && blue <=255 && green >= 0 && green <=255){
        b[x][y] = blue;
        g[x][y] = green;
        r[x][y] = red;
      }
      
  }

  /**
   * toString() returns a String representation of this PixImage.
   *
   * This method isn't required, but it should be very useful to you when
   * you're debugging your code.  It's up to you how you represent a PixImage
   * as a String.
   *
   * @return a String representation of this PixImage.
   */
  public String toString() {
    StringBuffer s = new StringBuffer();
    for(int i = 0; i < height; i++){
      for(int j = 0; j < width; j++){
        s.append(this.getRed(j,i));
        s.append(",");
      }
      s.append("|");
      for(int j = 0; j < width; j++){
        s.append(this.getBlue(j,i));
        s.append(",");
      }
      s.append("|");
      for(int j = 0; j < width; j++){
        s.append(this.getGreen(j,i));
        s.append(",");
      }
      s.append("\n");
    }


    return s.toString();
  }

  /**
   * boxBlur() returns a blurred version of "this" PixImage.
   *
   * If numIterations == 1, each pixel in the output PixImage is assigned
   * a value equal to the average of its neighboring pixels in "this" PixImage,
   * INCLUDING the pixel itself.
   *
   * A pixel not on the image boundary has nine neighbors--the pixel itself and
   * the eight pixels surrounding it.  A pixel on the boundary has six
   * neighbors if it is not a corner pixel; only four neighbors if it is
   * a corner pixel.  The average of the neighbors is the sum of all the
   * neighbor pixel values (including the pixel itself) divided by the number
   * of neighbors, with non-integer quotients rounded toward zero (as Java does
   * naturally when you divide two integers).
   *
   * Each color (red, green, blue) is blurred separately.  The red input should
   * have NO effect on the green or blue outputs, etc.
   *
   * The parameter numIterations specifies a number of repeated iterations of
   * box blurring to perform.  If numIterations is zero or negative, "this"
   * PixImage is returned (not a copy).  If numIterations is positive, the
   * return value is a newly constructed PixImage.
   *
   * IMPORTANT:  DO NOT CHANGE "this" PixImage!!!  All blurring/changes should
   * appear in the new, output PixImage only.
   *
   * @param numIterations the number of iterations of box blurring.
   * @return a blurred version of "this" PixImage.
   */
  public PixImage boxBlur(int numIterations) {
	  PixImage pix = new PixImage(width,height);
	  int aa = 0;int bb = 0;
	  while(aa < width){  
          while(bb < height){
        	  pix.setPixel(aa, bb, this.getRed(aa, bb), this.getGreen(aa, bb), this.getBlue(aa, bb));
        	  bb++;
          }
          bb=0;
          aa++;
	  }
	  if(numIterations <= 0){
      return this;
	  }else{
      int x = 0;
      int y = 0;
      int ite = numIterations;
      while(ite>0){
    	  PixImage pi = new PixImage(width,height);
        while(x < width){  
          while(y < height){
            int sum_green = 0;
            int sum_blue = 0;
            int sum_red = 0;
            if(x == 0|| x == (width-1)||y == 0 ||y == height-1){
              if(x == 0){
                if(y == 0){
                  sum_red = pix.getRed(x,y)+pix.getRed(x,y+1)+pix.getRed(x+1,y)+pix.getRed(x+1,y+1);
                  sum_blue = pix.getBlue(x,y)+pix.getBlue(x,y+1)+pix.getBlue(x+1,y)+pix.getBlue(x+1,y+1);
                  sum_green = pix.getGreen(x,y)+pix.getGreen(x,y+1)+pix.getGreen(x+1,y)+pix.getGreen(x+1,y+1);
                  pi.setPixel(x,y,(short)(sum_red/4),(short)(sum_green/4),(short)(sum_blue/4));
                }else if(y == height-1){
                  sum_red = pix.getRed(x,y)+pix.getRed(x,y-1)+pix.getRed(x+1,y)+pix.getRed(x+1,y-1);
                  sum_blue = pix.getBlue(x,y)+pix.getBlue(x,y-1)+pix.getBlue(x+1,y)+pix.getBlue(x+1,y-1);
                  sum_green = pix.getGreen(x,y)+pix.getGreen(x,y-1)+pix.getGreen(x+1,y)+pix.getGreen(x+1,y-1);
                  pi.setPixel(x,y,(short)(sum_red/4),(short)(sum_green/4),(short)(sum_blue/4));
                }else{
                  sum_red = pix.getRed(x,y)+pix.getRed(x,y-1)+pix.getRed(x+1,y)+pix.getRed(x+1,y-1)+pix.getRed(x+1,y+1)+pix.getRed(x,y+1);
                  sum_blue = pix.getBlue(x,y)+pix.getBlue(x,y-1)+pix.getBlue(x+1,y)+pix.getBlue(x+1,y-1)+pix.getBlue(x+1,y+1)+pix.getBlue(x,y+1);
                  sum_green = pix.getGreen(x,y)+pix.getGreen(x,y-1)+pix.getGreen(x+1,y)+pix.getGreen(x+1,y-1)+pix.getGreen(x+1,y+1)+pix.getGreen(x,y+1);
                  pi.setPixel(x,y,(short)(sum_red/6),(short)(sum_green/6),(short)(sum_blue/6));
                }
              }
              if(x == width-1){// x == width
                if(y == 0){
                  sum_red = pix.getRed(x,y)+pix.getRed(x,y+1)+pix.getRed(x-1,y)+pix.getRed(x-1,y+1);
                  sum_blue = pix.getBlue(x,y)+pix.getBlue(x,y+1)+pix.getBlue(x-1,y)+pix.getBlue(x-1,y+1);
                  sum_green = pix.getGreen(x,y)+pix.getGreen(x,y+1)+pix.getGreen(x-1,y)+pix.getGreen(x-1,y+1);
                  pi.setPixel(x,y,(short)(sum_red/4),(short)(sum_green/4),(short)(sum_blue/4));
                }else if(y == height-1){
                  sum_red = pix.getRed(x,y)+pix.getRed(x,y-1)+pix.getRed(x-1,y)+pix.getRed(x-1,y-1);
                  sum_blue = pix.getBlue(x,y)+pix.getBlue(x,y-1)+pix.getBlue(x-1,y)+pix.getBlue(x-1,y-1);
                  sum_green = pix.getGreen(x,y)+pix.getGreen(x,y-1)+pix.getGreen(x-1,y)+pix.getGreen(x-1,y-1);
                  pi.setPixel(x,y,(short)(sum_red/4),(short)(sum_green/4),(short)(sum_blue/4));
                }else{
                  sum_red = pix.getRed(x,y)+pix.getRed(x,y-1)+pix.getRed(x-1,y)+pix.getRed(x-1,y-1)+pix.getRed(x-1,y+1)+pix.getRed(x,y+1);
                  sum_blue = pix.getBlue(x,y)+pix.getBlue(x,y-1)+pix.getBlue(x-1,y)+pix.getBlue(x-1,y-1)+pix.getBlue(x-1,y+1)+pix.getBlue(x,y+1);
                  sum_green = pix.getGreen(x,y)+pix.getGreen(x,y-1)+pix.getGreen(x-1,y)+pix.getGreen(x-1,y-1)+pix.getGreen(x-1,y+1)+pix.getGreen(x,y+1);
                  pi.setPixel(x,y,(short)(sum_red/6),(short)(sum_green/6),(short)(sum_blue/6));
                }
              }
              if(y == 0&&x!=0&&x!=(width-1)){
                sum_red = pix.getRed(x,y)+pix.getRed(x,y+1)+pix.getRed(x-1,y)+pix.getRed(x-1,y+1)+pix.getRed(x+1,y)+pix.getRed(x+1,y+1);
                sum_blue = pix.getBlue(x,y)+pix.getBlue(x,y+1)+pix.getBlue(x-1,y)+pix.getBlue(x-1,y+1)+pix.getBlue(x+1,y)+pix.getBlue(x+1,y+1);
                sum_green = pix.getGreen(x,y)+pix.getGreen(x,y+1)+pix.getGreen(x-1,y)+pix.getGreen(x-1,y+1)+pix.getGreen(x+1,y)+pix.getGreen(x+1,y+1);
                pi.setPixel(x,y,(short)(sum_red/6),(short)(sum_green/6),(short)(sum_blue/6));
              }
              if(y == (height-1)&&x!=0&&x!=width-1){
                sum_red = pix.getRed(x,y)+pix.getRed(x,y-1)+pix.getRed(x-1,y)+pix.getRed(x-1,y-1)+pix.getRed(x+1,y)+pix.getRed(x+1,y-1);
                sum_blue = pix.getBlue(x,y)+pix.getBlue(x,y-1)+pix.getBlue(x-1,y)+pix.getBlue(x-1,y-1)+pix.getBlue(x+1,y)+pix.getBlue(x+1,y-1);
                sum_green = pix.getGreen(x,y)+pix.getGreen(x,y-1)+pix.getGreen(x-1,y)+pix.getGreen(x-1,y-1)+pix.getGreen(x+1,y)+pix.getGreen(x+1,y-1);
                pi.setPixel(x,y,(short)(sum_red/6),(short)(sum_green/6),(short)(sum_blue/6));
              }
            }else{
              sum_red = pix.getRed(x-1,y-1)+pix.getRed(x-1,y)+pix.getRed(x-1,y+1)+pix.getRed(x,y-1)+pix.getRed(x,y)+pix.getRed(x,y+1)+pix.getRed(x+1,y-1)+pix.getRed(x+1,y)+pix.getRed(x+1,y+1);
              sum_blue = pix.getBlue(x-1,y-1)+pix.getBlue(x-1,y)+pix.getBlue(x-1,y+1)+pix.getBlue(x,y-1)+pix.getBlue(x,y)+pix.getBlue(x,y+1)+pix.getBlue(x+1,y-1)+pix.getBlue(x+1,y)+pix.getBlue(x+1,y+1);
              sum_green = pix.getGreen(x-1,y-1)+pix.getGreen(x-1,y)+pix.getGreen(x-1,y+1)+pix.getGreen(x,y-1)+pix.getGreen(x,y)+pix.getGreen(x,y+1)+pix.getGreen(x+1,y-1)+pix.getGreen(x+1,y)+pix.getGreen(x+1,y+1);
              pi.setPixel(x,y,(short)(sum_red/9),(short)(sum_green/9),(short)(sum_blue/9));
            }
            y++;
          }
          y=0;
          x++;
        }
        x=0;
        y=0;
        pix = pi;
        ite--;
      }
      return pix;
    }
    
  }

  /**
   * mag2gray() maps an energy (squared vector magnitude) in the range
   * 0...24,969,600 to a grayscale intensity in the range 0...255.  The map
   * is logarithmic, but shifted so that values of 5,080 and below map to zero.
   *
   * DO NOT CHANGE THIS METHOD.  If you do, you will not be able to get the
   * correct images and pass the autograder.
   *
   * @param mag the energy (squared vector magnitude) of the pixel whose
   * intensity we want to compute.
   * @return the intensity of the output pixel.
   */
  private static short mag2gray(long mag) {
    short intensity = (short) (30.0 * Math.log(1.0 + (double) mag) - 256.0);

    // Make sure the returned intensity is in the range 0...255, regardless of
    // the input value.
    if (intensity < 0) {
      intensity = 0;
    } else if (intensity > 255) {
      intensity = 255;
    }
    return intensity;
  }

  /**
   * sobelEdges() applies the Sobel operator, identifying edges in "this"
   * image.  The Sobel operator computes a magnitude that represents how
   * strong the edge is.  We compute separate gradients for the red, blue, and
   * green components at each pixel, then sum the squares of the three
   * gradients at each pixel.  We convert the squared magnitude at each pixel
   * into a grayscale pixel intensity in the range 0...255 with the logarithmic
   * mapping encoded in mag2gray().  The output is a grayscale PixImage whose
   * pixel intensities reflect the strength of the edges.
   *
   * See http://en.wikipedia.org/wiki/Sobel_operator#Formulation for details.
   *
   * @return a grayscale PixImage representing the edges of the input image.
   * Whiter pixels represent stronger edges.
   */
  public PixImage sobelEdges() {
    PixImage pix = this.reflection();
    PixImage answ = new PixImage(width, height);
      int x = 1;
      int y = 1;
      
        while(x < width+1){  
          while(y < height+1){
            long gx_green = 0;
            long gy_green = 0;
            long gx_blue = 0;
            long gy_blue = 0;
            long gx_red = 0;
            long gy_red = 0;
            /*if(x == 0|| x == (width-1)||y == 0 ||y == height-1){
              if(x == 0){
                if(y == 0){
                  gx_red = (-2)*this.getRed(x+1,y)-this.getRed(x+1,y+1);
                  gy_red = (-2)*this.getRed(x,y+1)-this.getRed(x+1,y+1);
                  gx_blue = (-2)*this.getBlue(x+1,y)-this.getBlue(x+1,y+1);
                  gy_blue = (-2)*this.getBlue(x,y+1)-this.getBlue(x+1,y+1);
                  gx_green = (-2)*this.getGreen(x+1,y)-this.getGreen(x+1,y+1);
                  gy_green = (-2)*this.getGreen(x,y+1)-this.getGreen(x+1,y+1);
                }else if(y == height-1){
                  gx_red = (-2)*this.getRed(x+1,y)-this.getRed(x+1,y-1);
                  gy_red = (2)*this.getRed(x,y-1)+this.getRed(x+1,y-1);
                  gx_blue = (-2)*this.getBlue(x+1,y)-this.getBlue(x+1,y-1);
                  gy_blue = (2)*this.getBlue(x,y-1)+this.getBlue(x+1,y-1);
                  gx_green = (-2)*this.getGreen(x+1,y)-this.getGreen(x+1,y-1);
                  gy_green = (2)*this.getGreen(x,y-1)+this.getGreen(x+1,y-1);
                }else{
                  gx_red = (-2)*this.getRed(x+1,y)-this.getRed(x+1,y-1)-this.getRed(x+1,y+1);
                  gy_red = (-1)*this.getRed(x+1,y+1)+this.getRed(x+1,y-1);
                  gx_blue = (-2)*this.getBlue(x+1,y)-this.getBlue(x+1,y-1)-this.getRed(x+1,y+1);
                  gy_blue = (-1)*this.getBlue(x+1,y+1)+this.getBlue(x+1,y-1);
                  gx_green = (-2)*this.getGreen(x+1,y)-this.getGreen(x+1,y-1)-this.getRed(x+1,y+1);
                  gy_green = (-1)*this.getGreen(x+1,y+1)+this.getGreen(x+1,y-1);
                }
              }
              if(x == width-1){// x == width
                if(y == 0){
                  gx_red = (2)*this.getRed(x-1,y)+this.getRed(x-1,y+1);
                  gy_red = (-2)*this.getRed(x,y+1)-this.getRed(x-1,y+1);
                  gx_blue = (2)*this.getBlue(x-1,y)+this.getBlue(x-1,y+1);
                  gy_blue = (-2)*this.getBlue(x,y+1)-this.getBlue(x-1,y+1);
                  gx_green = (2)*this.getGreen(x-1,y)+this.getGreen(x-1,y+1);
                  gy_green = (-2)*this.getGreen(x,y+1)-this.getGreen(x-1,y+1);
                }else if(y == height-1){
                  gx_red = (2)*this.getRed(x-1,y)+this.getRed(x-1,y-1);
                  gy_red = (2)*this.getRed(x,y-1)+this.getRed(x-1,y-1);
                  gx_blue = (2)*this.getBlue(x-1,y)+this.getBlue(x-1,y-1);
                  gy_blue = (2)*this.getBlue(x,y-1)+this.getBlue(x-1,y-1);
                  gx_green = (2)*this.getGreen(x-1,y)+this.getGreen(x-1,y-1);
                  gy_green = (2)*this.getGreen(x,y-1)+this.getGreen(x-1,y-1);
                }else{
                  gx_red = (-2)*this.getRed(x-1,y)-this.getRed(x-1,y-1)-this.getRed(x-1,y+1);
                  gy_red = (-1)*this.getRed(x-1,y+1)+this.getRed(x-1,y-1);
                  gx_blue = (-2)*this.getBlue(x-1,y)-this.getBlue(x-1,y-1)-this.getRed(x-1,y+1);
                  gy_blue = (-1)*this.getBlue(x-1,y+1)+this.getBlue(x-1,y-1);
                  gx_green = (-2)*this.getGreen(x-1,y)-this.getGreen(x-1,y-1)-this.getRed(x-1,y+1);
                  gy_green = (-1)*this.getGreen(x-1,y+1)+this.getGreen(x-1,y-1);
                }
              }
              if(y == 0&&x!=0&&x!=(width-1)){
                  gx_red = (-2)*this.getRed(x+1,y)-this.getRed(x+1,y+1)+(2)*this.getRed(x-1,y)+this.getRed(x-1,y+1);
                  gy_red = (-2)*this.getRed(x,y+1)-this.getRed(x+1,y+1)-this.getGreen(x-1,y+1);
                  gx_blue = (-2)*this.getBlue(x+1,y)-this.getBlue(x+1,y+1)+(2)*this.getRed(x-1,y)+this.getRed(x-1,y+1);
                  gy_blue = (-2)*this.getBlue(x,y+1)-this.getBlue(x+1,y+1)-this.getGreen(x-1,y+1);
                  gx_green = (-2)*this.getGreen(x+1,y)-this.getGreen(x+1,y+1)+(2)*this.getRed(x-1,y)+this.getRed(x-1,y+1);
                  gy_green = (-2)*this.getGreen(x,y+1)-this.getGreen(x+1,y+1)-this.getGreen(x-1,y+1);
              }
              if(y == (height-1)&&x!=0&&x!=(width-1)){
                  gx_red = (-2)*this.getRed(x+1,y)-this.getRed(x+1,y-1)+(2)*this.getRed(x-1,y)+this.getRed(x-1,y-1);
                  gy_red = (2)*this.getRed(x,y-1)+this.getRed(x+1,y-1)+this.getGreen(x-1,y-1);
                  gx_blue = (-2)*this.getBlue(x+1,y)-this.getBlue(x+1,y-1)+(2)*this.getRed(x-1,y)+this.getRed(x-1,y-1);
                  gy_blue = (2)*this.getBlue(x,y-1)+this.getBlue(x+1,y-1)+this.getGreen(x-1,y-1);
                  gx_green = (-2)*this.getGreen(x+1,y)-this.getGreen(x+1,y-1)+(2)*this.getRed(x-1,y)+this.getRed(x-1,y-1);
                  gy_green = (2)*this.getGreen(x,y-1)+this.getGreen(x+1,y-1)+this.getGreen(x-1,y-1);
              }
            }else{
              gx_red = this.getRed(x-1,y-1)+2*this.getRed(x-1,y)+this.getRed(x-1,y+1)-this.getRed(x+1,y-1)-2*this.getRed(x+1,y)-this.getRed(x+1,y+1);
              gy_red= this.getRed(x-1,y-1)-this.getRed(x-1,y+1)+2*this.getRed(x,y-1)-2*this.getRed(x,y+1)+this.getRed(x+1,y-1)-this.getRed(x+1,y+1);
              gx_blue = this.getBlue(x-1,y-1)+2*this.getBlue(x-1,y)+this.getBlue(x-1,y+1)-this.getBlue(x+1,y-1)-2*this.getBlue(x+1,y)-this.getBlue(x+1,y+1);
              gy_blue = this.getBlue(x-1,y-1)-this.getBlue(x-1,y+1)+2*this.getBlue(x,y-1)-2*this.getBlue(x,y+1)+this.getBlue(x+1,y-1)-this.getBlue(x+1,y+1);
              gx_green = this.getGreen(x-1,y-1)+2*this.getGreen(x-1,y)+this.getGreen(x-1,y+1)-this.getGreen(x+1,y-1)-2*this.getGreen(x+1,y)-this.getGreen(x+1,y+1);
              gy_green = this.getGreen(x-1,y-1)-this.getGreen(x-1,y+1)+2*this.getGreen(x,y-1)-2*this.getGreen(x,y+1)+this.getGreen(x+1,y-1)-this.getGreen(x+1,y+1);
            }*/
            
            gx_red = pix.getRed(x-1,y-1)+2*pix.getRed(x-1,y)+pix.getRed(x-1,y+1)-pix.getRed(x+1,y-1)-2*pix.getRed(x+1,y)-pix.getRed(x+1,y+1);
            gy_red= pix.getRed(x-1,y-1)-pix.getRed(x-1,y+1)+2*pix.getRed(x,y-1)-2*pix.getRed(x,y+1)+pix.getRed(x+1,y-1)-pix.getRed(x+1,y+1);
            gx_blue = pix.getBlue(x-1,y-1)+2*pix.getBlue(x-1,y)+pix.getBlue(x-1,y+1)-pix.getBlue(x+1,y-1)-2*pix.getBlue(x+1,y)-pix.getBlue(x+1,y+1);
            gy_blue = pix.getBlue(x-1,y-1)-pix.getBlue(x-1,y+1)+2*pix.getBlue(x,y-1)-2*pix.getBlue(x,y+1)+pix.getBlue(x+1,y-1)-pix.getBlue(x+1,y+1);
            gx_green = pix.getGreen(x-1,y-1)+2*pix.getGreen(x-1,y)+pix.getGreen(x-1,y+1)-pix.getGreen(x+1,y-1)-2*pix.getGreen(x+1,y)-pix.getGreen(x+1,y+1);
            gy_green = pix.getGreen(x-1,y-1)-pix.getGreen(x-1,y+1)+2*pix.getGreen(x,y-1)-2*pix.getGreen(x,y+1)+pix.getGreen(x+1,y-1)-pix.getGreen(x+1,y+1);
            long ene = gx_green*gx_green+gx_blue*gx_blue+gx_red*gx_red+gy_green*gy_green+gy_blue*gy_blue+gy_red*gy_red;
            short ans = mag2gray(ene);
            answ.setPixel(x-1,y-1,ans,ans,ans);
            y++;
          }
          y=1;
          x++;
        }
        
    // Replace the following line with your solution.
    return answ;
    // Don't forget to use the method mag2gray() above to convert energies to
    // pixel intensities.
  }
  private PixImage reflection() {
	    PixImage pix = new PixImage(this.getWidth()+2, this.getHeight()+2);
	    int leftside = 0;
	    int rightside = this.getWidth()-1;
	    int upside = 0;
	    int downside = this.getHeight()-1;
	    
	    for (int y=0; y<this.getHeight(); y++) {
	      pix.r[leftside][y+1] = this.r[leftside][y];
	      pix.g[leftside][y+1] = this.g[leftside][y];
	      pix.b[leftside][y+1] = this.b[leftside][y];
	    }
	    for (int y=0; y<this.getHeight(); y++) {
	      pix.r[rightside+2][y+1] = this.r[rightside][y];
	      pix.g[rightside+2][y+1] = this.g[rightside][y];
	      pix.b[rightside+2][y+1] = this.b[rightside][y];
	    }
	    for (int x=0; x<this.getWidth(); x++) {
	      pix.r[x+1][upside] = this.r[x][upside];
	      pix.g[x+1][upside] = this.g[x][upside];
	      pix.b[x+1][upside] = this.b[x][upside];
	    }
	    for (int x=0; x<this.getWidth(); x++) {
	      pix.r[x+1][downside+2] = this.r[x][downside];
	      pix.g[x+1][downside+2] = this.g[x][downside];
	      pix.b[x+1][downside+2] = this.b[x][downside];
	    }
	    pix.r[0][0] = pix.r[0][1];pix.b[0][0] = pix.b[0][1];pix.g[0][0] = pix.g[0][1];
	    pix.r[0][pix.getHeight()-1] = pix.r[0][pix.getHeight()-2];
	    pix.b[0][pix.getHeight()-1] = pix.b[0][pix.getHeight()-2];
	    pix.g[0][pix.getHeight()-1] = pix.g[0][pix.getHeight()-2];
	    pix.r[pix.getWidth()-1][0] = pix.r[pix.getWidth()-2][0];
	    pix.b[pix.getWidth()-1][0] = pix.b[pix.getWidth()-2][0];
	    pix.g[pix.getWidth()-1][0] = pix.g[pix.getWidth()-2][0];
	    pix.r[pix.getWidth()-1][pix.getHeight()-1] = pix.r[pix.getWidth()-2][pix.getHeight()-1];
	    pix.b[pix.getWidth()-1][pix.getHeight()-1] = pix.b[pix.getWidth()-2][pix.getHeight()-1];
	    pix.g[pix.getWidth()-1][pix.getHeight()-1] = pix.g[pix.getWidth()-2][pix.getHeight()-1];

	    for(int y=1; y<pix.getHeight()-1; y++) {
	      for(int x=1; x<pix.getWidth()-1; x++) {
	        pix.r[x][y] = this.r[x-1][y-1];
	        pix.b[x][y] = this.b[x-1][y-1];
	        pix.g[x][y] = this.g[x-1][y-1];
	      }
	    }
	    return pix;
	  }


  /**
   * TEST CODE:  YOU DO NOT NEED TO FILL IN ANY METHODS BELOW THIS POINT.
   * You are welcome to add tests, though.  Methods below this point will not
   * be tested.  This is not the autograder, which will be provided separately.
   */


  /**
   * doTest() checks whether the condition is true and prints the given error
   * message if it is not.
   *
   * @param b the condition to check.
   * @param msg the error message to print if the condition is false.
   */
  private static void doTest(boolean b, String msg) {
    if (b) {
      System.out.println("Good.");
    } else {
      System.err.println(msg);
    }
  }

  /**
   * array2PixImage() converts a 2D array of grayscale intensities to
   * a grayscale PixImage.
   *
   * @param pixels a 2D array of grayscale intensities in the range 0...255.
   * @return a new PixImage whose red, green, and blue values are equal to
   * the input grayscale intensities.
   */
  private static PixImage array2PixImage(int[][] pixels) {
    int width = pixels.length;
    int height = pixels[0].length;
    PixImage image = new PixImage(width, height);

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        image.setPixel(x, y, (short) pixels[x][y], (short) pixels[x][y],
                       (short) pixels[x][y]);
      }
    }

    return image;
  }

  /**
   * equals() checks whether two images are the same, i.e. have the same
   * dimensions and pixels.
   *
   * @param image a PixImage to compare with "this" PixImage.
   * @return true if the specified PixImage is identical to "this" PixImage.
   */
  public boolean equals(PixImage image) {
    int width = getWidth();
    int height = getHeight();

    if (image == null ||
        width != image.getWidth() || height != image.getHeight()) {
      return false;
    }

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        if (! (getRed(x, y) == image.getRed(x, y) &&
               getGreen(x, y) == image.getGreen(x, y) &&
               getBlue(x, y) == image.getBlue(x, y))) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * main() runs a series of tests to ensure that the convolutions (box blur
   * and Sobel) are correct.
   */
  public static void main(String[] args) {
    // Be forwarned that when you write arrays directly in Java as below,
    // each "row" of text is a column of your image--the numbers get
    // transposed.
    PixImage image1 = array2PixImage(new int[][] { { 0, 10, 240 },
                                                   { 30, 120, 250 },
                                                   { 80, 250, 255 } });
    System.out.println("Testing getWidth/getHeight on a 3x3 image.  " +
                       "Input image:");
    System.out.print(image1);
    doTest(image1.getWidth() == 3 && image1.getHeight() == 3,
           "Incorrect image width and height.");

    System.out.println("Testing blurring on a 3x3 image.");
    doTest(image1.boxBlur(1).equals(
           array2PixImage(new int[][] { { 40, 108, 155 },
                                        { 81, 137, 187 },
                                        { 120, 164, 218 } })),
           "Incorrect box blur (1 rep):\n" + image1.boxBlur(1));
    doTest(image1.boxBlur(2).equals(
           array2PixImage(new int[][] { { 91, 118, 146 },
                                        { 108, 134, 161 },
                                        { 125, 151, 176 } })), "Incorrect box blur (2 rep):\n" + image1.boxBlur(2));
    doTest(image1.boxBlur(2).equals(image1.boxBlur(1).boxBlur(1)),
           "Incorrect box blur (1 rep + 1 rep):\n" +
           image1.boxBlur(2) + image1.boxBlur(1).boxBlur(1));

    System.out.println("Testing edge detection on a 3x3 image.");
    doTest(image1.sobelEdges().equals(
           array2PixImage(new int[][] { { 104, 189, 180 },
                                        { 160, 193, 157 },
                                        { 166, 178, 96 } })),
           "Incorrect Sobel:\n" + image1.sobelEdges());


    PixImage image2 = array2PixImage(new int[][] { { 0, 100, 100 },
                                                   { 0, 0, 100 } });
    System.out.println("Testing getWidth/getHeight on a 2x3 image.  " +
                       "Input image:");
    System.out.print(image2);
    doTest(image2.getWidth() == 2 && image2.getHeight() == 3,
           "Incorrect image width and height.");

    System.out.println("Testing blurring on a 2x3 image.");
    doTest(image2.boxBlur(1).equals(
           array2PixImage(new int[][] { { 25, 50, 75 },
                                        { 25, 50, 75 } })),
           "Incorrect box blur (1 rep):\n" + image2.boxBlur(1));

    System.out.println("Testing edge detection on a 2x3 image.");
    doTest(image2.sobelEdges().equals(
           array2PixImage(new int[][] { { 122, 143, 74 },
                                        { 74, 143, 122 } })),
           "Incorrect Sobel:\n" + image2.sobelEdges());
  }
}
