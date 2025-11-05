package com.example.TaskManager.utility;

import java.util.UUID;

public class UUIDConvertor {

    public static UUID StringToUUIDConvertor(String id){
        if(id==null || !id.matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$")){
           throw new RuntimeException("Invalid UUID string format: "+ id);
        }

        UUID uuid = UUID.fromString(id);

        return uuid;
    }

}
