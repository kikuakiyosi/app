package jp.ac.group.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.group.manage.model.ProductList;
import jp.ac.group.manage.repository.ProductListRepository;

@Service
@Transactional
public class ProductListService {

	@Autowired
	private ProductListRepository repository;

	/**
	 * アドレス帳一覧の取得
	 * @return List<ProductList>
	 */
	public List<ProductList> getProductList() {
	    List<ProductList> entityList = this.repository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  ProductList
	 */
	public ProductList get(@NonNull Long index) {
		ProductList ProductList = this.repository.findById(index).orElse(new ProductList());
		return ProductList;
	}

	/**
	 * アドレス帳データの保存
	 * @param ProductList ProductList
	 */
	public void save(@NonNull ProductList ProductList) {
		this.repository.save(ProductList);
	}

	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
}
