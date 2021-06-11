package Assignment3.client.model;

import Assignment3.shared.transferobjects.Message;
import Assignment3.shared.util.PropertyChangeSubject;

import java.util.List;

public interface ModelClient extends PropertyChangeSubject
{
    void setId(String id);
    List<String> getIds();
    List<Message> getAllMessages();
    void sendMessage(Message msg);
    String getAlias();

    void sendDirectMessage(Message msg);
}
