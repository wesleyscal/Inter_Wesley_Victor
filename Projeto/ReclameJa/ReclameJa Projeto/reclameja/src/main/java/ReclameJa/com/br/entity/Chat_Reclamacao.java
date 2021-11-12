package ReclameJa.com.br.entity;

import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Chat_Reclamacao extends PanacheEntity{

    public String Mensagem;
    public Date Data_Envio;
    public int id_Reclamacao;
    public String Responsavel;

    public static List<Chat_Reclamacao> findById_reclamacao(Integer id_Reclamacao){
        return find("id_Reclamacao", id_Reclamacao).list();
    }
}
