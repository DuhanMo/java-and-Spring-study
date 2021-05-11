package com.company.design.singleton;

public class AClazz {
    private SocketClient socketClient;

    public AClazz(){
        this.socketClient = SocketClient.getInstance();
//        this.socketClient = new SocketClient();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
