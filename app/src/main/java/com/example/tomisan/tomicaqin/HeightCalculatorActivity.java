package com.example.tomisan.tomicaqin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.tomisan.tomicaqin.R;

public class HeightCalculatorActivity extends Activity {

    private Button calculatorButton;
    private EditText weightEditTxt;
    private RadioButton manCheckBox;
    private RadioButton womanCheckBox;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatorButton = (Button) findViewById(R.id.calculator);
        weightEditTxt = (EditText) findViewById(R.id.weight);
        manCheckBox = (RadioButton) findViewById(R.id.man);
        womanCheckBox = (RadioButton) findViewById(R.id.woman);
        resultTextView = (TextView) findViewById(R.id.result);
        registerEvent();
    }

    public void registerEvent() {
        calculatorButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (!weightEditTxt.getText().toString().trim().equals("")){
                    if (manCheckBox.isChecked() || womanCheckBox.isChecked()){
                        Double weight = Double.parseDouble(weightEditTxt.getText().toString());
                        StringBuffer sb = new StringBuffer();
                        sb.append("------评估结果----- \n");
                        if (manCheckBox.isChecked()){
                            sb.append("男性标准身高：");
                            double result = evaluateHeight(weight,"男");
                            sb.append((int)result + "(厘米)");
                        }
                        if (womanCheckBox.isChecked()){
                            sb.append("女性标准身高：");
                            double result = evaluateHeight(weight,"女");
                            sb.append((int)result + "(厘米)");
                        }
                        resultTextView.setText(sb.toString());
                    }else {
                        showMessage("请选择性别！");
                    }
                }else {
                    showMessage("请输入体重！");
                }

            }
        });
    }

    private double evaluateHeight(double weight, String sex) {
        double height;
        if(sex=="男"){
            height = 170 - (62 - weight) / 0.6;
        }else {
            height = 158 - (52 - weight) / 0.5;
        }
        return height;
    }

    private void showMessage(String message) {
        AlertDialog alert = new AlertDialog.Builder(this).create();
        alert.setTitle("系统信息");
        alert.setMessage(message);
        alert.setButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(Menu.NONE,1,menu.NONE,"退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
