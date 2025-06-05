package mx.unam.aragon.ico.is.pokemonproyecto.controller;

import jakarta.validation.Valid;
import mx.unam.aragon.ico.is.pokemonproyecto.entities.Pokemon;
import mx.unam.aragon.ico.is.pokemonproyecto.services.interfaces.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Pokemon>> getPokemons() {
        return ResponseEntity.ok().body(pokemonService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable Integer id) {
        return ResponseEntity.ok(pokemonService.buscarPorId(id).orElse(null));
    }

    @PostMapping("/")
    public ResponseEntity<Pokemon> createPokemon(@Valid @RequestBody Pokemon pokemon) throws URISyntaxException {
        return ResponseEntity.created(new URI("http://localhost:8080")).body(pokemonService.crear(pokemon));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable Integer id,@RequestBody Pokemon pokemon) {
        return ResponseEntity.ok(pokemonService.actualizar(id,pokemon));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pokemon> patchPokemon(@PathVariable Integer id,@RequestBody Pokemon pokemon) {
        Optional<Pokemon> tmp = pokemonService.buscarPorId(id);
        if (tmp.isPresent()) {
            Pokemon actual = tmp.get();
            if(pokemon.getNombre() != null) actual.setNombre(pokemon.getNombre());
            if(pokemon.getTipo() != null) actual.setTipo(pokemon.getTipo());
            if(pokemon.getRegion() != null) actual.setRegion(pokemon.getRegion());
            if(pokemon.getFoto() != null) actual.setFoto(pokemon.getFoto());
            return ResponseEntity.ok(pokemonService.actualizar(id,actual));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable Integer id) {
        pokemonService.eliminar(id);
    }

}
