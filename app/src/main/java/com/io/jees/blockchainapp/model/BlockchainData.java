package com.io.jees.blockchainapp.model;



public class BlockchainData {

    private String hash;                                                          // <String of Hash, Integer of block_index>
    private String prev_block;
    private int n_tx;
    private int size;


    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrev_block() {
        return prev_block;
    }

    public void setPrev_block(String prev_block) {
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
