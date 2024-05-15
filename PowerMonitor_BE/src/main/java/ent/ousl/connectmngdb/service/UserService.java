package ent.ousl.connectmngdb.service;
import ent.ousl.connectmngdb.DataDTO.DataDTO;
import ent.ousl.connectmngdb.Entity.Test_power;
import ent.ousl.connectmngdb.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    public void SaveData(DataDTO dataDTO){

        int V1 = dataDTO.getVoltage();
        int C1 = dataDTO.getCurrent();
        int power = dataDTO.getPower();

        Test_power test_power = new Test_power();
        test_power.setV1(V1);
        test_power.setC1(C1);
        test_power.setPower(power);

        System.out.println("DataEntity before saving: " + test_power);

        userRepo.save(test_power);
    }
}
