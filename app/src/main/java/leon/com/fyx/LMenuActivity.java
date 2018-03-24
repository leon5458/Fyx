package leon.com.fyx;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import leon.com.fyx.view.WaterHorizontalLoader;
/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/3/23<p>
 * <p>更改时间：2018/3/23<p>
 * <p>版本号：1<p>
 */
public class LMenuActivity extends AppCompatActivity {
//    private SlidingMenu mMenu;
    private WaterHorizontalLoader bezierCircle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lemnuac_layout);
//        mMenu = (SlidingMenu) findViewById(R.id.id_menu);
        bezierCircle = (WaterHorizontalLoader) findViewById(R.id.bezier_view);
        bezierCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bezierCircle.startAnim();
            }
        });
    }

//    public void toggleMenu(View view) {
//        mMenu.toggle();
//        bezierCircle.startAnim();
//    }

}
