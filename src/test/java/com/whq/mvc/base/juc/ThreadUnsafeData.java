package com.whq.mvc.base.juc;

public class ThreadUnsafeData {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void add() {
        count++;
    }
}
