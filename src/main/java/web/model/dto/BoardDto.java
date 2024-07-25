package web.model.dto;


import jakarta.mail.Multipart;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder @Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private long bno ;          // 번호
    private String btitle;      // 제목
    private String bcontent;        // 내용
    //- HTML 의 INPUT type이 'file'일 때 바이트로 매핑 할 때 사용되는 인터페이스
    //업로드시 바이트를 저장하고 있는 필드
    private MultipartFile uploadFile;       // 첨부파일
    // DB 에 저장/출력할 업로드된 파일명 필드
    private String bfile;

    private long bview ;        // 조회수
    private String bdate;       // 작성일
    // 카테고리
    private long bcno ;         // 카테고리 번호
    private String bcname ;         // 카테고리 이름
    // 회원
    private long no ;          // 작성자 번호
    private String id;          // 작성자 아이디
}

