package space.lopatkin.spb.stalkerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DiaryJava extends AppCompatActivity {

    private static final int LayoutUI = R.layout.activity_diary;
    private Button buttonBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutUI);

        statusBarOFF();

        //кнопка назад
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainMenu();
            }
        });



    }


    private void openMainMenu() {
        try {
            Intent intent = new Intent(DiaryJava.this, MenuJava.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }

    private void statusBarOFF() {
        //убирает строку состояния батареи в приложении и тд
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    //системная (телефонная) кнопка назад
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(DiaryJava.this, MenuJava.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }




}
