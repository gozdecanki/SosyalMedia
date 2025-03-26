package com.gozde.repository;

import com.gozde.entity.Auth;

public interface AuthRepository extends MyGenericRepo<Auth,Long> {
    Boolean existsByUserNameAndPassword(String userName, String password);
}
