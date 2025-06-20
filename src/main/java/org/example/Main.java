package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.InsertManyResult;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static com.mongodb.client.model.Filters.eq;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
              // Obra social
            ObraSocial obraSocial = new ObraSocial("PAMI");
            ObraSocial obraSocial2 = new ObraSocial("OSDE");
            ObraSocial obraSocial3 = new ObraSocial("Swiss Medical");
            ObraSocial obraSocial4 = new ObraSocial("Privado");
            
            Domicilio domicilioEmpleado1 = new Domicilio("Urbanización Marcela Jódar", "Ceuta", "Buenos Aires");
            Domicilio domicilioEmpleado2 = new Domicilio("Av. Libertador", "Recoleta", "Buenos Aires");
            Domicilio domicilioEmpleado3 = new Domicilio("Av. Corrientes", "Microcentro", "Buenos Aires");

            Domicilio domicilioEmpleado4 = new Domicilio("C. de Soledad Segarra", "Córdoba", "Buenos Aires");
            Domicilio domicilioEmpleado5 = new Domicilio("Urbanización Marcela Jódar", "Palencia", "Buenos Aires");
            Domicilio domicilioEmpleado6 = new Domicilio("Acceso de Isidoro Chacón", "Ávila", "Buenos Aires");

            Domicilio domicilioEmpleado7 = new Domicilio("Paseo Simón Giménez", "Palencia", "Buenos Aires");
            Domicilio domicilioEmpleado8 = new Domicilio("Plaza de Martina Cuervo","Guipúzcoa","Buenos Aires");
            Domicilio domicilioEmpleado9 = new Domicilio("Vial de Ildefonso Navarro", "Ávila", "Buenos Aires");

          
            // Cliente
            Cliente cliente1 = new Cliente("Santiago", "Castro", 20890399, 688508, obraSocial4, new Domicilio("Urbanización Marcela Jódar", "Ceuta", "Buenos Aires"));
            Cliente cliente2 = new Cliente("Lucas", "Sosa", 31541238, 733052, obraSocial2, new Domicilio("Acceso de Isidoro Chacón", "Ávila", "Buenos Aires"));
            Cliente cliente3 = new Cliente("Martina", "Ponce", 21457954, 865179, obraSocial4, new Domicilio("Via Ezequiel Cuesta", "Pontevedra", "Buenos Aires"));
            Cliente cliente4 = new Cliente("Mateo", "Silva", 23389045, 498591, obraSocial, new Domicilio("Callejón de Ángela Gimenez", "Vizcaya", "Buenos Aires"));
            Cliente cliente5 = new Cliente("Bruno", "Acosta", 24188470, 496922, obraSocial2, new Domicilio("Urbanización Paca Antón", "La Coruña", "Buenos Aires"));
            
            List<Cliente> clientes = new ArrayList<Cliente>();
            clientes.add(cliente1);
            clientes.add(cliente2);
            clientes.add(cliente3);
            clientes.add(cliente4);
            clientes.add(cliente5);

            
            
            // Sucursal (sin encargado inicialmente)
            Sucursal sucursal1 = new Sucursal(null, new Domicilio("Calle Juramento 987", "Colegiales", "Buenos Aires"));
            Sucursal sucursal2 = new Sucursal(null, new Domicilio("Av. Santa Fe 1234", "Palermo", "Buenos Aires"));
            Sucursal sucursal3 = new Sucursal(null, new Domicilio("Av. Cabildo 2345", "Belgrano", "Buenos Aires"));

            List<Sucursal> sucursales = new ArrayList<Sucursal>();
            sucursales.add(sucursal1);
            sucursales.add(sucursal2);
            sucursales.add(sucursal3);
            // Roles
            List<TipoEmpleado> rolEncargado = new ArrayList<>();
            rolEncargado.add(TipoEmpleado.ENCARGADO);

            List<TipoEmpleado> rolVendedor = new ArrayList<>();
            rolVendedor.add(TipoEmpleado.VENDEDOR);

            List<TipoEmpleado> rolCobrador = new ArrayList<>();
            rolCobrador.add(TipoEmpleado.COBRADOR);

            // Empleados
            Empleado encargado1 = new Empleado(
                    "Martina", "Luna", 39615450, 549245, obraSocial2,
                    domicilioEmpleado1, "25236942776", rolEncargado
            );

            Empleado vendedor1 = new Empleado(
                    "Olivia", "Rojas", 33275203, 774079, obraSocial3,
                    domicilioEmpleado2, "27696922252", rolVendedor
            );

            Empleado cobrador1 = new Empleado(
                    "Santiago", "Maldonado", 38688132, 330283, obraSocial3,
                    domicilioEmpleado3, "24497330581", rolCobrador
            );

            Empleado encargado2 = new Empleado(
                    "Camila", "Gutiérrez", 40781234, 612345, obraSocial,
                    domicilioEmpleado4, "27456789123", rolEncargado
            );
            Empleado vendedor2 = new Empleado(
                    "Lucas", "Martínez", 38990123, 778899, obraSocial2,
                    domicilioEmpleado5, "27123456789", rolVendedor
            );
            Empleado cobrador2 = new Empleado(
                    "Paula", "Sánchez", 39567891, 887766, obraSocial3,
                    domicilioEmpleado6, "27099887766", rolCobrador
            );
            
            Empleado encargado3 = new Empleado(
                    "Federico", "López", 41234567, 334455, obraSocial3,
                    domicilioEmpleado7, "27987654321", rolEncargado
            );
            Empleado vendedor3 = new Empleado(
                    "Milagros", "Fernández", 40112233, 112233, obraSocial2,
                    domicilioEmpleado8, "27221133445", rolVendedor
            );
            Empleado cobrador3 = new Empleado(
                    "Joaquín", "Ramírez", 39445566, 665544, obraSocial,
                    domicilioEmpleado9, "27334455667", rolCobrador
            );
            
            // Seteamos el encargado ahora que fue creado
            sucursal1.setEncargado(encargado1);
            sucursal2.setEncargado(encargado2);
            sucursal3.setEncargado(encargado3);
            // Agregamos empleados a la sucursal
            sucursal1.getEmpleados().add(encargado1);
            sucursal1.getEmpleados().add(vendedor1);
            sucursal1.getEmpleados().add(cobrador1);
            
            sucursal2.getEmpleados().add(encargado2);
            sucursal2.getEmpleados().add(vendedor2);
            sucursal2.getEmpleados().add(cobrador2);
            
            sucursal3.getEmpleados().add(encargado3);
            sucursal3.getEmpleados().add(vendedor3);
            sucursal3.getEmpleados().add(cobrador3);

            // Producto y detalle
            Producto producto1 = new Producto(
                    "P-001", TipoProducto.MEDICAMENTO, "Ibuprofeno 400mg", "Laboratorio ABC", 150.50f
            );
            Producto producto2 = new Producto(
                    "P-002", TipoProducto.PERFUMERIA, "Shampoo Sedal 340ml", "Laboratorio Unilever", 1220.72f
            );
            Producto producto3 = new Producto(
                    "P-003", TipoProducto.MEDICAMENTO, "Paracetamol 500mg", "Laboratorio Genfar", 89.90f
            );

            Producto producto4 = new Producto(
                    "P-004", TipoProducto.PERFUMERIA, "Crema Nivea Soft 200ml", "Laboratorio Beiersdorf", 510.30f
            );

            Producto producto5 = new Producto(
                    "P-005", TipoProducto.MEDICAMENTO, "Amoxicilina 500mg", "Laboratorio Bayer", 310.25f
            );

            Producto producto6 = new Producto(
                    "P-006", TipoProducto.PERFUMERIA, "Desodorante Dove 150ml", "Laboratorio Unilever", 430.50f
            );

            Producto producto7 = new Producto(
                    "P-007", TipoProducto.MEDICAMENTO, "Omeprazol 20mg", "Laboratorio Bagó", 275.80f
            );
            
            List<Producto> productos = new ArrayList<Producto>();
            productos.add(producto1);
            productos.add(producto2);
            productos.add(producto3);
            productos.add(producto4);
            productos.add(producto5);
            productos.add(producto6);
            productos.add(producto7);
            
           List<Venta> ventas = new ArrayList<Venta>();
           List<FormaDePago> ListPagos = new ArrayList<FormaDePago>();
           ListPagos.add(FormaDePago.EFECTIVO);
           ListPagos.add(FormaDePago.TARJETA_DE_CREDITO);
           ListPagos.add(FormaDePago.TRANSFERENCIA);
           Random rand = new Random();
           
           for (int i = 0; i < 10; i++) {
        	    Cliente cliente = clientes.get(i % clientes.size());
        	    Sucursal sucursal = sucursales.get(i % sucursales.size());

        	    Empleado vendedor = sucursal.getEmpleados().stream()
        	            .filter(e -> e.getRoles().contains(TipoEmpleado.VENDEDOR)).findFirst().orElse(null);
        	    Empleado cobrador = sucursal.getEmpleados().stream()
        	            .filter(e -> e.getRoles().contains(TipoEmpleado.COBRADOR)).findFirst().orElse(null);

        	    FormaDePago formaDePago = ListPagos.get(i % ListPagos.size());
        	    int pago = rand.nextInt(2);
        	    Venta venta = new Venta(
        	            LocalDate.now().minusDays(rand.nextInt(10)),
        	            0,
        	            formaDePago,
        	            cliente,
        	            vendedor,
        	            cobrador,
        	            sucursal, 
        	            pago
        	    );

        	    int cantProductos = 1 + rand.nextInt(3);
        	    for (int j = 0; j < cantProductos; j++) {
        	        Producto prod = productos.get(rand.nextInt(productos.size()));
        	        int cantidad = 1 + rand.nextInt(3);
        	        venta.getProductos().add(new DetalleProducto(cantidad, prod));
        	    }

        	    float total = 0f;
        	    for (DetalleProducto dp : venta.getProductos()) {
        	        total += dp.getSubTotal();
        	    }
        	    venta.setTotalVenta(total);
        	    ventas.add(venta);
        	}
            
           
            // Serialización JSON
            ObjectMapper mapper = new ObjectMapper();
            // esto es  para las fechas
            mapper.registerModule(new JavaTimeModule()); // ⬅ REGISTRA ESTE MÓDULO
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // ⬅ FORMATO ISO "yyyy-MM-dd"
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
/*
            String jsonSucursal = mapper.writeValueAsString(sucursal);
            System.out.println("Sucursal JSON:");
            System.out.println(jsonSucursal);
*/
            
            


            //para insertar venta en mongodb
            String uri = "mongodb://localhost:27017";
            try (MongoClient mongoClient = MongoClients.create(uri)) {
                MongoDatabase database = mongoClient.getDatabase("gestion_farmacia");

                MongoCollection<Document> coleccionVenta = database.getCollection("Venta");
                for (Venta venta : ventas) {
                	String jsonVenta = mapper.writeValueAsString(venta);
                    Document documentVenta = Document.parse(jsonVenta);
    				System.out.println("Venta JSON:");
    				System.out.println(jsonVenta);
                    coleccionVenta.insertOne(documentVenta);
                    System.out.println("✅ Documento insertado correctamente en MongoDB.");
				}
                

            }catch (Exception e) {
                System.err.println("Error de conexión: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}