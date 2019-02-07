package com.kcar.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import io.realm.Realm;
import io.realm.RealmResults;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);

        Realm.init(this);
        Realm mRealm = Realm.getDefaultInstance();

        // mRealm.where(MemoVO.class)에 의해 RealmQuery 객체가 반환되고, 이 객체에서 데이터를 확득하기 위한 함수들을 제공함
        // 데이터 획득 메소드 : findAll(), findAllStorted(String fieldName), findAllSorted(String fieldName, Sort[] sortOrders), findFirst()...
        //
        // 조건명시 메소드 : equalTo(), between(), beginsWith(), endsWith(), inNotNull(), in(), isNull(), lessThan(), lessThanOrEqualTo(), contains(), like() 등
        //
        // 데이터가 여러건이면 RealmResults 타입으로 획득
        // RealmResult<MemoVO> results = mRealm.where(MemoVO.class).equalTo("title","Tiger").findAll();
        //
        // 획득한 객체를 삭제하려면 deleteFromRealm()함수를 이용. vo.deleteFromRealm();
        // 특정한 타입(MemoVO)의 모든 데이터를 삭제하려면 delete()함수를 이용 mRealm.delete(MemoVO.class);
        //
        // title 값이 hello인 데이터 중 첫 번째 데이터를 가져옴
//        MemoVO vo = mRealm.where(MemoVO.class).equalTo("title", "hello").findFirst();
        RealmResults<MemoVO> realmResults = mRealm.where(MemoVO.class).equalTo("title", "hello").findAll();

        String st = null;
        if(realmResults != null){
            for(MemoVO vo : realmResults){
//                textView.setText(vo.title.toString());
                  st += vo.title+" ";
            }

            textView2.setText(st);

        }else{
            Toast.makeText(this, "널이닷닷", Toast.LENGTH_SHORT);
        }




    }
}
