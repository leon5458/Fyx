package leon.com.fyx;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import leon.com.fyx.utils.ToastUtils;
import leon.com.fyx.view.clipPage.ClipViewPager;
import leon.com.fyx.view.clipPage.GaPageTransformer;
import leon.com.fyx.view.clipPage.RecyclingPagerAdapter;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/3/23<p>
 * <p>更改时间：2018/3/23<p>
 * <p>版本号：1<p>
 */
public class GalleryActivity extends AppCompatActivity {
    private ClipViewPager mViewPager;
    private RelativeLayout container;
    private LinearLayout indicatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galleryactivity_layout);
        mViewPager = (ClipViewPager) findViewById(R.id.ga_viewpager);
        container = (RelativeLayout) findViewById(R.id.ga_container);
        indicatorLayout = (LinearLayout) findViewById(R.id.ga_indicator);

        updateIndicator(0);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setPageTransformer(true, new GaPageTransformer());
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                updateIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mViewPager.setAdapter(new GaAdapter(GalleryActivity.this));
    }

    List<ImageView> imgs = new ArrayList<>();

    private void updateIndicator(int position) {
        indicatorLayout.removeAllViews();
        imgs.clear();
        for (int i = 0; i < 3; i++) {
            ImageView img = new ImageView(GalleryActivity.this);
            if (i == position) img.setImageResource(R.mipmap.select);
            else img.setImageResource(R.mipmap.unselect);
            img.setPadding(10, 0, 10, 0);
            imgs.add(img);
            indicatorLayout.addView(img);
        }
    }

    class GaAdapter extends RecyclingPagerAdapter {
        private final Context mContext;

        public GaAdapter(Context context) {
            mContext = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            View view;
            if (convertView == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.viewpager_ga_item, null);
            } else {
                view = convertView;
            }

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showToast("点击事件");
                }
            });

            return view;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }
    }

}

