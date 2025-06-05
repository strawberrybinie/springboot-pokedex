package mx.unam.aragon.ico.is.pokemonproyecto.services;

import mx.unam.aragon.ico.is.pokemonproyecto.entities.Pokemon;
import mx.unam.aragon.ico.is.pokemonproyecto.repositories.PokemonRepository;
import mx.unam.aragon.ico.is.pokemonproyecto.services.interfaces.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public Pokemon crear(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @Override
    public Iterable<Pokemon> listarTodos() {
        return pokemonRepository.findAll();
    }

    @Override
    public Optional<Pokemon> buscarPorId(Integer clave) {
        return pokemonRepository.findById(clave);
    }

    @Override
    public Pokemon actualizar(Integer clave, Pokemon pokemon) {
        Optional<Pokemon> pokemonActual = pokemonRepository.findById(clave);
        if (pokemonActual.isPresent()) {
            Pokemon tmp = pokemonActual.get();
            tmp.setClave(pokemon.getClave());
            tmp.setNombre(pokemon.getNombre());
            tmp.setTipo(pokemon.getTipo());
            tmp.setRegion(pokemon.getRegion());
            tmp.setFoto(pokemon.getFoto());
            return pokemonRepository.save(tmp);
        }else{
            return null;
        }
    }

    @Override
    public void eliminar(Integer clave) {
        pokemonRepository.deleteById(clave);
    }
}
