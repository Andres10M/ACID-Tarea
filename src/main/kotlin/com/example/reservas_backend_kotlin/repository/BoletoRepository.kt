package com.example.reservas_backend_kotlin.repository

import com.example.reservas_backend_kotlin.entity.Boleto
import org.springframework.data.jpa.repository.JpaRepository

interface BoletoRepository : JpaRepository<Boleto, Long>
