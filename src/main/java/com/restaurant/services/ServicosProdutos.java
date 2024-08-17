package com.restaurant.services;

import com.restaurant.dtos.CriarProdutoDTO;
import com.restaurant.dtos.DetalheInsumo;
import com.restaurant.dtos.DetalheProduto;
import com.restaurant.dtos.mapper.CriarProtudoMapper;
import com.restaurant.models.InsumosEntity;
import com.restaurant.models.ProdutosEntity;
import com.restaurant.repositories.InsumosRepository;
import com.restaurant.repositories.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ServicosProdutos {
    @Autowired
    private ProdutosRepository produtosRepository;
    @Autowired
    private CriarProtudoMapper criarProtudoMapper;
    @Autowired
    private InsumosRepository insumosRepository;

    public CriarProdutoDTO criar(CriarProdutoDTO criarProdutoDTO) {
        try {
            ProdutosEntity produtosEntity = this.criarProtudoMapper.produtoDtoParaProdutoEntity(criarProdutoDTO);

            if(produtosEntity.getIngredientes().isEmpty()){
                throw new RuntimeException("Nenhum ingrediente selecionado");
            }

            List<InsumosEntity> insumosEntityList = new ArrayList<>();

            criarProdutoDTO.ingredientes().forEach(insumo -> {
                
                insumo = insumosRepository.findById(insumo.getId()).orElseThrow(() -> new RuntimeException("Insumo não encontrado"));
                insumosEntityList.add(insumo);
            });

            produtosEntity.setIngredientes(insumosEntityList);

            return this.criarProtudoMapper.produtoEntityParaProdutoDTO(produtosRepository.save(produtosEntity));

        } catch (RuntimeException exception) {
            throw new RuntimeException(exception);
        }
    }
    public DetalheProduto buscarProdutoPorId(Long id){
        ProdutosEntity produto = produtosRepository.findById(id).orElseThrow(() ->new RuntimeException("produto não encontrado"));
        DetalheProduto detalheProduto = new DetalheProduto(produto);
        return detalheProduto;
    }
    public List<DetalheProduto> retornaListaDeProdutos(){
        List<ProdutosEntity> produtos = produtosRepository.findAll();
        List<DetalheProduto> detalheProdutos = produtos.stream().map(p -> new DetalheProduto(p)).collect(Collectors.toList());
        return detalheProdutos;
    }
    public void deletaProduto(Long id) {produtosRepository.deleteById(id);}

    public DetalheProduto alteraProduto(Long id, DetalheProduto dto){
        ProdutosEntity produto = produtosRepository.findById(id).orElseThrow(() -> new RuntimeException("produto não encontrado"));
        produto.alteraProduto(dto);
        produtosRepository.save(produto);
        return new DetalheProduto(produto);

    }
}
