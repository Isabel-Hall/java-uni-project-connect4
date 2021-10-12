import java.util.Random;

public class ComputerPlayer extends Player{
  private Random rand;

  public ComputerPlayer(Counter colour){
    super(colour);
    rand = new Random();
  }

//Returns a random integer with the range of possible columns
  public int getInput(int boardSize){
    return (rand.nextInt(boardSize) + 1);
  }
}