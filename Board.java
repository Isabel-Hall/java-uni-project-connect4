public class Board {
  private char[][] board;
  private int width;
  private int height;
  private View view;

  public Board(int height, int width) {
    this.width = width;
    this.height = height;
    board = new char[height][width];
    view = new CLInterface();
  }

//Method to place a counter on the board
  public void placeCounter(int position, Player player, int boardWidth){
    char symbol = player.getSymbol();
    boolean placed = false;
    while(!placed){
      for(int i=board.length-1; i>=0; i--){
        if(!placed){
          if(board[i][position-1] == '\0'){
            board[i][position-1] = symbol;
            placed = true;
            //skips over already placed counters to place in the next available space
          }
        }
      }
      //Informs the user if the column is full and allows them to re-enter their selection
      if(!placed){
        view.display("That column is full please select a different column!");
        position = player.getInput(boardWidth);
      }      
    }


  }

//Uses methods below to check if the player has 4 in a row
  public boolean checkWin(char symbol){
    if(checkHorizontal(symbol) || checkVertical(symbol) || checkDiagonal(symbol)){
      return true;
    }
    else{
      return false;
    }
  }

//Checks for 4 in a row in each line
  private boolean checkHorizontal(char symbol){    
    for(int i = 0; i < board.length; i++){
      int count = 0;
      for(int j = 0; j < board[i].length; j++){
        if(board[i][j] == symbol){
          count++;
          if(count >= 4){
            return true;
          }
        }
        else{
          count = 0;
        }
      }
    }
    return false;
  }

//Checks for 4 in a row in each column
  private boolean checkVertical(char symbol){    
    for(int i = 0; i < board[0].length; i++){
      int count = 0;
      for(int j = 0; j < board.length; j++){
        if(board[j][i] == symbol){
          count++;
          if(count >= 4){
            return true;
          }
        }
        else{
          count = 0;
        }
      }
    }
    return false;
  }

//Checks for 4 in a row diagonally across the different configurations that this can occur
  private boolean checkDiagonal(char symbol){
    int i;
    int j;
    int count;
    for(int x = 0; x < board.length; x++){
      i = x;
      j = 0;
      count = 0;
      while(j < board[0].length && i >= 0){
        if(board[i][j] == symbol){
          count++;
          if(count >= 4){
            return true;
          }
        }
        else{
          count = 0;
        }
        i--;
        j++;
      }
    }
    for(int x = 1; x < board[0].length; x++){
      i = (board.length - 1);
      j = x;
      count = 0;
      while(j < board[0].length && i >= 0){
        if(board[i][j] == symbol){
          count++;
          if(count >= 4){
            return true;
          }
        }
        else{
          count = 0;
        }
        i--;
        j++;
      }
    }
    for(int x = (board[0].length - 1); x >= 0; x--){
      i = 0;
      j = x;
      count = 0;
      while(j < board[0].length && i < board.length){
        if(board[i][j] == symbol){
          count++;
          if(count >= 4){
            return true;
          }
        }
        else{
          count = 0;
        }
        i++;
        j++;        
      }
    }
    for(int x = 1; x < (board.length); x++){
      i = x;
      j = 0;
      count = 0;
      while(j < board[0].length && i < board.length){
        if(board[i][j] == symbol){
          count++;
          if(count >= 4){
            return true;
          }
        }
        else{
          count = 0;
        }
        i++;
        j++;           
      }
    }
    return false;
  }


  public int getWidth(){
    return width;
  }

  public int getHeight(){
    return height;
  }

//Returns the configuration of the board as a string so it can be displayed to the user
  public String toString() {
    String boardToReturn = "";
  		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] == '\0'){
					boardToReturn += ("|   ");
				}
				else{
					boardToReturn += ("| " + board[i][j] + " ");
				}				
			}
			boardToReturn += ("|\n");
		}
		boardToReturn += ("  1   2   3   4   5   6   7");
    return boardToReturn;
	}

}