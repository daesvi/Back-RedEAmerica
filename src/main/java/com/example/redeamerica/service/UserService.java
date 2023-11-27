package com.example.redeamerica.service;

import com.example.redeamerica.dto.UserProfileUpdateDTO;
import com.example.redeamerica.model.UserEntity;
import com.example.redeamerica.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.redeamerica.model.UserEntity;
import com.example.redeamerica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Optional;

// UserService.java
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserEntity obtenerUsuarioPorEmail(String email) {
        // Buscar al usuario por correo electrónico en la base de datos
        Optional<UserEntity> userOptional = userRepository.findByEmail(email);


        // Verificar si el usuario existe y devolverlo, de lo contrario, devolver null
        return userOptional.orElse(null);
    }
    @Transactional
    public UserEntity actualizarPerfilUsuario(String email, UserProfileUpdateDTO updateDTO) {
        // Obtener el usuario por correo electrónico
        UserEntity user = obtenerUsuarioPorEmail(email);

        // Actualizar los campos del perfil según los datos proporcionados en el DTO
        if (updateDTO.getFullName() != null) {
            user.setFullName(updateDTO.getFullName());
        }
        if (updateDTO.getAddress() != null) {
            user.setAddress(updateDTO.getAddress());
        }
        // Guardar la entidad actualizada en la base de datos
        return userRepository.save(user);
    }
}


