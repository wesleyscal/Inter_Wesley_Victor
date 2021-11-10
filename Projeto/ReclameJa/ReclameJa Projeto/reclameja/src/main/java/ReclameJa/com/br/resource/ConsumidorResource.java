package ReclameJa.com.br.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ReclameJa.com.br.entity.Consumidor;

@Path("/consumidor")
public class ConsumidorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consumidor> getAll(){
        return Consumidor.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Consumidor getById(@PathParam("id") Long id){
        return Consumidor.findById(id);
    }

    @GET
    @Path("/busca")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consumidor> buscarPorNome(@QueryParam("Nome_Completo") String Nome_Completo){
        if(Nome_Completo == null){
            throw new BadRequestException("Enviar o parâmetro nome");
        }
        return Consumidor.findByName(Nome_Completo);
    }
    
}
