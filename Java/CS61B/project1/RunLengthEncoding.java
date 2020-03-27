/*
* @Author: adrrrrrrrian
* @Date:   2016-03-08 22:28:30
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-23 16:17:56
*/
/* RunLengthEncoding.java */

/**
 *  The RunLengthEncoding class defines an object that run-length encodes
 *  a PixImage object.  Descriptions of the methods you must implement appear
 *  below.  They include constructors of the form
 *
 *      public RunLengthEncoding(int width, int height);
 *      public RunLengthEncoding(int width, int height, int[] red, int[] green,
 *                               int[] blue, int[] runLengths) {
 *      public RunLengthEncoding(PixImage image) {
 *
 *  that create a run-length encoding of a PixImage having the specified width
 *  and height.
 *
 *  The first constructor creates a run-length encoding of a PixImage in which
 *  every pixel is black.  The second constructor creates a run-length encoding
 *  for which the runs are provided as parameters.  The third constructor
 *  converts a PixImage object into a run-length encoding of that image.
 *
 *  See the README file accompanying this project for additional details.
 */

import java.util.*;

public class RunLengthEncoding implements Iterable {

  /**
   *  Define any variables associated with a RunLengthEncoding object here.
   *  These variables MUST be private.
   */
  private int width;
  private int height;
  //private short[][][] pixe;//remember the first element stands for red, then green, blue;
  private ListNode head = null;

  /**
   *  The following methods are required for Part II.
   */

  /**
   *  RunLengthEncoding() (with two parameters) constructs a run-length
   *  encoding of a black PixImage of the specified width and height, in which
   *  every pixel has red, green, and blue intensities of zero.
   *
   *  @param width the width of the image.
   *  @param height the height of the image.
   */

  public RunLengthEncoding(int width, int height) {
    this.width = width;
    this.height = height;
    //pixe = new short[width][height][3];
    head = new ListNode(0,0,0,width*height);
  }

  /**
   *  RunLengthEncoding() (with six parameters) constructs a run-length
   *  encoding of a PixImage of the specified width and height.  The runs of
   *  the run-length encoding are taken from four input arrays of equal length.
   *  Run i has length runLengths[i] and RGB intensities red[i], green[i], and
   *  blue[i].
   *
   *  @param width the width of the image.
   *  @param height the height of the image.
   *  @param red is an array that specifies the red intensity of each run.
   *  @param green is an array that specifies the green intensity of each run.
   *  @param blue is an array that specifies the blue intensity of each run.
   *  @param runLengths is an array that specifies the length of each run.
   *
   *  NOTE:  All four input arrays should have the same length (not zero).
   *  All pixel intensities in the first three arrays should be in the range
   *  0...255.  The sum of all the elements of the runLengths array should be
   *  width * height.  (Feel free to quit with an error message if any of these
   *  conditions are not met--though we won't be testing that.)
   */

  public RunLengthEncoding(int width, int height, int[] red, int[] green,
                           int[] blue, int[] runLengths) {
    this.width = width;
    this.height = height;
    ListNode a = head;
    a = new ListNode(red[0],green[0],blue[0],runLengths[0]);
    for(int i = 1; i < runLengths.length; i++){
      a.next = new ListNode(red[i],green[i],blue[i],runLengths[i]);
      ListNode b = a.next;
      b.previous = a;
      a = a.next;
    }
    /*int w = 0;int h = 0;
    while(h < height){
      while(w < width){
        setPixel(h,w,a.get(h*height+w),b.get(h*height+w),c.get(h*height+w));
        w++;
      }
      w = 0;
      h++;
    }*/

  }

  /**
   *  getWidth() returns the width of the image that this run-length encoding
   *  represents.
   *
   *  @return the width of the image that this run-length encoding represents.
   */

  public int getWidth() {
    return width;
  }

  /**
   *  getHeight() returns the height of the image that this run-length encoding
   *  represents.
   *
   *  @return the height of the image that this run-length encoding represents.
   */
  public int getHeight() {
    return height;
  }

