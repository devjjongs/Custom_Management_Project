package com.wishiext.wishiext.controller;

import com.wishiext.wishiext.dao.CustomDAO;
import com.wishiext.wishiext.service.CustomService;
import com.wishiext.wishiext.vo.CustomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CustomController {

    @Autowired
    private CustomDAO customDao;

    @Autowired
    private CustomService customService;

    //거래처 등록 호출
    @GetMapping("/customRegister")
    public String customRegister() {
        return "customRegister";
    }

    //거래처 등록
    @PostMapping("insertCustom")
    public String insertCustom(CustomVO customVo) {
        System.out.println(customVo);
        customService.insertCustom(customVo);
        return "redirect:/";
    }

    /////////////////////////////////////////////////////////////////////////////////
    //거래처 전체 목록
    @RequestMapping(value = {"/", "/custommanage"})
    public String customList(Model model) {

//        List<CustomVO> customList = customDao.customList();
        List<CustomVO> customList = customService.customList();
        System.out.println(customList);

        model.addAttribute("customList", customList);
        return "customManage";
    }


    ////////////////////////////////////////////////////////////////////////////////

    //  거래처 검색 메소드 //111
    //  파라미터 : 사업자번호, 거래처명
    protected void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String busi_num = request.getParameter("BN");
        String custom = request.getParameter("CS");

    }


//    //    거래처 검색 메소드
//    //    파라미터 : 사업자번호, 거래처명
//    @RequestMapping(value = {"", "/", "/custommanage"})
//    public String customSearchList(Model model, @RequestParam(value = "busi_num") String busi_num, @RequestParam(value = "custom") String custom) throws Exception {
//        System.out.println("custom search 진입");
//        System.out.println("busi_num : " + busi_num);
//        System.out.println("custom : " + custom);
//
//        List<CustomVO> customSearchList = customService.searchCustom(busi_num, custom);
//
//        ModelAndView mav = new ModelAndView();
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("customSearchList", customSearchList);
//        map.put("busi_num", busi_num);
//        map.put("custom", custom);
//        mav.addObject("map", map);
//        mav.setViewName("customanage");
//        return null;
//    }


//    @RequestMapping(value = "/customInfo", method = {RequestMethod.POST})
//    public void selectCustom(@RequestParam("busi_num") String busi_num, @RequestParam("custom") String custom) {
//        System.out.println(busi_num);
//        System.out.println(custom);
//
//        CustomVO customVo = new CustomVO();
//
//        customVo.setBusi_num(busi_num);
//        customVo.setCustom(custom);
//
//        customDao.customList();
//        return;
//    }


    //거래처 수정 호출
    @GetMapping("/customInfo")
    public String customInfo() {
        return "customInfo";
    }

    //거래처 정보 수정
    @PostMapping("updateCustom")
    public void updateCustom(CustomVO customVo) {
        System.out.println(customVo);
        customService.updateCustom(customVo);
    }


    //거래처 삭제
    @GetMapping("/deleteCustom")
    public String deleteCustom() {
        return "deleteCustom";
    }


//    //거래처 정보 수정
//    @GetMapping("/customInfo")
//    public void update(HttpSession session, Model model) {
//        String busi_num = (String) session.getAttribute("busi_num");
//        model.addAttribute("customSelect", customService.customSelect(busi_num));
//    }


/*    @RequestMapping("/")
    public String main(){
        return "";
    }

    // 거래처관리 페이지를 리턴하는 메소드
    @RequestMapping("/customInsert")
    public String insertCustom(CustomVo customvo) {
        System.out.println("isnert custom 진입");
        CustomDao.insertCustom(customvo);
        return "customManage";
    }



*/
}
