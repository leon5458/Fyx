package leon.com.fyx.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;

import com.haibin.calendarview.Calendar;

import leon.com.fyx.R;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/3/24<p>
 * <p>更改时间：2018/3/24<p>
 * <p>版本号：1<p>
 */
public class WeekBar extends com.haibin.calendarview.WeekBar {

    private int mPreSelectedIndex;

    public WeekBar(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.week_bar, this, true);
        setBackgroundColor(Color.WHITE);
    }

    @Override
    protected void onDateSelected(Calendar calendar, boolean isClick) {
        getChildAt(mPreSelectedIndex).setSelected(false);
        getChildAt(calendar.getWeek()).setSelected(true);
        mPreSelectedIndex = calendar.getWeek();
    }
}
