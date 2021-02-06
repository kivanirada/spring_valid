package SpringBootRestfulCrudMysql.valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

	
	@Autowired
	private IUsuariosRepository repo;
	
	public List<Usuarios> listAll(){
		return repo.findAll();
	}
	
	public void save(Usuarios usuarios) {
		repo.save(usuarios);
	}
	
	public Usuarios get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
