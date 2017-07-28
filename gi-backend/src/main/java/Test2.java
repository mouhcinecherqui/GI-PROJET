/*
 * /*
 * Project: API GDFA - 29M
 * Copyright© 2017 ORANGE
 * Creation: 17 avr. 2017 by marouane.rais@sofrecom.com
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class Test2 {

	public static void main(String[] args) throws Exception {
		// System.out.println(GDFAGenericValidator.isNotBlankOrNull("t",
		// ExceptionType.APPLICATION_EXCEPTION, "chaine vide1"));
		// System.out.println(GDFAGenericValidator.isNotBlankOrNull(" - ",
		// ExceptionType.NOTFOUND_EXCEPTION, "chaine vide2"));
		// System.out.println(GDFAGenericValidator.isNotBlankOrNull(null,
		// ExceptionType.BUSINESS_EXCEPTION, "chaine vide4"));
		for (int i = 0; i <= 400; i++) {
			try {
				URL url = new URL(
						"http://www.aswakassalam.com/aswak/wp-content/uploads/2017/07/" + i + "-724x1024.jpg");
				BufferedImage img = ImageIO.read(url);
				File file = new File("D:/aswak_assalam/ASWAK-" + i + ".jpg");
				ImageIO.write(img, "jpg", file);
			} catch (Exception e) {
				System.out.println(e.getSuppressed() + " ==> " + i);
			}

		}
	}

}
