package com.green.Board.vo;

//페이징 처리를 위한 모든 정보를 갖는 클래스


import lombok.Data;

@Data
public class PageVO {

    //전체 데이터 수
    private int totalDataCnt;

    //한 페이지에 보여지는 데이터 수(게시글 수)
    //쿼리의 LIMIT랑 같아야함
    private int displayDataCnt;

    //전체 페이지 수
    private int totalPageCnt;


    //현재 페이지
    private int nowPage;

    //한 화면에 보여지는 페이지 수
    private int displayPageCnt;

    //화면에 보이는 시작페이지
    private int beginPage;

    //화면에 보이는 마지막 페이지
    private int endPage;

    //이전 버튼 유무
    private boolean prev;

    //다음 버튼 유무
    private boolean next;

    private int offset;

    //생성자 초기값 설정
    //매개변수 : DB에서 조회한 전체 데이터 수
    public PageVO(int totalDataCnt){
        this.nowPage=1; //내가 보고 있는 페이지?
        this.displayPageCnt=5; // 한페이지에 5개씩 보여주겠다
        displayDataCnt=5;
        this.totalDataCnt=totalDataCnt;

    }


    //모든 페이지 정보를 세팅하는 메서드
    public void setPageInfo(){
        // 총 게시글 수, 현재 페이지,한 화면에 보이는 페이지 수
        //올림(현재 페이지/한 화면에 보이는 페이지 수)*한 화면에 보이는 페이지 수
        //화면에 보이는 마지막 페이지 번호
        endPage=(int)Math.ceil(nowPage/(double)displayPageCnt)*displayPageCnt;

        // 전체 데이터 수 : 31
        // 한 번에 5개씩 페이지를 보여줄거임
        //한 페이지에 데이터를 5개씩 보여줄거

        // 1 2 3 4 5 6 7 : 페이지 개수

        // 1 2 3 4 5 next
        // prev 6 7

        beginPage=endPage-displayPageCnt+1;

        totalPageCnt=(int)Math.ceil(totalDataCnt/(double)displayDataCnt)+1;

//        if(endPage>totalPageCnt){
//            endPage=totalPageCnt;
//        }

        endPage=endPage>totalPageCnt?totalPageCnt:endPage;
        //엔드페이지가 토탈페이지 수보다 많으면
        // 엔드페이지는 토탈페이지 수이다

        //true 화면에 보임, false 화면에 안 보임
        //이전 버튼 유무
        prev= beginPage!=1;
        //다음 버튼 유무
        next= endPage!=totalDataCnt;


        offset=displayDataCnt*(nowPage-1);



    }


}
