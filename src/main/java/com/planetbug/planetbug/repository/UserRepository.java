package com.planetbug.planetbug.repository;

import com.planetbug.planetbug.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "call mydatabase.user_insert(:username, :email, @p_result);", nativeQuery = true)
    void userInsert(String username, String email);

    @Query(value = "call mydatabase.user_select_by_username(:username, @p_result);", nativeQuery = true)
    void userSelectByUserName(String username);

    @Query(value = "select @p_result", nativeQuery = true)
    Integer getProcedureResult();

}
