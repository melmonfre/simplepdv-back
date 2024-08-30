package com.restaurant.services;

import com.restaurant.dtos.DetalheInsumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dtos.CriarInsumoDTO;
import com.restaurant.dtos.mapper.CriarInsumoMapper;
import com.restaurant.models.InsumosEntity;
import com.restaurant.repositories.InsumosRepository;

import java.util.List;
import java.util.stream.Collectors;

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
        public DetalheInsumo buscaInsumoPorId (Long id){
            InsumosEntity insumo = insumosRepository.findById(id).orElseThrow(() -> new RuntimeException("Insumo não encontrado"));
            DetalheInsumo detalheInsumo = new DetalheInsumo(insumo);
            return detalheInsumo;

        }

        public List<DetalheInsumo> retornaListaDeInsumos(){
            List<InsumosEntity> insumos = insumosRepository.findAll();
            List<DetalheInsumo> detalheInsumos = insumos.stream().map(i -> new DetalheInsumo(i)).collect(Collectors.toList());
            return detalheInsumos;
        }
        public void deletaInsumo(Long id){insumosRepository.deleteById(id);}
    public DetalheInsumo alterarInsumo(Long id, DetalheInsumo dto){
            InsumosEntity insumos = insumosRepository.findById(id).orElseThrow(() -> new RuntimeException("Insumo não encontrado"));
            insumos.alteraInsumo(dto);
            insumosRepository.save(insumos);
            return new DetalheInsumo(insumos);
    }
}

