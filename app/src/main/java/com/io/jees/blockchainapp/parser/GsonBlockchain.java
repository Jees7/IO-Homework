package com.io.jees.blockchainapp.parser;

import android.util.Log;

public class GsonBlockchain {
    public static final String TAG = "GSON";

    public static String urlSingleBlock = "https://blockchain.info/ko/rawblock/";                        // https://blockchain.info/ko/rawblock/$block_hash
    public static String urlSingleTransaction = "https://blockchain.info/ko/rawtx/";                     // https://blockchain.info/ko/rawtx/$tx_hash


    public void parseSingleBlock(String hash) {
        String urlAPI = urlSingleBlock + hash;
        Log.d(TAG, urlAPI);


    }
}
