package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import web.model.dao.BoardDao;
import web.model.dao.MemberDao;
import web.model.dto.BoardDto;
import web.model.dto.MemberDto;

import java.util.ArrayList;
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
    public ArrayList<BoardDto> all(){
        return  boardDao.all();

    }
    //글 상세 호출
    public ArrayList<BoardDto> detailcall(){
        return  boardDao.detailcall();

    }

    //글 수정

    //글 삭제

    //카테고리 호출
    public ArrayList<BoardDto> category(){
        System.out.println("BoardService.category");
        return boardDao.category();
    }
}
