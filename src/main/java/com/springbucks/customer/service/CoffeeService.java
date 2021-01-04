package com.springbucks.customer.service;

import com.springbucks.customer.bean.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    @Autowired
    CoffeeDao coffeeDao;

    public int Insert(Coffee coffee){
        return coffeeDao.Insert(coffee);
    }

    public List<Coffee> getAll(){
        List<Coffee> list = coffeeDao.getAll();
        return list;
    }

    public Coffee getByName(String name){
        return coffeeDao.getByName(name);
    }
}
