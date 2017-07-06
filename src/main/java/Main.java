/**
 * Created by Janik on 05.07.2017.
 */

public class Main {
    public static void main(String [] args){

        LevelList list = new LevelList();

        Version.checkVersion();
        System.out.println("-------------------------------------------");

        DbToList.fillList(list);
        System.out.println("-------------------------------------------");

        System.out.println(list.toString());

        JsonToList.getVerbalization(list);
    }
}
