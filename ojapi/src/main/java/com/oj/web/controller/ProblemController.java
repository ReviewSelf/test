package com.oj.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.oj.DAO.model.Problem;
import com.oj.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @RequestMapping(value = "/selectAll")
    public @ResponseBody Object ProblemDetail(){
        List<Problem> problems= problemService.selectAll();
        return problems;
    }
    @PostMapping("/delete")
    public void delete(Integer id){
        problemService.deleteById(id);
    }

    @PostMapping("/update")
    public void update(@RequestBody Problem problem)  {
        System.out.println(problem.toString());
        problemService.updateByIdSelective(problem);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody Problem problem){
        Date date = new Date();
        problem.setInDate(date);
        System.out.println(problem.toString());
        problemService.insertSelective(problem);
    }

    @PostMapping("/selectproblem")
    public List<Problem> select(@RequestBody JSONObject jsonParam){
        String key=jsonParam.getString("key");
        return problemService.selectByTitle(key);
    }




}
