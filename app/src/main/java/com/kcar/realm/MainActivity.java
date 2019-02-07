package com.kcar.realm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private Realm mRealm;
    private EditText editText;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Realm 객체 획득
        Realm.init(this);
        mRealm = Realm.getDefaultInstance();

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

    }

    public void click(View view) {
        //저장
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //add a persion
                MemoVO vo = realm.createObject(MemoVO.class);
                vo.title= editText.getText().toString();
                vo.content = editText2.getText().toString();

                Log.d("dongy", editText.getText().toString() + ", " + editText2.getText().toString());
            }
        });

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        startActivity(intent);
    }
}
