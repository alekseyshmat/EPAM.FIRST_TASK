package com.epam.geometry.observer;

public interface Observable<T> {

    void addObserver(T obj);

    void removeObserver(T obj);

    void notifyObservers();

}
