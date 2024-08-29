
/**
 * The Elevator object signifies the current floor of the object, whether it is idle or
 *      moving to a source or destination floor, and the singular request that the object is taking.
 *      Implies that only one person/request is being taken per elevator.
 */
public class Elevator {
    private int currentFloor;
    private int elevatorState;
    private Request request;
    private final int IDLE = 0;
    private final int TO_SOURCE = 1;
    private final int TO_DESTINATION = 2;
    /**
     * The only constructor used to generate an elevator
     */
    public Elevator() {
        request = null;
        elevatorState = IDLE;
        currentFloor = 1;
    }
    /**
     * Getter method for the current floor of the elevator
     * @return the current floor
     */
    public int getCurrentFloor() {
        return currentFloor;
    }
    /**
     * Getter method for the state of the elevator
     * @return 0 if idle, 1 if going to a source floor, 2 if going to a destination floor
     */
    public int getElevatorState() {
        return elevatorState;
    }
    /**
     * Getter method for the request the elevator is taking
     * @return the request the elevator is taking
     */
    public Request getRequest() {
        return request;
    }
    /**
     * Setter method for current floor of the elevator
     * @param currentFloor the new current floor
     */
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
    /**
     * Setter method for the state of the elevator
     * @param elevatorState the state, 0 if idle, 1 if going to source floor, 2 if going to destination floor
     * @throws IllegalArgumentException if elevatorState isn't between 0 and 2 inclusive
     */
    public void setElevatorState(int elevatorState) throws IllegalArgumentException{
        if(elevatorState<0||elevatorState>2) {
            throw new IllegalArgumentException();
        }
        this.elevatorState = elevatorState;
    }
    /**
     * Setter method for the request the elevator is taking
     * @param request the request the elevator is taking
     */
    public void setRequest(Request request) {
        this.request = request;
    }
}
