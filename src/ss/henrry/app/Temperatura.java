package ss.henrry.app;

public class Temperatura {

    private String tipoTemperatura;
    private double valor;
    private String simbolo;

    public Temperatura(Double valor, String tipoTemperatura) {
        this.tipoTemperatura = tipoTemperatura;
        this.valor = valor;
    }

    public Temperatura(String tipoTemperatura, String simbolo) {
        this.tipoTemperatura = tipoTemperatura;
        this.simbolo = simbolo;
    }

    public String getTipoTemperatura() {
        return tipoTemperatura;
    }

    public void setTipoTemperatura(String tipoTemperatura) {
        this.tipoTemperatura = tipoTemperatura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getInformacion() {

        return (this.getValor() == 1.0) ? String.format("%.0f", this.getValor()) + " Grado " + this.getTipoTemperatura()
                : (this.getValor() % 1 == 0) ? String.format("%.0f", this.getValor()) + " Grados " + this.getTipoTemperatura()
                : String.format("%.2f", this.getValor()) + " Grados " + this.getTipoTemperatura();
    }

    public Double getValorEnKelvin() {
        Double valorEnKelvin = null;
        switch (this.simbolo) {
            case "°C"://De Celcius a Kelvin
                valorEnKelvin = this.valor + 273.15;
                break;
            case "°F"://De Fahrenheit a Kelvin
                valorEnKelvin = ((this.valor + 459.67) * 5) / 9;
                break;
            case "°R"://De Rankine a Kelvin
                valorEnKelvin = (this.valor * 5) / 9;
                break;
            case "°Ré"://De Réaumur a Kelvin  
                valorEnKelvin = 1.25 * this.valor + 273.15;
                break;
            default:
                valorEnKelvin = this.valor * 1.0;
        }
        return valorEnKelvin;
    }

    public void convertirDeKelvin(Double Kelvin) {

        switch (this.simbolo) {
            case "°C": //De Kelvin a Celcius
                this.setValor(Kelvin - 273.15);
                break;
            case "°F": //De Kelvin a Fahrenheit
                this.setValor(1.8 * (Kelvin - 273.15) + 32);
                break;
            case "°R"://De Kelvin a Rankine 
                this.setValor(1.8 * Kelvin); //R = 9/5K
                break;
            case "°Ré"://De Kelvin a Réaumur 
                this.setValor((Kelvin - 273.15) * 0.8);
                break;
            default:
                this.setValor(Kelvin * 1.0);
                ;
        }

    }

}
