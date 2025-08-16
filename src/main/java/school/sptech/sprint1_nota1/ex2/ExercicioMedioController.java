package school.sptech.sprint1_nota1.ex2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExercicioMedioController {

    private boolean isPrimo = true;

    public boolean isPrimo() {
        return isPrimo;
    }

    public void setPrimo(boolean primo) {
        isPrimo = primo;
    }

    @GetMapping("/ex-02/{numero}")
    public Boolean exercicioMedio(@PathVariable int numero) {
        int meioNumero = numero/2;
        if (numero <= 1){
            isPrimo = false;
        } else {
            for (int i = 2; i < meioNumero; i++) {
                if (numero % i == 0){
                    isPrimo = false;
                    i = meioNumero;
                }
            }
        }
        return isPrimo;
    }
}
