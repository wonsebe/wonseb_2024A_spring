package web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class FileServise {
    
    
        //[1] 파일 업로드 : 매개변수로 파일의 바이트가 저장된 MultipartFile 인터페이스
        //업로드 된 파일명 반환
    public  String  fileUpload(MultipartFile multipartFile){

        System.out.println(multipartFile.getContentType());  //파일의 확장자
        System.out.println(multipartFile.getName());   //속성명
        System.out.println(multipartFile.getSize());    //첨부파일의 바이트 사이즈/용량
        System.out.println(multipartFile.isEmpty());    //첨부파일이 없으면 true, 있으면 false

        //1. 첨부파일의 실제 파일 이름 추출
            // + 클라이언트(유저)들이 서로 다른 파일내용의 같은 파일명으로 업로드 했을 때 식별이 불가능.
            //해결방안 : 1. UUIO( 고유성 보장하는 ID 규약) 2. 조합식별 설게(주로 업로드날짜/시간 와 파일명 조합)
        String uuid = UUID.randomUUID().toString(); //난수의 UUID 생성 , 임의의 UUID 규약에 따른 문자열 생성
        System.out.println("uuid = " + uuid);
        String fileName = multipartFile.getOriginalFilename();
            //UUID +파일명 합치기, uuid ㅗ아 파일명 구분하는 문자조합 , 파일명의 _(언더바)가 존재하면 안된다.
            //추후에 _(언더바)기준으로 분리하면[0] UUID , [1] 순수파일명
            //문자열.replaceAll("기존문자" , " 새로운문자") : 만약에 문자열내 기존문자가 존재하면 새로운문자로 치환해서 변환
        fileName=uuid +"_"+fileName.replaceAll("_","-"); //파일명에 '_'

        fileName = uuid +"_" +fileName;
        System.out.println("fileName = " + fileName);
        //2 저장할 경로 만들기
        String  uploadPath = "C:\\Users\\tj-bu-703-06\\Desktop\\wonseb_2024A_spring\\src\\main\\resources\\static\\upload\\";
        //3. 저장할 경로와 파일 명 합치기
        String filePath=uploadPath + fileName;
        ///4. 해당 경로로 설정한 file 객체 , transferTo ( file 객체)
        File file=new File(filePath);
        //5.
        //multipartFile.transferTo(file 객체) : file 객체내 설정한 해당 경로로 파일 복사/저장/이동
            //일반예외 무조건 발생
        try {
            multipartFile.transferTo(file);
        }catch (Exception e){
            System.out.println("e = " + e); return null;
        }
        return fileName;
        
    }
}
