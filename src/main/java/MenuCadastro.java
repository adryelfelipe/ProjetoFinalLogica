import java.util.ArrayList;

public class MenuCadastro
{
    public static ArrayList<String> cadastro()
    {
        boolean continuar = true;

        while(continuar)
        {
            System.out.println("================================");
            System.out.println("|           CADASTRO           |");
            System.out.println("================================\n");

            System.out.println("|     Digite seu nome: ");
            String nomeCadastro = Ferramentas.lString();

            System.out.println("|     Digite seu CPF: ");
            String cpfCadastro = Ferramentas.lString();

            System.out.println("|     Crie uma senha: ");
            String senha = Ferramentas.lString();
            System.out.println("|     Confirme a Senha: ");
            String confirmacaoSenha = Ferramentas.lString();

            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(nomeCadastro);
            arrayList.add(cpfCadastro);
            arrayList.add(senha);

            System.out.println("Parabéns " + nomeCadastro + ", seu cadastro foi concluido!");
            return arrayList;
        }
        ArrayList<String> infoGerais = MenuCadastro.cadastro();
        return infoGerais;
    }
}
