package models;

import java.util.HashSet;
import java.util.Set;

public class UsernameList {

    private Set<String> editors;
    private Set<String> journalists;

    public UsernameList() {
        this.editors = new HashSet<>();
        this.journalists = new HashSet<>();
        editors.add("RDunbar");
        editors.add("BCooke");
        journalists.add("WCronkite");
        journalists.add("HThompson");
    }

    public Set<String> getEditors() {
        return editors;
    }

    public void setEditors(Set<String> editors) {
        this.editors = editors;
    }

    public Set<String> getJournalists() {
        return journalists;
    }

    public void setJournalists(Set<String> journalists) {
        this.journalists = journalists;
    }

    public boolean checkUsername(String name){
        HashSet<String> combined = new HashSet<>();
        combined.addAll(journalists);
        combined.addAll(editors);
        for (String user : combined){
            if (user.contains(name)){
                return true;
            }
        }
        return false;
    }
}
