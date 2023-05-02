package com.hcmute.edu.vn.OronProject.api;

import com.hcmute.edu.vn.OronProject.dto.NewDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewAPI {

    @PostMapping(value = "/new")
    public NewDTO createNew(@RequestBody NewDTO model){
        return model;
    }
    @PutMapping(value = "/new")
    public NewDTO updateNew(@RequestBody NewDTO model){
        return model;
    }

    @DeleteMapping (value = "/new")
    public void deleteNew(@RequestBody long[] ids){

    }

}
