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

import ReclameJa.com.br.entity.Empresa;

@Path("/empresa")
public class EmpresaResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> getAll(){
        return Empresa.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Empresa getById(@PathParam("id") Long id){
        return Empresa.findById(id);
    }

    @GET
    @Path("/busca")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> buscarPorNome(@QueryParam("Nome_Fantasia") String Nome_Fantasia){
        if(Nome_Fantasia == null){
            throw new BadRequestException("Enviar o parâmetro Nome_Fantasia");
        }
        return Empresa.findByName(Nome_Fantasia);
    }
    
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Empresa empresa){
        if(empresa.Nome_Fantasia.equals("")){
            throw new BadRequestException("Nome fantasia é obrigatório");
        }
        if(empresa.Razao_Social.equals("")){
            throw new BadRequestException("Razao Social é obrigatório");
        }
        if(empresa.CNPJ.equals("")){
            throw new BadRequestException("Genero é obrigatório");
        }
        if(empresa.Telefone.equals("")){
            throw new BadRequestException("CNPJ é obrigatório");
        }
        if(empresa.Pais.equals("")){
            throw new BadRequestException("Pais é obrigatório");
        }
        if(empresa.Estado.equals("")){
            throw new BadRequestException("Estado é obrigatório");
        }
        if(empresa.Cidade.equals("")){
            throw new BadRequestException("Cidade é obrigatório");
        }

        empresa.persist();
        return Response.status(Status.CREATED).entity(empresa).build();
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Empresa empresa){
        Empresa entity = Empresa.findById(id);
        if (entity == null){
            throw new NotFoundException();
        }

        entity.Nome_Fantasia = empresa.Nome_Fantasia;
        entity.Razao_Social = empresa.Razao_Social;
        entity.CNPJ = empresa.CNPJ;
        entity.Telefone = empresa.Telefone;
        entity.Pais = empresa.Pais;
        entity.Estado = empresa.Estado;
        entity.Cidade = empresa.Cidade;        

        entity.persist();

        return Response.status(Status.OK).entity(entity).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        Empresa entity = Empresa.findById(id);
        if (entity == null){
            throw new NotFoundException();
        }
        entity.delete();

        return Response.status(Status.OK).build();
    }
}
