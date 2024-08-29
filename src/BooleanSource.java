
/**
 * The BooleanSource object is a helper object for determining
 *      and executing the probability of a request per time unit.
 *      Takes in a probability number to use for its method.
 */
public class BooleanSource {
    private double probability;
    /**
     * The only used constructor for the object. Takes a probability.
     * @param x the probability being used for the object.
     */
    public BooleanSource(double x) {
        probability = x;
    }
    /**
     * The method used to measure a "coin flip" of some probability of getting heads per time unit
     * @return true or false, similar to a coin flip heads or tails
     */
    public boolean requestArrived() {
        double x;
        do {
            x = Math.random();
        } while (probability == x); //in case x equals p
        if(x<probability) {
            return true;
        } else {
            return false;
        }
    }
}
