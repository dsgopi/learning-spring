package com.projects.app.users.view.mappers.test;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
 
    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class ); 
// 
//    @Mapping(source = "numberOfSeats", target = "seatCount")
//    CarDto carToCarDto(Car car); 2
}