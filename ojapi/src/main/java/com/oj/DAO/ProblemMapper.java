package com.oj.DAO;

import com.oj.DAO.model.Problem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProblemMapper {
    int deleteById(Integer problemId);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectById(Integer problemId);

    List<Problem> selectByTitle(String key);

    List<Problem> selectAll();

    int updateByIdSelective(Problem record);    //Problem如字段为空则跳过

    int updateById(Problem record);             //Problem如果字段为空则赋空
}