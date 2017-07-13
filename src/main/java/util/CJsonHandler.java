package util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import core.*;

/**
 *
 */
public class CJsonHandler {

    private CLevelList errorList;

    public CJsonHandler(){
        errorList = new CLevelList();
    }
    /**
     *
     * @param list
     * @return
     */
    public void getVerbalization(CLevelList list){
        String solution;
        String verbalization;
        String url;
        JsonObject json;

        //TODO: !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        for(int i = 0 ; i <= 2 ; i++) {
            for (CLevel level : list.getList()) {

                if (!level.isReady()) {
                    solution = level.getSolution();
                    url = buildUrl(solution);
                    json = downloadJson(url);

                    if (json != null) {
                        verbalization = json.get("verbalization").getAsString();
                        level.setVerbalization(verbalization);
                        level.setReady(true);
                    } else {
                        if(i == 2){
                            errorList.add(level);
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @param solution
     * @return
     */
    private String buildUrl (String solution){
        String url;
        String urlPrae = "http://134.96.217.36:8081/q2gWeb/Q2GApiConnector?targetEntity=";
        String urlSuff = "&numBranches=3&numDistractors=0&maxResultSize=100";

        solution = solution.replace(' ' , '_');

        url = urlPrae + solution + urlSuff;
        //DEBUG
        System.out.println(solution);
        return url;
    }

    /**
     *
     * @param url
     * @return
     */
    private JsonObject downloadJson(String url){
        try {
            JsonObject jsonObject;
            Gson gson = new Gson();
            String content = "";

            Scanner scanner = new Scanner(new URL(url).openStream());
            while (scanner.hasNextLine()) {
                content += scanner.nextLine();
            }
            scanner.close();

            //DEBUG
            //System.out.println(content);

            jsonObject = gson.fromJson(content, JsonObject.class);

            return jsonObject;

        }catch (MalformedURLException e) {
            System.err.println("FEHLER: Keine gültige URL!\n" + e );
            return null;
        }catch (IOException e){
            System.err.println("FEHLER: URL konnte nicht eingelesen werden\n" + e );
            return null;
        }catch (JsonSyntaxException e){
            System.err.println("FEHLER: Datei ist keine Jsondatei\n" + e );
            return null;
        }
    }

    public ArrayList<CLevel> getErrorList() {
        return errorList.getList();
    }
}
