package ex;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MyTetris2_1 extends JFrame{

   MyTetris2_1(){
      setTitle("나의 테트리스");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      //1.1패널 컨텐트 펜에 붙임
      MyPanel myPanel = new MyPanel();
      setContentPane(myPanel);
      
      setSize(320,600);
      setVisible(true);
      getContentPane().requestFocus(); //3.2 잊으면 안되는것 
   }   
   
   //1.패널 클래스
   class MyPanel extends JPanel{
      //1.2 배열공부
      Point[] SHAPE_COORD = new Point[] {new Point(0,0),new Point(-1,0),new Point(1,0),new Point(0,1)};
      Point[] shapeCoord = new Point[4];
      Point[] shape = new Point[4];
      
      //생성자
      MyPanel() {
         for(int i=0; i<SHAPE_COORD.length;i++) //*배열 객체 요소 복사 (주소복사 SHAPE_COORD[i].x)
            shapeCoord[i] = new Point(SHAPE_COORD[i].x,SHAPE_COORD[i].y);
         for(int i=0; i<SHAPE_COORD.length;i++) //*배열 객체 요소 복사 (주소복사 SHAPE_COORD[i].x)
            shape[i] = new Point(shapeCoord[i].x+4,shapeCoord[i].y+2);
         
         //3.1 리스너 객체 생성
         this.addKeyListener(new MyListener());
         this.requestFocus();//3.2 잊으면안됨 두군데 써줘야함
         
         //4.1 스레드 객체 start()
         MyThread myThread = new MyThread();
         myThread.start();
         
         
      }//생성자
      
      //4.스레드 
      class MyThread extends Thread{

         @Override
         public void run() {
            // TODO Auto-generated method stub
            while(true) {
               boolean fallen = false;
               //하나라도 14가 되면 멈추게 , 깃발역할 
               for(int i=0; i<4; i++) {
                  if(shape[i].y==14)
                     fallen = true;
               }
               if(fallen!=true) { //깃발 체크 
                  for(int i=0; i<4; i++) {
                     shape[i].y ++;
                  }   
               }
               try{Thread.sleep(1000);}catch(Exception e) {return;}
               repaint();
            }            
         }
         
      }
      
      
      //3.1 리스너 클래스
      class MyListener extends KeyAdapter{//impelements 였다면 KeyListener였어야함 , impelements를 쓰면 코드가길어짐 

         @Override
         public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            super.keyPressed(e);
            if(e.getKeyCode() == KeyEvent.VK_UP) {
               int tmp;
               for(int i=0; i<4; i++) {
                  tmp = shapeCoord[i].y;
                  shapeCoord[i].y = shapeCoord[i].x;
                  shapeCoord[i].x = -tmp; //마이너스 주의
               }//for
               for(int i=0; i<4; i++) {
                  shape[i].x = shapeCoord[i].x + shape[0].x; //0에 주의
                  shape[i].y = shapeCoord[i].y + shape[0].y;
               }
               repaint(); //잊지말기
            }//if (회전)
            
            //왼쪽으로 이동
            if(e.getKeyCode() == KeyEvent.VK_LEFT) {
               for(int i=0; i<4; i++) 
                  shape[i].x--;
               repaint(); 
            }//if
            
            //오른쪽으로 이동 
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
               for(int i=0; i<4; i++) 
                  shape[i].x++;
               repaint(); 
            }//if
            
         } 
          
      }//리스너 클래스
      
      
      //2.그래픽
      @Override
      protected void paintComponent(Graphics g) {
         // TODO Auto-generated method stub
         super.paintComponent(g);
         g.setColor(Color.red);
         for(int i=0; i<4; i++) {
            g.fillRoundRect(shape[i].x*40-40, shape[i].y*40-40, 40, 40, 10, 10);
         }
      }
   }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new MyTetris2_1();
   }
}