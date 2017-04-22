package com.io.jees.blockchainapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.io.jees.blockchainapp.parser.GsonBlockchain;

public class MainActivity extends AppCompatActivity {

    Button.OnClickListener mClickListenerSearch = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // get string of hash
            EditText hashText = (EditText) findViewById(R.id.et_hash);
            String hash = hashText.getText().toString();

            // search for blockchain information of hash
            GsonBlockchain gb = new GsonBlockchain();
            gb.parseSingleBlock(hash);

            // show data on textview
            TextView tv_ntx = (TextView) findViewById(R.id.tv_ntx);




        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_search).setOnClickListener(mClickListenerSearch);




    }
}
