package br.org.ismart.ismartonline.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Component
public class FileSaver {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ServletContext context;
	
	private static String bucketName     = "elasticbeanstalk-sa-east-1-174765381476";
	
//	public static void main(String[] args) throws IOException {
//        AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());
//        try {
//            System.out.println("Uploading a new object to S3 from a file\n");
//            File file = new File(uploadFileName);
//            s3client.putObject(new PutObjectRequest(
//            		                 bucketName, keyName, file));
//
//         } catch (AmazonServiceException ase) {
//            System.out.println("Caught an AmazonServiceException, which " +
//            		"means your request made it " +
//                    "to Amazon S3, but was rejected with an error response" +
//                    " for some reason.");
//            System.out.println("Error Message:    " + ase.getMessage());
//            System.out.println("HTTP Status Code: " + ase.getStatusCode());
//            System.out.println("AWS Error Code:   " + ase.getErrorCode());
//            System.out.println("Error Type:       " + ase.getErrorType());
//            System.out.println("Request ID:       " + ase.getRequestId());
//        } catch (AmazonClientException ace) {
//            System.out.println("Caught an AmazonClientException, which " +
//            		"means the client encountered " +
//                    "an internal error while trying to " +
//                    "communicate with S3, " +
//                    "such as not being able to access the network.");
//            System.out.println("Error Message: " + ace.getMessage());
//        }
//    }
	
	
	public String write(String baseFolder, MultipartFile file, String fileName){
		
		String webPath = baseFolder + "/" + fileName;
		
		 AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());
	        try {
	            System.out.println("Uploading a new object to S3 from a file\n");
	            s3client.putObject(new PutObjectRequest(
	            		                 bucketName, webPath, convert(file) ));

	         } catch (AmazonServiceException ase) {
	            System.out.println("Caught an AmazonServiceException, which " +
	            		"means your request made it " +
	                    "to Amazon S3, but was rejected with an error response" +
	                    " for some reason.");
	            System.out.println("Error Message:    " + ase.getMessage());
	            System.out.println("HTTP Status Code: " + ase.getStatusCode());
	            System.out.println("AWS Error Code:   " + ase.getErrorCode());
	            System.out.println("Error Type:       " + ase.getErrorType());
	            System.out.println("Request ID:       " + ase.getRequestId());
	        } catch (AmazonClientException ace) {
	            System.out.println("Caught an AmazonClientException, which " +
	            		"means the client encountered " +
	                    "an internal error while trying to " +
	                    "communicate with S3, " +
	                    "such as not being able to access the network.");
	            System.out.println("Error Message: " + ace.getMessage());
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return webPath;
		
//		System.out.println(context.getContextPath());
//		System.out.println(context.getRealPath(context.getContextPath()));
//		
//		String homePath = System.getProperty("user.home");
//		String baseFolderPath = homePath + "/" + baseFolder;
//		
//		File folder = new File(baseFolderPath);
//		if (! folder.exists())
//			folder.mkdirs();
//		
//		String filePath = baseFolderPath + "/" + file.getOriginalFilename();
//		
//		System.out.println(filePath);
//		
//		try {
//			file.transferTo(new File(filePath));
//			return filePath;
//		} catch (IllegalStateException | IOException e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
	}
	
	private File convert(MultipartFile file) throws IOException
	{    
	    File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(convFile); 
	    fos.write(file.getBytes());
	    fos.close(); 
	    return convFile;
	}

}
