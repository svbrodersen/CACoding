package interface_adapter.clear_users;

import entity.User;
import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearInputData;
import use_case.clear_users.ClearOutputData;
import use_case.clear_users.ClearUserDataAccessInterface;

import java.util.List;

// TODO Complete me
public class ClearController {
    final ClearInputBoundary clearUseCaseInteractor;

    public ClearController(ClearInputBoundary clearUseCaseInteractor) {
        this.clearUseCaseInteractor = clearUseCaseInteractor;
    }
    public void execute() {
        ClearInputData clearInputData = new ClearInputData();
        clearUseCaseInteractor.execute(clearInputData);
    }
}
