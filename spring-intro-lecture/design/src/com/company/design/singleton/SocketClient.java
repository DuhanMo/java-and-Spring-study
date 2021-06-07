package com.company.design.singleton;

public class SocketClient {

    private static SocketClient socketClient;

    // 디폴트 생성자를 막고
    // getInstance를 통해서 만든다.
    private SocketClient(){

    }

    public static SocketClient getInstance(){
        if(socketClient == null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }
    public void connect(){
        System.out.println("connect");
    }
}
