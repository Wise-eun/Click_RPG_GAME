import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Start extends JFrame {
   public SharedItem item = new SharedItem();
   String STR_string, DEX_string, INT_string;
   Random random = new Random();
   boolean IScenter = false; // Crc 생성후

   int make_screen = 0;

   int percent = 0; // 무기 확률
   int percent1 = 0; // 장비 확률
   int percent2 = 0; // 재료 확률

   boolean weapon_wearing = false;
   int bonus = 10;
   ////////////////////////////////////// Crc 기본창
   String name;

   int LEVEL = 1;
   String level;

   int EXP = 0, MAX_EXP = 100;
   String exp, max_exp;

   int HP = 100, MAX_HP = 100;
   String hp, max_hp;

   int LEFT_STAT = 0;
   String left_stat;

   int STR = 0, DEX = 0, INT = 0;
   JLabel stat1 = new JLabel(STR_string);
   JLabel stat2 = new JLabel(DEX_string);
   JLabel stat3 = new JLabel(INT_string);

   
   JLabel name_component = new JLabel(name);
   JLabel level_component = new JLabel(level);
    JLabel exp_component = new JLabel(exp);
    JLabel slash1 = new JLabel("/");
    JLabel maxexp_component = new JLabel(max_exp);
    JLabel hp_component = new JLabel(hp);
    JLabel slash2 = new JLabel("/");
   JLabel maxhp_component = new JLabel(max_hp);
   JLabel leftstat_component = new JLabel(left_stat);
   
   
   
   
   JLabel wearing_weapon = new JLabel("( +10 )");
   boolean wearing_sword = false;
   boolean wearing_bow = false;
   boolean wearing_wand = false;

/////////////////////////////////////////
   private Image screenImage;
   private Graphics screenGraphic;

   Image background = new ImageIcon(getClass().getResource("forest.png")).getImage();
   private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("upbar.png")));

   private ImageIcon startButtonBasic = new ImageIcon(Main.class.getResource("gameA.png"));
   private ImageIcon startButtonEnter = new ImageIcon(Main.class.getResource("games.png"));
   private ImageIcon startButtonClick = new ImageIcon(Main.class.getResource("gameCL.png"));

   private ImageIcon exitBtBasic = new ImageIcon(Main.class.getResource("exitButtonBasic.png"));
   private ImageIcon exitBtClick = new ImageIcon(Main.class.getResource("exitButtonClick.png"));
   private JButton exitButton = new JButton(exitBtBasic);
   
   
   private ImageIcon sound = new ImageIcon(Main.class.getResource("vol.png"));
   private ImageIcon nosound = new ImageIcon(Main.class.getResource("volx.png"));
   private boolean sound_play = true;
   

   ///////////////////////////////////////////////////////////////////////// MakeF 화면
   private ImageIcon makeBtBasic = new ImageIcon(Main.class.getResource("MakeF.png"));
   private ImageIcon makeBtClick = new ImageIcon(Main.class.getResource("MakeO.png"));
   private JButton makeButton = new JButton(makeBtBasic);

   private ImageIcon resetButton = new ImageIcon(Main.class.getResource("Rsf.png"));
   private ImageIcon resetClickedButton = new ImageIcon(Main.class.getResource("Rso.png"));

   private JButton startButton = new JButton(startButtonBasic);
   private JButton randomButton = new JButton(resetButton);
//////////////////////////////////////////////////////////////////////////////////////////메인 버튼들
   private ImageIcon fightBasic = new ImageIcon(Main.class.getResource("deonG.png"));
   private ImageIcon fightClick = new ImageIcon(Main.class.getResource("deonF.png"));

   private ImageIcon invenBasic = new ImageIcon(Main.class.getResource("InvF.png"));
   private ImageIcon invenClick = new ImageIcon(Main.class.getResource("InvO.png"));

   private ImageIcon updateBasic = new ImageIcon(Main.class.getResource("up1.png"));
   private ImageIcon updateClick = new ImageIcon(Main.class.getResource("up2.png"));

   private ImageIcon petBasic = new ImageIcon(Main.class.getResource("PetF.png"));
   private ImageIcon petClick = new ImageIcon(Main.class.getResource("PetO.png"));

   private ImageIcon offBasic = new ImageIcon(Main.class.getResource("EXF.png"));
   private ImageIcon offClick = new ImageIcon(Main.class.getResource("EXO.png"));

   private ImageIcon statUp = new ImageIcon(Main.class.getResource("StatU.png"));

   private JButton STRButton = new JButton(statUp);
   private JButton DEXButton = new JButton(statUp);
   private JButton INTButton = new JButton(statUp);

   private JButton fightButton = new JButton(fightBasic);
   private JButton invenButton = new JButton(invenBasic);
   private JButton updateButton = new JButton(updateBasic);
   private JButton petButton = new JButton(petBasic);
   private JButton offButton = new JButton(offBasic);
   ///////////////////////////////////////////////////////////////////////////////// Dech
   int where; // 무슨던전을 돌고있는지

   private ImageIcon fight1 = new ImageIcon(Main.class.getResource("ErebO.png"));
   private ImageIcon fight1Click = new ImageIcon(Main.class.getResource("Ereb.png"));

   private ImageIcon fight2 = new ImageIcon(Main.class.getResource("MinarO.png"));
   private ImageIcon fight2Click = new ImageIcon(Main.class.getResource("Minar.png"));

   private ImageIcon fight3 = new ImageIcon(Main.class.getResource("AcuaO.png"));
   private ImageIcon fight3Click = new ImageIcon(Main.class.getResource("Acua.png"));

   private ImageIcon fight4 = new ImageIcon(Main.class.getResource("TempleO.png"));
   private ImageIcon fight4Click = new ImageIcon(Main.class.getResource("Temple.png"));

   private ImageIcon fight5 = new ImageIcon(Main.class.getResource("GateO.png"));
   private ImageIcon fight5Click = new ImageIcon(Main.class.getResource("Gate.png"));

   private JButton fight1Button;
   private JButton fight2Button;
   private JButton fight3Button;
   private JButton fight4Button;
   private JButton fight5Button;

