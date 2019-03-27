package com.yanfu.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yanfu on 2019/3/27.
 */

public class CommAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<BaseInfo> mData;
    private OnItemClickListenter onItemClickListenter;

    public CommAdapter() {
    }

    public CommAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<BaseInfo> data) {
        this.mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("RecyclerView.ViewHolder", "===");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Log.i("onBindViewHolder", "===");
        BaseInfo baseInfo = mData.get(position);

        ((ItemViewHolder) holder).name.setText(baseInfo.getName());
        ((ItemViewHolder) holder).age.setText(baseInfo.getAge());
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public BaseInfo getItem(int position) {
        if (mData == null) {
            return null;
        }
        return mData.get(position);
    }

    public void setOnItemClickListenter(OnItemClickListenter onItemClickListenter) {
        this.onItemClickListenter = onItemClickListenter;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView age;


        public ItemViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.buttonFirst);
            age = (TextView) itemView.findViewById(R.id.buttonSecond);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Log.i("=onClick=entry=",this.getPosition()+"");
            if (onItemClickListenter != null) {
                Log.i("=onClick=",this.getPosition()+"");
                onItemClickListenter.onItemClick(view, this.getPosition());
            }
        }
    }


    public interface OnItemClickListenter {
        void onItemClick(View view, int position);
    }
}