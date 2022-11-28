package com.example.theboringapp.repository.callbacks;

import com.example.theboringapp.repository.boring_models.SearchResponse;

public interface GetVentureCallback<T> {
    void onSuccess(T data);
    void onFailure(String message);
}
