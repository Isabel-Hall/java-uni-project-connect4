import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HumanPlayer extends Player{
  private BufferedReader input;
  private View view;

  public HumanPlayer(Counter colour){
    super(colour);
    input = new BufferedReader(new InputStreamReader(System.in));
    view = new CLInterface();
  }

//Gets the user's input, makes it clear what they need to input and guards against non-int entries
  public int getInput(int boardSize){
    try{
      view.display("Please choose one of the above columns");
      return Integer.parseInt(input.readLine());
    }
    catch(NumberFormatException e){
      view.display("Invalid input!");
      return -1;
    }
    catch(IOException e){      
      return -2;
    }
  }
}