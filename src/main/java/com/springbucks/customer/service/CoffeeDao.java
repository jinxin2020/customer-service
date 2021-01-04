package com.springbucks.customer.service;

import com.springbucks.customer.bean.Coffee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CoffeeDao {
    @Insert("INSERT INTO t_coffee(id,name,price,create_time,update_time) VALUES(#{id}, #{name}, #{price}, #{createTime}, #{updateTime})")
    public int Insert(Coffee coffee);

    @Select("select * from t_coffee")
    List<Coffee> getAll();

    @Select("select * from t_coffee where id=#{id}")
    Coffee getById(Long id);

    @Select("select * from t_coffee where name=#{name}")
    Coffee getByName(String name);
}
