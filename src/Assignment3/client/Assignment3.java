package Assignment3.client;

import Assignment3.client.core.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class Assignment3 extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ViewHandler.getInstance().start();
    }
}
