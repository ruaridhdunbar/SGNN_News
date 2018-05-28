package models;

import java.util.HashSet;
import java.util.Set;

public class UsernameList {

    private Set<String> users;

    public UsernameList() {
        this.users = new HashSet<>();
        users.add("Editor");
        users.add("Journalist");
    }

    public Set<String> getUsernames() {
        return users;
    }

    public void setUsernames(Set<String> usernames) {
        this.users = usernames;
    }

    public boolean checkUsername(String name){
        for (String user : this.users){
            if (user.contains(name)){
                return true;
            }
        }
        return false;
    }
}
