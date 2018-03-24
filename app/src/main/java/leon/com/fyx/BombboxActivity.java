package leon.com.fyx;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.othershe.nicedialog.BaseNiceDialog;
import com.othershe.nicedialog.NiceDialog;
import com.othershe.nicedialog.ViewConvertListener;
import com.othershe.nicedialog.ViewHolder;

import java.util.Arrays;

import leon.com.fyx.utils.ToastUtils;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/7<p>
 * <p>更改时间：2018/2/7<p>
 * <p>版本号：1<p>
 */
public class BombboxActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView car_agreement;
    private TextView car_bind;
    private TextView regist;
    private TextView appoint_cancel;
    private TextView change_shop;
    private TextView cancel_car_server;
    private TextView share;
    private TextView bottom_pick;
    private TextView light;
    private TextView bottom_cancel_carserver;
    private TextView quan;
    private TextView toast1;
    private TextView toast2;
    private TextView toast3;
    private TextView order;
    private TextView pop;

    private PopupWindow mPopWindow;
    private OptionsPickerView skidding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bombactivity_layout);
        car_agreement = (TextView) findViewById(R.id.car_agreement);
        car_bind = (TextView) findViewById(R.id.car_bind);
        regist = (TextView) findViewById(R.id.regist);
        appoint_cancel = (TextView) findViewById(R.id.appoint_cancel);
        change_shop = (TextView) findViewById(R.id.change_shop);
        cancel_car_server = (TextView) findViewById(R.id.cancel_car_server);
        bottom_pick = (TextView) findViewById(R.id.bottom_pick);
        share = (TextView) findViewById(R.id.share);
        light = (TextView) findViewById(R.id.light);
        order = (TextView) findViewById(R.id.order);
        bottom_cancel_carserver = (TextView) findViewById(R.id.bottom_cancel_carserver);
        quan = (TextView) findViewById(R.id.quan);
        toast1 = (TextView) findViewById(R.id.bomb_ten);
        toast2 = (TextView) findViewById(R.id.bomb11);
        toast3 = (TextView) findViewById(R.id.bomb12);
        pop = (TextView) findViewById(R.id.pop);
        car_agreement.setOnClickListener(this);
        car_bind.setOnClickListener(this);
        regist.setOnClickListener(this);
        appoint_cancel.setOnClickListener(this);
        change_shop.setOnClickListener(this);
        cancel_car_server.setOnClickListener(this);
        share.setOnClickListener(this);
        bottom_pick.setOnClickListener(this);
        light.setOnClickListener(this);
        bottom_cancel_carserver.setOnClickListener(this);
        quan.setOnClickListener(this);
        toast1.setOnClickListener(this);
        toast2.setOnClickListener(this);
        toast3.setOnClickListener(this);
        order.setOnClickListener(this);
        pop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pop:
                startActivity(new Intent(BombboxActivity.this,PopActivity.class));
                break;
            case R.id.car_agreement:
                NiceDialog.init()
                        .setLayoutId(R.layout.bombone_layout)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                                holder.setOnClickListener(R.id.close, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });
                            }
                        })
                        .setWidth(240)
                        .setOutCancel(true)
                        .setAnimStyle(R.style.EnterExitAnimation)
                        .show(getSupportFragmentManager());
                break;
            case R.id.bomb_ten:
                View view3 = LayoutInflater.from(BombboxActivity.this).inflate(R.layout.toast_item3, null);
                new ToastUtils(this, view3, Toast.LENGTH_LONG).show();
                break;
            case R.id.bomb11:
                View view1 = LayoutInflater.from(BombboxActivity.this).inflate(R.layout.toast_item2, null);
                new ToastUtils(this, view1, Toast.LENGTH_LONG).show();
                break;
            case R.id.bomb12:
                View view2 = LayoutInflater.from(BombboxActivity.this).inflate(R.layout.toast_item1, null);
                new ToastUtils(this, view2, Toast.LENGTH_LONG).show();
                break;
            case R.id.order:
                NiceDialog.init()
                        .setLayoutId(R.layout.order_layout)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

                            }
                        })
                        .setWidth(260)
                        .setOutCancel(true)
                        .setAnimStyle(R.style.EnterExitAnimation)
                        .show(getSupportFragmentManager());
                break;
            case R.id.quan:
                NiceDialog.init()
                        .setLayoutId(R.layout.bombnine_layout)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

                            }
                        })
                        .setWidth(260)
                        .setOutCancel(true)
                        .setAnimStyle(R.style.EnterExitAnimation)
                        .show(getSupportFragmentManager());
                break;
            case R.id.car_bind:
                NiceDialog.init()
                        .setLayoutId(R.layout.bombtwo_layout)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                                holder.setOnClickListener(R.id.close, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });
                            }
                        })
                        .setWidth(210)
                        .setOutCancel(true)
                        .setAnimStyle(R.style.EnterExitAnimation)
                        .show(getSupportFragmentManager());

                break;
            case R.id.regist:
                NiceDialog.init()
                        .setLayoutId(R.layout.bombthree_layout)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                                holder.setOnClickListener(R.id.close, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });
                            }
                        })
                        .setWidth(210)
                        .setOutCancel(true)
                        .setAnimStyle(R.style.EnterExitAnimation)
                        .show(getSupportFragmentManager());

                break;
            case R.id.appoint_cancel:
                NiceDialog.init()
                        .setLayoutId(R.layout.bombfour_layout)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                                holder.setOnClickListener(R.id.close, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });
                            }
                        })
                        .setWidth(210)
                        .setOutCancel(true)
                        .setAnimStyle(R.style.EnterExitAnimation)
                        .show(getSupportFragmentManager());

                break;
            case R.id.change_shop:
                ConfirmDialog.newInstance("1")
                        .setMargin(60)
                        .setOutCancel(true)
                        .show(getSupportFragmentManager());

                break;
            case R.id.cancel_car_server:
                ConfirmDialog.newInstance("3")
                        .setMargin(60)
                        .setOutCancel(true)
                        .show(getSupportFragmentManager());

                break;
            case R.id.bottom_cancel_carserver:
                NiceDialog.init()
                        .setLayoutId(R.layout.bombseven_layout)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                                holder.setOnClickListener(R.id.close, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });
                            }
                        })

                        .setShowBottom(true)
                        .show(getSupportFragmentManager());
                break;
            case R.id.share:
                NiceDialog.init()
                        .setLayoutId(R.layout.bombeight_layout)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                                holder.setOnClickListener(R.id.wechat, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        ToastUtils.showToast("分享成功");
                                    }
                                });
                            }
                        })
                        .setDimAmount(0.3f)
                        .setShowBottom(true)
                        .show(getSupportFragmentManager());

                break;
            case R.id.bottom_pick:
                final String[] food = new String[]{"1万公里定期保养", "20K基础保养", "10K基础保养", "馒头", "包子", "年糕", "油条", "豆浆", "烧饼", "蛋炒饭"};
                skidding = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {

                    }
                })
                        .setLayoutRes(R.layout.rem_options, new CustomListener() {
                            @Override
                            public void customLayout(View v) {
                                ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);
                                TextView tvAdd = (TextView) v.findViewById(R.id.tv_ok);
                                ivCancel.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        skidding.dismiss();
                                    }
                                });
                                tvAdd.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        skidding.dismiss();
                                    }
                                });
                            }
                        })
                        .setSubmitColor(0xFF55DA99)//确定按钮文字颜色
                        .setCancelColor(0xFFa9a9a9)//取消按钮文字颜色
                        .setDividerColor(Color.BLACK)
                        .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                        .setContentTextSize(20)
                        .setCancelText("请选择保养得项目")
                        .setSubmitText("确定")
                        .setOutSideCancelable(false)// default is true
                        .build();

                skidding.setPicker(Arrays.asList(food));
                skidding.show();

                break;
            case R.id.light:
                NiceDialog.init()
                        .setLayoutId(R.layout.light_layout)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

                            }
                        })
                        .setWidth(260)
                        .setOutCancel(true)
                        .setAnimStyle(R.style.EnterExitAnimation)
                        .show(getSupportFragmentManager());
                break;
        }
    }

    public static class ConfirmDialog extends BaseNiceDialog {
        private String type;

        public static ConfirmDialog newInstance(String type) {
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            ConfirmDialog dialog = new ConfirmDialog();
            dialog.setArguments(bundle);
            return dialog;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle bundle = getArguments();
            if (bundle == null) {
                return;
            }
            type = bundle.getString("type");
        }


        @Override
        public int intLayoutId() {
            return R.layout.confirm_layout;
        }


        @Override
        public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
            if ("1".equals(type)) {
                holder.setText(R.id.message, "确认更换专属销售店?");
                holder.setText(R.id.cancel, "再想想");
                holder.setText(R.id.ok, "确认更换");
                holder.setTextColor(R.id.ok, (Color.parseColor("#0babfe")));
            } else if ("2".equals(type)) {
                holder.setText(R.id.message, "(021) -6555 5570");
                holder.setText(R.id.cancel, "取消");
                holder.setText(R.id.ok, "呼叫");
                holder.setTextColor(R.id.ok, (Color.parseColor("#0babfe")));
            } else if ("3".equals(type)) {
                holder.setText(R.id.message, "取消取车服务,您需要先选择保养预约时间");
                holder.setText(R.id.cancel, "再想想");
                holder.setText(R.id.ok, "确认更换");
                holder.setTextColor(R.id.ok, (Color.parseColor("#0babfe")));

            } else if ("4".equals(type)) {
                holder.setText(R.id.message, "生日保存以后不能修改,是否确定保存?");
                holder.setText(R.id.cancel, "再想想");
                holder.setText(R.id.ok, "确认保存");
                holder.setTextColor(R.id.ok, (Color.parseColor("#0babfe")));

                holder.setOnClickListener(R.id.cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                holder.setOnClickListener(R.id.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        }
    }
}
