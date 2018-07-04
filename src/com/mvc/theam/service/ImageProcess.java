package com.mvc.theam.service;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.fileupload.FileItem;

public class ImageProcess {
	private static final int IMG_WIDTH = 600;
	private static final int IMG_HEIGHT = 300;

	public static boolean processfile(FileItem item, String imgName, String path) {
		try {
			String name = new File(item.getName()).getName();
			File f = new File(path + File.separator + name);
			item.write(f);

			// this code will help you to resize and rename your image....
			
			File resizefile = new File(path + File.separator + imgName);
			BufferedImage originalImage = ImageIO.read(f);
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

			BufferedImage resizeImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
			Graphics2D g = resizeImage.createGraphics();
			g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
			g.dispose();
			ImageIO.write(resizeImage, "jpg", resizefile);

			f.delete();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
