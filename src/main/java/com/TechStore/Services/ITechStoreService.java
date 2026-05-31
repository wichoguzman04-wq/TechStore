package com.TechStore.Services;

import java.util.List;
import com.TechStore.models.TechStore;

public interface ITechStoreService {
	
	List<TechStore> buscarTodo();
	TechStore buscarPorId(Integer id);
	void guardar(TechStore producto);
	
}