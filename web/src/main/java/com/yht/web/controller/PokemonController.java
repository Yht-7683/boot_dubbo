package com.yht.web.controller;


import com.pkm.service.object.Pokemon;
import com.pkm.service.service.PokemonService;
import com.yht.web.domain.Res;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PokemonController {
    @Reference(version = "1.0.0")
    private PokemonService pokemonService;
    //获取当前所有种类的精灵
    @RequestMapping("/public/getAllPokemon")
    public Res show(){
        List<Pokemon> list=pokemonService.getAllPokemon();
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //删除精灵
    @RequestMapping("/public/delPokemon")
    public Res del(int id){
        if(pokemonService.delPokemon(id)){
            return new Res(Res.SUCCESS,"删除成功！",null);
        }else {
            return new Res(Res.ERROR,"删除失败！",null);
        }
    }
    //添加精灵
    @RequestMapping("/public/addPokemon")
    public Res add(Pokemon pokemon){
        if(pokemonService.getPokemonById(pokemon.getId())!=null){
            return new Res(Res.FAILURE,"宝可梦已经存在！",null);
        }
        if(pokemonService.addPokemon(pokemon)){
            return new Res(Res.SUCCESS,"添加成功！",null);
        }else {
            return new Res(Res.ERROR,"添加失败！",null);
        }
    }
    //更新精灵信息
    @RequestMapping("/public/upPokemon/")
    public Res up(Pokemon pokemon){
        if(pokemonService.upPokemon(pokemon)){
            return new Res(Res.SUCCESS,"修改成功！",null);
        }
        else {
            return new Res(Res.ERROR,"修改失败！",null);
        }
    }
    //@RequestMapping("/public/upU")
//public Res up(User user,int userId){
//    String Do ="修改用户信息";
//    System.out.println(user);
//    if(userService.upUser(user)){
//        Do=Do+"成功";
//        //logService.createLog(Do, useId);
//        return new Res(Res.SUCCESS,"修改成功！",null);
//    }
//    else {
//        Do=Do+"失败";
//        //logService.createLog(Do, useId);
//        return new Res(Res.ERROR,"修改失败！",null);
//    }
//}
    //模糊查找精灵
    @RequestMapping("/public/searchPokemon")
    public Res select(@RequestParam("searchParam") String keyword){
        List<Pokemon> list=pokemonService.searchPokemon(keyword);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
}
