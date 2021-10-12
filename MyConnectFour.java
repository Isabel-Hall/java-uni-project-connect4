import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyConnectFour {
	
  private View view;
  private Board board;
  private ArrayList<Player> players;
  private int maxMoves;
  private int numOfMoves;
	
	public MyConnectFour(){
		
		playGame();
	}

//Method that allows a new game to be played, required that the board size and players are defined	
	private void playGame(){
    board = new Board(6, 7);
    view = new CLInterface();
    players = new ArrayList<>();
    Counter red = new Counter("red");
    Counter yellow = new Counter("yellow");
    players.add(new HumanPlayer(red));
    players.add(new ComputerPlayer(yellow));
    int currentPlayer = 0;
    maxMoves = board.getWidth() * board.getHeight();
    numOfMoves = 0;

//Explains how the game works to the player
		view.display("Welcome to Connect 4");
		view.display("There are " + players.size() + " players:");
    for(Player player : players){
      view.display(player.toString());
    }
		view.display("Player 1 is " + players.get(0) + " and they go first");
		view.display("To play the game type in the number of the column you want to drop you counter in"); 
		view.display("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		view.display("");
		view.display(board.toString());
    

    boolean win = false;
		while(!win){
      //Gets user's move and places counter, guards against invalid inputs (such as characters or out of range ints)
			int move = -1;
      while(move < 1 || move > board.getWidth()){
        move = players.get(currentPlayer).getInput(board.getWidth());
      }
			board.placeCounter(move, players.get(currentPlayer), board.getWidth());
      numOfMoves ++;
      //After each turn the board is displayed to the user and the programme checks if there is a winner, the game ends when someone wins
      view.display(board.toString());
      win = board.checkWin(players.get(currentPlayer).getSymbol());
      if(win){
        view.display("" + players.get(currentPlayer) + " wins!!");
      }
      //Game also ends if there is a draw
      else if(numOfMoves == maxMoves){
        view.display("No more spaces! It's a draw!");
        break;
      }
      //iterated through the available players so they have alternating turns
      currentPlayer = (currentPlayer + 1) % players.size();


//Original code that has been refactored into other classes and methods
			/*boolean hasWon = false;
      int count = 0;
			// check horizontal
			for(int i=0; i<board.length; i++){
				for(int j=0; j<board[i].length; j++){
					if(board[i][j] == 'r'){
						count = count + 1;
						if(count > 4){
							hasWon = true;
						}
					}
					else{
						count = 0;
					}
				}
				
			}
			// check vertical 
			count = 0;
			for(int i=0; i<board[0].length; i++){
				for(int j=0; j<board.length; j++){
					if(board[j][i] == 'r'){
						count = count + 1;
						if(count > 4){
							hasWon = true;
						}
					}
					else{
						count = 0;
					}
				}
				
			}
			System.out.println(board);
			if(hasWon){
				win = true;
			}
			else{
				//player 2
				userInput = getUserInput();
				move = Integer.parseInt(userInput);
				placeCounter('y',move);
				hasWon = false;
				count = 0;
				// check horizontal
				for(int i=0; i<board.length; i++){
					for(int j=0; j<board[i].length; j++){
						if(board[i][j] == 'y'){
							count = count + 1;
							if(count >= 4){
								hasWon = true;
							}
						}
						else{
							
						}
					}
					count = 0;
				}
				// check vertical 
				count = 0;
				for(int i=0; i<board[0].length; i++){
					for(int j=0; j<board.length; j++){
						if(board[j][i] == 'y'){
							count = count + 1;
							if(count >= 4){
								hasWon = true;
							}
						}
						else{
							 
						}
					}
					count = 0;
				}
				System.out.println(board);
				if(hasWon){
					win = true;
				}
			}
			if(win){System.out.println("You Have Won!!!");}
      */
		}
    view.display("Game over!");

    
		
	}

//More original code, the functionality of these methods is now contained within the relevant classes
	/*
	private String getUserInput(){
		String toReturn = null;
		try{			
			toReturn = input.readLine();
		}
		catch(Exception e){
			
		}
		return toReturn;
	}
	
	private void printBoard(){
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] == 'r'){
					System.out.print("| r ");
				}
				else if(board[i][j] == 'y'){
					System.out.print("| y ");
				}
				else{
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
		System.out.println("  1   2   3   4   5   6   7");
	}
	
	private void placeCounter(char player, int position){
		boolean placed = false;
		if(player == 'r'){
			for(int i=board.length-1; i>=0; i--){
				if(!placed){
					if(board[i][position-1] == 'y'){
						// skip
					}
					else if(board[i][position-1] != 'r'){
						board[i][position-1] = 'r';
						placed = true;
					}
				}
			}
		}
		else{
			for(int i=board.length-1; i>=0; i--){
				if(!placed){
					if(board[i][position-1] == 'r'){
						// skip
					}
					else if(board[i][position-1] != 'y'){
						board[i][position-1] = 'y';
						placed = true;
					} 
				}
			}
		}
	}*/
}
