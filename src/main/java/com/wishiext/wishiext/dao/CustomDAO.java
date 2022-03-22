package com.wishiext.wishiext.dao;

import com.wishiext.wishiext.vo.CustomVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomDAO {

    /*거래처 등록*/
    void insertCustom(CustomVO customVo);


    /*거래처 조회*/
    List<CustomVO> customSearchList(String busi_num, String custom);

    /*거래처 목록*/
    List<CustomVO> customList();

    /*거래처 정보 조회*/
    CustomVO customDetail(String busi_num);

    /*거래처 수정*/
    void updateCustom(CustomVO customVo);

    /*거래처 삭제*/
    void deleteCustom(String busiNum);


}
