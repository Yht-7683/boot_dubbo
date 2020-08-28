package com.pkm.service.service;

import com.pkm.service.object.Bag;

import java.util.List;


public interface BagService {
       List<Bag> searchBag(String keyword);
        List<Bag> getAllBag();

}
