package school.sptech.sprint1_nota1.ex1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExercicioFacilController {

    private boolean isPalindromo;
    private String palavraLowerCase;
    private int tamanhoPalavra;
    private int meioPalavra;

    public boolean isPalindromo() {
        return isPalindromo;
    }

    public void setPalindromo(boolean palindromo) {
        isPalindromo = palindromo;
    }

    public String getPalavraLowerCase() {
        return palavraLowerCase;
    }

    public void setPalavraLowerCase(String palavraLowerCase) {
        this.palavraLowerCase = palavraLowerCase;
    }

    public int getTamanhoPalavra() {
        return tamanhoPalavra;
    }

    public void setTamanhoPalavra(int tamanhoPalavra) {
        this.tamanhoPalavra = tamanhoPalavra;
    }

    public int getMeioPalavra() {
        return meioPalavra;
    }

    public void setMeioPalavra(int meioPalavra) {
        this.meioPalavra = meioPalavra;
    }

    @GetMapping("/ex-01/{palavra}")
    public Boolean exercicioFacil(@PathVariable String palavra) {
        isPalindromo = false;
        palavraLowerCase = palavra.toLowerCase();
        tamanhoPalavra = palavra.length();
        meioPalavra = tamanhoPalavra/2;

        if (tamanhoPalavra % 2 != 0){
            meioPalavra++;
        }
        for (int i = 0; i < meioPalavra; i++) {
            if (palavraLowerCase.charAt(0+ i) == palavraLowerCase.charAt(tamanhoPalavra-1 -i)){
                isPalindromo = true;
            } else {
                i = meioPalavra;
            }
        }
        return isPalindromo;
    }
}
