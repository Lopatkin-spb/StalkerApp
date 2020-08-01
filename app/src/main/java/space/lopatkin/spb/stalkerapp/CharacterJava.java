package space.lopatkin.spb.stalkerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CharacterJava extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_character;

    //damage blood от 0 до 10
    //ввести урон для теста
    int damage = 7;
    int bloodAfterDamage = 10 - damage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        statusBarOFF();
        backToMainMenuButton();
        drawBloodBar();

    }


    private void drawBloodBar() {
        //массив для прогресса крови
        final int[] progressBlood = {
                R.id.pointBlood1,
                R.id.pointBlood2,
                R.id.pointBlood3,
                R.id.pointBlood4,
                R.id.pointBlood5,
                R.id.pointBlood6,
                R.id.pointBlood7,
                R.id.pointBlood8,
                R.id.pointBlood9,
                R.id.pointBlood10
        };
        //закрашиваем прогресс крови темным цветом
        for (int i = 0; i < 10; i++) {
            TextView tv = findViewById(progressBlood[i]);
            tv.setBackgroundResource(R.drawable.style_points_blood_damage);
        }
        //закрашиваем прогресс крови Светлым цветом
        for (int i = 0; i < bloodAfterDamage; i++) {
            TextView tv = findViewById(progressBlood[i]);
            tv.setBackgroundResource(R.drawable.style_points_blood);
        }
    }

    private void backToMainMenuButton() {
        //кнопка назад в меню
        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(CharacterJava.this, MenuJava.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });
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
            Intent intent = new Intent(CharacterJava.this, MenuJava.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }


}
