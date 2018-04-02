package com.example.branislavnovak.chatapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class ContactsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        bLogout = findViewById(R.id.logoutButton);
        bLogout.setOnClickListener(this);


        ContactsAdapter adapter = new ContactsAdapter(this);

        // making object of Model Class with (String, String, Drawable) parameters
        //adapter.AddContact(new Model(("S"), ("Stevan Popov"), getResources().getDrawable(R.drawable.next_button3)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact1).charAt(0)),getResources().getString(R.string.sContact1),getResources().getDrawable(R.drawable.next_button3)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact2).charAt(0)),getResources().getString(R.string.sContact2),getResources().getDrawable(R.drawable.next_button3)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact3).charAt(0)),getResources().getString(R.string.sContact3),getResources().getDrawable(R.drawable.next_button3)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact4).charAt(0)),getResources().getString(R.string.sContact4),getResources().getDrawable(R.drawable.next_button3)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact5).charAt(0)),getResources().getString(R.string.sContact5),getResources().getDrawable(R.drawable.next_button3)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact6).charAt(0)),getResources().getString(R.string.sContact6),getResources().getDrawable(R.drawable.next_button3)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact7).charAt(0)),getResources().getString(R.string.sContact7),getResources().getDrawable(R.drawable.next_button3)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact8).charAt(0)),getResources().getString(R.string.sContact8),getResources().getDrawable(R.drawable.next_button3)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact9).charAt(0)),getResources().getString(R.string.sContact9),getResources().getDrawable(R.drawable.next_button3)));
        adapter.AddContact(new Model(("" + getResources().getString(R.string.sContact10).charAt(0)),getResources().getString(R.string.sContact10),getResources().getDrawable(R.drawable.next_button3)));


        ListView list = findViewById(R.id.listOfContacts);
        list.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.logoutButton:
                Intent i1 = new Intent(this, MainActivity.class);
                startActivity(i1);
                break;
            case R.id.nextButton:
                Intent i2 = new Intent(this, MessageActivity.class);
                startActivity(i2);
                break;
        }
    }

}
