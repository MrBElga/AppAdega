package appadega;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Adega {

    private int tot;

    private Vinho vinhos[][];

    public Adega() {
        vinhos = new Vinho[20][10];
        tot=0;
    }

    public boolean addVinho(int fila, int coluna, Vinho vinho) {
        if (posicaoValida(fila, coluna) && vinhos[fila][coluna]==null)
        {  vinhos[fila][coluna]=vinho;
           tot++;
           return true;
        }
        return false;
    }

    public boolean addVinho(Vinho vinho) {
        if (tot < vinhos.length * vinhos[0].length) {
            List<Posicao> posicoes = new ArrayList();
            for (int i = 0; i < vinhos.length; i++) 
                for (int j = 0; j < vinhos[i].length; j++) 
                    if (vinhos[i][j] == null) 
                        posicoes.add(new Posicao(i, j));
            Collections.shuffle(posicoes);
            Posicao primeira = posicoes.get(0);
            vinhos[primeira.getI()][primeira.getJ()] = vinho;
            tot++;
            return true;
        } else { return false; }
    }

    public int getVinhoTipo(String tipo) {
        int cont=0;
        for (int i = 0; i < vinhos.length; i++) {
            for (int j = 0; j < vinhos[i].length; j++) {
                if (vinhos[i][j]!=null)
                   if (vinhos[i][j].getTipo().equals(tipo.toUpperCase()))
                       cont++;
            }
        }
        return cont;
    }

    public int getVinhoCount() {
        return tot;
    }

    public double getValorAgregado() {
        double valor=0;
        for (int i = 0; i < vinhos.length; i++) {
            for (int j = 0; j < vinhos[i].length; j++) {
                if (vinhos[i][j]!=null)
                    valor+=vinhos[i][i].getValor();
            }
        }
        return valor;
    }

    public Vinho getVinhoMaisAntigo() {
        
        Vinho antigo=null;
        for (int i = 0; i < vinhos.length; i++) {
            for (int j = 0; j < vinhos[i].length; j++) {
                if (vinhos[i][j]!=null)
                    if(antigo==null)
                        antigo=vinhos[i][j];
                    else
                       if(vinhos[i][j].getTempoDias()>antigo.getTempoDias())
                          antigo=vinhos[i][j];
            }
        }
        return antigo;
    }

    public Vinho removeVinho(int fila, int coluna) {
        Vinho aux = null;
        if (posicaoValida(fila, coluna) && vinhos[fila][coluna] != null) {
            aux=vinhos[fila][coluna];
            vinhos[fila][coluna]=null;
        }
        return aux;
    }
    
    private boolean posicaoValida(int fila, int col)
    {
        return fila >= 0 && fila < vinhos.length && col >=0 && col < vinhos[0].length;
    }

    @Override
    public String toString() {
        String mapa="";
        for (int i = 0; i < vinhos.length; i++) {
            for (int j = 0; j < vinhos[i].length; j++) {
                mapa+=vinhos[i][j]==null?".":"X";
            }
            mapa+="\n";
        }
        return mapa;
    }
    

}
