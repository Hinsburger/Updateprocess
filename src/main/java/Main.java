import core.CLevelList;
import util.CDatabaseHandler;
import util.CJsonHandler;

/**
 *
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String [] args){
        //TODO: Logger schreiben + (Fehler-)Ausgabe überarbeiten
        //TODO: Database.properties (util.CDatabaseHandler)                             Hilfe Cedric Flo
        //TODO: Laufzeit util.CJsonHandler verbessern. Nicht 3mal komplett durch
        //TODO: Vererbung core.CLevelList
        //TODO: Kommentieren :)
        //TODO: 2 MODI: 1. alle Level, 2. neue Level (Übergabeparameter)
        //TODO: Logische Packages/Refactoring, Codeanalyse                  Hilfe Klaus
        //TODO: Konstantenklasse
        //TODO: Eigene Exceptions schmeißen + EKlassen Schreiben
        //TODO: Zeit stoppen (Jedes einzelne Level oder 1 mal komplett?)

        //TODO: Anzahl Jsondownload versuche????? (Übergabeparameter)       Ja/Nein Team?
        //TODO: Versionscheck drinne lassen                                 Ja/Nein Team?
        //TODO: Verbalization manipulieren (z.B. "is married" -> "is or was married")

        CLevelList list = new CLevelList();
        CLevelList errorList = new CLevelList();
        CDatabaseHandler databaseHandler = new CDatabaseHandler();
        System.out.println("-------------------------------------------");

        //Phase 1: Fill a List with the LevelDB:
        databaseHandler.importLevel(list);
        System.out.println("-------------------------------------------");

        //Phase 2: Download for each list entry a (new) Verbalization
        errorList.setList(CJsonHandler.getVerbalization(list));
        System.out.println("-------------------------------------------");

        //Phase 3: Push the new Verbalizations in the DB
        databaseHandler.exportLevel(list);
        System.out.println("-------------------------------------------");

        System.out.println("FINISH:");
        System.out.println(list.toString());
        System.out.println("-------------------------------------------");

        if(!errorList.getList().isEmpty()) {
            System.err.println("Q2G-Downloadfehler bei Folgenden Level:");
            System.err.println(errorList.toString());
        }
    }
}
