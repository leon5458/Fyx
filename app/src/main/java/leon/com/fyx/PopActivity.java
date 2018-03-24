package leon.com.fyx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/3/24<p>
 * <p>更改时间：2018/3/24<p>
 * <p>版本号：1<p>
 */
public class PopActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv;
    private PopupWindow mPopWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popactivity_layout);
        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow();
            }
        });
    }

    private void showPopupWindow() {
        View contentView = LayoutInflater.from(PopActivity.this).inflate(R.layout.popuplayout, null);
        mPopWindow = new PopupWindow(contentView);
        mPopWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView text = contentView.findViewById(R.id.pop_text);
        text.setOnClickListener(this);
        mPopWindow.showAsDropDown(tv);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.pop_text:
//                mPopWindow.dismiss();
                break;
        }
    }


}
