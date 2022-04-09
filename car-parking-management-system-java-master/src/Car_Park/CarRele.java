package Car_Park;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class CarRele {

	public static ArrayList<carpark> car = new ArrayList<carpark>();
	
	private JFrame frmCarRelease;
	private JTextField carNmbr;
	private JTextField name1;
	private JTextField cell1;
	private JTextField place;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarRele window = new CarRele();
					window.frmCarRelease.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CarRele() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCarRelease = new JFrame();
		frmCarRelease.getContentPane().setBackground(Color.WHITE);
		frmCarRelease.setTitle("CAR RELEASE");
		frmCarRelease.setBounds(100, 100, 761, 442);
		frmCarRelease.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCarRelease.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("PARKING MANAGEMENT SYSTEM");
		label.setForeground(new Color(128, 0, 0));
		label.setFont(new Font("Adobe Caslon Pro", Font.BOLD, 17));
		label.setBounds(43, 0, 352, 44);
		frmCarRelease.getContentPane().add(label);
		
		JButton CRbtnHome = new JButton("HOME");
		CRbtnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm= new Home();   // calling home window will come.
				Home.main(null);
				frmCarRelease.setVisible(false);
			}
		});
		CRbtnHome.setFont(new Font("Sitka Text", Font.BOLD, 11));
		CRbtnHome.setBounds(0, 46, 186, 30);
		frmCarRelease.getContentPane().add(CRbtnHome);
		
		JButton CRbtnCarPa = new JButton("CAR PARKING");
		CRbtnCarPa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarParking cp= new CarParking();   //calling car parking window will come.
				CarParking.main(null);
				frmCarRelease.setVisible(false);
			}
		});
		CRbtnCarPa.setFont(new Font("Sitka Text", Font.BOLD, 11));
		CRbtnCarPa.setBounds(186, 46, 186, 30);
		frmCarRelease.getContentPane().add(CRbtnCarPa);
		
		JButton CRbtnCarRe = new JButton("CAR RELEASE");
		CRbtnCarRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarRele cr= new CarRele();   //calling car release window will come.
				CarRele.main(null);
				frmCarRelease.setVisible(false);
			}
		});
		CRbtnCarRe.setFont(new Font("Sitka Text", Font.BOLD, 11));
		CRbtnCarRe.setBounds(372, 46, 186, 30);
		frmCarRelease.getContentPane().add(CRbtnCarRe);
		
		
		JButton CRbtnLogout = new JButton("LOG OUT");
		CRbtnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGIN li= new LOGIN();
				LOGIN.main(null);
				frmCarRelease.setVisible(false);
			}
		});
		CRbtnLogout.setFont(new Font("Sitka Text", Font.BOLD, 11));
		CRbtnLogout.setBounds(558, 46, 186, 30);
		frmCarRelease.getContentPane().add(CRbtnLogout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\OOP\\CAR\\car-parking-management-system-java-master\\picture\\logo 2.png"));
		lblNewLabel.setBounds(10, 0, 46, 44);
		frmCarRelease.getContentPane().add(lblNewLabel);
		
		JTextPane carnmbr = new JTextPane();
		carnmbr.setBackground(Color.GRAY);
		carnmbr.setText("CAR NUMBER:");
		carnmbr.setFont(new Font("Sitka Text", Font.BOLD, 11));
		carnmbr.setBounds(10, 98, 89, 20);
		frmCarRelease.getContentPane().add(carnmbr);
		
		carNmbr = new JTextField();
		carNmbr.setColumns(10);
		carNmbr.setBackground(SystemColor.inactiveCaptionBorder);
		carNmbr.setBounds(103, 98, 178, 20);
		frmCarRelease.getContentPane().add(carNmbr);
		
		JTextPane name = new JTextPane();
		name.setBackground(Color.GRAY);
		name.setText("NAME:");
		name.setFont(new Font("Sitka Text", Font.BOLD, 11));
		name.setBounds(10, 129, 73, 20);
		frmCarRelease.getContentPane().add(name);
		
		name1 = new JTextField();
		name1.setColumns(10);
		name1.setBackground(SystemColor.inactiveCaptionBorder);
		name1.setBounds(103, 129, 178, 20);
		frmCarRelease.getContentPane().add(name1);
		
		JTextPane cellname = new JTextPane();
		cellname.setBackground(Color.GRAY);
		cellname.setText("CELL No");
		cellname.setFont(new Font("Sitka Text", Font.BOLD, 11));
		cellname.setBounds(10, 160, 85, 20);
		frmCarRelease.getContentPane().add(cellname);
		
		cell1 = new JTextField();
		cell1.setColumns(10);
		cell1.setBackground(SystemColor.inactiveCaptionBorder);
		cell1.setBounds(103, 160, 178, 20);
		frmCarRelease.getContentPane().add(cell1);
		
		JTextPane placeNum = new JTextPane();
		placeNum.setBackground(Color.GRAY);
		placeNum.setText("PLACE No:");
		placeNum.setFont(new Font("Sitka Text", Font.BOLD, 11));
		placeNum.setBounds(10, 191, 85, 20);
		frmCarRelease.getContentPane().add(placeNum);
		
		place = new JTextField();
		place.setColumns(10);
		place.setBackground(SystemColor.inactiveCaptionBorder);
		place.setBounds(103, 191, 69, 20);
		frmCarRelease.getContentPane().add(place);
		
		JButton select = new JButton("Select");
		select.setBackground(new Color(204, 153, 255));
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			try {
					
					FileReader fr=new FileReader("carpark.txt");
					BufferedReader br=new BufferedReader(fr);
					String in=br.readLine();
					//System.out.println(in);
					String filename = "D:\\OOP\\CAR\\car-parking-management-system-java-master\\carpark.txt";
					String content = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
					String m=carNmbr.getText();
//					String m1=name1.getText();
//				    String m2=cell1.getText();
				    String m3=place.getText();
				    //System.out.println(content);
				    ArrayList<String> lines = new ArrayList<>();
				    try(Stream<String> stream = Files.lines(Paths.get(filename),StandardCharsets.UTF_8)){//đưa về dạng chuẩn utf8
				    	
						stream.forEach(line ->{
							lines.add(line);
						});
					} catch (Exception e) {
						e.printStackTrace();
					}
				    int i=0;
				    //System.out.println(lines);
				    String[] arr = lines.toArray(new String[0]);
				    //System.out.println(arr);
				    int dem=0;
					while(i<lines.size()){
						int dem1=0;
						if(i==lines.size()-1)dem1=1;
						String[] prts = arr[i].split(" ");
//						for(int j=0; j<7; j++) {
//							System.out.println(prts[j]);
//						}
						//System.out.println(prts);
						for(int j=0; j<7; j++) {
							if(prts[j].equals(m3)){
								JOptionPane.showMessageDialog(null, "INFORMATION MATCHED","Release Successfull",JOptionPane.ERROR_MESSAGE);
								popup po= new popup();   // calling home window will come.
								popup.main(null);
								dem=1;
//								String filename2 = "D:\\OOP\\CAR\\car-parking-management-system-java-master\\carpark.txt";
//								filename2.delete();
//								File file = new File("D:\\OOP\\CAR\\car-parking-management-system-java-master\\carpark.txt");
								break;
							}
						}
						if(dem==0){
							if(dem1==1) {
								JOptionPane.showMessageDialog(null, "INVALID INFORMATION","Release Corupted",JOptionPane.ERROR_MESSAGE);
								break;
							}
						}
						i++;
					}
					   in=br.readLine();
			
						br.close();
					}
			
					catch(Exception e){
					e.printStackTrace();
					}
			
			
				
//				Object obj = arg0.getSource();
//				if(obj== select) {
//					carpark temp;
//					boolean t= false;
//					for(int i=0; i<car.size();i++) {
//						if(car.get(i).carnum.equals(carNmbr.getText())) {
//							t=true;
//							temp= car.get(i);
//							JOptionPane.showMessageDialog(null, "INFORMATION MATCHED","Release Successfull",JOptionPane.ERROR_MESSAGE);
//						}
//						
//						
//					}
//					if(t==true) {
//						JOptionPane.showMessageDialog(null, "INFORMATION MATCHED","Release Successfull",JOptionPane.ERROR_MESSAGE);
//					}
//					else {
//						JOptionPane.showMessageDialog(null, "INVALID INFORMATION","Release Corupted",JOptionPane.ERROR_MESSAGE);
//					}
//					
//				}
				
				//JOptionPane.showMessageDialog(null, "Invalid username or password","Login Error",JOptionPane.ERROR_MESSAGE);
			
			}
		});
		select.setBounds(83, 278, 89, 23);
		frmCarRelease.getContentPane().add(select);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\OOP\\CAR\\car-parking-management-system-java-master\\picture\\fffff.jpg"));
		lblNewLabel_1.setBounds(0, 72, 745, 331);
		frmCarRelease.getContentPane().add(lblNewLabel_1);
	}
}
