package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "MainActivity.class";
    private Button mBtn;
    private Button mBtnJia;
    private Button mBtnJie;
    private EditText editText;
    private Button btn;
    private EditText etShow;
    private Button btnJia;
    private Button btnJie;
    private TextView tvBefore;
    private TextView tvResult;
    /**
     * 加密使用key
     */
    private String key ="222222222";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);

        mBtn.setOnClickListener(this);
        mBtnJia = (Button) findViewById(R.id.btn_jia);
        mBtnJia.setOnClickListener(this);
        mBtnJie = (Button) findViewById(R.id.btn_jie);
        mBtnJie.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.et_show);
        editText.setOnClickListener(this);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        etShow = (EditText) findViewById(R.id.et_show);
        etShow.setOnClickListener(this);
        btnJia = (Button) findViewById(R.id.btn_jia);
        btnJia.setOnClickListener(this);
        btnJie = (Button) findViewById(R.id.btn_jie);
        btnJie.setOnClickListener(this);
        tvBefore = (TextView) findViewById(R.id.tv_before);
        tvBefore.setOnClickListener(this);
        tvResult = (TextView) findViewById(R.id.tv_result);
        tvResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                break;
            case R.id.btn_jia:
                try {

                    String inputString = editText.getText().toString();

                    Log.i(TAG, "输入的内容=" + inputString);

                    String filecontent = CXAESUtil.encrypt(key, inputString);//加密后的

                    tvBefore.setText("加密后的内容:" + filecontent);

                    Log.i(TAG, "加密后的内容=" + filecontent);

                    String decryptString = CXAESUtil.decrypt(key, filecontent);//加密后的

                    Log.i(TAG, "解密后的内容=" + decryptString);

                    tvResult.setText("解密后的内容:" + decryptString);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_jie:
                break;

        }

    }

}
