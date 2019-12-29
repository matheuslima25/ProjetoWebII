package projetoweb2;

import dao.FornecedorDAO;
import dao.UsuarioDAO;
import java.text.SimpleDateFormat;
import model.Usuario;
import java.util.List;
import java.util.Scanner;
import model.Fornecedor;

/**
 *
 * @author Matheus
 */
public class ProjetoWeb2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String op = "";
        UsuarioDAO daoU = new UsuarioDAO();
        FornecedorDAO daoF = new FornecedorDAO();
        Usuario u = null;
        Fornecedor f = null;
        
        do{
            System.out.println("----MENU PRINCIPAL----");
            System.out.println("1. USUÁRIO");
            System.out.println("2. FORNECEDOR");
            System.out.println("0. SAIR");
            op = input.nextLine();

            switch(op){
                case"1":
                    do {
                        System.out.println("----USUÁRIO----");
                        System.out.println("1 - CADASTRAR");
                        System.out.println("2 - EDITAR");
                        System.out.println("3 - EXCLUIR");
                        System.out.println("4 - LISTAR");
                        System.out.println("5 - BUSCAR");
                        System.out.println("0 - SAIR");
                        op = input.nextLine();

                        if (op.equals("1")) {
                            System.out.println("----CADASTRAR----");

                            u = new Usuario();

                            System.out.println("Nome: ");
                            u.setNome(input.nextLine());
                            System.out.println("E-mail: ");
                            u.setEmail(input.nextLine());
                            System.out.println("Data de nascimento: ");
                            u.setDataNascimento(formatter.parse(input.nextLine()));
                            System.out.println("Telefone: ");
                            u.setTelefone(input.nextLine());
                            System.out.println("Rua: ");
                            u.getEndereco().setRua(input.nextLine());
                            System.out.println("Número: ");
                            u.getEndereco().setNumero(input.nextLine());
                            System.out.println("Bairro: ");
                            u.getEndereco().setBairro(input.nextLine());
                            System.out.println("Cidade: ");
                            u.getEndereco().setCidade(input.nextLine());
                            System.out.println("UF: ");
                            u.getEndereco().setUf(input.nextLine());

                            daoU.inserir(u);

                            System.out.println("Registro salvo com sucesso!");
                            break;
                        } else if (op.equals("2")) {
                            System.out.println("----EDITAR----");
                            System.out.println("Informe o id: ");
                            long id = Long.parseLong(input.nextLine());
                            u = daoU.getPorId(id);
                            if (u != null) {
                                System.out.println("Novo Nome: ");
                                u.setNome(input.nextLine());
                                System.out.println("Novo E-mail: ");
                                u.setEmail(input.nextLine());
                                System.out.println("Novo Telefone: ");
                                u.setTelefone(input.nextLine());
                                System.out.println("Nova Rua: ");
                                u.getEndereco().setRua(input.nextLine());
                                System.out.println("Novo Número: ");
                                u.getEndereco().setNumero(input.nextLine());
                                System.out.println("Novo Bairro: ");
                                u.getEndereco().setBairro(input.nextLine());
                                System.out.println("Nova Cidade: ");
                                u.getEndereco().setCidade(input.nextLine());
                                System.out.println("Novo UF: ");
                                u.getEndereco().setUf(input.nextLine());
                                daoU.editar(u);
                                System.out.println("Registro editado com sucesso!");
                            } else {
                                System.out.println("Registro não encontrado!");
                            }
                            break;
                        } else if (op.equals("3")) {
                            System.out.println("----EXLUIR---");
                            System.out.println("Informe o id: ");
                            long id = Long.parseLong(input.nextLine());
                            u = daoU.getPorId(id);
                            if (u != null) {
                                daoU.excluir(u);
                                System.out.println("Registro excluído com sucesso!");
                            } else {
                                System.out.println("Registro não encontrado!");
                            }
                            break;
                        } else if (op.equals("4")) {

                            System.out.println("----LISTAR----");
                            List<Usuario> lista = daoU.getLista();

                            if (lista.isEmpty()) {
                                System.out.println("Nenhum registro encontrado!");
                            }

                            for (int i = 0; i < lista.size(); i++) {
                                System.out.println(lista.get(i));
                            }
                            break;
                        } else if (op.equals("5")) {
                            System.out.println("----BUSCAR----");
                            System.out.println("Nome do usuario: ");
                            String busca = input.nextLine();
                            List<Usuario> lista = daoU.buscar(busca);

                            if (lista.isEmpty()) {
                                System.out.println("Nenhum registro encontrado!");
                            }

                            for (int i = 0; i < lista.size(); i++) {
                                System.out.println(lista.get(i));
                            }
                            break;
                        }

                    } while (!op.equals("0"));
                    break;
                case"2":
                    do {
                        System.out.println("----FORNECEDOR----");
                        System.out.println("1 - CADASTRAR");
                        System.out.println("2 - EDITAR");
                        System.out.println("3 - EXCLUIR");
                        System.out.println("4 - LISTAR");
                        System.out.println("5 - BUSCAR");
                        System.out.println("0 - SAIR");
                        op = input.nextLine();

                        if (op.equals("1")) {
                            System.out.println("----CADASTRAR----");

                            f = new Fornecedor();

                            System.out.println("Nome: ");
                            f.setNome(input.nextLine());
                            System.out.println("E-mail: ");
                            f.setEmail(input.nextLine());
                            System.out.println("Data de entrega: ");
                            f.setDataEntrega(formatter.parse(input.nextLine()));
                            System.out.println("Telefone: ");
                            f.setTelefone(input.nextLine());
                            System.out.println("Nome do produto: ");
                            f.getProduto().setNome(input.nextLine());
                            System.out.println("Preço: ");
                            f.getProduto().setPreco(input.nextLine());

                            daoF.inserir(f);

                            System.out.println("Registro salvo com sucesso!");
                            break;
                        } else if (op.equals("2")) {
                            System.out.println("----EDITAR----");
                            System.out.println("Informe o id: ");
                            long id = Long.parseLong(input.nextLine());
                            f = daoF.getPorId(id);
                            if (f != null) {
                                System.out.println("Novo Nome: ");
                                f.setNome(input.nextLine());
                                System.out.println("Novo E-mail: ");
                                f.setEmail(input.nextLine());
                                System.out.println("Nova Data de entrega: ");
                                f.setDataEntrega(formatter.parse(input.nextLine()));
                                System.out.println("Novo Telefone: ");
                                f.setTelefone(input.nextLine());
                                System.out.println("Novo Nome do produto: ");
                                f.getProduto().setNome(input.nextLine());
                                System.out.println("Novo Preço: ");
                                f.getProduto().setPreco(input.nextLine());
                                daoF.editar(f);
                                System.out.println("Registro editado com sucesso!");
                            } else {
                                System.out.println("Registro não encontrado!");
                            }
                            break;
                        } else if (op.equals("3")) {
                            System.out.println("----EXLUIR---");
                            System.out.println("Informe o id: ");
                            long id = Long.parseLong(input.nextLine());
                            f = daoF.getPorId(id);
                            if (f != null) {
                                daoF.excluir(f);
                                System.out.println("Registro excluído com sucesso!");
                            } else {
                                System.out.println("Registro não encontrado!");
                            }
                            break;
                        } else if (op.equals("4")) {

                            System.out.println("----LISTAR----");
                            List<Fornecedor> lista = daoF.getLista();

                            if (lista.isEmpty()) {
                                System.out.println("Nenhum registro encontrado!");
                            }

                            for (int i = 0; i < lista.size(); i++) {
                                System.out.println(lista.get(i));
                            }
                            break;
                        } else if (op.equals("5")) {
                            System.out.println("----BUSCAR----");
                            System.out.println("Nome do fornecedor: ");
                            String busca = input.nextLine();
                            List<Fornecedor> lista = daoF.buscar(busca);

                            if (lista.isEmpty()) {
                                System.out.println("Nenhum registro encontrado!");
                            }

                            for (int i = 0; i < lista.size(); i++) {
                                System.out.println(lista.get(i));
                            }
                            break;
                        }

                    } while (!op.equals("0"));
                    break;
                default:
                    System.out.println("Saindo...");
                    break;
            }        
        } while (!op.equals("0"));
    }

}
