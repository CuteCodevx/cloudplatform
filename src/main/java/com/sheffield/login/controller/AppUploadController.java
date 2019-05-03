package com.sheffield.login.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sheffield.application.service.ApplicationService;
import com.sheffield.ServerConfig;
import com.sheffield.common.result.ActionResult;
import com.sheffield.common.result.ResultType;

@Controller
public class AppUploadController {

    @Resource
    private ApplicationService applicationService;

    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Value("${file.staticAccessPath}")
    private String staticAccessPath;

    @Resource
    private ServerConfig serverConfig;

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
            String imageDir = uploadFolder + "/image/";
            String fileDir = uploadFolder + "/file/";
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


            if(appFile != null && imageFile != null) {
                String imageName = UUID.randomUUID().toString().replace("-", "") + "-" + imageFile.getOriginalFilename();
                String fileName = UUID.randomUUID().toString().replace("-", "") + "-" + appFile.getOriginalFilename();
                executeUpload(fileDir + fileName, appFile);
                executeUpload(imageDir + imageName, imageFile);
                String url = serverConfig.getUrl() + staticAccessPath.replace("*", "");
                String imageUrl = url + "/image/" + imageName;
                String fileUrl = url + "/file/" + fileName;
                applicationService.saveApplication(imageUrl, fileUrl, linkUrl, applicationName, desc, userId);
            }


        }catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            return builder.code(ResultType.FAILURE.code()).message("upload file error").build();
        }

        return builder.build();
    }

    private void executeUpload(String fileUrl, MultipartFile file) throws Exception {
        //服务器端保存的文件对象
        File serverFile = new File(fileUrl);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }

}
