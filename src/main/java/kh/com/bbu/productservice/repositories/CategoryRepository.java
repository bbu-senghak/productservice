package kh.com.bbu.productservice.repositories;

import kh.com.bbu.productservice.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    // Select * from categories where name='' and id;
    CategoryEntity findByName(String name);
}
