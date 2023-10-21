package use_case.clear_users;

import entity.User;

import java.util.List;
// TODO Complete me

public interface ClearUserDataAccessInterface {
    boolean existsByName(String identifier);
    void delete(User user);
    List<User> getAll();
}
