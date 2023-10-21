package view;

import interface_adapter.clear_users.ClearController;
import interface_adapter.clear_users.ClearState;
import interface_adapter.clear_users.ClearViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.signup.SignupState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ClearView extends JPanel implements PropertyChangeListener{
    public final String viewName = "clear view";
    private final ClearViewModel clearViewModel;
    private final JLabel usernames;
    private final ClearController clearController;

    public ClearView(ClearViewModel clearViewModel, ClearController clearController) {
        this.clearViewModel = clearViewModel;
        this.clearController = clearController;
        clearViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(clearViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernames = new JLabel(clearViewModel.USERNAMES_LABEL);
        usernames.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(usernames);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        clearController.execute();
        ClearState state = (ClearState) evt.getNewValue();
        doPopUp(state);
    }

    private void doPopUp(ClearState state) {
        JOptionPane.showMessageDialog(this, state.toString());
    }
}
