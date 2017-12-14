package com.example.chaihongwei.javasort;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInsertSort:
                startActivity(new Intent(this, InsertSortActivity.class));
                break;
            case R.id.btnBinaryInsertSort:
                startActivity(new Intent(this, BinaryInsertionSortActivity.class));
                break;
            case R.id.btnShellSort:
                startActivity(new Intent(this, ShellSortActivity.class));
                break;
            case R.id.btnBubbleSort:
                startActivity(new Intent(this, BubbleSortActivity.class));
                break;
            case R.id.btnSelectSort:
                startActivity(new Intent(this, SelectSortActivity.class));
                break;
            case R.id.btnQuickSort:
                startActivity(new Intent(this, QuickSortActivity.class));
                break;
            case R.id.btnMergeSort:
                startActivity(new Intent(this, MergeSortActivity.class));
                break;
            case R.id.btnHeapSort:
                startActivity(new Intent(this, HeapSortActivity.class));
                break;
            case R.id.btnRadixSort:
                startActivity(new Intent(this, RadixSortActivity.class));
                break;
            default:
                //无需处理
                break;
        }
    }
}
