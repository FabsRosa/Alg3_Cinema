package ufmt_alg3.cinema;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Essa classe implementa a abstração de sessões em um cinema.
 * 
 */
public class Sessao implements Serializable{
    private Integer id;
    private static Integer proximoId = 1;
    // private Sala tipoDeSessao;
    private String nomeSessao;
    private Date dataHora;
    
    /*
     * Esse método constutor inicializa todos os atributos da instância da 
     * classe sessão criada. Ele, ao ser finalizado, terá uma assinatura como 
     * segue: Sessao, String, String. 
     * 
     * O atributo estático proximoId é inicializado dentro da classe Lista,
     * através do método cadastrar().
     * @param nomeSessao, dataHora.
     * @throws ParseException
     */
    public Sessao (/*Sala tipoDeSessao,*/ String nomeSessao, String dataHora) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.id = proximoId;
        Sessao.proximoId++;
        this.nomeSessao = nomeSessao;
        this.dataHora = dateFormat.parse(dataHora);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public static void setProximoId(Integer proximoId){
        Sessao.proximoId = proximoId;
    }
    
    public static Integer getProximoId() {
        return Sessao.proximoId;
    }
/*
    Getters e setters do tipo de sala.
    
    public Sala getTipoDeSessao() {
        return tipoDeSessao;
    }

    public void setTipoDeSessao(Sala tipoDeSessao) {
        this.tipoDeSessao = tipoDeSessao;
    }
*/
    public String getNomeSessao() {
        return nomeSessao;
    }

    public void setNomeSessao(String nomeSessao) {
        this.nomeSessao = nomeSessao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date horario) {
        this.dataHora = horario;
    }
    
    
    /**
     * Esse método lista todos os atributos de uma instância da classe Sessao no 
     * console.
     */
    public void listarSessao() {
        System.out.println("ID: " + getId());
        // System.out.println("Tipo: " + getTipoDeSessao());
        System.out.println("Nome: " + getNomeSessao());
        System.out.println("Data/hora: " + getDataHora());
    }
}
