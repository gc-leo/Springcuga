package com.example.demo.external_api.faketory_api.services;

import com.example.demo.external_api.faketory_api.domain.User;
import com.example.demo.external_api.faketory_api.domain.UserData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by jt on 9/21/17.
 */
@Service
public class FaketoryApiServiceImpl implements FaketoryApiService {

    private RestTemplate restTemplate;

    public FaketoryApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers(Integer limit) {

        UserData userData = restTemplate.getForObject("http://apifaketory.com/api/user?limit=" + limit, UserData.class);
        return userData.getData();
    }
}
