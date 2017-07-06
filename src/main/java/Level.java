/**
 * Created by Janik on 05.07.2017.
 */
public class Level {
    private int id;
    private String verbalization;
    private String solution;
    private boolean ready;

    public Level(int id, String solution){
        this.id = id;
        this.verbalization = null;
        this.solution = solution;
        this.ready = false;
    }

    @Override
    public String toString(){
        return id + " : " + verbalization + " : " + solution + " : " + ready;
    }

    /**
     * Getter/Setter
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
}
