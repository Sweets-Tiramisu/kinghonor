package com.bbs.manage.controller;

import com.bbs.common.CommonCode;
import com.bbs.common.ResponseResult;
import com.bbs.domain.Word;
import com.bbs.service.IWordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/word")
public class WordController {

    @Autowired
    private IWordService wordService;


    /**
     * 分页,条件查询
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/findByPage.do")
    public String findByPage(Model model, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<Word> list = wordService.findByPage();
        PageInfo pageInfo = new PageInfo(list, 6);
        model.addAttribute("wordMsgs", pageInfo);
        return "/WordPage";
    }

    /**
     * 增加敏感词汇
     * @param word
     * @return
     */
    @PostMapping("/addWord.do")
    @ResponseBody
    public ResponseResult addWord(@RequestBody Word word) {

        boolean flag = wordService.add(word);
        if (flag){
            return new ResponseResult(CommonCode.SUCCESS);
        }else{
            return new ResponseResult(CommonCode.FAIL);
        }
    }

    /**
     * 修改敏感词状态
     * @param wid
     * @param pageNum
     * @return
     */
    @GetMapping("/changeStatus.do")
    public String changeStatus(Integer wid,@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pageNum){
        wordService.changeStatus(wid);
        return "redirect:/word/findByPage.do?pn="+pageNum;
    }





}
