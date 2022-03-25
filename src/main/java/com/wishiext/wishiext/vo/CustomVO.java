package com.wishiext.wishiext.vo;

import lombok.Data;

@Data
public class CustomVO {
    
    /*거래처 기본 정보*/
    private String busi_num;
    private String custom;
    private String shortName;
    private String ceo;
    private String charge_person;
    private String busi_condition;
    private String item;
    private String post_num;
    private String addr1;
    private String addr2;
    private String tel;
    private String fax;
    private String homePage;
    private String co_yn;
    private String foreign_yn;
    private String tax_yn;
    private String country_eng;
    private String country_kor;
    private String special_relation;
    private String trade_stop;
    private String contract_period_S;
    private String contract_period_E;
    private String regi_info_man;
    private String regi_info_date;
    private String modi_info_man;
    private String modi_info_date;

    /*거래처 계좌 정보*/
    private String factory;
    private String trade_bank;
    private String account_num;
}
