package mx.unam.aragon.ico.is.pokemonproyecto.services.interfaces;

import mx.unam.aragon.ico.is.pokemonproyecto.entities.Pokemon;

import java.util.Optional;

public interface PokemonService {
    public abstract Pokemon crear(Pokemon pokemon);
    public abstract Iterable<Pokemon> listarTodos();
    public abstract Optional<Pokemon> buscarPorId(Integer clave);
    public abstract Pokemon actualizar(Integer clave, Pokemon pokemon);
    public abstract void eliminar(Integer clave);
}
