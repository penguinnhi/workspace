import java.util.List;
import java.util.Optional;

public class BoardController {
    private BoardServiceImpl boardService;

    public BoardController(){
        this.boardService=new BoardServiceImpl();
    }

    // 게시글 목록 데이터 조회
    public Optional<List<BoardVO>> boardList(){
        Optional<List<BoardVO>> optionalList=boardService.getBoardList();
//        optionalList.ifPresentOrElse(()->{},()=>{});

        return Optional.ofNullable(boardService.getBoardList().get());

    }


    // 게시글 상세 정보 조회
    public BoardVO boardDetail(){
        Optional<BoardVO> op=boardService.getBoardDetail(0);

        op.ifPresentOrElse( member->{
            System.out.println("게시글 제목 : " +member.getTitle());
        } ,()->{
            System.out.println("404 NOT FOUND");
        });
        return boardService.getBoardDetail(0).get();
    }

}
