package interface_adapter.signup;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

import java.util.Optional;

public class SignupController {

    final SignupInputBoundary userSignupUseCaseInteractor;
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void clear() {
        userSignupUseCaseInteractor.clear();
    }
    public void execute(String username, String password1, String password2) {
            SignupInputData signupInputData = new SignupInputData(
                    username, password1, password2);


        userSignupUseCaseInteractor.execute(signupInputData);
    }
}
