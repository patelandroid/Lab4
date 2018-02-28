package com.example.patel.lab3checking;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.lang.String;
import java.util.ArrayList;

public class ChatWindow extends Activity {


    protected static final String ACTIVITY_NAME = "ChatWindow";

    ListView lv;
    EditText et;
    Button sendbutton;
    ArrayList<String> chat_array = new ArrayList<String>();
    Context context;


    public class ChatAdapter extends ArrayAdapter<String> {

        public ChatAdapter(@NonNull Context context, int resource) {
            super(context, 0);
        }

        @Override
        public int getCount() {
            return chat_array.size();
        }

        @Override
        public String getItem(int position) {
            return chat_array.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View result = null;
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();

            if (position % 2 == 0) {
                result = inflater.inflate(R.layout.chat_raw_incoming, null);
            }
            else {
                result = inflater.inflate(R.layout.chat_raw_outgoing, null);
            }

            TextView message = (TextView) result.findViewById(R.id.message_text);
            message.setText(getItem(position)); // get the string at position

            return result;

        }
    }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chat_window);

            lv = (ListView) findViewById(R.id.chatView);
            et = (EditText) findViewById(R.id.edittext);
            sendbutton = (Button) findViewById(R.id.sendbtn);


            sendbutton.setOnClickListener(new View.OnClickListener() {

               // LayoutInflater inflater = ChatWindow.this.getLayoutInflater();

                @Override
                public void onClick(View view) {
                    String getInput = et.getText().toString();
                    et.setText(" ");
                    chat_array.add(getInput);
//                if(chat_array.contains(getInput)) {
//                    Toast.makeText(getBaseContext(), "Value added in array", Toast.LENGTH_LONG).show();
//                }
//                else if(getInput == null || getInput.trim().equals("")) {
//                    Toast.makeText(getBaseContext(), "Input field is empty", Toast.LENGTH_LONG).show();
//                }
//                else{
//                    chat_array.add(getInput);
//                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(ChatWindow.this, android.R.layout.simple_list_item_1, chat_array );
//                    adapter.notifyDataSetChanged();
//
//
//            }
                  //  chat_array.add(getInput);
                    ChatAdapter messageAdapter;
                    messageAdapter = new ChatAdapter(ChatWindow.this,0);
                    lv.setAdapter(messageAdapter);
                   // messageAdapter.notifyDataSetChanged();


//                    Intent intent= new Intent(ChatWindow.this, ChatWindow.class);
//                    startActivity(intent);

                }
            });
        }

            @Override
            protected void onResume () {
                super.onResume();

                Log.i(ACTIVITY_NAME, "In onResume()");
            }

            @Override
            protected void onStart () {
                super.onStart();

                Log.i(ACTIVITY_NAME, "In onStart()");
            }

            @Override
            protected void onPause () {
                super.onPause();

                Log.i(ACTIVITY_NAME, "In onPause()");
            }

            @Override
            protected void onStop () {
                super.onStop();

                Log.i(ACTIVITY_NAME, "In onStop()");
            }

            @Override
            protected void onDestroy () {
                super.onDestroy();

                Log.i(ACTIVITY_NAME, "In onDestroy()");
            }

}
