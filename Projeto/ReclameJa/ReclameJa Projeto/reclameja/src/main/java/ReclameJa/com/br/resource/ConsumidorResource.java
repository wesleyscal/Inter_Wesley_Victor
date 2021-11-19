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
    
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Consumidor consumidor){
        if(consumidor.Nome_Completo.equals("")){
            throw new BadRequestException("Nome Completo é obrigatório");
        }
        if(consumidor.CPF.equals("")){
            throw new BadRequestException("CPF é obrigatório");
        }
        if(consumidor.Genero.equals("")){
            throw new BadRequestException("Genero é obrigatório");
        }
        if(consumidor.Data_Nacimento.toString().equals("")){
            throw new BadRequestException("Data de Nacimento é obrigatório");
        }
        if(consumidor.Celular.equals("")){
            throw new BadRequestException("Celular é obrigatório");
        }
        if(consumidor.CEP.equals("")){
            throw new BadRequestException("CEP é obrigatório");
        }
        if(consumidor.Estado.equals("")){
            throw new BadRequestException("Estado é obrigatório");
        }
        if(consumidor.Cidade.equals("")){
            throw new BadRequestException("Cidade é obrigatório");
        }
        if(consumidor.Senha.equals("")){
            throw new BadRequestException("Senha é obrigatório");
        }

        consumidor.persist();
        return Response.status(Status.CREATED).entity(consumidor).build();
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Consumidor consumidor){
        Consumidor entity = Consumidor.findById(id);
        if (entity == null){
            throw new NotFoundException();
        }

        entity.Nome_Completo = consumidor.Nome_Completo;
        entity.CPF = consumidor.CPF;
        entity.Genero = consumidor.Genero;
        entity.Data_Nacimento = consumidor.Data_Nacimento;
        entity.Celular = consumidor.Celular;
        entity.CEP = consumidor.CEP;
        entity.Estado = consumidor.Estado;
        entity.Cidade = consumidor.Cidade;     
        entity.Senha = consumidor.Senha;   

        entity.persist();

        return Response.status(Status.OK).entity(entity).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        Consumidor entity = Consumidor.findById(id);
        if (entity == null){
            throw new NotFoundException();
        }
        entity.delete();

        return Response.status(Status.OK).build();
    }

}
