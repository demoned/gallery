package com.demons.gallery.utils;

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.demons.gallery.R;

/**
 * 吐司工具类
 *
 * @author demons
 */
public class ToastUtil {

    private static Toast toast;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() {
        @Override
        public void run() {
            toast.cancel();
        }
    };

    public static void show(Context context, String message) {
        showCustomToast(context, message);
    }

    public static void show(Context context, int resId) {
        showCustomToast(context, resId);
    }

    private static void showCustomToast(Context context, String massage) {
        mHandler.removeCallbacks(r);
        //使用布局加载器，将编写的toast_layout布局加载进来
        View view = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);
        //获取TextView
        TextView title = (TextView) view.findViewById(R.id.toast_tv);
        //设置显示的内容
        title.setText(massage);
        toast = new Toast(context);
        //设置Toast要显示的位置，水平居中并在底部，X轴偏移0个单位，Y轴偏移70个单位，
        toast.setGravity(Gravity.TOP, 0, 200);
        //设置显示时间
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        mHandler.postDelayed(r, 800);
        toast.show();
    }

    private static void showCustomToast(Context context, int massage) {
        //使用布局加载器，将编写的toast_layout布局加载进来
        View view = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);
        //获取TextView
        TextView title = (TextView) view.findViewById(R.id.toast_tv);
        title.setText(massage);
        toast = new Toast(context);
        //设置Toast要显示的位置，水平居中并在底部，X轴偏移0个单位，Y轴偏移70个单位，
        toast.setGravity(Gravity.TOP, 0, 200);
        //设置显示时间
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        mHandler.postDelayed(r, 800);
        toast.show();
    }
}