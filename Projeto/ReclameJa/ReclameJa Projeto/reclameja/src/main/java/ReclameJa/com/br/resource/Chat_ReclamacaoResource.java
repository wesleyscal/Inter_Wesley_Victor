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

import ReclameJa.com.br.entity.Chat_Reclamacao;

@Path("/chat_reclamacao")
public class Chat_ReclamacaoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chat_Reclamacao> getAll(){
        return Chat_Reclamacao.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Chat_Reclamacao getById(@PathParam("id") Long id){
        return Chat_Reclamacao.findById(id);
    }

    @GET
    @Path("/busca")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chat_Reclamacao> buscarPorNome(@QueryParam("id_reclamacao") Integer id_Reclamacao){
        if(id_Reclamacao == null){
            throw new BadRequestException("Enviar o parâmetro id_reclamacao");
        }
        return Chat_Reclamacao.findById_reclamacao(id_Reclamacao);
    }
    
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Chat_Reclamacao chat_reclamacao){
        if(chat_reclamacao.Mensagem.equals("")){
            throw new BadRequestException("Mensagem é obrigatório");
        }
        if(chat_reclamacao.Data_Envio.toString().equals("")){
            throw new BadRequestException("Data de Envio é obrigatório");
        }
        if(chat_reclamacao.id_Reclamacao == 0){
            throw new BadRequestException("id_Reclamacao é obrigatório");
        }
        if(chat_reclamacao.Responsavel.equals("")){
            throw new BadRequestException("Responsavel é obrigatório");
        }

        chat_reclamacao.persist();
        return Response.status(Status.CREATED).entity(chat_reclamacao).build();
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Chat_Reclamacao chat_reclamacao){
        Chat_Reclamacao entity = Chat_Reclamacao.findById(id);
        if (entity == null){
            throw new NotFoundException();
        }

        entity.Mensagem = chat_reclamacao.Mensagem;
        entity.Data_Envio = chat_reclamacao.Data_Envio;
        entity.id_Reclamacao = chat_reclamacao.id_Reclamacao;
        entity.Responsavel = chat_reclamacao.Responsavel;    

        entity.persist();

        return Response.status(Status.OK).entity(entity).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        Chat_Reclamacao entity = Chat_Reclamacao.findById(id);
        if (entity == null){
            throw new NotFoundException();
        }
        entity.delete();

        return Response.status(Status.OK).build();
    }
}
