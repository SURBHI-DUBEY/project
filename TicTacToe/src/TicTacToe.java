import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TicTacToe {
    int boardwidth=600;
    int boardheight=600;
    
    JFrame frame= new JFrame("Tic-Tac-Toe");
    JLabel textlabel= new JLabel();
    JPanel panel=new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[][] board =new JButton[3][3];
    String playerX="X";
    String player ="O";
    String currentPlayer =playerX;

    boolean gameOver =false;
    int turn=0;


    TicTacToe() {
          frame.setVisible(true);
          frame.setSize(boardwidth, boardheight);
          frame.setLocationRelativeTo(null);
          frame.setResizable(false);

          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setLayout(new BorderLayout());   
           
          textlabel.setBackground(Color.DARK_GRAY);
          textlabel.setForeground(Color.LIGHT_GRAY);
          textlabel.setFont(new Font("Arial",Font.BOLD,40));
          textlabel.setHorizontalAlignment(JLabel.CENTER);
          textlabel.setText("Tic-Tac-Toe"); 
          textlabel.setOpaque(true);

          panel.setLayout(new BorderLayout());
          panel.add(textlabel);
          frame.add(panel, BorderLayout.NORTH);

          boardPanel.setLayout(new GridLayout(3,3));
          boardPanel.setBackground(Color.red);
          frame.add(boardPanel);

          for(int r=0; r<3; r++){
            for(int c=0;c<3;c++){
              JButton tile =new JButton();
              board[r][c]=tile;
              boardPanel.add(tile);

              tile.setBackground(Color.darkGray);
              tile.setForeground(Color.pink);
              tile.setFont(new Font("Arial",Font.BOLD,120));
              tile.setFocusable(false);

              tile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  if(gameOver) return;
                  JButton tile =(JButton) e.getSource();
                  if (tile.getText()=="") {
                    tile.setText(currentPlayer);
                    turn++;
                    checkWinner();
                    if (!gameOver) {
                      currentPlayer=currentPlayer==playerX?player:playerX;
                    textlabel.setText(currentPlayer+"'s turn.");
                    }
                    
                  }
                }
              });



            }
          }
      }


void checkWinner(){
  for(int r=0; r<3;r++){ //horizontal check
    if(board[r][0].getText()=="") continue;

    if(board[r][0].getText()==board[r][1].getText() &&
    board[r][1].getText()==board[r][2].getText()){       //first row check

      for(int i=0;i<3;i++){
        setWinner(board[r][i]);

      }
      gameOver=true;
      return;
    
  }
}
      for(int c=0; c<3;c++){ //vertical check
         if (board[0][c].getText()=="")continue;
         
         if(board[0][c].getText()==board[1][c].getText() &&
    board[1][c].getText()==board[2][c].getText()){       //first row check

      for(int i=0;i<3;i++){
        setWinner(board[i][c]);

      }
      gameOver=true;
      return;
    }   
  } 
  if(board[0][0].getText()!="" &&    //diagonal check
  board[0][0].getText()==board[1][1].getText() &&
   board[1][1].getText()==board[2][2].getText()&&
   board[0][0].getText() !=""){       //first row check
    for(int i=0;i<3;i++){
      setWinner(board[i][i]);
    }
    gameOver=true;
    return;
  }
  if(board[0][2].getText()==board[1][1].getText() && //anti-diagonal check
   board[1][1].getText()==board[2][0].getText()&&
   board[0][2].getText() !=""){       //first row check
    for(int i=0;i<3;i++){
      setWinner(board[i][2-i]);
    }
    gameOver=true;
    return;
  }
     if (turn==9) {   //tie check
      for(int r=0; r<3;r++){
        for(int c=0;c<3;c++){
         
          setTie(board[r][c]);
        }
      }
      
     }
         
  }
  void setWinner(JButton tile){
    tile.setForeground(Color.green);
    tile.setBackground(Color.lightGray);
    textlabel.setText(currentPlayer+" wins!");

  }
  void setTie(JButton tile){
    tile.setForeground(Color.red);
    tile.setBackground(Color.lightGray);
    textlabel.setText(" tie!");

  }
}