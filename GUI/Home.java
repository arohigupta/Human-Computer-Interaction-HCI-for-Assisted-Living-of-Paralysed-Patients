import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import resources.Sqlite_connection;
import sun.audio.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import com.mysql.jdbc.PreparedStatement;

import javazoom.jl.player.Player;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;


public class Home extends JFrame{
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel contentPane;
	JButton EMERGENCY = new JButton(" EMERGENCY");
	JButton FAN = new JButton("FAN");
	JButton WASHROOM = new JButton("WASHROOM CALL");
	JButton WATER = new JButton("WATER");
	JButton LIGHTS = new JButton("LIGHTS");
	JButton TEXT = new JButton("TEXT EDITOR");
	JButton CLOSE = new JButton("SLEEP");
	
	 
	    
	static int count=0;
	boolean flag = true;
	String current_focus = "EMERGENCY";
	long count2;
	int a[] = new int[4];
	int entry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
					EventQueue.invokeLater(new Runnable(){
						public void run() {
						frame.core(frame);
						}
					});
					
					
				//core();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 
	Connection connection = null;
	
	
	public Home() throws InterruptedException {
		setTitle("frame");
		connection = Sqlite_connection.dbconnector();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 697, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 51, 51));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		EMERGENCY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		EMERGENCY.setForeground(Color.BLACK);
		
		
		EMERGENCY.setFocusable(true);
		if(EMERGENCY.isFocusable()){}
		FAN.setFocusable(false);
		WASHROOM.setFocusable(false);
		if(WASHROOM.isFocusable()){System.out.println("asdwdcaewfefgaergad");}
		WATER.setFocusable(false);
		LIGHTS.setFocusable(false);
		TEXT.setFocusable(false);
		CLOSE.setFocusable(false);
		CLOSE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				flag = false;
				
			}
		});
		
		
		
	  
		
		EMERGENCY.setIcon(new ImageIcon("C:\\Users\\Arohi\\workspace\\HCI\\emergency.jpg"));
	
		
		EMERGENCY.setBounds(10, 76, 169, 159);
		
		contentPane.add(EMERGENCY);
		
	
		WATER.setIcon(new ImageIcon("C:\\Users\\Arohi\\workspace\\HCI\\water.jpg"));
		WATER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				FileInputStream Fis = new FileInputStream("C:\\Users\\Arohi\\workspace\\HCI\\glass.mp3");
				Player playMp3 = new Player(Fis);
				playMp3.play();
				
			}
				catch (Exception e1){
					System.out.println(e1);
				}
			}
		});
		WATER.setBounds(465, 280, 133, 159);
		contentPane.add(WATER);
		
		LIGHTS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				FileInputStream Fis = new FileInputStream("C:\\Users\\Arohi\\workspace\\HCI\\light.mp3");
				Player playMp3 = new Player(Fis);
				playMp3.play();
				
			}
				catch (Exception e1){
					System.out.println(e1);
				}
			}
		});
		LIGHTS.setIcon(new ImageIcon("C:\\Users\\Arohi\\workspace\\HCI\\Light-Bulb.jpg"));
		LIGHTS.setBounds(10, 280, 169, 159);
		contentPane.add(LIGHTS);
		
		
		FAN.setIcon(new ImageIcon("C:\\Users\\Arohi\\workspace\\HCI\\fan.jpg"));
		FAN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				FileInputStream Fis = new FileInputStream("C:\\Users\\Arohi\\workspace\\HCI\\fan.mp3");
				Player playMp3 = new Player(Fis);
				playMp3.play();
				
			}
				catch (Exception e1){
					System.out.println(e1);
				}
			}
		});
		FAN.setBounds(244, 280, 146, 159);
		contentPane.add(FAN);
		
		
		TEXT.setIcon(new ImageIcon("C:\\Users\\Arohi\\workspace\\HCI\\text.png"));
		
		TEXT.setBounds(452, 79, 146, 152);
		contentPane.add(TEXT);
		
		
		WASHROOM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				FileInputStream Fis = new FileInputStream("C:\\Users\\Arohi\\workspace\\HCI\\washroom.mp3");
				Player playMp3 = new Player(Fis);
				playMp3.play();
				
			}
				catch (Exception e1){
					System.out.println(e1);
				}
			}
		});
		WASHROOM.setIcon(new ImageIcon("C:\\Users\\Arohi\\workspace\\HCI\\washroom.png"));
		
		WASHROOM.setBounds(252, 79, 138, 152);
		contentPane.add(WASHROOM);
		
		
		CLOSE.setBounds(488, 11, 110, 32);
		contentPane.add(CLOSE);
		
		
		
		 
		
	
 }	
	
	
	
	String button_infocus(){
		
		if(WASHROOM.isFocusable()){
			
			return "WASHROOM";
		}
		if(WATER.isFocusable()) {
			
			return "WATER";
		}
		if(EMERGENCY.isFocusable()){
		
						return "EMERGENCY";
			}
		
		
		if(LIGHTS.isFocusable()) {
			
			return "LIGHTS";
		}
		if(TEXT.isFocusable()) {
			
			return "TEXT";
		}
		if(CLOSE.isFocusable()){
			
			return "CLOSE";
		}
		
		if(FAN.isFocusable()){
			
			return "FAN";
		}
		
		
		
		return "CLOSE";	
		
	}
	
	
	
	String focuson_next(String s){
		switch(s){
		case "EMERGENCY": {
			EMERGENCY.setFocusable(false); 
			
			WASHROOM.setFocusable(true);
			
			LIGHTS.setFocusable(false); 
			TEXT.setFocusable(false);
			FAN.setFocusable(false); 
			CLOSE.setFocusable(false);
			WATER.setFocusable(false);
			return "WASHROOM";
		}
		           
		             
		case "WASHROOM": {
			
			WASHROOM.setFocusable(false); 
			LIGHTS.setFocusable(false);
			EMERGENCY.setFocusable(false); 
			TEXT.setFocusable(true);
			FAN.setFocusable(false); 
			CLOSE.setFocusable(false);
			WATER.setFocusable(false);
			return "TEXT";
			
		}
		             
		
		case "TEXT": {
			TEXT.setFocusable(false); 
			LIGHTS.setFocusable(true);
			WASHROOM.setFocusable(false); 
			EMERGENCY.setFocusable(false); 
			FAN.setFocusable(false); 
			CLOSE.setFocusable(false);
			WATER.setFocusable(false);
			return "LIGHTS";
			
		} 
		             
		             
		case "LIGHTS": {
			LIGHTS.setFocusable(false); 
			FAN.setFocusable(true);
			WASHROOM.setFocusable(false); 
			EMERGENCY.setFocusable(false); 
			TEXT.setFocusable(false);
			CLOSE.setFocusable(false);
			WATER.setFocusable(false);
			return "FAN";
			
		}
		
		case "FAN": {
			FAN.setFocusable(false); 
			WATER.setFocusable(true);
			WASHROOM.setFocusable(false); 
			LIGHTS.setFocusable(false);
			EMERGENCY.setFocusable(false); 
			TEXT.setFocusable(false);
			CLOSE.setFocusable(false);
			WATER.setFocusable(false);
			return "WATER";
			
		}
		
		case "WATER":{
			WATER.setFocusable(false); 
			CLOSE.setFocusable(true);
			WASHROOM.setFocusable(false); 
			LIGHTS.setFocusable(false);
			EMERGENCY.setFocusable(false); 
			TEXT.setFocusable(false);
			FAN.setFocusable(false); 
			return "CLOSE";
			
		}
		
		case "CLOSE":{
			CLOSE.setFocusable(false); 
			EMERGENCY.setFocusable(true);
			WASHROOM.setFocusable(false); 
			LIGHTS.setFocusable(false); 
			TEXT.setFocusable(false);
			FAN.setFocusable(false); 
			WATER.setFocusable(false);
			return "EMERGENCY";
			
		}
		
		
		             
		
		}
		
		return "none";
		
	}

	
	void core(JFrame f){


		
while(count2!=10000){
	
	
			entry=0;
			java.sql.PreparedStatement pst = null;
			//System.out.println(4);
			try{
			String query = "SELECT * FROM threeorfive";
				pst =  connection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				while(rs.next()){
		
					a[entry]=rs.getInt(4);
					//System.out.println(a[entry]);
			        entry++;
					
				}
				
				//System.out.println(5);
				
				if(a[0]==1 && a[1]==1)
					{
					current_focus = button_infocus();
					

					System.out.println("Focus on :");
					  System.out.println(current_focus);
					  
						  
						
					}
				
				else if(a[0]==0 && a[1]==1){
					
				    current_focus = button_infocus();
					current_focus = focuson_next(current_focus);
					System.out.println("Focus on :");
					System.out.println(current_focus);
					FileInputStream Fis1 = new FileInputStream("C:\\Users\\Arohi\\workspace\\HCI\\3second.mp3");
					Player playMp32 = new Player(Fis1);
					playMp32.play();
					
					String query2 = "UPDATE threeorfive set value=1 WHERE ID=1 ";	
					java.sql.PreparedStatement pst2 = connection.prepareStatement(query2);
					pst2.execute();
					
					String query3 = "UPDATE threeorfive set value= 1 WHERE ID= 2  " ;	
					java.sql.PreparedStatement pst3 = connection.prepareStatement(query3);
					pst3.execute();
					
					
				}
				
				else if(a[0]==1 && a[1]==0){
					FileInputStream Fis2 = new FileInputStream("C:\\Users\\Arohi\\workspace\\HCI\\5second.mp3");
					Player playMp321 = new Player(Fis2);
					playMp321.play();
					
					if(current_focus.equals("EMERGENCY")){
                    try{
							
							FileInputStream Fis = new FileInputStream("C:\\Users\\Arohi\\workspace\\HCI\\Emergency.mp3");
							Player playMp3 = new Player(Fis);
							playMp3.play();
							
						}
							catch (Exception e1){
								System.out.println(e1);
							}			
						
						
						
					}else if(current_focus.equals("WASHROOM")){
						try{
							
							FileInputStream Fis = new FileInputStream("C:\\Users\\Arohi\\workspace\\HCI\\washroom.mp3");
							Player playMp3 = new Player(Fis);
							playMp3.play();
							
						}
							catch (Exception e1){
								System.out.println(e1);
							}
						
					}
					else if(current_focus.equals("TEXT")){
						//JOptionPane.showMessageDialog(null, "text");
					System.out.println("text");
						
						

						

						
						
						
					}else if(current_focus.equals("LIGHTS")){
						try{
							
							FileInputStream Fis = new FileInputStream("C:\\Users\\Arohi\\workspace\\HCI\\light.mp3");
							Player playMp3 = new Player(Fis);
							playMp3.play();
							String query4 = "UPDATE threeorfive set value=0 WHERE ID=3 ";	
							java.sql.PreparedStatement pst4 = connection.prepareStatement(query4);
							pst4.execute();
							
							
						}
							catch (Exception e1){
								System.out.println(e1);
							}
						
						
					}else if(current_focus.equals("FAN")){
						try{
							FileInputStream Fis = new FileInputStream("C:\\Users\\Arohi\\workspace\\HCI\\fan.mp3");
							Player playMp3 = new Player(Fis);
							playMp3.play();
							
						}
							catch (Exception e1){
								System.out.println(e1);
							}
						
						}else if(current_focus.equals("WATER")){
							try{
								FileInputStream Fis = new FileInputStream("C:\\Users\\Arohi\\workspace\\HCI\\glass.mp3");
								Player playMp3 = new Player(Fis);
								playMp3.play();
								
							}
								catch (Exception e1){
									System.out.println(e1);
								}
							
							
							
						}else if(current_focus.equals("CLOSE")){
							f.dispose();
							System.exit(0);
							
						}else ;
					
					String query2 = "UPDATE threeorfive set value=1 WHERE ID=1 ";	
					java.sql.PreparedStatement pst2 = connection.prepareStatement(query2);
					pst2.execute();
					
					String query3 = "UPDATE threeorfive set value= 1 WHERE ID= 2  " ;	
					java.sql.PreparedStatement pst3 = connection.prepareStatement(query3);
				    pst3.execute();
					
					
					
				}else {
					a[0]=1;
					a[1]=1;
				}
				
			
				try {
				    Thread.sleep(1000);  //1000 milliseconds is one second.
				    count2++;
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}

										
				
			}catch(Exception  e){
				JOptionPane.showMessageDialog(null, e);
			}
			
	
			
		}

 

 
	
}
	
}
	
