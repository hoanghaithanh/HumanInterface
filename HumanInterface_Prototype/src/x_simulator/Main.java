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
	Thread thread;

	public Main() {

		initLayout();

		initCamera();

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					camera.release();
					thread.interrupt();
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					System.exit(0);
				}
			}
		});

	}

	private void initLayout() {
		setTitle("Test");
		setSize(800, 600);

		label = new JLabel();
		label.setSize(800, 600);
		getContentPane().add(label);
		setVisible(true);
	}

	private void initCamera() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		t = new JPanelOpenCV();
		camera = new VideoCapture(0);
		Mat frame = new Mat();
		camera.read(frame);

		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (camera.read(frame)) {
						label.setIcon(new ImageIcon(t.MatToBufferedImage(frame)));
//						label.revalidate();
//						label.repaint();
//						label.update(label.getGraphics());
					}
				}
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
