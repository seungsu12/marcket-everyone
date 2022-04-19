package market.everyone.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ItemDto {

    private Long item_Id;
    private String item_Name;
    private List<MultipartFile> imgFiles;
    private MultipartFile attachFile;
}