ImageIcon power = new ImageIcon(Main.class.getResource("power.png"));

   private int mouseX, mouseY;
   
   AudioInputStream stream;
   AudioFormat format;
   DataLine.Info info;

   Clip clip = null;

   
   
   boolean now_power_click = false;
   
   //////////////////////////////////////////////////////////////////////////////////아이템 그림들
   private ImageIcon sw = new ImageIcon(Main.class.getResource("sword.png"));
   private ImageIcon bo = new ImageIcon(Main.class.getResource("bow.png"));
   private ImageIcon wa = new ImageIcon(Main.class.getResource("wand.png"));
   private ImageIcon on = new ImageIcon(Main.class.getResource("clo.png"));
   private ImageIcon sh = new ImageIcon(Main.class.getResource("shoes.png"));
   private ImageIcon m1 = new ImageIcon(Main.class.getResource("Mat1.png"));
   private ImageIcon m2 = new ImageIcon(Main.class.getResource("Mat2.png"));
   private ImageIcon m3 = new ImageIcon(Main.class.getResource("Mat3.png"));
   private ImageIcon m4 = new ImageIcon(Main.class.getResource("Mat4.png"));
   private ImageIcon m5 = new ImageIcon(Main.class.getResource("Mat5.png"));
   private ImageIcon inven = new ImageIcon(Main.class.getResource("invc.jpg"));
   
   
   private ImageIcon powerButtonImage = new ImageIcon(Main.class.getResource("powerbutton.png"));
   private ImageIcon powerButtonClickImage = new ImageIcon(Main.class.getResource("powerbuttonClick.png"));
   JButton pmat = new JButton();
   JButton pitem = new JButton();
   JLabel power_percent = new JLabel("100%");
   JButton powerButton = new JButton();

   private ImageIcon back = new ImageIcon(Main.class.getResource("back.png"));
   private ImageIcon back_click = new ImageIcon(Main.class.getResource("back_click.png"));
   JButton backback = new JButton();
   
   JPanel power_item = new JPanel();
   
   
   
   public Start() {

	  

	      try {
	         stream = AudioSystem.getAudioInputStream(getClass().getResource("BGM.wav"));
	         format = stream.getFormat();
	         info = new DataLine.Info(Clip.class, format);
	         clip = (Clip) AudioSystem.getLine(info);
	         clip.open(stream);
	         clip.loop(-1);
	        
	      } catch (Exception e) {
	         System.out.println("err : " + e);
	      }


      setUndecorated(true);
      setTitle("RPG game");
      setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
      setResizable(false);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setBackground(new Color(0, 0, 0, 0));
      setLayout(null);
      
      sound = imageSetSize(sound, 20, 20);
      nosound = imageSetSize(nosound, 20, 20);
      JButton soundButton = new JButton(sound);
     
      soundButton.setBounds(5,350,20,20);
      soundButton.setBorderPainted(false);
      soundButton.setContentAreaFilled(false);
      soundButton.setFocusPainted(false);
      soundButton.setVisible(true);
      add(soundButton);
     
      soundButton.addMouseListener(new MouseAdapter() {
          @Override

          public void mouseEntered(MouseEvent e) {
         
             soundButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
          }

          @Override
          public void mouseExited(MouseEvent e) {
        	 
        	  soundButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
          }

          @Override
          public void mousePressed(MouseEvent e) {
        	  if(sound_play == true) {
        		  sound_play = false;
        	  soundButton.setIcon(nosound);
        	  clip.stop();
        	 
        	  }
        	  else if(sound_play == false){
        		  sound_play = true;
            	  soundButton.setIcon(sound);
            	  clip.loop(-1);
        	  }
          }

       });
      
      
      
      exitButton.setBounds(596, 0, 30, 20);
      exitButton.setBorderPainted(false);
      exitButton.setContentAreaFilled(false);
      exitButton.setFocusPainted(false);
      exitButton.addMouseListener(new MouseAdapter() {
         @Override

         public void mouseEntered(MouseEvent e) {
            exitButton.setIcon(exitBtClick);
            exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         }

         @Override
         public void mouseExited(MouseEvent e) {
            exitButton.setIcon(exitBtBasic);
            exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }

         @Override
         public void mousePressed(MouseEvent e) {

            System.exit(0);
         }

      });
      add(exitButton);
      menuBar.setBounds(0, 0, 626, 20);
      menuBar.addMouseListener(new MouseAdapter() {

         public void mouseEntered(MouseEvent e) {////////////////////////////////////////////////////////////////////////

        	 if(item.now_power == true) { // 강화버튼을 눌렀을 경우
        		
        		 if( now_power_click  == false) {
        			    power = imageSetSize(power, 626, 375);
                        background = new ImageIcon(Main.class.getResource("power.png")).getImage();
                        
                      
        		 exitMain(name_component, slash1, slash2, level_component, exp_component,
                         maxexp_component, hp_component, maxhp_component, leftstat_component, stat1,
                         stat2, stat3);
       
                   //new INV();
                   }
                   now_power_click = true;
                   
                   if(item.sword.now_power == true) {
                	 
                	  pitem .setBorderPainted(false);
                	  pitem .setContentAreaFilled(false);
                	  pitem .setFocusPainted(false);
                      
                	  sw =imageSetSize(sw,35,35);
                	  pitem.setIcon(sw);
                	  
                	   pitem.setBounds(180,175,35,35);
                	   pitem.setVisible(true);
                	   add(pitem);
                	                  
                   }
                   
                   if(item.mat1.use == true) {
                	   
                 	  
                	   pmat .setBorderPainted(false);
                	   pmat .setContentAreaFilled(false);
                	   pmat .setFocusPainted(false);
                       
                 	  m1 =imageSetSize(m1,35,35);
                 	 pmat.setIcon(m1);
                 	  
                 	pmat.setBounds(415,175,35,35);
                 	pmat.setVisible(true);
                 	   add(pmat);
                 	   
                 	  
                 	   power_percent.setForeground(Color.white);
                 	   power_percent.setBounds(300,250,50,30);
                 	   add(power_percent);
                 	   
            		 
            		   powerButton .setBorderPainted(false);
            		   powerButton .setContentAreaFilled(false);
            		   powerButton .setFocusPainted(false);
            		   powerButtonImage = imageSetSize( powerButtonImage,150,44);
            		   powerButton.setIcon(powerButtonImage);
            		   powerButton.setBounds(240,310,150,44);
            		   powerButton.setVisible(true);
            		   
            		   powerButton.addMouseListener(new MouseAdapter() {
           	            public void mouseEntered(MouseEvent e) {
           	            	powerButtonClickImage = imageSetSize( powerButtonClickImage,150,42);
           	            	powerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
           	            	powerButton.setIcon( powerButtonClickImage);
           	            }

           	            public void mouseExited(MouseEvent e) {
           	            	powerButton.setIcon( powerButtonImage);
           	            	powerButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
           	            }

           	            public void mousePressed(MouseEvent e) {
           	 ////강화시작!
           	            	background = new ImageIcon(Main.class.getResource("after_power.png")).getImage();
           	            	JLabel powerEffect = new JLabel();
           	            	ImageIcon pef = new ImageIcon(this.getClass().getResource("effect.gif"));
           	            	//pef = imageSetSize( pef,300,300);
           	            	powerEffect.setIcon(pef);
           	            
           	            	powerEffect.setBounds(90,15,352,285);
           	            	powerEffect.setVisible(true);
           	            	add(powerEffect);
           	            	
           	            	pitem.setVisible(false);
           	            	pmat.setVisible(false);
           	            	power_percent.setVisible(false);
           	            	powerButton.setVisible(false);
           	             
           	            	JLabel suc = new JLabel("강화 성공");
           	             suc.setForeground(Color.white);
           	          suc.setBounds(150,230,50,30);
           	          suc.setVisible(true);
                   	   add( suc);
                   	   
                   	   back = imageSetSize(back,150,42);
                   	   back_click =  imageSetSize(back_click,150,44);
                   	   backback.setIcon(back);
                   	   backback.setBounds(240,300,150,42);
                   	backback .setBorderPainted(false);
                   	backback .setContentAreaFilled(false);
                   	backback .setFocusPainted(false);
                   	   
                   	   
                   	 backback.addMouseListener(new MouseAdapter() {
         	            public void mouseEntered(MouseEvent e) {
         	            	backback.setIcon( back_click);
         	            	backback.setCursor(new Cursor(Cursor.HAND_CURSOR));
         	            }

         	            public void mouseExited(MouseEvent e) {
         	            	backback.setIcon( back);
         	            	backback.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         	            }

         	            public void mousePressed(MouseEvent e) {
         	   
         	  backback.setVisible(false);}
         	      });
                   	   
                   	add(backback);   	
           	            	
           	            }
           	      });
            		   
                       add(powerButton);
            	   }
                   
                   
        	 }
        	 
            //fightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); --- 지워도 되는거
        	 else if (item.sword.wear == true) {

               if (wearing_sword == false) {
                  STR += bonus;

                  STR_string = Integer.toString(STR);
                  stat1.setText(STR_string);
                  add(stat1);

               }
               if (wearing_bow == true) // 다른 무기를 착용했던 경우 --> 검으로 무기교체
               {
                  wearing_bow = false;
                  DEX -= bonus;

                  DEX_string = Integer.toString(DEX);
                  stat2.setText(DEX_string);

               }

               if (wearing_wand == true) // 다른 무기를 착용했던 경우 --> 검으로 무기교체
               {
                  wearing_wand = false;
                  INT -= bonus;

                  INT_string = Integer.toString(INT);
                  stat3.setText(INT_string);

               }

               ImageIcon change = new ImageIcon(Main.class.getResource("swin.png"));
               wearing_sword = true;

               wearing_weapon.setVisible(true);// 추가된 능력치 보여줌
               wearing_weapon.setBounds(300, 215, 50, 50);
               wearing_weapon.setForeground(Color.red);

               add(stat1);
               add(wearing_weapon);

               change = imageSetSize(change, 626, 375);
               background = change.getImage();
               weapon_wearing = true;

            }

            else if (item.bow.wear == true) {

               if (wearing_bow == false) {
                  DEX += bonus;

                  DEX_string = Integer.toString(DEX);
                  stat2.setText(DEX_string);
                  add(stat2);

               }

               if (wearing_sword == true) // 다른 무기를 착용했던 경우 --> 활로 무기교체
               {
                  wearing_sword = false;
                  STR -= bonus;

                  STR_string = Integer.toString(STR);
                  stat1.setText(STR_string);

               }

               if (wearing_wand == true) // 다른 무기를 착용했던 경우 --> 활로 무기교체
               {
                  wearing_wand = false;
                  INT -= bonus;

                  INT_string = Integer.toString(INT);
                  stat3.setText(INT_string);

               }

               ImageIcon change = new ImageIcon(Main.class.getResource("bowin.png"));
               wearing_bow = true;

               wearing_weapon.setVisible(true);// 추가된 능력치 보여줌
               wearing_weapon.setBounds(300, 240, 50, 50);
               wearing_weapon.setForeground(Color.red);

               add(wearing_weapon);

               change = imageSetSize(change, 626, 375);
               background = change.getImage();
               weapon_wearing = true;

            }

            else if (item.wand.wear == true) {

               if (wearing_wand == false) {
                  INT += bonus;

                  INT_string = Integer.toString(INT);
                  stat3.setText(INT_string);
                  add(stat3);

               }

               if (wearing_sword == true) // 다른 무기를 착용했던 경우 --> 지팡이로 무기교체
               {
                  wearing_sword = false;
                  STR -= bonus;

                  STR_string = Integer.toString(STR);
                  stat1.setText(STR_string);

               }

               if (wearing_bow == true) // 다른 무기를 착용했던 경우 --> 지팡이로 무기교체
               {
                  wearing_bow = false;
                  DEX -= bonus;

                  DEX_string = Integer.toString(DEX);
                  stat2.setText(DEX_string);

               }

               ImageIcon change = new ImageIcon(Main.class.getResource("wandin.png"));
               wearing_wand = true;

               wearing_weapon.setVisible(true);// 추가된 능력치 보여줌
               wearing_weapon.setBounds(300, 270, 50, 50);
               wearing_weapon.setForeground(Color.red);

               add(wearing_weapon);

               change = imageSetSize(change, 626, 375);
               background = change.getImage();
               weapon_wearing = true;

            }

            else if (item.sword.wear == false && item.wand.wear == false && item.bow.wear == false && IScenter == true) {

               weapon_wearing = false;
               if (wearing_sword == true) // 다른 무기를 착용했던 경우
               {
                  wearing_sword = false;
                  STR -= bonus;

                  STR_string = Integer.toString(STR);
                  stat1.setText(STR_string);

               }

               if (wearing_bow == true) // 다른 무기를 착용했던 경우
               {
                  wearing_bow = false;
                  DEX -= bonus;

                  DEX_string = Integer.toString(DEX);
                  stat2.setText(DEX_string);

               }
               if (wearing_wand == true) // 다른 무기를 착용했던 경우
               {
                  wearing_wand = false;
                  INT -= bonus;

                  INT_string = Integer.toString(INT);
                  stat3.setText(INT_string);

               }

               wearing_weapon.setVisible(false);
               background = new ImageIcon(Main.class.getResource("center.png")).getImage();
            }

         }///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

         @Override
         public void mousePressed(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
         }
      });

      menuBar.addMouseMotionListener(new MouseMotionAdapter() {
         @Override
         public void mouseDragged(MouseEvent e) {
            int x = e.getXOnScreen();
            int y = e.getYOnScreen();
            setLocation(x - mouseX, y - mouseY);
         }

      });

      add(menuBar);

      startButton.setBounds(200, 275, 200, 35);
      startButton.setBorderPainted(false);
      startButton.setContentAreaFilled(false);
      startButton.setFocusPainted(false);
      add(startButton);

      startButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            startButton.setIcon(startButtonEnter);
         }

         @Override
         public void mouseExited(MouseEvent e) {
            startButton.setIcon(startButtonBasic);
         }

         @Override
         public void mousePressed(MouseEvent e) {
            startButton.setIcon(startButtonClick);

            // games 이벤트
            startButton.setVisible(false);
            background = new ImageIcon(Main.class.getResource("MakC.png")).getImage();
            make_screen = 1;

            if (make_screen == 1) // Crc MakeF 화면
            {

               JTextField text = new JTextField();/////////////////////////// Crc 닉네임 정하는거
               text.setBounds(70, 70, 125, 25);

               text.setVisible(true);
               add(text);

               int max = 23;
               STR = random.nextInt(10) + 1;
               DEX = random.nextInt(10) + 1;
               INT = 23 - STR - DEX;

               STR_string = Integer.toString(STR);
               DEX_string = Integer.toString(DEX);
               INT_string = Integer.toString(INT);

               stat1.setText(STR_string);
               stat2.setText(DEX_string);
               stat3.setText(INT_string);

               stat1.setBounds(339, 170, 108, 20);
               stat2.setBounds(339, 197, 108, 20);
               stat3.setBounds(339, 227, 108, 20);

               add(stat1);
               add(stat2);
               add(stat3);
               randomButton.setBounds(440, 244, 50, 54);

               randomButton.setBorderPainted(false);
               randomButton.setContentAreaFilled(false);
               randomButton.setFocusPainted(false);
               /////////////////////////////////////////////////////////////// 랜덤버튼
               randomButton.addMouseListener(new MouseAdapter() {

                  public void mouseEntered(MouseEvent e) {

                     randomButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                  }

                  public void mouseExited(MouseEvent e) {
                     randomButton.setIcon(resetButton);
                     randomButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                  }

                  public void mousePressed(MouseEvent e) {
                     randomButton.setIcon(resetClickedButton);
                     STR = random.nextInt(10) + 1;
                     DEX = random.nextInt(10) + 1;
                     INT = 23 - STR - DEX;

                     STR_string = Integer.toString(STR);
                     DEX_string = Integer.toString(DEX);
                     INT_string = Integer.toString(INT);

                     stat1.setText(STR_string);
                     stat2.setText(DEX_string);
                     stat3.setText(INT_string);

                  }

                  public void mouseReleased(MouseEvent e) {
                     randomButton.setIcon(resetButton);
                  }

               });

               getContentPane().add(randomButton);

               ////////////////////////////// 만들기버튼

               makeButton.setBounds(510, 330, 110, 48);

               makeButton.setBorderPainted(false);
               makeButton.setContentAreaFilled(false);
               makeButton.setFocusPainted(false);

               makeButton.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseEntered(MouseEvent e) {
                     makeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

                  }

                  @Override
                  public void mouseExited(MouseEvent e) {
                     makeButton.setIcon(makeBtBasic);
                     makeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                  }

                  @Override
                  public void mousePressed(MouseEvent e) {
                     makeButton.setIcon(makeBtClick);
                     name = text.getText();
                     //////////////////////////////////////////////////////////////////////// 로비
                     IScenter = true;
                     background = new ImageIcon(Main.class.getResource("center.png")).getImage();
                     makeButton.setVisible(false);
                     randomButton.setVisible(false);
                     text.setVisible(false);
                     stat1.setVisible(false);
                     stat2.setVisible(false);
                     stat3.setVisible(false);
                     makeButton.setVisible(false);

                     JLabel name_component = new JLabel(name);
                     name_component.setBounds(53, 25, 123, 23);
                     add(name_component);

                     level = Integer.toString(LEVEL);
                     JLabel level_component = new JLabel(level);
                     level_component.setBounds(305, 120, 100, 10);
                     level_component.setForeground(Color.white);
                     add(level_component);

                     exp = Integer.toString(EXP);
                     JLabel exp_component = new JLabel(exp);
                     exp_component.setBounds(305, 155, 50, 10);
                     exp_component.setForeground(Color.white);
                     add(exp_component);

                     JLabel slash1 = new JLabel("/");
                     slash1.setBounds(347, 155, 50, 10);
                     slash1.setForeground(Color.white);
                     add(slash1);

                     max_exp = Integer.toString(MAX_EXP);
                     JLabel maxexp_component = new JLabel(max_exp);
                     maxexp_component.setBounds(372, 155, 50, 10);
                     maxexp_component.setForeground(Color.white);
                     add(maxexp_component);

                     hp = Integer.toString(HP);
                     JLabel hp_component = new JLabel(hp);
                     hp_component.setBounds(305, 180, 50, 10);
                     hp_component.setForeground(Color.white);
                     add(hp_component);

                     JLabel slash2 = new JLabel("/");
                     slash2.setBounds(347, 180, 50, 10);
                     slash2.setForeground(Color.white);
                     add(slash2);

                     max_hp = Integer.toString(MAX_HP);
                     JLabel maxhp_component = new JLabel(max_hp);
                     maxhp_component.setBounds(372, 180, 50, 10);
                     maxhp_component.setForeground(Color.white);
                     add(maxhp_component);

                     left_stat = Integer.toString(LEFT_STAT);
                     JLabel leftstat_component = new JLabel(left_stat);
                     leftstat_component.setBounds(350, 205, 50, 10);
                     leftstat_component.setForeground(Color.white);
                     add(leftstat_component);

                     stat1.setVisible(true);
                     stat2.setVisible(true);
                     stat3.setVisible(true);

                     stat1.setBounds(340, 235, 50, 10);
                     stat1.setForeground(Color.white);

                     stat2.setBounds(340, 263, 50, 10);
                     stat2.setForeground(Color.white);

                     stat3.setBounds(340, 290, 50, 10);
                     stat3.setForeground(Color.white);

                     STRButton.setBounds(385, 230, 20, 20);
                     STRButton.setBorderPainted(false);
                     STRButton.setContentAreaFilled(false);
                     STRButton.setFocusPainted(false);

                     STRButton.addMouseListener(new MouseAdapter() {

                        public void mouseEntered(MouseEvent e) {
                           STRButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        }

                        public void mouseExited(MouseEvent e) {
                           STRButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        }

                        public void mousePressed(MouseEvent e) {
                           STR++;
                           STR_string = Integer.toString(STR);
                           stat1.setText(STR_string);

                           LEFT_STAT--;
                           left_stat = Integer.toString(LEFT_STAT);
                           leftstat_component.setText(left_stat);

                           if (LEFT_STAT <= 0) {
                              STRButton.setVisible(false);
                              DEXButton.setVisible(false);
                              INTButton.setVisible(false);
                           }

                        }
                     });
                     add(STRButton);

                     DEXButton.setBounds(385, 260, 20, 20);
                     DEXButton.setBorderPainted(false);
                     DEXButton.setContentAreaFilled(false);
                     DEXButton.setFocusPainted(false);
                     DEXButton.addMouseListener(new MouseAdapter() {

                        public void mouseEntered(MouseEvent e) {
                           DEXButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        }

                        public void mouseExited(MouseEvent e) {
                           DEXButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        }

                        public void mousePressed(MouseEvent e) {
                           DEX++;
                           DEX_string = Integer.toString(DEX);
                           stat2.setText(DEX_string);

                           LEFT_STAT--;
                           left_stat = Integer.toString(LEFT_STAT);
                           leftstat_component.setText(left_stat);
                           if (LEFT_STAT <= 0) {
                              STRButton.setVisible(false);
                              DEXButton.setVisible(false);
                              INTButton.setVisible(false);
                           }
                        }
                     });
                     add(DEXButton);

                     INTButton.setBounds(385, 285, 20, 20);
                     INTButton.setBorderPainted(false);
                     INTButton.setContentAreaFilled(false);
                     INTButton.setFocusPainted(false);
                     INTButton.addMouseListener(new MouseAdapter() {

                        public void mouseEntered(MouseEvent e) {
                           INTButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        }

                        public void mouseExited(MouseEvent e) {
                           INTButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        }

                        public void mousePressed(MouseEvent e) {
                           INT++;
                           INT_string = Integer.toString(INT);
                           stat3.setText(INT_string);

                           LEFT_STAT--;
                           left_stat = Integer.toString(LEFT_STAT);
                           leftstat_component.setText(left_stat);
                           if (LEFT_STAT <= 0) {
                              STRButton.setVisible(false);
                              DEXButton.setVisible(false);
                              INTButton.setVisible(false);
                           }
                        }
                     });
                     add(DEXButton);
                     add(INTButton);

                     if (LEFT_STAT <= 0) {
                        STRButton.setVisible(false);
                        DEXButton.setVisible(false);
                        INTButton.setVisible(false);
                     }

                     else if (LEFT_STAT > 0) {
                        STRButton.setVisible(true);
                        DEXButton.setVisible(true);
                        INTButton.setVisible(true);

                     }

                     backMain(name_component, slash1, slash2, level_component, exp_component,
                             maxexp_component, hp_component, maxhp_component, leftstat_component,
                             stat1, stat2, stat3);

               

                     //////////////////////////////////

                     fightButton.setBounds(547, 20, 79, 71);
                     fightButton.setBorderPainted(false);
                     fightButton.setContentAreaFilled(false);
                     fightButton.setFocusPainted(false);
                     add(fightButton);

                     fightButton.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                           fightButton.setIcon(fightClick);
                           fightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        }

                        public void mouseExited(MouseEvent e) {
                           fightButton.setIcon(fightBasic);
                           fightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

                        }

                        public void mousePressed(MouseEvent e) {
                           fightButton.setIcon(fightClick);
                           /////////////////////////////////////////////////////////////////////////////////// 던전입장

                           exitMain(name_component, slash1, slash2, level_component, exp_component,
                                 maxexp_component, hp_component, maxhp_component, leftstat_component, stat1,
                                 stat2, stat3);
                           ImageIcon back = new ImageIcon(Main.class.getResource("Dech.png"));
                           back = imageSetSize(back, 626, 375);

                           background = back.getImage();

                           fight1 = imageSetSize(fight1, 274, 71); // 이미지조정
                           fight1Click = imageSetSize(fight1Click, 274, 71);
                           fight2 = imageSetSize(fight2, 274, 71);
                           fight2Click = imageSetSize(fight2Click, 274, 71);
                           fight3 = imageSetSize(fight3, 274, 71);
                           fight3Click = imageSetSize(fight3Click, 274, 71);
                           fight4 = imageSetSize(fight4, 274, 71);
                           fight4Click = imageSetSize(fight4Click, 274, 71);
                           fight5 = imageSetSize(fight5, 274, 71);
                           fight5Click = imageSetSize(fight5Click, 274, 71);

                           /////////////////////////////////////// ErebO
                           fight1Button = new JButton(fight1);
                           fight1Button.setBounds(5, 15, 274, 71);
                           fight1Button.setBorderPainted(false);
                           fight1Button.setContentAreaFilled(false);
                           fight1Button.setFocusPainted(false);
                           fight1Button.addMouseListener(new MouseAdapter() {

                              public void mouseEntered(MouseEvent e) {
                                 fight1Button.setIcon(fight1Click);
                                 fight1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                              }

                              public void mouseExited(MouseEvent e) {
                                 fight1Button.setIcon(fight1);
                                 fight1Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                              }

                              public void mousePressed(MouseEvent e) {
                                 fight1Button.setVisible(false);
                                 fight2Button.setVisible(false);
                                 fight3Button.setVisible(false);
                                 fight4Button.setVisible(false);
                                 fight5Button.setVisible(false);

                                 if (HP == 0) {
                                    new Error(0);
                                 }

                                 else {
                                    where = 1;

                                    HP--;
                                    EXP += 100;
                                    hp = Integer.toString(HP);
                                    exp = Integer.toString(EXP);

                                    hp_component.setText(hp);
                                    exp_component.setText(exp);
                                    levelup(level_component, exp_component, maxexp_component, hp_component,
                                          leftstat_component);

                                    percent = random.nextInt(100) + 1;
                                    percent1 = random.nextInt(100) + 1;
                                    percent2 = random.nextInt(100) + 1;

                                    if (percent > 50) {

                                       item.sword.Exist = true;
                                       item.sword.n++;
                                       INV.item = item;

                                    }

                                    if (percent1 > 50) {

                                       item.shoes.Exist = true;
                                       item.shoes.n++;
                                       INV.item = item;

                                    }

                                    if (percent2 > 50) {

                                       item.mat1.Exist = true;
                                       item.mat1.n++;
                                       INV.item = item;

                                    }

                                    if (percent >= percent1 && percent >= percent2)
                                       new NewWindow(where, percent);

                                    else if (percent1 > percent2)
                                       new NewWindow(where, percent1);

                                    else
                                       new NewWindow(where, percent2);

                                    percent = 0;
                                    percent1 = 0;
                                    percent2 = 0;

                                 }
                                 backMain(name_component, slash1, slash2, level_component, exp_component,
                                       maxexp_component, hp_component, maxhp_component, leftstat_component,
                                       stat1, stat2, stat3);
                              }
                           });
                           add(fight1Button);

///////////////////////////////////////Minar
                           fight2Button = new JButton(fight2);
                           fight2Button.setBounds(5, 81, 274, 71);
                           fight2Button.setBorderPainted(false);
                           fight2Button.setContentAreaFilled(false);
                           fight2Button.setFocusPainted(false);
                           fight2Button.addMouseListener(new MouseAdapter() {

                              public void mouseEntered(MouseEvent e) {
                                 fight2Button.setIcon(fight2Click);
                                 fight2Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                              }

                              public void mouseExited(MouseEvent e) {
                                 fight2Button.setIcon(fight2);
                                 fight2Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                              }

                              public void mousePressed(MouseEvent e) {
                                 fight1Button.setVisible(false);
                                 fight2Button.setVisible(false);
                                 fight3Button.setVisible(false);
                                 fight4Button.setVisible(false);
                                 fight5Button.setVisible(false);

                                 if (HP == 0) {
                                    new Error(0);
                                 }

                                 else if (STR < 20 || INT < 4) {

                                    if (STR < 20)
                                       new Error(1);

                                    else if (INT < 4)
                                       new Error(3);
                                 }

                                 else {
                                    where = 2;

                                    HP -= 2;
                                    EXP += 50;
                                    hp = Integer.toString(HP);
                                    exp = Integer.toString(EXP);

                                    hp_component.setText(hp);
                                    exp_component.setText(exp);
                                    levelup(level_component, exp_component, maxexp_component, hp_component,
                                          leftstat_component);

                                    percent = random.nextInt(100) + 1;
                                    percent1 = random.nextInt(100) + 1;
                                    percent2 = random.nextInt(100) + 1;

                                    if (percent > 50) {

                                       item.bow.Exist = true;
                                       item.bow.n++;
                                       INV.item = item;

                                    }

                                    if (percent1 > 50) {

                                       item.onepe.Exist = true;
                                       item.onepe.n++;
                                       INV.item = item;

                                    }

                                    if (percent2 > 50) {

                                       item.mat2.Exist = true;
                                       item.mat2.n++;
                                       INV.item = item;

                                    }

                                    if (percent > percent1 && percent > percent2)
                                       new NewWindow(where, percent);

                                    else if (percent1 > percent2)
                                       new NewWindow(where, percent1);

                                    else
                                       new NewWindow(where, percent2);

                                    percent = 0;
                                    percent1 = 0;
                                    percent2 = 0;

                                 }
                                 backMain(name_component, slash1, slash2, level_component, exp_component,
                                       maxexp_component, hp_component, maxhp_component, leftstat_component,
                                       stat1, stat2, stat3);

                              }
                           });

                           add(fight2Button);

///////////////////////////////////////Acua
                           fight3Button = new JButton(fight3);
                           fight3Button.setBounds(5, 152, 274, 71);
                           fight3Button.setBorderPainted(false);
                           fight3Button.setContentAreaFilled(false);
                           fight3Button.setFocusPainted(false);
                           fight3Button.addMouseListener(new MouseAdapter() {

                              public void mouseEntered(MouseEvent e) {
                                 fight3Button.setIcon(fight3Click);
                                 fight3Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                              }

                              public void mouseExited(MouseEvent e) {
                                 fight3Button.setIcon(fight3);
                                 fight3Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                              }

                              public void mousePressed(MouseEvent e) {
                                 fight1Button.setVisible(false);
                                 fight2Button.setVisible(false);
                                 fight3Button.setVisible(false);
                                 fight4Button.setVisible(false);
                                 fight5Button.setVisible(false);

                                 if (HP == 0)
                                    new Error(0);

                                 else if (DEX < 100)
                                    new Error(2);

                                 else if (INT < 30)
                                    new Error(3);

                                 else {
                                    where = 3;

                                    HP -= 3;
                                    EXP += 300;
                                    hp = Integer.toString(HP);
                                    exp = Integer.toString(EXP);

                                    hp_component.setText(hp);
                                    exp_component.setText(exp);
                                    levelup(level_component, exp_component, maxexp_component, hp_component,
                                          leftstat_component);

                                    percent = random.nextInt(100) + 1;
                                    percent2 = random.nextInt(100) + 1;

                                    if (percent > 50) {

                                       item.wand.Exist = true;
                                       item.wand.n++;
                                       INV.item = item;

                                    }

                                    if (percent2 > 50) {

                                       item.mat3.Exist = true;
                                       item.mat3.n++;
                                       INV.item = item;

                                    }

                                    if (percent > percent2)
                                       new NewWindow(where, percent);

                                    else
                                       new NewWindow(where, percent2);

                                    percent = 0;
                                    percent2 = 0;

                                 }
                                 backMain(name_component, slash1, slash2, level_component, exp_component,
                                       maxexp_component, hp_component, maxhp_component, leftstat_component,
                                       stat1, stat2, stat3);

                              }
                           });

                           add(fight3Button);

///////////////////////////////////////Temple
                           fight4Button = new JButton(fight4);
                           fight4Button.setBounds(5, 223, 274, 71);
                           fight4Button.setBorderPainted(false);
                           fight4Button.setContentAreaFilled(false);
                           fight4Button.setFocusPainted(false);
                           fight4Button.addMouseListener(new MouseAdapter() {

                              public void mouseEntered(MouseEvent e) {
                                 fight4Button.setIcon(fight4Click);
                                 fight4Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                              }

                              public void mouseExited(MouseEvent e) {
                                 fight4Button.setIcon(fight4);
                                 fight4Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                              }

                              public void mousePressed(MouseEvent e) {
                                 fight1Button.setVisible(false);
                                 fight2Button.setVisible(false);
                                 fight3Button.setVisible(false);
                                 fight4Button.setVisible(false);
                                 fight5Button.setVisible(false);

                                 if (HP == 0)
                                    new Error(0);

                                 else if (STR < 230)
                                    new Error(1);

                                 else if (DEX < 100)
                                    new Error(2);

                                 else if (INT < 90)
                                    new Error(3);

                                 else {
                                    where = 4;
                                    // new NewWindow(where);
                                    HP -= 5;
                                    EXP += 700;
                                    hp = Integer.toString(HP);
                                    exp = Integer.toString(EXP);

                                    hp_component.setText(hp);
                                    exp_component.setText(exp);
                                    levelup(level_component, exp_component, maxexp_component, hp_component,
                                          leftstat_component);

                                    percent2 = random.nextInt(100) + 1;

                                    if (percent2 > 50) {

                                       item.mat4.Exist = true;
                                       item.mat4.n++;
                                       INV.item = item;

                                    }

                                    new NewWindow(where, percent2);

                                    percent2 = 0;

                                 }
                                 backMain(name_component, slash1, slash2, level_component, exp_component,
                                       maxexp_component, hp_component, maxhp_component, leftstat_component,
                                       stat1, stat2, stat3);
                              }
                           });

                           add(fight4Button);

///////////////////////////////////////Gate
                           fight5Button = new JButton(fight5);
                           fight5Button.setBounds(5, 294, 274, 71);
                           fight5Button.setBorderPainted(false);
                           fight5Button.setContentAreaFilled(false);

                           fight5Button.setFocusPainted(false);
                           fight5Button.addMouseListener(new MouseAdapter() {

                              public void mouseEntered(MouseEvent e) {
                                 fight5Button.setIcon(fight5Click);
                                 fight5Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                              }

                              public void mouseExited(MouseEvent e) {
                                 fight5Button.setIcon(fight5);
                                 fight5Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                              }

                              public void mousePressed(MouseEvent e) {
                                 fight1Button.setVisible(false);
                                 fight2Button.setVisible(false);
                                 fight3Button.setVisible(false);
                                 fight4Button.setVisible(false);
                                 fight5Button.setVisible(false);

                                 if (HP == 0)
                                    new Error(0);

                                 else if (STR < 300)
                                    new Error(1);

                                 else if (DEX < 200)
                                    new Error(2);

                                 else if (INT < 100)
                                    new Error(3);

                                 else {
                                    where = 5;
                                    // new NewWindow(where);
                                    HP -= 10;
                                    EXP += 5000;
                                    hp = Integer.toString(HP);
                                    exp = Integer.toString(EXP);

                                    hp_component.setText(hp);
                                    exp_component.setText(exp);
                                    levelup(level_component, exp_component, maxexp_component, hp_component,
                                          leftstat_component);

                                    percent2 = random.nextInt(100) + 1;

                                    if (percent2 > 50) {

                                       item.mat4.Exist = true;
                                       item.mat4.n++;
                                       INV.item = item;

                                    }

                                    new NewWindow(where, percent2);

                                    percent2 = 0;

                                 }
                                 backMain(name_component, slash1, slash2, level_component, exp_component,
                                       maxexp_component, hp_component, maxhp_component, leftstat_component,
                                       stat1, stat2, stat3);

                              }
                           });

                           add(fight5Button);

                        }
                     });// deonG 열어놓은상태

                     
                     invenButton.setBounds(547, 91, 79, 71);
                     invenButton.setBorderPainted(false);
                     invenButton.setContentAreaFilled(false);
                     invenButton.setFocusPainted(false);
                     add(invenButton);
                     invenButton.addMouseListener(new MouseAdapter() {

                        public void mouseEntered(MouseEvent e) {
                           invenButton.setIcon(invenClick);
                           invenButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        }

                        public void mouseExited(MouseEvent e) {
                           invenButton.setIcon(invenBasic);
                           invenButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

                        }

                        public void mousePressed(MouseEvent e) {
                           invenButton.setIcon(invenClick);
                           //////////////////////////////////////////////////// InvF 열기
                           new INV();

                        }

                     });
                     
                     updateButton.setBounds(547, 162, 79, 71);
                     updateButton.setBorderPainted(false);
                     updateButton.setContentAreaFilled(false);
                     updateButton.setFocusPainted(false);
                     add(updateButton);
                     updateButton.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                           updateButton.setIcon(updateClick);
                           updateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                           if (item.sword.wear == true) {

                              ImageIcon change = new ImageIcon(Main.class.getResource("swin.png"));
                              change = imageSetSize(change, 626, 375);

                              background = change.getImage();

                           }

                           else if (item.bow.wear == true) {
                              ImageIcon change = new ImageIcon(Main.class.getResource("bowin.png"));
                              change = imageSetSize(change, 626, 375);

                              background = change.getImage();

                           } else if (item.wand.wear == true) {
                              ImageIcon change = new ImageIcon(Main.class.getResource("wandin.png"));
                              change = imageSetSize(change, 626, 375);

                              background = change.getImage();

                           }
                           if (item.sword.wear == false && item.wand.wear == false && item.bow.wear == false)
                              background = new ImageIcon(Main.class.getResource("center.png"))
                                    .getImage();
                        }

                        public void mouseExited(MouseEvent e) {
                           updateButton.setIcon(updateBasic);
                           updateButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        }

                        public void mousePressed(MouseEvent e) {
                           updateButton.setIcon(updateClick);
                           /////////////////////////////////////////////////// up1하기
                           exitMain(name_component, slash1, slash2, level_component, exp_component,
                                 maxexp_component, hp_component, maxhp_component, leftstat_component, stat1,
                                 stat2, stat3);
                           power = imageSetSize(power, 626, 375);
                           background = new ImageIcon(Main.class.getResource("power.png")).getImage();
                           new INV();
                           // ImageIcon back = new ImageIcon(Main.class.getResource("up1화면.png"));
                           // back = imageSetSize(back, 626, 375);

                           // background = back.getImage();
                        }

                     });

                     petButton.setBounds(547, 233, 79, 71);
                     petButton.setBorderPainted(false);
                     petButton.setContentAreaFilled(false);
                     petButton.setFocusPainted(false);
                     add(petButton);
                     petButton.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                           petButton.setIcon(petClick);
                           petButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        }

                        public void mouseExited(MouseEvent e) {
                           petButton.setIcon(petBasic);
                           petButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        }

                        public void mousePressed(MouseEvent e) {
                           petButton.setIcon(petClick);
                           //////////////////////////////////////////////////// PetF 관련

                        }

                     });

                     offButton.setBounds(547, 304, 79, 71);
                     offButton.setBorderPainted(false);
                     offButton.setContentAreaFilled(false);
                     offButton.setFocusPainted(false);
                     add(offButton);
                     offButton.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                           offButton.setIcon(offClick);
                           offButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        
                        }

                        public void mouseExited(MouseEvent e) {
                           offButton.setIcon(offBasic);
                           offButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        }

                        public void mousePressed(MouseEvent e) {
                           offButton.setIcon(offClick);
                           //////////////////////////////////////////////////// 게임종료
                           System.exit(0);
                        }

                     });

                  }

                  @Override
                  public void mouseReleased(MouseEvent e) {
                     makeButton.setIcon(makeBtBasic);
                  }

               });

               add(makeButton);

            }

         }

         @Override
         public void mouseReleased(MouseEvent e) {
            startButton.setIcon(startButtonEnter);
         }

      });
      add(startButton);

   }

   public void paint(Graphics g) {
      screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
      screenGraphic = screenImage.getGraphics();
      screenDraw((Graphics2D) screenGraphic);
      g.drawImage(screenImage, 0, 0, null);

   }

   public void screenDraw(Graphics2D g) {
      g.drawImage(background, 0, 0, null);
      paintComponents(g);
      g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

      this.repaint();

   }

   public void backMain(JLabel name, JLabel sl1, JLabel sl2, JLabel level, JLabel exp, JLabel max_exp, JLabel hp,
         JLabel max_hp, JLabel left_stat, JLabel str, JLabel dex, JLabel int_) { // 다시 메인화면으로 돌아가는 것
      IScenter = true;
      background = new ImageIcon(Main.class.getResource("center.png")).getImage();
      name.setVisible(true);
      sl1.setVisible(true);
      sl2.setVisible(true);

      exp.setVisible(true);
      max_exp.setVisible(true);
      hp.setVisible(true);
      max_hp.setVisible(true);
      level.setVisible(true);
      left_stat.setVisible(true);

      str.setVisible(true);
      dex.setVisible(true);
      int_.setVisible(true);

      fightButton.setVisible(true);
      invenButton.setVisible(true);
      updateButton.setVisible(true);
      petButton.setVisible(true);
      offButton.setVisible(true);

      if (LEFT_STAT > 0) {
         STRButton.setVisible(true);
         DEXButton.setVisible(true);
         INTButton.setVisible(true);
      }

      if (item.sword.wear == true) {

         ImageIcon change = new ImageIcon(Main.class.getResource("swin.png"));
         change = imageSetSize(change, 626, 375);
         background = change.getImage();

      } else if (item.bow.wear == true) {
         ImageIcon change = new ImageIcon(Main.class.getResource("bowin.png"));
         change = imageSetSize(change, 626, 375);
         background = change.getImage();

      } else if (item.wand.wear == true) {
         ImageIcon change = new ImageIcon(Main.class.getResource("wandin.png"));
         change = imageSetSize(change, 626, 375);
         background = change.getImage();

      }
      if (item.sword.wear == false && item.wand.wear == false && item.bow.wear == false)
         background = new ImageIcon(Main.class.getResource("center.png")).getImage();


   }

   public void exitMain(JLabel name, JLabel sl1, JLabel sl2, JLabel level, JLabel exp, JLabel max_exp, JLabel hp,
         JLabel max_hp, JLabel left_stat, JLabel str, JLabel dex, JLabel int_) {
      IScenter = false;
      name.setVisible(false);
      sl1.setVisible(false);
      sl2.setVisible(false);

      exp.setVisible(false);
      max_exp.setVisible(false);
      hp.setVisible(false);
      max_hp.setVisible(false);
      level.setVisible(false);
      left_stat.setVisible(false);

      str.setVisible(false);
      dex.setVisible(false);
      int_.setVisible(false);

      fightButton.setVisible(false);
      invenButton.setVisible(false);
      updateButton.setVisible(false);
      petButton.setVisible(false);
      offButton.setVisible(false);

      STRButton.setVisible(false);
      DEXButton.setVisible(false);
      INTButton.setVisible(false);

   }

   ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
      Image ximg = icon.getImage();
      Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
      ImageIcon syimg = new ImageIcon(yimg);
      return syimg;

   }

   void levelup(JLabel level_component, JLabel exp_component, JLabel maxexp_component, JLabel hp_component,
         JLabel leftstat_component) {

      if (EXP >= MAX_EXP) {
         LEVEL++;
         level = Integer.toString(LEVEL);
         level_component.setText(level);

         EXP = EXP - MAX_EXP;
         exp = Integer.toString(EXP);
         exp_component.setText(exp);

         HP = 100;
         hp = Integer.toString(HP);
         hp_component.setText(hp);

         LEFT_STAT += 10;
         left_stat = Integer.toString(LEFT_STAT);
         leftstat_component.setText(left_stat);

         if (LEVEL < 30) {
            MAX_EXP += 100;
            max_exp = Integer.toString(MAX_EXP);
            maxexp_component.setText(max_exp);

         }

         else if (LEVEL >= 30) {

            MAX_EXP *= 1.5;
            max_exp = Integer.toString(MAX_EXP);
            maxexp_component.setText(max_exp);

         }

         else if (LEVEL >= 40) {

            MAX_EXP *= 2;
            max_exp = Integer.toString(MAX_EXP);
            maxexp_component.setText(max_exp);

         }
      }

   }
