package com.example.it_demo_recyclerview_advanced;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.graphics.Canvas;
import android.os.Bundle;
//import android.support.v7.widget.DividerItemDecoration;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class MainActivity extends AppCompatActivity {
    String[] A2J = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
    ArrayList<String> arrayList = new ArrayList<>();
    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //生成資料
        for (int i = 0; i < A2J.length; i++) {
            arrayList.add(A2J[i]);
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);

        recyclerViewAction(recyclerView, arrayList, myAdapter);

    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.textView);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.textView.setText(arrayList.get(position));
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
    }

    private void recyclerViewAction(RecyclerView recyclerView, final ArrayList<String> choose, final MyAdapter myAdapter) {
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                //管理RecyclerView的操作 上下左右
                return makeMovementFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN , ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                //管理RecyclerView上下拖曳操作 01 12 23 34
                int position_dragged = viewHolder.getAdapterPosition(); //初始位置
                int position_target = target.getAdapterPosition(); //結束位置

                Log.e("position_f", String.valueOf(viewHolder.getAdapterPosition()));
                Log.e("position_b", String.valueOf(target.getAdapterPosition()));

                Collections.swap(choose, position_dragged, position_target); //將 索引position_dragged 與 索引position_target 的值交換位置
                myAdapter.notifyItemMoved(position_dragged, position_target); //只管RecyclerView的交換 不管原始陣列的交換

                Log.e("position_c",choose.get(0));

                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                //管理RecyclerView滑動操作
                int position = viewHolder.getAdapterPosition();
                switch (direction) {
                    case ItemTouchHelper.LEFT:
                    case ItemTouchHelper.RIGHT:
                        choose.remove(position);
                        myAdapter.notifyItemRemoved(position);
                        break;
                }
            }
            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                new RecyclerViewSwipeDecorator.Builder(c,recyclerView,viewHolder,dX,dY,actionState,isCurrentlyActive)
                        .addBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.holo_red_dark))
                        .addActionIcon(R.drawable.ic_baseline_delete_forever_24)
                        .create()
                        .decorate();
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }

        });
        helper.attachToRecyclerView(recyclerView);
    }
}