/*
  ImageApp:
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Scanner;

public class ImageApp
{
  public static Picture rotate(Picture source, double degrees)
  {
    Picture rotated = new Picture(source.getHeight(), source.getWidth());
    rotated.setAllPixelsToAColor(Color.WHITE);
    Graphics2D graphics = rotated.createGraphics();
    graphics.rotate(Math.toRadians(degrees),
                    rotated.getWidth() / 2.0, rotated.getHeight() / 2.0);
    graphics.drawImage(source.getImage(), 0, 0, null);
    graphics.dispose();
    return rotated;
  }

  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    System.out.print("How many degrees should the image rotate? ");
    double rotationDegrees = scanner.nextDouble();

    // use any file from the lib folder
    String pictureFile = "lib/beach.jpg";

    // Get an image, get 2d array of pixels, show a color of a pixel, and display the image
    Picture origImg = new Picture(pictureFile);
    Pixel[][] origPixels = origImg.getPixels2D();
    System.out.println(origPixels[0][0].getColor());
    origImg.explore();

    // Image #1 Using the original image and pixels, recolor an image by changing the RGB color of each Pixel
    Picture recoloredImg = new Picture(pictureFile);
    Pixel[][] recoloredPixels = recoloredImg.getPixels2D();

    /* to be implemented */

    // Image #2 Using the original image and pixels, create a photographic negative of the image
    Picture negImg = new Picture(pictureFile);
    Pixel[][] negPixels = negImg.getPixels2D();

    negImg.reveal();
    negImg.explore();

    // Image #3 Using the original image and pixels, create a grayscale version of the image
    Picture grayscaleImg = new Picture(pictureFile);
    Pixel[][] grayscalePixels = grayscaleImg.getPixels2D();

    /* to be implemented */

    // Rotate within the original bounds; uncovered areas remain white.
    Picture rotatedImage = rotate(new Picture(pictureFile), rotationDegrees);
    rotatedImage.explore();

    // Final Image: Add a small image to a larger one

    /* to be implemented */

    // for testing  2D algorithms
    int[][] test1 = { { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 } };
    int[][] test2 = new int[4][4];
  }
}
