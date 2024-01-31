package com.zzm.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 阿里云 OSS 工具类
 *
 * @author Mingson
 * @version 1.0
 */
@Component
public class AliOSSUtils {

    @Autowired
    private AliOSSProperties aliOSSProperties;

//    /**
//     * @Value 注解通常用于外部配置的属性注入，具体用法为: @Value("${配置文件中的key}")
//     */
//    @Value("${aliyun.oss.endpoint}")
//    private String endpoint;
//    @Value("${aliyun.oss.accessKeyId}")
//    private String accessKeyId;
//    @Value("${aliyun.oss.accessKeySecret}")
//    private String accessKeySecret;
//    @Value("${aliyun.oss.bucketName}")
//    private String bucketName;

//    // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
//    // OSS管理控制台 -> Bucket 列表 -> 选择创建的 Bucket -> 概览 -> Endpoint(地域节点) -> 外网访问
//    private String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
////    // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
////    EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
//    private String accessKeyId = "";
//    private String accessKeySecret = "";
//    // 填写Bucket名称，例如examplebucket。
//    String bucketName = "examplebucket";

    /**
     * 实现上传图片到 OSS
     *
     * @param file
     * @return
     */
    public String upload(MultipartFile file) throws IOException {
        // 获取阿里云OSS参数
        String endpoint = aliOSSProperties.getEndpoint();
        String accessKeyId = aliOSSProperties.getAccessKeyId();
        String accessKeySecret = aliOSSProperties.getAccessKeySecret();
        String bucketName = aliOSSProperties.getBucketName();

        // 获取上传的文件的输入流
        InputStream inputStream = file.getInputStream();

        // 避免文件覆盖
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));

        // 上传文件到 OSS
        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, inputStream);
        // 创建PutObject请求。
        ossClient.putObject(putObjectRequest);

        // 文件访问路径
        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;
        // 关闭 ossClient
        ossClient.shutdown();
        return url;// 把上传到oss的路径返回
    }
}
