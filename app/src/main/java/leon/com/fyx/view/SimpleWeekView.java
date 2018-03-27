package leon.com.fyx.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.WeekView;

/**
 * <p>类名：leon.com.fyx.view<p>
 * <p>文件描述：<p>
 * <p>作者：h.yw<p>
 * <p>创建时间：2018/3/27 10:15<p>
 * <p>更改时间：2018/3/27 10:15<p>
 * <p>版本号：1<p>
 */

public class SimpleWeekView extends WeekView {
    private int mRadius;


    public SimpleWeekView(Context context) {
        super(context);
    }

    @Override
    protected void onPreviewHook() {
        mRadius = Math.min(mItemWidth, mItemHeight) / 5 * 2;
        mSchemePaint.setStyle(Paint.Style.STROKE);
        mSchemePaint.setShadowLayer(15, 1, 3, 0xAA333333);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, boolean hasScheme) {
        int cx = x + mItemWidth / 2;
        int cy = mItemHeight / 2;
        canvas.drawCircle(cx, cy, mRadius, mSelectedPaint);
        return false;
    }

    @Override
    protected void onDrawScheme(Canvas canvas, Calendar calendar, int x) {
        int cx = x + mItemWidth / 2;
        int cy = mItemHeight / 2;
        canvas.drawCircle(cx, cy, mRadius, mSchemePaint);
    }

    @Override
    protected void onDrawText(Canvas canvas, Calendar calendar, int x, boolean hasScheme, boolean isSelected) {
        float baselineY = mTextBaseLine;
        int top = -mItemHeight / 6;
        int cx = x + mItemWidth / 2;
        if (!TextUtils.isEmpty(calendar.getTraditionFestival())){
            drawText(canvas,calendar,x,hasScheme,isSelected,cx,top);

        }else if (!TextUtils.isEmpty(calendar.getGregorianFestival())){
            drawText(canvas,calendar,x,hasScheme,isSelected,cx,top);

        }else if (!TextUtils.isEmpty(calendar.getSolarTerm())){
            drawText(canvas,calendar,x,hasScheme,isSelected,cx,top);
        }else{
            if (isSelected) {
                canvas.drawText(String.valueOf(calendar.getDay()),
                        cx,
                        baselineY,
                        mSelectTextPaint);
                canvas.drawText(calendar.getLunar(), cx, mTextBaseLine + mItemHeight / 10, mSelectedLunarTextPaint);

            } else if (hasScheme) {
                canvas.drawText(String.valueOf(calendar.getDay()),
                        cx,
                        baselineY,
                        calendar.isCurrentDay() ? mCurDayTextPaint :
                                calendar.isCurrentMonth() ? mSchemeTextPaint : mSchemeTextPaint);

            } else {
                canvas.drawText(String.valueOf(calendar.getDay()), cx, baselineY,
                        calendar.isCurrentDay() ? mCurDayTextPaint :
                                calendar.isCurrentMonth() ? mCurMonthTextPaint : mCurMonthTextPaint);
            }
        }
    }

    private void drawText(Canvas canvas, Calendar calendar, int x, boolean hasScheme, boolean isSelected,int cx,int top){
        if (isSelected) {
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    mSelectTextPaint);
            canvas.drawText(calendar.getLunar(), cx, mTextBaseLine + mItemHeight / 10, mSelectedLunarTextPaint);
        } else if (hasScheme) {
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    calendar.isCurrentMonth() ? mSchemeTextPaint : mOtherMonthTextPaint);

            canvas.drawText(calendar.getLunar(), cx, mTextBaseLine + mItemHeight / 10, mSchemeLunarTextPaint);
        } else {
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    calendar.isCurrentDay() ? mCurDayTextPaint :
                            calendar.isCurrentMonth() ? mCurMonthTextPaint : mOtherMonthTextPaint);
            canvas.drawText(calendar.getLunar(), cx, mTextBaseLine + mItemHeight / 10,
                    calendar.isCurrentDay() ? mCurDayLunarTextPaint :
                            calendar.isCurrentMonth() ? mCurMonthLunarTextPaint : mOtherMonthLunarTextPaint);
        }
    }
}
