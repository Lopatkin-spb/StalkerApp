package space.lopatkin.spb.stalkerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
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
    //int bloodAfterDamage = 10 - damage;
    int bloodAfterDamage = 0;
    int counterBlood = 0;
    int radiation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        //навигация
        statusBarOFF();
        backToMainMenuButton();

        redrawingBloodBar();
        redrawingRadiationBar();
        aidkits();

    }

    private void aidkits() {
        final Button buttonSmallAid = (Button) findViewById(R.id.smallAid);
        final Button buttonScientificAid = (Button) findViewById(R.id.scientificAid);
        final Button buttonArmyAid = (Button) findViewById(R.id.armyAid);

        buttonSmallAid.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    //блокировка других аптечек во избежание одновременного нажатия
                    buttonScientificAid.setEnabled(false);
                    buttonArmyAid.setEnabled(false);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    bloodAfterDamage = bloodAfterDamage + 1;
                    redrawingBloodBar();
                }
                buttonScientificAid.setEnabled(true);
                buttonArmyAid.setEnabled(true);
                return false;
            }
        });
        buttonArmyAid.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    //блокировка других аптечек во избежание одновременного нажатия
                    buttonScientificAid.setEnabled(false);
                    buttonSmallAid.setEnabled(false);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    bloodAfterDamage = bloodAfterDamage + 2;
                    redrawingBloodBar();
                }
                buttonScientificAid.setEnabled(true);
                buttonSmallAid.setEnabled(true);
                return false;
            }
        });
        buttonScientificAid.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    //блокировка других аптечек во избежание одновременного нажатия
                    buttonSmallAid.setEnabled(false);
                    buttonArmyAid.setEnabled(false);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    bloodAfterDamage = bloodAfterDamage + 3;
                    redrawingBloodBar();
                    radiation = radiation + 4;
                    redrawingRadiationBar();
                }
                buttonSmallAid.setEnabled(true);
                buttonArmyAid.setEnabled(true);
                return false;
            }
        });
    }


    private void redrawingBloodBar() {
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
            tv.setBackgroundResource(R.drawable.style_points_blood_off);
        }
        //закрашиваем прогресс крови Светлым цветом
        for (int i = 0; i < bloodAfterDamage; i++) {
            TextView tv = findViewById(progressBlood[i]);
            tv.setBackgroundResource(R.drawable.style_points_blood_on);
        }
    }

    private void redrawingRadiationBar() {
        //массив для прогресса радиации
        final int[] progressRadiation = {
                R.id.pointRadiation1,
                R.id.pointRadiation2,
                R.id.pointRadiation3,
                R.id.pointRadiation4,
                R.id.pointRadiation5,
                R.id.pointRadiation6,
                R.id.pointRadiation7,
                R.id.pointRadiation8,
                R.id.pointRadiation9,
                R.id.pointRadiation10
        };
        //закрашиваем прогресс радиации темным цветом
        for (int i = 0; i < 10; i++) {
            TextView tv = findViewById(progressRadiation[i]);
            tv.setBackgroundResource(R.drawable.style_points_radiation_off);
        }
        //закрашиваем прогресс радиации Светлым цветом
        for (int i = 0; i < radiation; i++) {
            TextView tv = findViewById(progressRadiation[i]);
            tv.setBackgroundResource(R.drawable.style_points_radiation_on);
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
