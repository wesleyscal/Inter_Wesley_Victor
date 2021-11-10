package ReclameJa.com.br.entity;

import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Consumidor extends PanacheEntity{    

    public String Nome_Completo;
    public String CPF;
    public String Genero;
    public Date Data_Nacimento;
    public String Celular;
    public String CEP;
    public String Estado;
    public String Cidade;

    public static List<Consumidor> findByName(String Nome_Completo){
        return find("Nome_Completo", Nome_Completo).list();
    }

}
