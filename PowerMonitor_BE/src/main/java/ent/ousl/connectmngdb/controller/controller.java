package ent.ousl.connectmngdb.controller;

import ent.ousl.connectmngdb.DataDTO.DataDTO;
import ent.ousl.connectmngdb.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/value")
@RestController
public class controller {

    private final UserService userService;
    public controller(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/data")
    public ResponseEntity<String> receiveData(@RequestBody DataDTO dataDTO){
        try {
            // Data processing logic (you can customize this as needed)
            userService.SaveData(dataDTO);
            return ResponseEntity.ok("Data received successfully!");
        } catch (Exception e) {
            // Handle any exceptions that might occur during data processing
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing data.");
        }
    }

}

