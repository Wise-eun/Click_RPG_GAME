import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class INV extends JFrame {
   

   public static ItemButton itBtn;
   public static SharedItem item = new SharedItem();
   private ImageIcon sw = new ImageIcon(Main.class.getResource("sword.png"));
   private ImageIcon sw1 = new ImageIcon(Main.class.getResource("sword1.png"));
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

   INV() {

      JFrame frame = new JFrame("인벤토리");
      frame.setLocation(300, 300);
      frame.setSize(400, 500);

      
      JPanel p = new JPanel();
      p.setBackground(Color.black);
      p.setSize(new Dimension(400, 500));
      p.setLayout(new GridLayout(8, 5));

      Image a = on.getImage();
      a = a.getScaledInstance(50, 50, a.SCALE_SMOOTH);
      on = new ImageIcon(a);

      a = sh.getImage();
      a = a.getScaledInstance(50, 50, a.SCALE_SMOOTH);
      sh = new ImageIcon(a);

      a = inven.getImage();
      a = a.getScaledInstance(50, 50, a.SCALE_SMOOTH);
      inven = new ImageIcon(a);
      JButton button[] = new JButton[40];

      for (int i = 0; i < 40; i++) {
         button[i] = new JButton();
         p.add(button[i]);
         button[i].setPreferredSize(new Dimension(50, 50));
         button[i].setIcon(inven);

      }

      if (item.sword.Exist == true) {
         button[0].addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

               button[0].setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {

               button[0].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mousePressed(MouseEvent e) {
               itBtn = new ItemButton(item, 0);
               item.sword = itBtn.item.sword;
              
            }

         });

         if (item.sword.init == true) {
            button[0].setIcon(sw);
            item.sword.n = 1;
            item.sword.init = false;
         } else {
            button[0].setIcon(sw);

         }
      }

      if (item.bow.Exist == true) {
         button[1].addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

               button[1].setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {

               button[1].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mousePressed(MouseEvent e) {
               itBtn = new ItemButton(item, 1);
               item.bow = itBtn.item.bow;

            }

         });

         if (item.bow.init == true) {
            button[1].setIcon(bo);
            item.bow.n = 1;
            item.bow.init = false;
         } else {
            button[1].setIcon(bo);

         }

      }

      if (item.wand.Exist == true) {
         button[2].addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

               button[2].setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {

               button[2].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mousePressed(MouseEvent e) {
               itBtn = new ItemButton(item, 2);
               item.wand = itBtn.item.wand;

            }

         });

         if (item.wand.init == true) {
            button[2].setIcon(wa);
            item.wand.n = 1;
            item.wand.init = false;
         } else {
            button[2].setIcon(wa);

         }

      }

      if (item.onepe.Exist == true) {
         button[3].addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

               button[3].setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {

               button[3].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mousePressed(MouseEvent e) {
               itBtn = new ItemButton(item, 3);
               item.onepe = itBtn.item.onepe;

            }

         });

         if (item.onepe.init == true) {
            button[3].setIcon(on);
            item.onepe.n = 1;
            item.onepe.init = false;
         } else {
            button[3].setIcon(on);

         }

      }

      if (item.shoes.Exist == true) {
         button[4].addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

               button[4].setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {

               button[4].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mousePressed(MouseEvent e) {
               itBtn = new ItemButton(item, 4);
               item.shoes = itBtn.item.shoes;

            }

         });

         if (item.shoes.init == true) {
            button[4].setIcon(sh);
            item.shoes.n = 1;
            item.shoes.init = false;
         } else {
            button[4].setIcon(sh);

         }

      }

      if (item.mat1.Exist == true) {
         button[5].addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

               button[5].setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {

               button[5].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mousePressed(MouseEvent e) {
               itBtn = new ItemButton(item, 5);
               item.mat1 = itBtn.item.mat1;

            }

         });
         
         if(item.now_power == true) {
        	 
        	 
         }

         if (item.mat1.init == true) {
            button[5].setIcon(m1);
            item.mat1.n = 1;
            item.mat1.init = false;
         } else {
            button[5].setIcon(m1);

         }

      }

      if (item.mat2.Exist == true) {
         button[6].addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

               button[6].setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {

               button[6].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mousePressed(MouseEvent e) {
               itBtn = new ItemButton(item, 6);
               item.mat2 = itBtn.item.mat2;

            }

         });

         if (item.mat2.init == true) {
            button[6].setIcon(m2);
            item.mat2.n = 1;
            item.mat2.init = false;
         } else {
            button[6].setIcon(m2);

         }

      }

      if (item.mat3.Exist == true) {
         button[7].addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

               button[7].setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {

               button[7].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mousePressed(MouseEvent e) {
               itBtn = new ItemButton(item, 7);
               item.mat3 = itBtn.item.mat3;

            }

         });

         if (item.mat3.init == true) {
            button[7].setIcon(m3);
            item.mat3.n = 1;
            item.mat3.init = false;
         } else {
            button[7].setIcon(m3);

         }

      }

      if (item.mat4.Exist == true) {
         button[8].addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

               button[8].setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {

               button[8].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mousePressed(MouseEvent e) {
               itBtn = new ItemButton(item, 8);
               item.mat4 = itBtn.item.mat4;

            }

         });

         if (item.mat4.init == true) {
            button[8].setIcon(m4);
            item.mat4.n = 1;
            item.mat4.init = false;
         } else {
            button[8].setIcon(m4);

         }

      }

      if (item.mat5.Exist == true) {
         button[9].addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

               button[9].setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {

               button[9].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            public void mousePressed(MouseEvent e) {
               itBtn = new ItemButton(item, 9);
               item.mat5 = itBtn.item.mat5;

            }

         });

         if (item.mat4.init == true) {
            button[9].setIcon(m5);
            item.mat5.n = 1;
            item.mat5.init = false;
         } else {
            button[9].setIcon(m5);

         }

      }
      
      if (item.sword1.Exist == true) {
    	  //button[10].setBorderPainted(false);
    	  button[10].setContentAreaFilled(false);
    	  //button[10].setFocusPainted(false);
   
          button[10].addMouseListener(new MouseAdapter() {
             public void mouseEntered(MouseEvent e) {

                button[10].setCursor(new Cursor(Cursor.HAND_CURSOR));
             }

             public void mouseExited(MouseEvent e) {

                button[10].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
             }

             public void mousePressed(MouseEvent e) {
                itBtn = new ItemButton(item, 10);
                item.sword1 = itBtn.item.sword1;

             }

          });

          if (item.sword1.init == true) {
             button[10].setIcon(sw1);
             item.sword1.n = 1;
             item.sword1.init = false;
          } else {
             button[10].setIcon(sw1);

          }

       }

      ItemButton.item = item;
      frame.add(p);
      frame.pack();
      frame.setVisible(true);

   }
}