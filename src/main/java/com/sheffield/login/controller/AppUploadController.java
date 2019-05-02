package com.sheffield.login.controller;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sheffield.login.service.ApplicationService;

/**
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月02日 2:07
 * @version 1.0
 */ 

public class AppUploadController {

    @Resource
    private ApplicationService applicationService;

    /**
     * 上传多个文件
     * @param request 请求对象
     * @param file 上传文件集合
     * @return
     */
    @RequestMapping(value = "/uploads",method = RequestMethod.POST)
    @ResponseBody
    public String uploads(HttpServletRequest request, MultipartFile[] files, String applicationName, String desc, String linkUrl) {
        try {
            //上传目录地址
            String imageDir = request.getSession().getServletContext().getRealPath("/") +"image/";
            String fileDir = request.getSession().getServletContext().getRealPath("/") +"file/";
            HttpSession session = request.getSession();
            Integer userId = (Integer) session.getAttribute("userId");

            File image = new File(imageDir);
            if(!image.exists()) {
                image.mkdir();
            }
            if(files[0] != null) {
                //调用上传方法
                executeUpload(imageDir, files[0]);
            }

            File file = new File(fileDir);
            if(!file.exists()) {
                file.mkdir();
            }
            if(files[1] != null) {
                //调用上传方法
                executeUpload(fileDir, files[1]);
            }

            applicationService.saveApplication("", "", linkUrl, applicationName, desc, userId);

        }catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    /**
     * 提取上传方法为公共方法
     * @param uploadDir 上传文件目录
     * @param file 上传对象
     * @throws Exception
     */
    private void executeUpload(String uploadDir, MultipartFile file) throws Exception {
        //文件后缀名
        String suffix = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }

}
