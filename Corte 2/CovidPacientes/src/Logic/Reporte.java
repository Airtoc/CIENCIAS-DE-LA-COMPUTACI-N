
package Logic;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Font;

public class Reporte extends JPanel {
	
	public Reporte( String texto) {
		setLayout(null);
		
		JTextPane txtInfo = new JTextPane();
		txtInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInfo.setBounds(10, 11, 412, 266);
		txtInfo.setOpaque(false);
                txtInfo.setText(texto);
		add(txtInfo);

	}
}