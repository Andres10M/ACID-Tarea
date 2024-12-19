package com.example.reservas_backend_kotlin.entity

import jakarta.persistence.*

@Entity
@Table(name = "boleto")
data class Boleto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "nombre_evento", nullable = false)
    val nombreEvento: String,
    @Column(nullable = false)
    val disponible: Int
)
