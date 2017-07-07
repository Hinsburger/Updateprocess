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
        //TODO: Database.properties (CDatabase)                             Hilfe Cedric Flo
        //TODO: Laufzeit CJson verbessern. Nicht 3mal komplett durch
        //TODO: Vererbung CLevelList
        //TODO: Kommentieren :)
        //TODO: 2 MODI: 1. alle Level, 2. neue Level (Übergabeparameter)
        //TODO: Logische Packages/Refactoring, Codeanalyse                  Hilfe Klaus
        //TODO: Konstantenklasse
        //TODO: Eigene Exceptions schmeißen + EKlassen Schreiben
        //TODO: Zeit stoppen (Jedes einzelne Level oder 1 mal komplett?)

        //TODO: Anzahl Jsondownload versuche????? (Übergabeparameter)       Ja/Nein Team?
        //TODO: Versionscheck drinne lassen                                 Ja/Nein Team?

        CLevelList list = new CLevelList();
        CLevelList errorList = new CLevelList();

        CDatabase.checkVersion();
        System.out.println("-------------------------------------------");

        CDatabase.importLevel(list);
        System.out.println("-------------------------------------------");

        errorList.setList(CJson.getVerbalization(list));
        System.out.println("-------------------------------------------");

        CDatabase.exportLevel(list);
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
