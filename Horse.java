import java.util.Scanner;

/**
 * Write a description of class Horse here.
 * 
 * @author Zubair Osman
 * @version 15/04/2025 V2
 */
public class Horse
{
    //Fields of class Horse
    private String horseName;
    private char horseSymbol;
    private int horseDistance = 0;
    private boolean horseFallen;
    private double horseConfidence;
    
      
    //Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence)
    {
    this.horseSymbol = horseSymbol;
    this.horseName = horseName;
    
    if (horseConfidence >= 0 && horseConfidence <= 1) {
        this.horseConfidence = horseConfidence;
    } else {
        System.out.println("Invalid initial confidence. Setting default to 0.5.");
        this.horseConfidence = 0.5;
    }

    }
    
    
    
    //Other methods of class Horse
    public void fall()
    {
         this.horseFallen = true;
    }
    
    public double getConfidence()
    {
        return this.horseConfidence;
    }
    
    public int getDistanceTravelled()
    {
        return this.horseDistance;
    }
    
    public String getName()
    {
        return this.horseName;
    }
    
    public char getSymbol()
    {
        return this.horseSymbol;
    }
    
    public void goBackToStart()
    {
        this.horseDistance = 0;
        return;
    }
    
    public boolean hasFallen()
    {
        return this.horseFallen;
    }

    public void moveForward()
    {
        this.horseDistance += 1;
        return;
    }

    public void setConfidence(double newConfidence)
    {
        Scanner scanner = new Scanner(System.in);

        while(newConfidence > 1.0 || newConfidence < 0.0){
            System.out.println("You need to pick a value between 1 and 0");
            newConfidence = Double.parseDouble(scanner.nextLine());
        }
        
        this.horseConfidence = newConfidence;
    }
    
    public void setSymbol(char newSymbol)
    {
        this.horseSymbol = newSymbol; 
    }
    
}
