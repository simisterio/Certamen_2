package com.example.simon.certamen2.interfaces;

import com.example.simon.certamen2.models.User;

import java.util.List;

/**
 * Created by simon on 03-11-2016.
 */

public interface RepoView {
    void initRecycler(List<User> user);
}
