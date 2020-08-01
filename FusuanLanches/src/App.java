
import java.text.DateFormat;
import java.util.Date;
import view.Index;

/**
 * Classe main
 * Chamada inicial do sistema
 * @author Ruan
 */
public class App {
    
    public static void main(String[] args) {
        //data atual
        //vai ser usado em quase todo canto
        //dá de colocar numa classe de utils
        System.out.println(DateFormat.getDateInstance().format(new Date()));
        Index telaPrincipal = new Index();
        telaPrincipal.setVisible(true);
    }
    
}