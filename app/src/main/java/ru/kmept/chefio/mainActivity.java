package ru.kmept.chefio;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mainActivity extends AppCompatActivity {

    private TextView timerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);

        timerTextView = findViewById(R.id.labelTimer);

        // Время в миллисекундах (3 минуты и 12 секунд)
        long totalTimeInMillis = 3 * 60 * 1000 + 12 * 1000;

        new CountDownTimer(totalTimeInMillis, 1000) {

            public void onTick(long millisUntilFinished) {
                // Преобразование миллисекунд в минуты и секунды
                long minutes = millisUntilFinished / 60000;
                long seconds = (millisUntilFinished % 60000) / 1000;

                // Отображение времени в формате "минуты:секунды"
                timerTextView.setText(String.format("%02d:%02d", minutes, seconds));
            }

            public void onFinish() {
                // Действия по окончании отсчета
                timerTextView.setText("00:00");
                // Дополнительные действия, если необходимо
            }
        }.start();
    }
}
