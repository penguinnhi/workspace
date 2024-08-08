package com.green.Shop.utill;


import com.green.Shop.item.vo.ImgVO;
import com.green.Shop.item.vo.ShopItemVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

//첨부파일과 관련된 기능
public class FileUploadUtil {

    //파일 업로드
    public static ImgVO fileUpload(MultipartFile uploadFile){
        //원본 파일명 및 첨부된 파일명을 저장하기 위한 객체
        ImgVO imgVO =null;

        //input 태그에 파일을 선택했을 때만 첨부기능 실행
        if (!uploadFile.isEmpty()){
            //imgVO 객체 생성
            imgVO = new ImgVO();

            //업로드 될 경로
            String uploadPath="D:\\01-STUDY\\dev\\workspace\\workspace_spring\\Shop\\src\\main\\resources\\static\\upload\\";

            //내가 선택한 원본 파일명
            String originFileName = uploadFile.getOriginalFilename();

            //첨부될 파일명을 랜덤하게 생성
            String uuid= UUID.randomUUID().toString();

            String extension=originFileName.substring(originFileName.lastIndexOf("."));
            //System.out.println(uuid);

            //첨부될 파일명
            String attachedFileName=uuid+extension;

            //원본파일에서 확장자만 추출
            String a="abc.jpg";
            a.substring(3);

            String b="ab.cd.ef";
            //indexOf:찾는 문자의 index(위치)
            b.indexOf("c"); // b에서 c라는 문자는 몇번째에 있냐고 묻는거
            b.indexOf("."); // b에서 가장 먼저 만나는 . 찾기 : 2번째
            b.lastIndexOf(".");



            //첨부될 파일 생성
            File file=new File(uploadPath+attachedFileName);


            //첨부 기능 실행
            try {
                uploadFile.transferTo(file);

                //첨부된 파일 정보를 imgVO에 저장
                imgVO.setOriginFileName(originFileName);
                imgVO.setAttachedFileName(attachedFileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return imgVO;

    }

}
