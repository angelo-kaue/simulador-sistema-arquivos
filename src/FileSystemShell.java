import java.util.Scanner;

public class FileSystemShell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileOperations fileOps = new FileOperations();
        Journal journal = new Journal();

        System.out.println("=== Modo Shell: Simulador de Sistema de Arquivos ===");
        System.out.println("Digite 'help' para listar os comandos ou 'exit' para sair.\n");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] command = input.split(" ", 3); // comando, argumento1, argumento2...

            try {
                switch (command[0].toLowerCase()) {
                    case "help":
                        showHelp();
                        break;
                    case "copy":
                        fileOps.copyFile(command[1], command[2]);
                        journal.log("Copiado: " + command[1] + " para " + command[2]);
                        break;
                    case "delete":
                        fileOps.deleteFile(command[1]);
                        journal.log("Arquivo apagado: " + command[1]);
                        break;
                    case "rename":
                        fileOps.renameFile(command[1], command[2]);
                        journal.log("Renomeado: " + command[1] + " para " + command[2]);
                        break;
                    case "mkdir":
                        fileOps.createDirectory(command[1]);
                        journal.log("Diretório criado: " + command[1]);
                        break;
                    case "rmdir":
                        fileOps.deleteDirectory(command[1]);
                        journal.log("Diretório apagado: " + command[1]);
                        break;
                    case "list":
                        fileOps.listDirectoryContents(command[1]);
                        journal.log("Conteúdo listado: " + command[1]);
                        break;
                    case "exit":
                        System.out.println("Encerrando o simulador.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Comando desconhecido. Digite 'help' para ajuda.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Comando ou argumentos inválidos. Digite 'help' para ajuda.");
            }
        }
    }

    private static void showHelp() {
        System.out.println("\nComandos disponíveis:");
        System.out.println("help                - Mostra essa mensagem de ajuda.");
        System.out.println("copy <src> <dest>   - Copia arquivo de <src> para <dest>.");
        System.out.println("delete <file>       - Apaga o arquivo especificado.");
        System.out.println("rename <old> <new>  - Renomeia o arquivo ou diretório de <old> para <new>.");
        System.out.println("mkdir <dir>         - Cria um novo diretório em <dir>.");
        System.out.println("rmdir <dir>         - Apaga o diretório especificado.");
        System.out.println("list <dir>          - Lista o conteúdo do diretório especificado.");
        System.out.println("exit                - Encerra o simulador.\n");
    }
}
