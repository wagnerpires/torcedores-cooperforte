package br.com.desafio.cooperforteservice.service;

import br.com.desafio.cooperforteservice.entity.Torcedor;
import br.com.desafio.cooperforteservice.entity.LogTransacao;
import br.com.desafio.cooperforteservice.enums.OperacaoEnum;
import br.com.desafio.cooperforteservice.repository.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class LogService {

    private AutenticacaoService autenticacaoService;
    private LogRepository logRepository;

    public void registrar(OperacaoEnum operacaoEnum, Torcedor torcedor) {

        LogTransacao log = LogTransacao.builder()
                .operacao(operacaoEnum)
                .data(LocalDateTime.now())
                .torcedor(torcedor)
                .autor(autenticacaoService
                        .obterUsuarioLogado())
                .build();

        logRepository.save(log);
    }
}
