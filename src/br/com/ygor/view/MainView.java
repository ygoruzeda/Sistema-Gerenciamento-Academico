package br.com.ygor.view;

import br.com.ygor.controller.AlunoController;
import javax.swing.JOptionPane;

public class MainView implements View{
    
    public static void main(String args[]){
        new MainView().openView();
    }

    @Override
    public void openView() {
        int op;
        do {
            op = Integer.valueOf(JOptionPane.showInputDialog("Menu \n"
                + "1. Funcionários. \n"
                + "2. Alunos. \n"
                + "3. Escolas. \n"
                + "4. Cursos. \n"
                + "5. Disciplinas. \n"
                + "6. Turmas. \n"
                + "7. Setor. \n"
                + "8. Sair. \n"
                + "Informe a opção desejada:"));
        
            switch (op){
                case 1:
                    JOptionPane.showMessageDialog(null, "Funcionários!");
                    break;

                case 2: 
                    AlunoController alunoController = new AlunoController();
                    alunoController.start();
                    break;
                    
                case 8:
                    JOptionPane.showMessageDialog(null, "Você saiu...");
                    break;

                default: 
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (op != 8);
    }

    @Override
    public void closeView() {
        
    }
}
