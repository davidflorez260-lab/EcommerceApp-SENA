package com.tunombre.ecommerce.data.repository

import com.tunombre.ecommerce.data.model.Product
import com.tunombre.ecommerce.data.model.User

object EcommerceRepository {

    // Usuario de prueba (simula base de datos)
    private val users = mutableListOf(
        User(1, "Admin", "admin@ecommerce.com", "123456")
    )

    // Lista de productos de ejemplo
    private val products = listOf(
        Product(1, "Audífonos Bluetooth", "Audífonos inalámbricos con cancelación de ruido", 149900.0),
        Product(2, "Smartwatch Pro", "Reloj inteligente con monitor de ritmo cardíaco", 299900.0),
        Product(3, "Teclado Mecánico", "Teclado mecánico RGB para gaming", 189900.0),
        Product(4, "Mouse Gamer", "Mouse ergonómico con 6 botones programables", 89900.0),
        Product(5, "Monitor 27\" 144Hz", "Monitor gamer Full HD de 27 pulgadas", 799900.0),
        Product(6, "Silla Gamer", "Silla ergonómica reclinable", 549900.0)
    )

    // Login
    fun login(email: String, password: String): Boolean {
        return users.any { it.email == email && it.password == password }
    }

    // Registro
    fun register(name: String, email: String, password: String): Boolean {
        if (users.any { it.email == email }) {
            return false // El correo ya existe
        }
        val newUser = User(
            id = users.size + 1,
            name = name,
            email = email,
            password = password
        )
        users.add(newUser)
        return true
    }

    // Obtener todos los productos
    fun getProducts(): List<Product> {
        return products
    }
}
