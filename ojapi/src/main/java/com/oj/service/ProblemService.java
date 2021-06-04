package com.oj.service;

import com.oj.DAO.model.Problem;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ProblemService {

    int deleteById(Integer problemId);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectById(Integer problemId);

    List<Problem> selectAll();

    int updateByIdSelective(Problem record);    //Problem如字段为空则跳过

    int updateById(Problem record);             //Problem如果字段为空则赋空

    List<Problem> selectByTitle(String key);
}
