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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ReclameJa.com.br.entity.Reclamacao;

@Path("/reclamacao")
public class ReclamacaoResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reclamacao> getAll(){
        return Reclamacao.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reclamacao getById(@PathParam("id") Long id){
        return Reclamacao.findById(id);
    }
    
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Reclamacao reclamacao){
        if(reclamacao.Status.equals("")){
            throw new BadRequestException("Status é obrigatório");
        }
        if(reclamacao.Titulo.equals("")){
            throw new BadRequestException("Titulo é obrigatório");
        }
        if(reclamacao.Descricao.equals("")){
            throw new BadRequestException("Descricao é obrigatório");
        }
        if(reclamacao.Data_Abertura.toString().equals("")){
            throw new BadRequestException("Data de Abertura é obrigatório");
        }
        if(reclamacao.id_Consumidor == 0){
            throw new BadRequestException("Consumidor é obrigatório");
        }
        if(reclamacao.id_Empresa == 0){
            throw new BadRequestException("Empresa é obrigatório");
        }

        reclamacao.persist();
        return Response.status(Status.CREATED).entity(reclamacao).build();
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Reclamacao reclamacao){
        Reclamacao entity = Reclamacao.findById(id);
        if (entity == null){
            throw new NotFoundException();
        }

        entity.Status = reclamacao.Status;
        entity.Titulo = reclamacao.Titulo;
        entity.Descricao = reclamacao.Descricao;
        entity.Data_Abertura = reclamacao.Data_Abertura;
        entity.Data_Finalizacao = reclamacao.Data_Finalizacao;
        entity.id_Consumidor = reclamacao.id_Consumidor;
        entity.id_Empresa = reclamacao.id_Empresa;        

        entity.persist();

        return Response.status(Status.OK).entity(entity).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        Reclamacao entity = Reclamacao.findById(id);
        if (entity == null){
            throw new NotFoundException();
        }
        entity.delete();

        return Response.status(Status.OK).build();
    }

}
