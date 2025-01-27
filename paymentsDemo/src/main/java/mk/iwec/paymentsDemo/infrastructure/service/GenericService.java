package mk.iwec.paymentsDemo.infrastructure.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericService<D, ID> {
    D findById(ID id);
    Page<D> findAll(Pageable pageable);

    D save(D dto);

    D update(ID uuid, D dto);

    void deleteById(ID id);


}
