package br.com.ygor.view;

import br.com.ygor.controller.EscolaController;
import br.com.ygor.model.Escola;
import javax.swing.JOptionPane;

public class EscolaView implements View, ViewCRUD {
     private int id;
    private String nome;
    private EscolaController controller;

    public EscolaView(EscolaController controller){
        this.controller = controller;
    }

    @Override
    public void openView() {
        int op;
        do {
            op = Integer.valueOf(JOptionPane.showInputDialog("Manter escolas \n"
                + "1. Cadastrar escola. \n"
                + "2. Editar escola. \n"
                + "3. Excluir escola. \n"
                + "4. Listar escolas. \n"
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
        controller.insert();                
    }
    
    @Override
    public void update(){
        id = selectOne();
        nome = JOptionPane.showInputDialog("Informe o nome:");        
        controller.update();        
    }
    
    @Override
    public void delete(){
        id = selectOne();
        controller.delete();
    }
    
    @Override
    public int selectOne(){
        String escolas = "";
                
        for(Escola e : controller.listAll()){  
            escolas += e.getId() + " - " + e.getNome() + "\n";
        }
        
        escolas += "Digite o código do registro que deseja fazer a operação:";
        
        int id = Integer.valueOf(JOptionPane.showInputDialog(escolas));        
        
        return id;
    }
    
    @Override
    public void listAll(){
        String escolas = "";
        
        for(Escola e : controller.listAll()){  
            escolas += e.getId() + " - " + e.getNome() + "\n";
        }
        
        JOptionPane.showMessageDialog(null, escolas);
    }
    
    public void msgExclusionNotAllowed(){
        JOptionPane.showMessageDialog(null, "Essa escola está associada a um curso. Não é possível deletá-la.");
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

}
