package com.aaa.controller;

import com.aaa.service.FtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/25 19:01
 */
@Controller
public class FileController {
    @Autowired
    private FtpService ftpService;
    @RequestMapping("upload")
    public String upload(@RequestParam("uploadFile")MultipartFile file, HttpSession session, ModelMap modelMap){
        Map<String,Object> resultMap = ftpService.upload(file);
        if (!(Boolean)resultMap.get("result")){
            //上传失败
            return "false";
        }else {
            return "success";
        }
    }
}
