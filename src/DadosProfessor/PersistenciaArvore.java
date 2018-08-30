package DadosProfessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import javax.swing.JOptionPane;

public class PersistenciaArvore {
        TreeSet<Professor> listaDados;

    public PersistenciaArvore() {

        try {
            //Leitura arquivo Professores.csv 
            FileReader arq = new FileReader("Professores.csv");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            TreeSet listaProf = new TreeSet<String>();
            while (linha != null) {
                listaProf.add(linha);
                linha = lerArq.readLine();
            }
            arq.close();

            //Leitura arquivo DadosGerais.csv 
            arq = new FileReader("DadosGerais.csv");
            lerArq = new BufferedReader(arq);
            linha = lerArq.readLine();
            TreeSet listaDet = new TreeSet<String>();
            while (linha != null) {
                listaDet.add(linha);
                linha = lerArq.readLine();
            }
            
            arq.close();

            listaDados = new TreeSet<Professor>();
            Iterator<String> itListaProf = listaProf.iterator();
            Iterator<String> itListaDet;
            
            while(itListaProf.hasNext()){
                itListaDet = listaDet.iterator();
                String aux = itListaProf.next();
                String[] auxS = aux.split(";");
                while(itListaDet.hasNext()){
                    String auxDet = itListaDet.next();
                    String[] auxDetS = auxDet.split(";");
                    if(auxS[0].equals(auxDetS[0])){
                        Professor atual = new Professor();
                        atual.setMatricula(auxS[0]);
                        atual.setNome(auxS[1]);
                        atual.setDepartamento(auxDetS[1]);
                        atual.setTitulacao(auxDetS[2]);
                        atual.setHorista(auxDetS[3]);
                        listaDados.add(atual);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel abrir o arquivo");
        }
    }
}
