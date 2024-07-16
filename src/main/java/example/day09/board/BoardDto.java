package example.day09.board;

import lombok.*;

@NoArgsConstructor
@Builder
@ToString
@AllArgsConstructor
@Getter
@Setter

public class BoardDto {
    private int bno;
    private String bdate;
    private String  btitle;
    private  String bcontent;
    private  int bview;
    private String bpw;


}
