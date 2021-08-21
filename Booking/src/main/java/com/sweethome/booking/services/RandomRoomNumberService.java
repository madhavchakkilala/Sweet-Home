package com.sweethome.booking.services;


import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class RandomRoomNumberService {
    public String getRoomNumbers(Integer numberOfRooms){
        Random randomnNumberGenerator = new Random();
        String roomNumbers = "";
        for(int iterator = 0 ;iterator < numberOfRooms; iterator++){
            if(iterator == numberOfRooms-1) {
                roomNumbers = roomNumbers + (String.valueOf(randomnNumberGenerator.nextInt(100)));
            }
            else{
                roomNumbers = roomNumbers + (String.valueOf(randomnNumberGenerator.nextInt(100))) + ",";
            }
        }
        return roomNumbers;
    }
}
