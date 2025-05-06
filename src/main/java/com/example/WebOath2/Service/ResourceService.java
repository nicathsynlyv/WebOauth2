package com.example.WebOath2.Service;

import com.example.WebOath2.entities.Resource;

public interface ResourceService extends BaseService<Resource,Long>{
    Resource findByResourceName(String resourceName);

}
