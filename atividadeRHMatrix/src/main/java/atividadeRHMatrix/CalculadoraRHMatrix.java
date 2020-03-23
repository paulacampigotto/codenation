package atividadeRHMatrix;

import java.util.Scanner;


public class CalculadoraRHMatrix implements Calculadora {

    @Override
    public double calculaImposto(Funcionario funcionario) {
        if (funcionario.getSalario() <= 1045) return funcionario.getSalario() * .075;
        else if (funcionario.getSalario() <= 2089.6) return funcionario.getSalario() * .09;
        else if (funcionario.getSalario() <= 3134.4) return funcionario.getSalario() * .12;
        else return funcionario.getSalario() * 0.14;
    }

    @Override
    public double calculaImposto(Funcionario funcionario, double descontoINSS) {
        double baseCalculo = funcionario.getSalario() - descontoINSS;
        if (baseCalculo <= 1903.98) return 0;
        else if (baseCalculo <= 2826.65) return baseCalculo * .075;
        else if (baseCalculo <= 3751.05 ) return baseCalculo * .15;
        else if (baseCalculo <= 4664.68  ) return baseCalculo * .225;
        else return baseCalculo * .275;
        
        
    }

    @Override
    public double calculaSalarioLiquido(Funcionario funcionario) {
        double descontoINSS = calculaImposto(funcionario);
        double descontoIRRF = calculaImposto(funcionario, descontoINSS);
        return funcionario.getSalario() - descontoINSS - descontoIRRF;
    }
    
    public static void main(String[] args){
        
        
        String nome = "Gisele";
        double salario = 15000.00;
        
        Funcionario funcionario = new Funcionario(nome, salario);
        CalculadoraRHMatrix calculadora = new CalculadoraRHMatrix();
        
        System.out.println("### Dados de " + funcionario.getNome() + " ###\n");
        System.out.println("Salario bruto: R$ " + String.format("%.2f", funcionario.getSalario()));
        System.out.println("Desconto INSS: R$ " + String.format("%.2f", calculadora.calculaImposto(funcionario)));
        System.out.println("Desconto IRRF: R$ " + String.format("%.2f", calculadora.calculaImposto(funcionario, calculadora.calculaImposto(funcionario))));
        System.out.println("Salario liquido: R$ " + String.format("%.2f", calculadora.calculaSalarioLiquido(funcionario)));
    }
    
}


