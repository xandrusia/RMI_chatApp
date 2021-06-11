package Assignment3.client.views.view1;

import Assignment3.client.core.ViewHandler;
import Assignment3.client.core.ViewModelFactory;
import Assignment3.client.views.view2.ChatViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import Assignment3.client.views.ViewsController;

import java.awt.*;
import java.io.IOException;

public class LoginController implements ViewsController
{
    @FXML
    private TextField aliasTextField;
    @FXML
    private Button onLogIn;

    private LoginViewModel vm;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) throws IOException
    {
        this.vh = vh;
        this.vm = vmf.getLoginViewModel();

        aliasTextField.textProperty().bindBidirectional(vm.aliasTProperty());
    }

    public void onLogIn(javafx.event.ActionEvent actionEvent)
    {
        if(!aliasTextField.equals("") || aliasTextField == null)
        {
            vm.setAlias();
            vh.openChat();

        }

    }
}
