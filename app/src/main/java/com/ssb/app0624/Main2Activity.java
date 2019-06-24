package com.ssb.app0624;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    //리스트 뷰에 출력할 데이터 모임
    ArrayList<String> list;
    //Adapter
    ArrayAdapter<String> adapter;
    //ListView
    ListView listView;


    private Button insertbtn, deletebtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //출력할 데이터를 생성
        list = new ArrayList<>();
        list.add("김영철");
        list.add("버거킹");
        list.add("4딸라!");
        list.add("오케이");
        list.add("땡큐");
        list.add("올데이킹");

        //Adapter 생성
        //adapter = new ArrayAdapter<>(Main2Activity.this, android.R.layout.simple_list_item_single_choice, list);

        adapter = new ArrayAdapter<>(Main2Activity.this, android.R.layout.simple_list_item_multiple_choice, list);


        //리스트 뷰에 적용
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        //Andoroid의 ListView는 adapter에 설정한 모양과
        //Choice 모드가 일치해야만 출력
        //listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        insertbtn = (Button) findViewById(R.id.insertbtn);
        insertbtn.setOnClickListener((view) -> {
            //입력한 내용 가져오기
            EditText edit = (EditText) findViewById(R.id.name);
            String content = edit.getText().toString();
            if (content.trim().length() == 0) {
                Toast.makeText(Main2Activity.this, "입력할 내용을 작성하세요", Toast.LENGTH_LONG).show();
                return;
            }
            list.add(content);
            //데이터가 변경되었다는 것을 ListView에게 전달
            adapter.notifyDataSetChanged();
            edit.setText("");
        });

        deletebtn = (Button) findViewById(R.id.deletebtn);
        deletebtn.setOnClickListener((view) -> {
            /*
            //선택한 행 번호 가져오기
            int pos = listView.getCheckedItemCount();
            //선택이 안된 경우는 메시지를 출력하고 리턴
            if (pos < 0 || pos >= list.size()) {
                Toast.makeText(Main2Activity.this, "선택하고 삭제를 누르세요", Toast.LENGTH_LONG).show();
                return;
            }
            //리스트에서 데이터를 삭제하고 리스트 뷰를 다시 출력
            //list.remove(pos);
            //adapter.notifyDataSetChanged();
            */

            //선택된 항목들의 인덱스를 가져오기
            //ListView의 모든 인덱스들의 배열
            //선택이 된 것은 true 선택이 안된것은 false를 저장
            SparseBooleanArray sba = listView.getCheckedItemPositions();
            //선택인 된 경우에만 동작
            if(sba.size()>=0){
                for (int i =0;i<sba.size();i=i+1){
                    if(sba.get(sba.size()-i-1)==true){
                        list.remove(sba.size()-i-1);
                    }
                }
            }
            listView.clearChoices();
            adapter.notifyDataSetChanged();
        });

        //ListView의 아이템을 클릭했으 ㄹ때 처리
        //첫번째 매개변수는 이벤트가 발생한 AdapterView
        //두번째 매개변수는 이벤트가 발생한 항목 뷰
        //세번째 매개변수는 선택한 항목의 인덱스
        //네번째 매개변수는 선택한 항목의 id
        listView.setOnItemClickListener((parent, view, pos, id) -> {
            String data = list.get(pos);
            Toast.makeText(Main2Activity.this, data, Toast.LENGTH_LONG).show();
        });
    }
}