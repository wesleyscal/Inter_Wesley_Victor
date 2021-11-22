package ReclameJa.com.br.entity;

import java.util.List;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Empresa extends PanacheEntity{
    
    public String Nome_Fantasia;
    public String Razao_Social;
    public String CNPJ;
    public String Telefone;
    public String Pais;
    public String Estado;
    public String Cidade;

    public static List<Empresa> findByName(String Nome_Fantasia){
        return find("Nome_Fantasia", Nome_Fantasia).list();
    }
}
