package com.wishiext.wishiext.service;

import com.wishiext.wishiext.vo.CustomVO;

import java.util.List;

public interface CustomService {

    void insertCustom(CustomVO customVo);   //  거래처 등록

    List<CustomVO> searchCustom(String busi_num, String custom);// 거래처 목록 조회

    //거래처 조회
    List<CustomVO> customList();

    //거래처 정보 조회
    CustomVO customDetail(String busi_num);
//    void customList2(String busi_num, String custom);

    void updateCustom(CustomVO customVo);   //  거래처 정보 수정

    void deleteCustom(String busiNum);   //  거래처 삭제

}
