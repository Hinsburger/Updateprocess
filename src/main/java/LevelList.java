import java.util.ArrayList;

/**
 * Created by Janik on 05.07.2017.
 */
public class LevelList {

    private ArrayList<Level> list;
    private int anzLevel;

    public LevelList(){
        this.list = new ArrayList<Level>();
        this.anzLevel = 0;
    }

    public void add(int id, String solution){
        list.add(new Level(id, solution));
        anzLevel++;
    }

    @Override
    public String toString(){
        String s = "";
        for(Level level : list){
            s += level.toString() + '\n';
        }
        return s;
    }

    /**
     * Getter und Setter
     */
    public ArrayList<Level> getList() {
        return list;
    }

    public void setList(ArrayList<Level> list) {
        this.list = list;
    }

    public int getAnzLevel() {
        return anzLevel;
    }

    public void setAnzLevel(int anzLevel) {
        this.anzLevel = anzLevel;
    }

}
