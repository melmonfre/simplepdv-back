package com.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dtos.CriarInsumoDTO;
import com.restaurant.dtos.mapper.CriarInsumoMapper;
import com.restaurant.models.InsumosEntity;
import com.restaurant.repositories.InsumosRepository;

@Service
public class ServicosInsumos {

        @Autowired
        private InsumosRepository insumosRepository;
        @Autowired
        private CriarInsumoMapper criarInsumoMapper;

        public CriarInsumoDTO criar(CriarInsumoDTO criarInsumoDTO){
            
            try{

                InsumosEntity insumosEntity = this.criarInsumoMapper.insumoDtoParaInsumoEntity(criarInsumoDTO);

                var InsumoSalvo = this.insumosRepository.save(insumosEntity);

                return this.criarInsumoMapper.insumoEntityParaInsumoDTO(InsumoSalvo);
                
            }catch(RuntimeException exception){
                throw new RuntimeException(exception);
            }
        }
}
