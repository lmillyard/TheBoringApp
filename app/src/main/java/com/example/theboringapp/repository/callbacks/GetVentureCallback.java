package com.example.theboringapp.repository.callbacks;

import com.example.theboringapp.repository.boring_models.SearchResponse;

public interface GetVentureCallback {
    void onSuccess(SearchResponse data);
    void onFailure(String message);
}
