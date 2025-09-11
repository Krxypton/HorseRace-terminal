/**
 * HorseRaceSimulator
 * Author: Zubair Abdirahim Osman/240264295
 * Version 1
 * 15/04/2025
 * This is a horse program where horses compete and race with each other.
 * It demonstrates OOP principles including encapsulation and polymorphism.
 */

 public class Horse {
    private String horseName;
    private char horseSymbol;
    private double horseDistance = 0.0;
    private boolean horseFallen;
    private double horseConfidence;

    public Horse(char horseSymbol, String horseName, double horseConfidence) {
        this.horseSymbol = horseSymbol;
        this.horseName = horseName;
        this.horseConfidence = Math.max(0.1, Math.min(1.0, horseConfidence)); // Keep confidence in [0.1, 1.0]
        this.horseFallen = false;
    }

    public String getName() {
        return horseName;
    }

    public char getSymbol() {
        return horseFallen ? 'X' : horseSymbol; // Show 'X' if fallen
    }

    public double getDistanceTravelled() {
        return horseDistance;
    }

    public double getConfidence() {
        return horseConfidence;
    }

    public boolean hasFallen() {
        return horseFallen;
    }

    public void fall() {
        horseFallen = true;
    }

    public void moveForward() {
        if (!horseFallen) {
            // 5% chance of falling
            if (Math.random() < 0.05) {
                fall();
            } else {
                double step = Math.random() * horseConfidence * 2;
                horseDistance += step;
            }
        }
    }

    public void reset() {
        horseDistance = 0.0;
        horseFallen = false;
    }
}
