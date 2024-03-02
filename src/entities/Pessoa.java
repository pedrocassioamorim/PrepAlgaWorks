package entities;

import entities.pagamentos.TipoPessoa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Pessoa {
    private String name;
    private String documento;
    private TipoPessoa tipo = TipoPessoa.FISICA;
    private LocalDateTime dataUltimaAtualizacao = LocalDateTime.now();
    private BigDecimal rendimentoAnual;


    public Pessoa(){}


    public Pessoa(String name, String documento) {
        this.name = name;
        this.documento = documento;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(documento, pessoa.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }

    @Override
    public String toString(){
        return name;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public BigDecimal getRendimentoAnual() {
        return rendimentoAnual;
    }

    public void setRendimentoAnual(BigDecimal rendimentoAnual) {
        this.rendimentoAnual = rendimentoAnual;
    }
}
