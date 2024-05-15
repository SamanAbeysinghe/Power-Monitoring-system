package ent.ousl.connectmngdb.repo;
import ent.ousl.connectmngdb.Entity.Test_power;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Test_power,Long> {


}
