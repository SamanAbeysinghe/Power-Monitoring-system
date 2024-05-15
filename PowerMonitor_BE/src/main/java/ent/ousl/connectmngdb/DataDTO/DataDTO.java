package ent.ousl.connectmngdb.DataDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataDTO {
    private int voltage;
    private int current;
    private int power;


}
