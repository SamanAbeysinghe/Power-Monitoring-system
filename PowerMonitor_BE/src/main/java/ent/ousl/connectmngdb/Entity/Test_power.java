package ent.ousl.connectmngdb.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test_power")
public class Test_power {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Rec_ID;
    @Column
    private int V1;
    @Column
    private int C1;
    @Column
    private int power;
    }


