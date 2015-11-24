package com.caishi.capricorn.common.meta.word;

import java.io.Serializable;

public class Word implements Serializable {

    /**
     * word id
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * word content
     */
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
