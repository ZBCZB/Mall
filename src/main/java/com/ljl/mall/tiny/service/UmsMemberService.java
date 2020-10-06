package com.ljl.mall.tiny.service;

import com.ljl.mall.tiny.common.api.CommonResult;

/**
 * 会员管理
 */

public interface UmsMemberService {

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);


    /**
     * 判断验证码是否和手机号匹配
     */
    CommonResult verifyAuthCode(String telephone,String authCode);
}
