package com.epam.geometry.specification;

public interface Specification<T> {

    boolean specified(T object);
}
