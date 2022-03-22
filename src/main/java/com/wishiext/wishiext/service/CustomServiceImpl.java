package com.wishiext.wishiext.service;

import com.wishiext.wishiext.dao.CustomDAO;
import com.wishiext.wishiext.vo.CustomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {

    @Autowired
    CustomDAO customDao;

    /*거래처 등록*/
    @Override
    public void insertCustom(CustomVO customVo) {
        System.out.println(customVo.getBusi_num());
        customDao.insertCustom(customVo);
    }

    /*거래처 검색*/
    @Override
    public List<CustomVO> searchCustom(String busi_num, String custom) {
        List<CustomVO> searchCustom = customDao.customSearchList(busi_num, custom);
        return searchCustom;
    }

    /*거래처 정보 조회*/
    @Override
    public CustomVO customDetail(String busi_num) {
//        List<CustomVO> customDetail = customDao.customDetail(busi_num);
//        return customDetail;

        System.out.println("111 busiNum : " + busi_num + "aaaaaa");
        busi_num = busi_num.trim();
        System.out.println("222 busiNum : " + busi_num + "aaaaaa");
        return customDao.customDetail(busi_num);
    }

    /*거래처 조회*/
    @Override
    public List<CustomVO> customList() {

        System.out.println("asdfadfadfasdfd");

        List<CustomVO> customList = customDao.customList();

//        System.out.println("131453254356758786");
        return customList;
    }


    /*거래처 정보 수정*/
    @Override
    public void updateCustom(CustomVO customVo) {
        customDao.updateCustom(customVo);
    }


    /*거래처 정보 삭제*/
    @Override
    public void deleteCustom(String busiNum) {

        System.out.println(busiNum);
        customDao.deleteCustom(busiNum);
    }
}
