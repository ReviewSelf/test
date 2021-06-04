package com.oj.service.impl;

import com.oj.DAO.ProblemMapper;
import com.oj.DAO.model.Problem;
import com.oj.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public int deleteById(Integer problemId) {
        problemMapper.deleteById(problemId);
        return 0;
    }

    @Override
    public int insert(Problem record) {
        problemMapper.insert(record);
        return 0;
    }

    @Override
    public int insertSelective(Problem record) {
        problemMapper.insertSelective(record);
        return 0;
    }

    @Override
    public Problem selectById(Integer problemId) {
        Problem problem=problemMapper.selectById(problemId);
        return problem;
    }

    @Override
    public List<Problem> selectAll() {
        List<Problem> problems=problemMapper.selectAll();
        return problems;
    }

    @Override
    public int updateByIdSelective(Problem record) {
        problemMapper.updateByIdSelective(record);
        return 0;
    }

    @Override
    public int updateById(Problem record) {
        problemMapper.updateById(record);
        return 0;
    }

    @Override
    public List<Problem> selectByTitle(String key) {
        List <Problem> problems=new ArrayList<>();
        if(key==null){
            problems= selectAll();
        }
        else {
            if(canParseInt(key)){
                problems.add(selectById(Integer.valueOf(key)));
            }
            problems.addAll(problemMapper.selectByTitle(key));
        }
        System.out.println(problems);
        if(problems.isEmpty()){
            return null;
        }
        return problems;

    }

    public boolean canParseInt(String str){
        if(str == null){ //验证是否为空
            return false;
        }
        return str.matches("\\d+");
        //使用正则表达式判断该字符串是否为数字，第一个\是转义符，\d+表示匹配1个或 //多个连续数字，"+"和"*"类似，"*"表示0个或多个
    }

}
