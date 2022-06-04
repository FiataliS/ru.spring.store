package ru.spring.store.Repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spring.store.Entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
