package com.example.branislavnovak.chatapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Branislav Novak on 01-Apr-18.
 */

public class MessageAdapter extends BaseAdapter{
    private Context mContext;
    private ArrayList<ModelMessage> mMessages;

    public MessageAdapter(Context context) {
        mContext = context;
        mMessages = new ArrayList<ModelMessage>();
    }

    public void AddMessage(ModelMessage model){
         mMessages.add(model);
         notifyDataSetChanged();
    }

    public void RemoveMessage(ModelMessage model){
        mMessages.remove(model);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {                                                                         // returns the size of list
        return mMessages.size();
    }

    @Override
    public Object getItem(int position) {                                                           // returns the item on the position
        Object rv = null;
        try{
            rv = mMessages.get(position);
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return rv;
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_item_message, null);

            ViewHolder holder = new ViewHolder();

            // linking the holder with inner class ViewHolder to the row item message from .xml file
            holder.inboxMessage = (TextView) convertView.findViewById(R.id.inboxMessage);
            convertView.setTag(holder);
        }

        ModelMessage model = (ModelMessage) getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();

        // taking information from holder and setting background
        holder.inboxMessage.setText(model.mInboxMessage);
        if(model.mRorS.equals("S")){
            holder.inboxMessage.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.inboxMessage.setGravity(Gravity.CENTER_VERTICAL | Gravity.END);
        }else{
            holder.inboxMessage.setBackgroundColor(Color.parseColor("#b3b3b3"));
            holder.inboxMessage.setGravity(Gravity.CENTER_VERTICAL | Gravity.START);
        }
        return convertView;
    }

    public class ViewHolder{
        public TextView inboxMessage = null;
    }
}
