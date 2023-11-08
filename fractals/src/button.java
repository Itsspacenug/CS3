import java.awt.*;

public class button {

	public void makeButton(Graphics g, Point p1, Point p2, Point p3,int level)
	{
		Frame f = new Frame();
        Button b1 = new Button(""+level+"");
        b1.setBounds(100, 50, 50, 50);
        f.add(b1);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
	}
}
