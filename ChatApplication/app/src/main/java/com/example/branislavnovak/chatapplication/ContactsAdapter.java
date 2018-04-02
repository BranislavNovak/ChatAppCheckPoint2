package com.example.branislavnovak.chatapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Branislav Novak on 28-Mar-18.
 */

public class ContactsAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Model> mContacts;         // list of contacts (models)



    public ContactsAdapter(Context context) {
        mContext = context;
        mContacts = new ArrayList<Model>();
    }

    public void AddContact(Model model){        // adding new contact in list
        mContacts.add(model);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {                     // returns the size of list
        return mContacts.size();
    }

    @Override
    public Object getItem(int position) {       // returns the item on position
        Object rv = null;
        try{
            rv = mContacts.get(position);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return rv;
    }

    @Override                                   // returns the items ID
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_item, null);

            final ImageView sendButton = (ImageView) convertView.findViewById(R.id.nextButton);
            final View finalConvertView = convertView;                                                              // needs to be like this, cause of getting a ID for TextView

            sendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // bundle is for saving string of current name and sanding it into other activity
                    Bundle b = new Bundle();
                    TextView tv = finalConvertView.findViewById(R.id.contactName);
                    String name = tv.getText().toString();
                    b.putString("contactName", name);

                    Intent i = new Intent (mContext, MessageActivity.class);
                    i.putExtras(b);
                    mContext.startActivity(i);
                }
            });

            ViewHolder holder = new ViewHolder();

            // linking the holder with inner class ViewHolder to the row item form .xml file
            holder.firstLetter = (TextView) convertView.findViewById(R.id.firstLetter);
            holder.name = (TextView) convertView.findViewById(R.id.contactName);
            holder.image = (ImageView) convertView.findViewById(R.id.nextButton);

            // sating a random background color on TextView
            holder.firstLetter.setBackgroundColor(getRandomColor());

            convertView.setTag(holder);
        }

        Model model = (Model) getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.firstLetter.setText(model.mFirstLetter);
        holder.name.setText(model.mNameOfContact);
        holder.image.setImageDrawable(model.mImage);

        return convertView;
    }

    private class ViewHolder{
        public TextView firstLetter = null;
        public TextView name = null;
        public ImageView image = null;
    }


    private int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
