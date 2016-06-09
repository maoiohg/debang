package com.example.amoxicilin.myapplication.data;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.amoxicilin.myapplication.main.Fetch_List_Fragment;
import com.example.amoxicilin.myapplication.R;
import com.example.amoxicilin.myapplication.dummy.DummyContent.DummyItem;

import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> implements Fetch_List_Fragment.OnListFragmentInteractionListener {

    private final List<DummyItem> mValues;
    private final Fetch_List_Fragment.OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<DummyItem> items, Fetch_List_Fragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTitleTestView.setText(mValues.get(position).id);
        holder.mInfoTestView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public void onListFragmentInteraction(DummyItem item) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mImgTestView;
        public final TextView mTitleTestView;
        public final TextView mInfoTestView;
        public final Button mButtonLeft;
        public final Button mButtonRight;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImgTestView= (ImageView) view.findViewById(R.id.ImgTest);
            mTitleTestView = (TextView) view.findViewById(R.id.TitleTest);
            mInfoTestView = (TextView) view.findViewById(R.id.InfoTest);
            mButtonLeft=(Button)view.findViewById(R.id.list_item_button_left);
            mButtonRight=(Button)view.findViewById(R.id.list_item_button_right);


        }

        @Override
        public String toString() {
            return super.toString() + " '" + mInfoTestView.getText() + "'";
        }
    }
}
