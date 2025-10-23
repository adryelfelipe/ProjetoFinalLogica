package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.UsuarioService;
import ProjetoBase.UsuarioValidator;

public class MenuSetUsuario
{

    //SET NOME DO USUÁRIO
    public static String MenuSetNome(UsuarioValidator usuarioValidator)
    {
        while(true)
        {
            System.out.print("Digite o Nome: ");
            String nome = Ferramentas.lString();

            try
            {
                UsuarioValidator.verificaIntegridadeNome(nome);
                usuarioValidator.verificaRegrasNome(nome);
                return nome;
            }
            catch (IllegalArgumentException | IllegalStateException e)
            {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }

    //SET CPF DO USUÁRIO
    public static String MenuSetCpf(UsuarioService usuarioService, UsuarioValidator usuarioValidator){

        while(true){
            System.out.print("Digite o CPF: ");
            String cpf = Ferramentas.lString();

            try
            {
                UsuarioValidator.verificaIntegridadeCpf(cpf);
                usuarioValidator.verificarRegrasCpf(cpf);
                usuarioService.isCpfCadastradoValidator(cpf);
                return cpf;
            }
            catch (IllegalArgumentException | IllegalStateException e)
            {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }

    //SET SENHA DO USUÁRIO
    public static String MenuSetSenha(UsuarioValidator usuarioValidator){
        while(true){
            System.out.print("Digite a senha: ");
            String senha = ProjetoBase.Ferramentas.lString();

            try
            {
                UsuarioValidator.verificaIntegridadeSenha(senha);
                usuarioValidator.verificarRegrasSenha(senha);
                return senha;
            }
            catch (IllegalArgumentException | IllegalStateException e)
            {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
