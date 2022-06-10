package com.uc.iot_group3_fantomatic;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.slider.Slider;
import com.google.android.material.snackbar.Snackbar;
import com.uc.iot_group3_fantomatic.helper.FanSetting;
import com.uc.iot_group3_fantomatic.helper.Gate;

public class FanSettingsFragment extends Fragment {

    private Switch switch_power;
    private RadioButton rb_auto, rb_manu;
    private RadioGroup rb_pref;
    private TextView text_temp;
    private ImageView image_fan;
    private Slider slider_fan_speed;
    private View view;
    private FanSetting fs = Gate.fs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fan_settings, container, false);
        initView();
        init();
        return view;
    }

    private void initView(){
        switch_power = view.findViewById(R.id.switch_power);
        rb_auto = view.findViewById(R.id.rb_auto);
        rb_manu = view.findViewById(R.id.rb_manu);
        text_temp = view.findViewById(R.id.text_temp);
        rb_pref = view.findViewById(R.id.rb_pref);
        image_fan = view.findViewById(R.id.image_fan);
        slider_fan_speed = view.findViewById(R.id.slider_fan_speed);
    }

    private void init(){
        switch_power.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (switch_power.isChecked()){
                    fs.setIsPower("true");
                } else if (!switch_power.isChecked()){
                    fs.setIsPower("false");
                }
            }
        });

        rb_pref.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_auto:
                        fs.setIsAuto("true");
                        switch_power.setVisibility(View.INVISIBLE);
                        image_fan.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.rb_manu:
                        fs.setIsAuto("false");
                        switch_power.setVisibility(View.VISIBLE);
                        image_fan.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        slider_fan_speed.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                fs.setCurrentSpeed((int)slider_fan_speed.getValue());
            }
        });
    }
}