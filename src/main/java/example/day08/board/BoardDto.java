package example.day08.board;

public class BoardDto {
    private int bno;
    private String bdate;
    private String  btitle;
    private  String bcontent;
    private  int bview;
    private String bpw;

    public BoardDto(){}

    public BoardDto(int bno, String bdate, String btitle, String bcontent, int bview, String bpw) {
        this.bno = bno;
        this.bdate = bdate;
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bview = bview;
        this.bpw = bpw;
    }


    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public int getBview() {
        return bview;
    }

    public void setBview(int bview) {
        this.bview = bview;
    }

    public String getBpw() {
        return bpw;
    }

    public void setBpw(String bpw) {
        this.bpw = bpw;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", bdate='" + bdate + '\'' +
                ", btitle='" + btitle + '\'' +
                ", bcontent='" + bcontent + '\'' +
                ", bview=" + bview +
                ", bpw='" + bpw + '\'' +
                '}';
    }
}
