package com.io.jees.blockchainapp.model;

import java.util.HashMap;

public class BlockchainData {

    private HashMap<String, Integer> hash;                                                          // <String of Hash, Integer of block_index>
    private HashMap<String, Integer> prev_block;
    private int n_tx;
    private int size;


    public HashMap<String, Integer> getHash() {
        return hash;
    }

    public void setHash(HashMap<String, Integer> hash) {
        this.hash = hash;
    }

    public HashMap<String, Integer> getPrev_block() {
        return prev_block;
    }

    public void setPrev_block(HashMap<String, Integer> prev_block) {
        this.prev_block = prev_block;
    }

    public int getTxNumber() {
        return n_tx;
    }

    public void setTxNumber(int n_tx) {
        this.n_tx = n_tx;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
