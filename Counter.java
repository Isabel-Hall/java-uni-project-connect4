//Takes an inputted string and enables the first letter to be displayed in the board. This could be customised later to display something different

public class Counter{
  private String name;
  private char symbol;

  public Counter(String colour){
    this.name = colour;
    this.symbol = colour.charAt(0);
  }

  public char getSymbol(){
    return symbol;
  }

  public String getName(){
    return name;
  }


}