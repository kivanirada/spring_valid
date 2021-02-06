package SpringBootRestfulCrudMysql.valid;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuariosController {

	@Autowired
	private UsuariosService service;
	

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuarios> get(@PathVariable Integer id) {
		try {
			Usuarios usuarios = service.get(id);
			return new ResponseEntity<Usuarios>(usuarios, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Usuarios>(HttpStatus.NOT_FOUND);
		}
		
	}

	@GetMapping("/usuarios")
	public List<Usuarios> list(){
		return service.listAll();
	}
	
	@PostMapping("/usuarios")
	public void add(@RequestBody Usuarios usuarios) {
		service.save(usuarios);
	}
	

}
