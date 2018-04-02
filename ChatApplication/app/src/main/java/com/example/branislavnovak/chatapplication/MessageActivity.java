package com.example.branislavnovak.chatapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bSend;
    private EditText enteredMessage;
    final MessageAdapter adapter = new MessageAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        // getting all IDs from .xml
        bSend = findViewById(R.id.sendButton);
        enteredMessage = findViewById(R.id.eMessage);

        Button bLogout = findViewById(R.id.logoutButton1);
        ListView listOfContacts = findViewById(R.id.listOfMessages);
        TextView nameOfContact = findViewById(R.id.contactNameInMessage);                           // nameOfContact taking a ID of a TextView field that needs to be changed

        bSend.setEnabled(false);
        bSend.setOnClickListener(this);
        bLogout.setOnClickListener(this);

        // getting all extras (exactly the nameOfContact)
        Intent i = getIntent();
        Bundle b = i.getExtras();                                                                   // getting a values from the first made Bundle in ContactsAdapter
        String name = b.getString("contactName");                                              // then set a value on a String through a key value
        nameOfContact.setText(name);                                                                // making a TextView in MessageActivity

        // adding all messages to list
        adapter.AddMessage(new ModelMessage(getResources().getString(R.string.sRMessage1), "R"));
        adapter.AddMessage(new ModelMessage(getResources().getString(R.string.sSMessage1), "S"));
        adapter.AddMessage(new ModelMessage(getResources().getString(R.string.sRMessage2), "R"));
        adapter.AddMessage(new ModelMessage(getResources().getString(R.string.sSMessage2), "S"));
        adapter.AddMessage(new ModelMessage(getResources().getString(R.string.sRMessage3), "R"));
        adapter.AddMessage(new ModelMessage(getResources().getString(R.string.sSMessage3), "S"));
        adapter.AddMessage(new ModelMessage(getResources().getString(R.string.sRMessage4), "R"));

        listOfContacts.setAdapter(adapter);

        // setting item of a list on LongClickListener for removing it from list with method RemoveMessage(ModelMessage)
        listOfContacts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                ModelMessage model = (ModelMessage) adapter.getItem(i);
                adapter.RemoveMessage(model);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        enteredMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = enteredMessage.getText().toString();
                if (s.length() != 0){
                    bSend.setEnabled(true);
                }else{
                    bSend.setEnabled(false);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.sendButton:
                // adding a message to list
                String message = enteredMessage.getText().toString();
                adapter.AddMessage(new ModelMessage(message,"S"));
                String messageSent = "Message is sent";
                Toast.makeText(this, messageSent, Toast.LENGTH_LONG).show();
                enteredMessage.getText().clear();
                enteredMessage.setHint(R.string.sMessage);
                break;

            case R.id.logoutButton1:
                Intent j = new Intent(this, MainActivity.class);
                startActivity(j);
                break;
        }
    }
}
