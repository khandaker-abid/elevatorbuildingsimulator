/**
 * The Simulator object is only used to conduct the static Simulation method, which uses a helper method to simulate the
 *      elevator situation for the assignment
 * For the printing of the method, I will pretend the unit of time is a second just to make it sound nice and sweet, even if it might not be true.
 * Added printing summary of each step's requests to show validity of method
 */
public class Simulator {
    /**
     * The Simulation method takes all listed parameters, checks for their preconditions immediately, and if satisfied conducts
     *      a simulation of a building with numFloors floors and numElev elevators, with a probability of prob for a request to
     *      be made per time unit, iterating for totalTime time units. Prints at the end the number of finished requests and
     *      the average wait time for each request (AKA how many time units it took for an elevator to reach them), as well as
     *      the wait time in total.
     * @param prob the probability of a request being made per time unit
     * @param numFloors the number of floors in the building
     * @param numElev the number of elevators in the building
     * @param totalTime the number of time units in the simulation
     * @throws InvalidProbabilityException if prob's precondition is violated (prob isn't between 0 and 1 inclusive)
     * @throws InvalidFloorNumberException if numFloors' precondition is violated (numFloors <=1)
     * @throws InvalidElevNumberException if numElev's precondition is violated (numElev <= 0)
     * @throws InvalidTimeException if totalTime's precondition is violated (totalTime <= 0)
     */
    public static void Simulate(double prob, int numFloors, int numElev, int totalTime) throws InvalidProbabilityException, InvalidFloorNumberException, InvalidElevNumberException, InvalidTimeException{
        if(prob > 1 || prob < 0) {
            throw new InvalidProbabilityException();
        }
        if(numFloors <= 1) {
            throw new InvalidFloorNumberException();
        }
        if(numElev <= 0) {
            throw new InvalidElevNumberException();
        }
        if(totalTime <= 0) {
            throw new InvalidTimeException();
        }
        int timer = 0;
        Elevator[] allElev = new Elevator[numElev];
        for(int i = 0; i < allElev.length; i++) {
            allElev[i] = new Elevator();
        }
        BooleanSource p = new BooleanSource(prob);
        boolean elevFullFlag = true;
        RequestQueue<Request> q = new RequestQueue<>();
        int totalWait = 0;
        int doneReqCounter = 0;
        while(timer<totalTime) {
            System.out.print("Step " + (timer+1) + ": ");
            if(p.requestArrived()) {
                Request req = new Request(numFloors);
                req.setTimeEntered(timer);
                q.enqueue(req);
                System.out.println("Request arrived from floor " + req.getSourceFloor() + " to floor " + req.getDestinationFloor());
            } else {
                System.out.println("No request arrived");
            }
            while(!q.isEmpty() && elevFullFlag) {
                elevFullFlag = false;
                for (Elevator elevator : allElev) {
                    if (elevator.getElevatorState() == 0 && !q.isEmpty()) {
                        elevator.setRequest(q.dequeue());
                        elevator.setElevatorState(1);
                        elevFullFlag = true;
                    }
                }
            }
            for (int i = 0; i < allElev.length; i++) {
                if (allElev[i].getElevatorState() == 1 && allElev[i].getRequest().getTimeEntered() == timer && allElev[i].getCurrentFloor() == allElev[i].getRequest().getSourceFloor()) {
                    totalWait += 0;
                    doneReqCounter++;
                    if(allElev[i].getRequest().getSourceFloor() == allElev[i].getRequest().getDestinationFloor()) {
                        allElev[i].setElevatorState(0);
                        allElev[i].setRequest(null);
                    } else {
                        allElev[i].setElevatorState(2);
                        i--;
                    }
                    continue;
                }
                if (allElev[i].getElevatorState() == 1) {
                    allElev[i].setCurrentFloor(allElev[i].getCurrentFloor() + norm(allElev[i].getCurrentFloor(), allElev[i].getRequest().getSourceFloor()));
                    if (allElev[i].getCurrentFloor() == allElev[i].getRequest().getSourceFloor()) {
                        totalWait += timer - allElev[i].getRequest().getTimeEntered() + 1; //+1 because assumed that the elevator gets to its floor at the end of the time unit
                        doneReqCounter++;
                        if(allElev[i].getCurrentFloor() == allElev[i].getRequest().getDestinationFloor()) {
                            allElev[i].setElevatorState(0);
                            allElev[i].setRequest(null);
                        } else {
                            allElev[i].setElevatorState(2);
                        }
                    }
                } else if (allElev[i].getElevatorState() == 2) {
                    allElev[i].setCurrentFloor(allElev[i].getCurrentFloor() + norm(allElev[i].getCurrentFloor(), allElev[i].getRequest().getDestinationFloor()));
                    if (allElev[i].getCurrentFloor() == allElev[i].getRequest().getDestinationFloor()) {
                        allElev[i].setElevatorState(0);
                        allElev[i].setRequest(null);
                    }
                }
            }
            timer++;
        }
        try {
            double y = Double.parseDouble(String.format("%.2f", (double)totalWait / doneReqCounter));
            System.out.println("\nTotal wait time: " + totalWait + " seconds\nNumber of requests fulfilled: " + doneReqCounter + "\nAverage wait time: " + y + " seconds");
        } catch (ArithmeticException e) {
            System.out.println("Wow, not a single request was fulfilled! That's genuinely impressive!!");
        }
    }
    /**
     * Helper method used to move an elevator to the direction of its wanted floor per time unit
     * @param cur the current floor of the elevator
     * @param end the floor the elevator wants to reach
     * @return 1 if the wanted floor is above the current floor,
     *      -1 if the wanted floor is below the current floor,
     *      and 0 if the floors are the same (AKA the elevator got to its area)
     */
    public static int norm(int cur, int end) {
        if(cur < end) {
            return 1;
        } else if (cur > end) {
            return -1;
        } else {
            return 0;
        }
    }
}
