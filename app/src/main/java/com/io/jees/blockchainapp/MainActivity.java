package com.io.jees.blockchainapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.io.jees.blockchainapp.parser.GsonParseBlockchain;

public class MainActivity extends AppCompatActivity {

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // start to parse Blockchain JSON
            // get string for api-url
            EditText hashText = (EditText) findViewById(R.id.et_hash);
            String hash = hashText.getText().toString();

            GsonParseBlockchain gpb = new GsonParseBlockchain();
            gpb.parseSingleBlock(hash);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_search).setOnClickListener(mClickListener);

    }
}
