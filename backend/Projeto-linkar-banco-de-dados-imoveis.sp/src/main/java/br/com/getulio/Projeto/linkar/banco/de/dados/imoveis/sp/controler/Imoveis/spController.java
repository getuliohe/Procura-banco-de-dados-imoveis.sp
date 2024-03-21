package br.com.getulio.Projeto.linkar.banco.de.dados.imoveis.sp.controler.Imoveis;

import br.com.getulio.Projeto.linkar.banco.de.dados.imoveis.sp.service.SearchData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class spController {

    @CrossOrigin(origins = "http://127.0.0.1:5501/")
    @GetMapping("/backend/pesquisa")
    public String getImoveis_sp(@RequestParam String termo){
        if (termo.isBlank()){
            return "";
        }
        return SearchData.getDataFromDB(termo);
    }
}
