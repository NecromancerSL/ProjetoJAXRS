package servicos;



import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import modelo.dao.VeiculoDAO;
import modelo.entities.Veiculo;

@Path("imagem")
public class ImagemService {
	private VeiculoDAO dao = new VeiculoDAO();
	
	@GET
	@Path("/{id}")
	@Produces("image/*")
	public Response buscaImagem(@PathParam("id") int id) {
		Veiculo v = dao.getVeiculo(id);
		byte [] imagem = v.getImagem();
		return Response.ok(imagem).build();
 	}
	
	
	
	@PUT
	@Path("/{id}")
	@Consumes("image/*")
	public Response adicionaImagem(@PathParam("id") int id, byte[] imagem) {
		Veiculo atual = dao.getVeiculo(id);
		if (atual != null) {
			atual.setImagem(imagem);
			dao.salvar(atual);
			return Response.status(
					Response.Status.OK).build();
		}
		return Response.status(
				Response.Status.NOT_FOUND).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes("image/*")
	public Response excluirImagem(@PathParam("id") int id, byte[] imagem) {
		Veiculo atual = dao.getVeiculo(id);
		if (atual != null) {
			atual.setImagem(null);
			dao.salvar(atual);
			return Response.status(
					Response.Status.OK).build();
		}
		return Response.status(
				Response.Status.NOT_FOUND).build();
	
	}
	
}
