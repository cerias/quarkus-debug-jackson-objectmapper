package wtf.heck.spqg.core.enviroment.boundry;


import wtf.heck.spqg.core.AbstractRepository;
import wtf.heck.spqg.core.enviroment.entity.TestA;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TestRepository extends AbstractRepository<TestA> {

    public TestRepository() {
        super(TestA.class);
    }
}