  /**
   *  iterator() returns a newly created RunIterator that can iterate through
   *  the runs of this RunLengthEncoding.
   *
   *  @return a newly created RunIterator object set to the first run of this
   *  RunLengthEncoding.
   */
  public RunIterator iterator() {
    RunIterator ite = new RunIterator(head);
    return ite;
    // You'll want to construct a new RunIterator, but first you'll need to
    // write a constructor in the RunIterator class.
  }

  /**
   *  toPixImage() converts a run-length encoding of an image into a PixImage
   *  object.
   *
   *  @return the PixImage that this RunLengthEncoding encodes.
   */
  public PixImage toPixImage() {
    RunIterator ite = iterator();
    PixImage pix = new PixImage(width, height);
    ArrayList<Integer> all = new ArrayList<Integer>();
    while(ite.hasNext()){
      int[] ans = ite.next();
      int n = ans[3];
      for(int i = 0 ; i < n; i++){
        all.add(ans[0]);
        all.add(ans[1]);
        all.add(ans[2]);
      }
    }
    int k = 0;
    for(int i = 0; i < height; i++){
      for(int j = 0; j < width; j++){
        int a = all.get(k);
        k++;
        int b = all.get(k);
        k++;
        int c = all.get(k);
        k++;
        pix.setPixel(j,i,(short)a,(short)b,(short)c);
      }
    }
    return pix;
  }

  /**
   *  toString() returns a String representation of this RunLengthEncoding.
   *
   *  This method isn't required, but it should be very useful to you when
   *  you're debugging your code.  It's up to you how you represent
   *  a RunLengthEncoding as a String.
   *
   *  @return a String representation of this RunLengthEncoding.
   */
  public String toString() {
    StringBuffer s = new StringBuffer();
    RunIterator ite = iterator();
    while(ite.hasNext()){
    int[] ans;
    ans = ite.next();
      s.append(ans[0] +" "+ ans[1] +" "+ ans[2] +" "+","+ ans[3]+ "   |  ");
    }
    return s.toString();
  }


  /**
   *  The following methods are required for Part III.
   */

  /**
   *  RunLengthEncoding() (with one parameter) is a constructor that creates
   *  a run-length encoding of a specified PixImage.
   * 
   *  Note that you must encode the image in row-major format, i.e., the second
   *  pixel should be (1, 0) and not (0, 1).
   *
   *  @param image is the PixImage to run-length encode.
   */
  public RunLengthEncoding(PixImage image) {
    this.width = image.getWidth();
    this.height = image.getHeight();
    ListNode a = head;
    for(int i = 0 ; i < height; i++){
      for(int j = 0 ; j < width; j++){
        if(a == null){
          a = new ListNode(image.getRed(0,0),image.getGreen(0,0),image.getBlue(0,0),1);
          head = a;
        }else{
          if(a.red == image.getRed(j,i)){
            a.number++;
          }else{
            a.next = new ListNode(image.getRed(j,i),image.getGreen(j,i),image.getBlue(j,i),1);
            ListNode b = a.next;
            b.previous = a;
            a = a.next;
          }
        }
      }
    }
    check();
  }

  /**
   *  check() walks through the run-length encoding and prints an error message
   *  if two consecutive runs have the same RGB intensities, or if the sum of
   *  all run lengths does not equal the number of pixels in the image.
   */
  public void check() {
    RunIterator ite = iterator();
    int sum = 0; 
    int red=0,blue=0,green=0;
    if(ite.hasNext()){
      int[] run = ite.next();
      sum+= run[3];
      red = run[0];
      green = run[1];
      blue = run[2];
    }
    while(ite.hasNext()){
      int[] run = ite.next();
      sum += run[3];
      if(red == run[0]&&blue == run[2]&&green == run[1])System.out.println("There is an error: repeated colors!");
      else{
        red = run[0];
        green = run[1];
        blue = run[2];
      }
    }
    if(sum != width*height)System.out.println("the runlength coding has an error that the lengths are not equal!");


  }


  /**
   *  The following method is required for Part IV.
   */

