package com.pacheco.ibeth.tablay.infraestructure.controller;


import com.pacheco.ibeth.tablay.aplication.service.UsuarioService;
import com.pacheco.ibeth.tablay.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users") // Define el endpoint base
public class UserController {

    private final UsuarioService usuarioService;

    @Autowired
    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoint para crear un usuario
    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        Usuario createdUser = usuarioService.createUsuario(usuario);
        return ResponseEntity.ok(createdUser);
    }

    // Endpoint para obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers() {
        List<Usuario> users = usuarioService.getAllUsuarios();
        return new ResponseEntity<>(users,HttpStatus.OK);        
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
		Usuario user = usuarioService.getUsuarioById(id)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Endpoint para actualizar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody Usuario usuario) {
       Usuario updatedUser = usuarioService.updateUsuario(id, usuario);
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);	
    }

    // Endpoint para eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    	
    	boolean isDelete=usuarioService.deleteUsuario(id);
		if (isDelete) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }
}