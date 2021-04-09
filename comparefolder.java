
package testseleproj;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.imageio.ImageIO;

public class comparefolder {

    static String workingDir = System.getProperty("C:\\Users\\Bhuvaneswari\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
    static String COMBINATION = "combination";
    static String SUBTRACTION = "subtraction";
    static String IMAGE_FILE_TYPE = "png";
    final static File folderActual = new File("c:\\users\\Bhuvaneswari\\Desktop\\Folder 1\\");
    final static File folderExpected = new File("c:\\users\\Bhuvaneswari\\Desktop\\Folder 2\\");

    public static List<String> listFilesForFolder(final File folder) throws IOException
    {
        List<String> files = new ArrayList<String>();
        try (Stream<Path> paths = Files.walk(folder.toPath()))
        {
            paths.filter(Files::isRegularFile).filter(path -> path.toString().endsWith(".png")).map(Path::getFileName)
                    .forEach(p -> files.add(p.toString()));
        }

        return files;
    }
    public static void main(String[] args) throws IOException
    {
        for (String s : listFilesForFolder(folderExpected))
        {
            File actualFile = new File(folderActual.getAbsolutePath() + "\\" + s);
            File expectedFile = new File(folderExpected.getAbsolutePath() + "\\" + s);
            if (actualFile.exists())
            {
                BufferedImage imgA = ImageIO.read(actualFile);
                BufferedImage imgB = ImageIO.read(expectedFile);
                boolean same = comparefolder.bufferedImagesEqual(imgA, imgB);
                System.out.println(s + ": " + same);
                if (!same)
                {
                	comparefolder.subtractImages(imgA, imgB, new File(COMBINATION + "." + s));
                	comparefolder.combineImages(imgA, imgB, new File(SUBTRACTION + "." + s));
                }
            }
            else
            {
                System.out.println(s + ": does not exist in the ICScreenshots directory");
            }
        }
    }
    
    private static void combineImages(BufferedImage image1, BufferedImage image2, File outputFile) throws IOException
    {
        BufferedImage result = new BufferedImage(image1.getWidth(), image1.getHeight(), image1.getType());
        for (int x = 0; x < image1.getWidth(); x++)
            for (int y = 0; y < image1.getHeight(); y++)
            {
                result.setRGB(x, y, Math.abs(image2.getRGB(x, y) + image1.getRGB(x, y)));
            }
        ImageIO.write(result, IMAGE_FILE_TYPE, outputFile);
    }

    private static void subtractImages(BufferedImage image1, BufferedImage image2, File outputFile) throws IOException
    {
        BufferedImage result = new BufferedImage(image1.getWidth(), image1.getHeight(), image1.getType());
        for (int x = 0; x < image1.getWidth(); x++)
            for (int y = 0; y < image1.getHeight(); y++)
            {
                result.setRGB(x, y, Math.abs(image2.getRGB(x, y) - image1.getRGB(x, y)));
            }
        ImageIO.write(result, IMAGE_FILE_TYPE, outputFile);
    }

    private static boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2)
    {
        if (!(img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()))
        {
            return false;
        }
        for (int x = 0; x < img1.getWidth(); x++)
        {
            for (int y = 0; y < img1.getHeight(); y++)
            {
                if (img1.getRGB(x, y) != img2.getRGB(x, y))
                    return false;
            }
        }
        return true;
    }
}