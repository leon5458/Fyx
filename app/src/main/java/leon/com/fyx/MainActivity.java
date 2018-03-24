package leon.com.fyx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView bomb, calendar, clip, right, menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bomb = (TextView) findViewById(R.id.bomb);
        bomb.setOnClickListener(new View.OnClickListener() {//弹框
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BombboxActivity.class));
            }
        });
        calendar = (TextView) findViewById(R.id.calendar);
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//日历
                startActivity(new Intent(MainActivity.this, CalendarActivity.class));
            }
        });
        clip = (TextView) findViewById(R.id.clip);
        clip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//画廊
                startActivity(new Intent(MainActivity.this, GalleryActivity.class));
            }
        });
        right = (TextView) findViewById(R.id.right);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//对号
                startActivity(new Intent(MainActivity.this, RightMarkActivity.class));
            }
        });
        menu = (TextView) findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//侧滑
                startActivity(new Intent(MainActivity.this, LMenuActivity.class));
            }
        });
    }
}
