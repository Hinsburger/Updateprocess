/**
 * Created by Janik on 05.07.2017.
 */
import java.util.ArrayList;

public class Main {

    public static void main(String [] args){

        ArrayList<Level> list = new ArrayList<Level>();

        Version.checkVersion();

        Retrieve.fillList(list);

    }
}
