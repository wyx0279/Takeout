package com.takeout.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.takeout.reggie.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface empMapper extends BaseMapper<Employee> {
}
