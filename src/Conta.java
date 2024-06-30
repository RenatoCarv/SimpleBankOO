public abstract class Conta {
    int agencia;
    int numero;
    Cliente titular;
    double saldo;
    private static int total;

    public Conta (int agencia, int numero, Cliente titular) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;

        Conta.total++;
    }

    public void depositar (double valor) {
        this.saldo += valor;
    }

    public boolean sacar (double valor) {
        if (this.saldo > valor){
            this.saldo -= valor;
            return true;
        }else {
            return false;
        }
    }

    public abstract void gerarExtrato();

    public void transferir (double valor, Conta destino) {
        boolean saqueRealizado = this.sacar(valor);
        if(saqueRealizado){
            destino.depositar(valor);
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        if(agencia > 0) {
            this.agencia = agencia;
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public static int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", titular=" + titular +
                ", saldo=" + saldo +
                '}';
    }
}
