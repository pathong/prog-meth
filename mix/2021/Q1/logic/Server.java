package logic;

import javax.swing.event.ChangeEvent;
import java.util.ArrayList;

public class Server {
    private String name;
    private User owner;
    private ArrayList<Channel> channelList;
    private ArrayList<User> memberList;

    public Server(String name, User owner, TemplateType template){
        setOwner(owner);
        channelList = new ArrayList<Channel>();
        memberList = new ArrayList<User>();

        addUser(this.owner);
        setName(name);

        switch (template){
            case BASIC:
                addChannel(owner, "general");
                break;
            case GAMING:
                addChannel(owner, "gaming");
                break;
            case STUDY:
                addChannel(owner, "homework-help");
                break;
        }
    }
    public Channel addChannel(User user, String channelName){
        if(user != this.owner){return null;}
        Channel createdChannel = new Channel(channelName);
        channelList.add(createdChannel);
        return createdChannel;
    }


    public User addUser(User user){
        if(!memberList.contains(user)){
            memberList.add(user);
            user.addJoinedServersList(this);
            return user;
        }
        return null;
    }


    public boolean kickUser(User kicker, User kicked) throws Exception{
        if(kicker != this.owner){
            throw new Exception();
        }
        else if(kicker == this.owner && (kicked == this.owner || !memberList.contains(kicked))){
            return false;
        }
        else{
            kicked.getJoinedServersList().remove(this);
            memberList.remove(kicked);
            return true;
        }
    }



    public void setOwner(User toBeOwner){
        this.owner = toBeOwner;
    }

    public void setName(String name){
        if(name.isBlank()){
            this.name = owner.getName() + " home";
        }
        else{
            this.name = name;
        }
    }

    public String getName(){return this.name;}
    public User getOwner(){return this.owner;}
    public ArrayList<Channel> getChannelList(){return channelList;}
    public ArrayList<User> getMemberList(){return memberList;}


}
