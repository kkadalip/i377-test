package test;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class praks1yl3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//	3. Tekitage servlet, mis toodab PNG formaadis pildifaili, kuhu on "joonistatud" praeguse hetke kellaaeg
	//	   Vaadake, kuidas kysida kellaaega http://www.java-tips.org/java-se-tips/java.util/how-to-get-current-date-time.html
	//	   Graafika joonistamine: http://www.java2s.com/Code/Java/2D-Graphics-GUI/DrawanImageandsavetopng.htm
	//	   Faili kirjutamise asemel kirjutage v2ljundvoogu ( response.getOutputStream() )
	//	   2rge unustage s2ttida 6iget Content-Type-i
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = getDateTime().toString();
		//response.getWriter().println(a);
		
		response.setContentType("image/png");
		ServletOutputStream outputStream = response.getOutputStream();
		
		try {
			int width = 200, height = 200;
			// TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
			// into integer pixels
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D ig2 = bi.createGraphics();

			Font font = new Font("TimesRoman", Font.BOLD, 20);
			ig2.setFont(font);
			String message = a;
			FontMetrics fontMetrics = ig2.getFontMetrics();
			int stringWidth = fontMetrics.stringWidth(message);
			int stringHeight = fontMetrics.getAscent();
			ig2.setPaint(Color.black);
			ig2.drawString(message, (width - stringWidth) / 2, height / 2 + stringHeight / 4);
			
			ImageIO.write(bi, "PNG", outputStream);
//			ImageIO.write(bi, "PNG", new File("c:\\yourImageName.PNG"));
//			ImageIO.write(bi, "JPEG", new File("c:\\yourImageName.JPG"));
//			ImageIO.write(bi, "gif", new File("c:\\yourImageName.GIF"));
//			ImageIO.write(bi, "BMP", new File("c:\\yourImageName.BMP"));

		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			outputStream.close();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
