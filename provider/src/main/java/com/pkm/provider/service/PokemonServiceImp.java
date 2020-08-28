package com.pkm.provider.service;


import com.pkm.provider.dao.PokemonDao;
import com.pkm.service.object.Pokemon;
import com.pkm.service.service.PokemonService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Service(version = "1.0.0" ,timeout = 2000,interfaceClass = PokemonService.class)
public class PokemonServiceImp implements PokemonService {
    @Autowired
    private PokemonDao pokemonDao;
    public Pokemon getPokemonById(int id){
        return pokemonDao.getPokemonById(id);
    }
    public List<Pokemon> getAllPokemon(){
        return pokemonDao.getAllPokemon();
    }
    public List<Pokemon> searchPokemon(String keyword){
        return pokemonDao.searchPokemon("%"+keyword+"%");
    }
    public Boolean addPokemon(Pokemon object){
        return pokemonDao.addPokemon(object);
    }
    public Boolean delPokemon(int id){
        return pokemonDao.delPokemon(id);
    }
    public Boolean upPokemon(Pokemon object){
        return pokemonDao.upPokemon(object);
    }
    public int getPokemonNum(){
        return pokemonDao.getPokemonNum();
    }
}
