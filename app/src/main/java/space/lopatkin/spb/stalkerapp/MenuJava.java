package space.lopatkin.spb.stalkerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        statusBarOFF();
        menuNavigation();

    }

    private void statusBarOFF() {
        //убирает строку состояния батареи в приложении и тд
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    private void menuNavigation() {
        //кнопка назад
        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MenuJava.this, EnterJava.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });

        //кнопка входа на карту
        Button buttonMap = (Button) findViewById(R.id.buttonMap);
        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MenuJava.this, MapJava.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });

        //кнопка входа на дневник
        Button buttonDiary = (Button) findViewById(R.id.buttonDiary);
        buttonDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MenuJava.this, DiaryJava.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });

        //кнопка входа на контакты
        Button buttonContacts = (Button) findViewById(R.id.buttonContacts);
        buttonContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MenuJava.this, ContactsJava.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });

        //кнопка входа на вкладку рангов\место в рейтинге по очкам
        Button buttonRank = (Button) findViewById(R.id.buttonRank);
        buttonRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MenuJava.this, RankJava.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });

        //кнопка входа на вкладку персонаж
        Button buttonCharacter = (Button) findViewById(R.id.buttonCharacter);
        buttonCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MenuJava.this, CharacterJava.class);
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
            Intent intent = new Intent(MenuJava.this, EnterJava.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }




}
