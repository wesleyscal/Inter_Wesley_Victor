package ReclameJa.com.br.entity;

import java.sql.Date;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Reclamacao extends PanacheEntity{

    public String Status;
    public String Titulo;
    public String Descricao;
    public Date Data_Abertura;
    public Date Data_Finalizacao;
    public Integer nota;
    public int id_Consumidor;
    public int id_Empresa;

}
