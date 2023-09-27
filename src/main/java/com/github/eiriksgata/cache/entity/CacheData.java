package com.github.eiriksgata.cache.entity;

public class CacheData<T> {

    private long termOfValidity = 0L;
    private long updateTimestamp = 0L;
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public void setTermOfValidity(long termOfValidity) {
        this.termOfValidity = termOfValidity;
    }

    public void setUpdateTimestamp(long updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public Long getTermOfValidity() {
        return termOfValidity;
    }

    public Long getUpdateTimestamp() {
        return updateTimestamp;
    }

    public T getContent() {
        return content;
    }
}
