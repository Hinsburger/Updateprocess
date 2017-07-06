/**
 * Created by Janik on 05.07.2017.
 */

public class Main {
    public static void main(String [] args){

        LevelList list = new LevelList();
        LevelList errorList = new LevelList();

        Version.checkVersion();
        System.out.println("-------------------------------------------");

        DbToList.fillList(list);
        System.out.println("-------------------------------------------");

        System.out.println(list.toString());

        JsonToList.getVerbalization(list);

        System.out.println(list.toString());


        if(errorList.getList().isEmpty()) {
            System.err.println("Q2G-Downloadfehler:");
            System.err.println(errorList.toString());
        }
    }
}
