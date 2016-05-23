import java.io.File;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Font;
import javax.imageio.ImageIO;

public class Main
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("******************************");
        System.out.println("**  File Creator Generator  **");
        System.out.println("******************************\n");

        System.out.println("Note: Generates a variable number of files giving a number for their name\n");

        System.out.print("Input the starting number (Name of the first file): ");
        int startNumber = in.nextInt();

        System.out.print("Input the number of files to generate: ");
        int numOfFiles = in.nextInt();       

        System.out.print("Input the extension for the generated files: ");
        String fileExtension = in.next();

        System.out.println("\n");
        for(int i = startNumber; i < numOfFiles+startNumber; i++) {
            String fileName = i + "." + fileExtension;
            String fileDir = "Images//";

            File imgFile = new File(fileDir + fileName);

            try {
                int size = 500;
                
                //Edit the Image
                BufferedImage img = new BufferedImage(size, size/2, BufferedImage.TYPE_INT_RGB);
                Graphics g = img.getGraphics();
                g.setFont(new Font(null, Font.BOLD, 75));
                g.drawString(fileName, 100, 100);                  

                imgFile.createNewFile();
                ImageIO.write(img, fileExtension, imgFile); 
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }

            System.out.println(fileName + " was successfully created in the \"" + fileDir + "\" directory");
        }

    }
}