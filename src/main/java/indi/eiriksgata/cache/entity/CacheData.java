package indi.eiriksgata.cache.entity;

/**
 * author: create by Keith
 * version: v1.0
 * description: indi.eiriksgata.cache.entity
 * date: 2021/5/18
 **/
public class CacheData<T> {

    private Long termOfValidity = 0L;
    private Long updateTimestamp = 0L;
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public void setTermOfValidity(Long termOfValidity) {
        this.termOfValidity = termOfValidity;
    }

    public void setUpdateTimestamp(Long updateTimestamp) {
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
