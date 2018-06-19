package br.com.ygor.view;

import br.com.ygor.controller.AlunoController;
import br.com.ygor.dao.CursoDao;
import br.com.ygor.model.Aluno;
import br.com.ygor.model.Curso;
import javax.swing.JOptionPane;

public class AlunoView implements View{
    private int id;
    private Curso curso;
    private String nome;
    private int matricula;
    private String endereco;
    private String telefone;
    private AlunoController controller;
    
    public AlunoView(AlunoController controller){
        this.controller = controller;
    }
    
    @Override
    public void openView() {
        int op;
        do {
            op = Integer.valueOf(JOptionPane.showInputDialog("Manter alunos \n"
                + "1. Cadastrar aluno. \n"
                + "2. Editar aluno. \n"
                + "3. Excluir aluno. \n"
                + "4. Listar alunos. \n"
                + "5. Cancelar. \n"
                + "Informe a opção desejada:"));
        
            switch (op){
                case 1:
                    insertAluno();
                    break;

                case 2: 
                    
                    break;
                    
                case 3: 
                    
                    break;
                    
                case 4: 
                    listAllAlunos();
                    break;
                    
                case 5: 
                    
                    break;

                default: 
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (op != 5);

    }

    @Override
    public void closeView() {
        
    }
    
    public void insertAluno(){
        nome = JOptionPane.showInputDialog("Informe o nome:");
        matricula = Integer.valueOf(JOptionPane.showInputDialog("Informe a matrícula:"));
        endereco = JOptionPane.showInputDialog("Informe o endereço:");
        telefone = JOptionPane.showInputDialog("Informe o telefone:");
        String cursos = "";
        
        for(Curso c : controller.returnCursos()){  
            cursos += c.getId() + " - " + c.getNome() + "\n";
        }
        
        cursos += "Informe o código do curso que deseja inserir:";
        
        int idCurso = Integer.valueOf(JOptionPane.showInputDialog(cursos));
        curso = controller.returnCurso(idCurso);
        
        controller.insert();                
    }
    
    public void listAllAlunos(){
        String alunos = "";
        
        for(Aluno a : controller.listAlunos()){  
            alunos += a.getId() + " - " + a.getNome() + "\n";
        }
        
        JOptionPane.showMessageDialog(null, alunos);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }  

}
