package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.CadastrarUsuarioRequestDTO;
import com.bandtec.darlingjob.dto.CadastrarUsuarioResponseDTO;
import com.bandtec.darlingjob.gateway.repository.EnderecoRepository;
import com.bandtec.darlingjob.gateway.repository.UsuarioRepository;
import com.bandtec.darlingjob.gateway.repository.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public CadastrarUsuarioResponseDTO execute(CadastrarUsuarioRequestDTO cadastrarUsuarioRequestDTO) {
        Usuario profissional = new Usuario(
                cadastrarUsuarioRequestDTO.getNome(),
                cadastrarUsuarioRequestDTO.getSenha(),
                cadastrarUsuarioRequestDTO.getEmail(),
                cadastrarUsuarioRequestDTO.getTelefoneCelular(),
                cadastrarUsuarioRequestDTO.getTelefoneFixo(),
                cadastrarUsuarioRequestDTO.getRg(),
                cadastrarUsuarioRequestDTO.getCpf(),
                cadastrarUsuarioRequestDTO.getDataNascimento(),
                cadastrarUsuarioRequestDTO.getGenero(),
                cadastrarUsuarioRequestDTO.getRole(),
                cadastrarUsuarioRequestDTO.getDiasDisponiveis(),
                cadastrarUsuarioRequestDTO.getHorarioFeriadoFim(),
                cadastrarUsuarioRequestDTO.getHorarioFeriadoInicio(),
                cadastrarUsuarioRequestDTO.getHorarioInicioDia(),
                cadastrarUsuarioRequestDTO.getHorarioFimDia(),
                cadastrarUsuarioRequestDTO.getTrabalhaFeriados(),
                cadastrarUsuarioRequestDTO.getTipoServico(),
                cadastrarUsuarioRequestDTO.getEndereco()
        );

        Usuario profissionalSalvo = usuarioRepository.save(profissional);

        enderecoRepository.save(profissionalSalvo.getEndereco());

        return CadastrarUsuarioResponseDTO.convertFromDomain(profissionalSalvo);
    }

}
