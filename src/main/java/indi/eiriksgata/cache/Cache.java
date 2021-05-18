package indi.eiriksgata.cache;

import indi.eiriksgata.cache.entity.CacheData;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author: create by Keith
 * version: v1.0
 * description: indi.eiriksgata.cache
 * date: 2021/5/18
 **/

public class Cache<T> {

    private ConcurrentHashMap<String, CacheData<T>> data = new ConcurrentHashMap<>();
    private Timer recoveryTimer;
    private long recoveryInterval = 5000;
    private int recoveryMax = 20;
    private Queue<String> recoverQueue = new LinkedList<>();

    public Cache() {
        recoveryTimer = new Timer();
        recoveryTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < recoveryMax; i++) {
                    String key = recoverQueue.poll();
                    if (key != null) {
                        if (data.get(key).getTermOfValidity() == 0) {
                            return;
                        }
                        if (data.get(key) != null) {
                            long updateTime = data.get(key).getUpdateTimestamp();
                            if (System.currentTimeMillis() - updateTime > data.get(key).getTermOfValidity()) {
                                data.remove(key);
                            }
                        }
                    }
                }
            }
        }, 0, recoveryInterval);
    }

    public void set(String key, T value, long termOfValidity) {
        CacheData<T> cacheData = new CacheData<>();
        cacheData.setContent(value);
        cacheData.setTermOfValidity(termOfValidity);
        cacheData.setUpdateTimestamp(System.currentTimeMillis());
        data.put(key, cacheData);
        recoverQueue.add(key);
    }

    public void set(String key, T value) {
        set(key, value, 0L);
    }

    public T get(String key) {
        if (System.currentTimeMillis() - data.get(key).getUpdateTimestamp() > data.get(key).getTermOfValidity()) {
            return null;
        }
        return data.get(key).getContent();
    }

    public void setRecoveryInterval(long recoveryInterval) {
        this.recoveryInterval = recoveryInterval;
    }

    public Timer getRecoveryTimer() {
        return recoveryTimer;
    }

    public ConcurrentHashMap<String, CacheData<T>> getData() {
        return data;
    }
}
