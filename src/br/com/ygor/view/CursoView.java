package br.com.ygor.view;

import br.com.ygor.controller.CursoController;
import br.com.ygor.model.Curso;
import br.com.ygor.model.Escola;
import javax.swing.JOptionPane;


public class CursoView implements View, ViewCRUD{
    private int id;
    private String nome;
    private Escola escola;
    private CursoController controller;

    public CursoView(CursoController controller){
        this.controller = controller;
    }

    @Override
    public void openView() {
        int op;
        do {
            op = Integer.valueOf(JOptionPane.showInputDialog("Manter alunos \n"
                + "1. Cadastrar curso. \n"
                + "2. Editar curso. \n"
                + "3. Excluir curso. \n"
                + "4. Listar cursos. \n"
                + "5. Cancelar. \n"
                + "Informe a opção desejada:"));
        
            switch (op){
                
                case 1: insert(); break;

                case 2: update(); break;
                    
                case 3: delete(); break;
                    
                case 4: listAll(); break;
                    
                case 5: break;
                    
                default: JOptionPane.showMessageDialog(null, "Opção inválida!"); break;
                
            }
        } while (op != 5);

    }

    @Override
    public void closeView() {
        
    }
    
    @Override
    public void insert(){
        nome = JOptionPane.showInputDialog("Informe o nome:");
        
        String escolas = "";
        
        for(Escola e : controller.returnEscolas()){  
            escolas += e.getId() + " - " + e.getNome() + "\n";
        }
        
        escolas += "Informe o código da escola que deseja inserir:";
        
        int idEscola = Integer.valueOf(JOptionPane.showInputDialog(escolas));
        escola = controller.returnEscola(idEscola);
        
        controller.insert();                
    }
    
    @Override
    public void update(){
        id = selectOne();
        nome = JOptionPane.showInputDialog("Informe o nome:");
                
        String escolas = "";
        
        for(Escola e : controller.returnEscolas()){  
            escolas += e.getId() + " - " + e.getNome() + "\n";
        }
        
        escolas += "Informe o código da escola que deseja inserir:";
        
        int idEscola = Integer.valueOf(JOptionPane.showInputDialog(escolas));
        escola = controller.returnEscola(id);
        
        controller.update();        
    }
    
    @Override
    public void delete(){
        id = selectOne();
        controller.delete();
    }
    
    @Override
    public int selectOne(){
        String cursos = "";
                
        for(Curso c : controller.listAll()){  
            cursos += c.getId() + " - " + c.getNome() + "\n";
        }
        
        cursos += "Digite o código do registro que deseja fazer a operação:";
        
        int id = Integer.valueOf(JOptionPane.showInputDialog(cursos));        
        
        return id;
    }
    
    @Override
    public void listAll(){
        String cursos = "";
        
        for(Curso c : controller.listAll()){  
            cursos += c.getId() + " - " + c.getNome() + "\n";
        }
        
        JOptionPane.showMessageDialog(null, cursos);
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }
}
