package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import web.model.dao.BoardDao;
import web.model.dao.MemberDao;
import web.model.dto.BoardDto;
import web.model.dto.BoardPageDto;
import web.model.dto.MemberDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    BoardDao boardDao;
    @Autowired
    MemberService memberService;
    @Autowired
    FileServise fileServise;


    // 2.
    public boolean bWrite( BoardDto boardDto) {
        // 글자 작성을 요청한 회원의 로그인회원번호 구하기
        // 1. 로그인 세션에서 값 호출
        Object object = memberService.mLoginCheck();
        if( object == null ) return  false; // 비로그인시 함수 강제종료/취소
        // 2. 세션내 회원번호 속성 호출
        MemberDto memberDto = (MemberDto)object;
        // 3. 속성 호출
        int loginNo = memberDto.getNo();
        // 4. BoardDto 담아주기
        boardDto.setNo( loginNo );

        // - 파일 업로드 처리
        if( boardDto.getUploadFile().isEmpty() ){ // - 업로드 된 파일이 존재  하지 않으면
        }else{ // 존재하면
            String uploadFileName= fileServise.fileUpload(boardDto.getUploadFile());
            // 1. 만약에 업로드가 실패 했으면  글쓰기 실패
            if( uploadFileName == null ) return false;
            // 2. BoardDto 에 업로드 된 파일명 담아주기
            boardDto.setBfile( uploadFileName );
        }
        // ---- DB 처리
        return boardDao.bWrite( boardDto );

    }


//
//    //글쓰기 내가 했는데 오류난거
//    public  boolean post(BoardDto boardDto){
//
//        Object object= memberService.mLoginCheck();
//        if (object ==null)return  false;
//        MemberDto memberDto = (MemberDto) object; //형변환
//        int loginNo= memberDto.getNo(); //멤버변수 번호를 가져와서 로그인된 번호에 대입
//        boardDto.setNo(loginNo); //로그인된 번호에 멤버 번호를 저장
//
////        //파일처리
//        MultipartFile multipartFile=boardDto.getUploadFile();
//        System.out.println("multipartFile = " + multipartFile);
////        //byte[] bytes=multipartFile.getBytes();
//
//        // 파일 업로드
//        String uploadFileName= fileServise.fileUpload(boardDto.getUploadFile());
//            //만약에 업로드가 실패 했으면 글쓰기 실패
//        if (uploadFileName==null)return false;
//            //boardDto 에 업로드 된 파일명 담아주기
//        boardDto.setBfile(uploadFileName);
//        //====DB 처리
//        return boardDao.post(boardDto); //다오에 넘겨줌
//
//
//    }
//    public boolean post(Map<String , String> map){
//
//        //-
//
//        MemberDto loginDto = memberService.mLoginCheck();
//        if( loginDto == null ) return false;
//        int loginNo = loginDto.getNo();
//        // 2. 로그인된 회원번호를 map 엔트리 추가
//        map.put( "no" , String.valueOf(loginNo) );
//
//        return boardDao.post(map);
//    }

    //글 전체 호출
    public BoardPageDto all(BoardPageDto pageDto){
        System.out.println("boardPageDto = " + pageDto);
        System.out.println("BoardService.all");
        //만약에 페이지 번호가 매개변수로 존재하지 않으면 1페이지로 설정
        if (pageDto.getPage() == 0){pageDto.setPage(1);}
        //1. 하나의 페이지당 표시할 게시물 수
        int pageBoardSize=2; //- 하나의 페이지당 5개씩 표기
        //2. 페이지당 게시물을 출력할 시작 레코드 번호
        int startRow = ( pageDto.getPage() -1)* pageBoardSize ;

        //4. 전체 게시물 수 : 조건 추가 : 카테고리번호 별 , 검색 조건
        int totalBoardSize = boardDao.getTotalBoardSize(pageDto.getBcno(), pageDto.getSearchKey() , pageDto.getSearchKeyword());


        //3. total :전체 페이지 수  구하기
            //총 페이지수 계산식: 전체 게시물수 / 페이지당게시물수 , 단  나머지가 존재하면 페이지수 1 더한다.
        int totalPage = totalBoardSize % pageBoardSize == 0?
                totalBoardSize /pageBoardSize : //전체게시물수 나누기 페이지당게시물수 의 몫을 전체 페이지수
                totalBoardSize /pageBoardSize +1; //나머지 게시물들을 출력할 페이지 1개 더해준다

        int btnSize=5; //페이지당 최대 버튼수를 5개씩 표기한다는 가정
        int starBtn; //페이지별 시작 버튼 번호 변수
            starBtn= ((pageDto.getPage()-1) / btnSize ) * btnSize +1;
        int endBtn; //페이지별 끝 버튼 번호 변수
            endBtn=starBtn + btnSize -1;
            //만일 끝 번호가 마지막페이지 보다 커질 수 없다.
            if (endBtn >= totalPage) endBtn = totalPage;

        //6.게시물 정보 조회 : 조건추가1) 페이징처리 , 조건추가2)
        List<BoardDto>data = boardDao.all(startRow , pageBoardSize, pageDto.getBcno(), pageDto.getSearchKey() , pageDto.getSearchKeyword());

        //반환 객체 구성
        BoardPageDto boardPageDto = BoardPageDto.builder()
                .page( pageDto.getPage() ) // 1. 현재 페이지 번호
                .totalBoardSize( totalBoardSize ) // 2. 전체 게시물수
                .totalPage( totalPage ) // 3. 전체 페이지수
                .data( data ) // 4. 조회된 게시물 정보 목록/리스트
                .startBtn(starBtn)
                .endBtn(endBtn)
                .build();
        return  boardPageDto;

    }
    //글 상세 호출
    public BoardDto detailcall(int bno){
        //조회수 증가 처리
        boardDao.viewIncrease(bno);
        return  boardDao.detailcall(bno);
    }

    //글 수정
    public boolean Bupdate(BoardDto boardDto) {
        System.out.println("BoardService.Bupdate");
        Object object = memberService.mLoginCheck();
        if( object == null ) return  false; // 비로그인시 함수 강제종료/취소
        // 2. 세션내 회원번호 속성 호출
        MemberDto memberDto = (MemberDto)object;
        // 3. 속성 호출
        int loginNo = memberDto.getNo();
        // 4. BoardDto 담아주기
        boardDto.setNo( loginNo );
        return boardDao.Bupdate(boardDto);

    }

    //글 삭제
//    public boolean Bdelete(BoardDto boardDto){
//        System.out.println("BoardService.Bdelete");
//        System.out.println("boardDto = " + boardDto);
//        Object object = memberService.mLoginCheck();
//        if( object == null ) return  false; // 비로그인시 함수 강제종료/취소
//        // 2. 세션내 회원번호 속성 호출
//        MemberDto memberDto = (MemberDto)object;
//        // 3. 속성 호출
//        int loginNo = memberDto.getNo();
//        // 4. BoardDto 담아주기
//        boardDto.setNo( loginNo );
//        return boardDao.Bdelete(boardDto);
//
//    }


    //카테고리 호출
    public ArrayList<BoardDto> category(){
        System.out.println("BoardService.category");
        return boardDao.category();
    }


}
