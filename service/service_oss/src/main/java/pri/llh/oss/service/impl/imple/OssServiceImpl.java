package pri.llh.oss.service.impl.imple;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pri.llh.oss.service.impl.OssService;
import pri.llh.oss.utils.ConstantPropertiesUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author LiHao Liao
 * @version 1.0
 * @Package_Name pri.llh.oss.service.impl.imple
 * @since 1.0
 */
@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFileAvatar(MultipartFile file) {

        String endpoint = ConstantPropertiesUtils.END_POINT;
        String accessKeyId = ConstantPropertiesUtils.KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;


        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String filename = "";
        String date = "";

        try {
            InputStream inputStream = file.getInputStream();
            filename = file.getOriginalFilename();
            int i = filename.indexOf(".");
            //UUID to prevent filename repeat
            filename = filename.substring(0,i)+UUID.randomUUID().toString().replace("-", "").toLowerCase()+filename.substring(i);
            //store the file by upload date
            date = new DateTime().toString("yyyy/MM/dd");
            ossClient.putObject(bucketName, date+"/"+filename, inputStream);


        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
            //https://cyber-portal.oss-cn-guangzhou.aliyuncs.com/wlop1.jpg
            String url = "https://"+bucketName+"."+endpoint+"/"+date+"/"+filename;
            //System.out.println(url);
            return url;
        }
    }
}


