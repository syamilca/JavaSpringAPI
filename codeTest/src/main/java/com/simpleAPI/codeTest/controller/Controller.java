package com.simpleAPI.codeTest.controller;

import com.simpleAPI.codeTest.model.Account;
import com.simpleAPI.codeTest.repository.AccountRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private final AccountRepo repository;

    public Controller(AccountRepo repository) {
        this.repository = repository;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public void login(@RequestBody Account account) {
        Account existAccount = repository.findByUsernameContains(account.username());
        if(!existAccount.password().equals(account.password())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect Password");
        }
    }

    @GetMapping("/joblist")
    public List<Object> getJobList() {
        String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
        RestTemplate restTemplate = new RestTemplate();
        Object[] jobList = restTemplate.getForObject(url, Object[].class);

        return Arrays.asList(jobList);

    }

    @GetMapping("/jobdetail/{id}")
    public Object getJobDetail(@PathVariable Integer id) {
        String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions/".concat(String.valueOf(id));
        RestTemplate restTemplate = new RestTemplate();
        Object jobDetail = restTemplate.getForObject(url, Object.class);

        return jobDetail;
    }

}
