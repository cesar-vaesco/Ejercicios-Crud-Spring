package com.vaescode.producto.controller;

import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaescode.producto.dao.ProductoRepository;
import com.vaescode.producto.entity.Producto;
import com.vaescode.producto.service.IProductoService;

/**
 * @author Cesar_Dev
 *
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	public IProductoService productoService;

	@Autowired
	public ProductoRepository productoRepository;

	@GetMapping(value="/listar/{nombre}/{marca}") 
	public Producto existen(@PathVariable("nombre") String nombre,
							@PathVariable("marca") String marca ) {
		return productoRepository.findByNombreandMarca(nombre, marca);
	}
	
	@GetMapping(value="/listar/{nombre}/{marca}") 
	public List<Producto> listado(@PathVariable("nombre") String nombre,
			@PathVariable("marca") String marca ){
		
		productoService.findByNombreandMarca(nombre, marca);
		
		return (List<Producto>) productoService.findByNombreandMarca(nombre, marca);
	}
	
	/*
	 @GetMapping("usuarios/existE/{email}/{password}") public Usuario
	 * exist_e_p(@PathVariable String email, @PathVariable String password) { return
	 * iUsuarioDao.findByEmailandPassword(email,password); }
	
	
	
	/*@GetMapping(value = "/listar/{nombre}/{marca}")
	public ResponseEntity<Producto> productosListar(@PathVariable("nombre") String nombre,
			@PathVariable("marca") String marca) {
		
		Producto response = productoRepository.findByNombreandMarca(nombre, marca);
		
			log.info(nombre + " " + marca);
			
			//return new ResponseEntity<List<Producto>>(datos, HttpStatus.OK);
			log.info(" " +  productoRepository.findByNombreandMarca(nombre, marca));
			
			return ResponseEntity.status(HttpStatus.OK).body(response);
	}
*/
	/*
	 * 
	 * @@GET
	 * 
	 * @Path("customers") public Response getCustomers(
	 * 
	 * @QueryParam("firstname") String firstname,
	 * 
	 * @QueryParam("lastname") String lastname,
	 * 
	 * @QueryParam("status") String status) { String result =
	 * String.format("firstname = %s, lastname = %s, status = %s", new
	 * String[]{firstname, lastname, status}); return Response.ok(result).build(); }
	 */
	/*
	 
	 * 
	 * }
	 */

	/*
	 * 
	 * @GetMapping("usuarios/existE/{email}/{password}") public Usuario
	 * exist_e_p(@PathVariable String email, @PathVariable String password) { return
	 * iUsuarioDao.findByEmailandPassword(email,password); }
	 */
	/*
	 * @GetMapping("/listar/{nombre}/{marca}") public @ResponseBody Producto
	 * getNombreAndMarca(@RequestParam("nombre") String nombre,
	 * 
	 * @RequestParam("marca") String marca) {
	 * 
	 * Producto p = productoRepository.findByNombreandMarca(nombre, marca);
	 * 
	 * return p; }
	 * 
	 */

	/*
	 * // En el caso del servicio REST seria: return
	 * ResponseEntity.status(HttpStatus.OK).body(response);
	 * System.out.println("Json Correcto Object: " +
	 * mapper.writeValueAsString(response));
	 * System.out.println("Json Correcto Map: " +
	 * mapper.writeValueAsString(responseMap));
	 * 
	 */

//	http://localhost:8080/api/productos/listar
	@GetMapping("/listar")
	public ResponseEntity<List<Producto>> listarTodos() {
		List<Producto> productos = productoService.findAll();
		if (productos.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(productos);
		}
	}

	// http://localhost:8080/api/productos/listar/{id}
	@GetMapping("/listar/{id}")
	public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {
		Optional<Producto> buscarProducto = Optional.ofNullable(productoService.findById(id));

		if (buscarProducto.isPresent()) {
			return ResponseEntity.ok(buscarProducto.get());
		} else {

			return ResponseEntity.noContent().build();
		}
	}

	// http://localhost:8080/api/productos/crear --> nombre, marca, precio
	@PostMapping("/crear")
	public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
		Producto productoCreado = productoService.save(producto);

		return new ResponseEntity<Producto>(productoCreado, HttpStatus.CREATED);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Producto> actualizarProducto(@Validated @RequestBody Producto producto,
			@PathVariable(value = "id") Long productoId) {

		Optional<Producto> buscarProducto = Optional.ofNullable(productoService.findById(producto.getId()));

		if (buscarProducto.isPresent()) {

			Producto actualizarProducto = buscarProducto.get();

			actualizarProducto.setId(producto.getId());
			actualizarProducto.setNombre(producto.getNombre());
			actualizarProducto.setMarca(producto.getMarca());
			actualizarProducto.setPrecio(producto.getPrecio());

			productoService.save(actualizarProducto);

			return ResponseEntity.ok(actualizarProducto);

		} else {

			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<Producto> eliminarProducto(@PathVariable(value = "id") Long productoId) {

		Optional<Producto> buscarProducto = Optional.ofNullable(productoService.findById(productoId));

		if (buscarProducto.isPresent()) {
			productoService.delete(productoId);
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
