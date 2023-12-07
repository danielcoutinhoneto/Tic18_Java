import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

enum TipoParte {
    PESSOA_FISICA,
    PESSOA_JURIDICA,
    ORGAO_PUBLICO
}

class Tribunal {
    private List<Processo> processos;
    private List<Setor> setores;

    public Tribunal(List<Processo> processos, List<Setor> setores) {
        this.processos = processos;
        this.setores = setores;
    }

    public void adicionarProcesso(Processo processo) {
        processos.add(processo);
    }

    public void tramitarProcesso(Processo processo) {
        for (Setor setor : setores) {
            if (setor.podeTramitar(processo)) {
                setor.tramitar(processo);
                break; 
            }
        }
    }
}

abstract class Parte {
    protected String nome;
    protected Advogado advogado;

    public Parte(String nome, Advogado advogado) {
        this.nome = nome;
        this.advogado = advogado;
    }

    public String getNome() {
        return nome;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public abstract TipoParte getTipo();
}

class PessoaFisica extends Parte {
    private String cpf;
    private String dataNascimento;

    public PessoaFisica(String nome, String cpf, String dataNascimento, Advogado advogado) {
        super(nome, advogado);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public TipoParte getTipo() {
        return TipoParte.PESSOA_FISICA;
    }
}

class PessoaJuridica extends Parte {
    private String cnpj;

    public PessoaJuridica(String nome, String cnpj, Advogado advogado) {
        super(nome, advogado);
        this.cnpj = cnpj;
    }

    @Override
    public TipoParte getTipo() {
        return TipoParte.PESSOA_JURIDICA;
    }
}

class OrgaoPublico extends PessoaJuridica {
    private String orgaoFiscalizador;

    public OrgaoPublico(String nome, String cnpj, String orgaoFiscalizador, Advogado advogado) {
        super(nome, cnpj, advogado);
        this.orgaoFiscalizador = orgaoFiscalizador;
    }

    @Override
    public TipoParte getTipo() {
        return TipoParte.ORGAO_PUBLICO;
    }
}

class Advogado {
    private String nome;

    public Advogado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Juiz {
    private String nome;

    public Juiz(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

abstract class Setor {
    public abstract boolean podeTramitar(Processo processo);
    public abstract void tramitar(Processo processo);
}

class Secretaria extends Setor {
    @Override
    public boolean podeTramitar(Processo processo) {
        return true;
    }

    @Override
    public void tramitar(Processo processo) {
        // Implementação dos métodos para específica a tramitação na secretaria
    }
}

class Distribuicao extends Setor {
    @Override
    public boolean podeTramitar(Processo processo) {
        return processo.temJuizesSorteados();
    }

    @Override
    public void tramitar(Processo processo) {
        // Implementação dos métodos para específica a tramitação na distribuição
    }
}

class GabineteJuiz extends Setor {
    private String tipoJuiz;

    public GabineteJuiz(String tipoJuiz) {
        this.tipoJuiz = tipoJuiz;
    }

    @Override
    public boolean podeTramitar(Processo processo) {
        return processo.estaNosJuizes(tipoJuiz);
    }

    @Override
    public void tramitar(Processo processo) {
        // Implementação dos métodos para específica a tramitação no gabinete do juiz
    }
}

class Plenario extends Setor {
    @Override
    public boolean podeTramitar(Processo processo) {
        return processo.foiDebatidoNoPlenario();
    }

    @Override
    public void tramitar(Processo processo) {
        // Implementação dos métodos para específica a tramitação no plenário
    }
}

class GabineteProlator extends Setor {
    @Override
    public boolean podeTramitar(Processo processo) {
        return processo.foiDeclaradaVencedora();
    }

    @Override
    public void tramitar(Processo processo) {
        // Implementação dos métodos para específica a tramitação no gabinete do prolator
    }
}

class Execucao extends Setor {
    @Override
    public boolean podeTramitar(Processo processo) {
        return processo.temSentenca();
    }

    @Override
    public void tramitar(Processo processo) {
        // Implementação dos métodos para específica a tramitação na execução
    }
}

class Arquivamento extends Setor {
    @Override
    public boolean podeTramitar(Processo processo) {
        return true;
    }

    @Override
    public void tramitar(Processo processo) {
        // Implementação dos métodos para específica a tramitação no arquivamento
    }
}

// Classe para representar um Processo
class Processo {
    private boolean julgado;
    private boolean sentencaDefinida;
    private boolean aceitoRecurso;

    private boolean apresentouSentencaInicial;
    private boolean apresentouSentencaAlternativa;
    private boolean debatidoNoPlenario;
    private boolean declaradaVencedora;

    private List<Juiz> juizes;
    private List<Advogado> advogados;

    public Processo(List<Juiz> juizes, List<Advogado> advogados) {
        this.juizes = juizes;
        this.advogados = advogados;
    }

    public boolean temSentenca() {
        return sentencaDefinida;
    }

    public boolean foiJulgado() {
        return julgado;
    }

    public boolean aceitoRecurso() {
        return aceitoRecurso;
    }

    public boolean temJuizesSorteados() {
        // Implementação da lógica para verificar se há juízes sorteados
        return false;
    }

    public void apresentarSentenca(String tipoJuiz) {
        // Implementação dos métodos para apresentar a sentença
    }

    public boolean foiDebatidoNoPlenario() {
        // Implementação dos métodos para específica/verificar se foi debatido no plenário
        return false;
    }

    public void prolatarSentenca() {
        // Implementação dos métodos que específica para prolatar a sentença
    }

    public boolean foiDeclaradaVencedora() {
        // Implementação dos métodos que específica para verificar se foi declarada vencedora
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exemplo de utilização
        List<Juiz> juizes = new ArrayList<>();
        juizes.add(new Juiz("Juiz1"));
        juizes.add(new Juiz("Juiz2"));

        List<Advogado> advogados = new ArrayList<>();
        advogados.add(new Advogado("Advogado1"));
        advogados.add(new Advogado("Advogado2"));

        Tribunal tribunal = new Tribunal(new ArrayList<>(), new ArrayList<>());
        Processo processo = new Processo(juizes, advogados);
        tribunal.adicionarProcesso(processo);

        // Lógica para entrada do usuário aqui
        // Por exemplo, solicitar informações sobre a Parte, Advogado, etc.
        // Utilize scanner.nextLine(), scanner.nextInt(), etc.

        tribunal.tramitarProcesso(processo);
    }
}
