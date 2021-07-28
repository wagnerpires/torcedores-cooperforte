package br.com.desafio.cooperforteservice.services.mappers;

import br.com.desafio.cooperforteservice.dtos.TelefoneDTO;
import br.com.desafio.cooperforteservice.entities.Telefone;

import java.util.List;
import java.util.stream.Collectors;

public class TelefoneDTOMapper {

    public static List<Telefone> parseParaEntidade(List<TelefoneDTO> telefoneDTOS) {
        List<Telefone> collect = telefoneDTOS.stream().map(telefoneDTO -> Telefone.builder()
                .id(telefoneDTO.getId())
                .principal(telefoneDTO.getPrincipal())
                .telefone(telefoneDTO.getTelefone())
                .tipo(telefoneDTO.getTipo()).build())
                .collect(Collectors.toList());

        return  collect;
    }

}
