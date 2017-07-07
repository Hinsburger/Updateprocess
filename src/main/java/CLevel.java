/**
 *
 */
public class CLevel {
    private int id;
    private String verbalization;
    private String solution;
    private boolean ready;

    /**
     *
     * @param id
     * @param solution
     */
    public CLevel(int id, String solution){
        this.id = id;
        this.verbalization = null;
        this.solution = solution;
        this.ready = false;
    }

    /**
     * toString/Getter/Setter
     */

    @Override
    public String toString(){
        return id + " : " + verbalization + " : " + solution + " : " + ready;
    }

    public int getId() {
        return id;
    }

    public String getVerbalization() {
        return verbalization;
    }

    public void setVerbalization(String verbalization) {
        this.verbalization = verbalization;
    }

    public String getSolution() {
        return solution;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
}
