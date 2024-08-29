
/**
 * The Analyzer object houses the main method which uses Scanner to take in all inputs for the simulation to form. It
 *      houses a generic exception catch to deal with Scanner discrepancies, as well as has specific exception catches
 *      for each argument precondition violation. These are checked at once after all input arguments are taken and the
 *      method is attempted to be called, and if any violation is found, it gracefully ends the program.
 * For the printing of the method, I will pretend the unit of time is a second just to make it sound nice and sweet.
 * Also, since there was no mention of this assignment requiring a redo-able UI format, The main program simply ends
 *      when the simulation method is done, either fully done or after an exception is thrown.
 */

import java.util.Scanner;
public class Analyzer {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double p;
        int numF;
        int numE;
        int totT;
        //try {
            System.out.print("Welcome! To start the simulator, please state the probability of a request being made (0 to 1 inclusive): ");
            p = s.nextDouble();
            System.out.print("Next, please state the number of floors (more than 1): ");
            numF = s.nextInt();
            System.out.print("Next, please state the number of elevators (more than 0): ");
            numE = s.nextInt();
            System.out.print("Finally, please state the number of seconds of time you want to operate the simulation in (more than 0): ");
            totT = s.nextInt();
            try {
                Simulator.Simulate(p, numF, numE, totT);
            } catch (InvalidProbabilityException e1) {
                System.out.println("Sorry, the probability stated isn't within the range (0-1). Please try again.");
            } catch (InvalidFloorNumberException e2) {
                System.out.println("Sorry, the number of floors can't be 1 or less. Please try again.");
            } catch (InvalidElevNumberException e3) {
                System.out.println("Sorry, the number of elevators can't be 0 or negative. Please try again.");
            } catch (InvalidTimeException e4) {
                System.out.println("Sorry, the amount of seconds in the simulation can't be 0 or negative. Please try again.");
            }
        //} catch (Exception e) {
            //System.out.println("Sorry, invalid input!! Please try again.");
        //}
    }
}
