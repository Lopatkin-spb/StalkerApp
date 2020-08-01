package space.lopatkin.spb.stalkerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ContactsJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        //убирает строку состояния батареи в приложении и тд
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //кнопка назад
        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(ContactsJava.this, MenuJava.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });



    }


    //системная (телефонная) кнопка назад
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(ContactsJava.this, MenuJava.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }




}
