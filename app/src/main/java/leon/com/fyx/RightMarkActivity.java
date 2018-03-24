package leon.com.fyx;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import leon.com.fyx.view.RightMark;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/3/23<p>
 * <p>更改时间：2018/3/23<p>
 * <p>版本号：1<p>
 */
public class RightMarkActivity extends AppCompatActivity{
    private RightMark markview;
    private Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rightmark_layout);
        markview = (RightMark) findViewById(R.id.right_mark_view);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                markview.start();
            }
        });
    }
}
