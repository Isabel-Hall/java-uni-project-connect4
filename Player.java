public abstract class Player {
  private Counter colour;  

  public Player(Counter colour){
    this.colour = colour;

  }

//Abstract method implemented by the extending classes
  abstract int getInput(int boardWidth);

  public Counter getColour(){
    return colour;
  }

//Gets the character to display in the board for each move
  public char getSymbol(){
    return colour.getSymbol();
  }

//Returns the name that the player is using as their counter, e.g if the counter is "red" will return red as a string rather than the character 'r'
  public String toString(){
    return colour.getName();
  }


}