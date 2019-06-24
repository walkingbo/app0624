package com.ssb.app0624;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //출력할 데이터 만들기
        ArrayList<String> list = new ArrayList<>();
        list.add("리오넬 메시");
        list.add("크리스티안 호날두");
        list.add("모하메드 살라");
        list.add("폴 포그바");
        list.add("헤리 케인");

        //리스트 뷰 찾아오기
        ListView listView = (ListView)findViewById(R.id.listView);

        //리스트 뷰에 데이터를 출력하기 위한 Adapter 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,list);
        //Adapter를 listView에 주입
        listView.setAdapter(adapter);

        //선택 모드 설정
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //선 관련 옵션 수정
        listView.setDivider(new ColorDrawable(Color.RED));
        listView.setDividerHeight(3);


    }
}
