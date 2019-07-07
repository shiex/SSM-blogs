package com.xbb.controller;

import com.xbb.pojo.User;
import com.xbb.utils.AxDateUtils;
import com.xbb.utils.AxFileUploadUtils;
import com.xbb.utils.RestMap;
import com.xbb.utils.StatusCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author shiex-薛
 * @title: UploadFileController
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\30 003022:56
 */
@RestController
public class UploadFileController {

    /**
     * @description: 图片上传处理器
     * @param multipartFile
     * @param session
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/uploadFile",produces="application/json;charset=UTF-8")
    public Map<String, Object> fileUpload(@RequestParam("file") MultipartFile multipartFile, HttpSession session)
    {
        Map<String, Object> map = RestMap.getRestMap();
        if(multipartFile != null)
        {
            String realName = multipartFile.getOriginalFilename(); // 原始文件名
            String suffix = AxFileUploadUtils.fileSuffix(realName); // 文件名后缀
            String tmpFileName = AxFileUploadUtils.createTmpFileName(suffix); // 生成保证不重复的临时文件名

            // 图片上传验证
            if(!StatusCode.IMG_TYPE.contains(suffix)){
                map.put(StatusCode.ERROR, 1);
                map.put(StatusCode.MESSAGE, "上传失败：请上传格式为[" + StatusCode.IMG_TYPE + "]的图片");
                return map;
            }
            if(multipartFile.getSize() > StatusCode.IMG_SIZE_MAX){
                map.put(StatusCode.ERROR, 1);
                map.put(StatusCode.MESSAGE,"上传失败：图片大小不得超过10MB");
                return map;
            }

            // // 当图片数量大于1900时则新建文件夹
            StringBuilder sbr = new StringBuilder();
            User user = (User) session.getAttribute(StatusCode.SESSION_USER);
            String imgFileRoot = user.getImgFileRoot(); // 图片存储父目录
            File imgFile = new File(StatusCode.WEB_FILE_ROOT,imgFileRoot);
            File[] files = imgFile.listFiles();
            if(files.length > 1900){
                String date = AxDateUtils.format(AxDateUtils.SDF_Y2);
                sbr.append(StatusCode.IMGS_ROOT).append(date).append("/").append(user.getId());
                imgFileRoot = sbr.toString();
                imgFile = new File(StatusCode.WEB_FILE_ROOT,imgFileRoot);
                imgFile.mkdirs(); // 生成图片存储新目录
            }

            File tmpFile = new File(imgFile, tmpFileName);
            sbr.setLength(0);
            sbr.append(StatusCode.CONTEXT_PATH).append(imgFileRoot).append("/").append(tmpFileName);
            try{
                multipartFile.transferTo(tmpFile); // 写入图片
                map.put(StatusCode.ERROR, 0); // 富文本图片上传成功状态码
                map.put("url", sbr.toString()); // 富文本要求返回图片路径
                map.put("data", sbr.toString()); // 用户上传返回图片路径
            }catch (IOException e) {
                map.put(StatusCode.ERROR, 1); // 上传失败
                map.put(StatusCode.MESSAGE, e.getMessage());
                e.printStackTrace();
            }
        }

        return map;
    }

}
