package kr.co.munjanara.exammultiactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static int REQUEST_CODE = 1000;
    public final static String MESSAGE_NAME = "kr.co.munjanara.exammultiactivity.MESSAGE_NAME";
    public final static String MESSAGE_AGE = "kr.co.munjanara.exammultiactivity.MESSAGE_AGE";

    private EditText mName;
    private EditText mAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.et_name);
        mAge = findViewById(R.id.et_age);
    }

    public void mOnClick(View view) {

        Intent intent = new Intent(this, ActivitySecond.class);

        intent.putExtra(MESSAGE_NAME, mName.getText().toString() );
        intent.putExtra(MESSAGE_AGE, mAge.getText().toString());
        startActivityForResult(intent, REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null ) {
            String result = data.getStringExtra("result");
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        }
    }
}