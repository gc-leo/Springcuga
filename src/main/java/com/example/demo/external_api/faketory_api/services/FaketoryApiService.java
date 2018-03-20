package com.example.demo.external_api.faketory_api.services;


import com.example.demo.external_api.faketory_api.domain.User;

import java.util.List;

/**
 * Created by jt on 9/21/17.
 */
public interface FaketoryApiService {

    List<User> getUsers(Integer limit);
}
