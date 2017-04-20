package x_simulator;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 950, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		JLabel lblStatusvalue = new JLabel("OFF");
		JLabel label = new JLabel("25");
		JButton btnTemp = new JButton("Temp +");
		btnTemp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Toolkit.getDefaultToolkit().beep();
				int i = Integer.parseInt(label.getText());
				if(i<30) i++;
				label.setText(Integer.toString(i));
			}
		});
		btnTemp.setEnabled(false);
		JButton btnTemp_1 = new JButton("Temp -");
		btnTemp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Toolkit.getDefaultToolkit().beep();
				int i = Integer.parseInt(label.getText());
				if(i>=17) i--;
				label.setText(Integer.toString(i));
			}
		});
		btnTemp_1.setEnabled(false);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setName("horBox");
		frame.getContentPane().add(horizontalBox);

		Box verticalBox = Box.createVerticalBox();
		horizontalBox.add(verticalBox);

		JPanel panel_device = new JPanel();
		panel_device.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(30, 144, 255), new Color(0, 0, 255)));
		panel_device.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayPanel(0);
				panel_device.setBackground(Color.WHITE);
			}
		});
		panel_device.setPreferredSize(new Dimension(100, 10));
		panel_device.setBackground(new Color(128, 128, 128));
		verticalBox.add(panel_device);
		panel_device.setLayout(null);

		JLabel lblSecurity = new JLabel("Device");
		lblSecurity.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSecurity.setBounds(12, 77, 76, 31);
		panel_device.add(lblSecurity);

		JPanel panel_Utilities = new JPanel();
		panel_Utilities.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(30, 144, 255), new Color(0, 0, 139)));
		panel_Utilities.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayPanel(1);
				panel_Utilities.setBackground(Color.WHITE);
			}
		});
		panel_Utilities.setPreferredSize(new Dimension(100, 10));
		panel_Utilities.setBackground(new Color(128, 128, 128));
		verticalBox.add(panel_Utilities);
		panel_Utilities.setLayout(null);

		JLabel lblUtilities = new JLabel("Utilities");
		lblUtilities.setFont(new Font("Arial", Font.PLAIN, 20));
		lblUtilities.setBounds(12, 86, 76, 16);
		panel_Utilities.add(lblUtilities);

		JPanel panel_Navigator = new JPanel();
		panel_Navigator.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(30, 144, 255), new Color(0, 0, 255)));
		panel_Navigator.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayPanel(2);
				panel_Navigator.setBackground(Color.WHITE);
			}
		});
		panel_Navigator.setPreferredSize(new Dimension(100, 10));
		panel_Navigator.setBackground(new Color(128, 128, 128));
		verticalBox.add(panel_Navigator);
		panel_Navigator.setLayout(null);

		JLabel lblNewLabel = new JLabel("Navigator");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		lblNewLabel.setBounds(12, 88, 88, 24);
		panel_Navigator.add(lblNewLabel);

		JPanel panel_4 = new JPanel();
		horizontalBox.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));

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

		JToggleButton tglbtnPowerOn = new JToggleButton("Power");
		tglbtnPowerOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tglbtnPowerOn.isSelected())
				{
					playSound("airconditioner_on.wav");
					lblStatusvalue.setText("ON");
					btnTemp.setEnabled(true);
					btnTemp_1.setEnabled(true);
				}
				else 
				{
					playSound("airconditioner_off.wav");
					lblStatusvalue.setText("OFF");
					btnTemp.setEnabled(false);
					btnTemp_1.setEnabled(false);
				}
					
			}
		});
		
		tglbtnPowerOn.setPreferredSize(new Dimension(89, 50));
		panel_11.add(tglbtnPowerOn);

		
		btnTemp.setPreferredSize(new Dimension(77, 50));
		panel_11.add(btnTemp);

		
		btnTemp_1.setPreferredSize(new Dimension(75, 50));
		panel_11.add(btnTemp_1);

		JLabel lblStatus_1 = new JLabel("Status: ");
		lblStatus_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblStatus_1.setBounds(297, 47, 118, 70);
		panel_7.add(lblStatus_1);

		JLabel lblTemperature = new JLabel("Temperature:");
		lblTemperature.setFont(new Font("Arial", Font.PLAIN, 30));
		lblTemperature.setBounds(213, 124, 202, 47);
		panel_7.add(lblTemperature);

		
		lblStatusvalue.setFont(new Font("Arial", Font.PLAIN, 30));
		lblStatusvalue.setBounds(430, 68, 147, 29);
		panel_7.add(lblStatusvalue);
		
		
		label.setFont(new Font("Arial", Font.PLAIN, 30));
		label.setBounds(427, 133, 147, 29);
		panel_7.add(label);

		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("Rear Camera", null, panel_8, null);
		panel_8.setLayout(null);

		Main panel_12 = new Main();
		panel_12.setBackground(Color.LIGHT_GRAY);

		panel_12.setBounds(186, 14, 451, 424);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		Mat temp = new Mat();
		panel_8.add(panel_12);

		JButton btnStartCamera = new JButton("Start Camera");
		
		btnStartCamera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnStartCamera.isEnabled())
			{
				if(btnStartCamera.getText().equals("Start Camera"))
					
					{
						btnStartCamera.setText("Stop Camera");
						btnStartCamera.setEnabled(false);
						playSound("rearcamera_on.wav");
						panel_12.initCamera();
						btnStartCamera.setEnabled(true);
					}
					else
					{
						panel_12.stop();
						btnStartCamera.setText("Start Camera");
						btnStartCamera.setEnabled(false);
						playSound("rearcamera_off.wav");
						btnStartCamera.setEnabled(true);
					}
				
				}
			}
		});

		
		btnStartCamera.setBounds(361, 454, 109, 45);
		panel_8.add(btnStartCamera);

		JPanel panel_9 = new JPanel();
		tabbedPane.addTab("Device 3", null, panel_9, null);

		JPanel panel_10 = new JPanel();
		tabbedPane.addTab("Device 4", null, panel_10, null);

		JPanel panel_Util_dp = new JPanel();
		panel_4.add(panel_Util_dp, "name_172333993343338");
		panel_Util_dp.setLayout(new BorderLayout(0, 0));
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		panel_Util_dp.add(horizontalBox_1);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setPreferredSize(new Dimension(-450, 0));
		horizontalBox_1.add(verticalBox_1);
		JPanel panel = new JPanel();
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				((CardLayout)panel.getLayout()).show(panel, "name_343166705630381");
			}
		});
		verticalBox_1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Smart antithieft");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 34, 218, 49);
		panel_1.add(lblNewLabel_1);
		
		JToggleButton tglbtnOn = new JToggleButton("ON");
		tglbtnOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tglbtnOn.isSelected())
				{
					playSound("smartantitheft_on.wav");
					tglbtnOn.setText("OFF");
				}
				else 
					{
					playSound("smartantitheft_off.wav");
					tglbtnOn.setText("ON");
					}
			}
		});
		tglbtnOn.setBounds(12, 82, 67, 48);
		panel_1.add(tglbtnOn);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				((CardLayout)panel.getLayout()).show(panel, "name_343194074161899");
			}
		});
		verticalBox_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSmartWindscreenWipers = new JLabel("Smart windscreen wipers");
		lblSmartWindscreenWipers.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSmartWindscreenWipers.setBounds(12, 30, 300, 49);
		panel_2.add(lblSmartWindscreenWipers);
		
		JToggleButton toggleButton = new JToggleButton("ON");
		toggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(toggleButton.isSelected()) 
					{
					playSound("smartwindscreenwipers_on.wav");
					toggleButton.setText("OFF");
					}
				else 
				{
					playSound("smartwindscreenwipers_off.wav");
					toggleButton.setText("ON");
				}
			}
		});
		toggleButton.setBounds(12, 78, 67, 52);
		panel_2.add(toggleButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				((CardLayout)panel.getLayout()).show(panel, "name_343209872829260");
			}
		});
		verticalBox_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblAutoAdjustFlashlight = new JLabel("Auto adjust FlashLight");
		lblAutoAdjustFlashlight.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAutoAdjustFlashlight.setBounds(12, 26, 300, 49);
		panel_3.add(lblAutoAdjustFlashlight);
		
		JToggleButton toggleButton_1 = new JToggleButton("ON");
		toggleButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(toggleButton_1.isSelected()) 
					{
					playSound("autoadjustflashlight_on.wav");
					toggleButton_1.setText("OFF");
					}
				else 
					{
					playSound("autoadjustflashlight_off.wav");
					toggleButton_1.setText("ON");
					}
			}
		});
		toggleButton_1.setBounds(12, 74, 67, 56);
		panel_3.add(toggleButton_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				((CardLayout)panel.getLayout()).show(panel, "name_343226222483365");
			}
		});
		verticalBox_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblLockButtonsWhen = new JLabel("Smart physical buttons control");
		lblLockButtonsWhen.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLockButtonsWhen.setBounds(12, 27, 325, 49);
		panel_5.add(lblLockButtonsWhen);
		
		JToggleButton toggleButton_2 = new JToggleButton("ON");
		toggleButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(toggleButton_2.isSelected()) 
				{
					playSound("smartphysicalbuttonscontrol_on.wav");
					toggleButton_2.setText("OFF");
				}
				else 
					{
					playSound("smartphysicalbuttonscontrol_off.wav");
					toggleButton_2.setText("ON");
					}
			}
		});
		toggleButton_2.setBounds(12, 73, 67, 57);
		panel_5.add(toggleButton_2);
		
		
		panel.setMaximumSize(new Dimension(32700, 32767));
		panel.setPreferredSize(new Dimension(-300, 10));
		horizontalBox_1.add(panel);
		panel.setSize(new Dimension(-300, 0));
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel antiTheftInfo = new JPanel();
		panel.add(antiTheftInfo, "name_343166705630381");
		antiTheftInfo.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("<html>When this feature is turned on, if this car is affected by external forces while the Smart Key is not in a radius of 5 meters, the car will emit alarm sounds</html>");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(33, 0, 420, 144);
		antiTheftInfo.add(lblNewLabel_2);
		
		JPanel windsScreenInfo = new JPanel();
		panel.add(windsScreenInfo, "name_343194074161899");
		windsScreenInfo.setLayout(null);
		
		JLabel lblwhenThisFeature = new JLabel("<html>When this feature is turned on, the wiper will automatically clears the windscreen when the windscreen is dirty or smudged</html>");
		lblwhenThisFeature.setFont(new Font("Arial", Font.PLAIN, 18));
		lblwhenThisFeature.setBounds(33, 141, 420, 144);
		windsScreenInfo.add(lblwhenThisFeature);
		
		JPanel adjustLightInfo = new JPanel();
		panel.add(adjustLightInfo, "name_343209872829260");
		adjustLightInfo.setLayout(null);
		
		JLabel lblwhenThisFeature_1 = new JLabel("<html>When this feature is turned on, the car will automatically adjust the light brightness and gradient so as not to divert people's eyes in the opposite direction</html>");
		lblwhenThisFeature_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblwhenThisFeature_1.setBounds(12, 289, 420, 144);
		adjustLightInfo.add(lblwhenThisFeature_1);
		
		JPanel lockButtonInfo = new JPanel();
		panel.add(lockButtonInfo, "name_343226222483365");
		lockButtonInfo.setLayout(null);
		
		JLabel lblwhenThisFeature_2 = new JLabel("<html>When this feature is turned on, the physical buttons will be disabled when both of driver's hands is on the steering wheel</html>");
		lblwhenThisFeature_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblwhenThisFeature_2.setBounds(12, 431, 420, 144);
		lockButtonInfo.add(lblwhenThisFeature_2);

		JPanel panel_Nav_dp = new JPanel();
		 Browser browser = new Browser();
		 panel_Nav_dp.setLayout(new BorderLayout(0, 0));
		 BrowserView view = new BrowserView(browser);
		 panel_Nav_dp.add(view);
		 browser.loadURL("http://maps.google.com");
		panel_4.add(panel_Nav_dp, "name_172335601776851");
	}

	private void displayPanel(int order) {
		for (int i = 0; i < 3; i++) {
			((javax.swing.Box) ((javax.swing.Box) (frame.getContentPane().getComponent(0))) // Horizontal
																							// Box
					.getComponent(0)) // Vertical Box
							.getComponent(i).setBackground(Color.GRAY);
		}

		JPanel panel = ((JPanel) ((javax.swing.Box) (frame.getContentPane().getComponent(0))).getComponent(1));
		if (order == 0)
			((CardLayout) panel.getLayout()).show(panel, "name_172331696662152");
		if (order == 1)
			((CardLayout) panel.getLayout()).show(panel, "name_172333993343338");
		if (order == 2)
			((CardLayout) panel.getLayout()).show(panel, "name_172335601776851");
	}
	
	public void changeTextForButton(JButton btn, String text)
	{
		btn.setText(text);
	}
	
	private void playSound(String filename)
	{
		 try {
	         // Open an audio input stream.           
	          File soundFile = new File(filename); //you could also get the sound file with an URL
	          AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
	         // Get a sound clip resource.
	         Clip clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         clip.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	}
}
