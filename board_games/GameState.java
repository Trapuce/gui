package board_games;

public class GameState {

  public int board[][] = new int[16][16];

  public void initialise() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = 1;
      }
    }
  }

  public void affiche(){
      for (int[] ligne : board) {
          System.out.print("  | ");
          for (int cellule : ligne) {
              if(cellule == 1){
                  System.out.print("X");
              }
              System.out.print("  |  ");
          }
          System.out.println();
      }
  }
}
