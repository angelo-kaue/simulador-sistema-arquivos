import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileOperations {
    public void copyFile(String sourcePath, String destPath) {
        try {
            Files.copy(new File(sourcePath).toPath(), new File(destPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Arquivo copiado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao copiar arquivo: " + e.getMessage());
        }
    }

    public void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("Arquivo apagado com sucesso!");
        } else {
            System.err.println("Erro ao apagar arquivo.");
        }
    }

    public void renameFile(String oldName, String newName) {
        File file = new File(oldName);
        if (file.renameTo(new File(newName))) {
            System.out.println("Arquivo renomeado com sucesso!");
        } else {
            System.err.println("Erro ao renomear arquivo.");
        }
    }

    public void createDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (dir.mkdirs()) {
            System.out.println("Diretório criado com sucesso!");
        } else {
            System.err.println("Erro ao criar diretório.");
        }
    }

    public void deleteDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (dir.isDirectory() && dir.delete()) {
            System.out.println("Diretório apagado com sucesso!");
        } else {
            System.err.println("Erro ao apagar diretório.");
        }
    }

    public void renameDirectory(String oldName, String newName) {
        renameFile(oldName, newName); // Mesmo comportamento
    }

    public void listDirectoryContents(String dirPath) {
        File dir = new File(dirPath);
        if (dir.isDirectory()) {
            String[] contents = dir.list();
            if (contents != null) {
                for (String item : contents) {
                    System.out.println(item);
                }
            } else {
                System.out.println("O diretório está vazio.");
            }
        } else {
            System.err.println("Caminho inválido ou não é um diretório.");
        }
    }
}
