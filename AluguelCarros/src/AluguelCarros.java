import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

class Veiculo {
    private String placa;
    private String nome;
    private String tipo;
    private boolean disponivel;

    public Veiculo(String placa, String nome, String tipo) {
        this.placa = placa;
        this.nome = nome;
        this.tipo = tipo;
        this.disponivel = true;
    }

    // Getter para a placa do veículo
    public String getPlaca() {
        return placa;
    }

    // Setter para a placa do veículo
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // Getter para o nome do veículo
    public String getNome() {
        return nome;
    }

    // Setter para o nome do veículo
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para o tipo do veículo
    public String getTipo() {
        return tipo;
    }

    // Setter para o tipo do veículo
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getter para a disponibilidade do veículo
    public boolean isDisponivel() {
        return disponivel;
    }

    // Setter para a disponibilidade do veículo
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

class Cliente {
    private String documento;
    private String nome;
    private boolean pessoaJuridica;

    public Cliente(String documento, String nome, boolean pessoaJuridica) {
        this.documento = documento;
        this.nome = nome;
        this.pessoaJuridica = pessoaJuridica;
    }

    // Getter para o documento do cliente
    public String getDocumento() {
        return documento;
    }

    // Setter para o documento do cliente
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    // Getter para o nome do cliente
    public String getNome() {
        return nome;
    }

    // Setter para o nome do cliente
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para indicar se o cliente é pessoa jurídica
    public boolean isPessoaJuridica() {
        return pessoaJuridica;
    }

    // Setter para indicar se o cliente é pessoa jurídica
    public void setPessoaJuridica(boolean pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }
}

class Aluguel {
    private Veiculo veiculo;
    private Cliente cliente;
    private String dataAluguel;
    private String dataDevolucao;

    public Aluguel(Veiculo veiculo, Cliente cliente, String dataAluguel, String dataDevolucao) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
    }

    // Getter para o veículo alugado
    public Veiculo getVeiculo() {
        return veiculo;
    }

    // Setter para o veículo alugado
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    // Getter para o cliente que alugou o veículo
    public Cliente getCliente() {
        return cliente;
    }

    // Setter para o cliente que alugou o veículo
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Getter para a data de início do aluguel
    public String getDataAluguel() {
        return dataAluguel;
    }

    // Setter para a data de início do aluguel
    public void setDataAluguel(String dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    // Getter para a data de devolução do veículo
    public String getDataDevolucao() {
        return dataDevolucao;
    }

    // Setter para a data de devolução do veículo
    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}

public class AluguelCarros {
    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Aluguel> alugueis = new ArrayList<>();
    private Map<String, Aluguel> veiculoAlugado = new HashMap<>();

    public static void main(String[] args) {
        AluguelCarros gerenciador = new AluguelCarros();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar veículo");
            System.out.println("2. Alterar veículo");
            System.out.println("3. Buscar veículo por nome");
            System.out.println("4. Cadastrar cliente");
            System.out.println("5. Alterar cliente");
            System.out.println("6. Alugar veículo");
            System.out.println("7. Devolver veículo");
            System.out.println("8. Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    gerenciador.cadastrarVeiculo();
                    break;
                case 2:
                    gerenciador.alterarVeiculo();
                    break;
                case 3:
                    gerenciador.encontrarVeiculo();
                    break;
                case 4:
                    gerenciador.cadastrarCliente();
                    break;
                case 5:
                    gerenciador.alterarCliente();
                    break;
                case 6:
                    gerenciador.alugarVeiculo();
                    break;
                case 7:
                    gerenciador.devolverVeiculo();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 8);
    }

    public void cadastrarVeiculo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a placa do veículo:");
        String placa = scanner.nextLine();