/*
   public void play() {
    
      AudioInputStream stream;
      AudioFormat format;
      DataLine.Info info;
 
      Clip clip;

      try {
         stream = AudioSystem.getAudioInputStream(getClass().getResource("BGM.wav"));
         format = stream.getFormat();
         info = new DataLine.Info(Clip.class, format);
         clip = (Clip) AudioSystem.getLine(info);
         clip.open(stream);
         clip.loop(-1);
        
      } catch (Exception e) {
         System.out.println("err : " + e);
      }

   }

*/

}

class NewWindow extends JFrame {
   // 버튼이 눌러지면 만들어지는 새 창을 정의한 클래스
   NewWindow(int where, int percent) {

      setTitle("던전 알림");
  
      this.setLocation(600, 100);
      JPanel NewWindowContainer = new JPanel();
      setContentPane(NewWindowContainer);

      if (percent < 50) {
         if (where == 1) {
            JLabel NewLabel = new JLabel("hp 1감소, exp 10 증가!");
            NewWindowContainer.add(NewLabel);
         }

         if (where == 2) {
            JLabel NewLabel = new JLabel("hp 2감소, exp 50 증가!");
            NewWindowContainer.add(NewLabel);
         }

         if (where == 3) {
            JLabel NewLabel = new JLabel("hp 3감소, exp 300 증가!");
            NewWindowContainer.add(NewLabel);
         }

         if (where == 4) {
            JLabel NewLabel = new JLabel("hp 5감소, exp 700 증가!");
            NewWindowContainer.add(NewLabel);
         }

         if (where == 5) {
            JLabel NewLabel = new JLabel("hp 10감소, exp 5000 증가!");
            NewWindowContainer.add(NewLabel);
         }

      }

      else {
         if (where == 1) {
            JLabel NewLabel = new JLabel("hp 1감소, exp 10 증가! 아이템 휙득!");
            NewWindowContainer.add(NewLabel);
         }

         if (where == 2) {
            JLabel NewLabel = new JLabel("hp 2감소, exp 50 증가! 아이템 휙득!");
            NewWindowContainer.add(NewLabel);
         }

         if (where == 3) {
            JLabel NewLabel = new JLabel("hp 3감소, exp 300 증가! 아이템 휙득!");
            NewWindowContainer.add(NewLabel);
         }

         if (where == 4) {
            JLabel NewLabel = new JLabel("hp 5감소, exp 700 증가! 아이템 휙득!");
            NewWindowContainer.add(NewLabel);
         }

         if (where == 5) {
            JLabel NewLabel = new JLabel("hp 10감소, exp 5000 증가! 아이템 휙득!");
            NewWindowContainer.add(NewLabel);
         }

      }
      setSize(300, 100);
      setResizable(false);
      setVisible(true);
   }
}

class Error extends JFrame {
   // 버튼이 눌러지면 만들어지는 새 창을 정의한 클래스
   Error(int need) {

      setTitle("던전 알림");
      
      this.setLocation(600, 100);
      JPanel NewWindowContainer = new JPanel();
      setContentPane(NewWindowContainer);
      if (need == 0) {
         JLabel NewLabel = new JLabel("hp가 부족해 던전을 입장할 수 없습니다.");
         NewWindowContainer.add(NewLabel);
      }
      if (need == 1) {
         JLabel NewLabel = new JLabel("힘이 부족하여 던전을 입장할 수 없습니다.");
         NewWindowContainer.add(NewLabel);
      }
      if (need == 2) {
         JLabel NewLabel = new JLabel("민첩이 부족하여 던전을 입장할 수 없습니다.");
         NewWindowContainer.add(NewLabel);
      }
      if (need == 3) {
         JLabel NewLabel = new JLabel("지력이 부족하여 던전을 입장할 수 없습니다.");
         NewWindowContainer.add(NewLabel);
      }

      setSize(300, 100);
      setResizable(false);
      setVisible(true);
   }
}