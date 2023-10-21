package interface_adapter.clear_users;

// TODO Complete me

import entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClearState {
    private String error = "";
    private boolean cleared = false;
    private List<User> users = Collections.<User>emptyList();

    public String getError() {return this.error;}
    public List<User> getUsers() {return this.users;}

    public void setError(String error) {this.error = error;}
    public void setUsers(List<User> users) {this.users = users;}

    public void setCleared(boolean val) {this.cleared = val;}

    @Override
    public String toString() {
        ArrayList<String> userNames = new ArrayList<String>();
        for (User user : users) {
            userNames.add(user.getName());
        }
        return "ClearState{" + '\'' +
                "Users: " + (userNames.toString()) + '\'' +
                '}';
    }
}
