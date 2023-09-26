package logic;


import java.util.ArrayList;

public class Channel {
    private String name;
    private ArrayList<Message> messageList;


    public Channel(String name){
        setName(name);
        messageList = new ArrayList<Message>();
    }

    public void addMessage(Message message){
        getMessageList().add(message);
    }


    public void setName(String name){
        if(name.isBlank()){
            this.name = "off-topic";
            return;
        }
        this.name = name;
    }
    public int getMessageCount(){
        return getMessageList().size();

    }


    public String getName(){return this.name;}
    public ArrayList<Message> getMessageList(){return messageList;}
}

