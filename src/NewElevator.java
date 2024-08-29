import java.util.LinkedList;

public class NewElevator {
    private int currentFloor;
    private int elevatorState;
    private LinkedList<Request> requests;
    private boolean direction;
    private final int IDLE = 0;
    private final int TO_SOURCE = 1;
    private final int TO_DESTINATION = 2;
    public NewElevator() {
        requests = new LinkedList<>();
        elevatorState = IDLE;
        currentFloor = 1;
        direction = true;
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
    public int getElevatorState() {
        return elevatorState;
    }
    public LinkedList<Request> getRequests() {
        return requests;
    }
    public boolean getDirection() {
        return direction;
    }
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }
    public void addRequest(Request request) {
        requests.add(request);
    }
    public void setDirection(boolean x) {
        this.direction = x;
    }
}
