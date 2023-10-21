package use_case.clear_users;

// TODO Complete me

import entity.User;
import use_case.signup.SignupOutputBoundary;

import java.util.ArrayList;
import java.util.List;

public class ClearInteractor implements  ClearInputBoundary {
    final ClearUserDataAccessInterface userDataAccessInterface;
    final ClearOutputBoundary clearOutput;
    public ClearInteractor(ClearUserDataAccessInterface clearUserDataAccessInterface, ClearOutputBoundary clearOutputData) {
        this.userDataAccessInterface = clearUserDataAccessInterface;
        this.clearOutput = clearOutputData;
    }

    @Override
    public void execute(ClearInputData clearInputData) {
        List<User> users = userDataAccessInterface.getAll();
        for (User user : users) {
            userDataAccessInterface.delete(user);
        }
        clearOutput.prepareSuccessView(new ClearOutputData(users));
    }
}
