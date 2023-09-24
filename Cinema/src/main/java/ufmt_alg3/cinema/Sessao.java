package ufmt_alg3.cinema;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Gabriel
 */
public class Sessao {
    protected Integer id;
    protected Sala tipoDeSessao;
    protected String nomeSessao;
    protected Date dataHora;
    
    public Sessao (Integer id, Sala tipoDeSessao, String nomeSessao,
            String dataHora) throws ParseException {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.id = id;
        this.tipoDeSessao = tipoDeSessao;
        this.nomeSessao = nomeSessao;
        this.dataHora = dateFormat.parse(dataHora);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoDeSessao() {
        return tipoDeSessao;
    }

    public void setTipoDeSessao(String tipoDeSessao) {
        this.tipoDeSessao = tipoDeSessao;
    }

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
