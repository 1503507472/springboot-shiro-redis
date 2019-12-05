package com.aaa.service;

import com.aaa.config.FtpClientProperties;
import com.aaa.util.FileNameUtil;
import com.aaa.util.FtpClient;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/25 19:03
 */
@Service
public class FtpService {
    private static Logger logger= LoggerFactory.getLogger(FtpService.class);
    @Autowired
    private FtpClientProperties ftpClientProperties;
    public Map<String, Object> upload(MultipartFile file) {
        /**
         * 1,获取文件原始名
         * 2，生成新的文件名
         *
         */
        Map<String, Object> resultMap = new HashMap<>(2);
        //获取文件原始名
        String oldFileName = file.getOriginalFilename();
        //获取原始文件后缀
        String substring = oldFileName.substring(oldFileName.lastIndexOf("."));

        //生成一个新的文件名
        String newFileName = FileNameUtil.getFileName() + substring;
        //创建文件目录
        String filePath = new DateTime().toString("yyyy/MM/dd");

        //使用工具类进行ftp上传
        try {

            Boolean aBoolean = FtpClient.uploadFtp(ftpClientProperties.getHost(), ftpClientProperties.getPort(),
                    ftpClientProperties.getUsername(), ftpClientProperties.getPassword(),
                    ftpClientProperties.getBasePath(), filePath, newFileName, file.getInputStream());
            resultMap.put("result", aBoolean);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return resultMap;
    }
}
