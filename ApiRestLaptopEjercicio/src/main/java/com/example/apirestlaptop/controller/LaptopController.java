package com.example.apirestlaptop.controller;

import com.example.apirestlaptop.entities.Laptop;
import com.example.apirestlaptop.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {


    //variables
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    LaptopRepository laptopRepository;

    //constructor
    public LaptopController(LaptopRepository laptopRepository) {
        //guardar el repositorio
        this.laptopRepository = laptopRepository;

    }
    //getter y setter

    //metodos
    ///generar datos de prueva
    public void datosPrueba(){
        laptopRepository.save(new Laptop("HP","S17", LocalDate.of(2000,2,14),true));
        laptopRepository.save(new Laptop("ASUS","A5.3", LocalDate.of(2000,2,14),true));
    }

    //CRUD

    /**
     * muestra todas las laptop
     * @return
     */
    @GetMapping("/api/laptops")//http para hacer la coneccion
    @ApiOperation("muestra todas las laptop de la base de datos")//texto para el swagger
    public ResponseEntity<List<Laptop>> findAll(){//ResponseEntity usa los mensajes http
        return ResponseEntity.ok(laptopRepository.findAll());
    }

    /**
     * Buscar una Laptop que conincida con la Id que recive
     * @param id
     * @return
     */
    @GetMapping("/api/laptops/{id}")
    @ApiOperation("muestra una laptop dada su id")
    public ResponseEntity<Laptop> findOneById(@ApiParam("Clave primaria Long") @PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if(laptopOpt.isPresent()){//verifica si existe, usando Optional para evitar errores de null
            return ResponseEntity.ok(laptopOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Guardar laptop que llega por post
     * @param laptop
     * @return
     */
    @PostMapping("/api/laptops")
    @ApiOperation("crea una laptop, la id se crea automaticamente")
    public ResponseEntity<Laptop> create(@ApiParam("Json con todos los valores sin la id") @RequestBody Laptop laptop){
        if(laptop.getId()!=null){//
            log.warn("error al crear, existe el parametro id");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(laptopRepository.save(laptop));
    }

    /**
     * actualiza un registro que coincida con la id dada
     * @param laptop
     * @return
     */
    @PutMapping("/api/laptops")
    @ApiOperation("actualiza los valores de una laptop, la id es obligatoria")
    public ResponseEntity<Laptop> update(@ApiParam("Json con todos los valores") @RequestBody Laptop laptop){
        if(laptop.getId()==null){
            log.warn("no se pudo actualizar porque no existe una id");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(laptopRepository.save(laptop));
    }

    /**
     * elimina un archibo segun la id que se recibe
     * @param id
     * @return
     */
    @DeleteMapping("api/laptops/{id}")
    @ApiOperation("elimina una laptop dada la id")
    public ResponseEntity<String> deleteOneById(@ApiParam("Clave primaria Long") @PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            log.warn("no se pudo eliminar porque la laptop no existe");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);

        log.info("Documento con id: "+id+" eliminado con exito");
        return ResponseEntity.noContent().build();
    }

    /**
     * elimina todos los archivos de la base de datos
     * @return
     */
    @DeleteMapping("api/laptops")
    //@ApiIgnore
    public ResponseEntity<String> deleteAll(){
        log.info("REST Todas las laptop fueron eliminadas");
        laptopRepository.deleteAll();
        return null;
    }

}
