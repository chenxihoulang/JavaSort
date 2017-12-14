package com.example.chaihongwei.javasort;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public abstract class BaseSortActivity extends AppCompatActivity {
    protected TextView tvTip;

    protected int[] datas = {64, 8, 7, 89, 6, 24, 2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_sort);

        tvTip = findViewById(R.id.tvTip);

        printDatas("待排数据:");
        sort();
        printDatas("结果数据:");
    }

    protected void printDatas(String tip) {
        StringBuilder sbPartSortData = new StringBuilder(tip);
        for (int i = 0, count = datas.length; i < count; i++) {
            sbPartSortData.append(" " + datas[i] + " ,");
        }

        sbPartSortData.deleteCharAt(sbPartSortData.length() - 1);
        sbPartSortData.append("\n");

        tvTip.append(sbPartSortData);
    }

    protected void printTempData(String tip) {
        tvTip.append("临时数据:" + tip + "\n");
    }

    protected abstract void sort();
}
