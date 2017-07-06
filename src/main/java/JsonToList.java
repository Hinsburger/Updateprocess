/**
 * Created by Janik on 06.07.2017.
 */
public class JsonToList{

    public static void getVerbalization(LevelList list){
        String solution;
        String verbalization;
        String url;

        for(Level level : list.getList()){
            solution = level.getSolution();
            url = buildUrl(solution);
        }


    }

    private static String buildUrl (String solution){
        String url;
        String urlPrae = "https://gate.d5.mpi-inf.mpg.de/q2g/Q2GApiConnector?targetEntity=";
        String urlSuff = "&numDistractors=0";

        solution = solution.replace(' ' , '_');

        url = urlPrae + solution + urlSuff;
        //DEBUG
        System.out.println(solution);
        return url;
    }
}
