package Assignment3.client.views.view1;

import Assignment3.client.model.ModelClient;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{
    private StringProperty aliasT;
    private ModelClient model;


    public LoginViewModel(ModelClient model)
    {
        this.model = model;
        aliasT = new SimpleStringProperty();
    }

    public void setAlias()
    {
        model.setId(aliasT.get());
    }

    public StringProperty aliasTProperty()
    {
        return aliasT;
    }
}
