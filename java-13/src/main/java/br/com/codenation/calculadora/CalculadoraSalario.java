package br.com.codenation.calculadora;

public class CalculadoraSalario {

    public long calcularSalarioLiquido(double salarioBase) {
        if(salarioBase < 1039) return (long) 0.0;
        double descontoINSS = calcularINSS(salarioBase);
        double descontoIRRF = calcularIRRF(salarioBase - descontoINSS);
        return Math.round(salarioBase - descontoINSS - descontoIRRF);
    }

    private double calcularINSS(double salarioBase) {
        if(salarioBase <= 1500) return salarioBase * .08;
        else if(salarioBase <= 4000) return salarioBase * .09;
        return salarioBase * 0.11;
    }

    private double calcularIRRF(double salarioBase) {
        if(salarioBase <= 3000) return 0.0;
        else if(salarioBase <= 6000) return salarioBase * .075;
        return salarioBase * .15;
    }
}
