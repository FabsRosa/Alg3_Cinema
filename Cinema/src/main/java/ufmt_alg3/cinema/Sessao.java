package ufmt_alg3.cinema;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Gabriel
 */
public class Sessao implements Serializable{
    private Integer id;
    private static Integer proximoId = 0;
    // private Sala tipoDeSessao;
    private String nomeSessao;
    private Date dataHora;
    
    public Sessao (/*Sala tipoDeSessao,*/ String nomeSessao,
            String dataHora) throws ParseException {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.id = proximoId;
        Sessao.proximoId++;
        //this.tipoDeSessao = tipoDeSessao;
        this.nomeSessao = nomeSessao;
        this.dataHora = dateFormat.parse(dataHora);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    
}
