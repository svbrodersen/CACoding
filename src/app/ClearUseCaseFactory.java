package app;

import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.clear_users.ClearController;
import interface_adapter.clear_users.ClearPresenter;
import interface_adapter.clear_users.ClearViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearInteractor;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearUserDataAccessInterface;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginUserDataAccessInterface;
import view.ClearView;
import view.LoginView;

import javax.swing.*;
import java.io.IOException;

public class ClearUseCaseFactory {

    /** Prevent instantiation. */
    private ClearUseCaseFactory() {}

    public static ClearView create(
            ViewManagerModel viewManagerModel,
            ClearViewModel clearViewModel,
            ClearUserDataAccessInterface userDataAccessObject) {

        try {
            ClearController clearController = createClearUseCase(viewManagerModel, clearViewModel, userDataAccessObject);
            return new ClearView(clearViewModel, clearController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static ClearController createClearUseCase(
            ViewManagerModel viewManagerModel,
            ClearViewModel clearViewModel,
            ClearUserDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        ClearOutputBoundary clearOutputBoundary = new ClearPresenter(viewManagerModel, clearViewModel);

        ClearInputBoundary clearInteractor = new ClearInteractor(
                userDataAccessObject, clearOutputBoundary);

        return new ClearController(clearInteractor);
    }
}