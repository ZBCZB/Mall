package com.ljl.mall.tiny.service;


import com.ljl.mall.tiny.dto.OssCallbackResult;
import com.ljl.mall.tiny.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss服务
 */
public interface OssService {

    /**
     * 前端在文件上传前需要向后台拉起授权等上传策略
     * @return
     */
    OssPolicyResult policy();

    /**
     * 上传成功后oss服务器会访问后台的回调接口并将该结果返回给前端
     * @return
     */
    OssCallbackResult callback(HttpServletRequest request);
}
