package appadega;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Vinho implements Comparable<Vinho>{

    private String tipo;

    private String marca;

    private int volume;

    private LocalDate dtprod;

    private double valor;

    public String getTipo() {
        return tipo;
    }

    public Vinho() {
        this("","",0,LocalDate.now(),0);
    }

    public Vinho(String tipo, String marca, int volume, LocalDate dtprod, double valor) {
        setTipo(tipo); 
        this.marca = marca;
        setVolume(volume);
        setDtprod(dtprod);
        setValor(valor);
    }

    public Vinho(String tipo, String marca, int volume) {
        this(tipo,marca,volume,LocalDate.now(),0);
    }
    
    final public void setTipo(String tipo) {
        if (tipo.equalsIgnoreCase("Tinto") || tipo.equalsIgnoreCase("Branco"))
           this.tipo = tipo.toUpperCase();
    }

    public String getMarca() {
        return marca;
    }

    final public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getVolume() {
        return volume;
    }

    final public void setVolume(int volume) {
        if (volume >=0)
           this.volume = volume;
    }

    public LocalDate getDtprod() {
        return dtprod;
    }

    final public void setDtprod(LocalDate dtprod) {
        if (!dtprod.isAfter(LocalDate.now()))
            this.dtprod = dtprod;
    }

    public double getValor() {
        return valor;
    }

    final public void setValor(double valor) {
        if (valor>=0)
           this.valor = valor;
    }

    public long getTempoDias() {
        return dtprod.until(LocalDate.now(),ChronoUnit.DAYS);
    }
    public String toString()
    {
        return marca+" "+tipo+" "+volume;
    }

    @Override
    public int compareTo(Vinho outro) {
        return volume-outro.getVolume();
    }
    // >= 1 se o this for maior que outro
    // 0 se forem iguais
    // <= 1 se outro for maior que this

}
