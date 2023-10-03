package com.example.it_demo_recyclerview_slide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    List<StudentData> studentDataList = new ArrayList<>();
    Context context;

    public RecyclerViewAdapter(Context context){
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView_number,textView_name,textView_phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_name = itemView.findViewById(R.id.textView_name);
            textView_number = itemView.findViewById(R.id.textView_number);
            textView_phone = itemView.findViewById(R.id.textView_phone);
        }

        void setShowValue(int position){
            textView_number.setText(String.format("%02d",studentDataList.get(position).getNumber()));
            textView_name.setText(studentDataList.get(position).getName());
            textView_phone.setText(studentDataList.get(position).getPhone());
        }

        void setItemViewOnclick(int position){
            //itemView點擊事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"您選擇的是第 " + ( position + 1 ) + " 項", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加載Item布局
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //設定顯示資料
        holder.setShowValue(position);
        //設定ItemView的點擊事件
        holder.setItemViewOnclick(position);
    }

    @Override
    public int getItemCount() {
        //設定顯示數量
        return studentDataList.size();
    }

    //傳入MainActivity中的studentDataList
    public void setStudentData(List<StudentData> studentDataList){
        this.studentDataList = studentDataList;
        notifyDataSetChanged();
    }

    public void recyclerViewItemTouchHelper(RecyclerView recyclerView,List<StudentData> studentDataList) {
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

                Collections.swap(studentDataList, position_dragged, position_target); //將 索引position_dragged 與 索引position_target 的值交換位置
                //只管RecyclerView的交換 不管原始陣列的交換
                notifyItemMoved(position_dragged, position_target);
//            Log.e("position_c",studentDataList.get(0));

                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                //管理RecyclerView滑動操作
                int position = viewHolder.getAdapterPosition();
                switch (direction) {
                    case ItemTouchHelper.LEFT:
                    case ItemTouchHelper.RIGHT:
                        studentDataList.remove(position);
                        notifyItemRemoved(position);
                        break;
                }
            }
            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                new RecyclerViewSwipeDecorator.Builder(c,recyclerView,viewHolder,dX,dY,actionState,isCurrentlyActive)
                        .addBackgroundColor(Color.parseColor("#CB1B45"))
                        .addActionIcon(R.drawable.ic_baseline_delete_forever_24)
                        .create()
                        .decorate();
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        });
        helper.attachToRecyclerView(recyclerView);
    }
}
