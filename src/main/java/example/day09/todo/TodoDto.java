package example.day09.todo;

import lombok.*;

@NoArgsConstructor
@Builder
@ToString
@AllArgsConstructor
@Getter
@Setter
public class TodoDto {
    private int tno;
    private String tcontent;
    private int tstate;


}
