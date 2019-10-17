package wtf.heck.spqg.core.enviroment.endpoints;

import wtf.heck.spqg.core.enviroment.boundry.TestRepository;
import wtf.heck.spqg.core.enviroment.entity.TestA;
import wtf.heck.spqg.core.enviroment.entity.TestB;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    @Inject
    private TestRepository repository;

    @GET
    @Path("{id}")

    public TestA get(@PathParam("id") long id) {
        return repository.getById(id);
    }

    @GET
    public List<TestA> getAll(){ return repository.getAll(); }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public TestA StellarObject(TestA object) {
        return repository.save(object);
    }



}
