package x_simulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.JPanel;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Scanner;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Rectangle;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.event.ChangeListener;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import javax.swing.event.ChangeEvent;

public class XMainBoard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XMainBoard window = new XMainBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public XMainBoard() {
		initialize();
	}

	Image image = null;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setName("horBox");
		frame.getContentPane().add(horizontalBox);

		Box verticalBox = Box.createVerticalBox();
		horizontalBox.add(verticalBox);

		JPanel panel_Door = new JPanel();
		panel_Door.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				displayPanel(0);
				panel_Door.setBackground(Color.WHITE);
			}
		});
		panel_Door.setPreferredSize(new Dimension(100, 10));
		panel_Door.setMinimumSize(new Dimension(50, 50));
		panel_Door.setBackground(Color.WHITE);
		verticalBox.add(panel_Door);
		panel_Door.setLayout(null);

		JLabel lblDoorControl = new JLabel("Door Control");
		lblDoorControl.setBounds(12, 42, 72, 16);
		panel_Door.add(lblDoorControl);

		JPanel panel_device = new JPanel();
		panel_device.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayPanel(1);
				panel_device.setBackground(Color.WHITE);
			}
		});
		panel_device.setPreferredSize(new Dimension(100, 10));
		panel_device.setBackground(Color.GRAY);
		verticalBox.add(panel_device);
		panel_device.setLayout(null);

		JLabel lblSecurity = new JLabel("Device");
		lblSecurity.setBounds(12, 49, 76, 31);
		panel_device.add(lblSecurity);

		JPanel panel_Utilities = new JPanel();
		panel_Utilities.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayPanel(2);
				panel_Utilities.setBackground(Color.WHITE);
			}
		});
		panel_Utilities.setPreferredSize(new Dimension(100, 10));
		panel_Utilities.setBackground(Color.GRAY);
		verticalBox.add(panel_Utilities);
		panel_Utilities.setLayout(null);

		JLabel lblUtilities = new JLabel("Utilities");
		lblUtilities.setBounds(12, 46, 56, 16);
		panel_Utilities.add(lblUtilities);

		JPanel panel_Navigator = new JPanel();
		panel_Navigator.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayPanel(3);
				panel_Navigator.setBackground(Color.WHITE);
			}
		});
		panel_Navigator.setPreferredSize(new Dimension(100, 10));
		panel_Navigator.setBackground(Color.GRAY);
		verticalBox.add(panel_Navigator);
		panel_Navigator.setLayout(null);

		JLabel lblNewLabel = new JLabel("Navigator");
		lblNewLabel.setBounds(12, 48, 56, 16);
		panel_Navigator.add(lblNewLabel);

		JPanel panel_4 = new JPanel();
		horizontalBox.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));

		JPanel panel_Door_dp = new JPanel();
		panel_4.add(panel_Door_dp, "name_172318794265353");
		panel_Door_dp.setLayout(new BorderLayout(0, 0));

		Box horizontalBox_1 = Box.createHorizontalBox();
		panel_Door_dp.add(horizontalBox_1);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setMinimumSize(new Dimension(-300, 0));
		verticalBox_1.setPreferredSize(new Dimension(-300, 0));
		horizontalBox_1.add(verticalBox_1);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.ORANGE));
		verticalBox_1.add(panel);
		panel.setLayout(null);

		JLabel lblFrontLeft = new JLabel("Front Left");
		lblFrontLeft.setBounds(60, 134, 56, 16);
		panel.add(lblFrontLeft);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.ORANGE));
		verticalBox_1.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblRearLeft = new JLabel("Rear Left");
		lblRearLeft.setBounds(59, 135, 56, 16);
		panel_1.add(lblRearLeft);

		Box verticalBox_2 = Box.createVerticalBox();
		verticalBox_2.setPreferredSize(new Dimension(-300, 0));
		horizontalBox_1.add(verticalBox_2);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.ORANGE));
		verticalBox_2.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblFrontRight = new JLabel("Front Right");
		lblFrontRight.setBounds(47, 132, 69, 16);
		panel_2.add(lblFrontRight);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.ORANGE));
		verticalBox_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblRearRight = new JLabel("Rear Right");
		lblRearRight.setBounds(53, 132, 73, 16);
		panel_3.add(lblRearRight);

		JPanel panel_5 = new JPanel();
		horizontalBox_1.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblStatus = new JLabel("Door status: ");
		lblStatus.setBounds(62, 61, 94, 38);
		panel_5.add(lblStatus);

		JLabel lblDoorName = new JLabel("Door Name");
		lblDoorName.setBounds(189, 13, 89, 46);
		panel_5.add(lblDoorName);

		JLabel lblGlassStatus = new JLabel("Glass status: ");
		lblGlassStatus.setBounds(62, 112, 94, 38);
		panel_5.add(lblGlassStatus);

		JPanel panel_6 = new JPanel();
		panel_6.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_6.setBounds(62, 391, 374, 88);
		panel_5.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JToggleButton tglbtnNewToggleButton = new JToggleButton("Lock Door");
		tglbtnNewToggleButton.setPreferredSize(new Dimension(89, 50));
		tglbtnNewToggleButton.setHorizontalAlignment(SwingConstants.LEFT);
		panel_6.add(tglbtnNewToggleButton);

		JButton btnOpenGlass = new JButton("Open Glass");
		btnOpenGlass.setPreferredSize(new Dimension(97, 50));
		panel_6.add(btnOpenGlass);

		JButton btnCloseGlass = new JButton("Close Glass");
		btnCloseGlass.setPreferredSize(new Dimension(97, 50));
		panel_6.add(btnCloseGlass);

		JPanel panel_Device_dp = new JPanel();
		panel_4.add(panel_Device_dp, "name_172331696662152");
		panel_Device_dp.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_Device_dp.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Air Condition", null, panel_7, null);
		panel_7.setLayout(null);

		JPanel panel_11 = new JPanel();
		panel_11.setBounds(188, 295, 461, 82);
		panel_7.add(panel_11);

		JToggleButton tglbtnPowerOn = new JToggleButton("Power On");
		tglbtnPowerOn.setPreferredSize(new Dimension(89, 50));
		panel_11.add(tglbtnPowerOn);

		JButton btnTemp = new JButton("Temp +");
		btnTemp.setPreferredSize(new Dimension(77, 50));
		panel_11.add(btnTemp);

		JButton btnTemp_1 = new JButton("Temp -");
		btnTemp_1.setPreferredSize(new Dimension(75, 50));
		panel_11.add(btnTemp_1);

		JLabel lblStatus_1 = new JLabel("Status: ");
		lblStatus_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblStatus_1.setBounds(297, 47, 85, 70);
		panel_7.add(lblStatus_1);

		JLabel lblTemperature = new JLabel("Temperature:");
		lblTemperature.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTemperature.setBounds(297, 124, 118, 47);
		panel_7.add(lblTemperature);

		JLabel lblStatusvalue = new JLabel("StatusValue");
		lblStatusvalue.setBounds(431, 76, 85, 16);
		panel_7.add(lblStatusvalue);

		JLabel lblTempvalue = new JLabel("TempValue");
		lblTempvalue.setBounds(427, 141, 85, 16);
		panel_7.add(lblTempvalue);

		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("Rear Camera", null, panel_8, null);
		panel_8.setLayout(null);

		JPanel panel_12 = new JPanel() {
			@Override
			public void paint(Graphics g) {
				System.out.println(2);
				if (image != null) {
					System.out.println(1);
					g.drawImage(image, 0, 0, this);
				}
			}
		};

		panel_12.setBounds(238, 13, 365, 338);
		panel_12.setLayout(new BorderLayout(0, 0));
		VideoCapture videoCap = new VideoCapture();

		videoCap.set(Videoio.CAP_PROP_FRAME_WIDTH, 320);
		videoCap.set(Videoio.CAP_PROP_FRAME_HEIGHT, 240);
		Mat temp = new Mat();
		panel_8.add(panel_12);

		JButton btnStartCamera = new JButton("Start Camera");
		btnStartCamera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				videoCap.open(0);
				videoCap.read(temp);
				// ImageIcon icon = new ImageIcon();

				while (videoCap.read(temp)) {
					image = toBufferedImage(temp);
					// System.out.println(image.toString());
					panel_12.repaint();
					break;
					// System.out.println("ahuhu");
					// videoLabel.setIcon(toBufferedImage(temp));

					// videoLabel.setIcon(icon);

				}
			}
		});
		btnStartCamera.setBounds(372, 412, 97, 25);
		panel_8.add(btnStartCamera);

		JPanel panel_9 = new JPanel();
		tabbedPane.addTab("Device 3", null, panel_9, null);

		JPanel panel_10 = new JPanel();
		tabbedPane.addTab("Device 4", null, panel_10, null);

		JPanel panel_Util_dp = new JPanel();
		panel_4.add(panel_Util_dp, "name_172333993343338");

		JPanel panel_Nav_dp = new JPanel();
		// Browser browser = new Browser();
		// panel_Nav_dp.setLayout(new BorderLayout(0, 0));
		// BrowserView view = new BrowserView(browser);
		// panel_Nav_dp.add(view);
		// browser.loadURL("http://maps.google.com");
		panel_4.add(panel_Nav_dp, "name_172335601776851");
	}

	private void displayPanel(int order) {
		for (int i = 0; i < 4; i++) {
			((javax.swing.Box) ((javax.swing.Box) (frame.getContentPane().getComponent(0))) // Horizontal
																							// Box
					.getComponent(0)) // Vertical Box
							.getComponent(i).setBackground(Color.GRAY);
		}

		JPanel panel = ((JPanel) ((javax.swing.Box) (frame.getContentPane().getComponent(0))).getComponent(1));
		if (order == 0)
			((CardLayout) panel.getLayout()).show(panel, "name_172318794265353");
		if (order == 1)
			((CardLayout) panel.getLayout()).show(panel, "name_172331696662152");
		if (order == 2)
			((CardLayout) panel.getLayout()).show(panel, "name_172333993343338");
		if (order == 3)
			((CardLayout) panel.getLayout()).show(panel, "name_172335601776851"); // panel_4/panel(order)
	}

	public Image toBufferedImage(Mat m) {
		int type = BufferedImage.TYPE_BYTE_GRAY;
		if (m.channels() > 1) {
			type = BufferedImage.TYPE_3BYTE_BGR;
		}
		int bufferSize = m.channels() * m.cols() * m.rows();
		byte[] b = new byte[bufferSize];
		m.get(0, 0, b); // get all the pixels
		System.out.println(b.length);
		// BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
		// final byte[] targetPixels = ((DataBufferByte)
		// image.getRaster().getDataBuffer()).getData();
		// System.arraycopy(b, 0, targetPixels, 0, b.length);
		// BufferedImage resizedImage = new BufferedImage(320, 240, type);
		// Graphics2D g = resizedImage.createGraphics();
		// g.drawImage(image, 0, 0, 320, 240, null);
		// g.dispose();
		// image.
		// image.copyData(System.arraycopy(b, 0, targetPixels, 0, b.length));
		// System.out.println(targetPixels.length);
		return new ImageIcon(b).getImage();

	}
}
