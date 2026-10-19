
package com.latamairlines.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_reserva")
public class Reserva {

    // IDENTIFICADOR AUTOMATICO
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "reserva_generator"
    )
    @SequenceGenerator(
        name = "reserva_generator",
        sequenceName = "tb_reserva_seq",
        allocationSize = 1
    )
    @Column(name = "pr_id", nullable = false)
    private Integer id;

    // ATRIBUTOS
    @Column(name = "pr_origen", nullable = false)
    private String origen;

    @Column(name = "pr_destino", nullable = false)
    private String destino;

    @Column(name = "pr_numeroPasajeros", nullable = false)
    private Integer numeroPasajeros;

    // CONSTRUCTORES
    public Reserva() {
    }

    public Reserva(String origen, String destino, Integer numeroPasajeros) {
        this.origen = origen;
        this.destino = destino;
        this.numeroPasajeros = numeroPasajeros;
    }

    // GETTERS
    public Integer getId() {
        return id;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public Integer getNumeroPasajeros() {
        return numeroPasajeros;
    }

    // SETTERS
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setNumeroPasajeros(Integer numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }
}
