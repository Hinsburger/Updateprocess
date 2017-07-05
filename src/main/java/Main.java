/**
 * Created by Janik on 05.07.2017.
 */
import java.util.ArrayList;

public class Main {

    public static void main(String [] args){

        LevelList list = new LevelList();

        Version.checkVersion();
        System.out.println("-------------------------------------------");

        Retrieve.fillList(list);
        System.out.println("-------------------------------------------");

        System.out.println(list.toString());

    }
}
