package space.lopatkin.spb.stalkerapp.utils;


import java.net.*;
import java.io.*;


public class ConnectionAsyncTask {
    //все операции с сетью следует выполнять в другом от  главного потоке, иначе апп будет крашиться
    //нужен для создания отдельного потока для тяжеловесных задач
    // асингтаск обьявили устаревшим, он приводит к утечкам памяти 2019.
    // но есть решения грамотного использования без утечек.
    // сделаю плохо, чтобы пока работало. в будущем пересмотреть и переделать
    // в безопасный и правильный код


    private Socket clientSocket = null;
    private String clientHost = "10.0.2.2";
    private int clientPort = 80;

    public ConnectionAsyncTask() {
    }

    public ConnectionAsyncTask(final String host, final int port) {
        this.clientHost = host;
        this.clientPort = port;
    }

    /**
     * Метод открытия сокета
     */
    public void openConnection() throws Exception {
        // Если сокет уже открыт, то он закрывается
        closeConnection();
        try {
            // Создание сокета
            clientSocket = new Socket(clientHost, clientPort);
            System.out.println("Сокет создан");
        } catch (IOException e) {
            //throw new Exception("Невозможно создать сокет: " + e.getMessage());
            System.out.println("Невозможно создать сокет");
        }
    }

    /**
     * Метод закрытия сокета
     */
    public void closeConnection() throws IOException {
        /* Проверяем сокет. Если он не зарыт, то закрываем его и освобдождаем соединение.*/
        if (clientSocket != null && !clientSocket.isClosed()) {
            try {
                clientSocket.close();
            } catch (IOException e) {
                //System.out.println("Невозможно закрыть сокет: " + e.getMessage());
                System.out.println("Ошибка при закрытии сокета");
            } finally {
                clientSocket = null;
            }
        }
        clientSocket = null;
    }

    /**
     * Метод отправки данных
     */
    public String getData(String data) throws Exception {

        String sendData = null;

        // Проверка открытия сокета
        if (clientSocket == null || clientSocket.isClosed()) {
            //throw new Exception("Невозможно отправить данные. Сокет не создан или закрыт");
            System.out.println("Невозможно отправить данные. Сокет не создан или закрыт");
        }
        // Отправка данных
        try {

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream()));
            writer.write(data);
            writer.newLine();
            writer.flush();


            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            sendData = reader.readLine();
            System.out.println("reader = " + reader);
            System.out.println("messageFromServer = " + sendData);

            writer.close();
            reader.close();


        } catch (IOException e) {
            //throw new Exception("Невозможно отправить данные: " + e.getMessage());
            System.out.println("Ошибка отправки данных");
        }

        return sendData;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        closeConnection();
    }
}
