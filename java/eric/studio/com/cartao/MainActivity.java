package eric.studio.com.cartao;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int contador = 0;

    private String[] linhas = {"Especificações","Engenharia de Software - UFG", "Estágiario em Desenvolvimento", "Desenvolvimento Multiplataforma"};

    private TextSwitcher tw;

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tw = findViewById(R.id.textSwicher);



        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        if(contador == linhas.length - 1){

                            contador = 0;
                            tw.setText(linhas[contador]);

                        } else {

                            tw.setText(linhas[++contador]);

                        }

                    }
                });
            }
        }, 100, 5000);





        tw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                tv = new TextView(MainActivity.this);
                tv.setTextColor(Color.BLACK);
                tv.setTextSize(18);
                tv.setGravity(Gravity.CENTER_HORIZONTAL);
                return tv;
            }
        });

        tw.setText(linhas[contador]);
    }
}
