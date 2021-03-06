package com.thelivelock.elasticsearch_autocomplete.service;

import com.thelivelock.elasticsearch_autocomplete.model.User;
import com.thelivelock.elasticsearch_autocomplete.repository.UserRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        return this.userRepository.findAll();
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public long count() {
        return this.userRepository.count();
    }

    public List<User> search(String keywords) {
        MatchQueryBuilder searchByCountries = QueryBuilders.matchQuery("country", keywords);
        return this.userRepository.search(searchByCountries);
    }
}
