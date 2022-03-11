package market.everyone.upload;

import market.everyone.domain.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class FileStore {

    @Value("${file.dir")
    private String fileDir;

    public String getFullPath(String filename) {
        return fileDir+filename;
    }

    public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }

        String originalFilename = multipartFile.getOriginalFilename();
        //image.png

        //서버에 저장하는 파일명
        String storeFileName = createStoreFileName(originalFilename);
        multipartFile.transferTo(new File(getFullPath(storeFileName)));
        return new UploadFile(originalFilename,storeFileName);
    }

    private String createStoreFileName(String originalFilename) {
        String uuid  = UUID.randomUUID().toString();
        String ext = extracted(originalFilename);
        return  uuid+"."+ext;
    }

    private String extracted(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos+1);
    }


}
