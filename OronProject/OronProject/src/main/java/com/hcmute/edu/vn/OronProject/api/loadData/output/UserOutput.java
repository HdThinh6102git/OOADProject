package com.hcmute.edu.vn.OronProject.api.loadData.output;

import com.hcmute.edu.vn.OronProject.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserOutput {
    private List<UserDTO> listResult = new ArrayList();

    public List<UserDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<UserDTO> listResult) {
        this.listResult = listResult;
    }
}
