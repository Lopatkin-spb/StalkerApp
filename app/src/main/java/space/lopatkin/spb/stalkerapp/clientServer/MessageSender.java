package space.lopatkin.spb.stalkerapp.clientServer;

/*public class MessageSender extends AsyncTask<String, Void, Void> {
//в андроид сокеты по умолчанию используют протокол TCP\IP - гарантирует доставку пакетов
(UPD менее надежен при доставке пакетов)
все операции с сетью следует выполнять в другом от  главного потоке, иначе апп будет крашиться
    //нужен для создания отдельного потока для тяжеловесных задач
    // асингтаск обьявили устаревшим, он приводит к утечкам памяти 2019.
    // но есть решения грамотного использования без утечек.
    // сделаю плохо, чтобы пока работало. в будущем пересмотреть и переделать
    // в безопасный и правильный код



    Socket socket;
    DataOutputStream dataOutputStream;
    PrintWriter printWriter;


    @Override
    protected Void doInBackground(String... voids) {

        String message1 = voids[0];


        try {
            //socket = new Socket("127.0.0.1", 80);
            //printWriter = new PrintWriter(socket.getOutputStream());
            //printWriter.write(message1);
            //printWriter.flush();
            //printWriter.close();
            //socket.close();

            socket = new Socket("india.colorado.edu", 80);
Scanner otvet = new Scanner(socket.getOutputStream());


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }



        return null;
    }

}


 */


import android.widget.Toast;






