import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

class fractalsShells {
	public static void main(String[] args) {
		//This is the code used to create the image you see on the panel.
		
		DrawingPanel panel = new DrawingPanel(300,300); //The Canvas
		panel.setBackground(Color.WHITE);
		Graphics g = panel.getGraphics();//Create the paintbrush
		Point s1 = new Point(50,250);
		Point s2 = new Point(100,250);
		Point s3 = new Point(50,300);
		Point s4 = new Point(100, 300);
		//Everything else in main is for adding aspects to the canvas
		
		g.setColor(Color.RED); //Setting the paintbrush to the color red
		g.drawString("Hello, world!", 20, 50); //create a RED string onto the canvas
		
		
		//Now I need to assign the points of my equilateral triangle.
		Point bottomLeft = new Point(50, 250);
		Point topMiddle = new Point(150, 50);
		Point bottomRight = new Point(250, 250);
		
		//Time to use my custom method!
		g.setColor(Color.BLACK);//Setting the paintbrush to the color BLACK
		drawTriangle(g, bottomLeft, topMiddle, bottomRight);
		//runs the recursion to the triangle 
		recur(g,bottomLeft, topMiddle, bottomRight,2);
	}


	/*public static void makeButton(Graphics g, Point p1, Point p2, Point p3, Point p4, int level) {
		Frame f = new Frame();
        Button b1 = new Button(""+level+"");
        b1.setBounds(100, 50, 50, 50);
        f.add(b1);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
		
	}*/

	public static void drawTriangle(Graphics g, Point p1, Point p2, Point p3)
	{
		/* 
			Since the Graphics class doesn't contain a drawTriangle method,
			I decided to create my own using the Polygon class, which will
			basically trace the shape starting from the first point to the
			next point and so on and so on. It will then close the shape by
			tracing from the last point to the first point.
		*/

		//If you want to create a custom shape, edit this function to fit the
			//your design.
		Polygon p = new Polygon();
		p.addPoint(p1.x, p1.y);
		p.addPoint(p2.x, p2.y);
		p.addPoint(p3.x, p3.y);
		g.fillPolygon(p);
		
		//or you can use:   g.drawPolygon(p);
		
  	}
	public static void drawSquare(Graphics g, Point p1, Point p2, Point p3,Point p4)
	{
		
		Polygon p = new Polygon();
		p.addPoint(p1.x, p1.y);
		p.addPoint(p2.x, p2.y);
		p.addPoint(p3.x, p3.y);
		p.addPoint(p4.x,p4.y);
		g.fillPolygon(p);
		
		//or you can use:   g.drawPolygon(p);
		
  	}
  	
  	public static Point midpoint(Point p1, Point p2)
  	{
  		//This method should give us the midpoint of 2 coordinates
		  	//Use this site as a guide: https://www.mathsisfun.com/algebra/line-midpoint.html
  		
  		Point mid = new Point();
  		//Just setting the midpoint of the sum of x/y values divided by 2
  		mid.x = (p1.x+p2.x)/2;
  		mid.y = (p1.y+p2.y)/2;
  		//mid.x = ?
  		//mid.y = ?
  		
  		return mid;
  	}
  	public static Point thirds(Point p1, Point p2)
  	{
  		//this method creates the thirds of the carpet
		  	//Use this site as a guide: https://www.mathsisfun.com/algebra/line-midpoint.html
  		
  		Point third = new Point();
  		//Just setting the midpoint of the sum of x/y values divided by 2
  		third.x = p1.x + (p1.x-p2.x) * 1/3;
  		third.y = p1.y + (p1.y-p2.y) * 1/3;
  		//mid.x = ?
  		//mid.y = ?
  		
  		return third;
  	}

	public static void recur(Graphics g, Point p1, Point p2, Point p3, int level)
	{
		//sets it a different color 
		g.setColor(Color.WHITE);
		//calls the next/first level to be created
		drawTriangle(g,midpoint(p1,p2),midpoint(p2,p3),midpoint(p3,p1));
		level--;
		if(level > 0)
		{
			//creates three seperate triangles to surround the inner triangle
			recur(g,p1,midpoint(p1,p3),midpoint(p1,p2),level-1);
			recur(g,p2,midpoint(p2,p1),midpoint(p2,p3),level-1);
			recur(g,p3,midpoint(p3,p1),midpoint(p3,p2),level-1);
			//makes the level go down to get closer to the end
			level--;
		}
	}
	public static void recurs(Graphics g, Point p1, Point p2, Point p3,Point p4, int level)
	{
		g.setColor(Color.WHITE);
		level--;
		drawSquare(g,thirds(p1,p2),thirds(p2,p3),thirds(p3,p4),thirds(p4,p1));
		if(level > 0)
		{
			recurs(g,thirds(p1,p2),thirds(p2,p3),thirds(p3,p4),thirds(p4,p1),level-1);
			recurs(g,thirds(p1,p2),thirds(p2,p3),thirds(p3,p4),thirds(p4,p1),level-1);
			recurs(g,thirds(p1,p2),thirds(p2,p3),thirds(p3,p4),thirds(p4,p1),level-1);
			recurs(g,thirds(p1,p2),thirds(p2,p3),thirds(p3,p4),thirds(p4,p1),level-1);
			recurs(g,thirds(p1,p2),thirds(p2,p3),thirds(p3,p4),thirds(p4,p1),level-1);
			recurs(g,thirds(p1,p2),thirds(p2,p3),thirds(p3,p4),thirds(p4,p1),level-1);
			recurs(g,thirds(p1,p2),thirds(p2,p3),thirds(p3,p4),thirds(p4,p1),level-1);
			recurs(g,thirds(p1,p2),thirds(p2,p3),thirds(p3,p4),thirds(p4,p1),level-1);
		}
	}
}