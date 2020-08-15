package space.lopatkin.spb.stalkerapp.utils;

import android.os.AsyncTask;

import java.io.*;

import static space.lopatkin.spb.stalkerapp.CharacterJava.resultView;

public class ThreadAsyncTask extends AsyncTask<String, Void, String> {

//    Socket socket;
//    String serverHost = "10.0.2.2";
//    int serverPort = 80;
//    BufferedWriter writer;
//    BufferedReader reader;
//    String messageFromServer;

    @Override
    protected String doInBackground(String... voids) {

        String sendData = voids[0];
        String messageFromServer = null;

//        // Если сокет уже открыт, то он закрывается
//        if (socket != null && !socket.isClosed()) {
//            try {
//                socket.close();
//            } catch (IOException e) {
//                System.out.println("Ошибка при закрытии сокета :");
//            } finally {
//                socket = null;
//            }
//        }
//        socket = null;
        ConnectionAsyncTask connectionAsyncTask = new ConnectionAsyncTask();
        try {
            connectionAsyncTask.openConnection();
            messageFromServer = connectionAsyncTask.getData(sendData);
            connectionAsyncTask.closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
//            // Создание сокета
//            socket = new Socket(serverHost, serverPort);
//            System.out.println("Сокет создан");


//            writer = new BufferedWriter(
//                    new OutputStreamWriter(socket.getOutputStream()));
//            writer.write(data);
//            writer.newLine();
//            writer.flush();



//        reader = new BufferedReader(
//                    new InputStreamReader(socket.getInputStream()));
//            messageFromServer = reader.readLine();
//            System.out.println("reader = " + reader);
//            System.out.println("messageFromServer = " + messageFromServer);


//            writer.close();
//            reader.close();
//            socket.close();
//            System.out.println("close socket");


//        } catch (IOException e) {
//            System.out.println("Невозможно создать сокет");
//            messageFromServer = "Невозможно создать сокет";
//        }

        return messageFromServer;
    }



    @Override
    protected void onPostExecute(String messageFromServer) {
        resultView.setText(messageFromServer);
    }


}
