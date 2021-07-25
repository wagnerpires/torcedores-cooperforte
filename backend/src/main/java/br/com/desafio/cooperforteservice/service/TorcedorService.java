package br.com.desafio.cooperforteservice.service;

import br.com.desafio.cooperforteservice.Usuario;
import br.com.desafio.cooperforteservice.dto.TorcedorDTO;
import br.com.desafio.cooperforteservice.entity.Torcedor;
import br.com.desafio.cooperforteservice.enums.OperacaoEnum;
import br.com.desafio.cooperforteservice.exception.TorcedorNotFound;
import br.com.desafio.cooperforteservice.repository.TorcedorRepository;
import br.com.desafio.cooperforteservice.service.mappers.TorcedorDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TorcedorService {

    private TorcedorRepository torcedorRepository;
    private LogService logService;
    private AutenticacaoService autenticacaoService;

    @Transactional()
    public Torcedor novo(TorcedorDTO torcedorDTO) {

        Usuario usuarioLogado = autenticacaoService.obterUsuarioLogado();

        Torcedor torcedor = TorcedorDTOMapper.parseParaEntity(torcedorDTO);
        torcedor.setUsuarioUltimaAtualizacao(usuarioLogado);
        torcedor.setUsuarioCriador(usuarioLogado);

        torcedorRepository.save(torcedor);

        logService.registrar(OperacaoEnum.CRIACAO, torcedor);

        return torcedor;
    }

    public List<Torcedor> listar() {
        return torcedorRepository.findAllByExcluidoFalse();
    }

    @Transactional
    public void excluir(Long id) {
        Torcedor torcedor = torcedorRepository.findById(id).orElseThrow(() -> new TorcedorNotFound("Usuário não encontrado: " + id));
        logService.registrar(OperacaoEnum.DELECAO, torcedor);
        torcedor.setExcluido(true);
        torcedorRepository.save(torcedor);
    }

    @Transactional
    public Torcedor editar(Long id, TorcedorDTO torcedorDTO) {
        Torcedor torcedor = torcedorRepository.findById(id).orElseThrow(() -> new TorcedorNotFound("Usuário não encontrado: " + id));

        TorcedorDTOMapper.atualizarEntity(torcedorDTO, torcedor);
        torcedor.setUsuarioUltimaAtualizacao(autenticacaoService.obterUsuarioLogado());
        torcedorRepository.save(torcedor);

        logService.registrar(OperacaoEnum.ATUALIZACAO, torcedor);

        return torcedor;
    }
}
