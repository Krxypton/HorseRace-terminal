import java.awt.Color; 
/**
 * HorseRaceSimulator
 * Author: Zubair Abdirahim Osman/240264295
 * Version 1
 * 15/04/2025
 * This is a horse program where horses compete and race with each other
 * It demonstrates OOP principles including encapsulation and polymorphism.
 */

public class Horse {
    private String horseName;
    private char horseSymbol;
    private double horseDistance = 0.0;
    private boolean horseFallen;
    private double horseConfidence;
    private HorseCustomisation customisation; 

    public Horse(char horseSymbol, String horseName, double horseConfidence) {
        this(horseSymbol, horseName, horseConfidence, createDefaultCustomisation());
    }

    public Horse(char horseSymbol, String horseName, double horseConfidence, HorseCustomisation customisation) {
        this.horseSymbol = horseSymbol;
        this.horseName = horseName;
        this.customisation = customisation;
        double modifiedConfidence = horseConfidence * customisation.getConfidenceModifier();
        this.horseConfidence = Math.max(0.1, Math.min(1.0, modifiedConfidence));
    }

    private static HorseCustomisation createDefaultCustomisation() {
        HorseCustomisation custom = new HorseCustomisation();
        custom.setBreed("Quarter Horse");
        custom.setColour("Brown");  
        custom.setSymbol("🐎");
        custom.setSaddle("Standard Saddle");
        custom.setHorseshoes("Regular Horseshoes");
        return custom;
    }

    public void fall() {
        this.horseFallen = true;
        this.horseConfidence = Math.max(0.1, this.horseConfidence - 0.05); // Decrease confidence
    }
    
    public double getConfidence() {
        return this.horseConfidence;
    }
    
    public int getDistanceTravelled() {
        return (int) this.horseDistance;
    }

    public double getPreciseDistance() {
        return horseDistance; 
    }
    
    public String getName() {
        return this.horseName;
    }
    
    public char getSymbol() {
        return this.horseSymbol;
    }
    
    public void goBackToStart() {
        this.horseDistance = 0;
        this.horseFallen = false;
    }
    
    public boolean hasFallen() {
        return this.horseFallen;
    }

    public void moveForward(double distance) {
        this.horseDistance += distance;
    }

    public void moveForward() {
        this.horseDistance += 1;
    }

    public void setConfidence(double newConfidence) {
        if (newConfidence >= 0.0 && newConfidence <= 1.0) {
            this.horseConfidence = newConfidence;
        }
    }
    
    public void setSymbol(char newSymbol) {
        this.horseSymbol = newSymbol; 
    }
    public HorseCustomisation getCustomisation() {  
        return this.customisation;
    }

    public String getDisplaySymbol() {
        return this.customisation.getSymbol() != null ? 
               this.customisation.getSymbol() : 
               String.valueOf(this.horseSymbol);
    }
    
    public Color getDisplayColour() {  
        String colour = this.customisation.getColour();
        if (colour == null) return Color.BLACK;
        
        switch (colour.toLowerCase()) {
            case "black": return Color.BLACK;
            case "white": return Color.WHITE;
            case "grey": return Color.GRAY;
            case "chestnut": return new Color(152, 118, 84);
            default: return new Color(139, 69, 19);
        }
    }
}



   