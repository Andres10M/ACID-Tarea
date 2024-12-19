package com.example.reservas_backend_kotlin.service

import com.example.reservas_backend_kotlin.entity.Boleto
import com.example.reservas_backend_kotlin.repository.BoletoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoletoService(private val boletoRepository: BoletoRepository) {

    @Transactional
    fun reservarBoletos(id: Long, cantidad: Int): Boleto {
        val boleto = boletoRepository.findById(id).orElseThrow { Exception("Boleto no encontrado") }
        if (boleto.disponible < cantidad) {
            throw Exception("No hay suficientes boletos disponibles")
        }
        val nuevoDisponible = boleto.disponible - cantidad
        val boletoActualizado = boleto.copy(disponible = nuevoDisponible)
        return boletoRepository.save(boletoActualizado)
    }

    fun obtenerTodos(): List<Boleto> = boletoRepository.findAll()

    fun guardar(boleto: Boleto): Boleto = boletoRepository.save(boleto)
}
