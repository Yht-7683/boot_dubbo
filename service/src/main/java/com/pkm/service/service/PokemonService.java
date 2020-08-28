package com.pkm.service.service;


import com.pkm.service.object.Pokemon;


import java.util.List;


public interface PokemonService {

    Pokemon getPokemonById(int id);
    List<Pokemon> getAllPokemon();
    List<Pokemon> searchPokemon(String keyword);
    Boolean addPokemon(Pokemon object);
    Boolean delPokemon(int id);
    Boolean upPokemon(Pokemon object);
    int getPokemonNum();
}
