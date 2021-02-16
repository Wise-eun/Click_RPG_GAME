import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ItemButton extends JFrame{
	static SharedItem item = new SharedItem();

	   
    JButton button1 = new JButton("장착");
    JButton button2 = new JButton("해제");
    JButton button3 = new JButton("강화");
JButton button4 = new JButton("사용");
    
	ItemButton(SharedItem  item,int n){

	      setTitle("아이템 옵션창");
	     
	      this.setLocation(600, 100);
	      JPanel NewWindowContainer = new JPanel();
	      setContentPane(NewWindowContainer);
	      
	   
	      
	      button1.setBounds(30, 50, 90, 30);
	      button2.setBounds(30, 50, 90, 30);
	      button3.setBounds(150, 50, 90, 30);
	      button4.setBounds(30, 70, 90, 30);
	      
	      if(n==0) {
	      if(item.sword.wear == false) {
	    	  button1.setVisible(true);
              button2.setVisible(false);
              button3.setVisible(true);
              
             }
             
	      else if(item.now_power == true) {
	    	  button1.setVisible(false);
              button2.setVisible(false);
	    	  
	      }
             else  {
            	 button1.setVisible(false);
                 button2.setVisible(true);
                 button3.setVisible(false);
	             }

            
	
	
	      button1.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            
	            	button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
	            }

	            public void mouseExited(MouseEvent e) {
	               
	            	button1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            }

	            public void mousePressed(MouseEvent e) {
	            	
	            	
	              item.sword.wear = true;
	            
	              item.bow.wear = false;
	              item.wand.wear = false;

	          
	              button1.setVisible(false);
	              button2.setVisible(true);
	              
	            dispose();
	            
	            
	            }
	             
	   
	         });
	      
	      button2.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            
	            	button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
	            }

	            public void mouseExited(MouseEvent e) {
	               
	            	button2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            }

	            public void mousePressed(MouseEvent e) {
	              item.sword.wear = false;
	              button2.setVisible(false);
	              button1.setVisible(true);
	              dispose();

	            }

	         });
	      
	      button3.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            
	            	button3.setCursor(new Cursor(Cursor.HAND_CURSOR));
	            }

	            public void mouseExited(MouseEvent e) {
	               
	            	button3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            }

	            public void mousePressed(MouseEvent e) {
	            	item.now_power = true;
	                dispose();
	            }

	         });
	      
	      JLabel NewLabel = new JLabel("개수 : "+item.sword.n +"개");
	         //NewWindowContainer.add(NewLabel);
	          NewLabel.setBounds(290, 50, 40, 30);
	          add(NewLabel);
	     

	      setSize(300, 100);
	      setResizable(false);
	      setVisible(true);
	      
	      
	  	add(button1);
	  	add(button2);
	  	add(button3);
	      }
	      
	      
	      
	      
	      
	      
	     if(n==1) {//////////////////////////////////////////////////////활
	      
	      
	      
	    
		      if(item.bow.wear == false) {
		    	  button1.setVisible(true);
	              button2.setVisible(false);
	            
	              
	             }
	             
	             else  {
	            	 button1.setVisible(false);
	                 button2.setVisible(true);
		             }

	            
		
		
		      button1.addMouseListener(new MouseAdapter() {
		            public void mouseEntered(MouseEvent e) {
		            
		            	button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		            }

		            public void mouseExited(MouseEvent e) {
		               
		            	button1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		            }

		            public void mousePressed(MouseEvent e) {
		            	
		            	
		              item.bow.wear = true;
		            
		              item.sword.wear = false;
		              item.wand.wear = false;

		          
		              button1.setVisible(false);
		              button2.setVisible(true);
		              
		              }
		      });
		             
		    


		      
		      button2.addMouseListener(new MouseAdapter() {
		            public void mouseEntered(MouseEvent e) {
		            
		            	button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		            }

		            public void mouseExited(MouseEvent e) {
		               
		            	button2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		            }

		            public void mousePressed(MouseEvent e) {
		              item.bow.wear = false;
		              button2.setVisible(false);
		              button1.setVisible(true);

		            }

		         });
		      
		    
		    
		         JLabel NewLabel = new JLabel("개수 : "+item.bow.n +"개");
		         //NewWindowContainer.add(NewLabel);
		          NewLabel.setBounds(290, 50, 40, 30);
		          add(NewLabel);
		     
		      setSize(300, 100);
		      setResizable(false);
		      setVisible(true);
		      
		      
		  	add(button1);
		  	add(button2);
		  	add(button3);
		      }
	      

	      
	 if(n==2) {
		 //////////////////////////////////////////////////////지팡이
     
      
      
    
	      if(item.wand.wear == false) {
	    	  button1.setVisible(true);
              button2.setVisible(false);
            
              
             }
             
             else  {
            	 button1.setVisible(false);
                 button2.setVisible(true);
	             }

            
	
	
	      button1.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            
	            	button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
	            }

	            public void mouseExited(MouseEvent e) {
	               
	            	button1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            }

	            public void mousePressed(MouseEvent e) {
	            	
	            	
	              item.wand.wear = true;
	            
	              item.sword.wear = false;
	              item.bow.wear = false;

	          
	              button1.setVisible(false);
	              button2.setVisible(true);}
	      });
	             
	    
	      
	      button2.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            
	            	button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
	            }

	            public void mouseExited(MouseEvent e) {
	               
	            	button2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            }

	            public void mousePressed(MouseEvent e) {
	              item.wand.wear = false;
	              button2.setVisible(false);
	              button1.setVisible(true);

	            }

	         });
	      
	    
	    
	         JLabel NewLabel = new JLabel("개수 : "+item.wand.n +"개");
	         //NewWindowContainer.add(NewLabel);
	          NewLabel.setBounds(290, 50, 40, 30);
	          add(NewLabel);
	     
	      setSize(300, 100);
	      setResizable(false);
	      setVisible(true);
	      
	      
	  	add(button1);
	  	add(button2);
	  	add(button3);
	      }
	 
	 
	 
	 if(n==3) {
		 //////////////////////////////////////////////////////옷
     
      
      
    
	      if(item.onepe.wear == false) {
	    	  button1.setVisible(true);
              button2.setVisible(false);
            
              
             }
             
             else  {
            	 button1.setVisible(false);
                 button2.setVisible(true);
	             }

            
	
	
	      button1.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            
	            	button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
	            }

	            public void mouseExited(MouseEvent e) {
	               
	            	button1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            }

	            public void mousePressed(MouseEvent e) {
	            	
	            	
	              item.onepe.wear = true;
	            
	          
	          
	              button1.setVisible(false);
	              button2.setVisible(true);}
	      });
	             
	    
	      
	      button2.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            
	            	button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
	            }

	            public void mouseExited(MouseEvent e) {
	               
	            	button2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            }

	            public void mousePressed(MouseEvent e) {
	              item.onepe.wear = false;
	              button2.setVisible(false);
	              button1.setVisible(true);

	            }

	         });
	      
	    
	    
	         JLabel NewLabel = new JLabel("개수 : "+item.onepe.n +"개");
	         //NewWindowContainer.add(NewLabel);
	          NewLabel.setBounds(290, 50, 40, 30);
	          add(NewLabel);
	     
	      setSize(300, 100);
	      setResizable(false);
	      setVisible(true);
	      
	      
	  	add(button1);
	  	add(button2);
	  	add(button3);
	  
	      }
	 
	 
	 if(n==4) {
		 //////////////////////////////////////////////////////신발
     
      
      
    
	      if(item.shoes.wear == false) {
	    	  button1.setVisible(true);
              button2.setVisible(false);
            
              
             }
             
             else  {
            	 button1.setVisible(false);
                 button2.setVisible(true);
	             }

            
	
	
	      button1.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            
	            	button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
	            }

	            public void mouseExited(MouseEvent e) {
	               
	            	button1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            }

	            public void mousePressed(MouseEvent e) {
	            	
	            	
	              item.shoes.wear = true;
	            
	          
	          
	              button1.setVisible(false);
	              button2.setVisible(true);}
	      });
	             
	    
	      
	      button2.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            
	            	button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
	            }

	            public void mouseExited(MouseEvent e) {
	               
	            	button2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            }

	            public void mousePressed(MouseEvent e) {
	              item.shoes.wear = false;
	              button2.setVisible(false);
	              button1.setVisible(true);

	            }

	         });
	      
	    
	    
	         JLabel NewLabel = new JLabel("개수 : "+item.shoes.n +"개");
	         //NewWindowContainer.add(NewLabel);
	          NewLabel.setBounds(290, 50, 40, 30);
	          add(NewLabel);
	     
	      setSize(300, 100);
	      setResizable(false);
	      setVisible(true);
	      
	      
	  	add(button1);
	  	add(button2);
	  	add(button3);
	      }
	 
	 
	 
	 
	 
	 if(n==5) {
		 //////////////////////////////////////////////////////재료1
     

	         JLabel NewLabel = new JLabel("개수 : "+item.mat1.n +"개");
	         //NewWindowContainer.add(NewLabel);
	          NewLabel.setBounds(150, 50, 40, 30);
	          add(NewLabel);
	      		
	      setSize(300, 100);
	      setResizable(false);
	      setVisible(true);
	      
	      if(item.now_power == true) {
	    	 
	    	  button4.setVisible(true);
	    	  add(button4);
	      }
	      else
	      {
	    	  button4.setVisible(false);
	    	  
	      }
	      button4.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            
	            	button4.setCursor(new Cursor(Cursor.HAND_CURSOR));
	            }

	            public void mouseExited(MouseEvent e) {
	               
	            	button4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            }

	            public void mousePressed(MouseEvent e) {
	   
	              button4.setVisible(false);}
	      });

	      }
	 
	 if(n==6) {
		 //////////////////////////////////////////////////////재료2
     

	         JLabel NewLabel = new JLabel("개수 : "+item.mat2.n +"개");
	         //NewWindowContainer.add(NewLabel);
	          NewLabel.setBounds(150, 50, 40, 30);
	          add(NewLabel);
	     
	      setSize(300, 100);
	      setResizable(false);
	      setVisible(true);
	      

	      }
	 
	 if(n==7) {
		 //////////////////////////////////////////////////////재료3
     

	         JLabel NewLabel = new JLabel("개수 : "+item.mat3.n +"개");
	         //NewWindowContainer.add(NewLabel);
	          NewLabel.setBounds(150, 50, 40, 30);
	          add(NewLabel);
	     
	      setSize(300, 100);
	      setResizable(false);
	      setVisible(true);
	      

	      }
	 
	 if(n==8) {
		 //////////////////////////////////////////////////////재료4
     

	         JLabel NewLabel = new JLabel("개수 : "+item.mat4.n +"개");
	         //NewWindowContainer.add(NewLabel);
	          NewLabel.setBounds(150, 50, 40, 30);
	          add(NewLabel);
	     
	      setSize(300, 100);
	      setResizable(false);
	      setVisible(true);
	      

	      }
	 
	 if(n==9) {
		 //////////////////////////////////////////////////////재료5
     

	         JLabel NewLabel = new JLabel("개수 : "+item.mat5.n +"개");
	         //NewWindowContainer.add(NewLabel);
	          NewLabel.setBounds(150, 50, 40, 30);
	          add(NewLabel);
	     
	      setSize(300, 100);
	      setResizable(false);
	      setVisible(true);
	      

	      }
	 
	 
	 


	}
	      
	}
	   
