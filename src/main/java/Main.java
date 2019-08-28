
import data.ConnectionFactory;
import data.DataStore;
import java.util.logging.LogManager;
import misc.Globals;
import model.Categoria;

public class Main {

    public static void main(String[] args) {
        LogManager.getLogManager().getLogger("").setLevel(Globals.LOG_LEVEL);

//        manager.getTransaction().begin();
//        manager.persist(categoria);
//        manager.getTransaction().commit();

        System.out.println(DataStore.getCategorias().count());
        DataStore.getCategorias().findAll().forEach(System.out::println);
        int in = 10;
        for (int i = in; i < in + 20; i++) {
            Categoria categoria = new Categoria("cat " + i);
            DataStore.getCategorias().save(categoria);
        }
        System.out.println(DataStore.getCategorias().count());
        DataStore.getCategorias().findAll().forEach(System.out::println);

        ConnectionFactory.close();
        DataStore.getManager().close();
//        System.exit(0);
    }

}
