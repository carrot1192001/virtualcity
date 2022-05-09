package com.youku.atm.easycast;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenShots {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage screenshot = (new Robot()).createScreenCapture(new Rectangle(0,
					0,(int)dimension.getWidth(),(int)dimension.getHeight()));
			File file = new File("C:/screen.jpg");
			ImageIO.write(screenshot, "jpg", file);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}