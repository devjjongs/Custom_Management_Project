package com.wishiext.wishiext.controller;

import com.wishiext.wishiext.dao.CustomDAO;
import com.wishiext.wishiext.service.CustomService;
import com.wishiext.wishiext.vo.CustomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CustomController {

    @Autowired
    private CustomService customService;

    /*거래처 등록 호출*/
    @GetMapping("/customRegister")
    public String customRegister() {
        return "customRegister";
    }

    /*거래처 등록*/
    @PostMapping("insertCustom")
    public String insertCustom(CustomVO customVo) {
        System.out.println(customVo);
        customService.insertCustom(customVo);
        return "redirect:/custommanage";
    }

    /*거래처 전체 목록*/
    @RequestMapping(value = {"/", "/custommanage"})
    public String customList(Model model) {

        List<CustomVO> customList = customService.customList();
        System.out.println(customList);

        model.addAttribute("customList", customList);
        return "customManage";
    }


    /*거래처 검색 메소드*/
    /*파라미터 : 사업자번호, 거래처명*/
    @RequestMapping(value = {"/", "/customSearchList"})
    public String customSearchList(Model model, @RequestParam(value = "busiNum") String busi_num, @RequestParam(value = "custom") String custom) throws Exception {
        System.out.println("custom search 진입");
        System.out.println("busiNum : " + busi_num);
        System.out.println("custom : " + custom);

        List<CustomVO> customSearchList = customService.searchCustom(busi_num, custom);
        System.out.println(customSearchList.get(0));

        model.addAttribute("customSearchList", customSearchList);
        return "searchCustomListPage";
    }


    /*거래처 정보 호출*/
    @RequestMapping(value = "/customDetail")
    public String selectCustom(Model model, @RequestParam(value = "busiNum") String busi_num) {
        System.out.println("select custom 진입");
        System.out.println("busiNum : " + busi_num + "aaaaaa");

        CustomVO customDetail = customService.customDetail(busi_num);
        System.out.println(customDetail);

        model.addAttribute("customDetail", customDetail);
        return "customInfo";
    }

    /*거래처 수정 호출*/
    @GetMapping("/customInfo")
    public String customInfo() {
        return "customInfo";
    }


    /*거래처 정보 수정*/
    @PostMapping("/updateCustom")
    public String updateCustom(CustomVO customVo) {
        System.out.println(customVo);
        customService.updateCustom(customVo);
        return "redirect:/custommanage";
    }

    /*거래처 삭제*/
    @RequestMapping("/deleteCustom")
    public String deleteCustom(String busiNum) {
        System.out.println(busiNum);
        customService.deleteCustom(busiNum);
        return "redirect:/custommanage";
    }
}
