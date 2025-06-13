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
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            // Domicilios
            Domicilio domicilioSucursal = new Domicilio("Plaza Manuela Llopis", "Ceuta", "Buenos Aires");
            Domicilio domicilioCliente = new Domicilio("Via Inmaculada Bonet", "Alicante", "Buenos Aires");
            
            Domicilio domicilioEmpleado1 = new Domicilio("Urbanización Marcela Jódar", "Ceuta", "Buenos Aires");
            Domicilio domicilioEmpleado2 = new Domicilio("Acceso de Isidoro Chacón", "Ávila", "Buenos Aires");
            Domicilio domicilioEmpleado3 = new Domicilio("Via Ezequiel Cuesta", "Pontevedra", "Buenos Aires");

            // Obra social
            ObraSocial obraSocial = new ObraSocial("PAMI");
            ObraSocial obraSocial2 = new ObraSocial("OSDE");
            ObraSocial obraSocial3 = new ObraSocial("Swiss Medical");
            // Cliente
            Cliente cliente = new Cliente("Santiago", "Castro", 20890399, 688508, obraSocial, domicilioCliente);

            // Sucursal (sin encargado inicialmente)
            Sucursal sucursal = new Sucursal(null, domicilioSucursal);

            // Roles
            List<TipoEmpleado> rolEncargado = new ArrayList<>();
            rolEncargado.add(TipoEmpleado.ENCARGADO);

            List<TipoEmpleado> rolVendedor = new ArrayList<>();
            rolVendedor.add(TipoEmpleado.VENDEDOR);

            List<TipoEmpleado> rolCobrador = new ArrayList<>();
            rolCobrador.add(TipoEmpleado.COBRADOR);

            // Empleados
            Empleado encargado = new Empleado(
                    "Martina", "Luna", 39615450, 549245, obraSocial2,
                    domicilioEmpleado1, "25236942776", rolEncargado
            );

            Empleado vendedor = new Empleado(
                    "Olivia", "Rojas", 33275203, 774079, obraSocial3,
                    domicilioEmpleado2, "27696922252", rolVendedor
            );

            Empleado cobrador = new Empleado(
                    "Santiago", "Maldonado", 38688132, 330283, obraSocial3,
                    domicilioEmpleado3, "24497330581", rolCobrador
            );

            // Seteamos el encargado ahora que fue creado
            sucursal.setEncargado(encargado);

            // Agregamos empleados a la sucursal
            sucursal.getEmpleados().add(encargado);
            sucursal.getEmpleados().add(vendedor);
            sucursal.getEmpleados().add(cobrador);

            // Producto y detalle
            Producto producto = new Producto(
                    "P-001", TipoProducto.MEDICAMENTO, "Ibuprofeno 400mg", "Laboratorio ABC", 150.50f
            );
            Producto producto2 = new Producto(
                    "P-002", TipoProducto.PERFUMERIA, "Shampoo Sedal 340ml", "Laboratorio Unilever", 1220.72f
            );
            DetalleProducto detalleProducto = new DetalleProducto(
                    2, producto
            );
            DetalleProducto detalleProducto2 = new DetalleProducto(
            		3, producto2
            );
            // Venta
            Venta venta = new Venta(
                    LocalDate.now(), 0,
                    FormaDePago.TARJETA_DE_CREDITO, cliente, vendedor, cobrador , sucursal
            );
            //agrego los productos
            venta.getProductos().add(detalleProducto);
            venta.getProductos().add(detalleProducto2);
            //recorre la lista de productos para sacar el total
            float total = 0;
            for (DetalleProducto detproducto : venta.getProductos()) {
                total += detproducto.getSubTotal();
            }
            venta.setTotalVenta(total);
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
            String jsonVenta = mapper.writeValueAsString(venta);
            System.out.println("Venta JSON:");
            System.out.println(jsonVenta);



            //para insertar venta en mongodb
            String uri = "mongodb://localhost:27017";
            try (MongoClient mongoClient = MongoClients.create(uri)) {
                MongoDatabase database = mongoClient.getDatabase("gestion_farmacia");

                MongoCollection<Document> coleccionVenta = database.getCollection("Venta");

                Document documentVenta = Document.parse(jsonVenta);

                 coleccionVenta.insertOne(documentVenta);
                System.out.println("✅ Documento insertado correctamente en MongoDB.");

            }catch (Exception e) {
                System.err.println("Error de conexión: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}