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
            Domicilio domicilioSucursal = new Domicilio("Av. Siempre Viva 742", "Springfield", "Provincia X");
            Domicilio domicilioCliente = new Domicilio("Calle Falsa 123", "Springfield", "Provincia X");

            // Obra social
            ObraSocial obraSocial = new ObraSocial("OSDE");

            // Cliente
            Cliente cliente = new Cliente("Juan", "Perez", 12345678, 55555, obraSocial, domicilioCliente);

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
                    "Ana", "Gomez", 87654321, 11111, obraSocial,
                    domicilioSucursal, "20333456152", sucursal, rolEncargado
            );

            Empleado vendedor = new Empleado(
                    "Luis", "Martinez", 11223344, 22222, obraSocial,
                    domicilioSucursal, "20333555666", sucursal, rolVendedor
            );

            Empleado cobrador = new Empleado(
                    "Sofia", "Lopez", 44332211, 33333, obraSocial,
                    domicilioSucursal, "20333666777", sucursal, rolCobrador
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

            DetalleProducto detalleProducto = new DetalleProducto(
                    2, producto
            );

            // Venta
            Venta venta = new Venta(
                    LocalDate.now(), 301.00f,
                    FormaDePago.TARJETA_DE_CREDITO, cliente, vendedor, cobrador, detalleProducto
            );

            // Serialización JSON
            ObjectMapper mapper = new ObjectMapper();
            // esto es  para las fechas
            mapper.registerModule(new JavaTimeModule()); // ⬅ REGISTRA ESTE MÓDULO
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // ⬅ FORMATO ISO "yyyy-MM-dd"
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String jsonSucursal = mapper.writeValueAsString(sucursal);
            System.out.println("Sucursal JSON:");
            System.out.println(jsonSucursal);

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