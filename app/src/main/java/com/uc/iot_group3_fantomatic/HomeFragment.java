package com.uc.iot_group3_fantomatic;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uc.iot_group3_fantomatic.helper.FanSetting;
import com.uc.iot_group3_fantomatic.helper.Gate;

import java.util.Random;

public class HomeFragment extends Fragment {

    private int fspeed, temp = 0;
    private Handler handler = new Handler();
    private Random random = new Random();
    private View view;
    private FanSetting fs = Gate.fs;
    private TextView text_indicate_power, text_indicate_temp, text_indicate_speed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        init();
        return view;
    }

    private void initView(){
        text_indicate_power = view.findViewById(R.id.text_indicate_power);
        text_indicate_speed = view.findViewById(R.id.text_indicate_speed);
        text_indicate_temp = view.findViewById(R.id.text_indicate_temp);
    }

    private void init(){
        String power = fs.getIsPower();
        String auto = fs.getIsAuto();
        fspeed = fs.getCurrentSpeed();
        handler.removeCallbacks(temprun);
        handler.removeCallbacks(fanrun);
        handler.removeCallbacks(temprun2);

        if (power == "true"){
            if(auto == "true"){
                handler.post(temprun);
                handler.post(fanrun);
            }else{
                text_indicate_speed.setText(fspeed+"%");
                handler.post(temprun2);
            }
        } else {
            text_indicate_temp.setText("0");
            text_indicate_speed.setText("0%");
            text_indicate_power.setText("OFF");
        }
    }

    private Runnable temprun = new Runnable() {
        @Override
        public void run() {
            temp = temp + random.nextInt(20) + 1;

            if (temp >= 40) {
                temp = 40;
            }

            text_indicate_temp.setText(""+temp);

            handler.postDelayed(temprun, 5000);
        }
    };

    private Runnable temprun2 = new Runnable() {
        @Override
        public void run() {
            temp = temp + random.nextInt(10) + 1;

            if (temp >= 40) {
                temp = 40;
            }

            if (fspeed == 25){
                temp = temp - random.nextInt(6) + 1;
            }
            if (fspeed == 50) {
                temp = temp - random.nextInt(7) + 1;
            }
            if (fspeed == 75) {
                temp = temp - random.nextInt(8) + 1;
            }
            if (fspeed == 100) {
                temp = temp - random.nextInt(9) + 1;
            }

            text_indicate_temp.setText(""+temp);

            handler.postDelayed(temprun2, 1000);
        }
    };

    private Runnable fanrun2 = new Runnable() {
        @Override
        public void run() {

            if (fspeed == 25){
                temp = temp - random.nextInt(5) + 1;
            } else if (fspeed == 50) {
                temp = temp - random.nextInt(6) + 1;
            } else if (fspeed == 75) {
                temp = temp - random.nextInt(7) + 1;
            } else if (fspeed == 100) {
                temp = temp - random.nextInt(8) + 1;
            }

            handler.postDelayed(fanrun2, 2500);
        }
    };

    private Runnable fanrun = new Runnable() {
        @Override
        public void run() {
            if (temp < 25){
                fspeed = fspeed + random.nextInt(10) + 1;
                if (fspeed >= 25){
                    fspeed = 25;
                }
                text_indicate_speed.setText(fspeed + "%");
                temp = temp - random.nextInt(5) + 1;
                fspeed = fspeed - random.nextInt(5) + 1;
                text_indicate_speed.setText(fspeed + "%");
                text_indicate_temp.setText(""+temp);
            } else if (temp >= 25 && temp < 32) {
                fspeed = fspeed + random.nextInt(20) + 1;
                if (fspeed >= 50){
                    fspeed = 50;
                }
                text_indicate_speed.setText(fspeed + "%");
                temp = temp - random.nextInt(7) + 1;
                fspeed = fspeed - random.nextInt(10) + 1;
                text_indicate_speed.setText(fspeed + "%");
                text_indicate_temp.setText(""+temp);
            } else if (temp >= 32) {
                fspeed = fspeed + random.nextInt(25) + 1;
                if (fspeed >= 100){
                    fspeed = 100;
                }
                text_indicate_speed.setText(fspeed + "%");
                temp = temp - random.nextInt(10) + 1;
                fspeed = fspeed - random.nextInt(15) + 1;
                text_indicate_speed.setText(fspeed + "%");
                text_indicate_temp.setText(""+temp);
            }

            handler.postDelayed(fanrun, 1500);
        }
    };
}