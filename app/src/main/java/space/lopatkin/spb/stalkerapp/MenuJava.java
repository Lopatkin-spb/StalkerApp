package space.lopatkin.spb.stalkerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuJava extends AppCompatActivity {


    private static final int LayoutUI = R.layout.activity_menu;
    private Button buttonBack;
    private Button buttonMap;
    private Button buttonDiary;
    private Button buttonContacts;
    private Button buttonRank;
    private Button buttonCharacter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutUI);

        statusBarOFF();

        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonMap = (Button) findViewById(R.id.buttonMap);
        buttonDiary = (Button) findViewById(R.id.buttonDiary);
        buttonContacts = (Button) findViewById(R.id.buttonContacts);
        buttonRank = (Button) findViewById(R.id.buttonRank);
        buttonCharacter = (Button) findViewById(R.id.buttonCharacter);
        //кнопка назад
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEnterMenu();
            }
        });
        //кнопка входа на карту
        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMapMenu();
            }
        });
        //кнопка входа на дневник
        buttonDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiaryMenu();
            }
        });
        //кнопка входа на контакты
        buttonContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openContactsMenu();
            }
        });
        //кнопка входа на вкладку рангов\место в рейтинге по очкам
        buttonRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRankMenu();
            }
        });
        //кнопка входа на вкладку персонаж
        buttonCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCharacterMenu();
            }
        });
    }

    private void openRankMenu() {
        try {
            Intent intent = new Intent(MenuJava.this, RankJava.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }

    private void openContactsMenu() {
        try {
            Intent intent = new Intent(MenuJava.this, ContactsJava.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }

    private void openDiaryMenu() {
        try {
            Intent intent = new Intent(MenuJava.this, DiaryJava.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }

    private void openMapMenu() {
        try {
            Intent intent = new Intent(MenuJava.this, MapJava.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }

    private void openEnterMenu() {
        try {
            Intent intent = new Intent(MenuJava.this, EnterJava.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }


    private void openCharacterMenu() {
        try {
            Intent intent = new Intent(MenuJava.this, CharacterJava.class);
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


    @Override
    public void onBackPressed() {
        //системная (телефонная) кнопка назад
        try {
            Intent intent = new Intent(MenuJava.this, EnterJava.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }


}
