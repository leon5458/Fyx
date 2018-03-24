package leon.com.fyx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import leon.com.fyx.view.PswText;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/3/24<p>
 * <p>更改时间：2018/3/24<p>
 * <p>版本号：1<p>
 */
public class InputActivity extends AppCompatActivity{
    private PswText pswtext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.input_layout);
        pswtext = (PswText) findViewById(R.id.input_pswtext);
        pswtext.setInputCallBack(new PswText.InputCallBack() {
            @Override
            public void onInputFinish(String password) {
            }
        });

    }
}
