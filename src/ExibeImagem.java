import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

//import com.sun.xml.internal.ws.api.server.Container;

public class ExibeImagem extends JFrame {

	private File f;
	private BufferedImage imagem;
	private BufferedImage imagem2;

	public ExibeImagem(String caminho) throws IOException {
		f = new File(caminho);
		imagem2 = ImageIO.read(this.f);
		BufferedImage imagem = imagem2;

		String infoImagem = "Dimensões:" +imagem.getWidth()+
				"x"+imagem.getHeight()+" Bandas: "+
				imagem.getRaster().getNumBands();

		ImageIcon icone = new ImageIcon(imagem);
		JLabel labImagem = new JLabel(icone);
		Container contentPane = this.getContentPane();


		contentPane.add(new JScrollPane(labImagem), BorderLayout.CENTER);
		contentPane.add(new JLabel(infoImagem), BorderLayout.SOUTH);
		this.setTitle("Teste");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(imagem.getWidth(),imagem.getHeight());
		this.setVisible(true);
	

}

// Le a imagem de um repositorio especifico
public void LeImagem() throws IOException {
	imagem = ImageIO.read(this.f);
	int lar = imagem.getWidth();
	int alt = imagem.getHeight();

	System.out.println(lar + " "+ alt);
}

// Salva a imagem
public void WriteImage() throws IOException {
	File g = new File("c:\\teste\\Lenna2.jpg");
	ImageIO.write(imagem, "jpg", g);
}
}
