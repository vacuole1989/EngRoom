package com.cxd.engroom.bean;

import java.io.Serializable;

public class WordS implements Serializable {
    private int right=0;
    private String value;


    public int getRight() {
        return right;
    }

    public WordS setRight(int right) {
        this.right = right;
        return this;
    }

    public String getValue() {
        return value;
    }

    public WordS setValue(String value) {
        this.value = value;
        return this;
    }
}
