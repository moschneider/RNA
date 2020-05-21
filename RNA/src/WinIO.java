

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class WinIO {
	
	/**
	 * Rotinas gerais para facilitar a interação com janelas
	 */
	
	Dimension dim;
	
	public final int INT_INVALIDO = -9999;
	public final double DOUBLE_INVALIDO = -9999.99;
	
	/*
	 * Construtor
	 */
	
	public WinIO()
	{
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		dim = toolkit.getScreenSize();
	}
	
	public String selectFile(String texto, String dir)
	{
	    JFileChooser chooser = new JFileChooser(dir);
	   // FileNameExtensionFilter filter = new FileNameExtensionFilter(
	   //     "JPG & GIF Images", "jpg", "gif");
	   // chooser.setFileFilter(filter);
	    int returnVal = chooser.showDialog(chooser, texto);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       
	       return chooser.getSelectedFile().getPath();
	    }
	    
	    return "";
	}
	
	/*
	 * Pega a largura da tela
	 */
	
	public int getScreenWidth()
	{
		return dim.width;
	}
	
	/*
	 * Pega a altura da tela
	 */
	
	public int getScreenHeight()
	{
		return dim.height;
	}
	
	/*
	 * Mostra uma mensagem na tela
	 */

	public void message(String title, String text)
	{
	      JOptionPane.showMessageDialog(null, text,
                  title, JOptionPane.PLAIN_MESSAGE);
	}
	
	/*
	 * Mostra uma informacao na tela
	 */
	
	public void info(String text)
	{
	      JOptionPane.showMessageDialog(null, text,
                  "Informação", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/*
	 * Mostra um aviso na tela
	 */
	
	public void warning(String text)
	{
	      JOptionPane.showMessageDialog(null, text,
                  "Aviso", JOptionPane.WARNING_MESSAGE);
	}
	
	/*
	 * Mostra uma mensagem de erro na tela
	 */
	
	public void error(String text)
	{
	      JOptionPane.showMessageDialog(null, text,
                  "Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	/*
	 * Leh uma string
	 */
	
	public String readString(String text)
	{
		return JOptionPane.showInputDialog(text);
	}
	
	/*
	 * Leh a resposta a uma pergunta de "sim" ou "nao"
	 */
	
	public int yesNoQuestion(String text, String title)
	{
		Object[] options = {"Sim","Nao"};
		
		int n = JOptionPane.showOptionDialog(null,text,title, JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
		
		return n;
	}
	
	/*
	 * Leh a resposta a uma pergunta com opcoes
	 */
	
	public int openQuestion(String text, String title,Object[] options)
	{	
		int n = JOptionPane.showOptionDialog(null,text,title, JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
		
		return n;
	}
	
	/*
	 * Leh um numero inteiro (com tratamento de erros)
	 */
	
	public int readNumber(String text)
	{
		int flag=-1;
		String readText;
		
		readText = JOptionPane.showInputDialog(null,text,"Numero inteiro",JOptionPane.QUESTION_MESSAGE);
			
		try{
			flag = Integer.parseInt(readText);
		} catch (Exception exception) {
		
				error("Entrada invalida. Por favor digitar numero inteiro.");
				
				flag=INT_INVALIDO;
		}

		
		return flag;
	}
	
	/*
	 * Leh um numero real (com tratamento de erros)
	 */
	
	public double readDouble(String text)
	{
		double flag=-1.0;
		String readText;
		
		readText = JOptionPane.showInputDialog(null,text,"Numero real",JOptionPane.QUESTION_MESSAGE);
			
		try{
				flag = Double.parseDouble(readText);
			} catch (Exception expection) {
				
				flag=DOUBLE_INVALIDO;
				
				error("Entrada invalida. Por favor digitar um numero real (ex. 4.123)");
			}
		
		return flag;
	}
}
