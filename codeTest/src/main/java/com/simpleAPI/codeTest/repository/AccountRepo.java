package com.simpleAPI.codeTest.repository;

import com.simpleAPI.codeTest.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, Integer> {

    Account findByUsernameContains(String username);

}
