import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoardServiceImpl {
    private List<BoardVO> boardList;

    public BoardServiceImpl(){
        boardList = new ArrayList<>();
        boardList.add(new BoardVO(1,"첫번째 글"));
        boardList.add(new BoardVO(2,"두번째 글"));
        boardList.add(new BoardVO(3,"세번째 글"));
    }

    public Optional<List<BoardVO>> getBoardList(){
        return Optional.ofNullable(boardList);
    }

    public Optional<BoardVO> getBoardDetail(int index){
        return Optional.ofNullable(boardList.get(index));
    }

}

class BoardVO{
    private int boardNum;
    private String title;

    public BoardVO(int boardNum, String title) {
        this.boardNum = boardNum;
        this.title = title;
    }

    public int getBoardNum() {
        return boardNum;
    }

    public void setBoardNum(int boardNum) {
        this.boardNum = boardNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