        // Verifica se o veículo já está cadastrado
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Veículo com esta placa já está cadastrado.");
                return;
            }
        }

        System.out.println("Digite o nome do veículo:");
        String nome = scanner.nextLine();

        System.out.println("Digite o tipo do veículo (PEQUENO, MEDIO, SUV):");
        String tipo = scanner.nextLine().toUpperCase();

        // Valida se o tipo do veículo é válido

        while((!tipo.equals("PEQUENO") && !tipo.equals("MEDIO") && !tipo.equals("SUV"))){
            System.out.println("Tipo de veículo inválido.");
            System.out.println("Digite o tipo do veículo (PEQUENO, MEDIO, SUV):");
            tipo = scanner.nextLine().toUpperCase();
        }

        Veiculo veiculo = new Veiculo(placa, nome, tipo);
        veiculo.setPlaca(placa);
        veiculo.setNome(nome);
        veiculo.setTipo(tipo);
        veiculo.setDisponivel(true);

        veiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    public void alterarVeiculo() {
        Scanner scanner = new Scanner(System.in);


        String placa = "any";
        // Encontra o veículo pela placa
        Veiculo veiculoEncontrado = null;
        while(veiculoEncontrado == null){
            System.out.println("Digite a placa do veículo que deseja alterar:");
            placa = scanner.nextLine();
            for (Veiculo veiculo : veiculos) {
                if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                    veiculoEncontrado = veiculo;
                    break;
                }
            }
            if (veiculoEncontrado == null) {
                System.out.println("Veículo não encontrado.");
            }

        }

        System.out.println("Novo nome do veículo:");
        String novoNome = scanner.nextLine();

        System.out.println("Novo tipo do veículo (PEQUENO, MEDIO, SUV):");
        String novoTipo = scanner.nextLine().toUpperCase();

        // Valida se o tipo do veículo é válido

        while(!novoTipo.equals("PEQUENO") && !novoTipo.equals("MEDIO") && !novoTipo.equals("SUV")){
            System.out.println("Tipo de veículo inválido.");
            System.out.println("Digite o tipo do veículo (PEQUENO, MEDIO, SUV):");
            novoTipo = scanner.nextLine().toUpperCase();
        }

        // Atualiza os dados do veículo
        veiculoEncontrado.setNome(novoNome);
        veiculoEncontrado.setTipo(novoTipo);

        System.out.println("Veículo atualizado com sucesso!");
    }

    public void encontrarVeiculo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite parte do placa do veículo que deseja buscar:");
        String parteDaPlaca = "any";

        // Encontra o veículo pela placa
        Veiculo veiculoEncontrado = null;
        while(veiculoEncontrado == null){
            System.out.println("Digite parte do placa do veículo que deseja buscar:");
            parteDaPlaca = scanner.nextLine();

            veiculoEncontrado = buscarVeiculoPorPlaca(parteDaPlaca);
            if (veiculoEncontrado == null) {
                System.out.println("Veículo não encontrado.");
            }

        }

        System.out.println("Veículo encontrado:");
        System.out.println("Placa: " + veiculoEncontrado.getPlaca());
        System.out.println("Nome: " + veiculoEncontrado.getNome());
        System.out.println("Tipo: " + veiculoEncontrado.getTipo());
    }
    public Veiculo buscarVeiculoPorPlaca( String placa){
        Scanner scanner = new Scanner(System.in);

        Veiculo veiculoEncontrado = null;
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                veiculoEncontrado = veiculo;
                break;
            }
        }

        return veiculoEncontrado;
    }

    public void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();



        // Verifica se o cliente já está cadastrado
        boolean isClientUnique = false;
        String documento = "any";
        while(isClientUnique == false){
            isClientUnique = true;
            // é necessário colocar como true para ele só repetir se achaar um cliente com esse documento
            System.out.println("Digite o documento do cliente (CPF ou CNPJ):");
            documento = scanner.nextLine();

            for (Cliente clienteExistente : clientes) {
                if (clienteExistente.getDocumento().equalsIgnoreCase(documento)) {
                    System.out.println("Cliente com este documento já está cadastrado.");
                    isClientUnique = false;
                }
            }
        }

        System.out.println("O cliente é pessoa jurídica? (S/N):");
        String resposta = scanner.nextLine();
        boolean pessoaJuridica = resposta.equalsIgnoreCase("S");

        Cliente cliente = new Cliente(documento, nome, pessoaJuridica);

        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void alterarCliente() {
        Scanner scanner = new Scanner(System.in);

        // Encontra o cliente pelo documento
        String documento = "any";
        Cliente clienteEncontrado = null;


        while(clienteEncontrado == null){
            System.out.println("Digite o documento do cliente que deseja alterar:");
            documento = scanner.nextLine();
            for (Cliente cliente : clientes) {
                if (cliente.getDocumento().equalsIgnoreCase(documento)) {
                    clienteEncontrado = cliente;
                    break;
                }
            }
            if (clienteEncontrado == null) {
                System.out.println("Cliente não encontrado.");
            }

        }

        System.out.println("Novo nome do cliente:");
        String novoNome = scanner.nextLine();

        System.out.println("O cliente é pessoa jurídica? (S/N):");
        String resposta = scanner.nextLine();
        boolean novoPessoaJuridica = resposta.equalsIgnoreCase("S");

        // Atualiza os dados do cliente
        clienteEncontrado.setNome(novoNome);
        clienteEncontrado.setPessoaJuridica(novoPessoaJuridica);

        System.out.println("Cliente atualizado com sucesso!");
    }

    public Cliente encontrarClientePorDocumento(String documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equalsIgnoreCase(documento)) {
                return cliente;
            }
        }
        return null; // Retorna null se nenhum cliente for encontrado
    }

    public void alugarVeiculo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a placa do veículo que deseja alugar:");
        String placa = scanner.nextLine();

        // Encontra o veículo pelo número da placa
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);

        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        if (!veiculo.isDisponivel()) {
            System.out.println("Este veículo não está disponível para aluguel.");
            return;
        }

        System.out.println("Digite o documento do cliente:");
        String documento = scanner.nextLine();

        // Encontra o cliente pelo documento
        Cliente cliente = encontrarClientePorDocumento(documento);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("Digite a data de início do aluguel dd/MM/yyyy HH:mm:");
        String dataAluguel = scanner.nextLine();

        System.out.println("Digite a data da estimativa de devolução do veículo (dd/MM/yyyy HH:mm):");
        String dataDevolucao = scanner.nextLine();

        // Crie um objeto Aluguel com as informações fornecidas
        Aluguel aluguel = new Aluguel(veiculo, cliente, dataAluguel, dataDevolucao);

        // Marque o veículo como indisponível
        veiculo.setDisponivel(false);

        // Adicione o aluguel à lista de aluguéis
        alugueis.add(aluguel);

        System.out.println("Veículo alugado com sucesso!");
    }

    public void devolverVeiculo() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a placa do veículo que deseja devolver:");
        String placa = scanner.nextLine();

        // Encontra o veículo pelo número da placa
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);

        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        if (veiculo.isDisponivel()) {
            System.out.println("Este veículo não está alugado.");
            return;
        }

        Aluguel aluguelEncontrado = null;
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getVeiculo().equals(veiculo)) {
                aluguelEncontrado = aluguel;
                break;
            }
        }


        // Obtenha a data e hora atual
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date dataAtual = new Date();


        String dataDevolucaoStr = aluguelEncontrado.getDataAluguel();
        System.out.println("Data e hora do aluguel (dd/mm/yyyy HH:mm):" + aluguelEncontrado.getDataAluguel());

        try {
            Date dataDevolucao = sdf.parse(dataDevolucaoStr);

            // Calcule a diferença entre a data atual e a data do aluguel
            long diferencaMillis = dataAtual.getTime() - dataDevolucao.getTime();
            long horasDiferenca = diferencaMillis / (60 * 60 * 1000);

            // Calcule o valor a ser cobrado com base na diferença de horas
            double valorTotal = calcularValorAluguel(veiculo.getTipo(), horasDiferenca, aluguelEncontrado.getCliente().isPessoaJuridica() );

            // Marque o veículo como disponível
            veiculo.setDisponivel(true);

            System.out.println("Veículo devolvido com sucesso.");
            System.out.println("Valor a ser cobrado: R$ " + valorTotal);
        } catch (Exception e) {
            System.out.println("Formato de data e hora inválido. Use o formato dd/mm/yyyy HH:mm.");
        }
    }

    // Método para calcular o valor do aluguel com base no tipo de veículo e na quantidade de horas
    private double calcularValorAluguel(String tipoVeiculo, long horasDiferenca, boolean isPessoaJuridica) {
        double valorDiaria = 0.0;

        if (tipoVeiculo.equalsIgnoreCase("PEQUENO")) {
            valorDiaria = 100.0;
        } else if (tipoVeiculo.equalsIgnoreCase("MEDIO")) {
            valorDiaria = 150.0;
        } else if (tipoVeiculo.equalsIgnoreCase("SUV")) {
            valorDiaria = 200.0;
        }

        // Calcula o valor total com base nas diárias completas
        double valorTotal = Math.ceil(horasDiferenca / 24.0) * valorDiaria;

        // Aplica desconto conforme as regras de negócio (RN7)
        if (horasDiferenca > 120 && (isPessoaJuridica == false)) {
            valorTotal *= 0.95; // 5% de desconto para mais de 5 diárias
        } else if (horasDiferenca > 72 && (isPessoaJuridica == true)) {
            valorTotal *= 0.9; // 10% de desconto para mais de 3 diárias
        }

        return valorTotal;
    }
}
