package ent.ousl.connectmngdb.controller;

import ent.ousl.connectmngdb.DataDTO.DataDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class dataController {
    private int voltage;
    private int current;
    private int power;

    @GetMapping("/api/data")
    public DataDTO getData() {

            voltage = getData().getVoltage();
            current = getData().getCurrent();
            power = getData().getPower();
        // Here you would fetch or generate the DataDTO object
        // and return it.
        return new DataDTO(voltage, current, power);
    }
}

