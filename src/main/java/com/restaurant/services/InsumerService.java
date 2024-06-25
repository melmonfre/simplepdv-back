package com.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dtos.CreateInsumerDTO;
import com.restaurant.dtos.mapper.CreateInsumerMapper;
import com.restaurant.models.InsumersEntity;
import com.restaurant.repositories.InsumersRepository;

@Service
public class InsumerService {

        @Autowired
        private InsumersRepository insumersRepository;
        @Autowired
        private CreateInsumerMapper createInsumerMapper;

        public CreateInsumerDTO create(CreateInsumerDTO createInsumerDTO){
            
            try{

                InsumersEntity insumersEntity = this.createInsumerMapper.insumerDtoToInsumerEntity(createInsumerDTO);

                var insumerSaved = this.insumersRepository.save(insumersEntity);

                return this.createInsumerMapper.insumerEntityToInsumerDTO(insumerSaved);
                
            }catch(RuntimeException exception){
                throw new RuntimeException(exception);
            }
        }
}
