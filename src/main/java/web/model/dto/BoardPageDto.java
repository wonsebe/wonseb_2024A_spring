package web.model.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class BoardPageDto {
    private int page;  //1. 현재 페이지
    //dto 사용한 이유 :
    // 검색 , 카테고리 별 다양한 매개변수가 필요하므로 집합

    //(지역/매개 ) 변수와 필드 차이점 : 초기값의 차이

    private int totalBoardSize; //2.전체 게시물 수
    private  int totalPage; //3.전체 페이지수
    private List<BoardDto > data; //4. 조회된 게시물 정보 목록/리스트
    private  int startBtn ; //5.페이지당  시작버튼 번호
    private int endBtn; //6.페이지당 끝버튼 번호
    private  int bcno; // 7. 현재 카테고리 번호



}
