package mx.unam.aragon.ico.is.pokemonproyecto.repositories;

import mx.unam.aragon.ico.is.pokemonproyecto.entities.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    public Pokemon findPokemonByClave (Integer clave);
    public Pokemon deleteByClave(Integer clave);
}
