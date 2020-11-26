package kr.co.munjanara.exammultiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivitySecond extends AppCompatActivity implements View.OnClickListener {
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.MESSAGE_NAME);
        String age = intent.getStringExtra(MainActivity.MESSAGE_AGE);

        mResult = findViewById(R.id.tv_message_edit);
        if( !name.isEmpty() || !age.isEmpty() )
            mResult.setText(name + "님의 나이는 " + age + "살 입니다.");


        findViewById(R.id.btn_send_result).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("result", mResult.getText().toString());

        setResult(RESULT_OK, intent);

        finish();
    }
}