public class MenuSetNome
{
    public static void MenuSetNome(UsuarioValidator usuarioValidator)
    {
        boolean verifica = false;

        while(!verifica)
        {
            System.out.println("Digite o novo Nome: ");
            String nome = Ferramentas.lString();

            try
            {
                UsuarioValidator.verificaIntegridadeNome(nome);
                usuarioValidator.verificaRegrasNome(nome);
                verifica = true;
            }
            catch (IllegalArgumentException | IllegalStateException e)
            {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
