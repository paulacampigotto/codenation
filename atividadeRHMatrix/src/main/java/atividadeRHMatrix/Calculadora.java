package atividadeRHMatrix;



public interface Calculadora {
    
    double calculaImposto(Funcionario funcionario);

    double calculaImposto(Funcionario funcionario, double descontoINSS);
    
    double calculaSalarioLiquido(Funcionario funcionario);    
    
}
