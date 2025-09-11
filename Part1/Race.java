import java.util.concurrent.TimeUnit;

/**
 * A three-horse race, each horse running in its own lane
 * for a given distance
 * 
 * Author: Zubair Abdirahim Osman/240264295
 * Version: 1.0
 */
public class Race {
    private int raceLength;
    private Horse lane1Horse;
    private Horse lane2Horse;
    private Horse lane3Horse;

    public Race(int distance) {
        raceLength = distance;
    }

    public void addHorse(Horse theHorse, int laneNumber) {
        if (laneNumber == 1) lane1Horse = theHorse;
        else if (laneNumber == 2) lane2Horse = theHorse;
        else if (laneNumber == 3) lane3Horse = theHorse;
    }

    //Start race method
    public void startRace() {
        boolean finished = false;
        while (!finished) {
            lane1Horse.moveForward();
            lane2Horse.moveForward();
            lane3Horse.moveForward();
    
            printRaceState();
    
            // Check if race finished
            if (lane1Horse.getDistanceTravelled() >= raceLength ||
                lane2Horse.getDistanceTravelled() >= raceLength ||
                lane3Horse.getDistanceTravelled() >= raceLength) {
                finished = true;
                printWinner();
            }
    
            // Check if all horses have fallen
            else if (lane1Horse.hasFallen() && lane2Horse.hasFallen() && lane3Horse.hasFallen()) {
                finished = true;
                System.out.println("All horses have fallen! No winner.");
            }
    
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    //Drawing the race track
    private void printRaceState() {
        printLane(lane1Horse);
        printLane(lane2Horse);
        printLane(lane3Horse);
        System.out.println();
    }

    private void printLane(Horse horse) {
        int pos = (int) horse.getDistanceTravelled();
        for (int i = 0; i < raceLength; i++) {
            if (i == pos) System.out.print(horse.getSymbol());
            else System.out.print(".");
        }
        System.out.println(" " + horse.getName());
    }

    private void printWinner() {
        if (lane1Horse.getDistanceTravelled() >= raceLength)
            System.out.println(lane1Horse.getName() + " wins!");
        else if (lane2Horse.getDistanceTravelled() >= raceLength)
            System.out.println(lane2Horse.getName() + " wins!");
        else if (lane3Horse.getDistanceTravelled() >= raceLength)
            System.out.println(lane3Horse.getName() + " wins!");
    }

    // Main method to run a demo race
    public static void main(String[] args) {
        Race race = new Race(20); // track length

        Horse h1 = new Horse('A', "Derek", 0.8);
        Horse h2 = new Horse('B', "Arthur", 0.9);
        Horse h3 = new Horse('C', "Crystal", 0.7);

        race.addHorse(h1, 1);
        race.addHorse(h2, 2);
        race.addHorse(h3, 3);

        race.startRace();
    }
}
