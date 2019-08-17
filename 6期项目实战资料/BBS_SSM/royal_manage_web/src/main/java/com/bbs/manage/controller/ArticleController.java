package com.bbs.manage.controller;

import com.bbs.domain.Article;
import com.bbs.service.IArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {


    @Autowired
    private IArticleService articleService;

    /**
     * 分页,条件查询
     * @param model
     * @param pageNum
     * @param article
     * @return
     *
     */
    @GetMapping("/findByPage.do")
    public String findByPage(Model model, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pageNum, Article article) {
        try {
            if (article.getTitle()!=null){
                String title= new String(article.getTitle().getBytes("ISO-8859-1"), "utf-8");
                article.setTitle(title);
            }
            if (article.getSendername()!=null){
                String sendername= new String(article.getSendername().getBytes("ISO-8859-1"), "utf-8");
                article.setSendername(sendername);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        PageHelper.startPage(pageNum, 6);
        List<Article> list = articleService.findByPage(article);
        PageInfo pageInfo = new PageInfo(list, 6);
        model.addAttribute("articleMsgs", pageInfo);
        model.addAttribute("articleSearch", article);
        return "/ArticlePage";
    }

    /**
     * 修改置顶状态
     * @param id
     * @param pageNum
     * @param article
     */
    @GetMapping("/changeStatus.do")
    public String changeStatus(@RequestParam("id") Integer id, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pageNum, Article article) {
        articleService.changeStatus(id);
        String title="";
        if (article.getTitle()!=null){
            title=article.getTitle();
        }
        if (article.getSendername()!=null){
            return "redirect:/article/findByPage.do?title="+title+"&pn="+pageNum+"&role="+article.getSendername();
        }else{
            return "redirect:/article/findByPage.do?title="+title+"&pn="+pageNum+"&role=";
        }
    }

    @GetMapping("/deleteArticle.do")
    public String deleteArticle(@RequestParam("id") Integer id, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pageNum, Article article) {
        articleService.deleteArticle(id);
        String title="";
        if (article.getTitle()!=null){
            title=article.getTitle();
        }
        if (article.getSendername()!=null){
            return "redirect:/article/findByPage.do?title="+title+"&pn="+pageNum+"&role="+article.getSendername();
        }else{
            return "redirect:/article/findByPage.do?title="+title+"&pn="+pageNum+"&role=";
        }
    }

    /**
     * 根据用户id查询信息
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/findById.do")
    public Article findById(Integer id) {
        Article article=articleService.findById(id);
        return article;
    }



}
