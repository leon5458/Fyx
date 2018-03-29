package leon.com.fyx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;

import java.util.Arrays;

import leon.com.fyx.adapter.FyxRecyclerAdapter;
import leon.com.fyx.utils.ItemOffsetDecoration;
import leon.com.fyx.utils.WViewHolder;


/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/3/23<p>
 * <p>更改时间：2018/3/23<p>
 * <p>版本号：1<p>
 */
public class CalendarActivity extends AppCompatActivity implements CalendarView.OnDateSelectedListener,
        CalendarView.OnMonthChangeListener,
        CalendarView.OnYearChangeListener,
        CalendarView.OnDateLongClickListener {

    private CalendarView mCalendarView;
    private TextView mTextYear;
    private TextView mTextMouth;
    private CardView last_week;
    private CardView next_week;
    private ImageView last_mouth;
    private ImageView next_mouth;
    private TextView detailstime;


    private RecyclerView recyclerView;

    private TextView moring;
    private TextView afternoon;
    String moringtime[] = new String[]{"08:30", "08:45", "09:00", "09:15", "09:30", "09:45",
            "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45"};

    String afternoontime[] = new String[]{"13:30", "13:45", "14:00", "14:15", "14:30", "14:45",
            "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendaractivity_layout);
        initData();
        recyclerView = (RecyclerView) findViewById(R.id.recy_time);
        FyxRecyclerAdapter adapter = new FyxRecyclerAdapter(this, R.layout.recy_time_item, Arrays.asList(moringtime));
        recyclerView.setLayoutManager(new GridLayoutManager(CalendarActivity.this, 4));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.padding_middle);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
        adapter.setCallBack(new FyxRecyclerAdapter.CallBack() {
            @Override
            public <T> void convert(WViewHolder holder, T bean, int position) {
                holder.setText(R.id.time_text, (String) bean);
            }
        });
        adapter.setOnItemClickListner(new FyxRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                detailstime.setText(moringtime[position]);
            }
        });


        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mTextYear = (TextView) findViewById(R.id.year);
        mTextMouth = (TextView) findViewById(R.id.mouth);
        detailstime = (TextView) findViewById(R.id.details_time);
        last_week = (CardView) findViewById(R.id.last_week);
        next_week = (CardView) findViewById(R.id.next_week);
        last_mouth = (ImageView) findViewById(R.id.last_mouth);
        next_mouth = (ImageView) findViewById(R.id.next_mouth);

        mCalendarView.setOnYearChangeListener(this);
        mCalendarView.setOnDateSelectedListener(this);
        mCalendarView.setOnMonthChangeListener(this);
        mCalendarView.setOnDateLongClickListener(this);


        last_week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalendarView.scrollToPreWeek();
            }
        });
        next_week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalendarView.scrollToNextWeek();
            }
        });
        last_mouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalendarView.scrollToPre();
            }
        });
        next_mouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalendarView.scrollToNext();
            }
        });

        moring = (TextView) findViewById(R.id.moring);
        afternoon = (TextView) findViewById(R.id.afternoon);
        moring.setBackgroundResource(R.drawable.gray_drawable);
        moring.setTextColor(getResources().getColor(R.color.white));
        afternoon.setTextColor(getResources().getColor(R.color.blue));
        moring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moring.setBackgroundResource(R.drawable.gray_drawable);
                moring.setTextColor(getResources().getColor(R.color.white));
                afternoon.setTextColor(getResources().getColor(R.color.blue));
                afternoon.setBackgroundResource(0);
                FyxRecyclerAdapter adapter = new FyxRecyclerAdapter(CalendarActivity.this, R.layout.recy_time_item, Arrays.asList(moringtime));
                recyclerView.setAdapter(adapter);
                adapter.setCallBack(new FyxRecyclerAdapter.CallBack() {
                    @Override
                    public <T> void convert(WViewHolder holder, T bean, int position) {
                        TextView hint = (TextView) holder.getView(R.id.item_hint);
                        FrameLayout rootlayout = (FrameLayout) holder.getView(R.id.item_rootlayout);
                        TextView name = (TextView) holder.getView(R.id.time_text);
                        hint.setText(position % 2==0 ? "" : "闲");
                        rootlayout.setBackgroundResource(position % 2 == 0 ? R.drawable.shape_round_black : R.drawable.shape_round_gray);
                        name.setTextColor(position % 2 == 0?getResources().getColor(R.color.black):getResources().getColor(R.color.gray));
                        holder.setText(R.id.time_text, (String) bean);
                    }
                });
                adapter.setOnItemClickListner(new FyxRecyclerAdapter.OnItemClickListner() {
                    @Override
                    public void onItemClickListner(View v, int position) {
                        detailstime.setText(moringtime[position]);
                    }
                });
            }
        });

        afternoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                afternoon.setBackgroundResource(R.drawable.gray_drawable);
                moring.setBackgroundResource(0);
                afternoon.setTextColor(getResources().getColor(R.color.white));
                moring.setTextColor(getResources().getColor(R.color.blue));
                FyxRecyclerAdapter adapter = new FyxRecyclerAdapter(CalendarActivity.this, R.layout.recy_time_item, Arrays.asList(afternoontime));
                recyclerView.setAdapter(adapter);
                adapter.setCallBack(new FyxRecyclerAdapter.CallBack() {
                    @Override
                    public <T> void convert(WViewHolder holder, T bean, int position) {
                        holder.setText(R.id.time_text, (String) bean);
                    }
                });
                adapter.setOnItemClickListner(new FyxRecyclerAdapter.OnItemClickListner() {
                    @Override
                    public void onItemClickListner(View v, int position) {
                        detailstime.setText(afternoontime[position]);
                    }
                });
            }
        });
        mTextYear.setText(mCalendarView.getCurYear() + "年");
        mTextMouth.setText(mCalendarView.getCurMonth() + "月");
    }

    private void initData() {


    }

    @Override
    public void onYearChange(int year) {

    }

    @Override
    public void onMonthChange(int year, int month) {
//        mTextYear.setText(year+ "年");
//        mTextMouth.setText(month -1+ "月");
    }

    @Override
    public void onDateSelected(Calendar calendar, boolean isClick) {
        mTextYear.setText(calendar.getYear() + "年");
        mTextMouth.setText(calendar.getMonth() + "月");
        if (isClick) {
            Toast.makeText(this, getCalendarText(calendar), Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onDateLongClick(Calendar calendar) {
    }

    private static String getCalendarText(Calendar calendar) {
        return String.format(calendar.getMonth() + "月" + calendar.getDay() + "日");
    }

}
