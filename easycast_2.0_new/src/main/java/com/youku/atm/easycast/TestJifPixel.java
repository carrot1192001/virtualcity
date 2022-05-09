package com.youku.atm.easycast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.youku.atm.easycast.GifDecoder.GifImage;

public class TestJifPixel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        int width = 0;
        int height = 0;
        String path = "http://r1.ykimg.com/material/0A03/201805/0518/168911/480-800.gif";
		URL url = new URL(path);
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		if (path.endsWith("gif")) {
			GifImage gifImage = GifDecoder.read(connection.getInputStream());
			width = gifImage.getWidth();
			height = gifImage.getHeight();
		} else {

		}
		
		System.out.println("width is :" + width + " height is : " + height);

	}

}
