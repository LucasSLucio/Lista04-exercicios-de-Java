/*Nome: Lucas da Silva Lucio
 Disciplina: Desenvolvimento de aplicações
 TURMA: TCTG241CNTDEV
 */ 
import java.util.ArrayList;
import java.util.Scanner;

// Questão 1. FUPQ crie uma classe PESSOA para armazenar os dados de um cadastro de pessoas
// com os atributos: ID pessoa, Nome Pessoa, CPF da pessoa, Data nascimento da pessoa.

class Pessoa {
    private String id;
    private String nome;
    private String cpf;
    private String dataNascimento;

    public Pessoa(String id, String nome, String cpf, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

// Questão2. FUPQ crie uma classe ALUNO para armazenar os dados do aluno e sua respectiva nota.
class Aluno {
    private String nome;
    private double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getConceito() {
        if (nota >= 90) return "A";
        if (nota >= 80) return "B";
        if (nota >= 70) return "C";
        if (nota >= 60) return "D";
        return "E";
    }
}

// Questão 3. FUPQ crie uma classe FUNCIONÁRIO para armazenar os dados do empregado.
class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double aplicarReajuste(double percentual) {
        salario += salario * (percentual / 100);
        return salario;
    }
}


public class Cadastro {
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();
    private static ArrayList<Aluno> alunos = new ArrayList<>();
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("Escolha uma opção: 1) Cadastro de Pessoa 2) Cadastro de Aluno 3) Cadastro de Funcionário 4) Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    gerenciarPessoas();
                    break;
                case 2:
                    gerenciarAlunos();
                    break;
                case 3:
                    gerenciarFuncionarios();
                    break;
            }
        } while (opcao != 4);
        scanner.close();
    }

    private static void gerenciarPessoas() {
        int opcao;
        do {
            System.out.println("1) Inserir 2) Alterar 3) Consultar 4) Excluir 5) Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Data de Nascimento: ");
                    String dataNascimento = scanner.nextLine();
                    pessoas.add(new Pessoa(id, nome, cpf, dataNascimento));
                    break;
                case 2:
                    System.out.print("ID da pessoa a ser alterada: ");
                    String idAlterar = scanner.nextLine();
                    for (Pessoa pessoa : pessoas) {
                        if (pessoa.getId().equals(idAlterar)) {
                            System.out.print("Novo nome: ");
                            pessoa.setNome(scanner.nextLine());
                            System.out.print("Novo CPF: ");
                            pessoa.setCpf(scanner.nextLine());
                            System.out.print("Nova data de nascimento: ");
                            pessoa.setDataNascimento(scanner.nextLine());
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("ID da pessoa a ser consultada: ");
                    String idConsultar = scanner.nextLine();
                    for (Pessoa pessoa : pessoas) {
                        if (pessoa.getId().equals(idConsultar)) {
                            System.out.println("ID: " + pessoa.getId() + ", Nome: " + pessoa.getNome() + ", CPF: " + pessoa.getCpf() + ", Data de Nascimento: " + pessoa.getDataNascimento());
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("ID da pessoa a ser excluída: ");
                    String idExcluir = scanner.nextLine();
                    pessoas.removeIf(pessoa -> pessoa.getId().equals(idExcluir));
                    break;
            }
        } while (opcao != 5);
    }

    private static void gerenciarAlunos() {
        int opcao;
        do {
            System.out.println("1) Inserir 2) Alterar 3) Consultar 4) Excluir 5) Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Nota: ");
                    double nota = scanner.nextDouble();
                    alunos.add(new Aluno(nome, nota));
                    break;
                case 2:
                    System.out.print("Nome do aluno a ser alterado: ");
                    String nomeAlterar = scanner.nextLine();
                    for (Aluno aluno : alunos) {
                        if (aluno.getNome().equals(nomeAlterar)) {
                            System.out.print("Nova nota: ");
                            aluno.setNota(scanner.nextDouble());
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nome do aluno a ser consultado: ");
                    String nomeConsultar = scanner.nextLine();
                    for (Aluno aluno : alunos) {
                        if (aluno.getNome().equals(nomeConsultar)) {
                            System.out.println("Nome: " + aluno.getNome() + ", Nota: " + aluno.getNota() + ", Conceito: " + aluno.getConceito());
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Nome do aluno a ser excluído: ");
                    String nomeExcluir = scanner.nextLine();
                    alunos.removeIf(aluno -> aluno.getNome().equals(nomeExcluir));
                    break;
            }
        } while (opcao != 5);
    }

    private static void gerenciarFuncionarios() {
        int opcao;
        do {
            System.out.println("1) Inserir 2) Alterar 3) Consultar 4) Excluir 5) Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();
                    System.out.print("Salário: ");
                    double salario = scanner.nextDouble();
                    funcionarios.add(new Funcionario(nome, cargo, salario));
                    break;
                case 2:
                    S
