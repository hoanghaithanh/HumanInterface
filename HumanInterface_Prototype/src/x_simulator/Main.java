package x_simulator;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class Main extends JFrame {

	JLabel label;
	JPanelOpenCV t;
	VideoCapture camera;

	public Main() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		setTitle("Test");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		label = new JLabel();
		label.setSize(800, 600);
		getContentPane().add(label);
		setVisible(true);

		t = new JPanelOpenCV();
		camera = new VideoCapture(0);
		Mat frame = new Mat();
		camera.read(frame);
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (camera.read(frame)) {
						label.setIcon(new ImageIcon(t.MatToBufferedImage(frame)));
						label.revalidate();
						label.repaint();
						label.update(label.getGraphics());
					}
				}
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				camera.release();
				thread.interrupt();
				System.exit(0);
			}
		});

		

		

		if (!camera.isOpened()) {
			System.out.println("Error");
		} else {
			thread.start();
		}

	}

	public static void main(String[] agrs) {
		Main m = new Main();
	}
}
