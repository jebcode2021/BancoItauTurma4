import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ListadeMenu {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		boolean rodando = true;
		while(rodando) {
			System.out.println("[1] - Cadastrar de Cliente");
			System.out.println("[2] - Listar todos Cliente cadastrados");
			System.out.println("[3] - Procurar usuario por email");
			System.out.println("[4] - Atualizar dados de um Cliente");
			System.out.println("[5] - Remover Cliente");
			System.out.println("[6] - Gravar em arquivo");
			System.out.println("[7] - Consultar arquivo");
			System.out.println("[8] - Sair");
			System.out.println("Digite a opçao: *");
			String opcao = scanner.nextLine();
			
			switch(opcao) {
				case "1": {
					System.out.println("===== CADASTRO DE CLIENTE =====");
					System.out.print("Digite o Agencia: ");
					String agencia = scanner.nextLine();
					System.out.println("Digite a Conta: ");
					String conta = scanner.nextLine();
					System.out.println("Digite o seu nome: ");
					String nome = scanner.nextLine();
					System.out.println("Digite o seu email: ");
					String email = scanner.nextLine();
					System.out.println("Digite o seu telefone: ");
					String telefone = scanner.nextLine();
					System.out.println("Digite seu saldo: ");
					String saldo = scanner.nextLine();
					Cliente c = new Cliente();
					c.setAgencia(agencia);
					c.setConta(conta);
					c.setNome(nome);
					c.setEmail(email);
					c.setTelefone(telefone);
					c.setSaldo(saldo);
					
					clientes.add(c);
					break;
				}
				case "2": {
					System.out.println("===== CLIENTES CADASTRADOS =====");
					for (int i = 0; i < clientes.size(); i++) {
						Cliente uTemp = clientes.get(i);
						System.out.println("Cliente: " + i);
						System.out.println("\tAgencia: " + clientes.get(i).getAgencia());
						System.out.println("\tConta: " + clientes.get(i).getConta());
						System.out.println("\tNome: " + clientes.get(i).getNome());
						System.out.println("\tEmail: " + clientes.get(i).getEmail());
						System.out.println("\tTelefone: " + clientes.get(i).getTelefone());
						System.out.println("\tSaldo: " + clientes.get(i).getSaldo());
					}
					break;
				}
				case "3": {
					System.out.println("===== PROCURAR CLIENTE POR EMAIL =====");
					System.out.print("Digite o email: ");
					String email = scanner.nextLine();
					boolean encontrado = false;
					for (int i = 0; i < clientes.size(); i++) {
						Cliente uTemp = clientes.get(i);
						
						if( email.equals(uTemp.getEmail())) {
							System.out.println("Cliente encontrado");
							System.out.println("\tAgencia: " + uTemp.getAgencia());
							System.out.println("\tConta: " + uTemp.getConta());
							System.out.println("\tNome: " + uTemp.getNome());
							System.out.println("\tEmail: " + uTemp.getEmail());
							System.out.println("\tTelefone: " + uTemp.getTelefone());
							System.out.println("\tSaldo: " + uTemp.getSaldo());
							encontrado = true;
							break;
						} 
					}
					
					if (!encontrado) {
						System.out.println("Não foi encontrado nenhum cliente com esse email");
					}
					break;
				}
				case "4": {
					System.out.println("===== ATUALIZAÇÃO DE CLIENTE =====");
					
					for (int i = 0; i < clientes.size(); i++) {
						
						Cliente uTemp = clientes.get(i);
						
						System.out.println("[" + i + "} " + uTemp.getEmail());
					}
					
					System.out.print("Digite o valor de referência: ");
					int referencia = scanner.nextInt();
					scanner.nextLine();
					
					System.out.print("Digite o novo nome: ");
					String novoNome = scanner.nextLine();

					System.out.print("Digite a nova email: ");
					String novoEmail = scanner.nextLine();

					System.out.print("Digite a nova telefone: ");
					String novoTelefone = scanner.nextLine();

					System.out.print("Digite a nova saldo: ");
					String novoSaldo = scanner.nextLine();
					
					Cliente c = clientes.get(referencia);
					c.setNome(novoNome);
					c.setEmail(novoEmail);
					c.setTelefone(novoTelefone);
					c.setSaldo(novoSaldo);
					break;
				}
				case "5": {
					System.out.println("===== REMOVER CLIENTE =====");
					
					for (int i = 0; i < clientes.size(); i++) {
						Cliente uTemp = clientes.get(i);

						System.out.println("[" + i + "} " + uTemp.getEmail());
					}
					
					System.out.print("Digite o valor de referência: ");
					int referencia = scanner.nextInt();
					scanner.nextLine();
					
					clientes.remove(referencia);
					break;
				}
				case "6": {
					FileWriter arquivo = new FileWriter("C:\\arquivo.txt");
					PrintWriter gravarArquivo = new PrintWriter(arquivo);
					
					for (int i = 0; i < clientes.size(); i++) {
						Cliente uTemp = clientes.get(i);
						
						for(int registros=0; registros<3; ) {
							gravarArquivo.printf("Informações de Clientes%n%n");
							gravarArquivo.printf("Agencia: " + uTemp.getAgencia());
							gravarArquivo.printf("\tConta: " + uTemp.getConta());
							gravarArquivo.printf("\tNome: " + uTemp.getNome());
							gravarArquivo.printf("\tEmail: " + uTemp.getEmail());
							gravarArquivo.printf("\tTelefone: " + uTemp.getTelefone());
							gravarArquivo.printf("\tSaldo: " + uTemp.getSaldo());
							break;
						} 
					}
					arquivo.close();
					System.out.println("Gravado na arquivo");
					System.out.println("Local salvo é: C:\\arquivo.txt");
					break;
				}
				case "7": {  
				    String mostra="";
				    String nomeArq = "c:\\arquivo.txt"; 
				    String linha = "";
				    File arq = new File(nomeArq);
				 
				    if (arq.exists()){ 
				      mostra="Arquivo - '"+nomeArq+"', aberto com sucesso!\n";
				      mostra+="Tamanho do arquivo "+Long.toString(arq.length())+"\n";
				      try{
				        FileReader reader = new FileReader(nomeArq);
				        BufferedReader leitor = new BufferedReader(reader);
				        while(true){
				          linha=leitor.readLine();
				          if(linha==null)
				            break;
				          mostra+=linha +"\n";
				          System.out.println(linha);
		 
				        }
				      }
				      catch(Exception erro) {}
				      JOptionPane.showMessageDialog(null,mostra,"Arquivo...",1);
				    }
				    else
				      JOptionPane.showMessageDialog(null,"Arquivo nao existe!","Erro",0);
					break;
			}
				case "8": {
					System.out.print("Sair");
					rodando = false;
					break;
				}
				default:
					System.out.println("Opção Inválida!!!");
			}
			
		}
	}

}
