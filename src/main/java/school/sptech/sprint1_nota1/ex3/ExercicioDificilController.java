package school.sptech.sprint1_nota1.ex3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExercicioDificilController {
    
    @GetMapping("/ex-03/{n}")
    public ExercicioDificilResponse exercicioDificil(@PathVariable int n) {
        int primeiroTermo = 1;
        int segundoTermo = 1;
        int enesimoTermo = 0;
        int somaTermos = primeiroTermo + segundoTermo;
        if(n <= 0){
            return new ExercicioDificilResponse(0,0);
        } else if (n <= 1){
            return new ExercicioDificilResponse(primeiroTermo, segundoTermo);
        } else if (n <= 2){
            return new ExercicioDificilResponse(segundoTermo, somaTermos);
        }
        for (int i = 3; i <= n; i++) {
            enesimoTermo = primeiroTermo + segundoTermo;
            somaTermos += enesimoTermo;

            primeiroTermo = segundoTermo;
            segundoTermo = enesimoTermo;
        }
        return new ExercicioDificilResponse(enesimoTermo, somaTermos);
    }
}
