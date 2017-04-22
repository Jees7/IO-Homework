package com.io.jees.blockchainapp.parser;

import android.util.Log;

public class GsonParseBlockchain {
    public static final String TAG = "GSON";

    public static String url_singleBlock = "https://blockchain.info/ko/rawblock/";                        // https://blockchain.info/ko/rawblock/$block_hash
    public static String url_singleTransaction = "https://blockchain.info/ko/rawtx/";                     // https://blockchain.info/ko/rawtx/$tx_hash


    public void parseSingleBlock(String hash) {
        String url_api = url_singleBlock + hash;
        Log.d(TAG, url_api);


    }
}
