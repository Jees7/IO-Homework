package com.io.jees.blockchainapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.io.jees.blockchainapp.model.BlockchainData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    public static final String urlSingleBlock = "https://blockchain.info/ko/rawblock/";                        // https://blockchain.info/ko/rawblock/$block_hash
    public static final String urlSingleTransaction = "https://blockchain.info/ko/rawtx/";                     // https://blockchain.info/ko/rawtx/$tx_hash

    private static final int NONE = 0;
    private static final int INPUT = 1;
    private static final int OUTPUT = 2;

    Button.OnClickListener mClickListenerSearch = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Get string of hash
            EditText hashText = (EditText) findViewById(R.id.et_hash);
            String hash = hashText.getText().toString();

            // Request and Parse from JSON
            requestJsonObject(hash, NONE);
        }
    };

    Button.OnClickListener mClickListenerInput = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Get string of hash
            EditText hashText = (EditText) findViewById(R.id.et_hash);
            String hash = hashText.getText().toString();

            // Request and Parse from JSON
            requestJsonObject(hash, INPUT);
        }
    };

    Button.OnClickListener mClickListenerOutput = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Get string of hash
            EditText hashText = (EditText) findViewById(R.id.et_hash);
            String hash = hashText.getText().toString();

            // Request and Parse from JSON
            requestJsonObject(hash, OUTPUT);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_search).setOnClickListener(mClickListenerSearch);
        findViewById(R.id.btn_input).setOnClickListener(mClickListenerInput);
        findViewById(R.id.btn_output).setOnClickListener(mClickListenerOutput);
    }

    private void requestJsonObject(String hash, final int resultType) {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = urlSingleBlock + hash;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Log.d(TAG, "Response " + response);

                // JSON parsing used GSON
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                List<BlockchainData> datas = new ArrayList<BlockchainData>();
                datas = Arrays.asList(mGson.fromJson(response, BlockchainData.class));

                showResult(datas, resultType);
                //Log.d(TAG, "size " + posts.get(0).getSize());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error " + error.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    private void showResult(List<BlockchainData> datas, int showType) {
        int nTx = datas.get(0).getN_tx();
        float avgTxValue = datas.get(0).getBits() / nTx;
        float avgTxFee = datas.get(0).getFee() / nTx;
        float avgTxSize = datas.get(0).getSize() / nTx;

        long inSequence = datas.get(0).getTx().get(0).getInputs().get(0).getSequence();
        int outTxIdx = datas.get(0).getTx().get(0).getOut().get(0).getTx_index();

        String string;

        switch (showType) {
            case NONE:
                string = "트랜젝션의 수 " + nTx +
                        "\n평균 트랜젝션의 값 " + avgTxValue +
                        "\n평균 트랜젝션의 수수료 " + avgTxFee +
                        "\n평균 트랜젝션의 크기 " + avgTxSize;
                break;

            case INPUT:
                string = "INPUT 의 Sequence " + inSequence;
                break;

            case OUTPUT:
                string = "OUTPUT 의 트랜젝션 인덱스 " + outTxIdx;
                break;

            default:
                string = "";
                break;
        }

        TextView textView = (TextView) findViewById(R.id.tv_result);
        textView.setText(string);
    }
}
