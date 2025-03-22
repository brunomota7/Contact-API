package br.com.crud.model.user;

public record RegisterDTO(String email, String password, UserRole role) {
}
