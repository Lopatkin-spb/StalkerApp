package space.lopatkin.spb.stalkerapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import space.lopatkin.spb.stalkerapp.utils.ThreadAsyncTask;


public class CharacterJava extends AppCompatActivity {

    private static final int LayoutUI = R.layout.activity_character;
    private Button buttonBack;
    private Button buttonSmallAid;
    private Button buttonScientificAid;
    private Button buttonArmyAid;
    public static TextView resultView;
    private String data = "small_aidkit";

    private ThreadAsyncTask threadAsyncTask = new ThreadAsyncTask();


    private String getMessage = new String();




    int bloodAfterDamage = 0;
    int counterBlood = 0;
    int radiation = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutUI);

        buttonSmallAid = (Button) findViewById(R.id.smallAid);
        buttonScientificAid = (Button) findViewById(R.id.scientificAid);
        buttonArmyAid = (Button) findViewById(R.id.armyAid);
        resultView = (TextView) findViewById(R.id.resultView);

        //test
        Button testSocketAsyncThread = (Button) findViewById(R.id.testSocketAsyncThread);
        testSocketAsyncThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestToServer();
            }
        });
        Button testSocketClass = (Button) findViewById(R.id.testSocketClass);
        testSocketClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.setText("пустое действие");
            }
        });


        //навигация
        statusBarOFF();
        backToMainMenuButton();

        redrawingBloodBar();
        redrawingRadiationBar();
        aidkits();


    }


    private void requestToServer() {
        threadAsyncTask = new ThreadAsyncTask();
        threadAsyncTask.execute(data);
    }


    private void aidkits() {

        buttonSmallAid.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                try {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        //блокировка других аптечек во избежание одновременного нажатия при нажатии пальцем
                        buttonScientificAid.setEnabled(false);
                        buttonArmyAid.setEnabled(false);
                    } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        //отрисовка жизни после отрыва пальца от картинки
                        bloodAfterDamage = bloodAfterDamage + 1;
                        //messageToSocket = "small aidkit";
                        createAndShowDialogWindow();
                    }
                    //разблокировка залоченных елементов
                    buttonScientificAid.setEnabled(true);
                    buttonArmyAid.setEnabled(true);
                } catch (Exception e) {
                }
                return false;
            }
        });
        buttonArmyAid.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                try {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        //блокировка других аптечек во избежание одновременного нажатия при нажатии пальцем
                        buttonScientificAid.setEnabled(false);
                        buttonSmallAid.setEnabled(false);
                    } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        //отрисовка жизни после отрыва пальца от картинки
                        bloodAfterDamage = bloodAfterDamage + 2;
                        createAndShowDialogWindow();
                    }
                    //разблокировка залоченных елементов
                    buttonScientificAid.setEnabled(true);
                    buttonSmallAid.setEnabled(true);
                } catch (Exception e) {
                }
                return false;
            }
        });
        buttonScientificAid.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                try {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        //блокировка других аптечек во избежание одновременного нажатия при нажатии пальцем
                        buttonSmallAid.setEnabled(false);
                        buttonArmyAid.setEnabled(false);
                    } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        //отрисовка жизни после отрыва пальца от картинки
                        bloodAfterDamage = bloodAfterDamage + 3;
                        radiation = radiation + 4;
                        createAndShowDialogWindow();
                    }
                    //разблокировка залоченных елементов
                    buttonSmallAid.setEnabled(true);
                    buttonArmyAid.setEnabled(true);
                } catch (Exception e) {
                }
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


    private void createAndShowDialogWindow() {
        AlertDialog.Builder builder = new AlertDialog.Builder(CharacterJava.this);
        builder.setTitle("Диалоговое окно")
                .setMessage("Использовать предмет?")
                .setCancelable(false)
                .setNeutralButton("Выбросить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//прописать действие
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//прописать действие
                    }
                })
                .setPositiveButton("Использовать", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            //onOpenClick();
                            threadAsyncTask = new ThreadAsyncTask();
                            threadAsyncTask.execute(data);

                            //send();

                            //test
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "ответ сервера - " + getMessage, Toast.LENGTH_LONG);
                            toast.show();

                            redrawingBloodBar();
                            redrawingRadiationBar();
                        } catch (Exception e) {
                        }
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private void backToMainMenuButton() {
        //кнопка назад в меню
        buttonBack = (Button) findViewById(R.id.buttonBack);
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
        //убирает строку состояния батареи и тд в приложении
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
