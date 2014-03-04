package com.qubo.learning.common.model;

/**
 * Created by Morrandir on 14-3-4.
 */
public enum ROLE {
    ROLE_USER(0), ROLE_ADMIN(1);

    private int index;

    ROLE(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
