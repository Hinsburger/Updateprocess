import java.util.ArrayList;
/**
 *
 */
//TODO: extend gebacken bekommen
public class CLevelList{
    private ArrayList<CLevel> list;

    /**
     *
     */
    public CLevelList(){
        this.list = new ArrayList<CLevel>();
    }

    /**
     *
     * @param id
     * @param solution
     */
    public void add(int id, String solution){
        list.add(new CLevel(id, solution));
    }

    /**
     * toString/Getter/Setter
     */

    @Override
    public String toString(){
        String s = "";
        for(CLevel level : list){
            s += level.toString() + '\n';
        }
        return s;
    }

    public ArrayList<CLevel> getList() {
        return list;
    }

    public void setList(ArrayList<CLevel> list) {
        this.list = list;
    }

}
