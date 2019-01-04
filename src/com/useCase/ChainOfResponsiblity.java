package com.useCase;

public class ChainOfResponsiblity {
    public static void main(String args[]){
        AbstractCallCenter c1 = new Fresher();
        AbstractCallCenter c2 = new TeamLead();
        AbstractCallCenter c3 = new ProjectManager();
        c1.setCaller(c2);
        c2.setCaller(c3);
        c1.handleCall("caller1");
    }
}

abstract class AbstractCallCenter{
    public void setCaller(AbstractCallCenter caller){
        this.callCenter=caller;
    }
    AbstractCallCenter callCenter;
    abstract void handleCall(String  call);
}

class Fresher extends  AbstractCallCenter{
    AbstractCallCenter caller;
    @Override
    public void setCaller(AbstractCallCenter caller) {
        this.caller = caller;
    }

    @Override
    void handleCall(String call) {
        System.out.println("Fresher is handling the call for message " + call);
        caller.handleCall(call);
    }
}
class TeamLead extends AbstractCallCenter{
    AbstractCallCenter caller;
    @Override
    public void setCaller(AbstractCallCenter caller) {
        this.caller = caller;
    }

    @Override
    void handleCall(String call) {
        System.out.println("Call is been forwarded... TeamLead is handling the call.");
        caller.handleCall(call);
    }
}
class ProjectManager extends  AbstractCallCenter{
    @Override
    public void setCaller(AbstractCallCenter caller) {
        this.caller = caller;
    }
    AbstractCallCenter caller;
    @Override
    void handleCall(String call) {
        System.out.println("Call is been forwarded... Now  ProjectManager  is handling the call.");
        //caller.handleCall(call); no need to call if i want to stop.
    }
}