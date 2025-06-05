package mx.unam.aragon.ico.is.pokemonproyecto.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "Pokedex") //Bautizamos a nuestra tabla
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private Integer clave; //clave de Pokedex

    @Column(name = "Nombre_Pokemon", nullable = false, length = 50)
    @NotBlank(message = "No debe contener espacios en blanco")
    @NotNull(message = "No debe ser nulo")
    private String nombre; //Nombre del pokemon

    @Column(name = "Region_Origen", nullable = false ,length = 50)
    private String region; //Region de origen

    @Column(name = "Tipo_Pokemon", nullable = false ,length = 50)
    @NotBlank(message = "No debe contener espacios en blanco")
    @NotNull(message = "No debe ser nulo")
    private String tipo; //Tipo de pokemon

    @Column(name = "URL_Foto", insertable = false ,columnDefinition = "VARCHAR(250) DEFAULT 'https://extensions.typo3.org/typo3temp/assets/tx_terfe2/images/placeholder_images_1.1.0.png'")
    private String foto; //Foto del pokemon o especifica en caso de no cargar una

    @Version
    private Integer version;

    public Pokemon() {
    }

    public Pokemon(Integer clave, String nombre, String region, String tipo, String foto) {
        this.clave = clave;
        this.nombre = nombre;
        this.region = region;
        this.tipo = tipo;
        this.foto = foto;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(clave, pokemon.clave) && Objects.equals(nombre, pokemon.nombre) && Objects.equals(region, pokemon.region) && Objects.equals(tipo, pokemon.tipo) && Objects.equals(foto, pokemon.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clave, nombre, region, tipo, foto);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "clave=" + clave +
                ", nombre='" + nombre + '\'' +
                ", region='" + region + '\'' +
                ", tipo='" + tipo + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
