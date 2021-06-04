package com.oj.DAO.model;


import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class Problem {
    private Integer problemId=null;

    private String title=null;

    private String description=null;

    private String input=null;

    private String output=null;

    private String sampleInput=null;

    private String sampleOutput=null;

    private String spj=null;

    private String hint=null;

    private String source=null;

    private Date inDate=null;

    private BigDecimal timeLimit=null;

    private Integer memoryLimit=null;

    private String defunct="Y";

    private Integer accepted=0;

    private Integer submit=0;

    private Integer solved=0;

    private String textInput=null;

    private String textOutput=null;


}