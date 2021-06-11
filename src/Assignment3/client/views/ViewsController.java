package Assignment3.client.views;

import Assignment3.client.core.ViewHandler;
import Assignment3.client.core.ViewModelFactory;

import java.io.IOException;

public interface ViewsController
{
    void init(ViewHandler vh, ViewModelFactory vmf) throws IOException;
}
