package senai.topicos.estoque.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.estoque.domain.entity.Compra;
import senai.topicos.estoque.repository.CompraRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GeraLoteService {

    private final CompraRepository repository;

    public void gerarLote() {
        //TODO adicionar Job para criar arquivo automaticamente todo a meia noite, após impleentação do DB
        List<Compra> compras = repository.listarCompras();
        String path = "D:\\listaDeCompras.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Compra compra : compras) {
                bw.write(String.valueOf(compra));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
