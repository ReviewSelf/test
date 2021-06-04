package com.oj.DAO.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Users {
    private String userId=null;

    private String email=null;

    private Integer submit=0;

    private Integer solved=0;

    private String defunct="N";

    private String ip="127.0.0.1";

    private Timestamp accesstime=null;

    private Integer volume=0;

    private Integer language=1;

    private String password=null;

    private Timestamp regTime=null;

    private String nick=null;

    private String school="宁波工程学院";
}