package com.sheffield.login.controller;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sheffield.application.service.ApplicationService;
import com.sheffield.common.result.ActionResult;
import com.sheffield.common.result.ResultType;

@Controller
public class AppUploadController {

    @Resource
    private ApplicationService applicationService;

    @RequestMapping(value = "/uploads", method = RequestMethod.POST)
    @ResponseBody
    public ActionResult<String> uploads(HttpServletRequest request,
                                @RequestParam("appFile") MultipartFile appFile,
                                @RequestParam("imageFile") MultipartFile imageFile,
                                String applicationName,
                                String desc,
                                String linkUrl) {
        ActionResult.Builder<String> builder = new ActionResult.Builder<>();
        try {
            //上传目录地址
            String imageDir = request.getSession().getServletContext().getRealPath("/") +"image\\";
            String fileDir = request.getSession().getServletContext().getRealPath("/") +"file\\";
            HttpSession session = request.getSession();
            Integer userId = (Integer) session.getAttribute("userId");

            File image = new File(imageDir);
            if(!image.exists()) {
                image.mkdir();
            }
            File file = new File(fileDir);
            if(!file.exists()) {
                file.mkdir();
            }

            String fileUlr = "";
            if(appFile != null) {
                fileUlr = executeUpload(fileDir, appFile);
            }
            String imageUrl = "";
            if(imageFile != null) {
                //调用上传方法
                imageUrl = executeUpload(imageDir, imageFile);
            }

            applicationService.saveApplication(imageUrl, fileUlr, linkUrl, applicationName, desc, userId);

        }catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            return builder.code(ResultType.FAILURE.code()).message("upload file error").build();
        }

        return builder.build();
    }

    private String executeUpload(String uploadDir, MultipartFile file) throws Exception {
        //文件后缀名
        // String suffix = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = file.getOriginalFilename();
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);

        return uploadDir + filename;
    }

}