  /**
   *  setPixel() modifies this run-length encoding so that the specified color
   *  is stored at the given (x, y) coordinates.  The old pixel value at that
   *  coordinate should be overwritten and all others should remain the same.
   *  The updated run-length encoding should be compressed as much as possible;
   *  there should not be two consecutive runs with exactly the same RGB color.
   *
   *  @param x the x-coordinate of the pixel to modify.
   *  @param y the y-coordinate of the pixel to modify.
   *  @param red the new red intensity to store at coordinate (x, y).
   *  @param green the new green intensity to store at coordinate (x, y).
   *  @param blue the new blue intensity to store at coordinate (x, y).
   */
  public void setPixel(int x, int y, short red, short green, short blue) {
    int location = y*width+x;
      int sum = 0;
      int temp = 0;
      int flag = 0;
      RunIterator a = iterator();
      ListNode aa = head;
      while(a.hasNext()){
        int[] run = a.next();
        temp = run[3];
        sum = sum+temp;
        if(sum-1 >= location){
          flag = location-(sum-1-temp);
          break;
        }
        aa = aa.next;
      }
      //only one element in this listnode
      if(temp == 1){
        ListNode p = aa.previous;
        ListNode n = aa.next;
        if(p != null && n!= null){
          if((red == (short)p.red)&&(blue == (short)p.blue)&& (green == (short)p.green)){
            p.number++;
            p.next = n;
            n.previous = p;
          }else if((red == (short)n.red)&&(blue == (short)n.blue)&& (green == (short)n.green)){
            n.number++;
            p.next = n;
            n.previous = p;
          }else{
            aa.red = red;
            aa.green = green;
            aa.blue = blue;
          }
          if(((short)n.red) == (short)p.red&&((short)n.blue) == ((short)p.blue)&& ((short)n.green) == (short)p.green){
            p.number = p.number + n.number;
            if(n.next != null){
              p.next = n.next;
              n.next.previous = p;
            }else{
              p.next = null;
            }
          }
          
          
          
        }else if(p!= null && n == null){
          if((red == (short)p.red)&&(blue == (short)p.blue)&& (green == (short)p.green)){
            p.number++;
            p.next = null;
          }else{
            aa.red = red;
            aa.green = green;
            aa.blue = blue;
          }
        }else if(p== null && n!= null){
          if((red == (short)n.red)&&(blue == (short)n.blue)&& (green == (short)n.green)){
            n.number++;
            head = n;
          }else{
            aa.red = red;
            aa.green = green;
            aa.blue = blue;
          }
        }else{//p == null && n == null
          aa.red = red;
          aa.green = green;
          aa.blue = blue;
        }
        
        check();
        return;
      }
      //larger than one element, the changing node is at the end point
      if(sum-1 == location){
        ListNode n = aa.next;
        if(n != null){
          if((red == (short)n.red)&&(blue == (short)n.blue)&& (green == (short)n.green)){
            n.number++;
            aa.number--;
          }else{
            aa.number--;
            ListNode ne = new ListNode(red,green,blue,1);
            ne.next = aa.next;
            aa.next.previous = ne;
            aa.next = ne;
            ne.previous = aa;
          }
        }else{
          aa.number--;
            ListNode ne = new ListNode(red,green,blue,1);
            ne.next = null;
            aa.next = ne;
            ne.previous = aa;
        }
        
        check();
        return;
      }
      //larger than one element, the changing node is at the begin point
      if(sum-temp == location){
        ListNode p = aa.previous;
        if(p!= null){
          if((red == (short)p.red) && (blue == (short)p.blue) && (green == (short)p.green)){
            p.number++;
            aa.number--;
          }else{
            aa.number--;
            ListNode ne = new ListNode(red,green,blue,1);
            aa.previous.next = ne;
            ne.previous = aa.previous;
            aa.previous = ne;
            ne.next = aa;
          }
        }else{
          aa.number--;
            ListNode ne = new ListNode(red,green,blue,1);
            ne.previous = null;
            aa.previous = ne;
            ne.next = aa;
            head = ne;
        }
        
        check();
        return;
      }
      //larger than one element, the changing node is in the middle
      if(sum-temp < location && location<sum-1){
        ListNode n = aa.next;
        ListNode p = aa.previous;
        int num = aa.number;
        int left = flag - 1;
        int right = num - flag;

        ListNode ne1 = new ListNode(aa.red, aa.green,aa.blue,left);
        ListNode nem = new ListNode(red, green, blue, 1);
        ListNode ne2 = new ListNode(aa.red, aa.green, aa.blue,right);
        
        ne1.next = nem;
        nem.previous = ne1;
        nem.next = ne2;
        ne2.previous = nem;
        
        if(p != null){
          p.next = ne1;
          ne1.previous = p;
        }else{
          head = ne1;
        }
        if(n!= null){
          ne2.next = n;
        n.previous = ne2;
        }else{
          ne2.next = null;
        }
      }
      check();
      return;
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
   * setAndCheckRLE() sets the given coordinate in the given run-length
   * encoding to the given value and then checks whether the resulting
   * run-length encoding is correct.
   *
   * @param rle the run-length encoding to modify.
   * @param x the x-coordinate to set.
   * @param y the y-coordinate to set.
   * @param intensity the grayscale intensity to assign to pixel (x, y).
   */
  private static void setAndCheckRLE(RunLengthEncoding rle,
                                     int x, int y, int intensity) {
    rle.setPixel(x, y,
                 (short) intensity, (short) intensity, (short) intensity);
    rle.check();
  }

  /**
   * main() runs a series of tests of the run-length encoding code.
   */
  public static void main(String[] args) {
    // Be forwarned that when you write arrays directly in Java as below,
    // each "row" of text is a column of your image--the numbers get
    // transposed.
    PixImage image1 = array2PixImage(new int[][] { { 0, 3, 6 },
                                                   { 1, 4, 7 },
                                                   { 2, 5, 8 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on a 3x3 image.  Input image:");
    System.out.print(image1);
    RunLengthEncoding rle1 = new RunLengthEncoding(image1);
    System.out.println(rle1);
    rle1.check();
    System.out.println("Testing getWidth/getHeight on a 3x3 encoding.");
    doTest(rle1.getWidth() == 3 && rle1.getHeight() == 3,
           "RLE1 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 3x3 encoding.");
    doTest(image1.equals(rle1.toPixImage()),
           "image1 -> RLE1 -> image does not reconstruct the original image");
    System.out.println(rle1);
    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 0, 42);
    image1.setPixel(0, 0, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           /*
                       array2PixImage(new int[][] { { 42, 3, 6 },
                                                    { 1, 4, 7 },
                                                    { 2, 5, 8 } })),
           */
           "Setting RLE1[0][0] = 42 fails.");
    System.out.println(rle1);
    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 1, 0, 42);
    image1.setPixel(1, 0, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[1][0] = 42 fails.");
    System.out.println(rle1);
    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 1, 2);
    image1.setPixel(0, 1, (short) 2, (short) 2, (short) 2);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[0][1] = 2 fails.");
    System.out.println(rle1);
    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 0, 0);
    image1.setPixel(0, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[0][0] = 0 fails.");
    System.out.println(rle1);
    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 2, 2, 7);
    image1.setPixel(2, 2, (short) 7, (short) 7, (short) 7);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[2][2] = 7 fails.");
    System.out.println(rle1);
    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 2, 2, 42);
    image1.setPixel(2, 2, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[2][2] = 42 fails.");
    System.out.println(rle1);
    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 1, 2, 42);
    image1.setPixel(1, 2, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[1][2] = 42 fails.");
    System.out.println(rle1);

    PixImage image2 = array2PixImage(new int[][] { { 2, 3, 5 },
                                                   { 2, 4, 5 },
                                                   { 3, 4, 6 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on another 3x3 image.  Input image:");
    System.out.print(image2);
    RunLengthEncoding rle2 = new RunLengthEncoding(image2);
    rle2.check();
    System.out.println("Testing getWidth/getHeight on a 3x3 encoding.");
    doTest(rle2.getWidth() == 3 && rle2.getHeight() == 3,
           "RLE2 has wrong dimensions");
    System.out.println(rle2);
    System.out.println("Testing toPixImage() on a 3x3 encoding.");
    doTest(rle2.toPixImage().equals(image2),
           "image2 -> RLE2 -> image does not reconstruct the original image");
    System.out.println(rle2);
    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle2, 0, 1, 2);
    image2.setPixel(0, 1, (short) 2, (short) 2, (short) 2);
    doTest(rle2.toPixImage().equals(image2),
           "Setting RLE2[0][1] = 2 fails.");
    System.out.println(rle2);
    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle2, 2, 0, 2);
    image2.setPixel(2, 0, (short) 2, (short) 2, (short) 2);
    doTest(rle2.toPixImage().equals(image2),
           "Setting RLE2[2][0] = 2 fails.");
    System.out.println(rle2);

    PixImage image3 = array2PixImage(new int[][] { { 0, 5 },
                                                   { 1, 6 },
                                                   { 2, 7 },
                                                   { 3, 8 },
                                                   { 4, 9 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on a 5x2 image.  Input image:");
    System.out.print(image3);
    RunLengthEncoding rle3 = new RunLengthEncoding(image3);
    rle3.check();
    System.out.println("Testing getWidth/getHeight on a 5x2 encoding.");
    doTest(rle3.getWidth() == 5 && rle3.getHeight() == 2,
           "RLE3 has wrong dimensions");
    System.out.println(rle3);
    System.out.println("Testing toPixImage() on a 5x2 encoding.");
    doTest(rle3.toPixImage().equals(image3),
           "image3 -> RLE3 -> image does not reconstruct the original image");
    System.out.println(rle3);
    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 4, 0, 6);
    image3.setPixel(4, 0, (short) 6, (short) 6, (short) 6);
    doTest(rle3.toPixImage().equals(image3),
           "Setting RLE3[4][0] = 6 fails.");
    System.out.println(rle3);
    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 0, 1, 6);
    image3.setPixel(0, 1, (short) 6, (short) 6, (short) 6);
    doTest(rle3.toPixImage().equals(image3),
           "Setting RLE3[0][1] = 6 fails.");
    System.out.println(rle3);
    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 0, 0, 1);
    image3.setPixel(0, 0, (short) 1, (short) 1, (short) 1);
    doTest(rle3.toPixImage().equals(image3),
           "Setting RLE3[0][0] = 1 fails.");
    System.out.println(rle3);

    PixImage image4 = array2PixImage(new int[][] { { 0, 3 },
                                                   { 1, 4 },
                                                   { 2, 5 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on a 3x2 image.  Input image:");
    System.out.print(image4);
    RunLengthEncoding rle4 = new RunLengthEncoding(image4);
    rle4.check();
    System.out.println("Testing getWidth/getHeight on a 3x2 encoding.");
    doTest(rle4.getWidth() == 3 && rle4.getHeight() == 2,
           "RLE4 has wrong dimensions");
    System.out.println(rle4);
    System.out.println("Testing toPixImage() on a 3x2 encoding.");
    doTest(rle4.toPixImage().equals(image4),
           "image4 -> RLE4 -> image does not reconstruct the original image");
    System.out.println(rle4);
    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 2, 0, 0);
    image4.setPixel(2, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle4.toPixImage().equals(image4),
           "Setting RLE4[2][0] = 0 fails.");
    System.out.println(rle4);
    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 1, 0, 0);
    image4.setPixel(1, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle4.toPixImage().equals(image4),
           "Setting RLE4[1][0] = 0 fails.");
    System.out.println(rle4);
    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 1, 0, 1);
    image4.setPixel(1, 0, (short) 1, (short) 1, (short) 1);
    doTest(rle4.toPixImage().equals(image4),
           "Setting RLE4[1][0] = 1 fails.");
  }
}