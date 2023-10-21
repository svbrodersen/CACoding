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

public class ClearView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "clear view";
    JLabel usernames;
    private final ClearViewModel clearViewModel;

    private final ClearController clearController;

    public ClearView(ClearViewModel clearViewModel, ClearController clearController) {
        this.clearViewModel = clearViewModel;
        this.clearController = clearController;
        this.clearViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Cleared Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernames = new JLabel();

        this.add(title);
        this.add(usernames);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("CHANGE");
        clearController.execute();
        ClearState state = (ClearState) evt.getNewValue();
        setFields(state);
    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
    private void setFields(ClearState state) {
        usernames.setText(state.toString());
    }
}
