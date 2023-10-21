package use_case.clear_users;

// TODO Complete me

import entity.User;

import java.util.List;

public interface ClearOutputBoundary {
    void prepareSuccessView(ClearOutputData clearOutputData);
    void prepareFailView(String out);
}
