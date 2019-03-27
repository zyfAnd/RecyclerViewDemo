package com.yanfu.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yanfu.demo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CommAdapter commAdapter;
    private LinearLayoutManager linearLayoutManager;
    TextView tvName;
    TextView tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initViews();

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        commAdapter.setOnItemClickListenter(onItemClickListenter);
    }

    private void initData() {
        BaseInfo baseInfo1 = new BaseInfo("Yanfu1", "18");
        BaseInfo baseInfo2 = new BaseInfo("Yanfu2", "19");
        BaseInfo baseInfo3 = new BaseInfo("Yanfu3", "20");
        List data = new ArrayList();
        data.add(baseInfo1);
        data.add(baseInfo2);
        data.add(baseInfo3);

        commAdapter = new CommAdapter();
        commAdapter.setData(data);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setAdapter(commAdapter);
    }

    private CommAdapter.OnItemClickListenter onItemClickListenter = new CommAdapter.OnItemClickListenter() {
        @Override
        public void onItemClick(View view, int position) {
            BaseInfo baseInfo = commAdapter.getItem(position);
            Log.i("=baseInfo=", baseInfo.toString());
            tvName = (TextView) view.findViewById(R.id.buttonFirst);
            tvAge = (TextView) view.findViewById(R.id.buttonSecond);
            switch (position) {
                case 0:
                    tvName.setText("ZhangYanfu1");
                    tvAge.setText("24");
                    break;
                case 1:
                    tvName.setText("ZhangYanfu2");
                    tvAge.setText("25");
                    break;
                case 2:
                    tvName.setText("ZhangYanfu3");
                    tvAge.setText("26");
                    break;
            }


        }
    };


}
