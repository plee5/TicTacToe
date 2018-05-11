import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TicGUI extends JFrame 
    {

  JFrame frame = new JFrame("TicTacToe Game");                    //Global frame and grid button variables 
  JButton[][] buttons = new JButton[3][3];
  JButton start = new JButton("Start");              //Create start/reset buttons for game
//   start.addActionListener(new ActionListener() {
//       public void actionPerformed(ActionEvent e) { 
//         initialize();
//     } 
// });
  JButton reset = new JButton("Reset");
  JOptionPane turn;
  int moveCounter = 9;
  boolean gameWon = false;


 public TicGUI()                                        //Tic tac default constructor which adds and dimensions Jframe
   {
     super();
     frame.setSize(350, 450);
     frame.setDefaultCloseOperation(EXIT_ON_CLOSE);        //Setting dimension of Jframe and setting parameters
     frame.setVisible(true);
     frame.setResizable(false);
    //  initialize();

   }

  private void checkWin(int row, int col)
    {
      if(buttons[row][0].getText()==buttons[row][1].getText()&& buttons[row][1].getText()==buttons[row][2].getText())
        {
          gameWon = true;
          System.out.println(buttons[row][0].getText()+ " wins!!!");         
        }
    else  if(buttons[0][col].getText()==buttons[1][col].getText()&& buttons[1][col].getText()==buttons[2][col].getText())
       {
          gameWon = true;
          System.out.println(buttons[row][0].getText()+ " wins!!!");
       }
    }
  private void compTurn(int count)
   { 
    int randomMove=count;
    Random num = new Random();
    randomMove = num.nextInt(randomMove)+1;

     while(gameWon ==false)
      {
       for(int i = 0; i < 3; i++)                      //Create grid of buttons for tic tac toe game
        {
         for(int j = 0; j < 3; j++) 
          {                 
           if(buttons[i][j].isEnabled()==true)
            {
               randomMove--;

             if(randomMove==0 )
              {
                buttons[i][j].setText("O");
                buttons[i][j].setEnabled(false);
                moveCounter--;
                checkWin(i, j);
              }
             } 

            }
          }
        }
      }

private void initialize()             //Initialize tic tac toe game board
   {
       
       
      JPanel mainPanel = new JPanel(new BorderLayout());         //create main panel container to put layer others on top
      JPanel menu = new JPanel(new BorderLayout());
      JPanel game = new JPanel(new GridLayout(3,3));                     //Create two more panels with layouts for buttons


      for(int i = 0; i < 3; i++)                      //Create grid of buttons for tic tac toe game
        {
         for(int j = 0; j < 3; j++) 
           {

            buttons[i][j] = new JButton();                //Instantiating buttons 
            buttons[i][j].setText("");
            buttons[i][j].setVisible(true);
           // game.add(new JButton("Button hi"));
            game.add(buttons[i][j], BorderLayout.WEST); 
            buttons[i][j].addActionListener(new myActionListener());        //Adding response event to buttons
           }
        }
        
        
      frame.add(mainPanel);
      mainPanel.setPreferredSize(new Dimension(325,425));
      menu.setPreferredSize(new Dimension(300,50));                     //Setting dimensions of panels
      game.setPreferredSize(new Dimension(300,300));
      mainPanel.add(menu, BorderLayout.NORTH);                   //Add two panels to the main container panel             
      mainPanel.add(game, BorderLayout.SOUTH);

      menu.add(start, BorderLayout.WEST);                //Add both start/reset buttons to menu container panel
      menu.add(reset, BorderLayout.EAST);

      start.addActionListener(new myActionListener());
      reset.addActionListener(new myActionListener());
      frame.setVisible(true);



  }
private int counter = 0;
 private class myActionListener implements ActionListener
   {      //Implementing action listener for buttons
       private String[] text = {"X", "O"};
       //why does it not work to do 3 line
       // private String[] txt = new String[2];
       //switch between two players
     public void actionPerformed(ActionEvent a) 
      {
          
       counter = 1 - counter;
       //Display X's or O's on the buttons  
       if(a.getSource() == buttons[0][0])                  //Checking which button is pressed
         {
           buttons[0][0].setText(text[counter]);
           buttons[0][0].setEnabled(false);
           moveCounter--;
           // compTurn(moveCounter);
           checkWin(0,0);
         } 
       else if(a.getSource() == buttons[0][1])
         {
           buttons[0][1].setText(text[counter]);
           buttons[0][1].setEnabled(false);
           moveCounter--;
           // compTurn(moveCounter);
           checkWin(0,1);
         } 
       else if(a.getSource() == buttons[1][0])
        {
          buttons[1][0].setText(text[counter]);  
          buttons[1][0].setEnabled(false);
          moveCounter--;
          // compTurn(moveCounter);
          checkWin(1,0);
        } 
       else if(a.getSource() == buttons[1][1])
        {
          buttons[1][1].setText(text[counter]);
          buttons[1][1].setEnabled(false);
          moveCounter--;
          // compTurn(moveCounter);
          checkWin(1,1);
        }
       else if(a.getSource() == buttons[1][2])
        {
          buttons[1][2].setText(text[counter]);
          buttons[1][2].setEnabled(false);
          moveCounter--;
          // compTurn(moveCounter); 
          checkWin(1,2);
        } 
       else if(a.getSource() == buttons[2][2])
        {
         buttons[2][2].setText(text[counter]);
         buttons[2][2].setEnabled(false);
         moveCounter--;
         // compTurn(moveCounter);
         checkWin(2,2);
        } 
       else if(a.getSource() == buttons[0][2])
        {
         buttons[0][2].setText(text[counter]);
         buttons[0][2].setEnabled(false);
         moveCounter--;
         // compTurn(moveCounter);
         checkWin(0,2);
        }
       else if(a.getSource() == buttons[2][1])
        {
         buttons[2][1].setText(text[counter]);
         buttons[2][1].setEnabled(false);
         moveCounter--;
         // compTurn(moveCounter);
         checkWin(2,1);
        }
       else if(a.getSource() == buttons[2][0])
        {
         buttons[2][0].setText(text[counter]);
         buttons[2][0].setEnabled(false);
         moveCounter--;
         // compTurn(moveCounter);
         checkWin(2,0);
        }
       else if(a.getSource() == start)
         {
             System.out.println("It does go here");
           turn = new JOptionPane("Do you want to go first?\n",JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
           start.setEnabled(false);
         }
       else if(a.getSource() == reset)
         {
             start.setEnabled(true);
            for(int i = 0; i < 3; i++)
             { 
               for(int j = 0; j < 3; j++)
                {
                   buttons[i][j].setText(""); 
                   buttons[i][j].setEnabled(true);
                   gameWon = false;
                }
             }
           }
           
       }
       
     }

 public static void main(String[] args)
    {
      TicGUI game = new TicGUI();         //main method and instantiating tic tac object and calling initialize function
      game.initialize();
    }
 }