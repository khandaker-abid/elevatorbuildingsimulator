
/**
 * The Request object details all information of a singular request including the source and destination of the request
 *      and when it was entered into the simulation. Source and destination are randomly picked for this assignment.
 */
public class Request {
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered;
    /**
     * The only constructor used for a Request, taking in the number of floors
     * @param allFloors the number of floors in the simulation
     */
    public Request(int allFloors) {
        sourceFloor = (int)(Math.random()*allFloors) + 1;
        destinationFloor = (int)(Math.random()*allFloors) + 1;
    }
    /**
     * Getter method for source floor
     * @return the source floor
     */
    public int getSourceFloor() {
        return sourceFloor;
    }
    /**
     * Getter method for destination floor
     * @return the destination floor
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }
    /**
     * Getter method for the time this request was made
     * @return the time this request was made
     */
    public int getTimeEntered() {
        return timeEntered;
    }
    /**
     * Setter method for the source floor of this request
     * @param sourceFloor the new source floor
     */
    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }
    /**
     * Setter method for the destination floor of this request
     * @param destinationFloor the new destination floor
     */
    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }
    /**
     * Setter method for the time this request was entered
     * @param timeEntered the time this request was entered
     */
    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }
}