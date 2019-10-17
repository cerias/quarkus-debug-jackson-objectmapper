package wtf.heck.spqg.core.enviroment.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class TestA implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    private long minRadius;
    private long maxRadius;


    @OneToMany(mappedBy = "object")
    private List<TestB> resources;

}
