//Khandaker Abid        115478345       214 R30

import java.util.LinkedList;

/**
 * For the printing of the method, I will pretend the unit of time is a second just to make it sound nice and sweet, even if it might not be true.
 * Added printing summary of each step's requests to show validity of method
 */
/*
public class OptimalSimulator { //******
    public static void Simulation(double prob, int numFloors, int numElev, int totalTime) throws InvalidProbabilityException, InvalidFloorNumberException, InvalidElevNumberException, InvalidTimeException{
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
        NewElevator[] allElev = new NewElevator[numElev];
        for(int i = 0; i < allElev.length; i++) {
            allElev[i] = new NewElevator();
        }
        LinkedList<Request>[] floorRequests = new LinkedList[numFloors];
        BooleanSource p = new BooleanSource(prob);
        boolean elevFullFlag = true;
        RequestQueue<Request> q = new RequestQueue<>();
        int totalWait = 0;
        int doneReqCounter = 0;
        while(timer<totalTime) {
            System.out.print("Step " + timer+1 + ": ");
            if(p.requestArrived()) {
                Request req = new Request(numFloors);
                req.setTimeEntered(timer);
                floorRequests[req.getSourceFloor()].add(req);
                q.enqueue(req);
                System.out.println("Request arrived from floor " + req.getSourceFloor() + " to floor " + req.getDestinationFloor());
            } else {
                System.out.println("No request arrived");
            }
            while(!q.isEmpty() && elevFullFlag) {
                elevFullFlag = false;
                for (NewElevator elevator : allElev) {
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
                    allElev[i].setElevatorState(2);
                    i--;
                    continue;
                }
                if (allElev[i].getElevatorState() == 1) {
                    allElev[i].setCurrentFloor(allElev[i].getCurrentFloor() + norm(allElev[i].getCurrentFloor(), allElev[i].getRequest().getSourceFloor()));
                    if (allElev[i].getCurrentFloor() == allElev[i].getRequest().getSourceFloor()) {
                        totalWait += timer - allElev[i].getRequest().getTimeEntered();
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
            System.out.println("Total wait time: " + totalWait + " seconds\nNumber of requests fulfilled: " + doneReqCounter + "\nAverage wait time: " + y + " seconds");
        } catch (ArithmeticException e) {
            System.out.println("Wow, not a single request was fulfilled! That's genuinely impressive!!");
        }
    }
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

*/