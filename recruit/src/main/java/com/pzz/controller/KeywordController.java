package com.pzz.controller;


import com.pzz.pojo.Keyword;
import com.pzz.service.IKeywordService;
import com.pzz.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 彭政
 * @since 2022-11-27
 */
@RestController
@RequestMapping("/keyword")
public class KeywordController {
    @Autowired
    private IKeywordService keywordService;

    @GetMapping
    private JsonResult getAll() {
        List<Keyword> keywordList = keywordService.getBaseMapper().selectList(null);

        return JsonResult.ok("keywordList", keywordList);
    }
}

