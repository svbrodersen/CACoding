package use_case.clear_users;

// TODO Complete me

import entity.User;

import java.util.List;

public class ClearOutputData {

    private final List<User> delUsers;

    public ClearOutputData(List<User> users) {
        this.delUsers = users;
    }

    public List<User> getDelUsers() {return delUsers;}
}
