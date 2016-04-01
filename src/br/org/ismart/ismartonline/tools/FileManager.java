package br.org.ismart.ismartonline.tools;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.org.ismart.ismartonline.tools.models.AwsFileMiniModel;

public interface FileManager {

	List<AwsFileMiniModel> list(String prefix);

	String write(String baseFolder, MultipartFile file, String fileName);

}