package jp.ac.group.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.group.manage.model.ProductList;


@Repository
public interface ProductListRepository extends JpaRepository<ProductList, Long> {
	
}
