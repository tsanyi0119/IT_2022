package com.example.it_demo_recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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
}
