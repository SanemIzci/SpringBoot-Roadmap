package com.example.starter.services.impl;

import com.example.starter.dto.DtoHome;
import com.example.starter.dto.DtoRoom;
import com.example.starter.entities.Home;
import com.example.starter.entities.Room;
import com.example.starter.repository.HomeRepository;
import com.example.starter.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public DtoHome findHomeById(Long id) {
        DtoHome dtoHome=new DtoHome();
        Optional<Home>optional=homeRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        Home DbHome=optional.get();
        List<Room> DbRooms=optional.get().getRooms();
        BeanUtils.copyProperties(DbHome,dtoHome);
        if(DbRooms!=null && !DbRooms.isEmpty()){
            for(Room room:DbRooms){
                DtoRoom dtoRoom=new DtoRoom();
                BeanUtils.copyProperties(room,dtoRoom);
                dtoHome.getRooms().add(dtoRoom);
            }
        }
        return dtoHome;


    }
}
