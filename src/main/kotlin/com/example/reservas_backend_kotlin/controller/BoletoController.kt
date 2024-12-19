package com.example.reservas_backend_kotlin.controller

import com.example.reservas_backend_kotlin.entity.Boleto
import com.example.reservas_backend_kotlin.service.BoletoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/boletos")
class BoletoController(private val boletoService: BoletoService) {

    @GetMapping
    fun obtenerBoletos(): List<Boleto> = boletoService.obtenerTodos()

    @PostMapping
    fun guardarBoleto(@RequestBody boleto: Boleto): Boleto = boletoService.guardar(boleto)

    @PatchMapping("/{id}/reservar")
    fun reservarBoletos(
        @PathVariable id: Long,
        @RequestParam cantidad: Int
    ): Boleto = boletoService.reservarBoletos(id, cantidad)
}
