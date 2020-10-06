package com.ljl.mall.tiny.controller;

import com.ljl.mall.tiny.common.api.CommonResult;
import com.ljl.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import com.ljl.mall.tiny.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户浏览记录controller
 */
@Controller
@Api(tags = "MemberReadHistoryController",description = "用户商品浏览记录")
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {

    @Autowired
    MemberReadHistoryService memberReadHistoryService;

    @ApiOperation("创建浏览记录")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody MemberReadHistory memberReadHistory){
        int count=memberReadHistoryService.creat(memberReadHistory);
        if(count==1){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }
    @ApiOperation("删除浏览记录")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids")List<String> ids){
        int count=memberReadHistoryService.delete(ids);
        if(count>0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("展示浏览记录")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<MemberReadHistory>> list(Long memberId){
        List<MemberReadHistory> list=memberReadHistoryService.list(memberId);
        return CommonResult.success(list);
    }

}
