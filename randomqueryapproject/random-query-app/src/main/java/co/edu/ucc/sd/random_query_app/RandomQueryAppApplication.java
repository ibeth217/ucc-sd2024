package co.edu.ucc.sd.random_query_app;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class RandomQueryAppApplication implements CommandLineRunner {

    private final DataSource dataSource;

    public RandomQueryAppApplication(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(RandomQueryAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            Random random = new Random();

            while (true) {
                int waitTime = random.nextInt(10) + 1; // Espera aleatoria entre 1 y 10 segundos
                TimeUnit.SECONDS.sleep(waitTime);

                // Cambiamos la consulta para que sea compatible con la tabla "public.dummy"
                String query = "SELECT id, \"name\" FROM public.dummy";
                ResultSet resultSet = statement.executeQuery(query);

                // Recorrer el resultado y mostrar los valores de "id" y "name"
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");

                    System.out.println("Resultado: ID = " + id + ", Nombre = " + name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}