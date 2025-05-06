package com.example.WebOath2.Service;

import com.example.WebOath2.entities.Privilege;

public interface PrivilegeService extends BaseService <Privilege,Long>{
    Privilege findByName(String name);
}
