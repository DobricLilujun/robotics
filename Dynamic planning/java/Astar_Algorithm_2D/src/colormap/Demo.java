package colormap;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Demo
{
	public static void main(String[] arg) throws Exception
	{
		int width = 30, height = 500;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		double zmin = 0;
		double zmax = height - 1;
		
		ColorMap cmap = new ColorMap(zmin, zmax);
		cmap.sea(256);
//		cmap.demcmap(64);
//		cmap.jet(256);
//		cmap.parula(256);
//		cmap.sea(256);
		
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				image.setRGB(x, y, cmap.getRGB(height-1-y));
			}
		}
		
		File file = new File("test.bmp");
        ImageIO.write(image, "bmp", file);
	}
}

