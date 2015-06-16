package com.himotech.adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.himotech.recycleviewdemo.R;

import java.util.ArrayList;

/**
 * Created by ubbvand2 on 16/6/15.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {



    private LayoutInflater mLayoutInflater;

    private Context _Context;

    private ArrayList<ListData> mArrayData;

    public ListAdapter(Context mContext,ArrayList<ListData> mArrayData){

        this._Context=mContext;

        this.mArrayData=mArrayData;

        mLayoutInflater=(LayoutInflater)_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mView=mLayoutInflater.inflate(R.layout.custom_list_row,parent,false);


        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        holder.setData(mArrayData.get(position));

        holder.mTxtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(_Context,mArrayData.get(position).getTxtDesc(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArrayData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public AppCompatTextView mTxtTitle;

        public AppCompatTextView mTxtDesc;

        public ImageView mImgView;

        public ViewHolder(View itemView) {
            super(itemView);

            mTxtTitle=(AppCompatTextView)itemView.findViewById(R.id.txt_name);
            mTxtDesc=(AppCompatTextView)itemView.findViewById(R.id.txt_description);
        }


        public void setData(ListData mListData){

            mTxtTitle.setText(mListData.getTxtName());

            mTxtDesc.setText(mListData.getTxtDesc());

        }


    }
}
