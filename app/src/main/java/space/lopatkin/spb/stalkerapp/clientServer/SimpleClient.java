package space.lopatkin.spb.stalkerapp.clientServer;

import space.lopatkin.spb.stalkerapp.CharacterJava;

import java.net.*;
import java.io.*;


public class SimpleClient {

    public void send() throws IOException {

        CharacterJava characterJava = new CharacterJava();
        characterJava.messageццццццццццц = "do soketa";

        //Socket clientSocket = new Socket("Denis-KEY", 8000);
        Socket clientSocket = new Socket("10.0.2.2", 8000);

        characterJava.messageццццццццццц = "posle soketa";


        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(clientSocket.getOutputStream()));
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));


        String messageToServer = "запрос";


        writer.write(messageToServer);
        writer.newLine();
        writer.flush();

        characterJava.messageццццццццццц = "posle otpravki";


        String messageFromServer = reader.readLine();


        characterJava.otvetOtServaka = messageFromServer;


        System.out.println(messageFromServer);
        writer.close();
        reader.close();
        clientSocket.close();

    }

}
